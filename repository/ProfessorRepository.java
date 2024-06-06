package repository; 

import model.Professor;
import java.util.ArrayList;
import java.util.List; 

public class ProfessorRepository implements CrudRepository<Professor> {
private List<Professor> professores = new ArrayList<>(); 

@Override
public void adicionar(Professor professor) {
    professores.add(professor);
    } 

@Override
public void remover(Professor professor) {
    professores.remove(professor);
    } 

@Override
public Professor buscarPorNome(String nome) {
    return professores.stream()
        .filter(professor -> professor.getNome().equalsIgnoreCase(nome))
        .findFirst()
        .orElse(null);
    } 

@Override
    public List<Professor> listarTodos() {
        return new ArrayList<>(professores);
    }
}