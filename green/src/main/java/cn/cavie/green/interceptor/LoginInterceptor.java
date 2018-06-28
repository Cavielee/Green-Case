package cn.cavie.green.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	// 进入 Handler方法之前执行
	// 用于身份认证、身份授权
	// 比如身份认证，如果认证通过表示当前用户没有登陆，需要此方法拦截不再向下执行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

//		// 获取请求的url
//		String url = request.getRequestURI();
//		// 判断url是否是公开地址（实际使用时将公开地址配置配置文件中）
//		// 这里公开地址是登陆提交的地址
//		if (url.indexOf("order") >= 0 || url.indexOf("login") >= 0 || url.indexOf("regedit") >= 0
//				|| url.indexOf("user") >= 0 || url.indexOf("point") >= 0 || url.indexOf("index") >= 0) {
//			// 如果进行登陆提交，放行
//			return true;
//		}
//
//		// 获取session
//		HttpSession session = request.getSession();
//
//		// 判断是否登陆
//		if (session.getAttribute("user_id") != null) {
//			return true;
//		}
//		Cookie[] cookies = request.getCookies();
//		if (cookies != null) {
//			for (Cookie cookie : cookies) {
//				if (cookie.getName().equals("user_id")) {
//					return true;
//				}
//
//			}
//		}
//
//		// 执行这里表示用户身份需要认证，跳转登陆页面
////		response.sendRedirect("login");
//		 request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,
//		 response);
//
//		// return false表示拦截，不向下执行
//		// return true表示放行
//		return false;
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}
}