/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesep29;

import java.util.*;

//Esto es la AGENDA COMO TAL, que es donde se tienen dichos métodos con un ArrayList
//Además se usa un Iterator.

public class Agenda {
    //Atributo(s) de la clase
    List <Contacto>agenda;
    Contacto tmp;

    Agenda(){
        ControladorAgenda ca = new ControladorAgenda();
        ArrayList obj = ca.obtenObjetoDeArchivo();
        agenda = obj;
        if (obj == null) {
            agenda = new <Contacto>ArrayList();
        }
        
        tmp = null; //Para uso propio del objeto para el paso de parametros
    }


    //comportamiento de la clase
    // 1) Buscar Contacto
    //a) Telefono, Regresa null sino encuentra un contacto con ese telefono
    public Contacto buscarContacto(long telefono){
        Iterator it;
        it = agenda.iterator();
        while(it.hasNext()){
            tmp = (Contacto)it.next();
                if(tmp.telefono == telefono){
                    return tmp;
                }
        }
            return null;
    }

    //Agregar un contacto a la lista AGENDA
    public void agregarContacto(Contacto a){
        agenda.add(a);
    }  
    //Agregado para editar
    public void agregarContacto(Contacto a, int n){
        agenda.add(n,a);
    }  

    //Muestra cada contacto en forma secuencial desde el primero al último y 
    //forma bidireccional
    //n representa el índice del elemento en la lista
    public Contacto navegarAgenda(int n){
        if (n >= 0 || n < agenda.size()) {
            return (Contacto)agenda.get(n);
        }else{
            return null;  //n no estuvo en el rango 0 la agenda está vacía
        }
    }
    
    //Métodos para inflar y deflactar los contactos de la agenda
    //Esta parte se refiere a la persistencia de datos
    //La persistencia se hace mediante un archivo .ser
    //.ser -> Almacena objectos
    //Inflar es al inicio
    //Cuando finalice es deflactar
    
    public boolean guardarAgenda(){ //Al salir de la app guarda la agenda archivo
        ControladorAgenda ca = new ControladorAgenda();
        return ca.guardarAgenda((Object)agenda);
        //En esta parte se separa la lógica de negocio de la entidad
        //Se manda el objeto ArrayLIst al método del controlador
        //Para guardarlo en un archivo
    }
    
    
    
    //MÉTODOS DE PRUEBA DE TAREA PARA DIA 28/10/2020 MIÉRCOLES
    
    
    public void printAll(){
        Iterator it;
        it = agenda.iterator();
        while(it.hasNext()){
            tmp = (Contacto)it.next();
            System.out.println(tmp.toString() + " " );
        }
    }
    
    public Contacto eliminarContacto(int n){
        return agenda.remove(n);
    }
    
    
}
