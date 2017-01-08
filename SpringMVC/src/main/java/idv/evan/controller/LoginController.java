package idv.evan.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import idv.evan.constant.Constant;
import idv.evan.domain.Userinfo;
import idv.evan.dto.UserDto;
import idv.evan.service.UserService;

@Controller
public class LoginController {

	static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/login", "/" }, method = RequestMethod.GET)
	public ModelAndView init(HttpSession session) {
		if (session.getAttribute(Constant.LOGIN_STATUS) != null) {
			logger.info("session : {}", session);
			return new ModelAndView("index");
		}
		logger.info("username : {}", "get");
		return new ModelAndView("login");
	}

	// @RequestMapping(value = { "/login", "/" }, method = RequestMethod.POST,
	// produces = "application/json")
	@RequestMapping(value = { "/login", "/" }, method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView verifyUser(UserDto userDto, Model model, HttpSession session) {
		logger.info("username : {}", userDto.getUsername());
		Userinfo userinfo = new Userinfo();
		userinfo.setUsername(userDto.getUsername());
		userinfo.setPassword(userDto.getPassword());
		logger.info("verifyUser : {}", userService.verifyUser(userinfo));

		if (userService.verifyUser(userinfo)) {
			session.setAttribute(Constant.LOGIN_STATUS, true);
			return new ModelAndView("index");
		}
		return new ModelAndView("login");

	}
}
