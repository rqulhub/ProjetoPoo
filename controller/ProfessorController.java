package controller;

import service.GerenciadorDeProfessores;
import model.Professor;
import util.Util;

import java.util.List;

public class ProfessorController {
    private GerenciadorDeProfessores gerenciador;

    public ProfessorController(GerenciadorDeProfessores gerenciador) {
        this.gerenciador = gerenciador;
    }

    public void adicionarProfessor(String nome, List<String> materias, List<String> salas) {
        Professor professor = new Professor(Util.trimInput(nome));
        for (String materia : materias) {
            professor.adicionarMateria(Util.trimInput(materia));
        }
        for (String sala : salas) {
            professor.adicionarSala(Util.trimInput(sala));
        }
        gerenciador.adicionarProfessor(professor);
    }

    public void removerProfessor(String nome) {
        gerenciador.removerProfessor(nome.trim());
    }

    public void listarProfessores() {
        gerenciador.listarProfessores().forEach(Professor::mostrarPerfil);
    }
}