package cn.ekgc.vms.service.impl;

import cn.ekgc.vms.base.enums.StatusEnum;
import cn.ekgc.vms.dao.MenuDao;
import cn.ekgc.vms.pojo.entity.Menu;
import cn.ekgc.vms.pojo.entity.Role;
import cn.ekgc.vms.pojo.vo.Node;
import cn.ekgc.vms.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>菜单信息接口</b>
 * @author xiaoqiao
 * @since 1.0.0
 * @version 1.0.0
 */
@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuDao menuDao;

	/**
	 * <b>使用角色为首页面查询菜单列表</b>
	 * @param role
	 * @return
	 * @throws Exception
	 */
	public List<Menu> getIndexMenuList(Role role) throws Exception{
		Map<String, Object> query = new HashMap<String, Object>();
		// 根据角色查询所有一级菜单
		query.put("parentId", null);
		query.put("roleId", role.getId());
		query.put("status", StatusEnum.STATUS_ENABLE.getCode());

		List<Menu> menuList = menuDao.findMenuListByParentAndRole(query);
		// 得到一级菜单列表，根据一级菜单列表查询对应的二级菜单
		if (menuList != null && menuList.size() > 0){
			for (Menu first : menuList) {
				query.put("parentId", first.getId());
				List<Menu> secondList = menuDao.findMenuListByParentAndRole(query);
				first.setChildList(secondList);
			}
		}
		return menuList;
	}

	/**
	 * <b>为授权页面查询Node集合</b>
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	public List<Node> getNodeListForAuth(Long roleId) throws Exception{
		List<Node> nodeList = new ArrayList<Node>();
		// 查询所有的菜单信息
		List<Menu> menuList = menuDao.findListByQuery(null);
		// 根据角色查询该角色已有的权限
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("roleId", roleId);
		List<Menu> roleMenuList = menuDao.findListByQuery(map);
		// 需要将menuList切换成nodeList
		if (menuList != null && menuList.size() > 0){
			for (Menu menu : menuList){
				// 创建Node对象
				Node node = new Node();
				// 设置id
				node.setId(menu.getId());
				// 设置pId
				node.setpId((menu.getParent() == null) ? 0 : menu.getParent().getId());
				// 设置name
				node.setName(menu.getText());
				// open
				if (menu.getParent() == null ){
					// 一级菜单，那么进行展开
					node.setOpen(true);
				}
				// 判断是否选中
				if (roleMenuList.contains(menu)){
					node.setChecked(true);
				}
				nodeList.add(node);
			}
		}
		return nodeList;
	}
}
