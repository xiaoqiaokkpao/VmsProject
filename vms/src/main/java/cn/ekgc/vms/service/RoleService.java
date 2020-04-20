package cn.ekgc.vms.service;

import cn.ekgc.vms.pojo.entity.Role;
import cn.ekgc.vms.pojo.vo.VmsPage;

import java.util.List;

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

	/**
	 * <b>进行角色授权</b>
	 * @param roleId
	 * @param menuIds
	 * @return
	 * @throws Exception
	 */
	boolean auth(Long roleId, Long[] menuIds) throws Exception;

	List<Role> getRoleListByQuery(Role query) throws Exception;
}
