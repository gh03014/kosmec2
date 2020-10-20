package com.dongguk.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dongguk.domain.SeminarVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SeminarMapperTest {
	
	@Setter(onMethod_ = @Autowired)
	private SeminarMapper mapper;
	
	/*
	@Test
	public void testGetMaxNum() {
		int num = mapper.getMaxNum();
		System.out.println("최근 번호: " + num);
	}
	*/
	
	
	@Test
	public void testInsert() {
		int num = mapper.getMaxNum() + 1;
		
		SeminarVO seminar = new SeminarVO();
		seminar.setNum(num);
		seminar.setTitle("Junit - insert");
		seminar.setField("인력");
		seminar.setArea("서울");
		seminar.setSource("재환");
		seminar.setStart_date("2020-08-24");
		seminar.setStop_date("2020-08-25");
		
		if(mapper.insert(seminar))System.out.printf("insert 완료");
	}
	
	
	/*
	@Test
	public void testGetList() {
		SeminarVO seminar = new SeminarVO();
		String search_title = "";
		String search_field = "";
		String search_area = "";
		seminar.setTitle(search_title);
		seminar.setField(search_field);
		seminar.setArea(search_area);
		
		int maxNum = mapper.getSearchMaxNum(seminar);
		System.out.println("검색 데이터 수: " + maxNum);
		
		int listSize = 20;
		int currentPage = 1;
		int startRow = maxNum - (listSize * (currentPage - 1)); 
        int endRow = startRow - listSize; // 시작 열 - 리스트 사이즈
        // 전제 데이터 갯수가 한 페이지당 출력할 갯수보다 작을 경우 
        if (endRow <= 0) endRow = 1;
        String search = " where title like '%" + search_title + "%' and field like '%" 
                + search_field + "%' and area like '%" + search_area + "%'";
        String sql = "select a.* from (select rownum rn, b.* from (select * from seminar" + search 
                + " order by num) b where rownum <= " + startRow + ") a where rn > " + endRow 
                + " order by num desc"; 
        String sql2 = "select a.* from (select rownum rn, b.* from (select * from seminar where title like '%" 
                + search_title + "%' and field like '%" +search_field + "%' and area like '%" + search_area + "%'" 
                + " order by num) b where rownum <= " + startRow + ") a where rn > " + endRow 
                + " order by num desc";
        
        seminar.setStartRow(startRow);
        seminar.setEndRow(endRow);
        
        List<SeminarVO> list = mapper.getList(seminar);
        java.util.Iterator it = list.iterator();
        
        while (it.hasNext()) { //다음 행이 null값이 아닐 경우 계속 loop를 실행
            seminar = (SeminarVO) it.next();
            System.out.printf(seminar.getNum() + " ");
            System.out.printf(seminar.getTitle() + " ");
            System.out.printf(seminar.getField() + " ");
            System.out.printf(seminar.getRead_Count() + " ");
            System.out.printf(seminar.getStart_date() + " ");
            System.out.printf(seminar.getStop_date() + " ");
            System.out.printf(seminar.getRegister_date() + " ");
            System.out.println(seminar.getUpdate_date());
        }
	}
	*/
	
	@Test
	public void testGetView() {
		int seminarNum = 1381;
		SeminarVO seminar = mapper.getView(seminarNum);
		System.out.printf(seminar.getNum() + " ");
        System.out.printf(seminar.getTitle() + " ");
        System.out.printf(seminar.getField() + " ");
        System.out.printf(seminar.getRead_Count() + " ");
        System.out.printf(seminar.getStart_date() + " ");
        System.out.printf(seminar.getStop_date() + " ");
        System.out.printf(seminar.getRegister_date() + " ");
        System.out.println(seminar.getUpdate_date() + "\n");
        
        log.info(seminar);
        
        mapper.addRead(seminarNum);
	}
}
