/*
 * Copyright (c) 2005, 2019, EVECOM Technology Co.,Ltd. All rights reserved.
 * EVECOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package cn.bif.config;

import com.bstek.ureport.provider.report.file.FileReportProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Ted Wang
 * @created 2020/6/30 9:11 上午
 */
@ConfigurationProperties(
        prefix = "ureport.file"
)
@Component
public class UreportFilePathConfig {
    
    String dir;
    
    
    @Autowired
    ApplicationContext applicationContext;
    
    @PostConstruct
    public void init () {
        FileReportProvider bean = (FileReportProvider) applicationContext.getBean("ureport.fileReportProvider");
        
        bean.setFileStoreDir(dir);
        
    }
    
    public String getDir () {
        return dir;
    }
    
    public void setDir (String dir) {
        this.dir = dir;
    }
}
