package cn.bif.vo;

import java.math.BigDecimal;

/**
 * @author Ted Wang
 * @created 2021/1/29 11:01 上午
 */
public class TableDataVO {
    
    private String name ;
    
    private Integer age;
    
    private String title;
    
    private String address;
    
    private BigDecimal wages;
    
    
    public String getName () {
        return name;
    }
    
    public void setName (String name) {
        this.name = name;
    }
    
    public Integer getAge () {
        return age;
    }
    
    public void setAge (Integer age) {
        this.age = age;
    }
    
    public String getTitle () {
        return title;
    }
    
    public void setTitle (String title) {
        this.title = title;
    }
    
    public String getAddress () {
        return address;
    }
    
    public void setAddress (String address) {
        this.address = address;
    }
    
    public BigDecimal getWages () {
        return wages;
    }
    
    public void setWages (BigDecimal wages) {
        this.wages = wages;
    }
}
