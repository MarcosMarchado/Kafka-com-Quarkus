package com.machado.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class PedidoEntity extends PanacheEntity {
   private String nome;
   private Double total;

   public PedidoEntity() {
   }

   public PedidoEntity(String nome, Double total) {
      this.nome = nome;
      this.total = total;
   }

  public String getNome() {
      return nome;
   }

   public Double getTotal() {
      return total;
   }

}
