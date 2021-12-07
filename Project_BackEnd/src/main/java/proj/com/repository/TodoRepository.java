package proj.com.repository;

import proj.com.entity.Todo;

import java.util.List;

public interface TodoRepository {

    void save(Todo todo);
    void delete(int id);
    List<Todo> findAll();

}
