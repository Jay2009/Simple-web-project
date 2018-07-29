<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>


<%@include file="../include/header.jsp" %>



<br>
<center>
<h3 Style="color:blue"> My page </h3>
	<br><br><br><br><br><br>
				
					Id &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;   <input type="text" id='id' name='id' value="${id}"readonly="readonly">&nbsp;&nbsp; 
					
					Name &nbsp; <input type="text" name='username' value="${userVO.username}" readonly="readonly">&nbsp;&nbsp;
					<br>
					<br>
					Birth &nbsp; <input type="text" name='birth' value="${userVO.birth}" readonly="readonly">&nbsp;&nbsp;
							
					Email &nbsp; <input type="text" name='email' value="${userVO.email}" readonly="readonly">&nbsp;&nbsp;
					<br>
					<br>
					
					Mobile &nbsp; <input type="text" name='mobilenum' value="${userVO.mobilenum}" readonly="readonly">&nbsp;&nbsp;
					
					Address1 &nbsp; <input type="text" name='address1' value="${userVO.address1}" readonly="readonly">&nbsp;&nbsp;
					<br>
					<br>
							
					Address2 &nbsp; <input type="text" name='address2' value="${userVO.address2}" readonly="readonly">&nbsp;&nbsp;
					
					Address3 &nbsp; <input type="text" name='address3' value="${userVO.address3}" readonly="readonly">&nbsp;&nbsp;
					<br>
					<br>
					<br>
					
					Follower &nbsp; <input type="text" name='follownum' value="${userVO.follownum}" readonly="readonly">&nbsp;&nbsp;
					
					Point &nbsp; <input type="text" name='balance' value=" ${userVO.balance}" readonly="readonly">&nbsp;&nbsp;
					<br><br><br>
									
		
			<button type = "submit" class="btn btn-warning">Modify</button>
			<button type = "submit" class="btn btn-primary">Cancel</button>
	</center>		

  <script>
	$(document).ready(function(){
		var formObj = $("form[role='form']");
		console.log(formObj);
		
		$(".btn-warning").on("click", function(){
			self.location="/user/mypagemodify";
		});
		
		$(".btn-primary").on("click", function(){
			self.location="/user/main";
		});
		
		
		
	});

	
	
</script>
     


<%@include file="../include/footer.jsp" %>