<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward 액션 태그를 이용한 분기 예제  </title>
</head>
<body>
<% if(request.getParameter("type")==null || 
           request.getParameter("type").equals("admin") ){ %>
  <jsp:forward page="adminPage.jsp">
  <jsp:param name="message" value="Hi! Administrator" /> <!-- 포워드 태그와 인클루드 액션태그와 함께 쓰이며 키 밸류값을 전달함 --> 
  </jsp:forward>
<% } else  {%>
  <jsp:forward page="userPage.jsp">
  <jsp:param name="message" value="Hi! User" />
  </jsp:forward>
<%} %> 
</body>
</html>
