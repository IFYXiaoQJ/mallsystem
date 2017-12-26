package edu.mallsystem.service.impl;

import edu.mallsystem.bean.PageBean;
import edu.mallsystem.dao.IBaseDao;
import edu.mallsystem.entity.Product;
import edu.mallsystem.service.IProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 处理商品相关业务的实现类
 * Created by Administrator on 2017/12/24.
 */
@Service("productService")
@Transactional(propagation = Propagation.REQUIRED)
public class ProductServiceImpl implements IProductService {

    //声明Dao接口
    @Resource(name = "baseDao")
    private IBaseDao baseDao;

    /**
     * 新增
     * @param product
     * @return
     */
    @Override
    public boolean saveProduct(Product product) {
        return baseDao.saveObj(product);
    }

    /**
     * 下架
     * @param product
     * @return
     */
    @Override
    public boolean logoutProduct(Product product) {
        return false;
    }

    /**
     * 上架
     * @param product
     * @return
     */
    @Override
    public boolean restoreProduct(Product product) {
        return false;
    }

    /**
     * 删除
     * @param product
     * @return
     */
    @Override
    public boolean deleteProduct(Product product) {
        return false;
    }

    /**
     * 查询
     * @return
     */
    @Override
    public List findProductList() {
        return null;
    }

    /**
     * 分页带条件查询
     * @param pageBean
     * @param querys
     * @return
     */
    @Override
    public PageBean findProductList(PageBean pageBean, String[] querys) {
        //构建hql语句
        String hql = "FROM Product WHERE 1=1";
        hql += " ORDER BY createtime DESC";

        pageBean.setAllNum(baseDao.findObjList(hql).size());
        pageBean.setResult(baseDao.findObjList(hql,pageBean));
        return pageBean;
    }

    /**
     * 根据id查询
     * @param product
     * @return
     */
    @Override
    public Product getProductById(Product product) {
        return baseDao.getObjById(Product.class,product.getNo());
    }

    public void setBaseDao(IBaseDao baseDao) {
        this.baseDao = baseDao;
    }
}
