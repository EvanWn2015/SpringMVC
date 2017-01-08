package idv.evan.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import idv.evan.constant.Constant;

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
		if(req.getServletPath().startsWith("index")) {  
	        return true;  
	    }  
	          
	    //2、TODO 比如退出、首页等页面无需登录，即此处要放行 允许游客的请求  
	          
	    //3、如果用户已经登录 放行    
	    if(req.getSession().getAttribute(Constant.LOGIN_STATUS) != null) {  
	        //更好的实现方式的使用cookie  
	        return true;  
	    }  

	    //4、非法请求 即这些请求需要登录后才能访问  
	    //重定向到登录页面  
	    resp.sendRedirect(req.getContextPath() + "/index");  
	    return false;  
	}
}
