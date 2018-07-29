<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>


<%@include file="../include/header.jsp" %>
<body>
<style>
div {
  background-image: url('/resources/gameover.jpg');
  background-repeat: no-repeat;
  background-position: center;
  background-size: 1000px 600px;
}
</style>
</body>


<div>
<br><br>


<center>

<h3 style="color:blue">Game over</h3> <br>
<button type = "submit" class="btn btn-primary">Go main</button>
</center>


<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</div>
<script>
	$(document).ready(function(){
		$(".btn-primary").on("click", function(){
			self.location="/user/main";
		});
	});
</script>


<%@include file="../include/footer.jsp"%>