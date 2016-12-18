/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.service;

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
import rest.ejb.Operacion;
import rest.facade.OperacionFacade;

/**
 *
 * @author nacho
 */
@Stateless
@Path("rest.operacion")
public class OperacionFacadeREST {

    @EJB
    private OperacionFacade operacionFacade;
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Operacion entity) {
        operacionFacade.create(entity);
    }

    @PUT
    @Path("put/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Operacion entity) {
        operacionFacade.edit(entity);
    }

    @DELETE
    @Path("remove/{id}")
    public void remove(@PathParam("id") Integer id) {
        Operacion operacion = operacionFacade.find(id);
        if(operacion != null){
            operacionFacade.remove(operacion);
        }
        
    }

    @GET
    @Path("find/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Operacion find(@PathParam("id") Integer id) {
        return operacionFacade.find(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Operacion> findAll() {
        return operacionFacade.findAll();
    }

    @GET
    @Path("listOp/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Operacion> findByIdAviso(@PathParam("id") Integer id) {
        return operacionFacade.findListaOperaciones(id);
    }
    
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(operacionFacade.count());
    }


    
}
