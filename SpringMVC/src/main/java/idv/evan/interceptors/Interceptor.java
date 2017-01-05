package idv.evan.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(Interceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse resp, Object obj, Exception ex)
			throws Exception {
		logger.info("~~~~~~{}", "in Interceptor");
		// TODO Auto-generated method stub
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object obj, ModelAndView model)
			throws Exception {
		logger.info("~~~~~~{}", "in Interceptor");
		// TODO Auto-generated method stub
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object obj) throws Exception {
		logger.info("~~~~~~{}", "in Interceptor");
		if (req.getSession().getAttribute("user_ID") == null) {
			resp.sendRedirect(req.getContextPath() + "/");
			return false;
		} else {
			return true;
		}
	}
}
