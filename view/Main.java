package view;

import controller.ProfessorController;
import controller.HorarioController;
import repository.ProfessorRepository;
import service.GerenciadorDeProfessores;
import service.GradeHorarios;
import model.Aula;
import model.Horario;
import model.Professor;
import util.Util;
import util.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradeHorarios gradeHorarios = new GradeHorarios();
        GerenciadorDeProfessores gerenciador = new GerenciadorDeProfessores(new ProfessorRepository());
        ProfessorController professorController = new ProfessorController(gerenciador);
        HorarioController horarioController = new HorarioController(gradeHorarios);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar professor");
            System.out.println("2. Remover professor");
            System.out.println("3. Listar professores");
            System.out.println("4. Atualizar professor");
            System.out.println("5. Adicionar aula à grade");
            System.out.println("6. Listar grade de horários");
            System.out.println("7. Remover aula da grade");
            System.out.println("8. Sair");
            System.out.print("Opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.print("\nDigite o nome do professor: ");
                    String nome = scanner.nextLine();

                    List<String> materias = new ArrayList<>();
                    while (true) {
                        System.out.print("Digite a matéria (ou 'fim' para encerrar): ");
                        String materia = scanner.nextLine();
                        if ("fim".equalsIgnoreCase(materia)) {
                            break;
                        }
                        materias.add(materia);
                    }

                    List<String> salas = new ArrayList<>();
                    while (true) {
                        System.out.print("Digite a sala (ou 'fim' para encerrar): ");
                        String sala = scanner.nextLine();
                        if ("fim".equalsIgnoreCase(sala)) {
                            break;
                        }
                        salas.add(sala);
                    }

                    professorController.adicionarProfessor(nome, materias, salas);
                    break;

                case 2:
                    System.out.println("\nEscolha uma opção:");
                    System.out.println("1. Remover um professor");
                    System.out.println("2. Remover todos os professores");
                    System.out.print("Opção: ");
                    int subOpcao = Integer.parseInt(scanner.nextLine());
                    if (subOpcao == 1) {
                        System.out.print("\nDigite o nome do professor a ser removido: ");
                        String nomeRemover = scanner.nextLine();
                        professorController.removerProfessor(nomeRemover);
                    } else if (subOpcao == 2) {
                        List<Professor> todosProfessores = gerenciador.listarProfessores();
                        for (Professor p : todosProfessores) {
                            professorController.removerProfessor(p.getNome());
                        }
                    } else {
                        System.out.println(Constants.INVALID_INPUT);
                    }
                    break;

                case 3:
                    professorController.listarProfessores();
                    break;

                case 4:
                    System.out.print("\nDigite o nome do professor a ser atualizado: ");
                    String nomeAtualizar = scanner.nextLine();
                    Professor profAtualizar = gerenciador.buscarProfessor(Util.trimInput(nomeAtualizar));
                    if (profAtualizar == null) {
                        System.out.println(Constants.PROFESSOR_NOT_FOUND);
                        break;
                    }

                    System.out.print("Digite o novo nome do professor (ou 'manter' para não alterar): ");
                    String novoNome = scanner.nextLine();
                    if (!novoNome.equalsIgnoreCase("manter")) {
                        profAtualizar.setNome(Util.trimInput(novoNome));
                    }

                    System.out.println("Atualizar matérias do professor (digite 'adicionar' para adicionar, 'remover' para remover, 'manter' para não alterar):");
                    while (true) {
                        System.out.print("Opção: ");
                        String materiaOpcao = scanner.nextLine();
                        if (materiaOpcao.equalsIgnoreCase("manter")) {
                            break;
                        }
                        if (materiaOpcao.equalsIgnoreCase("adicionar")) {
                            System.out.print("Matéria: ");
                            String novaMateria = scanner.nextLine();
                            profAtualizar.adicionarMateria(Util.trimInput(novaMateria));
                        } else if (materiaOpcao.equalsIgnoreCase("remover")) {
                            System.out.print("Matéria: ");
                            String materiaRemover = scanner.nextLine();
                            profAtualizar.removerMateria(Util.trimInput(materiaRemover));
                        } else {
                            System.out.println(Constants.INVALID_INPUT);
                        }
                    }

                    System.out.println("Atualizar salas do professor (digite 'adicionar' para adicionar, 'remover' para remover, 'manter' para não alterar):");
                    while (true) {
                        System.out.print("Opção: ");
                        String salaOpcao = scanner.nextLine();
                        if (salaOpcao.equalsIgnoreCase("manter")) {
                            break;
                        }
                        if (salaOpcao.equalsIgnoreCase("adicionar")) {
                            System.out.print("Sala: ");
                            String novaSala = scanner.nextLine();
                            profAtualizar.adicionarSala(Util.trimInput(novaSala));
                        } else if (salaOpcao.equalsIgnoreCase("remover")) {
                            System.out.print("Sala: ");
                            String salaRemover = scanner.nextLine();
                            profAtualizar.removerSala(Util.trimInput(salaRemover));
                        } else {
                            System.out.println(Constants.INVALID_INPUT);
                        }
                    }
                    break;

                case 5:
                    System.out.println("\nEscolha o dia da semana:");
                    System.out.println("1. Segunda-feira");
                    System.out.println("2. Terça-feira");
                    System.out.println("3. Quarta-feira");
                    System.out.println("4. Quinta-feira");
                    System.out.println("5. Sexta-feira");
                    System.out.print("Opção: ");
                    int diaOpcao = Integer.parseInt(scanner.nextLine());
                    String diaSemana;
                    switch (diaOpcao) {
                        case 1: diaSemana = "Segunda-feira"; break;
                        case 2: diaSemana = "Terça-feira"; break;
                        case 3: diaSemana = "Quarta-feira"; break;
                        case 4: diaSemana = "Quinta-feira"; break;
                        case 5: diaSemana = "Sexta-feira"; break;
                        default:
                            System.out.println(Constants.INVALID_INPUT);
                            continue;
                    }

                    System.out.print("Digite o nome do professor: ");
                    String nomeProfessor = scanner.nextLine();
                    Professor prof = gerenciador.buscarProfessor(Util.trimInput(nomeProfessor));
                    if (prof == null) {
                        System.out.println(Constants.PROFESSOR_NOT_FOUND);
                        continue;
                    }

                    String materia;
                    do {
                        System.out.print("Digite a matéria: ");
                        materia = scanner.nextLine();
                        if (!prof.lecionaMateria(Util.trimInput(materia))) {
                            System.out.println("O professor não leciona esta matéria. Tente novamente.");
                        }
                    } while (!prof.lecionaMateria(Util.trimInput(materia)));

                    String sala;
                    do {
                        System.out.print("Digite a sala: ");
                        sala = scanner.nextLine();
                        if (!prof.atuaNaSala(Util.trimInput(sala))) {
                            System.out.println("O professor não atua nesta sala. Tente novamente.");
                        }
                    } while (!prof.atuaNaSala(Util.trimInput(sala)));

                    Aula aula = new Aula(prof, materia, sala);

                    System.out.print("Digite a hora de início (HH:MM): ");
                    String horaInicio = scanner.nextLine();
                    System.out.print("Digite a hora de fim (HH:MM): ");
                    String horaFim = scanner.nextLine();

                    Horario horario = new Horario(diaSemana, horaInicio, horaFim);
                    gradeHorarios.adicionarAula(horario, aula);

                    break;

                case 6:
                    System.out.println("\nGrade de Horários:");
                    horarioController.listarGrade();
                    break;

                case 7:
                System.out.print("Digite o nome do professor: ");
                String nomeProfessorRemover = scanner.nextLine();
                gradeHorarios.removerAulaPorProfessor(nomeProfessorRemover);
                break;

                case 8:
                    System.out.println("\nEncerrando o sistema.");
                    return;

                default:
                    System.out.println(Constants.INVALID_INPUT);
                    break;
            }
            
        }

    }
}