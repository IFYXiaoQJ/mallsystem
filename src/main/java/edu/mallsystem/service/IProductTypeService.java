package edu.mallsystem.service;

import edu.mallsystem.bean.PageBean;
import edu.mallsystem.entity.ProductType;

import java.util.List;

/**
 * 定义商品类型的服务接口
 * Created by Administrator on 2017/12/23.
 */
public interface IProductTypeService {

    boolean saveProductType(ProductType productType);

    boolean deleteProductType(ProductType productType);

    boolean updateProductType(ProductType productType);

    List findProductTypeList();

    PageBean findProductTypeList(PageBean pageBean,String[] querys);

    ProductType getProductTypeById(ProductType productType);

    boolean deleteProductType(String[] selects);

}
