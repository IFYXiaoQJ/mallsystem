package edu.mallsystem.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import edu.mallsystem.bean.PageBean;
import edu.mallsystem.entity.Product;
import edu.mallsystem.entity.ShoppingCar;
import edu.mallsystem.entity.User;
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
    private PageBean pageBean;
    private String[] querys;
    private String[] selects;
    private int total;
    private int msg;

    //声明业务层接口
    @Resource(name = "shoppingCarService")
    private IShoppingCarService shoppingCarService;

    //1,处理添加商品到购物车的请求
    public String doSaveShoppingCar(){
        if(product!=null&&total!=0){
            User user = (User) ActionContext.getContext().getSession().get("loginUser");
            if(shoppingCarService.saveShoppingCar(user,product,total)){
                msg = 1;
            }else{
                msg = -1;
            }
        }
        System.out.println(msg);
        return "saveShoppingCar";
    }

    //2,处理查询购物车列表的请求
    public String doFindShoppingCarForPage(){
        if(pageBean!=null){
            User user = (User) ActionContext.getContext().getSession().get("loginUser");
            pageBean = shoppingCarService.findUserShoppingCarList(pageBean,user.getNo());
        }
        return "main";
    }

    //3,处理删除购物车的请求
    public String doDeleteShoppingCar(){
        if(shoppingCar!=null){
            if(shoppingCarService.deleteShoppingCar(shoppingCar)){
                msg = 1;
            }else{
                msg = -1;
            }
        }
        return "toFindShoppingCarForPage";
    }

    //4,处理批量删除购物车的请求
    public String doDeleteShoppingCarList(){
        if(selects!=null&&selects.length>0){
            if(shoppingCarService.deleteShoppingCar(selects)){
                msg = 1;
            }else{
                msg = -1;
            }
        }
        return "toFindShoppingCarForPage";
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

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public String[] getQuerys() {
        return querys;
    }

    public void setQuerys(String[] querys) {
        this.querys = querys;
    }

    public String[] getSelects() {
        return selects;
    }

    public void setSelects(String[] selects) {
        this.selects = selects;
    }

    public void setShoppingCarService(IShoppingCarService shoppingCarService) {
        this.shoppingCarService = shoppingCarService;
    }
}
