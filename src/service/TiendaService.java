/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Tienda;
import java.util.HashMap;

public interface TiendaService {
    public void Menu();
    public HashMap<Tienda, Integer> createProducts(HashMap<Tienda, Integer> productos);
     public void mostrarProductos(HashMap<Tienda, Integer> productos);
}
