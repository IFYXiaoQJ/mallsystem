package edu.mallsystem.service.impl;

import edu.mallsystem.bean.PageBean;
import edu.mallsystem.dao.IBaseDao;
import edu.mallsystem.entity.Product;
import edu.mallsystem.entity.ShoppingCar;
import edu.mallsystem.entity.User;
import edu.mallsystem.service.IShoppingCarService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/12/25.
 */
@Service("shoppingCarService")
@Transactional(propagation = Propagation.REQUIRED)
public class ShoppingCarServiceImpl implements IShoppingCarService {

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
        String hql = "FROM ShoppingCar s WHERE s.user.no='"+user.getNo()+"' AND s.product.no='"+product.getNo()+"'";
        List<ShoppingCar> list = baseDao.findObjList(hql);
        ShoppingCar shoppingCar = null;
        if(list!=null&&list.size()>0){
            //如果已存在,则更新购物车信息
            shoppingCar = list.get(0);
            shoppingCar.setTotal(shoppingCar.getTotal()+total);
            shoppingCar.setPrice(total*product.getPrice()+shoppingCar.getPrice());
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

    /**
     * 查询
     * @return
     */
    @Override
    public List findShoppingCarList() {
        return null;
    }

    /**
     * 分页带条件查询所有
     * @param pageBean
     * @param querys
     * @return
     */
    @Override
    public PageBean findShoppingCarList(PageBean pageBean, String[] querys) {
        return null;
    }

    /**
     * 分页带条件查询个人用户
     * @param pageBean
     * @param userNo
     * @return
     */
    @Override
    public PageBean findUserShoppingCarList(PageBean pageBean, String userNo) {
        //构建hql语句
        String hql = "FROM ShoppingCar WHERE 1=1 AND user.no='"+userNo+"'";
        pageBean.setAllNum(baseDao.findObjList(hql).size());
        pageBean.setResult(baseDao.findObjList(hql,pageBean));
        return pageBean;
    }

    /**
     * 删除单个购物车
     * @param shoppingCar
     * @return
     */
    @Override
    public boolean deleteShoppingCar(ShoppingCar shoppingCar) {
        return baseDao.deleteObj(shoppingCar);
    }

    /**
     * 删除多个购物车
     * @param selects
     * @return
     */
    @Override
    public boolean deleteShoppingCar(String[] selects) {
        ShoppingCar shoppingCar = null;
        for (String no : selects) {
            shoppingCar = new ShoppingCar();
            shoppingCar.setNo(no);
            if(!deleteShoppingCar(shoppingCar)){
                return false;
            }
        }
        return true;
    }

    /**
     * 根据id查询
     * @param uuid
     * @return
     */
    @Override
    public ShoppingCar getShoppingCarById(String uuid) {
        return baseDao.getObjById(ShoppingCar.class,uuid);
    }

    public void setBaseDao(IBaseDao baseDao) {
        this.baseDao = baseDao;
    }
}
