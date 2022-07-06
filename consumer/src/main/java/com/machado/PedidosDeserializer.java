package com.machado;

import com.machado.model.Pedido;
import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class PedidosDeserializer extends ObjectMapperDeserializer<Pedido> {
   public PedidosDeserializer() {
      super(Pedido.class);
   }
}
