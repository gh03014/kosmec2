package com.dongguk.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dongguk.domain.PageDTO;
import com.dongguk.domain.SeminarVO;
import com.dongguk.mapper.SeminarMapper;
import com.dongguk.service.SeminarService;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j
@RequestMapping("/seminar/*")
@AllArgsConstructor //SeminarService�뿉 �쓽議댁쟻�씠誘�濡� �깮�꽦�옄瑜� 留뚮뱾怨� �옄�룞�쑝濡� 二쇱엯
public class SeminarController {
	
	private SeminarService service;
	
	@GetMapping("/list")
	public void list(SeminarVO seminar, Model model) {
		log.info("list");
		
		List<SeminarVO> seminarList = service.getList(seminar);
		int index = seminarList.size() - 1;
		SeminarVO seminar2 = seminarList.get(index);
		PageDTO pageDTO = new PageDTO(seminar2.getLastRow(), seminar.getPage());
		seminarList.remove(index); // �씠�젣 �븘�슂 �뾾�쑝誘�濡� �떎�떆 �궘�젣
		System.out.println("\n\n" + pageDTO);
		
		model.addAttribute("list", seminarList);
		model.addAttribute("pageMaker", pageDTO);
	}
	
	@RequestMapping("/search")
	public String search() {
		return "/seminar/search";
	}
	
	@GetMapping("/get")
	public void get(SeminarVO seminar, Model model) {
		log.info("getSeminar");
		
		model.addAttribute("seminar", service.getSeminar(seminar.getNum()));
	}
	
	@RequestMapping("/register_input")
	public String register_input() {
		return "/seminar/register_input";
	}
	
	@PostMapping("/register")
	public String register(SeminarVO seminar, RedirectAttributes rttr) {
		log.info("registerSeminar: " + seminar);
		
		service.registerSeminar(seminar);
		rttr.addFlashAttribute("result", seminar.getNum());
		
		return "redirect:/seminar/list";
	}
	
	@PostMapping("/remove")
	public String remove(SeminarVO seminar, RedirectAttributes rttr) {
		log.info("removeSeminar: " + seminar);
		
		service.removeSeminar(seminar.getNum());
		
		return "redirect:/seminar/list";
	}
	
	@GetMapping("/modify_input")
	public void modify_input(SeminarVO seminar, Model model) {
		log.info("Modify_Input: " + seminar);
		
		model.addAttribute("seminar", service.getSeminar(seminar.getNum()));
	}
	
	@PostMapping("/modify")
	public String modify(SeminarVO seminar, RedirectAttributes rttr) {
		log.info("modifySeminar: " + seminar);
		
		service.modifySeminar(seminar);
		
		return "redirect:/seminar/list";
	}
}

