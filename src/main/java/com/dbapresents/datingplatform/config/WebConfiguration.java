package com.dbapresents.datingplatform.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import java.util.TimeZone;

@Configuration
public class WebConfiguration implements ServletContextInitializer {

    private Environment env;

    @Autowired
    public WebConfiguration(Environment env) {
        this.env = env;
    }

    @Override
    public void onStartup(ServletContext servletContext) {
        if (env.acceptsProfiles(Profiles.of("h2"))) {
            initH2Console(servletContext);
        }
    }

    private void initH2Console(ServletContext servletContext) {
        ServletRegistration.Dynamic h2ConsoleServlet = servletContext.addServlet("H2Console", new org.h2.server.web.WebServlet());
        h2ConsoleServlet.addMapping("/h2console/*");
        h2ConsoleServlet.setLoadOnStartup(1);
        TimeZone.setDefault(TimeZone.getTimeZone("Etc/UTC"));
    }

}
