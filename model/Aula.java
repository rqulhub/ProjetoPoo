package model; 

public class Aula {
    private Professor professor;
    private String materia;
    private String sala; 

    public Aula(Professor professor, String materia, String sala) {
        this.professor = professor;
        this.materia = materia;
        this.sala = sala;
    } 

    public Professor getProfessor() {
        return professor;
    } 

    public String getMateria() {
        return materia;
    } 

    public String getSala() {
        return sala;
    }
}