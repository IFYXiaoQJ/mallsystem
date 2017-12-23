package edu.mallsystem.service;

import edu.mallsystem.entity.User;
import edu.mallsystem.entity.UserInfo;

/**
 * 定义用户相关业务的接口
 * Created by Administrator on 2017/12/21.
 */
public interface IUserService {

    //新增用户
    boolean saveUser(User user);

    //新增用户返回用户
    User saveUserReturn(User user);

    //用户登录
    User doLogin(User user);

    //查询用户详细信息
    UserInfo findUserInfo(String uuid);

    //更新用户详细信息
    boolean updateUserInfo(UserInfo userInfo);

}
