<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<%@include file="../include/header.jsp"%>

     

<form action="/user/loginPost" method="post">

			
		


  <div class="form-group has-feedback">
   ID <input type="text" name="uid" class="form-control" size="40"   placeholder="Email"/>
  </div>
  
  <div class="form-group has-feedback">
   PASSWORD <input type="password" name="upw" class="form-control"  size = "40" placeholder="Password"/>
  </div>
  
   <tb> <button type="submit" size = "20" class="btn btn-primary btn-block btn-flat">Sign In</button> 

</form>


      <a href="#">I forgot my password</a><br>


<!--     <script>
      $(function () {
        $('input').iCheck({
          checkboxClass: 'icheckbox_square-blue',
          radioClass: 'iradio_square-blue',
          increaseArea: '20%' // optional
        });
      });
    </script> -->





<!-- create account button -->
<div class="box-footer" style="text-align:center;">
 <button type="submit" class="btn btn-create">Create a new account</button> 
</div>


<script>
	$(document).ready(function(){
		var formObj = $("form[role='form']");
		console.log(formObj);
		
		$(".btn-create").on("click", function(){
			self.location="/user/register";
		});
	});

	
	
</script>



<%@include file="../include/footer.jsp"%>
