package edu.mallsystem.dao.impl;

import edu.mallsystem.bean.PageBean;
import edu.mallsystem.dao.IBaseDao;
import edu.mallsystem.factory.HbnSessionFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/12/21.
 */
@Repository("baseDao")
public class BaseDaoImpl extends HbnSessionFactory implements IBaseDao {

    /**
     * 新增
     * @param obj
     * @return
     */
    @Override
    public boolean saveObj(Object obj) {
        try {
            getSession().save(obj);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 新增返回对象
     * @param  obj
     * @return
     */
    @Override
    public Object saveObje(Object obj) {
       try {
            getSession().save(obj);
            return obj;
       } catch (Exception e){
           e.printStackTrace();
       }
       return null;
    }

    //删除
    @Override
    public boolean deleteObj(Object obj) {
        try {
            getSession().delete(obj);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    //更新
    @Override
    public boolean updateObj(Object obj) {
        try {
            getSession().update(obj);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    //查询
    @Override
    public List findObjList(String hql) {
        return getSession().createQuery(hql).list();
    }

    //分页查询
    @Override
    public List findObjList(String hql, PageBean pageBean) {
        Query query = getSession().createQuery(hql);
        query.setFirstResult((pageBean.getCpage()-1)*pageBean.getShowNum());
        query.setMaxResults(pageBean.getShowNum());
        return query.list();
    }

    //根据id查询(数值id)
    @Override
    public <T> T getObjById(Class<T> clazz, int id) {
        return null;
    }

    //根据id查询(uuid)
    @Override
    public <T> T getObjById(Class<T> clazz, String uuid) {
        System.out.println(clazz);
        try {
            return (T) getSession().get(clazz,uuid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
