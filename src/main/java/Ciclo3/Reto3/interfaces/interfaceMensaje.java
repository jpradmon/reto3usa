/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Ciclo3.Reto3.interfaces;

import Ciclo3.Reto3.model.Mensaje;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Webminar
 */
public interface interfaceMensaje extends CrudRepository<Mensaje, Integer>{
    
}