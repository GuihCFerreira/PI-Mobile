package com.example.projetopi4semestre.domain.model;

public class Estatistica {

   private String media;
   private String mediana;
   private String moda;
   private String desvio_padrao;
   private String assimetria;
   private String previsao_futura;

   public Estatistica(String media, String mediana, String moda, String desvioPadrao, String assimetria, String previsaoFutura) {
      this.media = media;
      this.mediana = mediana;
      this.moda = moda;
      this.desvio_padrao = desvioPadrao;
      this.assimetria = assimetria;
      this.previsao_futura = previsaoFutura;
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
      return desvio_padrao;
   }

   public String getAssimetria() {
      return assimetria;
   }

   public String getPrevisaoFutura() {
      return previsao_futura;
   }
}

