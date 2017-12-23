package edu.mallsystem.action;

import com.opensymphony.xwork2.ActionSupport;
import edu.mallsystem.bean.PageBean;
import edu.mallsystem.entity.ProductType;
import edu.mallsystem.service.IProductTypeService;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 处理商品类型请求的Action
 * Created by Administrator on 2017/12/23.
 */
@Controller("productTypeAction")
@Scope("prototype")
public class ProductTypeAction extends ActionSupport {

    private ProductType productType;
    private PageBean pageBean;
    private String[] querys;
    private int msg;

    //声明服务层接口
    @Resource(name = "productTypeService")
    private IProductTypeService productTypeService;

    //1,处理新增商品类型的请求
    public void doSaveProductType() throws IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        PrintWriter out = response.getWriter();
        if(productType!=null){
            if(productTypeService.saveProductType(productType)){
                out.println("<script>alert('新增商品类型成功!');history.back();location.reload();</script>");
            }else {
                out.println("<script>alert('新增商品类型失败!');history.back();location.reload();</script>");
            }
        }
        out.close();
    }

    //2,处理分页带条件查询的请求
    public String findProductTypeForPage(){
        if(pageBean!=null){
            pageBean = productTypeService.findProductTypeList(pageBean,querys);
        }
        return "main";
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
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

    public int getMsg() {
        return msg;
    }

    public void setMsg(int msg) {
        this.msg = msg;
    }

    public void setProductTypeService(IProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }
}
