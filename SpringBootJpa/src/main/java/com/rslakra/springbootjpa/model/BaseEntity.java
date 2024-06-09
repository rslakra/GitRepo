package com.rslakra.springbootjpa.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @Created Aug 31, 2021 20:34:57
 */
@MappedSuperclass
public abstract class BaseEntity extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public BaseEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return String.format("%s, id=%s", super.toString(), Objects.toString(getId()));
    }
}
