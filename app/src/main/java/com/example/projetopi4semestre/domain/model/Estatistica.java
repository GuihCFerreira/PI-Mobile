package com.example.projetopi4semestre.domain.model;

public class Estatistica {

   private String media;
   private String mediana;
   private String moda;
   private String desvioPadrao;
   private String assimetria;
   private String previsaoFutura;

   public Estatistica(String media, String mediana, String moda, String desvioPadrao, String assimetria, String previsaoFutura) {
      this.media = media;
      this.mediana = mediana;
      this.moda = moda;
      this.desvioPadrao = desvioPadrao;
      this.assimetria = assimetria;
      this.previsaoFutura = previsaoFutura;
   }

   public String getMedia() {
      return media;
   }

   public String getMediana() {
      return mediana;
   }

   public String getModa() {
      return moda;
   }

   public String getDesvioPadrao() {
      return desvioPadrao;
   }

   public String getAssimetria() {
      return assimetria;
   }

   public String getPrevisaoFutura() {
      return previsaoFutura;
   }
}

