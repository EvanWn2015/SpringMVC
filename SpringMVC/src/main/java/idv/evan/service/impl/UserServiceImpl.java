package idv.evan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import idv.evan.dao.UserDAO;
import idv.evan.service.UserService;
import idv.evan.vo.Userinfo;

@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Transactional(readOnly = false)
	public long createUserinfo(Userinfo Userinfo) {
		return userDAO.createUserinfo(Userinfo);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public Userinfo updateUserinfo(Userinfo Userinfo) {
		return userDAO.updateUserinfo(Userinfo);
	}

	public void deleteUserinfo(long id) {
		userDAO.deleteUserinfo(id);
	}

	public List<Userinfo> getAllUserinfos() {
		return userDAO.getAllUserinfos();
	}

	@Transactional(readOnly = true)
	public Userinfo getUserinfo(long id) {
		return userDAO.getUserinfo(id);
	}

	public List<Userinfo> getAllUserinfos(String UserinfoName) {
		return userDAO.getAllUserinfos(UserinfoName);
	}

	public boolean verifyUser(Userinfo userinfo) {
		return getAllUserinfos(userinfo.getUsername()) == null ? false : true;

	}

}
