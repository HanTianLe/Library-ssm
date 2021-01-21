<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>借书管理页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/index.css" type="text/css" rel="stylesheet">
	  <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
	  <script type="text/javascript">
		  $(function(){
			  /** next 下一页，绑定点击事件。*/
			  $("#next").click(function(){
				  // 将 pages 值(文本类型)，通过parseInt强转为数值类型。
				  // 总页数。（最后一页）
				  var pages = parseInt($("#pages").html());
				  // 将 currentPage 值(文本类型)，通过parseInt强转为数值类型。
				  // 当前页号。
				  var page = parseInt($("#currentPage").html());
				  // 设置页数上限。当到最后一页时，无法继续，直接逗留本页面。
				  if(page == pages){
					  return;
				  }
				  // page初始化是=1的。
				  page++;
				  location.href = "/admin/findAllBorrowByState/"+page+"/0";
			  })

			  /** previous 上一页，绑定点击事件。*/
			  $("#previous").click(function () {
				  var page = parseInt($("#currentPage").html());
				  // 当回到第一页时，无法继续，直接逗留本页面。
				  if(page == 1){
					  return;
				  }
				  page--;
				  location.href = "/admin/findAllBorrowByState/"+page+"/0";
			  })

			  /** first 首页，绑定点击事件。*/
			  $("#first").click(function () {
				  // 回到第一页。
				  location.href = "/admin/findAllBorrowByState/1/0";
			  })

			  /** last 最后一页，绑定点击事件。*/
			  $("#last").click(function(){
				  // 总页数。（最后一页）
				  var pages = parseInt($("#pages").html());
				  // 回到最后一页。（用参数pages总页数也就是最后一页。）
				  location.href = "/admin/findAllBorrowByState/"+pages+"/0";
			  })
		  })
	  </script>
  </head>
  
  <body>
    <%@ include file="top.jsp" %>
  	
  	
  	<div id="main">
		<div class="navigation">
				当前位置:&nbsp;&nbsp;<a href="/admin/findAllBorrowByState/1/1">还书管理</a>
				<div id="readerBlock">欢迎回来&nbsp;:${sessionScope.admin.username }&nbsp;<a href="/logout">注销</a></div>
		</div>
		<div class="img_block">
			<img src="images/main_booksort.gif" class="img" />
		</div>
		
		<table class="table" cellspacing="0">
			<tr>
				<td>编号</td>
				<td>图书名称</td>
				<td>图书作者</td>
				<td>读者姓名</td>
				<td>证件编号</td>
				<td>联系电话</td>
				<td>借书时间</td>
				<td>还书时间</td>
				<td>操作</td>
			</tr>

			<c:forEach items="${list}" var="borrow">
				<tr>
					<td>${borrow.id}</td>
					<td>${borrow.bookName}</td>
					<td>${borrow.author}</td>
					<td>${borrow.readerName}</td>
					<td>${borrow.cardId}</td>
					<td>${borrow.tel}</td>
					<td>${borrow.borrowTime}</td>
					<td>${borrow.returnTime}</td>
					<td>
						<a href="/admin/borrowHandler/${sessionScope.admin.id}/${borrow.id}/1">同意</a>
						<a href="/admin/borrowHandler/${sessionScope.admin.id}/${borrow.id}/2">拒绝</a>
					</td>
				</tr>
			</c:forEach>

		</table>
		<hr class="hr"/>
		<div id="pageControl">
			<div class="pageControl_item">每页<font id="dataPrePage">${dataPrePage }</font>条数据</div>
			<div class="pageControl_item" id="last">最后一页</div>
			<div class="pageControl_item" id="next">下一页</div>
			<div class="pageControl_item"><font id="currentPage">${currentPage }</font>/<font id="pages">${pages }</font></div>
			<div class="pageControl_item" id="previous">上一页</div>
			<div class="pageControl_item" id="first">首页</div>
		</div>
	</div>
  	
   <%@ include file="footer.jsp" %>
  </body>
</html>
