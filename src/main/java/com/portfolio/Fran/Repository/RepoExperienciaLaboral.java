package com.portfolio.Fran.Repository;

import com.portfolio.Fran.Entity.ExperienciaLaboral;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoExperienciaLaboral extends JpaRepository<ExperienciaLaboral, Integer> {

    public Optional<ExperienciaLaboral> findByNombreEmpresa(String nombreE);

    public boolean existsByNombreEmpresa(String nombreE);
}
