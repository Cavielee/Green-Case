package cn.cavie.green.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.cavie.green.service.VisitsService;

@WebListener
public class SessionListener implements HttpSessionListener {

	private VisitsService visitsService;

	// 记录访问人数
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		visitsService = (VisitsService) WebApplicationContextUtils.getWebApplicationContext(se.getSession().getServletContext())
				.getBean("visitsService");
		try {
			visitsService.addVisits();
		} catch (Exception e) {
			Logger log = Logger.getLogger(this.getClass());
			log.error(e.getMessage());
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
