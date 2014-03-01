

package com.demo.eja.demopush.bean;

import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.primefaces.push.PushContext;
import org.primefaces.push.PushContextFactory;

@ManagedBean(name = "contador")
@ApplicationScoped
public class Contador implements Serializable{
    
    private int cuenta;

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }
    
    public synchronized void incrementar(){
        
        cuenta++;
        
        PushContext pushContext = PushContextFactory.getDefault().getPushContext();
        pushContext.push("/counter", String.valueOf(cuenta));
        
        
    }
    
}
