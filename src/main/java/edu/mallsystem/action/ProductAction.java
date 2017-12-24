package edu.mallsystem.action;

import com.opensymphony.xwork2.ActionSupport;
import edu.mallsystem.bean.PageBean;
import edu.mallsystem.entity.Product;
import edu.mallsystem.service.IProductService;
import edu.mallsystem.service.IProductTypeService;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 * 处理商品请求的Action
 * Created by Administrator on 2017/12/24.
 */
@Controller("productAction")
@Scope("prototype")
public class ProductAction extends ActionSupport {

    private Product product;
    private PageBean pageBean;
    private String[] querys;
    private int msg;
    private List productTypeList;
    private File productImg;
    private String productImgFileName;

    //声明服务层接口
    @Resource(name = "productService")
    private IProductService productService;
    @Resource(name = "productTypeService")
    private IProductTypeService productTypeService;

    //1,处理去到新增商品页面的请求
    public String toSaveProduct(){
        //查询商品类型
        productTypeList = productTypeService.findProductTypeList();
        return "saveProduct";
    }

    //2,处理新增商品的请求
    public String doSaveProduct(){
        if(product!=null){
            uploadImg();
            if(productService.saveProduct(product)){
                msg = 1;
            }else{
                msg = -1;
            }
        }
        return "";
    }

    //执行商品图片上传
    private void uploadImg(){
        if(productImg!=null&&productImgFileName!=null){
            //获取保存路径
            String path = ServletActionContext.getServletContext().getRealPath("/upload/product/productImg");
            System.out.println("path: "+path);
            //获取文件要上传的路径
            String filePath = path+"/"+productImgFileName;
            try {
                //执行上传
                FileUtils.copyFile(productImg,new File(filePath));
                product.setImg("upload/product/productImg/"+productImgFileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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

    public List getProductTypeList() {
        return productTypeList;
    }

    public void setProductTypeList(List productTypeList) {
        this.productTypeList = productTypeList;
    }

    public File getProductImg() {
        return productImg;
    }

    public void setProductImg(File productImg) {
        this.productImg = productImg;
    }

    public String getProductImgFileName() {
        return productImgFileName;
    }

    public void setProductImgFileName(String productImgFileName) {
        this.productImgFileName = productImgFileName;
    }

    public void setProductService(IProductService productService) {
        this.productService = productService;
    }

    public void setProductTypeService(IProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }
}
