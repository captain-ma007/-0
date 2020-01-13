package cn.tedu.store.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.ServiceException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameDuplicateException;
import cn.tedu.store.util.JsonResult;

/**
 * 控制器类的基类
 */
public abstract class BaseController {
	
	/**
	 * 操作成功时的状态码
	 */
	public static final int SUCCESS = 2000;
	
	@ExceptionHandler(ServiceException.class)
	public JsonResult<Void> handleException(Throwable ex) {
		// 创建响应结果对象
		JsonResult<Void> jsonResult = new JsonResult<>(ex);
		
		// 逐一判断异常类型
		if (ex instanceof UsernameDuplicateException) {
			// 4000-用户名冲突异常，例如：注册时，用户名已经被占用
			jsonResult.setState(4000);
		} else if (ex instanceof UserNotFoundException) {
			// 4001-用户数据不存在
			jsonResult.setState(4001);
		} else if (ex instanceof PasswordNotMatchException) {
			// 4002-验证密码失败
			jsonResult.setState(4002);
		} else if (ex instanceof InsertException) {
			// 5000-插入数据异常
			jsonResult.setState(5000);
		}
		
		return jsonResult;
	}
	
}
