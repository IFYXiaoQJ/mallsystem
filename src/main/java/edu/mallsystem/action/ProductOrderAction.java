package edu.mallsystem.action;

import edu.mallsystem.entity.ProductOrder;
import edu.mallsystem.service.IProductOrderService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
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

    //声明业务层接口
    @Resource(name = "productOrderService")
    private IProductOrderService productOrderService;

    //1,处理购买单个商品
    public String doSaveProductOrder(){
        if(productOrder!=null){

        }
        return "";
    }

    //2,处理购买单个订单的请求
    public String doSaveProductOrderByShoppingCar(){
        if(productOrder!=null){

            System.out.println("ok");
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

    public void setProductOrderService(IProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }
}
