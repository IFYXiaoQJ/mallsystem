<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/25
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>商品信息</title>
    <script src="${pageContext.request.contextPath}/js/jquery1.9/jquery-1.9.min.js"></script>
</head>
<body>
<%@include file="/pages/user/userBaseInfo.jsp"%>
    <h2>商品信息</h2>
    <s:form id="frm">
        <s:hidden name="product.no" value="%{product.no}"/>
        <s:hidden name="product.price" value="%{product.price}"/>
        <img width="200px" height="200px" src="${pageContext.request.contextPath}/${product.img}" alt=""><br/>
        商品名称:<s:textfield name="product.name" value="%{product.name}" disabled="true"/><br/>
        剩余数量:<s:textfield name="product.total" value="%{product.total}" disabled="true"/><br/>
        价格:<s:textfield name="product.price" value="%{product.price}" disabled="true"/><br/>
        会员优惠:<s:if test="%{product.discounts==0}">无</s:if>
                    <s:elseif test="%{product.discounts==1}">有</s:elseif><br/>
        公司名称:<s:textfield name="product.company" value="%{product.company}" disabled="true"/><br/>
        生产地址:<s:textfield name="product.address" value="%{product.address}" disabled="true"/><br/>
        详细信息:<s:textfield name="product.info" value="%{product.info}" disabled="true"/><br/>
        状态:<s:if test="%{product.status==0}">下架</s:if>
            <s:elseif test="%{product.status==1}">上架</s:elseif><br/>
        数量选择:<input type="button" value="-" onclick="operation(-1);"/>
                <input id="productTotal" name="total" type="text" value="1"/>
                <input type="button" value="+" onclick="operation(1);"/><br/>
        <s:if test="%{product.total<1}">
            (该商品已经售完)
            <s:submit disabled="true" value="购买"/>
            <s:submit disabled="true" value="加入购物车"/>
        </s:if>
        <s:elseif test="%{product.total>0}">
            <input type="button" value="购买" onclick=""/>
            <input type="button" value="加入购物车" onclick="addShoppingCar();"/>
        </s:elseif>
    </s:form>
</body>
</html>
<script>

    //数量算法的方法
    function operation(num) {
        var oldNum = parseInt($("#productTotal").val());
        var newNum = oldNum+num;
        if(newNum<=0){
            return;
        }
        if(newNum>parseInt($("input[name='product.total']").val())){
            return;
        }
        $("#productTotal").val(newNum);
    }

    //添加到购物车
    function addShoppingCar(){
        var url = "shoppingCarAction_doSaveShoppingCar";
        var params = $("#frm").serialize();
        $.post(url,params,function(data){
            if(data.msg==1){
                alert("加入购物车成功!");
            }else{
                alert("加入购物车失败!");
            }
        });
    }

</script>
