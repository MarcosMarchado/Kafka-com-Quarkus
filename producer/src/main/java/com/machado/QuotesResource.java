package com.machado;

import com.machado.model.Quote;
import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("/quotes")
public class QuotesResource {

   private Logger log = LoggerFactory.getLogger(QuotesResource.class);

   @Channel("quotes")
   Multi<Quote> quotes;

   @Channel("quote-requests")
   Emitter<String> quoteRequestEmitter;
   /* gerenciado como um tópico Kafka, pois é o único conector no caminho de classe.
   Se não houver outra indicação, como neste exemplo, o Quarkus usa o nome do canal como nome do tópico*/
   @POST
   @Path("/request")
   @Produces(MediaType.TEXT_PLAIN)
   public String createRequest() {
      UUID uuid = UUID.randomUUID();
      quoteRequestEmitter.send(uuid.toString());
      log.info("ID {}", uuid.toString());
      return uuid.toString();
   }

   @GET
   @Produces(MediaType.SERVER_SENT_EVENTS)
   public Multi<Quote> stream() {
      return quotes;
   }
}
