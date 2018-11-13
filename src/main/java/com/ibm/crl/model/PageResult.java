package com.ibm.crl.model;

import java.util.List;

public class PageResult<T> {
	// 当前页码
	private int page = 1;
	// 总页数
	private int total;
	// 数据总条数
	private int records;
	//每页条数
	private int rows = 10;
	// 返回页面数据
	private List<T> list;
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRecords() {
		return records;
	}

	public void setRecords(int records) {
		this.records = records;
		pageMake();
	}


	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public void setDbStartNo(int dbStartNo) {
		this.dbStartNo = dbStartNo;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	// DB数据的开始行号
	private int dbStartNo;

	public int getDbStartNo() {
		return dbStartNo;
	}
	private void pageMake(){
	this.dbStartNo=(page - 1) * rows;
	}
}