package org.example.server;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class SimpleInterceptor {
	
	@AroundInvoke
	public Object intercept(InvocationContext context) throws Exception {
		System.out.println("SimpleInterceptor - BEFORE :"
						+ context.getMethod().getName());
		Object result = context.proceed();
		System.out.println("SimpleInterceptor - AFTER :"
				+ context.getMethod().getName());
		return result;
	}
}
