import java.util.*;

public class App {

    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        Medicamento[] medicamento = new Medicamento[4];
        medicamento[0] = new Medicamento("CovidUltra", 15);
        medicamento[1] = new Medicamento("Zicox", 20);
        medicamento[2] = new Medicamento("ChikTop", 15);
        medicamento[3] = new Medicamento("Denguenit", 15);

        Paciente[] paciente = new Paciente[10];

        // paciente[0] = new Paciente("Bruno1", "601311", "9825252", 1,
        // medicamento[0].getNomeRemedio(),
        // medicamento[0].getQuantidadeRemedio());
        // paciente[1] = new Paciente("Bruno2", "601111", "9825252", 1,
        // medicamento[0].getNomeRemedio(),
        // medicamento[0].getQuantidadeRemedio());
        // paciente[4] = new Paciente("Bruno3", "601111", "9825252", 1,
        // medicamento[0].getNomeRemedio(),
        // medicamento[0].getQuantidadeRemedio());
        // paciente[5] = new Paciente("Bruno4", "601111", "9825252", 1,
        // medicamento[0].getNomeRemedio(),
        // medicamento[0].getQuantidadeRemedio());
        // paciente[8] = new Paciente("Bruno5", "601111", "9825252", 1,
        // medicamento[0].getNomeRemedio(),
        // medicamento[0].getQuantidadeRemedio());

        CadastroPaciente cadastro = new CadastroPaciente(10);
        cadastro.setPacientes(paciente);

        int saida = 0;
        do {
            System.out.println("  ----------------------------------------------- ");
            System.out.println("  |   Bem vindo ao sistema da UPA               | ");
            System.out.println("  |---------------------------------------------| ");
            System.out.println("  |       Escolha o que deseja fazer:           | ");
            System.out.println("  |  1 - Adicionar Paciente                     | ");
            System.out.println("  |  2 - Remover paciente                       | ");
            System.out.println("  |  3 - Gerenciar a ficha dos pacientes        | ");
            System.out.println("  |  4 - Gerenciar remédios                     | ");
            System.out.println("  |  5 - Sair do programa                       | ");
            System.out.println("  ----------------------------------------------- ");
            int opcao = key.nextInt();
            key.nextLine();
            switch (opcao) {
                case 1: // Adicionar paciente
                    System.out.println("Digite o nome do paciente que você deseja adicionar: ");
                    String n = key.nextLine();
                    System.out.println("Digite o cpf do paciente");
                    String c = key.nextLine();
                    System.out.println("Digite o celular ");
                    String t = key.nextLine();
                    System.out.println("Escolha o diagnóstico que o paciente recebeu: ");
                    System.out.println("1 - Covid ");
                    System.out.println("2 - Zica ");
                    System.out.println("3 - Chikungunya ");
                    System.out.println("4 - Dengue ");
                    int d = key.nextInt();
                    System.out.println("Escolha o remédio que foi receitado para o paciente: ");
                    System.out.println("1 - CovidUltra ");
                    System.out.println("2 - Zicox ");
                    System.out.println("3 - ChikTop ");
                    System.out.println("4 - Denguenit ");
                    int r = key.nextInt();
                    System.out.println("Digite a quantidade de remédio receitada para o paciente: ");
                    int q = key.nextInt();
                    medicamento[r - 1].setQuantidadeRemedio(medicamento[r - 1].getQuantidadeRemedio() - q);
                    Paciente completarPaciente = new Paciente(n, c, t, d,
                            medicamento[r - 1].getNomeRemedio(), q);
                    cadastro.AddPaciente(completarPaciente);
                    break;
                case 2: // remover paciente
                    System.out.println("Digite o cpf do paciente que você remover: ");
                    String remover = key.nextLine();
                    int local = cadastro.localizarPaciente(remover);
                    cadastro.organizarVetor(paciente);
                    cadastro.removerPaciente(paciente, local + 1);
                    break;
                case 3: // Mostrar todos os pacientes
                    int menuVagas;
                    do {
                        System.out.println("--------------------------------------------");
                        System.out.println("Bem vindo ao sistema de pacientes da UPA");
                        System.out.println("--------------------------------------------");
                        System.out.println(" 1 - Mostrar todos os pacientes que estão em atendimento ");
                        System.out.println(" 2 - Mostrar pacientes e leitos disponiveis      ");
                        System.out.println(" 3 - Mostrar porcentagem de ocorrência de cada doença");
                        System.out.println(" 4 - Ordenar todos os pacientes em ordem alfabética: "); // Não feito
                        menuVagas = key.nextInt();
                    } while (menuVagas >= 4 || menuVagas <= 0);
                    switch (menuVagas) {
                        case 1:
                            System.out.println("Aqui está a ficha com os pacientes internados:  ");
                            cadastro.imprimeOcupado();
                            System.out.println("-----------------------------------");
                            break;
                        case 2:
                            System.out.println("Aqui está a ficha com os pacientes e os leitos ainda disponiveis: ");
                            cadastro.imprimeTodoVetor();
                            System.out.println("-----------------------------------");
                            break;
                        case 3:
                            System.out.println("Aqui está o relatório da ocorreência das doenças no hospital: ");
                            cadastro.contaDoenças();
                            break;
                    }
                    break;
                case 4: // gerenciar remédios
                    int remedio;
                    do {
                        System.out.println("  ------------------------------------------------ ");
                        System.out.println("  |  Bem vindo(a) ao estoque de remédios da UPA  | ");
                        System.out.println("  ------------------------------------------------ ");
                        System.out.println("  |  1 - Verificar o estoque de remédios:        | ");
                        System.out.println("  |  2 - Alterar o estoque:                      | ");
                        System.out.println("  ------------------------------------------------ ");
                        remedio = key.nextInt();
                    } while (remedio <= 0 || remedio > 2);
                    switch (remedio) {
                        case 1: // Mostrar todo o estoque
                            System.out.println(
                                    "O estoque de CovidUltra possui: " + medicamento[0].getQuantidadeRemedio());
                            System.out.println("O estoque de Zicox possui: " + medicamento[1].getQuantidadeRemedio());
                            System.out.println("O estoque de ChikTop possui: " + medicamento[2].getQuantidadeRemedio());
                            System.out
                                    .println("O estoque de Denguenit possui: " + medicamento[3].getQuantidadeRemedio());
                            System.out.println("------------------------------------------------ ");
                            break;
                        case 2:
                            int opcaoAlteraEstoque = 0;
                            do {
                                System.out.println("1 - Alterar estoque de CovidUltra");
                                System.out.println("2 - Alterar estoque de Zicox");
                                System.out.println("3 - Alterar estoque de ChikTop");
                                System.out.println("4 - Alterar estoque de Denguenit");
                                opcaoAlteraEstoque = key.nextInt();
                            } while (opcaoAlteraEstoque > 4 || opcaoAlteraEstoque <= 0);
                            switch (opcaoAlteraEstoque) {
                                case 1: // Alterar quantidade de coviultra
                                    System.out.println("Digite a nova quantidade de CovidUltra do estoque");
                                    int cAltera = key.nextInt();
                                    medicamento[0].setQuantidadeRemedio(cAltera);
                                    break;
                                case 2: // Alterar quantidade de zicox
                                    System.out.println("Digite a nova quantidade de Zicox do estoque");
                                    int zAltera = key.nextInt();
                                    medicamento[1].setQuantidadeRemedio(zAltera);
                                    break;
                                case 3: // Alterar a quantidade de ChikTopbreak;
                                    System.out.println("Digite a nova quantidade de ChikTop do estoque");
                                    int chikAltera = key.nextInt();
                                    medicamento[2].setQuantidadeRemedio(chikAltera);
                                    break;
                                case 4: // alterar a quantidade de Denguenit
                                    System.out.println("Digite a nova quantidade de Denguenit do estoque");
                                    int dAltera = key.nextInt();
                                    medicamento[3].setQuantidadeRemedio(dAltera);
                                    break;
                            }
                            break;
                    }
                    break;

                case 5:
                    System.out.println(" FIM DO PROGRAMA");
                    saida = 5;
                    break;

            }
        } while (saida <= 0 || saida > 5);

        // TESTES!!!!!!!
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
