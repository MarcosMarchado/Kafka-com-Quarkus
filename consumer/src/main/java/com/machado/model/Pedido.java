package com.machado.model;

public class Pedido {

   private String nome;
   private Double total;

   public Pedido() {
   }

   public Pedido(String nome, Double total) {
      this.nome = nome;
      this.total = total;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public Double getTotal() {
      return total;
   }

   public void setTotal(Double total) {
      this.total = total;
   }
}
