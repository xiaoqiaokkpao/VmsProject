package cn.ekgc.vms.service.impl;

import cn.ekgc.vms.dao.UserDao;
import cn.ekgc.vms.pojo.entity.User;
import cn.ekgc.vms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>用户实现类接口</b>
 * @author xiaoqiao
 * @since 1.0.0
 * @version 1.0.0
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	/**
	 * <b>通过用户的手机号码查询出相关信息</b>
	 * @param cellphone
	 * @return
	 * @throws Exception
	 */
	public User getUserByCellphone(String cellphone) throws Exception{
		User query = new User();
		query.setCellphone(cellphone);
		List<User> userList = userDao.findListByQuery(query);
		if (userList != null && userList.size() > 0){
			return userList.get(0);
		}
		return new User();
	}
}
