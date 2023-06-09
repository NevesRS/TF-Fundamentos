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

        // do {
        // System.out.println(" ----------------------------------- ");
        // System.out.println(" - Bem vindo ao sistema da UPA -- ");
        // System.out.println(" ----------------------------------- ");
        // System.out.println(" - Escolha o que deseja fazer: - ");
        // System.out.println(" 1 - Adicionar Paciente - ");
        // System.out.println(" 2 - Remover paciente - ");
        // System.out.println(" 3 - Mostrar todos os pacientes - ");
        // System.out.println(" 4 - Verificar estoque de remédios - ");
        // System.out.println(" 5 - Adicionar remédios ao estoque - ");
        // System.out.println(" ----------------------------------- ");
        // int opcao = key.nextInt();
        // key.nextLine();
        // switch (opcao) {
        // case 1:
        // int saida = 0;
        // do {
        // System.out.println("Digite o nome do paciente que você deseja adicionar: ");
        // String n = key.nextLine();
        // System.out.println("Digite o cpf do paciente");
        // String c = key.nextLine();
        // System.out.println("Digite o celular ");
        // String t = key.nextLine();
        // System.out.println("Digite o diagnostico do paciente: ");
        // System.out.println("1 - Covid ");
        // System.out.println("2 - Zica ");
        // System.out.println("3 - Chikungunya ");
        // System.out.println("4 - Dengue ");
        // int d = key.nextInt();
        // System.out.println("Digite o remédio que foi receitado para o paciente: ");
        // System.out.println("1 - covid ");
        // System.out.println("2 - Zica ");
        // System.out.println("3 - Chikungunya ");
        // System.out.println("4 - Dengue ");
        // int r = key.nextInt();
        // System.out.println("Digite a quantidade receitada do remédio que o paciente
        // deve tomar: ");
        // int q = key.nextInt();
        // Paciente completarPaciente = new Paciente(n, c, t, d, medicamento[r -
        // 1].getNomeRemedio(), q);
        // cadastro.AddPaciente(completarPaciente);
        // System.out.println("Deseja encerrar o programa? ");
        // saida = key.nextInt();
        // key.nextLine();
        // } while (saida != 1);
        // }
        // } while (erro);

        // cadastro.imprimeOcupado();
        // cadastro.imprimeTodoVetor();

        key.close();
    }
}