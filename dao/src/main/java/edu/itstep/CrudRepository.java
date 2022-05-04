package edu.itstep;

import java.util.List;
import java.util.UUID;

public interface CrudRepository<M> {

    M findOneById(String id);

    List<M> getAll();

    void addNewUnit(M model);

    void deleteById(String id);

    List<UUID> getAllId();
}