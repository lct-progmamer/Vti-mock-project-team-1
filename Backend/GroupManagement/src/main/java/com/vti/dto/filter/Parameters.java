package com.vti.dto.filter;

public class Parameters {

	private int pageSize;
	
	private int page;
	
	private String search;
	
	private String typeSort;
	
	private String fieldSort;
	
	private int maxId;
	
	private int minId;

	public Parameters() {
		super();
	}

	public Parameters(int pageSize, int page, String search, String typeSort, String fieldSort, int maxId, int minId) {
		super();
		this.pageSize = pageSize;
		this.page = page;
		this.search = search;
		this.typeSort = typeSort;
		this.fieldSort = fieldSort;
		this.maxId = maxId;
		this.minId = minId;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getTypeSort() {
		return typeSort;
	}

	public void setTypeSort(String typeSort) {
		this.typeSort = typeSort;
	}

	public String getFieldSort() {
		return fieldSort;
	}

	public void setFieldSort(String fieldSort) {
		this.fieldSort = fieldSort;
	}

	public int getMaxId() {
		return maxId;
	}

	public void setMaxId(int maxId) {
		this.maxId = maxId;
	}

	public int getMinId() {
		return minId;
	}

	public void setMinId(int minId) {
		this.minId = minId;
	}
	
	
	
	
	
}
