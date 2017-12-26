package edu.mallsystem.action;

import edu.mallsystem.entity.ProductOrder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * 处理订单相关请求的Action
 * Created by Administrator on 2017/12/26.
 */
@Controller("productOrderAction")
@Scope("prototye")
public class ProductOrderAction {

    private ProductOrder productOrder;
    private List productOrderList;
    private int msg;

    //1,处理购买单个商品
    public String doSaveProductOrder(){
        if(productOrder!=null){

        }
        return "";
    }

    public ProductOrder getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(ProductOrder productOrder) {
        this.productOrder = productOrder;
    }

    public List getProductOrderList() {
        return productOrderList;
    }

    public void setProductOrderList(List productOrderList) {
        this.productOrderList = productOrderList;
    }

    public int getMsg() {
        return msg;
    }

    public void setMsg(int msg) {
        this.msg = msg;
    }
}
