<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <title>한국 중소기업 대상 교육 세미나 정보 검색 시스템 KOSMEC</title>
        <SCRIPT language="JavaScript">
            function Check() <!--버튼을 클맀했을 때 실행되는 자바스크립트 함수-->
            {
                <!--공백이 입력되었을 경우 알림창을 나타내고 다시 입력하도록 한다-->
                if (modify.title.value.length < 1) {
                    alert("제목을 입력하세요.");
                    modify.title.focus();
                    return false;
                }

                if (modify.field.value.length < 1) {
                    alert("분야를 입력하세요.");
                    modify.field.focus();
                    return false;
                }
                
                if (modify.area.value.length < 1) {
                    alert("지역을 입력하세요.");
                    modify.area.focus();
                    return false;
                }
                
                if (modify.source.value.length < 1) {
                    alert("출처를 입력하세요.");
                    modify.source.focus();
                    return false;
                }
                
                if (modify.start_date.value.length < 1) {
                    alert("시작일을 입력하세요.");
                    modify.start_date.focus();
                    return false;
                }
                
                if (modify.stop_date.value.length < 1) {
                    alert("종료일을 입력하세요.");
                    modify.stop_date.focus();
                    return false;
                }
                <!--시작날짜가 종료날짜 보다 늦을 경우-->
                if(modify.start_date.value > modify.stop_date.value) {
                    alert("시작일과 종료일을 구분하세요");
                    modify.start_date.focus();
                    return false;
                }
            }
        </SCRIPT>
    </head>
    <body>     
        <h1>한국 중소기업 대상 세미나 정보 검색 시스템 KOSMEC</h1>
        <h2>dongguk computer 정재환 2015211051</h2>
        <hr>
        
        <div class="w3-card-4">
		  <div class="w3-container w3-brown">
		    <h2>세미나 수정</h2>
		  </div>
		  <form class="w3-container" name=modify action="modify" method=post OnSubmit='return Check()'>
		   <p>      
		    <label class="w3-text-brown"><b>번호</b></label>
		    <input class="w3-input w3-border w3-sand" type="text" name="num" value="${seminar.num}" readonly>
		    </p> 
		   <p>      
		    <label class="w3-text-brown"><b>제목</b></label>
		    <input class="w3-input w3-border w3-sand" type= "text" name="title" value="${seminar.title}" maxlength="100">
		    </p>
		    <p>      
		    <label class="w3-text-brown"><b>분야</b></label>
		    <input class="w3-input w3-border w3-sand" type="text" style="IME-MODE: active" name="field" value="${seminar.field}" maxlength="25">
		    </p>
		    <p>      
		    <label class="w3-text-brown"><b>지역</b></label>
		    <input class="w3-input w3-border w3-sand" type="text" style="IME-MODE: active" name="area" value="${seminar.area}" maxlength="25">
		    </p>
		    <p>      
		    <label class="w3-text-brown"><b>출처</b></label>
		    <input class="w3-input w3-border w3-sand" type="text" name="source" value="${seminar.source}" maxlength="25">
		    </p>
		    <p>      
		    <label class="w3-text-brown"><b>시작일</b></label>
		    <input class="w3-input w3-border w3-sand" type="date" name="start_date" value="${seminar.start_date}" min="2010-01-01" max="2036-12-30">
		    </p>
		    <p>      
		    <label class="w3-text-brown"><b>종료일</b></label>
		    <input class="w3-input w3-border w3-sand" type="date" name="stop_date" value="${seminar.stop_date}" min="2010-01-01" max="2036-12-30">
		    </p>
		    <p>      
		    <label class="w3-text-brown"><b>등록 날짜</b></label>
		    <input class="w3-input w3-border w3-sand" type="text" name="register_date" value="${seminar.register_date}" disabled>
		    </p>
		    <p>
		    <button class="w3-btn w3-brown"><input type="submit" name="update_button" value="저장"></button></p>
		  </form>
		</div>
    </body>
</html>