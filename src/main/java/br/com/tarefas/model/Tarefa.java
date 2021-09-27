package br.com.tarefas.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tarefas")
public class Tarefa {

   @Id
   @GeneratedValue
   @Column(name = "idtarefa")
   private int id;

   @Size(min = 5, max = 1000, message = "A descrição deve ter entre 5 e 1000 caracteres")
   private String descricao;

   private boolean finalizado;

   @Column(name = "data_finalizacao")
   private LocalDate dataFinalizacao;

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getDescricao() {
      return descricao;
   }

   public void setDescricao(String descricao) {
      this.descricao = descricao;
   }

   public boolean isFinalizado() {
      return finalizado;
   }

   public void setFinalizado(boolean finalizado) {
      this.finalizado = finalizado;
   }

   public LocalDate getDataFinalizacao() {
      return dataFinalizacao;
   }

   public void setDataFinalizacao(LocalDate dataFinalizacao) {
      this.dataFinalizacao = dataFinalizacao;
   }

   public String getDataString() {
      if (getDataFinalizacao() == null) 
         return "Nao finalizado";
      else 
         return getDataFinalizacao().format(DateTimeFormatter
            .ofPattern("dd/MM/uuuu"));
   }
}
