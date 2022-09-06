
package com.portfolio.Fran.Interface;

import com.portfolio.Fran.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    
   //Trear una lista de personas
    public List<Persona> getPersona();
    
    //Guardar objeto de tipo persona
    public void savePersona(Persona persona);
    //Borrar persona por Id
    public void deletePersona(Long id);
    //Buscar una persona por Id
    public Persona findPersona(Long id);
}
