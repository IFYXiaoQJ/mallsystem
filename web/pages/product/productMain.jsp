<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/25
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>商品主页</title>
    <script src="${pageContext.request.contextPath}/js/jquery1.9/jquery-1.9.min.js"></script>
</head>
<body>
<%@include file="/pages/user/userBaseInfo.jsp"%>
    <h2>商品主页</h2>
    <a href="${pageContext.request.contextPath}/pages/mall/mallMain.jsp">返回</a>
    <s:form id="frm" action="" method="post">

    </s:form>
    <hr/>
    <!-- 分页条 -->
    <div id="page" style="width:500px; height: 50px; margin:0 auto; border: 1px; "></div>
    <!-- 显示商品 -->
    <div id="show" style="width:900px; height: 700px; margin:0 auto; border: 1px;">

    </div>
</body>
</html>
<script>

    window.onload = loadData();

    //异步查询数据
    function loadData(page){
        $("#page").empty(); //清除内容
        $("#show").empty(); //清除内容
        page = page==null?1:page;//判断页数
        var url = "productAction_doFindProductListForPage?pageBean.cpage="+page;
        var params = $("#frm").serialize();

        $.post(url,params,function (data) {
            var allNum =data.pageBean.allNum;		//总数据条数
            var showNum = data.pageBean.showNum;	//显示数据条数
            var allPage = data.pageBean.allPage;	//总页数
            var cpage = data.pageBean.cpage;		//当前页
            //定义上一页,下一页的变量页数
            var upPage = cpage>1?cpage-1:1;
            var downPage = cpage<allPage?cpage+1:allPage;

            //判断集合是否有数据
            if(data.pageBean.result.length>0){
                //遍历数据
                $.each(data.pageBean.result,function(i,v){
                    var opt = "<div style='width: 20%; height: 200px; border: 1px solid red; float: left; margin: 5px;'>";
                        opt += "<img style='width:100%; height:70%;' src='${pageContext.request.contextPath}/"+v.img+"'/>";
                        opt += "<br/>商品名称:<a href='productAction_toBuyProduct?product.no="+v.no+"' target='_Blank'>"+v.name+"</a>";
                        if(v.total!=0){
                            opt += "<br/>数量:"+v.total;
                        }else{
                            opt += "<br/>数量:已售完";
                        }
                        opt += "<br/>价格:<b style='color: red;'>￥"+v.price+"</b>";
                        opt += "</div>";

                    $("#show").append(opt);
                });

                //分页条
                var opt = "共"+allNum+"条数据,"+data.pageBean.cpage+"/"+allPage+"页&nbsp;";
                opt += "<a href='javascript:loadData(1);'>首页</a>&nbsp;";
                opt += "<a href='javascript:loadData("+upPage+");'>上一页</a>&nbsp;";
                opt += "<a href='javascript:loadData("+downPage+");'>下一页</a>&nbsp;";
                opt += "<a href='javascript:loadData("+allPage+");'>尾页</a>&nbsp;";

                $("#page").append(opt);
            }
        },"json");
    }

</script>
