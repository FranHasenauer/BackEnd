
package com.portfolio.Fran.Repository;

import com.portfolio.Fran.Entity.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoSkills extends JpaRepository<Skills, Integer>{
    public Optional<Skills> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
    
}
