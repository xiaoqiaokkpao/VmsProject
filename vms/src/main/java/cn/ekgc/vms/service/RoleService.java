package cn.ekgc.vms.service;

import cn.ekgc.vms.pojo.entity.Role;
import cn.ekgc.vms.pojo.vo.VmsPage;

/**
 * <b>角色业务类接口</b>
 * @author xiaoqiao
 * @since 1.0.0
 * @version 1.0.0
 */
public interface RoleService {

	/**
	 * <b>分页查询用户信息列表</b>
	 * @param page
	 * @return
	 * @throws Exception
	 */
	VmsPage<Role> getRoleVmsPage(VmsPage<Role> page) throws Exception;
}
