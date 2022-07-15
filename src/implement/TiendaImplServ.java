/*
Se necesita una aplicación para una t en la cual queremos almacenar los
distintos ps que venderemos y el precio que tendrán. Además, se necesita
que la aplicación cuente con las funciones básicas.
Estas las realizaremos en el main. Como, introducir un elemento, modificar su precio,
eliminar un producto y mostrar los ps que tenemos con su precio (Utilizar
Hashmap). El HashMap tendrá de llave el nombre del producto y de valor el precio.
Realizar un menú para lograr todas las acciones previamente mencionadas.
 */
package implement;

import entity.Tienda;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import service.TiendaService;

public class TiendaImplServ implements TiendaService {

    Tienda t = new Tienda();
    Scanner input = new Scanner(System.in).useDelimiter("\n");
    HashMap<Tienda, Integer> ps = new HashMap();

    public void Menu() throws InputMismatchException {
        int opción;
        ps = createProducts(ps);
        do {
            System.out.println("Opciones:\n"
                    + "1: Agregar productos.\n"
                    + "2: Modificar producto.\n"
                    + "3: Eliminar producto.\n"
                    + "4: Mostrar productos.\n"
                    + "5: Salir.\n");
            opción = input.nextInt();
            switch (opción) {
                case 1:
                    System.out.println("Cantidad de productos");
                    int cantProduct = input.nextInt();
                    for (int i = 0; i < cantProduct; i++) {
                        System.out.println("Nombre del proucto y precio del producto: ");
                        t.setProducto(input.next());
                        int precio = input.nextInt();
                        ps.put(t, precio);
                    }
                    break;
                case 2:
                    System.out.println("Producto que deseas modificar y su nuevo precio");
                    t.setProducto(input.next());
                    ps.replace(t, input.nextInt());
                    break;
                case 3:
                    System.out.println("Producto a remover:");
                    t.setProducto(input.next());
                    boolean flag = false;
                    if (ps.containsKey(t)) {
                        flag = true;
                    } else {
                        flag = false;
                    }
                    if (flag == true) {
                        ps.remove(t);
                    }
                    break;
                case 4:
                    mostrarProductos(ps);
                    break;
                case 5:
                    break;
            }
        } while (opción != 5);
    }

    public HashMap<Tienda, Integer> createProducts(HashMap<Tienda, Integer> ps) {
        String option;
        int p;
        HashMap<Tienda, Integer> listaProductos = ps;
        do {
            Tienda p1 = new Tienda();
            System.out.println("Producto a agregar: ");
            p1.setProducto(input.next());
            System.out.println("Precio del producto: ");
            p = input.nextInt();
            listaProductos.put(p1, p);
            System.out.println("¿Deseas agregar más productos?");
            option = input.next();
        } while (option.equalsIgnoreCase("si"));
        return listaProductos;
    }

    public void mostrarProductos(HashMap<Tienda, Integer> ps) {
        for (Map.Entry<Tienda, Integer> aux : ps.entrySet()) {
            Tienda key = aux.getKey();
            Integer value = aux.getValue();
            System.out.println("Producto: " + key + ", valor: " + value);
        }
    }
}
