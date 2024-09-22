package com.my_app.my_app.dbDoc.Repository.Interfaceee;

import com.my_app.my_app.dbDoc.Collections.SchedaProdotto;
import java.util.List;

public interface SchedaProdottoI {
    List<SchedaProdotto> query(SchedaProdotto schedaProdotto);
    void CustomInsert(SchedaProdotto schedaProdotto);
    void update(SchedaProdotto schedaProdotto);
    void delete(int idReview);
}
