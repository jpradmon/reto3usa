/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ciclo3.Reto3.service;

import Ciclo3.Reto3.model.Cabin;
import Ciclo3.Reto3.repository.RepositorioCabin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Webminar
 */
@Service
public class ServicioCabin {

    @Autowired
    private RepositorioCabin metodosCrud;

    public List<Cabin> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Cabin> getCabin(int idCabin) {
        return metodosCrud.getCabin(idCabin);
    }

    public Cabin save(Cabin cabin) {
        if (cabin.getId() == null) {
            return metodosCrud.save(cabin);
        } else {
            Optional<Cabin> evt = metodosCrud.getCabin(cabin.getId());
            if (evt.isEmpty()) {
                return metodosCrud.save(cabin);
            } else {
                return cabin;
            }
        }
    }

    public Cabin update(Cabin cabin) {
        if (cabin.getId() != null) {
            Optional<Cabin> e = metodosCrud.getCabin(cabin.getId());
            if (!e.isEmpty()) {
                if (cabin.getName() != null) {
                    e.get().setName(cabin.getName());
                }
                if (cabin.getBrand() != null) {
                    e.get().setBrand(cabin.getBrand());
                }
                if (cabin.getDescription() != null) {
                    e.get().setDescription(cabin.getDescription());
                }
                if (cabin.getCategory() != null) {
                    e.get().setCategory(cabin.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return cabin;
            }
        } else {
            return cabin;
        }
    }

    public boolean deleteCabin(int cabinId) {
        Boolean aBoolean = getCabin(cabinId).map(cabin -> {
            metodosCrud.delete(cabin);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
