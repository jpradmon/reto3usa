/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ciclo3.Reto3.repository;

import Ciclo3.Reto3.interfaces.interfaceCabana;
import Ciclo3.Reto3.model.Cabin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Webminar
 */
@Repository
public class RepositorioCabin {

    @Autowired
    private interfaceCabana crud;

    public List<Cabin> getAll() {
        return (List<Cabin>) crud.findAll();
    }

    public Optional<Cabin> getCabin(int id) {
        return crud.findById(id);
    }

    public Cabin save(Cabin cabin) {
        return crud.save(cabin);
    }

    public void delete(Cabin cabin) {
        crud.delete(cabin);
    }

}
