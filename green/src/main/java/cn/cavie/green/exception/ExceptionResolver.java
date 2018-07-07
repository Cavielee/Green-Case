package cn.cavie.green.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class ExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		CustomException customException = null;
		
		if (ex instanceof CustomException) {
			customException = (CustomException) ex;
		} else {
			customException = new CustomException("未知错误");
		}

		// 错误信息
		//String message = customException.getMessage();

		ModelAndView modelAndView = new ModelAndView();

		Logger log = LogManager.getLogger(this.getClass());
		log.error(ex.getMessage());
		// 将错误信息传到页面
		// modelAndView.addObject("message", message);
		// 指向错误页面
		modelAndView.setViewName("redirect:/error/500");

		return modelAndView;

	}

}
