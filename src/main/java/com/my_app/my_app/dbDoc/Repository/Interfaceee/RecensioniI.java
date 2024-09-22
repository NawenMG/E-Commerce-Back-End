package com.my_app.my_app.dbDoc.Repository.Interfaceee;

import com.my_app.my_app.dbDoc.Collections.Recensioni;
import java.util.List;

public interface RecensioniI {
    List<Recensioni> query(Recensioni recensioni);
    void CustomInsert(Recensioni recensioni);
    void update(Recensioni recensioni);
    void delete(int idRecensione);
}
