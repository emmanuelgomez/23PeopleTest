package com.redbee.microblog.controller;

import com.redbee.microblog.entity.PersonaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class PersonaController {
    @Autowired
    private PersonaRepository personaRepository;



    @RequestMapping(value = "/persona/", method = RequestMethod.GET)
    public ResponseEntity<Iterable<PersonaEntity>> listAllPersonas() {
        Iterable<PersonaEntity> personas = personaRepository.findAll();

        return new ResponseEntity<Iterable<PersonaEntity>>(personas, HttpStatus.OK);
    }

    // -------------------Retrieve Single Persona------------------------------------------

    @RequestMapping(value = "/persona/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPersona(@PathVariable("id") int id) {
        PersonaEntity personaEntity = personaRepository.findById(id).get();
        return new ResponseEntity<PersonaEntity>(personaEntity, HttpStatus.OK);
    }

    // -------------------Create a Persona-------------------------------------------

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<?> createPersona(@RequestBody PersonaEntity personaEntity, UriComponentsBuilder ucBuilder) {


        personaRepository.save(personaEntity);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(personaEntity.getIdPersona()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    // ------------------- Update a Persona ------------------------------------------------

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public PersonaEntity updateUser(@PathVariable("id") int id, @RequestBody PersonaEntity personaEntityRequest) {

        PersonaEntity personaEntity = personaRepository.findById(id).get();



        personaEntity.setNombre(personaEntityRequest.getNombre());
        personaEntity.setApellidos(personaEntityRequest.getApellidos());

        personaRepository.save(personaEntity);

        return personaEntity;
    }

    // ------------------- Delete a User-----------------------------------------

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
        PersonaEntity personaEntity = personaRepository.findById(id).get();
        personaRepository.delete(personaEntity);
        return new ResponseEntity<PersonaEntity>(HttpStatus.NO_CONTENT);
    }


}


