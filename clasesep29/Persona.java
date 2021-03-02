
package clasesep29;

import java.util.Date;
import java.io.Serializable;


//Esta es la clase persona, ya que aquí implementamos herencia, heredamos los atributos
// de esta clase a Contacto, y además esta misma clase implementa una interfaz 
// La cual es serializable para serializar la clase
public class Persona implements Serializable{
    String nombre;
    Date fdn; //fecha de nacimiento //Instancia
    
    
    public Persona(String a, Date b){
        this.nombre = a;                //INICIALIZAR OBJETOS = CONSTRUCTOR
        this.fdn = b;
    }
    
    public Persona(String a){           //Sobrecarga de constructores significa que puedes crear ,más de un constructor pero con diferentes parametros
        this.nombre = a;
    }
    
    public String getNombre(){ //Método getter
        return this.nombre;
    }
    
    public void setNombre(String a){ //Método setter
        this.nombre = a;
    }
    
    public Date getFdn(){  //Método get para fdn
        return this.fdn;
    }
    
    public void setFdn(Date a){ //Método setter
        this.fdn = a;
    }
    
    public boolean equals(Persona a){
        return a.nombre.equals(this.nombre) && a.fdn.equals(this.fdn);
    }
    
    public String toString(){
        return this.nombre + " - " + this.fdn;
    }
}
