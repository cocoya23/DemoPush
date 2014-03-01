/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.demo.eja.demopush.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "mensajero")
@ViewScoped
public class Mensajero {
    
    private String mensaje;
    private String summary;
    private String detail;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
    
    public void enviar(){
        
        FacesContext context = FacesContext.getCurrentInstance();
        Notificaciones notificaciones = (Notificaciones) context.getApplication().evaluateExpressionGet(context, "#{notificacion}", Notificaciones.class);
        notificaciones.sendGeneralMensajeGrowl(FacesMessage.SEVERITY_FATAL,getSummary(),getDetail());
        
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public void enviarMsj(){
        
        FacesContext context = FacesContext.getCurrentInstance();
        Notificaciones notificaciones = (Notificaciones) context.getApplication().evaluateExpressionGet(context, "#{notificacion}", Notificaciones.class);
        notificaciones.enviarMsj(mensaje);
        
    }
    
}
