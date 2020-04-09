package cn.ekgc.vms.pojo.vo;

import cn.ekgc.vms.util.ConstanUtil;

import java.io.Serializable;
import java.util.List;

public class VmsPage<E> implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer pageNum;            // 当前页码
	private Integer pageSize;           // 每页显示数量
	private List<E> list;               // 分页列表
	private Integer totalCount;         // 总数量
	private Integer totalPage;          // 总页数

	public VmsPage() {}
	public VmsPage(Integer pageNum, Integer pageSize) {
		if (pageNum != null && pageNum > 0){
			this.pageNum = pageNum;
		} else {
			this.pageNum = ConstanUtil.PAGE_NUM;
		}

		if (pageSize != null && pageSize > 0){
			this.pageSize = pageSize;
		} else {
			this.pageSize = ConstanUtil.PAGE_SIZE;
		}
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
}
