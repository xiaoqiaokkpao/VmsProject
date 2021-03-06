package cn.ekgc.vms.controller;

import cn.ekgc.vms.base.controller.BaseController;
import cn.ekgc.vms.pojo.entity.Role;
import cn.ekgc.vms.pojo.vo.VmsPage;
import cn.ekgc.vms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <b>角色控制层</b>
 * @author xiaoqiao
 * @since 1.0.0
 * @version 1.0.0
 */
@Controller("roleController")
@RequestMapping("/role")
public class RoleController extends BaseController {
	@Autowired
	private RoleService roleService;

	/**
	 * <b>转发到角色界面</b>
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/index")
	public String forwardLoginPage() throws Exception{
		return "role/role_index";
	}

	@PostMapping(value = "/page")
	@ResponseBody
	public VmsPage<Role> getRoleVmsPage(Integer pageNum, Integer pageSize, Integer draw) throws Exception{
		// 创建VmsPage对象
		VmsPage<Role> page = new VmsPage<Role>(pageNum, pageSize, draw);
		// 业务层进行分页查询
		page = roleService.getRoleVmsPage(page);
		return page;
	}

	/**
	 * <b>转发到授权界面</b>
	 * @param id
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/auth")
	public String forwardAuthPage(Long id, ModelMap map) throws Exception{
		// 将角色主键绑定到 ModelMap 中
		map.put("roleId", id);
		return "role/role_auth";
	}

	/**
	 * <b>进行授权</b>
	 * @param roleId
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/auth")
	@ResponseBody
	public boolean authRole(Long roleId, String ids) throws Exception{
		// 判断此时的授权信息是否存在
		if (ids != null && !"".equals(ids.trim())){
			// 使用“-”进行字符串切割
			String[] strs = ids.split("-");
			// 将对应的String[] 变成Long[]
			Long[] menuIds = new Long[strs.length];
			for (int i = 0; i < strs.length; i++){
				menuIds[i] = Long.parseLong(strs[i]);
			}
			// 进行保存
			return roleService.auth(roleId, menuIds);
		}
		return false;
	}

}
