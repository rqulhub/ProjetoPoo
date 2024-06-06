package model;

import java.util.ArrayList;
import java.util.List;

public class Professor {
    private String nome;
    private List<String> materias;
    private List<String> salas;

    public Professor(String nome) {
        this.nome = nome;
        this.materias = new ArrayList<>();
        this.salas = new ArrayList<>();
    }

    public void adicionarMateria(String materia) {
        materias.add(materia);
    }

    public void removerMateria(String materia) {
        materias.remove(materia);
    }

    public boolean lecionaMateria(String materia) {
        return materias.contains(materia);
    }

    public void adicionarSala(String sala) {
        salas.add(sala);
    }

    public void removerSala(String sala) {
        salas.remove(sala);
    }

    public boolean atuaNaSala(String sala) {
        return salas.contains(sala);
    }

    public void mostrarPerfil() {
        System.out.println("Nome: " + nome);
        System.out.println("Matérias:");
        for (String materia : materias) {
            System.out.println("- " + materia);
        }
        System.out.println("Salas:");
        for (String sala : salas) {
            System.out.println("- " + sala);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}