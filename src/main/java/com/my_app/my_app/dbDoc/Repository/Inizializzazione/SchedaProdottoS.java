package com.my_app.my_app.dbDoc.Repository.Inizializzazione;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.my_app.my_app.dbDoc.Collections.SchedaProdotto;
import com.my_app.my_app.dbDoc.Repository.Interfaceee.SchedaProdottoI;

public interface SchedaProdottoS extends MongoRepository<SchedaProdotto, Integer>, SchedaProdottoI {
}
