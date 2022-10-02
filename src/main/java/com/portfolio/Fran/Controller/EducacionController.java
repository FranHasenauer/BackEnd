
package com.portfolio.Fran.Controller;

import com.portfolio.Fran.Dto.DtoEducacion;
import com.portfolio.Fran.Entity.Educacion;
import com.portfolio.Fran.Security.Controller.Mensaje;
import com.portfolio.Fran.Service.EducacionService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("edu")
@CrossOrigin(origins = "**") //https://frontendfranh.web.app/
//@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {
    
    @Autowired
    EducacionService eduService;
   
    
      @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = eduService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
     @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id) {

        if (!eduService.existById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }

        Educacion educacion = eduService.getOne(id).get();

        return new ResponseEntity(educacion, HttpStatus.OK);

    }
     @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoEdu) {
        if (StringUtils.isBlank(dtoEdu.getNombreE())) {
            return new ResponseEntity(new Mensaje("Necesitas poner un nombre"), HttpStatus.BAD_REQUEST);
        }
        if (eduService.existByNombreE(dtoEdu.getNombreE())) {
            return new ResponseEntity(new Mensaje("Educacion ya existente"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = new Educacion(dtoEdu.getNombreE(), dtoEdu.getDescripcionE());
        eduService.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion creada!"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoEdu) {
        if (!eduService.existById(id)) {
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.BAD_REQUEST);
        }

        if (eduService.existByNombreE(dtoEdu.getNombreE()) && eduService.getByNombreE(dtoEdu.getNombreE()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Educacion ya existente"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoEdu.getNombreE())) {
            return new ResponseEntity(new Mensaje("Necesitas poner un nombre"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = eduService.getOne(id).get();
        educacion.setNombreE(dtoEdu.getNombreE());
        
        educacion.setDescripcionE(dtoEdu.getDescripcionE());
        
        eduService.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion laboral actualizada"), HttpStatus.OK);
    }

    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!eduService.existById(id)) {
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.BAD_REQUEST);
        }
        eduService.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }

}
