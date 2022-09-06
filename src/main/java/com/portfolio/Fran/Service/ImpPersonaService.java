
package com.portfolio.Fran.Service;

import com.portfolio.Fran.Entity.Persona;
import com.portfolio.Fran.Interface.IPersonaService;
import com.portfolio.Fran.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements IPersonaService {
    @Autowired IPersonaRepository ipersonaRepo;
            
    @Override
    public List<Persona> getPersona() {
   List<Persona> persona = ipersonaRepo.findAll();
   return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonaRepo.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
ipersonaRepo.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
    Persona persona = ipersonaRepo.findById(id).orElse(null);
    return persona;
    }
    
}
