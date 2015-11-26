package com.footoss.basic.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.footoss.basic.constant.Constants;

public class PageModel<T>  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8729803408047949518L;
	
	private int currentPage;//当前页号
	private int totalRecords;//总记录数
	private int pageSize = Constants.PAGE_SIZE;//每页几条记录
	private int navSize  = Constants.PAGE_NAV_SIZE;//页面显示的页数
	private int totalPages;//总页数
	private int startRecord;//开始记录号
	private int endRecord;//结束记录号
	private String sort;//排序子段
	private String order;//升序或降序
	
	private Map<String , Object> queryParams ;//= new HashMap<>();//查询条件
	private List<T> rows;//查询结果
	
	/**
	 * expand
	 */
	private String url;//路径
	private int firstPage = 1;//首页
	private int lastPage;//尾页号
	private int prevPage;//前一页
	private int nextPage;//下一页
	private int navStartPage;//当前显示的起始页号
	private int navEndPage;//当前显示的结束页号
	
	
	public PageModel(){}
	
	public PageModel(int currentPage, int totalRecords, String sort, String order, 
			Map<String, Object> queryParams) {
		this(currentPage,totalRecords,Constants.PAGE_SIZE,Constants.PAGE_NAV_SIZE,sort,order,
				queryParams,null,null);
	}

	
	
	public PageModel(int currentPage, int totalRecords, int pageSize, String sort, String order,
			Map<String, Object> queryParams) {
		this(currentPage,totalRecords,pageSize,Constants.PAGE_NAV_SIZE,sort,order,
				queryParams,null,null);
	}



	public PageModel(int currentPage, int totalRecords, int pageSize, Map<String, Object> queryParams,List<T> rows) {
		this(currentPage,totalRecords,pageSize,Constants.PAGE_NAV_SIZE,"ID","DESC",
				queryParams,rows,null);
	}
	
	public PageModel(int currentPage, int totalRecords, int pageSize, Map<String, Object> queryParams) {
		this(currentPage,totalRecords,pageSize,Constants.PAGE_NAV_SIZE,"ID","DESC",
				queryParams,null,null);
	}


	public PageModel(int currentPage, int totalRecords, int pageSize, int navSize,
			String sort, String order, Map<String, Object> queryParams, List<T> rows,String url) {
		super();
		this.currentPage = currentPage;
		this.totalRecords = totalRecords;
		if(pageSize > 0)
			this.pageSize = pageSize;
		if(navSize > 0)
			this.navSize = navSize;
		
		this.sort = sort;
		this.order = order;
		this.queryParams = queryParams;
		this.rows = rows;
		
		this.url = url;
		
		init();
		initExpand();
	}
	
	public void validate() {
		if(pageSize < 1)		pageSize = Constants.PAGE_SIZE;	
		if(navSize < 1)			navSize = 5;
		if(currentPage < 1){	currentPage = 1;}
	}
	
	public void init(){
		totalPages		= totalRecords/pageSize;
		if(totalRecords % pageSize != 0) 	totalPages++;
//		if(currentPage == lastPage)         currentPage = lastPage = totalPages;
		if(currentPage > totalPages)		currentPage = totalPages;
		
		startRecord		= ((currentPage <= 0 ? 1 : currentPage)-1) * pageSize;
//		startRecord		= startRecord == 0 ? startRecord+1 : startRecord;
		startRecord		= Math.min(startRecord, totalRecords);
		endRecord		= Math.min(startRecord + pageSize -1, totalRecords);
	}
	
	public void initExpand(){
		
		lastPage = totalPages;
		nextPage = Math.min(currentPage + 1 ,lastPage);
		prevPage = Math.max(currentPage - 1, firstPage);
		
		navStartPage = Math.max(1, currentPage - navSize / 2);
		navEndPage = Math.min(navStartPage + navSize - 1, lastPage);
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getNavSize() {
		return navSize;
	}

	public void setNavSize(int navSize) {
		this.navSize = navSize;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getStartRecord() {
		return startRecord;
	}

	public void setStartRecord(int startRecord) {
		this.startRecord = startRecord;
	}

	public int getEndRecord() {
		return endRecord;
	}

	public void setEndRecord(int endRecord) {
		this.endRecord = endRecord;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public Map<String, Object> getQueryParams() {
		return queryParams;
	}

	public void setQueryParams(Map<String, Object> queryParams) {
		this.queryParams = queryParams;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getNavStartPage() {
		return navStartPage;
	}

	public void setNavStartPage(int navStartPage) {
		this.navStartPage = navStartPage;
	}

	public int getNavEndPage() {
		return navEndPage;
	}

	public void setNavEndPage(int navEndPage) {
		this.navEndPage = navEndPage;
	}
	
}
