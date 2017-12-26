package edu.mallsystem.service.impl;

import edu.mallsystem.dao.IBaseDao;
import edu.mallsystem.entity.Product;
import edu.mallsystem.entity.ShoppingCar;
import edu.mallsystem.entity.User;
import edu.mallsystem.service.IShoppingCarService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/12/25.
 */
public class ShoppingCarImpl implements IShoppingCarService {

    //声明Dao层接口
    @Resource(name = "baseDao")
    private IBaseDao baseDao;

    /**
     * 添加商品到购物车
     * @param product
     * @return
     */
    @Override
    public boolean saveShoppingCar(User user, Product product,int total) {
        //1,先查询用户是否已经在购物车存放该商品
        String hql = "FROM ShoppingCar WHERE user.no='"+user.getNo()+"' AND product.no='"+product.getNo()+"'";
        List<ShoppingCar> list = baseDao.findObjList(hql);
        ShoppingCar shoppingCar = null;
        if(list!=null&&list.size()>0){
            //如果已存在,则更新,添加数量
            shoppingCar = list.get(0);
            return updateShoppingCar(shoppingCar);
        }else{
            //设置订单信息
            shoppingCar = new ShoppingCar();
            shoppingCar.setUser(user);
            shoppingCar.setProduct(product);
            shoppingCar.setTotal(total);
            shoppingCar.setPrice(total*product.getPrice());

        }
        //执行添加
        return baseDao.saveObj(shoppingCar);
    }

    /**
     * 更新购物车
     * @param shoppingCar
     * @return
     */
    @Override
    public boolean updateShoppingCar(ShoppingCar shoppingCar) {
        return baseDao.updateObj(shoppingCar);
    }

    public void setBaseDao(IBaseDao baseDao) {
        this.baseDao = baseDao;
    }
}
