package com.my_app.my_app.dbCol.API.Soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

@EnableWs //Per abilitare web service
@Configuration
public class Configurazione {

    @Bean
    public MessageDispatcherServlet messageDispatcherServlet() {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setTransformWsdlLocations(true); //Trasforma i wdsl in url
        return servlet;
    }

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServletRegistration() {
        return new ServletRegistrationBean<>(messageDispatcherServlet(), "/ws/*"); //Tutte le richieste che arrivano con ws saranno gestite dal messageservletdispatch
    }
}
