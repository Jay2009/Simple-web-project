<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>


<%@include file="../include/header.jsp" %>
<body>
<style>
div {
  background-image: url('/resources/congratulations.jpg');
  background-repeat: no-repeat;
  background-position: center;
  background-size: 1500px 600px;
}
</style>
</body>


<div>
<br><br>

<form role="form">
<center>

<h3 style="color:blue">You win 100 points!</h3> <br>
<h3 style="color:skyblue">Click the button below to get the points!</h3> <br>
<button type = "submit" class="btn btn-primary">click</button>
</center>

</form>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</div>
<script>
	$(document).ready(function(){
		var formObj = $("form[role='form']");
		console.log(formObj);
		
		$(".btn-primary").on("click", function(){
			formObj.attr("method", "post");
			formObj.attr("action", "/user/congratulations");
			formObj.submit();
		});
	});
</script>


<%@include file="../include/footer.jsp"%>