package edu.itstep.view;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface CrudOperationView<T> {

    String findOneById() throws IOException;

    void showAllId();

    T add() throws IOException;

    String deleteById() throws IOException;

}
