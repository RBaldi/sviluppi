package org.stuff.ejb.interceptor;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

public class CustomStuffAwInterceptor extends SpringBeanAutowiringInterceptor {

	private static final String CONTEXT_FILE = "spring-conf.xml";

	@Override
	protected BeanFactory getBeanFactory(Object target) {
		return SpringBeanFactoryManager.getBeanFactory();
	}
	
	
	/**
	 * Implementazione del pattern
	 * 
	 *  Initialization-on-demand holder idiom
	 *  
	 *  per riferimenti ( http://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom )
	 *  
	 *  
	 *  per ottenere una istanza della BeanFactory thread safe e
	 *  unica ( singleton Pattern e Double Checked Locking idiom )
	 * 
	 * 
	 * @author 16800027
	 *
	 */
	private static class SpringBeanFactoryManager {
		
		private static class LazyHolder {
			private static final BeanFactory INSTANCE = new ClassPathXmlApplicationContext(CONTEXT_FILE).getBeanFactory();

		}
		
		
		public static BeanFactory getBeanFactory() {
			return LazyHolder.INSTANCE;
		}
		
	}
	
	
}
