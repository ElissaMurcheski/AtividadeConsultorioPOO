package odontoconsultorio;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ServicoPaciente {

    public String todosPacientesQtdAgendamentos(ArrayList<Paciente> listaPacientes, ArrayList<Agendamento> listaAgendamentos) {
        String resposta = "";
        for (int i = 0; i < listaPacientes.size(); i++) {
            resposta += listaPacientes.get(i).toString();
            int contAgendamento = 0;
            for (int j = 0; j < listaAgendamentos.size(); j++) {
                if (listaPacientes.get(i) == listaAgendamentos.get(j).getPaciente()) {
                    contAgendamento++;
                }
            }
            if (contAgendamento == 0) {
                resposta += "\nPaciente sem agendamento!";
            } else {
                resposta += "\nQuantidade de agendamentos: " + contAgendamento;
            }
        }
        return resposta;
    }

    public String todosPacientesTdsAgendamentos(ArrayList<Paciente> listaPacientes, ArrayList<Agendamento> listaAgendamentos) {
        String resposta = "";
        for (int i = 0; i < listaPacientes.size(); i++) {
            resposta += listaPacientes.get(i).toString();
            boolean contemAgendamento = false;
            for (int j = 0; j < listaAgendamentos.size(); j++) {
                if (listaPacientes.get(i) == listaAgendamentos.get(j).getPaciente()) {
                    resposta += listaAgendamentos.get(j).toString();
                    contemAgendamento = true;
                }
            }
            if (!contemAgendamento) {
                resposta += "\nPaciente sem agendamento!";
            }
        }
        return resposta;
    }

    public String pesquisaAgendamentosData(ArrayList<Agendamento> listaAgendamentos, Date data) {
        String resposta = "";
        boolean contemAgendamento = false;
        for (int i = 0; i < listaAgendamentos.size(); i++) {
            if (DateFormat.getDateInstance().format(data).equals(DateFormat.getDateInstance().format(listaAgendamentos.get(i).getData()))) {
                resposta += listaAgendamentos.get(i).toString();
                contemAgendamento = true;
            }
        }
        if (!contemAgendamento) {
            resposta += "\nData sem agendamento!";
        }
        return resposta;
    }

    public String pesquisaAgendamentosPaciente(ArrayList<Agendamento> listaAgendamentos, Paciente paciente) {
        String resposta = "";
        boolean contemAgendamento = false;
        for (int i = 0; i < listaAgendamentos.size(); i++) {
            if (paciente == listaAgendamentos.get(i).getPaciente()) {
                resposta += listaAgendamentos.get(i).toString();
                contemAgendamento = true;
            }
        }
        if (!contemAgendamento) {
            resposta += "\nPaciente sem agendamento!";
        }
        return resposta;
    }
}
