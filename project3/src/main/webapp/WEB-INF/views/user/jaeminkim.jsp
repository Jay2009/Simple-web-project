<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<%@include file="../include/header.jsp"%>
<br>
<h4 style="color:blue">
Creator : Jaemin Kim (Jay Kim)<br>
Mobile  : 647-936-5340<br>
E-mail  : jaem2009@naver.com<br>
</h4>
<a href="${path}https://www.youtube.com/channel/UCMZ2i2Zi94Pt3amWWXXkP6A?view_as=subscriber" style="color:skyblue;">
<center> <h2>Click here to watch Jaemin's RC car project </h2> </center>
 </a>
 
<center>
<a href="${path}https://www.youtube.com/channel/UCMZ2i2Zi94Pt3amWWXXkP6A?view_as=subscriber" >
<img src="/resources/rc1.jpg" style="width:200px;height:180px;"  >
     &emsp; &emsp; </a>
     
       
<a href="${path}https://www.youtube.com/channel/UCMZ2i2Zi94Pt3amWWXXkP6A?view_as=subscriber" >
<img src="/resources/rc2.jpg" style="width:200px;height:180px;"  >
     &emsp; &emsp; </a>
     
     
<a href="${path}https://www.youtube.com/channel/UCMZ2i2Zi94Pt3amWWXXkP6A?view_as=subscriber" >
<img src="/resources/rc3.jpg" style="width:200px;height:180px;"> </a>
</center>
     

    
    
    
    <br>
<br>
<center>
<button type="submit" class="btn btn-primary">Back</button>
</center>
<br>
<br>
<br>
  </body>
</html>


   <script>
	$(document).ready(function(){
		var formObj = $("form[role='form']");
		console.log(formObj);
		
		$(".btn-primary").on("click", function(){
			self.location="/user/main";
		});
	
	});
	
</script>


<%@include file="../include/footer.jsp"%>