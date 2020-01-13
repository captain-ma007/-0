package cn.tedu.store.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.User;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.UsernameDuplicateException;
import cn.tedu.store.util.JsonResult;

@RestController
@RequestMapping("users")
public class UserController extends BaseController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("reg")
	public JsonResult<Void> reg(User user)  {
		try {
			userService.reg(user);
		} catch (UsernameDuplicateException e) {
			throw e;
		}
		
		return new JsonResult<>(SUCCESS);
	}

	@RequestMapping("login")
	public JsonResult<User> login(String username,
			String password, HttpSession session){
		// 调用业务层对象执行登录
		User data = userService.login(username, password);
		// 将uid和username存入到session中
		session.setAttribute("uid", data.getUid());
		session.setAttribute("username", data.getUsername());
		// 响应结果
		return new JsonResult<>(SUCCESS, data);
	}
	
}





