package com.dongguk.domain;

import lombok.Data;

@Data
public class PageDTO {
	private int lastRow, page, startPage, endPage, lastPage, previousPage, nextPage, windowSize, listSize;
	boolean prev, next;
	
	public PageDTO(int lastRow, int page) {
		this.lastRow = lastRow;
		this.page = page;
		this.windowSize = 10;
		this.listSize = 20;
		this.startPage = ((page - 1) / 10) * 10 + 1;
		this.endPage = startPage + 9;
		
		if(lastRow % listSize == 0) this.lastPage = lastRow / listSize;
		else this.lastPage = lastRow / listSize + 1;
		
		if(page > 10) this.previousPage = endPage - windowSize;
		else this.previousPage = 1;
		
		if(lastPage > endPage) this.nextPage = startPage + windowSize;
		else this.nextPage = lastPage;
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < this.lastPage;
	}
}
