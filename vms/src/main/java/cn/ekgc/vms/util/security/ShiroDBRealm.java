package cn.ekgc.vms.util.security;

import cn.ekgc.vms.base.enums.StatusEnum;
import cn.ekgc.vms.pojo.entity.User;
import cn.ekgc.vms.service.UserService;
import cn.ekgc.vms.util.MD5Util;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

/**
 * <b>Shiro 认证域</b>
 * @author xiaoqiao
 * @since 1.0.0
 * @version 1.0.0
 */
public class ShiroDBRealm extends AuthorizingRealm {
	@Autowired
	private HttpSession session;
	@Autowired
	private UserService userService;
	/**
	 * <b>当需要授权的时候，会调用该方法</b>
	 * @param principalCollection
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		return null;
	}

	/**
	 * <b>当需要认证的时候，调用该方法</b>
	 * @param authenticationToken
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		// 因为登录所使用的方式是“登录名+登陆密码”的形式，因此需要把AuthenticationToken进行转换
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		// 通过UsernamePasswordToken能够获得登录的用户名、密码当前登录用户的IP地址等信息
		// 通过用户名获得对应的用户对象
		try {
			 User user = userService.getUserByCellphone(token.getUsername());
			// 判断该User对象是否为null，并且处于启用状态
			 if (user != null && StatusEnum.STATUS_ENABLE.getCode() == user.getStatus()){
				// 获得用户的登录密码，对该密码进行加密
				String password = MD5Util.encrypt(new String(token.getPassword()));
				 // 将加密之后的密码重新设定到toke中
				 token.setPassword(password.toCharArray());
				 // 通过手机号码查询出正确用户信息，以及将用户登录所提交的密码进行了加密处理，并没有进行密码比对
				 // 对于密码是否正确，只需要交给Shiro，其自身能够比对
				 SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getCellphone(), user.getPassword(), getName());
				 // 默认登录成功，绑定HttpSession信息
				session.setAttribute("user", user);
				return info;
			 }
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
