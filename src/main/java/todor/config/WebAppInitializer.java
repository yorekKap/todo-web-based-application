package todor.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import todor.security.SecurityConfig;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"/"};
		
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[] {RootConfig.class, SecurityConfig.class};
		
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] {WebConfig.class};
		
	}
	
}
