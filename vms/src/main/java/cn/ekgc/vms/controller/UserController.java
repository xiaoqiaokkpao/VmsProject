package cn.ekgc.vms.controller;

import cn.ekgc.vms.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <b>系统用户控制层</b>
 * @author xiaoqiao
 * @since 1.0.0
 * @version 1.0.0
 */
@Controller("userController")
@RequestMapping("/user")
public class UserController extends BaseController {

	/**
	 * <b>转发到登录界面</b>
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/login")
	public String forwardLoginPage() throws Exception{
		return "user/user_login";
	}

	/**
	 * <b>登录失败后访问地址</b>
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/login")
	public String errorLogin() throws Exception{
		// 只要重定向到退出即可
		return "redirect:/user/logout";
	}
}
