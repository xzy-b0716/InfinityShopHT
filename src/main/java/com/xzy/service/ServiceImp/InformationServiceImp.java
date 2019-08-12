package com.xzy.service.serviceImp;

import com.xzy.beans.*;
import com.xzy.mapper.ProductMapper;
import com.xzy.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Create by Shuai on 2019/8/12 21:51
 */
@Service
public class InformationServiceImp implements InformationService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public Information selectInformation(Integer productId) {
        Product product =productMapper.selectByPrimaryKey(productId);
        Information information = new Information();
//       品牌
        String bdesc =product.getProductBrand();
        ProductBrand productBrand=new ProductBrand();
        productBrand.setDescribe(bdesc);
        information.setProductBrand(productBrand);
        System.out.println(information);
//      材质
        String mdesc =product.getProductMaterial();
        ProductMaterial productMaterial=new ProductMaterial();
        productMaterial.setDescribe(mdesc);
        information.setProductMaterial(productMaterial);
//      厚薄
        String tdesc =product.getProductThickness();
        ProductThickness productThickness=new ProductThickness();
        productThickness.setDescribe(tdesc);
        information.setProductThickness(productThickness);
//      风格
        String sdesc =product.getProductStyle();
        ProductStyle productStyle=new ProductStyle();
        productStyle.setDescribe(sdesc);
        information.setProductStyle(productStyle);
//      版型
        String vdesc =product.getProductVersion();
        ProductVersion productVersion=new ProductVersion();
        productVersion.setDescribe(vdesc);
        information.setProductVersion(productVersion);

        return information;
    }
}
