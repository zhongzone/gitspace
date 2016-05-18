package exam.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import exam.po.User;
import exam.service.UserService;
import exam.util.StringUtil;

@Controller
@RequestMapping("/LoginAction")
public class LoginAction {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/login.do")
	public String login(){
		return "login";
	}

	/**
	 * 登陆验证
	 */
	@RequestMapping("/loginCheck.do")
	@ResponseBody
	public String loginCheck(HttpServletRequest request){
		String result;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userService.getUser(username);
		if(null == user){	//判断用户是否存在
			result = "noUser";
		}else if(StringUtil.MD5Encode(password).equals(user.getPassword())){	//判断密码是否正确
			request.getSession().setAttribute("user", user);
			result = "success";
			//更新用户最近登陆时间
			userService.updateLastSingin(username);
		}else{
			result = "errPsw";
		}
		return result;
	}
	
	/**
	 * 用户信息页面跳转
	 */
	@RequestMapping("/showUserInfo.do")
	public String showUserInfo(){
		return "userInfo";
	}
	
	/**
	 * 注销登陆
	 */
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request){
		request.getSession().removeAttribute("user");
		return "login";
	}
}
