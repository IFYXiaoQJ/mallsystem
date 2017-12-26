package edu.mallsystem.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 封装购物车信息的类
 * Created by Administrator on 2017/12/25.
 */
@Entity
@Table(name = "mallsystem_shoppingcar")
public class ShoppingCar {

    @Column(name = "shoppingcar_no")
    private String no;//编号
    @Column(name = "shoppingcar_price")
    private double price;//总价
    @Column(name = "shoppingcar_total")
    private int total;//数量
    @Column(name = "shoppingcar_createtime")
    private Date createtime = new Date();//创建时间

    //多对一 商品
    private Product product;
    //多对一 用户
    private User user;

    public ShoppingCar() {
    }

    public ShoppingCar(String no, double price, int total, Date createtime) {
        this.no = no;
        this.price = price;
        this.total = total;
        this.createtime = createtime;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Temporal(TemporalType.DATE)
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "product_no")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_no")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
