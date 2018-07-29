<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<%@include file="../include/header.jsp"%>
<br>

<h4 style="color:blue">
Mobile  : 647-936-5340<br>
E-mail  : jaem2009@naver.com<br>
</h4>

<!DOCTYPE html>
<html>
  <head>
    <style>
      #map {
        height: 400px;
        width: 100%;
       }
    </style>
  </head>
  <body>
    <h3>Customer service centre location below</h3> 
    (test location)
    <div id="map"></div>
    <script>
      function initMap() {
        var uluru = {lat: 43.6535736, lng: -79.3811992};
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 15,
          center: uluru
        });
        var marker = new google.maps.Marker({
          position: uluru,
          map: map
        });
      }
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCKO6LNfaPvcclnLz2Xnmgd9DBa2sppKK4&callback=initMap">
    </script>
    
    
    
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