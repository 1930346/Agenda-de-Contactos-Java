/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesep29;

import java.util.Date;
import java.io.Serializable;

//Clase CONTACTO QUE MANEJA LOS DATOS
public class Contacto extends Persona implements Serializable{   //INTERFACE PARA EL FLUJO DE DATOS, en archivos
    String email;
    long telefono;
    
    
    public Contacto(String a, Date b){
        super(a,b);

    }
    
    public Contacto(String a, String b, long d){
        super(a);
        this.email = b;
        this.telefono = d;
    }
    
    public Contacto(String a, Date b, String c, long d){
        super(a,b);
        this.email = c;
        this.telefono = d;
    }
    
    
    public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String a){
        this.email = a;
    }
    
    public long getTelefono(){
        return this.telefono;
    }
    
    public void setTelefono(long a){
        this.telefono = a;
    }
    
    public String toString(){
        return nombre + " - " + fdn + " - " + this.email + " - " + this.telefono; 
    }
}
