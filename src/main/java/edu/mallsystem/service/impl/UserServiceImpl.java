package edu.mallsystem.service.impl;

import edu.mallsystem.dao.IBaseDao;
import edu.mallsystem.dao.IUserDao;
import edu.mallsystem.entity.User;
import edu.mallsystem.entity.UserInfo;
import edu.mallsystem.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 处理用户相关业务的实现类
 * Created by Administrator on 2017/12/21.
 */
@Service("userService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements IUserService {

    //声明dao层接口
    @Resource(name = "baseDao")
    private IBaseDao baseDao;
    @Resource(name = "userDao")
    private IUserDao userDao;

    /**
     * 新增用户
     * @param user
     * @return
     */
    @Override
    public boolean saveUser(User user) {
        if(checkUser(user.getName())){
            return false;
        }

        return baseDao.saveObj(user);
    }

    /**
     * 新增用户返回用户
     * @param user
     * @return
     */
    @Override
    public User saveUserReturn(User user) {
        return null;
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @Override
    public User doLogin(User user) {
        //构建hql语句
        String hql = "FROM User WHERE name='"+user.getName()+"' AND status=1";
        //查询
        List<User> list = baseDao.findObjList(hql);

        if(list!=null&&list.size()>0){
            //遍历集合
            for (User u : list) {
                if(u.getName().equals(user.getName())&&u.getPassword().equals(user.getPassword())){
                    return u;
                }
            }
        }
        return null;
    }

    /**
     * 查询用户详细信息
     * @param uuid
     * @return
     */
    @Override
    public UserInfo findUserInfo(String uuid) {
        //构建hql语句
        String hql = "FROM UserInfo WHERE user.no='"+uuid+"'";
        List<UserInfo> list = baseDao.findObjList(hql);
        UserInfo userInfo = null;
        if(list!=null&&list.size()>0){
           userInfo = list.get(0);
        }
        return userInfo;
    }

    /**
     * 更新用户详细信息
     * @param userInfo
     * @return
     */
    @Override
    public boolean updateUserInfo(UserInfo userInfo) {
        return baseDao.updateObj(userInfo);
    }

    /**
     * 校验用户是否已经存在
     * @param name
     * @return
     */
    public boolean checkUser(String name){
        //构建hql语句
        String hql = "FROM User WHERE name='"+name+"'";
        List<User> list = baseDao.findObjList(hql);

        if(list!=null&&list.size()>0){
            //说明存在用户
            return true;
        }
        return false;
    }


    public void setBaseDao(IBaseDao baseDao) {
        this.baseDao = baseDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
}
