
package com.portfolio.Fran.Service;

import com.portfolio.Fran.Entity.Skills;
import com.portfolio.Fran.Repository.RepoSkills;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SkillsService {
    
    @Autowired
    RepoSkills repoS;
            
     public List<Skills> list() {
        return repoS.findAll();
    }

    public Optional<Skills> getOne(int id) {
        return repoS.findById(id);
    }

    public Optional<Skills> getByNombre(String nombre) {
        return repoS.findByNombre(nombre);
    }
    public void save(Skills skills){
        repoS.save(skills);
    }
    public void delete(int id){
        repoS.deleteById(id);
    }
    public boolean existByNombre(String nombre){
        return repoS.existsByNombre(nombre);
}
    public boolean existById(int id) {
        return repoS.existsById(id);
    }
}
