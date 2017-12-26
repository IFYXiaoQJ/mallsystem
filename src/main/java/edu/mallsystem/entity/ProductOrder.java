package edu.mallsystem.entity;

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
    private String ordernum;//单号
    @Column(name = "productorder_price")
    private double price;//总价
    @Column(name = "productorder_total")
    private int total;//数量
    @Column(name = "productorder_createtime")
    private Date createtime = new Date();//创建时间
    @Column(name = "productorder_status")
    private int status = 0;//状态 0:未发货 1:发货 2:确认接收 3:退货

    //多对一 商品
    private Product product;

    public ProductOrder() {
    }

    public ProductOrder(String no, String ordernum, double price, int total, Date createtime, int status) {
        this.no = no;
        this.ordernum = ordernum;
        this.price = price;
        this.total = total;
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
}
