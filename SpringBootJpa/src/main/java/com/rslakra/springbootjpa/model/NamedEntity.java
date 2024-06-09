package com.rslakra.springbootjpa.model;

import com.rslakra.springbootjpa.service.security.EntityPersistenceListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @Created Aug 31, 2021 21:05:35
 */
@MappedSuperclass
@EntityListeners(EntityPersistenceListener.class)
public abstract class NamedEntity extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    public NamedEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
