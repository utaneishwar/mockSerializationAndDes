package pojo;

import java.util.List;

public class DelayUser 
{
	Integer page; 
	Integer  per_page;
	Integer total;
	Integer total_pages;
	List<DelayData> data;
	DelaySupport support;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPer_page() {
		return per_page;
	}
	public void setPer_page(Integer per_page) {
		this.per_page = per_page;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(Integer total_pages) {
		this.total_pages = total_pages;
	}
	public List<DelayData> getData() {
		return data;
	}
	public void setData(List<DelayData> data) {
		this.data = data;
	}
	public DelaySupport getSupport() {
		return support;
	}
	public void setSupport(DelaySupport support) {
		this.support = support;
	}
	
	
}
