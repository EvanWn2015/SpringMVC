package idv.evan.service;

import java.util.List;

import idv.evan.domain.Userinfo;

public interface UserService {

	public long createUserinfo(Userinfo Userinfo);

	public Userinfo updateUserinfo(Userinfo Userinfo);

	public void deleteUserinfo(long id);

	public List<Userinfo> getAllUserinfos();

	public Userinfo getUserinfo(long id);

	public List<Userinfo> getAllUserinfos(String UserinfoName);
	
	public boolean verifyUser(Userinfo userinfo);

}
