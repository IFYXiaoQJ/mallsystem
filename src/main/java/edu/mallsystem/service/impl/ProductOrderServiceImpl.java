package edu.mallsystem.service.impl;

import edu.mallsystem.bean.PageBean;
import edu.mallsystem.dao.IBaseDao;
import edu.mallsystem.entity.ProductOrder;
import edu.mallsystem.entity.ShoppingCar;
import edu.mallsystem.entity.User;
import edu.mallsystem.service.IProductOrderService;
import edu.mallsystem.util.DateSequenceCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/12/26.
 */
@Service("productOrderService")
@Transactional(propagation = Propagation.REQUIRED)
public class ProductOrderServiceImpl implements IProductOrderService {

    //声明Dao层接口
    @Resource(name = "baseDao")
    private IBaseDao baseDao;

    /**
     * 判断是否够钱
     * @param userMoney
     * @param price
     * @return
     */
    @Override
    public boolean haveEnoughMoney(double userMoney, double price) {
        if(userMoney<price){
            System.out.println("----用户不够钱----");
            return false;
        }
        System.out.println("----用户够钱----");
        return true;
    }

    @Override
    public ProductOrder saveProductOrder(ProductOrder productOrder, User user) {
        if(!haveEnoughMoney(user.getMoney(),productOrder.getPrice())){
            System.out.println("----购买失败----");
            return null;
        }
        productOrder.setUser(user);
        productOrder.setOrdernum(DateSequenceCode.getTimeSequence());
        return (ProductOrder) baseDao.saveObje(productOrder);
    }

    @Override
    public List<ProductOrder> saveProductOrder(ShoppingCar shoppingCar, User user) {
        return null;
    }

    @Override
    public List findProductOrder() {
        return null;
    }

    @Override
    public PageBean findProductOrder(PageBean pageBean, String[] querys) {
        return null;
    }

    public void setBaseDao(IBaseDao baseDao) {
        this.baseDao = baseDao;
    }
}
