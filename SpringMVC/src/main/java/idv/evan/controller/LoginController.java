package idv.evan.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import idv.evan.constant.Constant;
import idv.evan.domain.Userinfo;
import idv.evan.service.UserService;

@Controller
public class LoginController {

	static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/login", "/" }, method = RequestMethod.GET)
	public ModelAndView init(HttpSession session) {
		logger.info("~~~~~GET session :{}", session.getAttribute(Constant.LOGIN_STATUS));
		if ((boolean) session.getAttribute(Constant.LOGIN_STATUS)) {
			return new ModelAndView("index");
		}
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView verifyUser(Userinfo userinfo, Model model, HttpSession session) {
		session.setAttribute(Constant.LOGIN_STATUS, true);
		logger.info("username : {}", userinfo.getUsername());
		userinfo.setEmail("email@mail.com");
		ModelAndView mod = new ModelAndView();
		mod.setViewName("login");
		if (userService.verifyUser(userinfo)) {
			mod.setViewName("index");
		}
		return mod;
	}
}
