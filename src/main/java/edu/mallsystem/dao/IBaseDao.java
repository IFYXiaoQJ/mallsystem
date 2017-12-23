package edu.mallsystem.dao;

import edu.mallsystem.bean.PageBean;

import java.util.List;

/**
 * 基础Dao接口
 * @author Administrator
 *
 */
public interface IBaseDao {

	/**
	 * 新增
	 * @param obj
	 * @return
	 */
	boolean saveObj(Object obj);

	/**
	 * 新增返回对象
	 * @param obj
	 * @return
	 */
	Object saveObje(Object obj);

	/**
	 * 删除
	 * @param obj
	 * @return
	 */
	public boolean deleteObj(Object obj);

	/**
	 * 更新
	 * @param obj
	 * @return
	 */
	public boolean updateObj(Object obj);

	/**
	 * 查询列表
	 * @param hql
	 * @return
	 */
	public List findObjList(String hql);

	/**
	 * 分页查询列表
	 * @param hql
	 * @param pageBean
	 * @return
	 */
	public List findObjList(String hql,PageBean pageBean);

	/**
	 * 根据id查询(数值类型)
	 * @param clazz
	 * @param id
	 * @param <T>
	 * @return
	 */
	public <T> T getObjById(Class<T> clazz,int id);

	/**
	 * 根据id查询(uuid)
	 * @param clazz
	 * @param uuid
	 * @param <T>
	 * @return
	 */
	public <T> T getObjById(Class<T> clazz,String uuid);
}
