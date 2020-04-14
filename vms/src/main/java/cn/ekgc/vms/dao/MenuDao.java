package cn.ekgc.vms.dao;

import cn.ekgc.vms.pojo.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <b>菜单信息数据持久层接口</b>
 * @author xiaoqiao
 * @since 1.0.0
 * @version 1.0.0
 */
@Repository
public interface MenuDao {
	/**
	 * <b>根据上级菜单和角色查询对应的菜单列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<Menu> findMenuListByParentAndRole(Map<String, Object> query)throws Exception;
}
