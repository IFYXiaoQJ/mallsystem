<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/23
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>商品类型列表</title>
    <script src="${pageContext.request.contextPath}/js/jquery1.9/jquery-1.9.min.js"></script>
</head>
<body>
    <h2>商品类型列表</h2>
    <a href="${pageContext.request.contextPath}/pages/mall/mallMain.jsp">返回</a>
    <form id="frm">
        类型名称:<input type="text" name="querys"/>&nbsp;
        时间:<input type="date" name="querys"/>-<input type="date" name="querys"/>
            <input type="button" value="模糊查询" onclick="loadData();"/>
            <input type="button" value="批量删除" onclick="deletes()"/>
    </form>
    <table id="tab" border="1" width="600px">
        <tr>
            <td><input type='checkbox' onclick='selected();'/>全/反选</td>
            <td>序号</td>
            <td>类型</td>
            <td>创建时间</td>
            <td>管理</td>
        </tr>
    </table>
</body>
</html>
<script>

    window.onload = loadData;

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

    //异步查询数据
    function loadData(page){
        $("#tab tr :not(:first)").remove();//清空第一行以外的数据
        page = page==null?1:page;//判断页数
        var url = "productTypeAction_findProductTypeForPage?pageBean.page="+page;
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
                    var opt = "<tr>";
                        opt += "<td><input name='selects' type='checkbox' value='"+v.no+"'/></td>";
                        opt += "<td>"+((cpage-1)*showNum+(i+1))+"</td>";
                        opt += "<td>"+v.name+"</td>";
                        opt += "<td>"+v.createtime.substring(0,10)+"</td>";
                        opt += "<td>";
                        opt += "<a href='productTypeAction_toUpdateProductType?productType.no="+v.no+"'>更新</a>&nbsp;|&nbsp;";
                        opt += "<a href='productTypeAction_doDeleteProductType?productType.no="+v.no+"'>删除</a>";
                        opt += "</td>";
                        opt += "</tr>";

                    $("#tab").append(opt);
                });

                //分页条
                var opt = "<tr>";
                    opt += "<td colspan='5' style='text-align:center;'>";
                    opt += "共"+allNum+"条数据,"+data.pageBean.cpage+"/"+allPage+"页&nbsp;";
                    opt += "<a href='javascript:loadData(1);'>首页</a>&nbsp;";
                    opt += "<a href='javascript:loadData("+upPage+");'>上一页</a>&nbsp;";
                    opt += "<a href='javascript:loadData("+downPage+");'>下一页</a>&nbsp;";
                    opt += "<a href='javascript:loadData("+allPage+");'>尾页</a>&nbsp;";

                $("#tab").append(opt);
            }else{
                var opt = "<tr><td colspan='5'>";
                    opt += "没查询到任何数据...";
                    opt += "</td></tr>";

                $("#tab").append(opt);
            }
        },"json");
    }

    //处理异步删除
    function deletes(){
        var selects = $(":checkbox").serialize();
        location.href = "productTypeAction_doDeleteProductTypeList?"+selects;
    }

</script>
