/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesep29;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

//Aquí es donde se serializa como tal y se lleva acabo el control de la Agenda mediante el 
// MODELO VISTA CONTROLADOR
public class ControladorAgenda {
    
    
    public ArrayList obtenObjetoDeArchivo(){
        ArrayList tmp = null;
        FileInputStream fis = null;
        ObjectInputStream entrada = null;
        
        try {
            fis = new FileInputStream("agenda.ser");
            entrada = new ObjectInputStream(fis);
            
            tmp = (ArrayList) entrada.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        finally{
            try {
                if (entrada != null) {
                    entrada.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return tmp;
        
    }
    
    public boolean guardarAgenda(Object a){
        //TODO
        ArrayList b = (ArrayList)a;
        boolean ban = false;
        FileOutputStream fos = null;
        ObjectOutputStream salida = null;
        
        try {
            fos = new FileOutputStream("agenda.ser");
            salida = new ObjectOutputStream(fos);
            
            salida.writeObject(b);
            ban = true;
        } catch (Exception e) {
            e.printStackTrace();
            ban = false;
        }
        
        finally{   
            try{
                if (salida != null) {
                    salida.close();
                }
                if (fos != null) {
                    fos.close();
                    return ban;
                }
            }catch(IOException e){
                e.printStackTrace();
                return ban;
            }
        }
        return ban;
    }
    
}
