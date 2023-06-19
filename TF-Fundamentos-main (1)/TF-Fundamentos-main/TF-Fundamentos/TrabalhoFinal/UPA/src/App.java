import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        boolean erro = false;

        Medicamento[] medicamento = new Medicamento[4];
        medicamento[0] = new Medicamento("CovidUltra", 15);
        medicamento[1] = new Medicamento("Zicox", 20);
        medicamento[2] = new Medicamento("ChikTop", 15);
        medicamento[3] = new Medicamento("Denguenit", 15);

        Paciente[] paciente = new Paciente[10];

        paciente[0] = new Paciente("Bruno1", "601111", "9825252", 1, medicamento[0].getNomeRemedio(),
                medicamento[0].getQuantidadeRemedio());
        paciente[1] = new Paciente("Bruno2", "601111", "9825252", 1, medicamento[0].getNomeRemedio(),
                medicamento[0].getQuantidadeRemedio());
        paciente[4] = new Paciente("Bruno3", "601111", "9825252", 1, medicamento[0].getNomeRemedio(),
                medicamento[0].getQuantidadeRemedio());
        paciente[5] = new Paciente("Bruno4", "601111", "9825252", 1, medicamento[0].getNomeRemedio(),
                medicamento[0].getQuantidadeRemedio());
        paciente[8] = new Paciente("Bruno5", "601111", "9825252", 1, medicamento[0].getNomeRemedio(),
                medicamento[0].getQuantidadeRemedio());

        CadastroPaciente cadastro = new CadastroPaciente(10);
        cadastro.setPacientes(paciente);


        //TESTES!!!!!!!

        // Paciente c = new Paciente("Teste", null, null, 0, null, 0);
        // cadastro.organizarVetor(paciente);
        // cadastro.AddPaciente(c);
        // cadastro.imprimeOcupado();
        // int local = cadastro.localizarPaciente(null);
        // cadastro.removerPaciente(paciente, local);
        // cadastro.imprimeOcupado();
        // key.close();
    }
}