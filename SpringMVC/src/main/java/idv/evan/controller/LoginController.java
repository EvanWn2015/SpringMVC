package idv.evan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import idv.evan.service.UserService;
import idv.evan.vo.Userinfo;

@Controller
public class LoginController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView verifyUser(Userinfo userinfo, Model model) {
		
		userService.createUserinfo(userinfo);
		System.out.println(userinfo.getUsername() + "");
		LOGGER.info("user: {}", userinfo.getUsername());
		ModelAndView mod = new ModelAndView();
		mod.setViewName("login");
		return mod;
	}
}
