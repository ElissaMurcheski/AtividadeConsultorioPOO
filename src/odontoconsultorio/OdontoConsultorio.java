package odontoconsultorio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class OdontoConsultorio {

    public static void main(String[] args) throws ParseException {
        ArrayList<Paciente> listaPacientes = new ArrayList<>();
        ArrayList<Agendamento> listaAgendamentos = new ArrayList<>();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        int opcaoCadastro = Integer.parseInt(JOptionPane.showInputDialog("----- Cadastrar ----- \n1- Paciente \n2- Agendamento \n0- Cancelar"));
        while (opcaoCadastro != 0) {
            if (opcaoCadastro == 1) {
                String nome = JOptionPane.showInputDialog("Nome do Paciente: ");
                String email = JOptionPane.showInputDialog("Email do Paciente: ");
                String telefone = JOptionPane.showInputDialog("Telefone do Paciente: ");
                Paciente paciente = new Paciente(nome, email, telefone);
                listaPacientes.add(paciente);
            } else if (opcaoCadastro == 2) {
                Date data = df.parse(JOptionPane.showInputDialog("Data da consulta: "));
                String hora = JOptionPane.showInputDialog("Hora da consulta: ");
                String observacao = JOptionPane.showInputDialog("Observações da consulta: ");
                int opcaoPaciente = Integer.parseInt(JOptionPane.showInputDialog("Digite: \n1- Paciente Cadastrado \n2- Cadastrar Paciente"));
                if (opcaoPaciente == 1) {
                    String nomePacientes = "";
                    for (int i = 0; i < listaPacientes.size(); i++) {
                        Paciente paciente = listaPacientes.get(i);
                        nomePacientes += i + 1 + "- " + paciente.getNome() + "\n";
                    }
                    int indexPaciente = Integer.parseInt(JOptionPane.showInputDialog(nomePacientes)) - 1;
                    Agendamento agendamento = new Agendamento(data, hora, observacao, listaPacientes.get(indexPaciente));
                    listaAgendamentos.add(agendamento);
                } else if (opcaoPaciente == 2) {
                    String nome = JOptionPane.showInputDialog("Nome do Paciente: ");
                    String email = JOptionPane.showInputDialog("Email do Paciente: ");
                    String telefone = JOptionPane.showInputDialog("Telefone do Paciente: ");
                    Paciente paciente = new Paciente(nome, email, telefone);
                    listaPacientes.add(paciente);
                    Agendamento agendamento = new Agendamento(data, hora, observacao, paciente);
                    listaAgendamentos.add(agendamento);
                }
            }
            opcaoCadastro = Integer.parseInt(JOptionPane.showInputDialog("----- Cadastrar ----- \n1- Paciente \n2- Agendamento \n0- Cancelar"));
        }
        ServicoPaciente servicoPacientes = new ServicoPaciente();
        JOptionPane.showMessageDialog(null, "----- Relatório de todos os pacientes e quantidade de agendamentos ----- \n" + servicoPacientes.todosPacientesQtdAgendamentos(listaPacientes, listaAgendamentos));
        JOptionPane.showMessageDialog(null, "----- Relatório de todos os pacientes com seus respectivos agendamentos ----- \n " + servicoPacientes.todosPacientesTdsAgendamentos(listaPacientes, listaAgendamentos));
        Date data = df.parse(JOptionPane.showInputDialog("Pesquisar o agendamento por data: "));
        JOptionPane.showMessageDialog(null, "----- Agendamentos ----- \n" + servicoPacientes.pesquisaAgendamentosData(listaAgendamentos, data));

        String nomePacientes = "----- Selecione um paciente para consultar agendamento ----- \n";
        for (int i = 0; i < listaPacientes.size(); i++) {
            Paciente paciente = listaPacientes.get(i);
            nomePacientes += i + 1 + "- " + paciente.getNome() + "\n";
        }
        int indexPaciente = Integer.parseInt(JOptionPane.showInputDialog(nomePacientes)) - 1;
        Paciente paciente = listaPacientes.get(indexPaciente);
        JOptionPane.showMessageDialog(null, "----- Agendamentos ----- \n" + servicoPacientes.pesquisaAgendamentosPaciente(listaAgendamentos, paciente));
    }

}
