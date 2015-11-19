package com.hybrid.util;

public class Pagination {
	/*
	 * read-write
	 */
	private int totalItem;  // select count(*) from city
	private int pageNo;		// request Parameter pageNo
	
	/*
	 * read-only
	 */
	private int totalPage;
	private int firstItem;
	private int lastItem;
	private int firsPage;
	private int lastPage;
	/*
	 * read-write
	 */
	private int itemsPerPage = 10;
	private int pagesPerGroup = 10;
	
	public void calculate(){
		/*
		 * pageNo validation
		 */
		if(pageNo < 1)
		   pageNo = 1;
		
		/*
		 * totalPage
		 */
		//4079 / 10 = 407
		//4079 / 10 = 407 + 1 = 408
		totalPage = totalItem / itemsPerPage;
		if(totalItem % itemsPerPage > 0)
			totalPage++;
		
		/*
		 * pageNo validation
		 */
		
		if(pageNo > totalPage)
		   pageNo = (totalPage ==0) ? 1 : totalPage;
		
		 
		
		/*
		 * firsItem
		 */
		//(1 - 1) * 10 + 1 = 1				=> 1
		//(5 - 1) * 10 + 1  = 41            => 41
		firstItem = (pageNo-1) * itemsPerPage+1;
		
		/*
		 * lastItem
		 */
		//fistItem = 4071
		//lastItem = 4079
		//4071 + 4079 + 10 - 1 = 4080
		lastItem = firstItem + itemsPerPage -1;
			if(lastItem > totalItem)
			   lastItem = totalItem;
			
		/*
		 * firsPage
		 */
		//pageNo = 5  ==> firsPage = 1
		//(5 - 1 ) / 10*10 + 1 = 1
		//(16 - 1) / 10*10 + 1 = 11
		//(408 - 1) / 10*10 + 1 = 401
		firsPage = (pageNo - 1) / pagesPerGroup * pagesPerGroup + 1 ;	
		
		/*
		 * lastPage
		 */
		lastPage = firsPage + (pagesPerGroup - 1);
		if(lastPage > totalPage)
		   lastPage = totalPage;
		
	}
	
	public int getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
		/*
		 * 유도 변수를 계산 한다.
		 */
		calculate();
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getTotalPage() {
		return totalPage;
	}

	public int getFirstItem() {
		return firstItem;
	}

	public int getLastItem() {
		return lastItem;
	}

	public int getFirsPage() {
		return firsPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public int getItemsPerPage() {
		return itemsPerPage;
	}
	public void setItemsPerPage(int itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}
	public int getPagesPerGroup() {
		return pagesPerGroup;
	}
	public void setPagesPerGroup(int pagesPerGroup) {
		pagesPerGroup = pagesPerGroup;
	}
	
	public boolean isFirstGroup(){
		return (firsPage == 1) ? true : false;
		
		
	}
	public boolean isLastGroup(){
		
		return (lastPage == totalItem) ? true : false;
		
	}
	
	public int getStart(){
		return firstItem - 1;
	}
	
	public int getLength(){
		return lastItem - firstItem + 1;
	}
}
