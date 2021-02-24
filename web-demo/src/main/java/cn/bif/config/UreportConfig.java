package cn.bif.config;

import com.bstek.ureport.console.UReportServlet;
import com.bstek.ureport.provider.report.file.FileReportProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
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
