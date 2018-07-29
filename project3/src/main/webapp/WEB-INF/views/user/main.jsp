<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>


<%@include file="../include/header.jsp" %>
<head>
<style>
div {
  background-image: url('/resources/toronto.jpg');
  background-repeat: no-repeat;
  background-position: center top;
  background-size: 1550px 500px;
}
</style>




</head>

<div> 

   <br>
   <br>
   <br>
   <br>
   <c:if test="${username != null}" > 
   <br>
    <h4 style="color:black">&emsp;&emsp; Hello!!!  ${username} </h4>
  
    &emsp;&emsp;&nbsp;&nbsp; <a href="${path}/user/mypage" style="color:blue;">My page</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="${path}/user/logout.do" style="color:orange;">Sign out</a>
    </c:if>
 
 
    <c:if test="${username == null}" > 
   <h2> <a href="${path}/user/login.do" style="color:orange;">Sign in</a> </h2>
    </c:if>
    <br><br><br><br><br>
 <center>
 <h1><a href="${path}/user/main " style="color:yellowgreen;">Home</a></h1>
</center>

<span style="float:right">
  <button type="submit" class="btn btn-info" style="color:white">Creator info</button>&emsp;&emsp;&emsp;&emsp;&emsp;
  </span>
 	<br>
 	<br>
   <br>
   <br>
   </div>
   <br>
   <center><h3 style="color:skyblue" >Click an image below to continue!</h3></center>
    <br>

 &emsp; &emsp;&emsp; &emsp; &emsp; &emsp;&emsp; <a href="${path}/projectboard/projectlist" >
<img src="/resources/roomrentals.gif" style="width:200px;height:180px;"  >
     </a>&emsp; &emsp; &emsp;&emsp; &emsp; &emsp;&emsp;&emsp;
  
     
     <a href="${path}/sboard/list" >
		<img src="/resources/Portfolio.png" style="width:200px;height:180px;">
     </a>&emsp; &emsp; &emsp;&emsp; &emsp; &emsp;&emsp;&emsp;
     
     
     <a href="${path}/user/boom" >
		<img src="/resources/freepoint.gif" style="width:200px;height:180px;">
 	</a>&emsp; &emsp; &emsp;&emsp; &emsp; &emsp;&emsp;&emsp;
 	
 	<a href="${path}/user/customerservice" >
		<img src="/resources/customerservice.jpg" style="width:200px;height:180px;">
 	</a>
 	
 	

 	
 	
     <br>
    
    &emsp; &emsp; &emsp; &emsp; &emsp; <video src="/resources/Low_Flight_over_the_Houses.mp4" style="width:600px;height:600px;"  autoplay="autoplay" loop="loop" >
    </video>&emsp; &emsp; &emsp;&emsp; &emsp;
    
    
    
    <video src="/resources/job.mp4" style="width:600px;height:600px;"  autoplay="autoplay" loop="loop" >
    </video>
     
  
     
     <script>
	$(document).ready(function(){
		var formObj = $("form[role='form']");
		console.log(formObj);
		
		$(".btn-info").on("click", function(){
			self.location="/user/jaeminkim";
		});
	
	});

	
	
</script>
     
<br><br><br>

<%@include file="../include/footer.jsp" %>