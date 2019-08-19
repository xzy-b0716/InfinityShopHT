package com.xzy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author wangxiaoliang
 * @date 2019/8/5 - 21:27
 */
@Component
public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016100100639525";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCzs9EB/"
            + "PCcChF65naqzVqKj03Kk4N9Hw5bR8ieDTBPvIkeIMLbPixYIvLFnWRExNwVlrCTEV4DVcf5CPMe1ntUibFLN00J38Y6"
            + "IKKJFjKgkteEWBPTHTvsn5PFBqkJtXfotzm5C7K2zYmMS5/7dR+fiOryDLDqQbwctY4uWaa5HmTMGAkNr1cC3E0FayaX"
            + "3Om+NyZHAQiNP69jXXc/zkuXQerXzK6i+ukyJwMP3aL7uGjc9nTPbuoJ6iTbU6sRvO3KeCm5fjiAQ5wTlo5hRgXKxM/l"
            + "5bUr3LQzHdHA5X1r9NLPF1Xw4yGbNzy8HXlilcR1/1SjPzLNiWdFL8fiz8ZFAgMBAAECggEAd0TMXr5rT5VbHq/haOGcy"
            + "0PrhJ09cwjutWTCYSwtuW5Pr2BdE7iDJAgmC0S4LPBfhjCahzHKrPn9HGt1OS1vc59jvaE5j2knHqNUXRoPhgWP5vWySrc"
            + "nc5hCMk2GWbxIlnstY4TBG5T1StlSmEmXMIJmNTp5HTF90awqbtbv0gKedIZFsNvBoRV5RsFxVYC/vaoc7HEnQQK0tv3Bi"
            + "L7NX/ijLXiLwlcTfjtw5naMxmmrRmyymE26lH1QIRiIz7+Hiwg134g43xdscdl24l232RfGl/BAKkhEzolGfRiHs7m0UEnp"
            + "QPtaLDK8MoBhn1DDDD5ZhkUx3jy9MCBmQtu/AQKBgQDZeNZUXr3/7eDuw5kcFzkdvfwIP7nxawh8utY9YePuddZSywR66Sb"
            + "HUr2jZ6G17TmjDyJF7Hef0BQaIjM9WYYM/OgeraeJqfTkkoPgPPutAh9IRd5WyE1Qj+aMXRgLuJiKCBBfXeS508viM1inv"
            + "RCmZLj5tdLmYVwyxMogPToxwQKBgQDTify4lCrJCYi5HxYMCfcBDlDRxenNOprvP3zSxi1sC69pSIzwod0vZUtl8YLnPfP"
            + "1wJk17/cOIlGD6Ie5k16OZDPakziq6+TE+XLqPr93XaIoxVHrVLJfM3lY1U84RM44gpPzv/MCncxC6JqzqvS1p0f7HsY4wbZ"
            + "bf9onxBUthQKBgEnaL28XfY6cSfbLlgNkH5FqI1zpx0uk/YzeJkNSKwWgHtie+TaEVxb5kk0btF8D4L7vNMRqOXWcRDdbxerfrB"
            + "ZdDLbeYjbt8Kxu1Tohe5aVUepJT+hIvXjOZYzlUHUqiyLU+jpouHQi6Oo4ZbMREcZwDiE/DhAOoDDdg4bPRCQBAoGBAIY2Ce1htD"
            + "OQpPouyuIggGJfHs+47bmT8TDR6vQfYDoov8XgjesuBxNHBStMq2zjVaEZ7RrXgLuq8mTqZxJKebeFw5Btz4pB2AdQ7KPJ49hrw"
            + "7JyXqMcPX9BPUArNfPRU7Vuw0fnBNsoGqxov542XMPTukuNHt5rqLMsztBkC7uxAoGAT/a3K/FF2xUKzt+il1zuJuix6ZfiILsDA"
            + "6VYYZasXmGz3frgyOaks9AxmA2VoReX9TCXFyD3A3evVjSqdM31BeF++Ivqj+ss4dJaN50OxItbhxhKzPZJl7+78tw8Uom4xH6ccA"
            + "aLJLGimcY3h6muylxX/LmKVtBwGbsaOPmnbe8=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwQ2pwXO1GMt4JVcP4SBl5poJv"
            + "pTnVXMp1iDSQsfH70XSlE4Qa21iUWonsEUBKHsncyHSk4NfxyWV/XCSIYAWKPcWZqtTYPlMfjgkCDsXHrbc8p8E/Nxwd+QSHY/uU7"
            + "Yu9oSPnanMAybuMYn7MzRCDYXVhBTeiF/JBTIP3XV+SEjNVRqjOEKkVifGEFxHb6OsdJDGJ6RTn51+E3AivJmIpI8DqgyPtPYXMFzk"
            + "Xr+d83r6S24q6FAjyJEGxL4YArhcGvudPQZoy1iHn052AhC647Sl11IOc3j0NzeKSMRe04CmFQUJwk6i3YsuAeW3h57pB//6Na0Xrb"
            + "SnmyG5NgS9YQIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/orderHandle/notifyUrl";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/orderHandle/returnUrl";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "E:\\ldt\\logger";

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
<<<<<<< HEAD
<<<<<<< HEAD
     *
=======
>>>>>>> 7aff539f7f1ca78abf9864906015322561dcf54a
=======
>>>>>>> fdbeba15f33092c6a46ea962c57dad262aad3aca
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
