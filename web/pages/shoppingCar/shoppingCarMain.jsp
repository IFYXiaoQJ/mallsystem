<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/26
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>购物车页面</title>
    <script src="${pageContext.request.contextPath}/js/jquery1.9/jquery-1.9.min.js"></script>
</head>
<body>
<%@include file="/pages/user/userBaseInfo.jsp"%>
    <h2>购物车列表</h2>
    <input type="button" value="批量下单"/>
    <input type="button" value="批量删除" onclick="deletes();"/>
    <s:form id="frm">
        <table border="1" width="600px">
            <tr>
                <td><input type='checkbox' onclick='selected();'/>全/反选</td>
                <td>序号</td>
                <td>商品图片</td>
                <td>商品名</td>
                <td>单价</td>
                <td>总数量</td>
                <td>总价</td>
                <td>加入时间</td>
                <td>管理</td>
            </tr>
            <s:if test="%{pageBean.result!=null}">
                <s:iterator var="opt" value="%{pageBean.result}" status="ids">
                    <tr>
                        <td><input name="selects" type="checkbox" value="${opt.no}"/></td>
                        <td>${ids.count}</td>
                        <td><img width="50px" height="50px" src="${pageContext.request.contextPath}/${opt.product.img}"></td>
                        <td>${opt.product.name}</td>
                        <td>${opt.product.price}</td>
                        <td>${opt.total}</td>
                        <td>${opt.price}</td>
                        <td>${opt.createtime}</td>
                        <td>
                            <a javascript:;>购买</a>&nbsp;|&nbsp;
                            <a href="shoppingCarAction_doDeleteShoppingCar?shoppingCar.no=${opt.no}">删除</a>
                        </td>
                    </tr>
                </s:iterator>
                <tr>
                    <td colspan="9" style="text-align: center;">
                        共${pageBean.allNum}条数据,
                        ${pageBean.cpage}/${pageBean.allPage}页,
                        <a href="shoppingCarAction_doFindShoppingCarForPage?pageBean.cpage=1">首页</a>
                        <a href="shoppingCarAction_doFindShoppingCarForPage?pageBean.cpage=${pageBean.cpage>1?pageBean.cpage-1:pageBean.cpage}">上一页</a>
                        <a href="shoppingCarAction_doFindShoppingCarForPage?pageBean.cpage=${pageBean.cpage<pageBean.allPage?pageBean.cpage+1:pageBean.allPage}">下一页</a>
                        <a href="shoppingCarAction_doFindShoppingCarForPage?pageBean.cpage=${pageBean.allPage}">尾页</a>
                    </td>
                </tr>
            </s:if>
        </table>
    </s:form>
</body>
</html>
<script>

    //处理全/反选的方法
    function selected(){
        var selects = document.getElementsByName("selects");
        for(var i=0; i<selects.length; i++){
            if(selects[i].checked==true){
                selects[i].checked = false;
            }else{
                selects[i].checked = true;
            }
        }
    }

    //批量删除
    function deletes(){
        var selects = $(":checkbox").serialize();
        if(selects==null||selects.length<=0){
            alert("请选择要移出的商品!");
            return;
        }
        location.href = "shoppingCarAction_doDeleteShoppingCarList?"+selects;
    }

    //单个购买
    function buyProduct(){

    }
</script>
