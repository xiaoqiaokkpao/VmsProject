package cn.ekgc.vms.controller;

import cn.ekgc.vms.base.controller.BaseController;
import cn.ekgc.vms.pojo.entity.Menu;
import cn.ekgc.vms.pojo.entity.Role;
import cn.ekgc.vms.pojo.entity.User;
import cn.ekgc.vms.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * <b>首页面加载控制器</b>
 * @author xiaoqiao
 * @since 1.0.0
 * @version 1.0.0
 */
@Controller("indexController")
public class IndexController extends BaseController {
	@Autowired
	private MenuService menuService;

	/**
	 * <b>加载首页面</b>
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/")
	public String index(ModelMap map) throws Exception{
		// 根据当前用户的角色获取对应的菜单信息
		// 获取当前登录用户
		User user = (User) session.getAttribute("user");
		// 根据用户获得其所对应的角色信息
		Role role = user.getRole();
		// 根据角色信息获取该角色所对应的菜单列表
		List<Menu> menuList = menuService.getIndexMenuList(role);
		// 将查询的菜单列表转发到首页面
		map.put("menuList", menuList);

		return "index";
	}

}
