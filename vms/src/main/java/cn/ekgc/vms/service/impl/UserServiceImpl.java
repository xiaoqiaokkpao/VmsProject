package cn.ekgc.vms.service.impl;

import cn.ekgc.vms.dao.UserDao;
import cn.ekgc.vms.pojo.entity.User;
import cn.ekgc.vms.pojo.vo.VmsPage;
import cn.ekgc.vms.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

	/**
	 * <b>分页查询用户列表</b>
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public VmsPage<User> getUserListByPage(VmsPage<User> page) throws Exception{
		// 使用 PageHelper 进行分页查询
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<User> userList = userDao.findListByQuery(null);
		// 将 userList 进行类型转换
		PageInfo<User> pageInfo = new PageInfo<User>(userList);
		// 提取 PageInfo 中的信息，填入到 VmsPage中
		page.copyFromPageInfo(pageInfo);
		return page;
	}

	/**
	 * <b>保存信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean save(User user) throws Exception{
		if (userDao.save(user) > 0){
			return true;
		}
		return false;
	}
}
