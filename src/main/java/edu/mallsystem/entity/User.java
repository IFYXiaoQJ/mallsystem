package edu.mallsystem.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 封装用户信息的实体类
 * Created by Administrator on 2017/12/20.
 */
@Entity
@Table(name = "mallsystem_user")
public class User implements Serializable {

    @Column(name = "user_no")
    private String no;          //编号
    @Column(name = "user_name",unique = true,nullable = false)
    private String name;        //用户名
    @Column(name = "user_password",nullable = false)
    private String password;    //密码
    @Column(name = "user_integral")
    private double integral;    //积分
    @Column(name = "user_money")
    private double money;       //钱包
    @Column(name = "user_privilege")
    private int privilege = 0;  //权限 0:普通用户 1:超级管理员
    @Column(name = "user_createtime",nullable = false)
    private Date createtime;    //创建时间
    @Column(name = "user_status")
    private int status = 1;     //状态 0:注销 1:启用


    public User() {
    }

    public User(String no, String name, String password, double integral, double money, int privilege, Date createtime, int status) {
        this.no = no;
        this.name = name;
        this.password = password;
        this.integral = integral;
        this.money = money;
        this.privilege = privilege;
        this.createtime = createtime;
        this.status = status;
    }

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid")
    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getIntegral() {
        return integral;
    }

    public void setIntegral(double integral) {
        this.integral = integral;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    @Temporal(TemporalType.DATE)
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
