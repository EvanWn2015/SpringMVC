package idv.evan.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import idv.evan.dao.AbstractDao;
import idv.evan.dao.UserDAO;
import idv.evan.vo.Userinfo;

@Repository("userDAO")
public class UserDaoImpl extends AbstractDao implements UserDAO {

	private Class<Userinfo> clazz = Userinfo.class;

	/**
	 * HibernateDaoSupport 與 SessionFactory 衝突
	 * @param sessionFactory
	 */
	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}


	public long createUserinfo(Userinfo Userinfo) {
		return (Long) super.create(Userinfo);
	}

	public Userinfo updateUserinfo(Userinfo Userinfo) {
		return super.update(Userinfo);
	}

	public void deleteUserinfo(long id) {
		Userinfo userinfo = new Userinfo();
		userinfo.setId(id);
		super.delete(userinfo);

	}

	public List<Userinfo> getAllUserinfos() {
		return super.fetchAll(Userinfo.class);
	}

	public Userinfo getUserinfo(long id) {
		return super.fetchById(id, Userinfo.class);
	}

	@SuppressWarnings("unchecked")
	public List<Userinfo> getAllUserinfos(String userinfoName) {
		String query = "SELECT e.* FROM userinfo e WHERE e.name like '%" + userinfoName + "%'";
		List<Object[]> userinfoObjects = super.fetchAll(query);
		List<Userinfo> userinfos = new ArrayList<Userinfo>();
		for (Object[] userinfoObject : userinfoObjects) {
			Userinfo userinfo = new Userinfo();
			long id = ((BigInteger) userinfoObject[0]).longValue();
			String username = (String) userinfoObject[1];
			String passwoed = (String) userinfoObject[2];
			String email = (String) userinfoObject[3];
			userinfo.setId(id);
			userinfo.setUsername(username);
			userinfo.setPassword(passwoed);
			userinfo.setEmail(email);
			userinfos.add(userinfo);
		}
		System.out.println(userinfos);
		return userinfos;
	}

	@Override
	public List<Userinfo> findByExample(DetachedCriteria criteria) {
		return criteria.getExecutableCriteria(super.getSession()).list();
	}
}
