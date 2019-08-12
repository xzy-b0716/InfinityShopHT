package com.xzy.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.xzy.beans.Orderitem;
import com.xzy.config.AlipayConfig;
import com.xzy.service.serviceImp.OrderItemServiceImp;
import com.xzy.service.serviceImp.OrdersServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.*;

@RestController
@RequestMapping("/orderHandle")
public class OrderHandleController {
    @Autowired
    private OrdersServiceImp os;
    @Autowired
    private OrderItemServiceImp ois;
    @Autowired
    private ProductServiceImp ps;

    /*
    增（完成）
    ---增加订单时删商品库存
    1、单点生成订单及订单项
    ---价格等于商品价格*数量，
    2、通过购物车生成订单及订单
    ---总价格是前端算好传过来
     */
    //单点生成订单及订单项
    @RequestMapping("/createOrdersOrderitem01")
    public String createOrdersOrderitem01(int userId, int productId, int addressId, int num,
                                          String oiProductSize, String oiProductColor) {
        int ordersId = os.addOrderBy01(userId, addressId, productId, num);
        int i = ois.addOrderItemBy01(productId, num, ordersId, oiProductSize, oiProductColor);
        if (i == 1) {
            return "单点生成订单成功";
        } else {
            return "单点生成订单失败";
        }
    }

    //通过购物车生成订单及订单
    @RequestMapping("/createOrdersOrderitem02")
    public String createOrdersOrderitem02(int userId, int addressId, float ordersTotalPrice) {
        int ordersId = os.addOrderBy02(userId, addressId, ordersTotalPrice);
        int i = ois.addOrderItemBy02(userId, ordersId);
        return "通过购物车生成订单成功";
    }

    //通过秒杀生成订单及订单
    @RequestMapping("/createOrdersOrderitem03")
    public String createOrdersOrderitem03(int userId, int addressId, int productId, String oiProductSize, String oiProductColor) {
        int orderId = os.addOrderBy03(userId, addressId, productId);
        int i = ois.addOrderItemBy03(orderId, productId, oiProductSize, oiProductColor);
        if (i == 1) {
            return "通过秒杀生成订单成功";
        } else {
            return "通过秒杀生成订单失败";
        }
    }

    /*
    删（完成）
     */
    //删除订单及订单项
    @RequestMapping("/deleteOrdersOrderitem")
    public String deleteOrdersOrderitem(int ordersId) {
        os.deleteOrders(ordersId);
        ois.deleteOrderitem(ordersId);
        return "删除订单及订单项成功";
    }

    /*
    改（完成）
    ---修改订单各个状态
    1、支付状态，默认是0，未支付
    2、发货状态，默认是0，未发货，修改时添加发货时间
    3、收货状态，默认是0，未收货，修改时添加收货时间
    ---发货时必须是已支付状态
    ---收货时必须是已发货状态
     */
    //修改支付状态
    @RequestMapping("/updatePayStatus")
    public String updatePayStatus(int ordersId) {
        int payStatus = os.updatePayStatus(ordersId);
        return "修改支付状态成功";
    }

    //修改发货状态、添加发货时间
    @RequestMapping("/updateSend")
    public String updateSend(int ordersId) {
        int i = os.updateSend(ordersId);
        if (i == 1) {
            return "修改发货状态、添加发货时间成功";
        } else {
            return "修改发货状态、添加发货时间失败";
        }
    }

    //修改收货状态、添加收货时间
    @RequestMapping("/updateGet")
    public String updateGet(int ordersId) {
        int i = os.updateGet(ordersId);
        if (i == 1) {
            return "修改收货状态、添加收货时间成功";
        } else {
            return "修改发货状态、添加收货时间失败";
        }
    }

    /*
    查（完成）
    1、查询全部订单
    2、查询待支付订单
    3、查询待发货订单
    4、查询待收货订单
     */
    //订单详情页面（全部状态）
    @RequestMapping("/findAllOrderItem")
    public List<Orderitem> findAllOrderItem() {
        List<Orderitem> allOrderitems = new ArrayList<Orderitem>();
        List<Integer> allOrdId = os.findAllOrdId();
        Iterator<Integer> allOrdIds = allOrdId.iterator();
        while (allOrdIds.hasNext()) {
            Integer orderId = allOrdIds.next();
            List<Orderitem> allOrderitem = ois.findAllOIByOrdId(orderId);
            Iterator<Orderitem> iterator = allOrderitem.iterator();
            while (iterator.hasNext()) {
                allOrderitems.add(iterator.next());
            }
        }
        return allOrderitems;
    }

    //待支付订单
    @RequestMapping("/findPayOrderItem")
    public List<Orderitem> findPayOrderItem() {
        List<Orderitem> allOrderitems = new ArrayList<Orderitem>();
        List<Integer> payOrdId = os.findPay();
        Iterator<Integer> allOrdIds = payOrdId.iterator();
        while (allOrdIds.hasNext()) {
            Integer orderId = allOrdIds.next();
            List<Orderitem> allOrderitem = ois.findAllOIByOrdId(orderId);
            Iterator<Orderitem> iterator = allOrderitem.iterator();
            while (iterator.hasNext()) {
                allOrderitems.add(iterator.next());
            }
        }
        return allOrderitems;
    }

    //待发货订单
    @RequestMapping("/findSendOrderItem")
    public List<Orderitem> findSendOrderItem() {
        List<Orderitem> allOrderitems = new ArrayList<Orderitem>();
        List<Integer> sendOrdId = os.findSend();
        Iterator<Integer> allOrdIds = sendOrdId.iterator();
        while (allOrdIds.hasNext()) {
            Integer orderId = allOrdIds.next();
            List<Orderitem> allOrderitem = ois.findAllOIByOrdId(orderId);
            Iterator<Orderitem> iterator = allOrderitem.iterator();
            while (iterator.hasNext()) {
                allOrderitems.add(iterator.next());
            }
        }
        return allOrderitems;
    }

    //待收货订单
    @RequestMapping("/findGetOrderItem")
    public List<Orderitem> findGetOrderItem() {
        List<Orderitem> allOrderitems = new ArrayList<Orderitem>();
        List<Integer> getOrdId = os.findGet();
        Iterator<Integer> allOrdIds = getOrdId.iterator();
        while (allOrdIds.hasNext()) {
            Integer orderId = allOrdIds.next();
            List<Orderitem> allOrderitem = ois.findAllOIByOrdId(orderId);
            Iterator<Orderitem> iterator = allOrderitem.iterator();
            while (iterator.hasNext()) {
                allOrderitems.add(iterator.next());
            }
        }
        return allOrderitems;
    }

    @RequestMapping("/alipayIumpSum")
    public String alipayIumpSum(Model model, HttpServletResponse response, HttpServletRequest request) throws AlipayApiException, UnsupportedEncodingException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        //String out_trade_no =
        String out_trade_no = new String(request.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"), "UTF-8");
        //付款金额，必填
        String total_amount = new String(request.getParameter("WIDtotal_amount").getBytes("ISO-8859-1"), "UTF-8");
        //订单名称，必填
        String subject = new String(request.getParameter("WIDsubject").getBytes("ISO-8859-1"), "UTF-8");
        //商品描述，可空
        String body = new String(request.getParameter("WIDbody").getBytes("ISO-8859-1"), "UTF-8");

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        //输出
        //System.out.println(result);
        return result;
    }

    @PostMapping("/notifyUrl")
    public String notifyUrl(HttpServletResponse response, HttpServletRequest request) throws AlipayApiException, UnsupportedEncodingException {
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        //调用SDK验证签名
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
        //处理业务逻辑
        /* 实际验证过程建议商户务必添加以下校验：
	    1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
	    2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
	    3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
	    4、验证app_id是否为该商户本身。
	    */
        if (signVerified) {//商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            //交易状态
            String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");
            if (trade_status.equals("TRADE_FINISHED")) {
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序

                //注意：
                //退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
            } else if (trade_status.equals("TRADE_SUCCESS")) {
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序

                //注意：
                //付款完成后，支付宝系统发送该交易状态通知
            }
            return "success";
        } else {//验证失败
            return "fail";
        }
    }

    @GetMapping("/returnUrl")
    private String returnUrl(HttpServletRequest request)
            throws AlipayApiException, UnsupportedEncodingException {
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名

        //——请在这里编写您的程序（以下代码仅作参考）——
        if (signVerified) {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            return "trade_no:" + trade_no + "<br/>out_trade_no:" + out_trade_no + "<br/>total_amount:" + total_amount;
        } else {
            return "验签失败";
        }
    }
}
