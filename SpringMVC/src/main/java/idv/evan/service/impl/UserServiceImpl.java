package idv.evan.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import idv.evan.constant.DaoConstants;
import idv.evan.dao.UserDAO;
import idv.evan.domain.Userinfo;
import idv.evan.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	public long createUserinfo(Userinfo Userinfo) {
		return userDAO.createUserinfo(Userinfo);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public Userinfo updateUserinfo(Userinfo Userinfo) {
		return userDAO.updateUserinfo(Userinfo);
	}

	@Transactional(readOnly = false)
	public void deleteUserinfo(long id) {
		userDAO.deleteUserinfo(id);
	}

	@Transactional(readOnly = true)
	public List<Userinfo> getAllUserinfos() {
		return userDAO.getAllUserinfos();
	}

	@Transactional(readOnly = true)
	public Userinfo getUserinfo(long id) {
		return userDAO.getUserinfo(id);
	}

	@Transactional(readOnly = true)
	public List<Userinfo> getAllUserinfos(String UserinfoName) {
		return userDAO.getAllUserinfos(UserinfoName);
	}

	@Transactional(readOnly = true)
	public boolean verifyUser(Userinfo userinfo) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Userinfo.class);
		criteria.add(Restrictions.eq(DaoConstants.USERINFO_USERNAME, userinfo.getUsername()));
		criteria.add(Restrictions.eq(DaoConstants.USERINFO_PASSWORD, userinfo.getPassword()));
		return userDAO.findByExample(criteria).size() != 0 ? true : false;
	}

}
