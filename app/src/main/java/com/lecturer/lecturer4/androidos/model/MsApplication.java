/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecturer.lecturer4.androidos.model;

import java.util.Date;
public class MsApplication {

    private static final long serialVersionUID = 1L;
    private String id;
    private String appName;
    private String appLinkName;
    private String appLink;
    private String inputBy;
    private Date inputDt;
    private String updateBy;
    private Date updateDt;

    public MsApplication() {}
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getAppName() {
        return appName;
    }
    
    public void setAppName(String appName) {
        this.appName = appName;
    }
    
    public String getAppLinkName() {
        return appLinkName;
    }
    
    public void setAppLinkName(String appLinkName) {
        this.appLinkName = appLinkName;
    }
    
    public String getAppLink() {
        return appLink;
    }
    
    public void setAppLink(String appLink) {
        this.appLink = appLink;
    }
    
    public String getInputBy() {
        return inputBy;
    }
    
    public void setInputBy(String inputBy) {
        this.inputBy = inputBy;
    }
    
    public Date getInputDt() {
        return inputDt;
    }
    
    public void setInputDt(Date inputDt) {
        this.inputDt = inputDt;
    }
   
    public String getUpdateBy() {
        return updateBy;
    }
    
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
    
    public Date getUpdateDt() {
        return updateDt;
    }
    
    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }
}
