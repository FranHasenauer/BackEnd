/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.Fran.Service;

import com.portfolio.Fran.Entity.Proyectos;
import com.portfolio.Fran.Repository.RepoProyectos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectosService {

    @Autowired
    RepoProyectos repoP;

    public List<Proyectos> list() {
        return repoP.findAll();
    }

    public Optional<Proyectos> getOne(int id) {
        return repoP.findById(id);
    }

    public Optional<Proyectos> getByNombreP(String nombreP) {
        return repoP.findByNombreP(nombreP);
    }
    public void save(Proyectos proyectos){
        repoP.save(proyectos);
    }
    public void delete(int id){
        repoP.deleteById(id);
    }
    public boolean existByNombreP(String nombreP){
        return repoP.existsByNombreP(nombreP);
}
    public boolean existById(int id) {
        return repoP.existsById(id);
    }
    
}
