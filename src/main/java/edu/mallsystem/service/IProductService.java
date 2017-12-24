package edu.mallsystem.service;

import edu.mallsystem.bean.PageBean;
import edu.mallsystem.entity.Product;

import java.util.List;

/**
 * 定义商品相关业务的接口
 * Created by Administrator on 2017/12/24.
 */
public interface IProductService {

    boolean saveProduct(Product product);

    boolean logoutProduct(Product product);

    boolean restoreProduct(Product product);

    boolean deleteProduct(Product product);

    List findProductList();

    List findProductList(PageBean pageBean,String[] querys);

    Product getProductById(Product product);

}
