/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.facade;

import rest.ejb.Aviso;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
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
public class AvisoFacade extends AbstractFacade<Aviso> {

    @PersistenceContext(unitName = "emasa-REST-serverPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AvisoFacade() {
        super(Aviso.class);
    }

    public List<Aviso> findAvisoPorUsuario(String s) {
        Query q;
        q = em.createNamedQuery("Aviso.findByUsuario");
        q.setParameter("param", s);
        List<Aviso> salida = null;
        try {
            salida = (List<Aviso>) q.getResultList();
        } catch (NoResultException e) {
            salida = null;
        }
        return salida;

    }

    public List<Aviso> findAvisoPorEstado(String s) {
        Query q;
        q = em.createNamedQuery("Aviso.findByEstado");
        q.setParameter("estado", s);
        List<Aviso> salida = null;
        try {
            salida = (List<Aviso>) q.getResultList();
        } catch (NoResultException e) {
            salida = null;
        }
        return salida;

    }

    public List<Aviso> findAvisoPorTipo(String s) {
        Query q;
        q = em.createNamedQuery("Aviso.findByTipo");
        q.setParameter("tipo", s);
        List<Aviso> salida = null;
        try {
            salida = (List<Aviso>) q.getResultList();
        } catch (NoResultException e) {
            salida = null;
        }
        return salida;

    }

    public List<Aviso> findAvisoPorPrioridad(int s) {
        Query q;
        q = em.createNamedQuery("Aviso.findByPrioridad");
        q.setParameter("prioridad", s);
        List<Aviso> salida = null;
        try {
            salida = (List<Aviso>) q.getResultList();
        } catch (NoResultException e) {
            salida = null;
        }
        return salida;
    }

    public List<Aviso> findAvisoEntre(String fecha1, String fecha2) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                formatter.applyPattern("dd-MM-yyyy");
                java.util.Date fecha = formatter.parse(fecha1);
                java.util.Date fecha3 = formatter.parse(fecha2);
        Query q;
        q = em.createNamedQuery("Aviso.findByMargen");
        q.setParameter("fecha1", fecha);
        q.setParameter("fecha2", fecha3);
        List<Aviso> salida = null;
        try {
            salida = (List<Aviso>) q.getResultList();
        } catch (NoResultException e) {
            salida = null;
        }
        return salida;
    }

}
