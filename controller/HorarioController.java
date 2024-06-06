package controller;

import service.GradeHorarios;
import model.Horario;
import java.util.Comparator;

public class HorarioController {
    private GradeHorarios gradeHorarios;

    public HorarioController(GradeHorarios gradeHorarios) {
        this.gradeHorarios = gradeHorarios;
    }

    public void listarGrade() {
        System.out.println("Grade de Horários:");
        System.out.println("---------------------------------------------------------");
        System.out.println("| Dia da Semana | Início | Fim | Professor | Matéria | Sala |");
        System.out.println("---------------------------------------------------------");
    
        gradeHorarios.getGrade().entrySet()
                .stream()
                .sorted(Comparator.comparing(entry -> entry.getKey().getDiaSemana()))
                .forEach(entry -> {
                    Horario horario = entry.getKey();
                    entry.getValue().stream()
                            .sorted(Comparator.comparing(aula -> aula.getProfessor().getNome()))
                            .forEach(aula -> {
                                System.out.printf("| %-13s| %-7s| %-4s| %-10s| %-8s| %-5s|\n",
                                        horario.getDiaSemana(), horario.getHoraInicio(),
                                        horario.getHoraFim(), aula.getProfessor().getNome(),
                                        aula.getMateria(), aula.getSala());
                            });
                });
    
        System.out.println("---------------------------------------------------------");
    }
    
}