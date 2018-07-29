<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<%@include file="../include/header.jsp"%>



<title>login</title>
<script>
    $(document).ready(function(){
        $("#btnLogin").click(function(){
            // 태크.val() : 태그에 입력된 값
            // 태크.val("값") : 태그의 값을 변경 
            var id = $("#id").val();
            var pw = $("#pw").val();
            if(id == ""){
                alert("put ID!!");
                $("#id").focus(); // 입력포커스 이동
                return; // 함수 종료
            }
            if(pw == ""){
                alert("Put password!!");
                $("#pw").focus();
                return;
            }
            // 폼 내부의 데이터를 전송할 주소
            document.form1.action="${path}/user/loginCheck.do"
            // 제출
            document.form1.submit();
            
          
        });
    });
</script>

<br><br>
<br>
<center>
<h2>Log in</h2>
    <form name="form1" method="post">
        <table border="1" width="400px">
            <tr>
                <td>ID</td>
                <td><input name="id" id="id"></td>
            </tr>
            <tr>
                <td>PASSWORD</td>
                <td><input type="password" name="pw" id="pw"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="button" id="btnLogin">Sign in</button>
                <c:if test="${msg == 'failure'}">
                    <div style="color: red">
                        ID or Password is incorrect!!
                    </div>
  				</c:if>
                    
                
                </td>
            </tr>
        </table>
    </form>
    </center>
    <br><br>
    
</body>
</html>


<center>
 <button type="submit" class="visit">Visit without login</button> 
</center>
<br><br>

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
		
		$(".visit").on("click", function(){
			self.location="/user/main";
		});
		
		
		
	});
</script>

<script>
if (${msg == 'logout'}){
	alert("signed out !");
}
</script>


<%@include file="../include/footer.jsp"%>
