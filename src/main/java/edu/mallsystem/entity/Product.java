package edu.mallsystem.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 封装商品信息的实体类
 * Created by Administrator on 2017/12/23.
 */
@Entity
@Table(name = "mallsystem_product")
public class Product {

    @Column(name = "product_no")
    private String no;//编号
    @Column(name = "product_name",nullable = false,unique = true)
    private String name;//名称
    @Column(name = "product_company",nullable = false)
    private String company;//公司名称
    @Column(name = "product_info")
    private String info;//详细信息
    @Column(name = "product_address",nullable = false)
    private String address;//地址
    @Column(name = "product_price",nullable = false)
    private double price;//价格
    @Column(name = "product_total",nullable = false)
    private int total;//数量
    @Column(name = "product_createtime",nullable = false)
    private Date createtime = new Date();//创建时间
    @Column(name = "product_discounts")
    private int discounts;//优惠状态 1:优惠 0:没优惠
    @Column(name = "product_status")
    private int status = 1;//状态 1:上架 0:下架
    @Column(name = "product_img")
    private String img = "images/system/errorImg.jpg";//图片路径

    //多对一,商品类型
    private ProductType productType;

    public Product() {
    }

    public Product(String no, String name, String company, String info, String address, double price, int total, Date createtime, int discounts, int status) {
        this.no = no;
        this.name = name;
        this.company = company;
        this.info = info;
        this.address = address;
        this.price = price;
        this.total = total;
        this.createtime = createtime;
        this.discounts = discounts;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public int getDiscounts() {
        return discounts;
    }

    public void setDiscounts(int discounts) {
        this.discounts = discounts;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "producttype_no")
    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
