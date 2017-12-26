package edu.mallsystem.service.impl;

import edu.mallsystem.bean.PageBean;
import edu.mallsystem.dao.IBaseDao;
import edu.mallsystem.entity.ProductType;
import edu.mallsystem.service.IProductTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 处理商品类型相关业务的实现类
 * Created by Administrator on 2017/12/23.
 */
@Service("productTypeService")
@Transactional(propagation = Propagation.REQUIRED)
public class ProductTypeServiceImpl implements IProductTypeService {

    //声明Dao层接口
    @Resource(name = "baseDao")
    private IBaseDao baseDao;

    /**
     * 新增
     * @param productType
     * @return
     */
    @Override
    public boolean saveProductType(ProductType productType) {
        return baseDao.saveObj(productType);
    }

    /**
     * 删除
     * @param productType
     * @return
     */
    @Override
    public boolean deleteProductType(ProductType productType) {
        return baseDao.deleteObj(productType);
    }

    /**
     * 更新
     * @param productType
     * @return
     */
    @Override
    public boolean updateProductType(ProductType productType) {
        return baseDao.updateObj(productType);
    }

    /**
     * 查询
     * @return
     */
    @Override
    public List findProductTypeList() {
        //构建hql语句
        String hql = "FROM ProductType";
        return baseDao.findObjList(hql);
    }

    /**
     * 分页带条件查询
     * @param pageBean
     * @param querys
     * @return
     */
    @Override
    public PageBean findProductTypeList(PageBean pageBean, String[] querys) {
        //构建hql语句
        String hql = "FROM ProductType WHERE 1=1";
        //判断是否有条件
        if(querys!=null&&querys.length>0){
            if(querys[0]!=null&&querys[0].length()>0){
                hql += " AND name LIKE '%"+querys[0]+"%'";
            }
            if(querys[1]!=null&&querys[1].length()>0){
                hql += " AND TO_CHAR(createtime,yyyy-MM-dd)>='"+querys[1]+"' ";
            }
            if(querys[2]!=null&&querys[2].length()>0){
                hql += " AND TO_CHAR(createtime,yyyy-MM-dd)<='"+querys[2]+"' ";
            }
        }
        hql += " ORDER BY createtime DESC";

        pageBean.setAllNum(baseDao.findObjList(hql).size());
        pageBean.setResult(baseDao.findObjList(hql,pageBean));
        return pageBean;
    }

    /**
     * 根据id查询
     * @param productType
     * @return
     */
    @Override
    public ProductType getProductTypeById(ProductType productType) {
        return baseDao.getObjById(ProductType.class,productType.getNo());
    }

    /**
     * 批量删除
     * @param selects
     * @return
     */
    @Override
    public boolean deleteProductType(String[] selects) {
        ProductType productType = null;
        for(int i=0; i<selects.length; i++){
            productType = new ProductType();
            productType.setNo(selects[i]);
            if(!baseDao.deleteObj(productType)){
                return false;
            }
        }
        return true;
    }

    public void setBaseDao(IBaseDao baseDao) {
        this.baseDao = baseDao;
    }
}
