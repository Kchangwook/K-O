package toy.project.kando.common.resolver;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Component
public class HtmlViewResolver extends InternalResourceViewResolver {
	public HtmlViewResolver() {
		this.setPrefix("/html/");
		this.setSuffix(".html");
	}
}
