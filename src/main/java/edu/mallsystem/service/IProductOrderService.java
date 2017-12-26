package edu.mallsystem.service;

import edu.mallsystem.bean.PageBean;
import edu.mallsystem.entity.ProductOrder;
import edu.mallsystem.entity.ShoppingCar;
import edu.mallsystem.entity.User;

import java.util.List;

/**
 * 定义商品订单相关业务的接口
 * Created by Administrator on 2017/12/26.
 */
public interface IProductOrderService {

    boolean haveEnoughMoney(double userMoney,double price);

    ProductOrder saveProductOrder(ProductOrder productOrder, User user);

    List<ProductOrder> saveProductOrder(ShoppingCar shoppingCar,User user);

    List findProductOrder();

    PageBean findProductOrder(PageBean pageBean,String[] querys);

}
