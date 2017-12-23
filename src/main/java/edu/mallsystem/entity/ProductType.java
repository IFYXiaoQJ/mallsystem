package edu.mallsystem.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 封装商品类型信息的实体类
 * Created by Administrator on 2017/12/23.
 */
@Entity
@Table(name = "mallsystem_producttype")
public class ProductType {

    @Column(name = "producttype_no")
    private String no;
    @Column(name = "producttype_name",nullable = false,unique = true)
    private String name;
    @Column(name = "producttype_createtime")
    private Date createtime = new Date();

    public ProductType() {
    }

    public ProductType(String no, String name, Date createtime) {
        this.no = no;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Temporal(TemporalType.DATE)
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
