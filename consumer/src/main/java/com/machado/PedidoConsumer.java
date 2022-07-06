package com.machado;

import com.machado.model.Pedido;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PedidoConsumer {

   private Logger log = LoggerFactory.getLogger(PedidoConsumer.class);

   @Incoming("pedido") //Indica que o método consome os itens do requests Channel.
   public Pedido process(Pedido pedido) throws InterruptedException {
      // simulate some hard working task
      //Thread.sleep(200);
      log.info("Nome {} | Preço {}", pedido.getNome(), pedido.getTotal());
      return pedido;
   }
}
