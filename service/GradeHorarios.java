package service;

import model.Aula;
import model.Horario;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GradeHorarios {
    private Map<Horario, Set<Aula>> grade = new HashMap<>();

    public void adicionarAula(Horario horario, Aula aula) {
        grade.computeIfAbsent(horario, k -> new HashSet<>()).add(aula);
    }

    public void removerAulaPorProfessor(String nomeProfessor) {
        grade.values().forEach(aulas -> {
            aulas.removeIf(aula -> aula.getProfessor().getNome().equalsIgnoreCase(nomeProfessor));
        });
    }

    public Map<Horario, Set<Aula>> getGrade() {
        return grade;
    }
}