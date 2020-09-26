package toy.project.kando.common.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {WebConfig.class};
	}

	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebConfig.class};
	}

	protected String[] getServletMappings() {
		return new String[] {"/*"};
	}
}
