package com.company.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppInit implements WebApplicationInitializer {


    private static final String DISPATCHER_SERVLET = "dispatcher";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

        context.register(WebApplicationConfig.class);
        context.register(SecurityConfig.class);
        context.register(ApplicationConfig.class);

        servletContext.addListener(new ContextLoaderListener(context));

        context.setServletContext(servletContext);
        ServletRegistration.Dynamic servlet = servletContext.addServlet(DISPATCHER_SERVLET, new DispatcherServlet(context));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}
