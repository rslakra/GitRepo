package com.rslakra.springbootjpa.service.security;

import com.rslakra.springbootjpa.model.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.transaction.Transactional;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @Created Aug 31, 2021 20:44:23
 */
public class EntityPersistenceListener {

    // LOGGER
    private static Logger LOGGER = LoggerFactory.getLogger(EntityPersistenceListener.class);

    public enum Operation {
        INSERTED,
        UPDATED,
        DELETED;
    }

    public EntityPersistenceListener() {
        LOGGER.debug("EntityPersistenceListener()");
    }

    /**
     * @param baseEntity
     */
    @PrePersist
    public void prePersist(BaseEntity baseEntity) {
        persistEntity(Operation.INSERTED, baseEntity);
    }

    /**
     * @param baseEntity
     */
    @PreUpdate
    public void preUpdate(BaseEntity baseEntity) {
        persistEntity(Operation.UPDATED, baseEntity);
    }

    /**
     * @param baseEntity
     */
    @PreRemove
    public void preRemove(BaseEntity baseEntity) {
        persistEntity(Operation.DELETED, baseEntity);
    }

    /**
     * @param operation
     * @param baseEntity
     */
    @Transactional(Transactional.TxType.MANDATORY)
    void persistEntity(final Operation operation, BaseEntity baseEntity) {
        LOGGER.debug("persistEntity({}, {})", operation, baseEntity);
//        EntityManager entityManager = AppContextAware.getBean(EntityManager.class);
//        entityManager.persist(baseEntity);
    }

}
