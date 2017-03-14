package com.bourse.facades;

import com.bourse.entities.Contrat;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ContratFacade extends AbstractFacade<Contrat> implements ContratFacadeLocal {

    @PersistenceContext(unitName = "BourseProjet-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContratFacade() {
        super(Contrat.class);
    }
    
}
