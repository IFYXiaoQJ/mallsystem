package edu.mallsystem.entity;

import javax.persistence.*;

/**
 * 封装用户详细信息的实体类
 * Created by Administrator on 2017/12/20.
 */
@Entity
@Table(name = "mallsystem_userinfo")
public class UserInfo {

    @Column(name = "userinfo_no")
    private int no;             //编号
    @Column(name = "userinfo_realname")
    private String realname;    //真实姓名
    @Column(name = "userinfo_sex")
    private int sex = 1;        //性别 1:男 0:女
    @Column(name = "userinfo_age")
    private int age;            //年龄
    @Column(name = "userinfo_idcard")
    private String idcard;      //身份证
    @Column(name = "userinfo_address")
    private String address;     //家庭地址
    @Column(name = "userinfo_postAddress")
    private String postAddress; //邮政地址
    @Column(name = "userinfo_tel1")
    private String tel1;        //联系电话1
    @Column(name = "userinfo_tel2")
    private String tel2;        //联系电话2

    //一对一
    private User user;

    public UserInfo() {
    }

    public UserInfo(int no, String realname, int sex, int age, String idcard, String address, String postAddress, String tel1, String tel2) {
        this.no = no;
        this.realname = realname;
        this.sex = sex;
        this.age = age;
        this.idcard = idcard;
        this.address = address;
        this.postAddress = postAddress;
        this.tel1 = tel1;
        this.tel2 = tel2;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    @OneToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_no")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
