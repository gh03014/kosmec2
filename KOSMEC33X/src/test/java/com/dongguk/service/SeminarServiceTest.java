package com.dongguk.service;

import static org.junit.Assert.assertNotNull;

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
public class SeminarServiceTest {
	@Setter(onMethod_ = @Autowired)
	private SeminarService service;
	
	/*
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	*/
	
	/*
	@Test
	public void testExist() {
		SeminarVO seminar = new SeminarVO();
		String search_title = "臾댁뿭";
		String search_field = "�닔異�";
		String search_area = "";
		int currentPage = 2;
		seminar.setTitle(search_title);
		seminar.setField(search_field);
		seminar.setArea(search_area);
		seminar.setPage(currentPage);
		
		List<SeminarVO> list = service.getList(seminar);
        java.util.Iterator it = list.iterator();
        
        while (it.hasNext()) { //�떎�쓬 �뻾�씠 null媛믪씠 �븘�땺 寃쎌슦 怨꾩냽 loop瑜� �떎�뻾
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
	
	/*
	@Test
	public void testGetSeminar() {
		int seminarNum = 1385;
		SeminarVO seminar = service.getSeminar(seminarNum);
		System.out.printf(seminar.getNum() + " ");
        System.out.printf(seminar.getTitle() + " ");
        System.out.printf(seminar.getField() + " ");
        System.out.printf(seminar.getRead_Count() + " ");
        System.out.printf(seminar.getStart_date() + " ");
        System.out.printf(seminar.getStop_date() + " ");
        System.out.printf(seminar.getRegister_date() + " ");
        System.out.println(seminar.getUpdate_date() + "\n");
        
        log.info(seminar);
	}
	*/
	
	/*
	@Test
	public void testRegister() {
		SeminarVO seminar = new SeminarVO();
		seminar.setTitle("serviceImpl2");
		seminar.setField("李쎌뾽");
		seminar.setArea("�꽌�슱");
		seminar.setSource("�옱�솚");
		seminar.setStart_date("2020-08-24");
		seminar.setStop_date("2020-08-25");
		
		if(service.registerSeminar(seminar)) System.out.printf("insert �셿猷�\n");
	}
	*/
	
	/*
	@Test
	public void testRemoveSeminar() {
		int seminarNum = 1385;
		if(service.removeSeminar(seminarNum)) System.out.printf("delete �셿猷�\n");
	}
	*/
	
	/*
	@Test
	public void testModifySeminar() {
		SeminarVO seminar = new SeminarVO();
		seminar.setNum(1384);
		seminar.setTitle("serviceImpl3");
		seminar.setField("湲곗닠");
		seminar.setArea("�꽌�슱");
		seminar.setSource("�옱�솚");
		seminar.setStart_date("2020-08-21");
		seminar.setStop_date("2020-08-25");
		
		if(service.modifySeminar(seminar)) System.out.printf("update �셿猷�\n");
	}
	*/
}
