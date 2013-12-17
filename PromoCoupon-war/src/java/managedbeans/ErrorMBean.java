/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbeans;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author liuju
 */
@Named(value = "errorMBean")
@RequestScoped
public class ErrorMBean {

    @ManagedProperty(value="#{param.msg}")
    private String msg;
    /**
     * Creates a new instance of ErrorMBean
     */
    public ErrorMBean() {
    }
        
    @PostConstruct
    public void init() {
        System.out.println("###"+msg+"###"); 
    }
    
    public String getMessage(){
        return msg;
    }

}
