package edu.mallsystem.service;

import edu.mallsystem.bean.PageBean;
import edu.mallsystem.entity.Product;
import edu.mallsystem.entity.ShoppingCar;
import edu.mallsystem.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/12/25.
 */
public interface IShoppingCarService {

    boolean saveShoppingCar(User user,Product product,int total);

    boolean updateShoppingCar(ShoppingCar shoppingCar);

    List findShoppingCarList();

    PageBean findShoppingCarList(PageBean pageBean,String[] querys);

    PageBean findUserShoppingCarList(PageBean pageBean,String userNo);

    boolean deleteShoppingCar(ShoppingCar shoppingCar);

    boolean deleteShoppingCar(String[] selects);

    ShoppingCar getShoppingCarById(String uuid);
}
