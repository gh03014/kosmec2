package com.dongguk.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.dongguk.domain.SeminarVO;

public interface SeminarMapper {
	public int getSearchMaxNum(SeminarVO seminar);
	//@Select("select * from seminar where num > 1350")
	public List<SeminarVO> getList(SeminarVO seminar);
	
	public SeminarVO getView(int num);
	
	public void addRead(int num);
	
	public int getMaxNum();
	
	public boolean insert(SeminarVO seminar);
	
	public boolean delete(int num);
	
	public boolean updateNum(int num);
	
	public boolean update(SeminarVO seminar);
}
