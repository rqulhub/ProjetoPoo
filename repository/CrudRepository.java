package repository; 

import java.util.List; 

public interface CrudRepository<T> {
    void adicionar(T t);
    void remover(T t);
    T buscarPorNome(String nome);
    List<T> listarTodos();
}