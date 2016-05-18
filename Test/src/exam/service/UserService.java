package exam.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import exam.dao.UserDao;
import exam.po.User;

@Service
public class UserService {
	@Resource
	private UserDao userDao;
	
	/**
	 * 根据用户名获取用户对象
	 */
	public User getUser(String username){
		return userDao.getUser(username);
	}

	/**
	 * 更新用户最近登陆时间
	 */
	public void updateLastSingin(String username) {
		userDao.updateLastSingin(username);
	}

}
