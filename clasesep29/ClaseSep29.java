/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesep29;

import java.util.Date;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ClaseSep29 {
//ESTA CLASE TRATO RESPECTO A LA SERIALIZACIÓN Y DES-SERIALIZAR CLASES QUE A LA VEZ TENIAN HERENCIA
// Y se maneja el problema de AGENDA DE CONTACTOS, ESTE MAIN ES IMPLEMENTADO POR EL PROFESOR
// SE MANEJA EL USO DE SIMPLE LINKED LIST (LISTA SIMPLEMENTE ENLAZADA)
// Se mantiene repositorio en BitBucket Y listas con arrayList
    public static void main(String[] args) {
        String nombre;
        Date fdn;
        String email;
        long telefono;
        int n = 0;
        int nMax = 0;
        char op = '0';
        boolean ban_1 = false;
        
        //añadido
        String eleccion = "";
        String fechaCompleta;
        StringTokenizer st = null;
        
        
        Scanner sc = new Scanner(System.in);
        Agenda obj = new Agenda();
        Contacto contacto, tmp;
        tmp = null;
        
        //Comienza la prueba de agenda
        //CONSTRUCTOR CON 4 PARAMETROS
        /*
        SE COMENTÓ PORQUE YA NO ES NECESARIO YA QUE YA TENEMOS OBJETOS, AHORA LO HARÉMOS PARA QUE SEA DE OPCIÓN
        nombre = "Mafalda Gomez";
        fdn = new Date(100, 2, 17); // enero=> 0, febrero=> 1, marzo=> 2
        email = "mafalda@upv.edu.mx";
        telefono = 8343218965L;
        contacto = new Contacto(nombre,fdn, email, telefono);
        obj.agregarContacto(contacto);
        
        
        
        nombre = "Felipillo Pérez";
        fdn = new Date(100, 5, 18); // enero=> 0, febrero=> 1, marzo=> 2
        email = "felipillo@upv.edu.mx";
        telefono = 8341238578L;
        contacto = new Contacto(nombre,fdn, email, telefono);
        obj.agregarContacto(contacto);
        
        
        nombre = "Carlitos Schultz";
        fdn = new Date(100, 10, 10); // enero=> 0, febrero=> 1, marzo=> 2
        email = "carlitos@upv.edu.mx";
        telefono = 8342038578L;
        contacto = new Contacto(nombre,fdn, email, telefono);
        obj.agregarContacto(contacto);
        */
        nMax = obj.agenda.size() - 1;
        
        
        try{
            tmp = obj.buscarContacto(83432138965L);
            
        }
        catch (Exception e){
            e.printStackTrace();
        }

        //EN CASO DE QUE EL PROFE LO HAGA DE OTRA FORMA DESCOMENTAR TODO LO DE ABAJO y borrar mi switch
        

        //q - > mover arriba (hacia el primero)    w -> abajo (hacia el ultimo)
        try {
            System.out.println("Navegar en la agenda");
            System.out.println(obj.navegarAgenda(n).toString());
            System.out.println("q -> arriba, w -> abajo, s -> salir");
            while (true) {
                op = sc.nextLine().trim().charAt(0);
                if (op == 's') {
                    break;
                }
                if (op == 'q') {
                    if (n == 0) {
                        n = 0;
                        System.out.println(obj.navegarAgenda(n).toString());
                    }
                    if (n > 0 && n <= nMax) {
                        n = n - 1;
                        System.out.println(obj.navegarAgenda(n).toString());
                    }
                }
                if (op == 'w') {
                    if (n == nMax) {
                        n = nMax;
                        System.out.println(obj.navegarAgenda(n).toString());
                    }
                    if (n >= 0 && n < nMax) {
                        n = n + 1;
                        System.out.println(obj.navegarAgenda(n).toString());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        finally{
            ban_1 = obj.guardarAgenda();
            System.out.println("Guardando lista de contactos..." + ban_1);
            //Si muestra true se gguardo la lista a un archivo
            //si muestra false hubo una excepcion y no se guardo la list al archivo
        }
        
        
        //AQUÍ ABAJO SE ENCUENTRA EL CÓDIGO QUE FUE EXPLICATIVO EN LA CLASE, TODO LO ANTERIOR ES EN BASE AL PROYECTO AGENDA
        //SIGUIENDO EL ENFOQUE "MODELO-VISTA-CONTROLADOR"
        
        
        //CONSTRUCTOR CON 4 PARAMETROS  Y AQUÍ ABAJO SERIALIZAR -----------------
        /* 
        nombre = "Mafalda Gomez";
        fdn = new Date(101, 3, 7);
        email = "mafalda@upv.edu.mx";
        telefono = 8343218965L;
      
        Contacto mafalda = new Contacto(nombre, fdn, email, telefono);
        System.out.println(mafalda.toString());
    */
        //Practica de programación, correcta, aunque ambas lo son;
        //SERIALIZACIÓN
        /*
        FileOutputStream fos = null;
        ObjectOutputStream salida = null;
        try {
            fos = new FileOutputStream("data.ser");
            salida = new ObjectOutputStream(fos);
            
            salida.writeObject(mafalda);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        finally{   
            try{
                if (salida != null) {
                    salida.close();
                }
                if (fos != null) {
                    fos.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        */
        
        
        //DES-SERIALIZAR ------------------------
        /*
        Contacto contacto = null;
        FileInputStream fis = null; //El archivo de lectura = FUENTE de datos
        ObjectInputStream entrada = null; // De la fuente de datos a la app
        
        try {
            fis = new FileInputStream("data.ser");
            entrada = new ObjectInputStream(fis);
            
            contacto = (Contacto) entrada.readObject(); //Se pone conectacto porque sabemos
                        //Pero en caso de que no sepamos se utiliza un getClass();
            System.out.println("CONTACTO: " + contacto.toString());
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        */
        
        //AQUÍ CONCLUYE LA EXPLICACIÓN DE SERIALIZACIÓN Y DES SERIALIZACIÓN DE LA CLASE
        
    }
    
}
