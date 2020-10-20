package com.dongguk.domain;

import lombok.Data;

@Data
public class Criteria {
	private int page, startRow, endRow, lastRow;
	private String field, area, title;
}
