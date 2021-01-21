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
    
    <title>我的借书记录</title>
    
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
			  $("#next").click(function(){
				  var pages = parseInt($("#pages").html());
				  var page = parseInt($("#currentPage").html());
				  if(page == pages){
					  return;
				  }
				  page++;
				  location.href = "/reader/findAllBorrow/"+page+"/"+${sessionScope.reader.id};
			  })

			  $("#previous").click(function () {
				  var page = parseInt($("#currentPage").html());
				  if(page == 1){
					  return;
				  }
				  page--;
				  location.href = "/reader/findAllBorrow/"+page+"/"+${sessionScope.reader.id};
			  })

			  $("#first").click(function () {
				  location.href = "/reader/findAllBorrow/1/"+${sessionScope.reader.id};
			  })

			  $("#last").click(function(){
				  var pages = parseInt($("#pages").html());
				  location.href = "/reader/findAllBorrow/"+pages+"/"+${sessionScope.reader.id};
			  })
		  })
	  </script>
  </head>
  
  <body>
    <%@ include file="top.jsp" %>
  	
  	
  	<div id="main">
		<div class="navigation">
				当前位置:&nbsp;&nbsp;<a href="/reader/findAllBook/1">首页</a>
				<div id="readerBlock">欢迎回来&nbsp;:${sessionScope.reader.name}&nbsp;<a href="/logout">注销</a></div>
		</div>
		<div class="img_block">
			<img src="images/main_booksort.gif" class="img" />
		</div>
		
		<table class="table" cellspacing="0">
			<tr>
				<td>编号</td>
				<td>图书名称</td>
				<td>图书作者</td>
				<td>出版社</td>
				<td>读者姓名</td>
				<td>联系电话</td>
				<td>证件编号</td>
				<td>借书时间</td>
				<td>还书时间</td>
				<td>审核状态</td>
			</tr>
			<c:forEach items="${list}" var="borrowVo">
				<tr>
					<td>${borrowVo.id}</td>
					<td>${borrowVo.bookName}</td>
					<td>${borrowVo.author}</td>
					<td>${borrowVo.publish}</td>
					<td>${borrowVo.readerName}</td>
					<td>${borrowVo.tel}</td>
					<td>${borrowVo.cardId}</td>
					<td>${borrowVo.borrowTime}</td>
					<td>${borrowVo.returnTime}</td>
					<td>
						<c:if test="${borrowVo.state == 0}">
							<font color="black">未审核</font>
						</c:if>
						<c:if test="${borrowVo.state == 1}">
							<font color="green">审核通过</font>
						</c:if>
						<c:if test="${borrowVo.state == 2}">
							<font color="red">未通过</font>
						</c:if>
						<c:if test="${borrowVo.state == 3}">
							<font color="blue">已归还</font>
						</c:if>
					</td>
				</tr>
			</c:forEach>
			
		</table>
		<hr class="hr"/>
		<div id="pageControl">
			<%--dataPrePage：每页6条数据--%>
			<div class="pageControl_item">每页<font id="dataPrePage">${dataPrePage }</font>条数据</div>
			<div class="pageControl_item" id="last">最后一页</div>
			<div class="pageControl_item" id="next">下一页</div>
				<%--
				currentPage：当前页号。
				pages：总页数。
				--%>
			<div class="pageControl_item"><font id="currentPage">${currentPage }</font>/<font id="pages">${pages }</font></div>
			<div class="pageControl_item" id="previous">上一页</div>
			<div class="pageControl_item" id="first">首页</div>
		</div>
	</div>

  	
   <%@ include file="footer.jsp" %>
  </body>
</html>
