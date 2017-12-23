package edu.mallsystem.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import edu.mallsystem.entity.User;
import edu.mallsystem.entity.UserInfo;
import edu.mallsystem.service.IUserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * 处理用户相关请求的Action
 * Created by Administrator on 2017/12/21.
 */
@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport {

    private User user;
    private UserInfo userInfo;
    private int msg;

    //声明服务层接口
    @Resource(name = "userService")
    private IUserService userService;

    //1,处理注册用户的请求
    public String doRegisterUser(){
        if(user!=null){
            if(userService.saveUser(user)){
                user = userService.doLogin(user);
                ActionContext.getContext().getSession().put("loginUser",user);
                return "toUpdateUserInfo";
            }
        }
        return "input";
    }

    //2,处理去到更新用户详细信息的页面
    public String toUpdateUserInfo(){
        //获取登录用户
        user = (User) ActionContext.getContext().getSession().get("loginUser");
        //调用服务层方法查询
        userInfo = userService.findUserInfo(user.getNo());
        return "updateUserInfo";
    }

    //3,处理更新用户详细信息的请求
    public String doUpdateUserInfo(){
        if(userInfo!=null){
            if(userService.updateUserInfo(userInfo)){
                return "toUpdateUserInfo";
            }
        }
        return "input";
    }

    //4,处理用户登录的请求
    public String doLogin(){
        if(user!=null){
            user = userService.doLogin(user);
            if(user==null){
                return "loginInput";
            }
            ActionContext.getContext().getSession().put("loginUser",user);
        }
        return "main";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public int getMsg() {
        return msg;
    }

    public void setMsg(int msg) {
        this.msg = msg;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
}
