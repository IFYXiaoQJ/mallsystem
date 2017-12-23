package test;

import edu.mallsystem.dao.IBaseDao;
import edu.mallsystem.dao.impl.BaseDaoImpl;
import edu.mallsystem.entity.User;

/**
 * Created by Administrator on 2017/12/21.
 */
public class BaseDaoTest {

    public static void main(String[] args) {
        User user = new User();
        user.setName("test001");
        user.setPassword("aa123123");

        IBaseDao baseDao = new BaseDaoImpl();
        user = (User) baseDao.saveObje(user);
    }

}
