package com.company.interceptor;

import lombok.extern.log4j.Log4j;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

@Log4j
public class SimpleLogger {
    @AroundInvoke
    public Object addLog(InvocationContext context) throws Exception {
        log.info("method: " + context.getMethod());
        return context.proceed();
    }
}
