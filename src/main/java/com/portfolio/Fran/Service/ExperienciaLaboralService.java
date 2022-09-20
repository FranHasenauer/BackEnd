package com.portfolio.Fran.Service;

import com.portfolio.Fran.Entity.ExperienciaLaboral;
import com.portfolio.Fran.Repository.RepoExperienciaLaboral;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaLaboralService {

    @Autowired
    RepoExperienciaLaboral repoExperienciaLaboral;

    public List<ExperienciaLaboral> list() {
        return repoExperienciaLaboral.findAll();
    }

    public Optional<ExperienciaLaboral> getOne(int id){
        return repoExperienciaLaboral.findById(id);
    }
    
    public Optional<ExperienciaLaboral> getByNombreEmpresa(String nombreEmpresa){
        return repoExperienciaLaboral.findByNombreEmpresa(nombreEmpresa);
    }
    public void save(ExperienciaLaboral experienciaLaboral){
        repoExperienciaLaboral.save(experienciaLaboral);
    }
    public void delete(int id){
        repoExperienciaLaboral.deleteById(id);
    }
    public boolean existById(int id){
        return repoExperienciaLaboral.existsById(id);
    }
    public boolean existByNombreEmpresa(String nombreEmpresa){
        return repoExperienciaLaboral.existsByNombreEmpresa(nombreEmpresa);
    }
}
