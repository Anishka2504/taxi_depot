package edu.itstep;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface CrudController {

    void findOneById() throws IOException;

    void showAll();

    void addNewUnit() throws IOException;

    void deleteById() throws IOException;

    void getAllId() throws IOException;
    
}
