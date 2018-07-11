package com.redbee.microblog.controller;

import com.redbee.microblog.entity.PersonaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  PersonaRepository extends CrudRepository<PersonaEntity, Integer> {
  //  AgentEntity findFirstByName(String name);
 // PersonaEntity findOne(long id);
}
