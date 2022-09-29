
package com.portfolio.Fran.Service;

import com.portfolio.Fran.Entity.Educacion;
import com.portfolio.Fran.Repository.RepoEducacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService {

    @Autowired
    RepoEducacion repoEdu;

    public List<Educacion> list() {
        return repoEdu.findAll();
    }

    public Optional<Educacion> getOne(int id) {
        return repoEdu.findById(id);
    }

    public Optional<Educacion> getByNombreE(String nombreE) {
        return repoEdu.findByNombreE(nombreE);
    }

    public void save(Educacion educacion) {
        repoEdu.save(educacion);
    }

    public void delete(int id) {
        repoEdu.deleteById(id);
    }

    
    public boolean existByNombreE(String nombreE){
        return repoEdu.existsByNombreE(nombreE);
}
    public boolean existById(int id) {
        return repoEdu.existsById(id);
    }
}
