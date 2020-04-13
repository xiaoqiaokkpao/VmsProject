package cn.ekgc.vms.dao;

import cn.ekgc.vms.pojo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>用户模块数据持久层接口</b>
 * @author xiaoqiao
 * @since 1.0.0
 * @version 1.0.0
 */
@Repository
public interface UserDao {
	/**
	 * <b>根据查询对象查询信息列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<User> findListByQuery(User query) throws Exception;

	/**
	 * <b>保存信息</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int save(User entity) throws Exception;

	/**
	 * <b>更新信息</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	int update(User entity) throws Exception;
}
