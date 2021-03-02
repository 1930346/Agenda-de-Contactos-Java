/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesep29;

import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

//EN PRUEBA DE TAREA SE LLEVA A CABO LA TERMINACIÓN DE TODA LA AGENDA POR MI PARTE
// IMPLEMENTANDO CADA FUNCIONALIDAD SEGÚN LOS MÉTODOS QUE TAMBIÉN SE AÑADEN EN EL RESTO
// DE LAS CLASES
public class PruebaDeTarea {

    /**
     * @param args the command line arguments
     */
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
        int eleccionDos = 0;
        String fechaCompleta;
        StringTokenizer st = null;
        
        
        Scanner sc = new Scanner(System.in);
        Agenda obj = new Agenda();
        Contacto contacto, tmp;
        tmp = null;
        

        
        System.out.println("\n");
        System.out.println("-------- Agenda --- Contactos: " +  nMax+1 +  " --------");
        System.out.println("Nombre  -  Fecha de nacimiento  -  Email  -  Telefono");
        obj.printAll();
        System.out.println("\n----------------------------------------------------------");
        
        //ENCARGO DE TAREA SOBRE FUNCIÓN ADD CON SWITCH
        do {
            nMax = obj.agenda.size() - 1;
            System.out.println("MENU DE OPCIONES");
            System.out.println("1.- Agregar contacto");
            System.out.println("2.- Navegar entre contactos");
            System.out.println("3.- Mostrar contactos");
            System.out.print("Elija una opción: ");
            eleccion = sc.nextLine();
            switch (eleccion) {
                case "1":
                    System.out.println("\n\nIngrese por favor los datos del contacto.");
                    System.out.print("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Fecha de nacimiento (yyyy mm dd): ");
                    fechaCompleta = sc.nextLine();
                    st = new StringTokenizer(fechaCompleta, " ");
                    fdn = new Date((Integer.parseInt(st.nextElement().toString())-1900), (Integer.parseInt(st.nextElement().toString())-1), Integer.parseInt(st.nextElement().toString()));
                    System.out.print("email: ");
                    email = sc.nextLine();
                    System.out.print("Telefono: ");
                    telefono = sc.nextLong();
                    sc.nextLine();    //Se agrega esto, porque nextLong no consume el \n, entonces no funcionaría el ciclo
                    contacto = new Contacto(nombre, fdn, email, telefono);
                    obj.agregarContacto(contacto);
                    System.out.println("Contacto agregado");
                    nMax = obj.agenda.size() - 1;
                    obj.guardarAgenda();
                    break;
                case "2":
                    //q - > mover arriba (hacia el primero)    w -> abajo (hacia el ultimo)
                    try {
                        
                        System.out.println("\n\nNavegar en la agenda");
                        System.out.println("q -> arriba, w -> abajo, s -> salir, x -> eliminar, e -> editar");
                        System.out.println(obj.navegarAgenda(n).toString());
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
                            if (op == 'x') {
                                System.out.print("¿Está seguro (s/n)? ");
                                op = sc.nextLine().trim().charAt(0);
                                if (op == 's') {
                                    System.out.println(obj.eliminarContacto(n));
                                    System.out.println("Contacto eliminado");
                                    if (n == nMax) {
                                        n = n - 1;
                                        nMax = n;
                                    }else if (n == 0){
                                        n = n + 1;
                                        nMax = nMax - 1;
                                    }else if (n > 0 && n < nMax){
                                        n = n - 1;
                                        nMax = nMax - 1;
                                    }
                                    obj.guardarAgenda();
                                }else{
                                    System.out.println("Acción no realizada.");
                                }
                                System.out.println("\n\n" + obj.navegarAgenda(n).toString());
                            }
                            if (op == 'e') {
                                System.out.print("¿Está seguro (s/n)? ");
                                op = sc.nextLine().trim().charAt(0);
                                if (op == 's') {
                                    obj.eliminarContacto(n);
                                    System.out.println("Ingrese por favor los datos del contacto.");
                                    System.out.print("Nombre: ");
                                    nombre = sc.nextLine();
                                    System.out.print("Fecha de nacimiento (yyyy mm dd): ");
                                    fechaCompleta = sc.nextLine();
                                    st = new StringTokenizer(fechaCompleta, " ");
                                    fdn = new Date((Integer.parseInt(st.nextElement().toString())-1900), (Integer.parseInt(st.nextElement().toString())-1), Integer.parseInt(st.nextElement().toString()));
                                    System.out.print("email: ");
                                    email = sc.nextLine();
                                    System.out.print("Telefono: ");
                                    telefono = sc.nextLong();
                                    sc.nextLine();    //Se agrega esto, porque nextLong no consume el \n, entonces no funcionaría el ciclo
                                    contacto = new Contacto(nombre, fdn, email, telefono);
                                    obj.agregarContacto(contacto,n);
                                    obj.guardarAgenda();  
                                    System.out.println("\nContacto modificado.");
                                    System.out.println("\n" + obj.navegarAgenda(n).toString());
                                }else{
                                    System.out.println("\n" + obj.navegarAgenda(n).toString());
                                }
                                
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case "3":
                    System.out.println("\n");
                    System.out.println("-------- Agenda --- Contactos: " +  nMax+1 +  " --------");
                    System.out.println("Nombre  -  Fecha de nacimiento  -  Email  -  Telefono");
                    obj.printAll();
                    System.out.println("\n----------------------------------------------------------");
                    break;
                default:
                    System.out.println("Opción no existente");
                    break;
            }    
            
            System.out.print("\n\nDesea salir de la aplicación (0 salir) (1 continuar): ");
            eleccionDos = sc.nextInt();
            sc.nextLine();
        } while (eleccionDos != 0);
        
        
        

       
        ban_1 = obj.guardarAgenda();
        System.out.println("Guardando lista de contactos..." + ban_1);
        //Si muestra true se gguardo la lista a un archivo
        //si muestra false hubo una excepcion y no se guardo la list al archivo
        
    }
    
}
