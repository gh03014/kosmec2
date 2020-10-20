package com.dongguk.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration //servlet의 servletContext를 이용, 스프링에서는 WebApplication이라는 존재를 이용
@ContextConfiguration({"file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml", 
                       "file:src\\main\\webapp\\WEB-INF\\spring\\appServlet\\servlet-context.xml"})
@Log4j
public class SeminarControllerTests {
	
	@Setter(onMethod_ = @Autowired)
	private WebApplicationContext ctx; //was를 사용하지 않고 테스트하기 위해 사용
	
	private MockMvc mockMvc; //가짜 mvc, controller 기능을 테스트하기 위해 사용
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	
	@Test
	public void testGetList() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/seminar/list")
				//.param("page", "0")
				.param("title", "")
				.param("field", "")
				.param("area", ""))
				.andReturn().getModelAndView().getModelMap());
	}
	
	
	/*
	@Test
	public void testRegisterSeminar() throws Exception {
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/seminar/register")
				.param("title", "mockMVC")
				.param("field", "경영")
				.param("area", "경북")
				.param("source", "coding")
				.param("start_date", "2020-09-05")
				.param("stop_date", "2020-09-06"))
				.andReturn().getModelAndView().getViewName();
		
		log.info(resultPage);
	}
	*/
}