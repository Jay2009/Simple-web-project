<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>


<%@include file="../include/header.jsp" %>
<center>
<br><br><br>Click "Complete" button after you write<br><br>
			
			<form method="post" name="frm" id="frm">
			<label for="username">Name</label>
			<input type="text"
			name ='username'  placeholder=" Name" required>
		
		
			<label for="birthdate">Birth Date</label>
			<input type ="text"  size="40"
			name ='birth'  placeholder="Birth ex) 1900/12/01" required>
		<br>
		<br>
	
			<label for="Id">Id</label>
			<input type="text" id="id" name ='id'  placeholder="put Email address " required>  
                  <button type="buttton" id="checkbtn" class="checkbtn" >ID check</button>
                  <div id="checkMsg"></div>
		<br>
		<br>
			<label for="Pw">Password</label>
			<input type="password" 
			name ='pw' id ="pw"   placeholder="password" required>
			
			
			<label for="Pwcheck">Password check</label>
			<input type="password"
			name ='pwcheck' id="pwcheck"  placeholder="password check" required  >
		<br>
		<br>	
			<label for="address1">Address1</label>
			<input type="text" size="50"
			name ='address1'  placeholder="1st address" required>
			
			
			<label for="address2">Address2</label>
			<input type="text" size="50"
			name ='address2'  placeholder="2nd address" required>
			<br>
			<br>
			
			
			<label for="address3">Address3</label>
			<input type="text" size="50"
			name ='address3'  placeholder="3rd address" required>
			<br>
			<br>
			
			<label for="Mobilenum">Mobile number</label>
			<input type="text" size="20"
			name ='mobilenum' placeholder="Phone# ex) 111-111-1111" required>
			
			
			<label for="email">Email</label>
			<input type="text" size="35"
			name ='email' placeholder="Email" required>
			<br><br>

			<button type = "submit" class="btn btn-primary">Complete</button>
			<button type = "submit" class="btn btn-warning">Cancel</button>
			</form>		
			
			</center>

 <script type="text/javascript">
    $(document).ready(function(){
    	var checkcompl = 0;
    	var formObj = $("form[role='form']");
    	console.log(formObj);
    	var ch = $('#checkbtn');
    	console.log(ch);

    	$(".btn-warning").on("click", function(){
			self.location="/user/login.do";
		});
    	
    	
    	 $(".btn-primary").on("click", function(e){
    	 	var a = document.getElementById('pw').value;
    		var b = document.getElementById('pwcheck').value;
    	
    		if( a == b){
    			formObj.submit();
    		 }else {
    			alert("The password is not matched!!");
    			 e.preventDefault();
    		}// if-else	 
    	});  //end on
    
    	
        $('#checkbtn').on('click', function(e){
        	var id = document.getElementById('id').value;
        	console.log(id);
            $.ajax({
                type: 'POST',
                url: 'checkSignup',
                data: {
                	"id" : id
                },
                success: function(data){
                    if($.trim(data)==0){
                        alert("Available");
                        e.preventDefault();
                        checkcompl = 1;
                        console.log(id);
                    	
                    }
                    else{
                    	alert("Alerady in use");
                    	e.preventDefault();
//                     	data.stopImmediatepropagation()
                    } // end if-else
                }// end function
            });    //end ajax    
        });    //end on    
    });
    </script>	
		

<%@include file="../include/footer.jsp" %>