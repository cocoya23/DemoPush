package com.demo.eja.demopush.bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import org.primefaces.push.PushContext;
import org.primefaces.push.PushContextFactory;

@ManagedBean(name = "notificacion")
@ApplicationScoped
public class Notificaciones {
    
    public synchronized void sendGeneralMensajeGrowl(FacesMessage.Severity severidad,String asunto,String detalle){
        
        PushContext pushContext = PushContextFactory.getDefault().getPushContext();
        
        pushContext.push("/general", new FacesMessage(severidad,asunto,detalle));
        
    }
    
    public synchronized void enviarMsj(String mensaje){
        
        PushContext pushContext = PushContextFactory.getDefault().getPushContext();
        pushContext.push("/mensajero", String.valueOf(mensaje));
        
    }
    
}
