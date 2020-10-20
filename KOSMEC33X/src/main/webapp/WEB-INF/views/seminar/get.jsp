<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="../resources/css/view.css">
        <title>한국 중소기업 대상 교육 세미나 정보 검색 시스템 KOSMEC</title>
    </head>
    <body>
        <h1>한국 중소기업 대상 교육 세미나 정보 검색 시스템</h1>
        <h2>dongguk computer 정재환 2015211051</h2>
        <hr>
        
        <form name="getSeminar" action="remove" method=post>
        <div>
		  <h2>세미나 상세정보</h2>
		  
		  <p>
		  <label>제목</label>
		  <input type="text" value="${seminar.title}" size="80" disabled>
		  </p>
		  
		  <p>
		  <label>분야</label>
		  <input  type="text" value="${seminar.field}" size="15" disabled>
		  </p>
		  
		  <p>
		    <label>세미나 번호</label>
		    <input type="number" name="num" value="${seminar.num}" size="12" readonly>
		    <label class="right">등록 날짜</label>
		    <input type="text" value="${seminar.register_date}" disabled>	  
		  </p>
		
		  <p>
		    <label>시작일</label>
		    <input type="text" value="${seminar.start_date}" disabled>
		    <label class="right2">종료일</label>
		    <input type="text" value="${seminar.stop_date}" disabled>
		  </p>
	
		  <p>
		  <label>개최 지역</label>
		  <input  type="text" value="${seminar.area}" size="15" disabled>
		  <label class="right3">출처</label>
		  <input  type="text" value="${seminar.source}" size="15" disabled>
		  </p>
		  
		  <p>
		  <label>최근 변경일</label>
		  <input  type="text" value="${seminar.update_date}" disabled>
		  <label class="right4">조회수</label>
		  <input  type="text" value="${seminar.read_Count}" size="15" disabled>
		  </p>
		  
		  <hr>
		  
		  <p>
		    <button><input type="submit" name="removeButten" value="삭제하기"></button>
		    <button><a href="modify_input?num=${seminar.num}">수정하기</a></button>
		  </p>
		</div>  
		</form>
    </body>
</html>