package model;

public class Horario {
    private String diaSemana;
    private String horaInicio;
    private String horaFim;

    public Horario(String diaSemana, String horaInicio, String horaFim) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }
}