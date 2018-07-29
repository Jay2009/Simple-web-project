<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@include file="../include/header.jsp"%>

<h3>Game </h3>
<br><br>

  <c:if test="${username != null}" > 
   <br>
    <h4 style="color:black">&emsp;&emsp; Hello!!!  ${username} </h4>
  
    &emsp;&emsp;&nbsp;&nbsp; <a href="${path}/user/mypage" style="color:blue;">My page</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="${path}/user/logout.do" style="color:orange;">Sign out</a>
    </c:if>
 
    <c:if test="${username == null}" > 
    <h3> <a href="${path}/user/login.do" style="color:lightgreen;">Sign in</a> </h3>
    </c:if>
    
<center>
 <h3><a href="${path}/user/main " style="color:green;">Home</a></h3><br>
 
 &emsp;&emsp;&emsp; <h5 style="color:grey"> $Event time$  <br>(you have unlimited chance to win free points only from 10:00pm to 10:05pm )</h3>
 <br><br>

<h3 style="color:blue">Pandora Box</h3>
<br>
<h4 style="color:skyblue">If it is your first play, you have "3times" to win 100points</h4>
<br>

<form id="hello">
	<input type="hidden" name="btn1" value="nothing">
	<input type="button" name="submitbtn" value="click" style="width:60pt;height:60pt;" class="btn-info">
		
	<input type="hidden" name="btn1" value="nothing">
	<input type="button" name="submitbtn" value="click" style="width:60pt;height:60pt;" class="btn-info">
	
	<input type="hidden" name="btn1" value="nothing">
	<input type="button" name="submitbtn" value="click" style="width:60pt;height:60pt;" class="btn-info"> <br>
	
	<input type="hidden" name="btn1" value="nothing">
	<input type="button" name="submitbtn" value="click" style="width:60pt;height:60pt;" class="btn-info">
	
	<input type="hidden" name="btn1" value="nothing">
	<input type="button" name="submitbtn" value="click" style="width:60pt;height:60pt;" class="btn-info">
	
	<input type="hidden" name="btn1" value="nothing">
	<input type="button" name="submitbtn" value="click" style="width:60pt;height:60pt;" class="btn-info"> <br>
	
	<input type="hidden" name="btn1" value="nothing">
	<input type="button" name="submitbtn" value="click" style="width:60pt;height:60pt;" class="btn-info">
	
	<input type="hidden" name="btn1" value="nothing">
	<input type="button" name="submitbtn" value="click" style="width:60pt;height:60pt;" class="btn-info">
	
	<input type="hidden" name="btn1" value="nothing">
	<input type="button" name="submitbtn" value="click" style="width:60pt;height:60pt;" class="btn-info"> <br>
</form>

<br>


</center>
<br><br><br>

<br><br><br><br><br>


<script type="text/javascript">

var username = "${username}";

var dt = new Date();
var day = dt.getDate();

console.log("now DATE", day);
var overtoday = '${overtoday}';


$(document).ready(function () {
	
	var formObj = $("#hello");
	console.log("\t****1: " + formObj);
// 	formObj.submit();
	
	var btn1Val = $("#btn1").val();
	console.log("qjxmsaldjadjl;kdfj",btn1Val);
	console.log("\t****2: "+ formObj);
	
	var timecheck = 0;// max chances

	$(".btn-info").on("click", function(e){
		console.log("\t****3: "+ formObj);
		
		if(overtoday >= 3){
			alert("Event is over today Try again tomorrow at 10:00pm ");
			e.preventDefault();
		}else{
			
		
		
		console.log("username",username);
		if(username != ""){
		var a = 1;
    	var iValue = Math.random(); // generate nummbers from 0 to 1
		iValue *= 10; //in order to get numbers from 1 to 20, multipuly by 20
		iValue = Math.floor(iValue); // round up the decimal number.
		console.log("iValueiValue",iValue);
		//change to 1 if number 0 comes out. 
			if(iValue < 1){
				iValue = 1; 	
	   		 }//if	

			console.log(iValue);
			console.log('timecheck::'+timecheck);
				if(iValue == a ){
					console.log("\t****4: "+ formObj);
					
					timecheck++;
					
					if(timecheck  >= 3){
						console.log("\t****5: "+ formObj);
						
						console.log(btn1Val);
						formObj.attr("method", "post");
						formObj.attr("action", "/user/gameover");					
						formObj.submit();
						
					}else{
						console.log("\t****6: "+ formObj);
						
						formObj.attr("method", "get");
						formObj.attr("action", "/user/congratulations");
						formObj.submit();
						
					} //if else timecheck in if 
					
					
				}else{
					console.log("\t****7: "+ formObj);
				
					timecheck++;
					
					if(timecheck  >= 3 ){
						console.log("\t****8: "+ formObj);
						formObj.attr("method", "post");
						formObj.attr("action", "/user/gameover");
						formObj.submit();
					}else{
						console.log("\t****9: "+ formObj);
						alert("sorry :p nothing here");
					}
				
				
				}// if else

		}else{
			console.log("\t****10: "+ formObj);
			
			alert("need sign in to play");
		}//if else
			
	
		}//else ( working part! )
	
	}); // onclick
	
	
	console.log("\t****77: "+ formObj);

	
}); //ready function

</script>


			
			




<%@include file="../include/footer.jsp"%>