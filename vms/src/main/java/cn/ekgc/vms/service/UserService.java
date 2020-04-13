package cn.ekgc.vms.service;

import cn.ekgc.vms.pojo.entity.User;

/**
 * <b>用户实现类接口</b>
 * @author xiaoqiao
 * @since 1.0.0
 * @version 1.0.0
 */
public interface UserService {

	/**
	 * <b>通过用户的手机号码查询出相关信息</b>
	 * @param cellphone
	 * @return
	 * @throws Exception
	 */
	User getUserByCellphone(String cellphone) throws Exception;
}
