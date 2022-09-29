
package com.portfolio.Fran.Repository;

import com.portfolio.Fran.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoProyectos extends JpaRepository<Proyectos, Integer> {
    public Optional<Proyectos> findByNombreP(String nombreP);
    public boolean existsByNombreP(String nombreP);
}
