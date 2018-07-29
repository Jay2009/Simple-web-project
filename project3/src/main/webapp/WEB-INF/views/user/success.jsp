<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>


<%@include file="../include/header.jsp" %>
<body>
<style>
div {
  background-image: url('/resources/darkuniverse.jpg');
  background-repeat: no-repeat;
  background-position: center top;
  background-size: 1550px 1500px;
}
</style>
</body>
<div>
    <title>Home</title>

    <c:if test="${msg == 'success'}">
 
   
    <h3 style="color: skyblue">Hello!!!  ${username} </h3>
    
  
    </c:if>
     <a href="${path}/user/mypage" style="color:white;">My page</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <a href="${path}/user/logout.do" style="color:orange;">Sign out</a>
     <br>
     <br>
     <br>
     <br>
     <br>
   <center>
   
    <h3 style="color: skyblue"> Click to start</h3>
 <a href="${path}/user/main" >
<img src="/resources/earth.jpg" style="width:128px;height:128px;">
     </a>
     
     </center>
     <br>
     <br>
     <br>
     <br>
     <br>
     <br><br> <br><br> <br><br>
     <br><br><br><br> <br><br> <br><br><br><br>
     <br>
    </div>
     <script>
	
	
	
</script>
     


<%@include file="../include/footer.jsp" %>