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
            System.out.println("----------------------------------------------- ");
            System.out.println("|      Seja bem-vindo ao sistema da UPA       | ");
            System.out.println("| ------------------------------------------- | ");
            System.out.println("|        Escolha o que deseja fazer:          | ");
            System.out.println("|  1 - Adicionar novo paciente                | ");
            System.out.println("|  2 - Remover paciente                       | ");
            System.out.println("|  3 - Gerenciar a ficha dos pacientes        | ");
            System.out.println("|  4 - Gerenciar remédios                     | ");
            System.out.println("|  5 - Sair do programa                       | ");
            System.out.println("----------------------------------------------- ");
            int opcaoPrincipal = key.nextInt();
            key.nextLine();
            switch (opcaoPrincipal) {
                case 1: // Adicionar paciente
                    System.out.println("Digite o nome do paciente que você deseja adicionar: ");
                    String nome = key.nextLine();
                    System.out.println("Digite o cpf do paciente");
                    String cpf = key.nextLine();
                    System.out.println("Digite o celular ");
                    String tel = key.nextLine();
                    System.out.println("Escolha o diagnóstico que o paciente recebeu: ");
                    System.out.println("1 - Covid ");
                    System.out.println("2 - Zica ");
                    System.out.println("3 - Chikungunya ");
                    System.out.println("4 - Dengue ");
                    int diag = key.nextInt();
                    System.out.println("Escolha o remédio que foi receitado para o paciente: ");
                    System.out.println("1 - CovidUltra ");
                    System.out.println("2 - Zicox ");
                    System.out.println("3 - ChikTop ");
                    System.out.println("4 - Denguenit ");
                    int remed = key.nextInt();
                    System.out.println("Digite a quantidade de remédio receitada para o paciente: ");
                    int quant = key.nextInt();
                    medicamento[remed - 1].setQuantidadeRemedio(medicamento[remed - 1].getQuantidadeRemedio() - quant);
                    Paciente completarPaciente = new Paciente(nome, cpf, tel, diag,
                            medicamento[remed - 1].getNomeRemedio(), quant);
                    cadastro.AddPaciente(completarPaciente);
                    break;
                case 2: // removerPac paciente
                    System.out.println("Digite o cpf do paciente que você removerPac: ");
                    String removerPac = key.nextLine();
                    cadastro.organizarVetor(paciente);
                    int localPac = cadastro.localizarPaciente(removerPac);
                    cadastro.removerPaciente(paciente, localPac);
                    break;
                case 3: // Menu do sistema de pacientes
                    int menuFichas;
                    do {
                        System.out.println("----------------------------------------------------------- ");
                        System.out.println("|        Sistema de fichas dos pacientes da UPA           | ");
                        System.out.println("| ------------------------------------------------------- | ");
                        System.out.println("| 1 - Mostrar todos os pacientes que estão em atendimento | ");
                        System.out.println("| 2 - Mostrar pacientes e leitos disponiveis              | ");
                        System.out.println("| 3 - Mostrar porcentagem de ocorrência de cada doença:   | ");
                        System.out.println("| 4 - Ordenar todos os pacientes em ordem alfabética:     | "); // NC
                        System.out.println("----------------------------------------------------------- ");
                        menuFichas = key.nextInt();
                    } while (menuFichas >= 4 || menuFichas <= 0);
                    switch (menuFichas) {
                        case 1:
                            System.out.println("Aqui está a ficha com os pacientes internados:  ");
                            System.out.println(" ");
                            cadastro.imprimeOcupado();
                            System.out.println("----------------------------------------------------------- ");
                            System.out.println(" ");
                            break;
                        case 2:
                            System.out.println("Aqui está a ficha com os pacientes e os leitos ainda disponiveis: ");
                            System.out.println(" ");
                            cadastro.imprimeTodoVetor();
                            System.out.println("----------------------------------------------------------- ");
                            System.out.println(" ");
                            break;
                        case 3:
                            System.out.println("Aqui está o relatório da ocorreência das doenças no hospital: ");
                            System.out.println(" ");
                            cadastro.porcentDoenças();
                            System.out.println("----------------------------------------------------------- ");
                            System.out.println(" ");
                            break;
                    }
                    break;
                case 4: // Gerenciar remédios
                    int menuRemedio;
                    do {
                        System.out.println("------------------------------------------------ ");
                        System.out.println("|  Bem-vindo(a) ao estoque de remédios da UPA  | ");
                        System.out.println("| -------------------------------------------- | ");
                        System.out.println("|  1 - Verificar o estoque de remédios:        | ");
                        System.out.println("|  2 - Alterar o estoque:                      | ");
                        System.out.println("------------------------------------------------ ");
                        menuRemedio = key.nextInt();
                    } while (menuRemedio <= 0 || menuRemedio > 2);
                    switch (menuRemedio) {
                        case 1: // Mostrar todo o estoque
                            System.out.println(
                                    "O estoque de CovidUltra possui: " + medicamento[0].getQuantidadeRemedio()
                                            + "caixas");
                            System.out.println(
                                    "O estoque de Zicox possui: " + medicamento[1].getQuantidadeRemedio() + "caixas");
                            System.out.println(
                                    "O estoque de ChikTop possui: " + medicamento[2].getQuantidadeRemedio() + "caixas");
                            System.out
                                    .println("O estoque de Denguenit possui: " + medicamento[3].getQuantidadeRemedio()
                                            + "caixas");
                            System.out.println("----------------------------------------------------------- ");
                            System.out.println(" ");
                            break;
                        case 2:// Alterar estoque
                            int opcaoAlteraEstoque = 0;
                            do {
                                System.out.println("Escolha o estoque de remédio que deseja alterar");
                                System.out.println("1 - Alterar estoque de CovidUltra");
                                System.out.println("2 - Alterar estoque de Zicox");
                                System.out.println("3 - Alterar estoque de ChikTop");
                                System.out.println("4 - Alterar estoque de Denguenit");
                                opcaoAlteraEstoque = key.nextInt();
                            } while (opcaoAlteraEstoque > 4 || opcaoAlteraEstoque <= 0);
                            switch (opcaoAlteraEstoque) {
                                case 1: // Alterar quantidade de coviultra
                                    System.out.println("Digite a nova quantidade de CovidUltra do estoque");
                                    int covidAltera = key.nextInt();
                                    medicamento[0].setQuantidadeRemedio(covidAltera);
                                    System.out.println("Estoque de CovidUltra atualizado");
                                    System.out.println("----------------------------------------------------------- ");
                                    System.out.println(" ");
                                    break;
                                case 2: // Alterar quantidade de zicox
                                    System.out.println("Digite a nova quantidade de Zicox do estoque");
                                    int zicAltera = key.nextInt();
                                    medicamento[1].setQuantidadeRemedio(zicAltera);
                                    System.out.println("Estoque de Zicox atualizado");
                                    System.out.println("----------------------------------------------------------- ");
                                    System.out.println(" ");
                                    break;
                                case 3: // Alterar a quantidade de ChikTop
                                    System.out.println("Digite a nova quantidade de ChikTop do estoque");
                                    int chikAltera = key.nextInt();
                                    medicamento[2].setQuantidadeRemedio(chikAltera);
                                    System.out.println("Estoque de ChikTop atualizado");
                                    System.out.println("----------------------------------------------------------- ");
                                    System.out.println(" ");
                                    break;
                                case 4: // alterar a quantidade de Denguenit
                                    System.out.println("Digite a nova quantidade de Denguenit do estoque");
                                    int dengAltera = key.nextInt();
                                    medicamento[3].setQuantidadeRemedio(dengAltera);
                                    System.out.println("Estoque de Denguenit atualizado");
                                    System.out.println("----------------------------------------------------------- ");
                                    System.out.println(" ");
                                    break;
                            }
                            break;
                    }
                    break;

                case 5:
                    System.out.println("----------------------------------------------------------- ");
                    System.out.println("Obrigado por utilizar nosso programa");
                    System.out.println("----------------------------------------------------------- ");
                    saida = 5;
                    break;

            }
        } while (saida <= 0 || saida > 5);

        // TESTES!!!!!!!
        // Paciente c = new Paciente("Teste", null, null, 0, null, 0);
        // cadastro.organizarVetor(paciente);
        // cadastro.AddPaciente(c);
        // cadastro.imprimeOcupado();
        // int localPac = cadastro.localizarPaciente(null);
        // cadastro.removerPaciente(paciente, localPac);
        // cadastro.imprimeOcupado();
        // key.close();
    }
}
