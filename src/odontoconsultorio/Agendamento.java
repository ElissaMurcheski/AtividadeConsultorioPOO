package odontoconsultorio;
import java.text.DateFormat;
import java.util.Date;

public class Agendamento {

    private Date data;
    private String hora;
    private String observacao;
    private Paciente paciente;

    public Agendamento(Date data, String hora, String observacao, Paciente paciente) {
        this.data = data;
        this.hora = hora;
        this.observacao = observacao;
        this.paciente = paciente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "\n---> Data: " + DateFormat.getDateInstance().format(data) + "\nHora: " + hora + "\nObservação: " + observacao;
    }
    

}
