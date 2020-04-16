package cn.ekgc.vms.dao;

import cn.ekgc.vms.pojo.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>角色数据持久层接口</b>
 * @author xiaoqiao
 * @since 1.0.0
 * @version 1.0.0
 */
@Repository
public interface RoleDao {
	/**
	 * <b>根据查询对象获得列表信息</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<Role> findListByQuery(Role query) throws Exception;

	/**
	 * <b>保存信息</b>
	 * @param role
	 * @return
	 * @throws Exception
	 */
	int save(Role role) throws Exception;

	/**
	 * <b>修改信息</b>
	 * @param role
	 * @return
	 * @throws Exception
	 */
	int update(Role role) throws Exception;

}
