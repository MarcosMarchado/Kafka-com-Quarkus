package com.machado.controller;

import com.machado.model.PedidoEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/pedidos")
public class ConsultaPedidosController {

   @GET
   public List<PedidoEntity> listaPedidos(Page page){
      return PedidoEntity.findAll().list();
      //return PedidoEntity.listAll();
   }

}
