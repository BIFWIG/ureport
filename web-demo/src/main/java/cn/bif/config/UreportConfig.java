package cn.bif.config;

import com.bstek.ureport.console.UReportServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.servlet.Servlet;


/**
 * @author Ted Wang
 * @created 2021/1/29 10:43 上午
 */
@Configuration
@ImportResource("classpath:ureport-console-context.xml")
public class UreportConfig {
    
    @Bean
    public ServletRegistrationBean<Servlet> ureportServlet(){
        return new ServletRegistrationBean(new UReportServlet(),"/ureport/*");
    }
}
