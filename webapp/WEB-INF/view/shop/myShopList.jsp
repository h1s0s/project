<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>펫시터 수정</title>
	<!-- CSS -->
	<link href="${pageContext.request.contextPath}/assets/bootstrap/css/bootstrap.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/assets/css/myShopList.css" rel="stylesheet" type="text/css" />
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
	
	<!-- JS -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap.js"></script>
</head>

<body>
	<c:import url="/WEB-INF/view/includes/header.jsp"></c:import>
	<div id="wrap">
		<div id="container" class="clearfix">
			<c:import url="/WEB-INF/view/includes/aside.jsp"></c:import>
			<div id="content">
				<div id="content-head" >
					<div id="location" class="clearfix">
						<ul>
							<li>마이페이지</li>
							<li>내 쇼핑</li>
							<li class="last">상품 주문내역</li>
						</ul>
					</div>
					<h1>상품 주문내역</h1>
				</div><!-- //content-head -->
				<div id="content-main">
					<div id="itemhistory">
						<table class="table" style="border-bottom:1px solid #EEE;">
						     <colgroup>
	                            <col width="100px">
	                            <col width="140px">
	                            <col width="140px">
	                            <col width="70px">
	                            <col width="70px">
	                            <col width="70px">
	                            <col width="70px">
	                        </colgroup>
							<tr style="background-color:#EEE">
								<th class="text-center">주문번호</th>
								<th class="text-center">주문일자</th>
								<th class="text-center">상품정보</th>
								<th class="text-center">수량</th>
								<th class="text-center">배송상태</th>
								<th class="text-center">가격</th>
							</tr>
							<tr style="height:100px;">
								<td class="text-center">2022032101</td>
								<td class="text-center">2022-03-12</td>
								<td>허브페스토</td>
								<td class="text-center">1개</td>
								<td class="text-center">배송완료</td>
								<td class="text-center">65,000원</td>
							</tr>
							<tr style="height:100px;">
								<td class="text-center">2022032101</td>
								<td class="text-center">2022-03-12</td>
								<td>허브페스토</td>
								<td class="text-center">1개</td>
								<td class="text-center">배송완료</td>
								<td class="text-center">65,000원</td>
							</tr>
						</table>
					</div>
				</div><!-- //content-main -->
			</div><!-- //content -->
		</div><!-- //container -->
	</div><!-- //wrap -->
	<c:import url="/WEB-INF/view/includes/footer.jsp"></c:import>
<script>
</script>
</body>
</html>