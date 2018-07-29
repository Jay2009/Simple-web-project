<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<%@include file="../include/header.jsp"%>
<c:if test="${username != null}" > 
<h4 style="color:skyblue">Hello!!!  ${username} </h4>
  
     <a href="${path}/user/mypage" style="color:blue;">My page</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <a href="${path}/user/logout.do" style="color:orange;">Sign out</a>
     </c:if>
       <c:if test="${username == null}" > 
    <h3> <a href="${path}/user/login.do" style="color:lightgreen;">Sign in</a> </h3>
    <br>
    </c:if>
     <br>
     <img src="/resources/roomrentals.gif" style="width:128px;height:100px;">
     <center>
 <h3> <a href="${path}/user/main " style="color:green;">Home</a></h3>
  </center>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->


		<div class="col-md-12">
			<!-- general form elements -->
			<div class='box'>
				<div class="box-header with-border">
					<h3 class="box-title">Board List</h3>
				</div>


				<div class='box-body'>

					<select name="searchType">
						<option value="n"
							<c:out value="${projectcri.searchType == null?'selected':''}"/>>
							---</option>
						<option value="t"
							<c:out value="${projectcri.searchType eq 't'?'selected':''}"/>>
							Title</option>
						<option value="p"
							<c:out value="${projectcri.searchType eq 'p'?'selected':''}"/>>
							Price</option>
						<option value="r"
							<c:out value="${projectcri.searchType eq 'r'?'selected':''}"/>>
							Region</option>
						<option value="c"
							<c:out value="${projectcri.searchType eq 'c'?'selected':''}"/>>
							Content</option>
						<option value="w"
							<c:out value="${projectcri.searchType eq 'w'?'selected':''}"/>>
							Writer</option>
						<option value="tc"
							<c:out value="${projectcri.searchType eq 'tc'?'selected':''}"/>>
							Title OR Content</option>
						<option value="cw"
							<c:out value="${projectcri.searchType eq 'cw'?'selected':''}"/>>
							Content OR Writer</option>
						<option value="tcw"
							<c:out value="${projectcri.searchType eq 'tcw'?'selected':''}"/>>
							Title OR Content OR Writer</option>
					</select> <input type="text" name='keyword' id="keywordInput"
						value='${projectcri.keyword }'>
					<button id='searchBtn'>Search</button>
			<span style="float:right">
					<button id='newBtn'>Register house</button>
			</span>
				</div>
			</div>




			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">LIST PAGING</h3>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr>
							<th style="width: 10px">BNO</th>
							<th>TITLE</th>
							<th>PRICE</th>
							<th>REGION</th>
							<th>WRITER</th>
							<th>REGDATE</th>
							
							<th style="width: 40px">VIEWCNT</th>
						</tr>

						<c:forEach items="${projectlist}" var="projectVO">

							<tr>
								<td>${projectVO.bno}</td>
								<td>
						
								<a
									href='/projectboard/readPage${projectpageMaker.makeSearch(projectpageMaker.cri.page) }&bno=${projectVO.bno}'>
									<c:if test="${id == projectVO.writer}"><strong style="color:blue"></c:if>	${projectVO.title}  <strong>[ ${projectVO.replycnt} ] </strong> </a></td>
								<td>$ ${projectVO.price} </td>
								<td>${projectVO.region} </td>
								<td> <c:if test="${id == projectVO.writer}"><strong style="color:blue"></c:if>   ${projectVO.writer}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
										value="${projectVO.regdate}" /></td>
								<td><span class="badge bg-red">${projectVO.viewcnt }</span></td>
							</tr>

						</c:forEach>

					</table>
				</div>
				<!-- /.box-body -->


				<div class="box-footer">

					<div class="text-center">
						<ul class="pagination">

							<c:if test="${projectpageMaker.prev}">
								<li><a
									href="projectlist${projectpageMaker.makeSearch(projectpageMaker.startPage - 1) }">&laquo;</a></li>
							</c:if>

							<c:forEach begin="${projectpageMaker.startPage }"
								end="${projectpageMaker.endPage }" var="idx">
								<li
									<c:out value="${projectpageMaker.cri.page == idx?'class =active':''}"/>>
									<a href="projectlist${projectpageMaker.makeSearch(idx)}">${idx}</a>
								</li>
							</c:forEach>

							<c:if test="${projectpageMaker.next && projectpageMaker.endPage > 0}">
								<li><a
									href="projectlist${projectpageMaker.makeSearch(projectpageMaker.endPage +1) }">&raquo;</a></li>
							</c:if>

						</ul>
					</div>

				</div>
				<!-- /.box-footer-->
			</div>
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->


<script>
	var a = '${projectlist}';
	console.log("projectlist ::",a);
	var result = '${msg}';


</script>

<script>
var name = '${username}';
console.log("username in javascript ::",name);
	$(document).ready(
			function() {

				$('#searchBtn').on(
						"click",
						function(event) {

							self.location = "projectlist"
									+ '${projectpageMaker.makeQuery(1)}'
									+ "&searchType="
									+ $("select option:selected").val()
									+ "&keyword=" + $('#keywordInput').val();

						});

				$('#newBtn').on("click", function(evt) {
					if(name != ''){
					self.location = "register";
					}
					else{ 
						evt.preventDefault();
						}
				});

			});
</script>


<%@include file="../include/footer.jsp"%>
