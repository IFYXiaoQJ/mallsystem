package edu.mallsystem.action;

import com.opensymphony.xwork2.ActionSupport;
import edu.mallsystem.entity.Product;
import edu.mallsystem.entity.ShoppingCar;
import edu.mallsystem.service.IShoppingCarService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * 处理购物车请求的Action
 * Created by Administrator on 2017/12/26.
 */
@Controller("shoppingCarAction")
@Scope("prototype")
public class ShoppingCarAction extends ActionSupport {

    private ShoppingCar shoppingCar;
    private Product product;
    private int total;
    private int msg;

    //声明业务层接口
    @Resource(name = "shoppingCarService")
    private IShoppingCarService shoppingCarService;

    //1,处理添加商品到购物车的请求
    public void doSaveShoppingCar(){
        System.out.println("---");
        if(product!=null&&total!=0){
            System.out.println("total: "+total);
        }
        //return "saveShoppingCar";
    }

    public ShoppingCar getShoppingCar() {
        return shoppingCar;
    }

    public void setShoppingCar(ShoppingCar shoppingCar) {
        this.shoppingCar = shoppingCar;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getMsg() {
        return msg;
    }

    public void setMsg(int msg) {
        this.msg = msg;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setShoppingCarService(IShoppingCarService shoppingCarService) {
        this.shoppingCarService = shoppingCarService;
    }
}
