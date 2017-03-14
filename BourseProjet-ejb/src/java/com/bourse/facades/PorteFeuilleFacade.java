package com.bourse.facades;

import com.bourse.entities.PorteFeuille;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PorteFeuilleFacade extends AbstractFacade<PorteFeuille> implements PorteFeuilleFacadeLocal {

    @PersistenceContext(unitName = "BourseProjet-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PorteFeuilleFacade() {
        super(PorteFeuille.class);
    }
    
}
