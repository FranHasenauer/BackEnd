
package com.portfolio.Fran.Security.Repository;

import com.portfolio.Fran.Security.Entity.Rol;
import com.portfolio.Fran.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol>  findByRolNombre(RolNombre rolNombre);
    
}
