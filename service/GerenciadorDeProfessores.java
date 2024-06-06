package service;

import repository.ProfessorRepository;
import model.Professor;
import java.util.List;

public class GerenciadorDeProfessores {
    private ProfessorRepository repository;

    public GerenciadorDeProfessores(ProfessorRepository repository) {
        this.repository = repository;
    }

    public void adicionarProfessor(Professor professor) {
        repository.adicionar(professor);
    }

    public void removerProfessor(String nome) {
        Professor professor = repository.buscarPorNome(nome);
        if (professor != null) {
            repository.remover(professor);
        }
    }

    public List<Professor> listarProfessores() {
        return repository.listarTodos();
    }

    public Professor buscarProfessor(String nome) {
        return repository.buscarPorNome(nome);
    }
}
