
package com.portfolio.Fran.Controller;

import com.portfolio.Fran.Dto.DtoSkills;
import com.portfolio.Fran.Entity.Skills;
import com.portfolio.Fran.Security.Controller.Mensaje;
import com.portfolio.Fran.Service.SkillsService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skill")
public class SkillsController {

    @Autowired
    SkillsService skillsService;

    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list() {
        List<Skills> list = skillsService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id) {

        if (!skillsService.existById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }

        Skills skills = skillsService.getOne(id).get();

        return new ResponseEntity(skills, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoSkills dtoSkills) {
        if (StringUtils.isBlank(dtoSkills.getNombre())) {
            return new ResponseEntity(new Mensaje("Necesitas poner un nombre a tu habilidad"), HttpStatus.BAD_REQUEST);
        }
        if (skillsService.existByNombre(dtoSkills.getNombre())) {
            return new ResponseEntity(new Mensaje("Habilidad ya existente"), HttpStatus.BAD_REQUEST);
        }
        Skills skills = new Skills(dtoSkills.getNombre(), dtoSkills.getPorcentaje());
        skillsService.save(skills);
        return new ResponseEntity(new Mensaje("habilidad creado!"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSkills dtoSkills) {
        if (!skillsService.existById(id)) {
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.BAD_REQUEST);
        }

        if (skillsService.existByNombre(dtoSkills.getNombre()) && skillsService.getByNombre(dtoSkills.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("habilidad ya existente"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoSkills.getNombre())) {
            return new ResponseEntity(new Mensaje("Necesitas poner un nombre"), HttpStatus.BAD_REQUEST);
        }

        Skills skills = skillsService.getOne(id).get();
        skills.setNombre(dtoSkills.getNombre());
        skills.setPorcentaje(dtoSkills.getPorcentaje());

        skillsService.save(skills);
        return new ResponseEntity(new Mensaje("Skill actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!skillsService.existById(id)) {
            return new ResponseEntity(new Mensaje("ID inexistente"), HttpStatus.BAD_REQUEST);
        }
        skillsService.delete(id);
        return new ResponseEntity(new Mensaje("habilidad eliminada"), HttpStatus.OK);
    }

}
