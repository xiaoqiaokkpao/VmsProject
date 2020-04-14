package cn.ekgc.vms.service;

import cn.ekgc.vms.pojo.entity.Menu;
import cn.ekgc.vms.pojo.entity.Role;

import java.util.List;

/**
 * <b>菜单信息接口</b>
 * @author xiaoqiao
 * @since 1.0.0
 * @version 1.0.0
 */
public interface MenuService {
	/**
	 * <b>使用角色为首页面查询菜单列表</b>
	 * @param role
	 * @return
	 * @throws Exception
	 */
	List<Menu> getIndexMenuList(Role role) throws Exception;
}
