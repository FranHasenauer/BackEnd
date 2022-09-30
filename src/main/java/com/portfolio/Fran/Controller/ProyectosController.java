package com.portfolio.Fran.Controller;

import com.portfolio.Fran.Dto.DtoProyectos;
import com.portfolio.Fran.Entity.Proyectos;
import com.portfolio.Fran.Security.Controller.Mensaje;
import com.portfolio.Fran.Service.ProyectosService;
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
@RequestMapping("pro")
@CrossOrigin(origins = "https://frontendfranh.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class ProyectosController {

    @Autowired
    ProyectosService proService;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list() {
        List<Proyectos> list = proService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id) {

        if (!proService.existById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }

        Proyectos proyectos = proService.getOne(id).get();

        return new ResponseEntity(proyectos, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyectos dtoPro) {
        if (StringUtils.isBlank(dtoPro.getNombreP())) {
            return new ResponseEntity(new Mensaje("Necesitas poner un nombre a tu proyecto"), HttpStatus.BAD_REQUEST);
        }
        if (proService.existByNombreP(dtoPro.getNombreP())) {
            return new ResponseEntity(new Mensaje("Proyecto ya existente"), HttpStatus.BAD_REQUEST);
        }
        Proyectos proyectos = new Proyectos(dtoPro.getNombreP(), dtoPro.getDescripcionP(), dtoPro.getUrlP(), dtoPro.getImgP());
        proService.save(proyectos);
        return new ResponseEntity(new Mensaje("proyecto creado!"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyectos dtoPro) {
        if (!proService.existById(id)) {
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.BAD_REQUEST);
        }

        if (proService.existByNombreP(dtoPro.getNombreP()) && proService.getByNombreP(dtoPro.getNombreP()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("proyecto ya existente"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoPro.getNombreP())) {
            return new ResponseEntity(new Mensaje("Necesitas poner un nombre"), HttpStatus.BAD_REQUEST);
        }

        Proyectos proyectos = proService.getOne(id).get();
        proyectos.setNombreP(dtoPro.getNombreP());
        proyectos.setDescripcionP(dtoPro.getDescripcionP());
        proyectos.setUrlP(dtoPro.getUrlP());
        proyectos.setImgP(dtoPro.getImgP());

        proService.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!proService.existById(id)) {
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.BAD_REQUEST);
        }
        proService.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }

}
