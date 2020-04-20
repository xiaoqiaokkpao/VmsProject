package cn.ekgc.vms.service.impl;

import cn.ekgc.vms.dao.RoleDao;
import cn.ekgc.vms.pojo.entity.Role;
import cn.ekgc.vms.pojo.vo.VmsPage;
import cn.ekgc.vms.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>角色业务类接口实现类</b>
 * @author xiaoqiao
 * @since 1.0.0
 * @version 1.0.0
 */
@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;
	/**
	 * <b>分页查询用户信息列表</b>
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public VmsPage<Role> getRoleVmsPage(VmsPage<Role> page) throws Exception{
		// 使用 PageHelper 进行分页查询
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<Role> roleList = roleDao.findListByQuery(null);
		// 获得 PageInfo 对象
		PageInfo<Role> pageInfo = new PageInfo<>(roleList);
		// 进行信息切换
		page.copyFromPageInfo(pageInfo);
		return page;
	}

	/**
	 * <b>进行角色授权</b>
	 * @param roleId
	 * @param menuIds
	 * @return
	 * @throws Exception
	 */
	public boolean auth(Long roleId, Long[] menuIds) throws Exception{
		// 根据角色主键清空现有权限
		if (roleDao.deleteForAuth(roleId) >= 0){
			// 循环授权
			Map<String, Object> map = new HashMap<String, Object>();
			for (Long menuId : menuIds){
				// 保存权限
				map.put("roleId", roleId);
				map.put("menuId", menuId);
				roleDao.saveAuth(map);
			}
			return true;
		}
		return false;
	}


	public List<Role> getRoleListByQuery(Role query) throws Exception{
		List<Role> list = roleDao.findListByQuery(query);
		if (list != null && list.size() > 0){
			return list;
		}
		return new ArrayList<Role>();
	}
}
