package nav.fullstack.springdataapp.repositories;

import java.util.Collection;

public interface CRUDRepository <T, ID> {
    T findById(ID id);
    Collection<T> findAll();
    T add(T entity);
    T update(T entity);
    void deleteById(ID id);
}
