/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.facade;

import rest.ejb.Aviso;
import rest.ejb.Operacion;
import java.sql.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author nacho
 */
@Stateless
public class OperacionFacade extends AbstractFacade<Operacion> {

    @PersistenceContext(unitName = "emasa-REST-serverPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OperacionFacade() {
        super(Operacion.class);
    }
    
    public List<Operacion> findListaOperaciones(int id) {
        System.err.println("id : "+id);
        Query q;
        q = em.createNamedQuery("Operacion.findByIdAviso");
        q.setParameter("id", id);
        List<Operacion> salida = null;
        try {
            salida = (List<Operacion>) q.getResultList();
        } catch (NoResultException e) {
            salida = null;
        }
        return salida;
    }
    
}
