package com.dongguk.service;

import java.util.List;
import com.dongguk.domain.SeminarVO;

//인터페이스를 통해 로직, 트랜잭션 코드 분리
public interface SeminarService {
	
    public List<SeminarVO> getList(SeminarVO seminar);
    
    public SeminarVO getSeminar(int num);
    
    public boolean registerSeminar(SeminarVO seminar);
    
    public boolean removeSeminar(int seminarNum);
    
    public boolean modifySeminar(SeminarVO seminar);
}