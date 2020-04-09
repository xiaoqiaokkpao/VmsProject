package cn.ekgc.vms.controller;

import cn.ekgc.vms.controller.Base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
}
