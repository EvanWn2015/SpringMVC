package idv.evan.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import idv.evan.vo.Userinfo;

public interface UserDAO {

	public long createUserinfo(Userinfo Userinfo);

	public Userinfo updateUserinfo(Userinfo Userinfo);

	public void deleteUserinfo(long id);

	public List<Userinfo> getAllUserinfos();

	public Userinfo getUserinfo(long id);

	public List<Userinfo> getAllUserinfos(String UserinfoName);

	public List<Userinfo> findByExample(DetachedCriteria criteria);

}
