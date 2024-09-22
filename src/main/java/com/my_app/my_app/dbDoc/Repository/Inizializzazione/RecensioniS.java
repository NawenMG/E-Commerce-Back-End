package com.my_app.my_app.dbDoc.Repository.Inizializzazione;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.my_app.my_app.dbDoc.Collections.Recensioni;
import com.my_app.my_app.dbDoc.Repository.Interfaceee.RecensioniI;

public interface RecensioniS extends MongoRepository<Recensioni, Integer>, RecensioniI {
}
