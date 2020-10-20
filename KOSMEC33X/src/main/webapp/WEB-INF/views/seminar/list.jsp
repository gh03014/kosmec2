<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% request.setCharacterEncoding("utf-8"); %> <!-- 파라미터 인코딩 -->
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<!-- 초기 화면 확대 비율 설정 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>한국 중소기업 대상 교육 세미나 정보 검색 시스템 KOSMEC</title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="../resources/css/list.css">
</head>
<body>
    <!-- Sidebar -->
	<div class="w3-sidebar w3-bar-block w3-border-right" style="display:none" id="mySidebar">
	  <button onclick="w3_close()" class="w3-bar-item w3-large">Close &times;</button>
	  <a href="list" class="w3-bar-item w3-button">목록으로</a>
	  <a href="search" class="w3-bar-item w3-button">통합검색</a>
	  <a href="register_input" class="w3-bar-item w3-button">세미나 등록</a>
	</div>
	
	<!-- Page Content -->
	<div class="w3-teal">
	  <button class="w3-button w3-teal w3-xlarge" onclick="w3_open()">메뉴탭</button>
	  <div class="w3-container">
	    <h1>한국 중소기업 대상 교육 세미나 정보 검색 시스템 KOSMEC</h1>
	    <h2>dongguk 정재환 2015211051</h2>
	  </div>
	</div>
	
    <hr>
    
    <div>
    <table id="data"> <!-- 박스 -->
        <tr> <!-- 가로단(행) -->
            <th class="num">번호</th> <!-- 세로단 -->
            <th class="field">분야</th>
            <th class="title">제목</th>
            <th class="startDate">시작일</th>
            <th class="readCount">조회수</th>
        </tr>

		<c:forEach items="${list}" var="seminar">
        <tr>
            <td class="num"><c:out value="${seminar.num}"></c:out></td> <!-- 변수 값을 출력 -->
            <td class="field"><c:out value="${seminar.field}"></c:out></td>
            <td class="title"><a href="get?num=${seminar.num}"><c:out value="${seminar.title}"></c:out></a></td>
            <td class="startDate"><c:out value="${seminar.start_date}"></c:out></td>
            <td class="readCount"><c:out value="${seminar.read_Count}"></c:out></td>
        </tr>
        </c:forEach>
    </table>
	</div>
	
    <hr>
    
    <div class="w3-bar">
    <table> <!-- 페이징 처리 -->
        <a href="list?page=1&title=<%=request.getParameter("title")%>&field=<%=request.getParameter("field")%>&area=<%=request.getParameter("area")%>" class="w3-button">[<<]</a>
        
        <c:if test="${pageMaker.prev}">
        <a href="list?page=${pageMaker.previousPage}&title=<%=request.getParameter("title")%>&field=<%=request.getParameter("field")%>&area=<%=request.getParameter("area")%>" class="w3-button">[<]</a>
        </c:if>
        
        <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
        	<a href="list?page=${num}&title=<%=request.getParameter("title")%>&field=<%=request.getParameter("field")%>&area=<%=request.getParameter("area")%>" class="w3-button">${num}</a>
        </c:forEach>
        
        <c:if test="${pageMaker.next}">
        <a href="list?page=${pageMaker.nextPage}&title=<%=request.getParameter("title")%>&field=<%=request.getParameter("field")%>&area=<%=request.getParameter("area")%>" class="w3-button">[>]</a>
        </c:if>
        
        <a href="list?page=${pageMaker.lastPage}&title=<%=request.getParameter("title")%>&field=<%=request.getParameter("field")%>&area=<%=request.getParameter("area")%>" class="w3-button">[>>]</a>
    </table>
    </div>
    
    <script> //특정 태그를 클릭했을 때 상태 확인, 변경 수행
		function w3_open() {
		  document.getElementById("mySidebar").style.display = "block";
		}
		
		function w3_close() {
		  document.getElementById("mySidebar").style.display = "none";
		}
	</script>
</body>
</html>