package com.my_app.my_app.dbDoc.Collections;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id; // Import corretto per @Id
import java.util.HashMap;
import java.util.Map;

@Document(collection = "schedaProdotto") 
public class SchedaProdotto {
    @Id
    private int idSchedaProdotto; 
    private String nome;
    private double prezzo;
    private Map<String, Object> campiAggiuntivi = new HashMap<>(); //Per il client che può inserire nuovi campi, e così sfruttare mongodb

    public SchedaProdotto() {}

    public int getIdSchedaProdotto() {
        return idSchedaProdotto;
    }

    public void setIdSchedaProdotto(int idSchedaProdotto) {
        this.idSchedaProdotto = idSchedaProdotto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public Map<String, Object> getCampiAggiuntivi() {
        return campiAggiuntivi;
    }

    public void setCampiAggiuntivi(Map<String, Object> campiAggiuntivi) {
        this.campiAggiuntivi = campiAggiuntivi;
    }
}
