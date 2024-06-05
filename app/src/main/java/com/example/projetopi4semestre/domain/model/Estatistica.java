package com.example.projetopi4semestre.domain.model;

public class Estatistica {

   private Double media;
   private Double mediana;
   private Double moda;
   private Double desvioPadrao;
   private Double assimetria;
   private Double previsaoFutura;

   public Estatistica(Double media, Double mediana, Double moda, Double desvioPadrao, Double assimetria, Double previsaoFutura) {
      this.media = media;
      this.mediana = mediana;
      this.moda = moda;
      this.desvioPadrao = desvioPadrao;
      this.assimetria = assimetria;
      this.previsaoFutura = previsaoFutura;
   }

   public Double getMedia() {
      return media;
   }

   public Double getMediana() {
      return mediana;
   }

   public Double getModa() {
      return moda;
   }

   public Double getDesvioPadrao() {
      return desvioPadrao;
   }

   public Double getAssimetria() {
      return assimetria;
   }

   public Double getPrevisaoFutura() {
      return previsaoFutura;
   }
}

