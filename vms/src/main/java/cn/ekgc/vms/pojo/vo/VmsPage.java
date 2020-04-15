package cn.ekgc.vms.pojo.vo;

import cn.ekgc.vms.util.ConstanUtil;
import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

public class VmsPage<E> implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer pageNum;            // 当前页码
	private Integer pageSize;           // 每页显示数量
	private List<E> list;               // 分页列表
	private Long totalCount;         // 总数量
	private Long totalPage;          // 总页数
	private Integer draw;               // 用于 DataTables 组件

	public VmsPage() {}
	public VmsPage(Integer pageNum, Integer pageSize, Integer draw) {
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
		this.draw = draw;
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

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	/**
	 * <b>将 PageHelper 中 PageInfo 信息转换到对象中</b>
	 * @param pageInfo
	 */
	public void copyFromPageInfo(PageInfo<E> pageInfo) {
		// 列表
		this.list = pageInfo.getList();
		this.totalCount = pageInfo.getTotal();
		this.totalPage = (long)pageInfo.getPages();
	}
}
