package com.dongguk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dongguk.domain.SeminarVO;
import com.dongguk.mapper.SeminarMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j //pom.xml�뿉�꽌 <scope>�깭洹몃�� �깮�왂�빐�빞 鍮④컙以꾩씠 �뾾�뼱吏꾨떎
@Service //鍮꾩쫰�땲�뒪 �쁺�뿭�쓣 �떞�떦�븯�뒗 媛앹껜�엫�쓣 �몴�떆�븯湲� �쐞�빐 �궗�슜
@AllArgsConstructor
public class SeminarServiceImpl implements SeminarService {
	
	@Setter(onMethod_ = @Autowired)
	private SeminarMapper mapper;
	
	@Transactional
	@Override
	public List<SeminarVO> getList(SeminarVO seminar) {
		log.info("getSearchMaxNum.....");
		
		if(seminar.getTitle() == null || seminar.getTitle().equals("null")) seminar.setTitle("");
        if(seminar.getField() == null || seminar.getField().equals("null")) seminar.setField("");
        if(seminar.getArea() == null || seminar.getArea().equals("null")) seminar.setArea("");
        
		int currentPage = seminar.getPage();
		if(currentPage < 1) {
			currentPage = 1;
			seminar.setPage(1);
		}
		int lastNum = mapper.getSearchMaxNum(seminar);
		int listSize = 20;
		int startRow = lastNum - (listSize * (currentPage - 1)); 
        int endRow = startRow - listSize; // �떆�옉 �뿴 - 由ъ뒪�듃 �궗�씠利�
        // �쟾�젣 �뜲�씠�꽣 媛��닔媛� �븳 �럹�씠吏��떦 異쒕젰�븷 媛��닔蹂대떎 �옉�쓣 寃쎌슦 
        if (endRow <= 0) endRow = 0;
        
        seminar.setLastRow(lastNum);
        seminar.setStartRow(startRow);
        seminar.setEndRow(endRow);
        
        log.info("getList.........");
        List<SeminarVO> seminarList = mapper.getList(seminar);
        int addIndex = seminarList.size();
        System.out.println("\n\n " + addIndex + "\n\n\n");
        seminarList.add(addIndex, seminar); //�쟾泥� �뜲�씠�꽣 媛��닔瑜� controller�뿉�꽌 �궗�슜�븯湲� �쐞�븳 �렪踰�
		return seminarList;
	}

	@Transactional
	@Override
	public SeminarVO getSeminar(int num) {
		log.info("addRead......." + num);
		mapper.addRead(num);
		
		log.info("getSeminar......" + num);
		return mapper.getView(num);
	}

	@Transactional
	@Override
	public boolean registerSeminar(SeminarVO seminar) {
		log.info("getMaxNum......");
		int newNum = mapper.getMaxNum() + 1;
		seminar.setNum(newNum);
		
		log.info("register......" + seminar);
		return mapper.insert(seminar);
	}

	@Transactional
	@Override
	public boolean removeSeminar(int num) {
		boolean removeSeminar;
		
		log.info("remove......" + num);
		boolean delete = mapper.delete(num);
		
		log.info("updateNum......");
		boolean updateNum = mapper.updateNum(num);
		
		if(delete || updateNum) removeSeminar = true;
		else removeSeminar = false;
		
		return removeSeminar;
	}

	@Transactional
	@Override
	public boolean modifySeminar(SeminarVO seminar) {
		log.info("modify......." + seminar);
		return mapper.update(seminar);
	}
}