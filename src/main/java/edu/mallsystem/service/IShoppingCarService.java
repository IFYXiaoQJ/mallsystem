package edu.mallsystem.service;

import edu.mallsystem.entity.Product;
import edu.mallsystem.entity.ShoppingCar;
import edu.mallsystem.entity.User;

/**
 * Created by Administrator on 2017/12/25.
 */
public interface IShoppingCarService {

    boolean saveShoppingCar(User user,Product product,int total);

    boolean updateShoppingCar(ShoppingCar shoppingCar);

}
