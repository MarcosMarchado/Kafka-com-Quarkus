package com.machado;

import com.machado.model.Pedido;
import com.machado.model.Quote;
import io.smallrye.common.annotation.Blocking;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;

@ApplicationScoped
public class QuotesProcessor {

   private Random random = new Random();

   @Incoming("requests") //Indica que o método consome os itens do requests Channel.
   @Outgoing("quotes") //Indica que os objetos retornados pelo método são enviados ao quotes Channel.
   @Blocking //Indica que o processamento está bloqueando e não pode ser executado no thread do chamador.
   public Quote process(String quoteRequest) throws InterruptedException {
      // simulate some hard working task
      Thread.sleep(200);
      return new Quote(quoteRequest, random.nextInt(100));
   }


}
