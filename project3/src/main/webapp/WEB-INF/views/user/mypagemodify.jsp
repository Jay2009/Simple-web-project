<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>


<%@include file="../include/header.jsp" %>
<center>
<br>

<h3 Style="color:blue"> My page </h3>
	<br><br><br>
	Change your info and click "Save" button
	<br><br><br>



					<form role="form">
				
					
					Id &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;   <input type="text" id='id' name='id' value="${id}"readonly="readonly">&nbsp;&nbsp; 
					
					Name &nbsp; <input type="text" name='username' value="${userVO.username}" >&nbsp;&nbsp;
					<br><br>
					
					Birth &nbsp; <input type="text" name='birth' value="${userVO.birth}" >&nbsp;&nbsp;
						
					Email &nbsp; <input type="text" name='email' value="${userVO.email}" >&nbsp;&nbsp;
					<br><br>
					
					Mobile &nbsp; <input type="text" name='mobilenum' value="${userVO.mobilenum}">&nbsp;&nbsp;
				
					Address1 &nbsp; <input type="text" name='address1' value="${userVO.address1}" >&nbsp;&nbsp;
					<br><br>
							
					Address2 &nbsp; <input type="text" name='address2' value="${userVO.address2}" >&nbsp;&nbsp;
					
					Address3 &nbsp; <input type="text" name='address3' value="${userVO.address3}" >&nbsp;&nbsp;
					<br>
					<br><br>
					Follower &nbsp; <input type="text" name='follownum' value="${userVO.follownum}" readonly="readonly">&nbsp;&nbsp;
					
					Balance &nbsp; <input type="text" name='balance' value="${userVO.balance}" readonly="readonly">&nbsp;&nbsp;
					<br>
					<br>
					<br>
						</form>			
		
						<button type = "submit" class="btn btn-primary">Save</button>
						<button type = "submit" class="btn btn-warning">Back
						</button>
								

<script>
	$(document).ready(function(){
		var formObj = $("form[role='form']");
		console.log(formObj);
		
		$(".btn-primary").on("click", function(){
			formObj.attr("method", "post");
			formObj.attr("action", "/user/mypagemodify");
			formObj.submit();
		});
			
		$(".btn-warning").on("click", function(){
			self.location="/user/mypage";
		});
			
	});	
</script>
 


<%@include file="../include/footer.jsp" %>