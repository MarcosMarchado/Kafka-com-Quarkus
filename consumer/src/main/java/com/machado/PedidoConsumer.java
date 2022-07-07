package com.machado;

import com.machado.model.Pedido;
import com.machado.model.PedidoEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class PedidoConsumer {

   private Logger log = LoggerFactory.getLogger(PedidoConsumer.class);

   @Incoming("pedido") //Indica que o método consome os itens do requests Channel.
   @Transactional
   public Pedido process(Pedido pedido) throws InterruptedException {
      // simulate some hard working task
      //Thread.sleep(200);
      log.info("Nome {} | Preço {}", pedido.getNome(), pedido.getTotal());
      PedidoEntity pedidoEntity = new PedidoEntity(pedido.getNome(), pedido.getTotal());
      pedidoEntity.persist();
      return pedido;
   }
}
