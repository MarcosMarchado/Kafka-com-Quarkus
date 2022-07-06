package com.machado;

import com.machado.model.Pedido;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.concurrent.CompletionStage;

@Path("pedidos")
public class PedidoResource {

   @Channel("pedido-efetuado")
   Emitter<Pedido> pedidoEfetuado;

   @POST
   public Response finalizaPedido(Pedido pedido){
      pedidoEfetuado.send(pedido);
      return Response.ok(pedido).build();
   }

}
