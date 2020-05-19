package org.acme.getting.started;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

/**
 * DeveloperRepository
 */
@ApplicationScoped
public class DeveloperRepository implements PanacheRepository<Developer>{

    @Transactional
    public Developer createDeveloper(Developer developer){
        persist(developer);
        return developer;
    }

    public Developer findByName(String name){
        return find("name", name).firstResult();
    }


    public Developer findByNameAge(String name,Integer age){
        return find("name = ?1 and age = ?2 ", name , age).firstResult();
    }

}