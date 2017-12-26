package edu.mallsystem.entity;

import edu.mallsystem.util.DateSequenceCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 封装商品订单的实体类
 * Created by Administrator on 2017/12/25.
 */
@Entity
@Table(name = "mallsystem_productorder")
public class ProductOrder {

    @Column(name = "productorder_no")
    private String no;//编号
    @Column(name = "productorder_ordernum",unique = true,nullable = false)
    private String ordernum = DateSequenceCode.getTimeSequence();//单号
    @Column(name = "productorder_price")
    private double price;//总价
    @Column(name = "productorder_total")
    private int total;//数量
    @Column(name = "productorder_shippingAddress",nullable = false)
    private String shippingAddress;//收货地址
    @Column(name = "productorder_name",nullable = false)
    private String name;//姓名
    @Column(name = "productorder_tel",nullable = false)
    private String tel;//联系电话
    @Column(name = "productorder_createtime")
    private Date createtime = new Date();//创建时间
    @Column(name = "productorder_status")
    private int status = 0;//状态 0:未发货 1:发货 2:确认接收 3:退货

    //多对一 商品
    private Product product;
    //多对一 用户
    private User user;

    public ProductOrder() {
    }

    public ProductOrder(String no, String ordernum, double price, int total, String shippingAddress, String name, String tel, Date createtime, int status) {
        this.no = no;
        this.ordernum = ordernum;
        this.price = price;
        this.total = total;
        this.shippingAddress = shippingAddress;
        this.name = name;
        this.tel = tel;
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

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "product_no")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_no")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
