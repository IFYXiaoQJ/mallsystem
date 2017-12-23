package edu.mallsystem.dao.impl;

import edu.mallsystem.dao.IUserDao;
import edu.mallsystem.entity.User;
import edu.mallsystem.factory.HbnSessionFactory;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/12/22.
 */
@Repository("userDao")
public class UserDaoImpl extends HbnSessionFactory implements IUserDao {

    /**
     * 新增用户返回用户
     * @param user
     * @return
     */
    @Override
    public User saveUser(User user) {
        try {
            String no = (String) getSession().save(user);
            user.setNo(no);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
