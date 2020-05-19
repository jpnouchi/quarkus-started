package org.acme.getting.started;

import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Developer
 */
@Entity
public class Developer extends PanacheEntity{

    @Column(unique = true)
    private String name;

    @Column
    private Integer age;

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    
}