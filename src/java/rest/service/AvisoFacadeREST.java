/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.service;

import java.text.ParseException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import rest.ejb.Aviso;
import rest.facade.AvisoFacade;

/**
 *
 * @author nacho
 */
@Stateless
@Path("rest.aviso")
public class AvisoFacadeREST{

    @EJB
    private AvisoFacade avisoFacade;

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Aviso entity) {
        avisoFacade.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Aviso entity) {
        avisoFacade.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        Aviso aviso = avisoFacade.find(id);
        if(aviso != null){
            avisoFacade.remove(aviso);
        }

    }
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Aviso find(@PathParam("id") Integer id) {
        return avisoFacade.find(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Aviso> findAll() {
        return avisoFacade.findAll();
    }

    @GET
    @Path("avisosUsuario/{name}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Aviso> findAvisosPorUsuario(@PathParam("name") String name) {
        return avisoFacade.findAvisoPorUsuario(name);
    }
    
    @GET
    @Path("avisosEstado/{name}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Aviso> findAvisoPorEstado(@PathParam("name") String name) {
        return avisoFacade.findAvisoPorEstado(name);
    }

    @GET
    @Path("avisosTipo/{name}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Aviso> findAvisoPorTipo(@PathParam("name") String name) {
        return avisoFacade.findAvisoPorTipo(name);
    }
    
    @GET
    @Path("avisosPrioridad/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Aviso> findAvisosPorPrioridad(@PathParam("id") Integer id) {
        return avisoFacade.findAvisoPorPrioridad(id);
    }
    
    @GET
    @Path("avisosEntre/{fecha1}/{fecha2}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Aviso> findAvisosEntre(@PathParam("fecha1") String fecha1, @PathParam("fecha2") String fecha2) throws ParseException {
        return avisoFacade.findAvisoEntre(fecha1, fecha2);
    }
    
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(avisoFacade.count());
    }

    
}
