package com.dongguk.domain;

import lombok.Data;

@Data
public class SeminarVO {
	private int num, read_Count, page, startRow, endRow, lastRow; //int 타입의 식별자 num을 선언하여 메모리주소를 할당한다
	private String field, area, title, source, start_date, stop_date, register_date, update_date;
}
