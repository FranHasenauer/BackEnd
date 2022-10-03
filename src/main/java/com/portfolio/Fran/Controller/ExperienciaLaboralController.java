package com.portfolio.Fran.Controller;

import com.portfolio.Fran.Entity.ExperienciaLaboral;
import com.portfolio.Fran.Security.Controller.Mensaje;
import com.portfolio.Fran.Security.Model.DtoExperienciaLaboral;
import com.portfolio.Fran.Service.ExperienciaLaboralService;
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
@RequestMapping("expe")
public class ExperienciaLaboralController {

    @Autowired
    ExperienciaLaboralService experienciaLaboralService;

    @GetMapping("/lista")
    public ResponseEntity<List<ExperienciaLaboral>> list() {
        List<ExperienciaLaboral> list = experienciaLaboralService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<ExperienciaLaboral> getById(@PathVariable("id") int id) {

        if (!experienciaLaboralService.existById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }

        ExperienciaLaboral experiencia = experienciaLaboralService.getOne(id).get();

        return new ResponseEntity(experiencia, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperienciaLaboral dtoExp) {
        if (StringUtils.isBlank(dtoExp.getNombreEmpresa())) {
            return new ResponseEntity(new Mensaje("Necesitas poner un nombre"), HttpStatus.BAD_REQUEST);
        }
        if (experienciaLaboralService.existByNombreEmpresa(dtoExp.getNombreEmpresa())) {
            return new ResponseEntity(new Mensaje("Experiencia ya existente"), HttpStatus.BAD_REQUEST);
        }
        ExperienciaLaboral experienciaLaboral = new ExperienciaLaboral(dtoExp.getNombreEmpresa(), dtoExp.getFechaIn(), dtoExp.getFechaOut(), dtoExp.getPuestoEmpresa(), dtoExp.getDomicilioEmpresa(), dtoExp.getDescripcionEmpresa(), dtoExp.getUrlEmpresa());
        experienciaLaboralService.save(experienciaLaboral);
        return new ResponseEntity(new Mensaje("Experiencia creada!"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperienciaLaboral dtoExp) {
        if (!experienciaLaboralService.existById(id)) {
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.BAD_REQUEST);
        }

        if (experienciaLaboralService.existByNombreEmpresa(dtoExp.getNombreEmpresa()) && experienciaLaboralService.getByNombreEmpresa(dtoExp.getNombreEmpresa()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Experiencia ya existente"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoExp.getNombreEmpresa())) {
            return new ResponseEntity(new Mensaje("Necesitas poner un nombre"), HttpStatus.BAD_REQUEST);
        }

        ExperienciaLaboral experienciaLaboral = experienciaLaboralService.getOne(id).get();
        experienciaLaboral.setNombreEmpresa(dtoExp.getNombreEmpresa());
        experienciaLaboral.setFechaIn(dtoExp.getFechaIn());
        experienciaLaboral.setFechaOut(dtoExp.getFechaOut());
        experienciaLaboral.setPuestoEmpresa(dtoExp.getPuestoEmpresa());
        experienciaLaboral.setDomicilioEmpresa(dtoExp.getDomicilioEmpresa());
        experienciaLaboral.setDescripcionEmpresa(dtoExp.getDescripcionEmpresa());
        experienciaLaboral.setUrlEmpresa(dtoExp.getUrlEmpresa());
        experienciaLaboralService.save(experienciaLaboral);
        return new ResponseEntity(new Mensaje("Experiencia laboral actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!experienciaLaboralService.existById(id)) {
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.BAD_REQUEST);
        }
        experienciaLaboralService.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }

}
