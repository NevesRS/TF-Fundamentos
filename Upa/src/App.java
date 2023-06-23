import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        Medicamento[] medicamento = new Medicamento[4]; // Criando vetor de objeto da classe medicamento
        medicamento[0] = new Medicamento("CovidUltra", 15); // Colocando o nome e quantidade de medicamento em cada
        medicamento[1] = new Medicamento("Zicox", 20);
        medicamento[2] = new Medicamento("ChikTop", 15);
        medicamento[3] = new Medicamento("Denguenit", 15);

        Paciente[] paciente = new Paciente[10]; // Criando vetor de objeto da classe paciente

        CadastroPaciente cadastro = new CadastroPaciente(10); // Criando objeto cadastro
        cadastro.setPacientes(paciente); // Armazenando paciente dentro do objeto cadastro

        int saida = 0;
        String opcaoPrincipal;
        int opcaoPrincipalCode = 5;
        System.out.println("----------------------------------------------------------- ");
        System.out.println("Olá, pressione enter para entrar no programa");
        System.out.println("----------------------------------------------------------- ");
        do {
            key.nextLine();
            do {
                // Menu principal da UPA
                System.out.println("----------------------------------------------- ");
                System.out.println("|      Seja bem-vindo ao sistema da UPA       | ");
                System.out.println("| ------------------------------------------- | ");
                System.out.println("|        Escolha o que deseja fazer:          | ");
                System.out.println("|  1 - Adicionar novo paciente                | ");
                System.out.println("|  2 - Remover paciente                       | ");
                System.out.println("|  3 - Gerenciar a ficha dos pacientes        | ");
                System.out.println("|  4 - Gerenciar remédios                     | ");
                System.out.println("|  5 - Alterar alguma informação de paciente  | ");
                System.out.println("|  6 - Sair do programa                       | ");
                System.out.println("----------------------------------------------- ");
                opcaoPrincipal = key.nextLine();
                opcaoPrincipalCode = cadastro.tranforma(opcaoPrincipal);
                // Verificação de números na entrada de dados
            } while (opcaoPrincipalCode <= 0 || opcaoPrincipalCode > 6);

            switch (opcaoPrincipalCode) { // Switch principal do menu
                case 1: // Opção adicionar paciente
                    int travaNome = 1;
                    String nome = " ";
                    do {
                        System.out.println("Digite o nome do paciente que você deseja adicionar: ");
                        nome = key.nextLine();
                        travaNome = cadastro.verificacaoLetras(nome); // Tratamento de letras na entrada de dados
                        if (travaNome == 1) { // Verificação na entrada de dados
                            System.out.println("Nome inválido, tente novamente");
                        }
                    } while (travaNome == 1);

                    int travaCpf = 1;
                    String cpf = " ";
                    do {
                        System.out.println("Digite o cpf do paciente");
                        cpf = key.nextLine();
                        travaCpf = cadastro.verificacaoNumeros(cpf); // Tratamento de números na entrada de dados
                        if (cadastro.cpfRepetido(paciente, cpf) == true) { // Verifica Cpf repetido
                            System.out.println("Esse CPF já está cadastrado!");
                        }
                        if (travaCpf == 1) { // Verificação na entrada de dados
                            System.out.println("Cpf inválido, tente novamente");
                        } else if (cpf.length() != 11) {
                            System.out.println(
                                    "Cpf inválido, digite apenas os números do cpf do paciente, Ex: 11122233345");
                        }
                    } while (cpf.length() != 11 || travaCpf == 1 || cadastro.cpfRepetido(paciente, cpf) == true);

                    int travaTelefone;
                    String tel = " ";
                    do {
                        System.out.println("Digite o celular do paciente");
                        tel = key.nextLine();
                        travaTelefone = cadastro.verificacaoNumeros(tel); // Tratamento de números na entrada de dados
                        if (tel.length() != 9) { // Verificação no tamanho do telefone
                            System.out.println("Número de celular inválido utilize o formato 911223344 ");
                        } else if (travaTelefone == 1) { // Verificação na entrada de dados
                            System.out.println("Número de celular inválido, tente novamente");
                        }
                    } while (tel.length() != 9 || travaTelefone == 1);

                    String diagnostico;
                    int diagnosticoCodigo = 0;
                    do {
                        System.out.println("Escolha o diagnóstico que o paciente recebeu: ");
                        System.out.println("1 - Covid ");
                        System.out.println("2 - Zica ");
                        System.out.println("3 - Chikungunya ");
                        System.out.println("4 - Dengue ");
                        diagnostico = key.nextLine();
                        diagnosticoCodigo = cadastro.tranforma(diagnostico); // Tratamento de números na entrada de
                                                                             // dados
                    } while (diagnosticoCodigo < 1 || diagnosticoCodigo > 4);

                    String remedio;
                    int remedioCodigo = 0;
                    do {
                        System.out.println("Escolha o remédio que foi receitado para o paciente: ");
                        System.out.println("1 - CovidUltra (" + medicamento[0].getQuantidadeRemedio() + " em estoque)");
                        System.out.println("2 - Zicox (" + medicamento[1].getQuantidadeRemedio() + " em estoque)");
                        System.out.println("3 - ChikTop (" + medicamento[2].getQuantidadeRemedio() + " em estoque)");
                        System.out.println("4 - Denguenit (" + medicamento[3].getQuantidadeRemedio() + " em estoque)");
                        remedio = key.nextLine();
                        remedioCodigo = cadastro.tranforma(remedio); // Tratamento de números na entrada de dados
                    } while (remedioCodigo < 1 || remedioCodigo > 4);

                    String quant;
                    int quantTrava;
                    int quantCode = 0;
                    do {
                        System.out.println("Digite a quantidade de remédio receitada para o paciente: ");
                        quant = key.nextLine();
                        quantTrava = cadastro.verificacaoNumeros(quant); // Tratamento de números na entrada de dados
                        if (quantTrava != 1) { // Verificação na entrada de dados
                            quantCode = quantTrava;
                        } else {
                            System.out.println("Entrada de dados inválida, tente novamente");
                        }
                        if (quantCode > medicamento[remedioCodigo - 1].getQuantidadeRemedio() || quantCode < 0) {
                            System.out.println("Quantidade indisponivel no estoque!");
                        } // Verificando se há a quantidade suficiente no estoque para criar o paciente
                    } while (quantCode > medicamento[remedioCodigo - 1].getQuantidadeRemedio() || quantCode < 0
                            || quantTrava == 1);
                    cadastro.alterarRemedio(quantCode, medicamento, remedioCodigo, nome, cpf, tel, diagnosticoCodigo);
                    // Adicionando o paciente com os dados armazenados no vetor
                    break;

                case 2: // Opção remover paciente
                    String removerPac = " ";
                    int travaRemovePac;
                    do {
                        System.out.println("Digite o cpf do paciente que você deseja remover: ");
                        removerPac = key.nextLine();
                        travaRemovePac = cadastro.verificacaoNumeros(removerPac); // Tratamento de números na entrada de
                                                                                  // dados
                        if (travaRemovePac == 1) { // Verificação na entrada de dados
                            System.out.println(
                                    "Cpf inválido, digite apenas os números do cpf do paciente, Ex: 11122233345");
                        }
                        if (removerPac.length() != 11) { // Verificação no tamanho do Cpf
                            System.out.println(
                                    "Cpf inválido, digite apenas os números do cpf do paciente, Ex: 11122233345");
                        }
                    } while (removerPac.length() != 11 || travaRemovePac == 1);
                    cadastro.removerPaciente(paciente, removerPac); // Remove o paciente utilizando o Cpf
                    cadastro.organizarVetor(paciente); // Organiza o vetor para não deixar "furos"
                    System.out.println("----------------------------------------------------------- ");
                    System.out.println("Pressione enter para voltar ao menu");
                    System.out.println("----------------------------------------------------------- ");
                    break;

                case 3: // Menu do sistema de pacientes
                    String fichas;
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
                        fichas = key.nextLine();
                        menuFichas = cadastro.tranforma(fichas); // Tratamento de números na entrada de dados
                    } while (menuFichas >= 5 || menuFichas <= 0);
                    switch (menuFichas) {
                        case 1: // Mostra apenas as posições ocupadas do vetor
                            System.out.println("Aqui está a ficha com os pacientes internados:  ");
                            System.out.println(" ");
                            cadastro.imprimeOcupado();
                            System.out.println("----------------------------------------------------------- ");
                            System.out.println("Pressione enter para voltar ao menu");
                            System.out.println("----------------------------------------------------------- ");
                            break;
                        case 2: // Mostra o vetor inteiro
                            System.out.println("Aqui está a ficha com os pacientes e os leitos ainda disponiveis: ");
                            System.out.println(" ");
                            cadastro.imprimeTodoVetor();
                            System.out.println("----------------------------------------------------------- ");
                            System.out.println("Pressione enter para voltar ao menu");
                            System.out.println("----------------------------------------------------------- ");
                            break;
                        case 3: // Mostra a porcentagem de ocorreência de cada doença na UPA
                            System.out.println("Aqui está o relatório da ocorrência das doenças no hospital: ");
                            System.out.println(" ");
                            cadastro.porcentDoenças();
                            System.out.println("----------------------------------------------------------- ");
                            System.out.println("Pressione enter para voltar ao menu");
                            System.out.println("----------------------------------------------------------- ");
                            break;
                        case 4: // Ordena os Pacientes internados em ordem alfabética
                            System.out.println("Aqui está o relatório de pacientes em ordem alfabética: ");
                            System.out.println(" ");
                            int cont = 0;
                            for (int i = 0; i < paciente.length; i++) {
                                if (paciente[i] != null) {
                                    cont++;
                                }
                            }
                            String[] nomes = new String[cont];
                            int index = 0;
                            for (int i = 0; i < paciente.length; i++) {
                                if (paciente[i] != null) {
                                    nomes[index] = paciente[i].getNome();
                                    index++;
                                }
                            }
                            Arrays.sort(nomes);
                            for (int j = 0; j < nomes.length; j++) {
                                for (int i = 0; i < paciente.length; i++) {
                                    if (paciente[i] != null && nomes[j].equals(paciente[i].getNome())) {
                                        Paciente temp = paciente[j];
                                        paciente[j] = paciente[i];
                                        paciente[i] = temp;
                                    }
                                }
                            }
                            for (int i = 0; i < paciente.length; i++) {
                                if (paciente[i] != null) {
                                    System.out.println(paciente[i] + "\n");
                                }
                            }
                            System.out.println("----------------------------------------------------------- ");
                            System.out.println("Pressione enter para voltar ao menu");
                            System.out.println("----------------------------------------------------------- ");
                    }
                    break;

                case 4: // Menu de controle do estoque de remédios da UPA
                    String remedioCode;
                    int menuRemedio;
                    do {
                        System.out.println("------------------------------------------------ ");
                        System.out.println("|  Bem-vindo(a) ao estoque de remédios da UPA  | ");
                        System.out.println("| -------------------------------------------- | ");
                        System.out.println("|  1 - Verificar o estoque de remédios:        | ");
                        System.out.println("|  2 - Alterar o estoque:                      | ");
                        System.out.println("------------------------------------------------ ");
                        remedioCode = key.nextLine();
                        menuRemedio = cadastro.tranforma(remedioCode); // Tratamento de números na entrada de dados
                    } while (menuRemedio <= 0 || menuRemedio > 2);
                    switch (menuRemedio) {
                        case 1: // Mostra todo o estoque de remédios
                            System.out.println("----------------------------------------------------------- ");
                            System.out.println(
                                    "O estoque de CovidUltra possui: " + medicamento[0].getQuantidadeRemedio()
                                            + " caixas");
                            System.out.println(
                                    "O estoque de Zicox possui: " + medicamento[1].getQuantidadeRemedio() + " caixas");
                            System.out.println(
                                    "O estoque de ChikTop possui: " + medicamento[2].getQuantidadeRemedio()
                                            + " caixas");
                            System.out
                                    .println("O estoque de Denguenit possui: " + medicamento[3].getQuantidadeRemedio()
                                            + " caixas");

                            System.out.println("----------------------------------------------------------- ");
                            System.out.println("Pressione enter para voltar ao menu");
                            System.out.println("----------------------------------------------------------- ");
                            break;
                        case 2: // Menu para alterar estoque de remédios
                            String alteraEstoqueCode;
                            int opcaoAlteraEstoque = 0;
                            do {
                                System.out.println("Escolha o estoque de remédio que deseja alterar");
                                System.out.println("1 - Alterar estoque de CovidUltra");
                                System.out.println("2 - Alterar estoque de Zicox");
                                System.out.println("3 - Alterar estoque de ChikTop");
                                System.out.println("4 - Alterar estoque de Denguenit");
                                alteraEstoqueCode = key.nextLine();
                                opcaoAlteraEstoque = cadastro.tranforma(alteraEstoqueCode);
                                // Tratamento de números na entrada de dados

                            } while (opcaoAlteraEstoque > 4 || opcaoAlteraEstoque <= 0);
                            switch (opcaoAlteraEstoque) {
                                case 1: // Altera a quantidade de CovidUltra
                                    String covidAltera;
                                    int travaCovidAltera;
                                    int covidAlteraInt = 0;
                                    do {
                                        System.out.println("Digite a nova quantidade de CovidUltra do estoque");
                                        covidAltera = key.nextLine();
                                        travaCovidAltera = cadastro.verificacaoNumeros(covidAltera);
                                        // Tratamento de números na entrada de dados
                                        if (travaCovidAltera == 1) {
                                            System.out.println("Entrada inválida, tente novamente");
                                        }
                                        if (travaCovidAltera == 2) {
                                            covidAlteraInt = Integer.parseInt(covidAltera);
                                        }
                                        if (covidAlteraInt < 0) {
                                            System.out.println(
                                                    "Quantidades de caixas de CovidUltra inválida, tente novamente");
                                        }
                                    } while (covidAlteraInt < 0 || travaCovidAltera == 1);
                                    medicamento[0].setQuantidadeRemedio(covidAlteraInt);
                                    System.out.println("----------------------------------------------------------- ");
                                    System.out.println("Estoque de CovidUltra atualizado");
                                    System.out.println("----------------------------------------------------------- ");
                                    System.out.println(" ");
                                    System.out.println("----------------------------------------------------------- ");
                                    System.out.println("Pressione enter para voltar ao menu");
                                    System.out.println("----------------------------------------------------------- ");
                                    break;
                                case 2: // Alterar quantidade de zicox
                                    String zicAltera;
                                    int travaZicAltera;
                                    int zicAlteraInt = 0;
                                    do {
                                        System.out.println("Digite a nova quantidade de Zicox do estoque");
                                        zicAltera = key.nextLine();
                                        travaZicAltera = cadastro.verificacaoNumeros(zicAltera);
                                        // Tratamento de números na entrada de dados
                                        if (travaZicAltera == 1) { // Verificação na entrada de dados
                                            System.out.println("Entrada inválida, tente novamente");
                                        }
                                        if (travaZicAltera == 2) {
                                            zicAlteraInt = Integer.parseInt(zicAltera);
                                        }
                                        if (zicAlteraInt < 0) { // Verificação na entrada de dados
                                            System.out.println(
                                                    "Quantidades de caixas de Zicox inválida, tente novamente");
                                        }
                                    } while (zicAlteraInt < 0 || travaZicAltera == 1);
                                    medicamento[1].setQuantidadeRemedio(zicAlteraInt);
                                    System.out.println("----------------------------------------------------------- ");
                                    System.out.println("Estoque de Zicox atualizado");
                                    System.out.println("----------------------------------------------------------- ");
                                    System.out.println(" ");
                                    System.out.println("----------------------------------------------------------- ");
                                    System.out.println("Pressione enter para voltar ao menu");
                                    System.out.println("----------------------------------------------------------- ");
                                    break;
                                case 3: // Alterar a quantidade de ChikTop
                                    String chikAltera;
                                    int travaChikAltera;
                                    int chikAlteraInt = 0;
                                    do {
                                        System.out.println("Digite a nova quantidade de ChikTop do estoque");
                                        chikAltera = key.nextLine();
                                        travaChikAltera = cadastro.verificacaoNumeros(chikAltera);
                                        // Tratamento de números na entrada de dados
                                        if (travaChikAltera == 1) { // Verificação na entrada de dados
                                            System.out.println("Entrada inválida, tente novamente");
                                        }
                                        if (travaChikAltera == 2) {
                                            chikAlteraInt = Integer.parseInt(chikAltera);
                                        }
                                        if (chikAlteraInt < 0) { // Verificação na entrada de dados
                                            System.out.println(
                                                    "Quantidades de caixas de ChikTop inválida, tente novamente");
                                        }
                                    } while (chikAlteraInt < 0 || travaChikAltera == 1);
                                    medicamento[2].setQuantidadeRemedio(chikAlteraInt);
                                    System.out.println("----------------------------------------------------------- ");
                                    System.out.println("Estoque de ChikTop atualizado");
                                    System.out.println("----------------------------------------------------------- ");
                                    System.out.println(" ");
                                    System.out.println("----------------------------------------------------------- ");
                                    System.out.println("Pressione enter para voltar ao menu");
                                    System.out.println("----------------------------------------------------------- ");
                                    break;
                                case 4: // alterar a quantidade de Denguenit
                                    String dengAltera;
                                    int travaDengAltera;
                                    int dengAlteraInt = 0;
                                    do {
                                        System.out.println("Digite a nova quantidade de Denguenit do estoque");
                                        dengAltera = key.nextLine();
                                        travaDengAltera = cadastro.verificacaoNumeros(dengAltera);
                                        // Tratamento de números na entrada de dados
                                        if (travaDengAltera == 1) { // Verificação na entrada de dados
                                            System.out.println("Entrada inválida, tente novamente");
                                        }
                                        if (travaDengAltera == 2) {
                                            dengAlteraInt = Integer.parseInt(dengAltera);
                                        }
                                        if (dengAlteraInt < 0) { // Verificação na entrada de dados
                                            System.out.println(
                                                    "Quantidades de caixas de Denguenit inválida, tente novamente");
                                        }
                                    } while (dengAlteraInt < 0 || travaDengAltera == 1);
                                    medicamento[3].setQuantidadeRemedio(dengAlteraInt);
                                    System.out.println("----------------------------------------------------------- ");
                                    System.out.println("Estoque de Denguenit atualizado");
                                    System.out.println("----------------------------------------------------------- ");
                                    System.out.println(" ");
                                    System.out.println("----------------------------------------------------------- ");
                                    System.out.println("Pressione enter para voltar ao menu");
                                    System.out.println("----------------------------------------------------------- ");
                                    break;
                            }
                            break;
                    }
                    break;

                case 5: // Menu para alterar informações de um paciente já cadastrado
                    String alterPaciente;
                    int alterPacienteCode = 0;
                    String cpfPaciente;
                    int cpfPacienteCode;
                    do {
                        System.out.println("Digite o CPF do paciente que você deseja alterar a ficha: ");
                        cpfPaciente = key.nextLine();
                        cpfPacienteCode = cadastro.verificacaoNumeros(cpfPaciente);
                        // Tratamento de números na entrada de dados
                        if (cpfPacienteCode == 1) { // Verificação na entrada de dados
                            System.out.println("Entrada inválida, tente novamente ");
                        }
                    } while (cpfPacienteCode == 1 || cpfPaciente.length() != 11);

                    int infoCpf = cadastro.localizarPaciente(cpfPaciente);
                    // Localiza a posição do paciente pelo Cpf do mesmo
                    if (infoCpf != -1) {
                        do {
                            System.out.println("O que você deseja alterar do paciente: " + paciente[infoCpf].getNome());
                            System.out.println("1 - Nome: " + paciente[infoCpf].getNome());
                            System.out.println("2 - CPF: " + paciente[infoCpf].getCpf());
                            System.out.println("3 - Telefone: " + paciente[infoCpf].getTelefone());
                            System.out.println("4 - Diagnóstico: " + paciente[infoCpf].getDiagnostico());
                            System.out.println("5 - Medicamento: " + paciente[infoCpf].getMedicamentoIndicado());
                            System.out.println("6 - Quantidade de caixas: " + paciente[infoCpf].getQuantidadeCaixas());
                            alterPaciente = key.nextLine();
                            alterPacienteCode = cadastro.tranforma(alterPaciente);
                            // Tratamento de números na entrada de dados
                            if (alterPacienteCode <= 0 || alterPacienteCode > 6) {
                                System.out.println("Número inváilido, tente novamente");
                            }
                        } while (alterPacienteCode <= 0 || alterPacienteCode > 6);
                    } else {
                        System.out.println("Paciente com o cpf: " + cpfPaciente + " não foi encontrado");
                        System.out.println("----------------------------------------------------------- ");
                        System.out.println("Pressione enter para voltar ao menu");
                        System.out.println("----------------------------------------------------------- ");

                    }

                    // Variáveis de controle

                    String novoRemed;
                    int novoRemedCode = 0;

                    String novaQuant;
                    int travaNovaQuant;
                    int novaQuantCode = 0;

                    int travaNovoNome;

                    String novoCpf;
                    int travaNovoCpf;

                    String novoTelefone;
                    int travaNovoTelefone;

                    String novoDiag;
                    int novoDiagCode;

                    switch (alterPacienteCode) {
                        case 1:

                            do {
                                System.out.println("Atualize o nome do paciente: ");
                                String novoNome = key.nextLine();
                                travaNovoNome = cadastro.verificacaoLetras(novoNome);
                                // Tratamento de letras na entrada de dados
                                paciente[infoCpf].setNome(novoNome);
                                if (travaNovoNome == 1) { // Verificação na entrada de dados
                                    System.out.println("Entrada inválida, tente novamente ");
                                }
                            } while (travaNovoNome == 1);
                            System.out.println("----------------------------------------------------------- ");
                            System.out.println("Nome do paciente atualizado com sucesso ");
                            System.out.println("----------------------------------------------------------- ");
                            System.out.println(" ");

                            break;
                        case 2:

                            do {
                                System.out.println("Atualize o CPF do paciente: ");
                                novoCpf = key.nextLine();
                                travaNovoCpf = cadastro.verificacaoNumeros(novoCpf);
                                // Tratamento de números na entrada de dados
                                paciente[infoCpf].setCpf(novoCpf);
                                if (travaNovoCpf == 1) { // Verificação na entrada de dados
                                    System.out.println("Entrada inválida, tente novamente ");
                                } else if (novoCpf.length() != 11) { // Verificação no tamanho do novo Cpf
                                    System.out.println("Entrada inválida, tente novamente");
                                }
                            } while (travaNovoCpf == 1 || novoCpf.length() != 11);
                            System.out.println("----------------------------------------------------------- ");
                            System.out.println("Cpf do paciente atualizado com sucesso ");
                            System.out.println("----------------------------------------------------------- ");
                            System.out.println(" ");
                            break;
                        case 3:

                            do {
                                System.out.println("Atualize o telefone do paciente: ");
                                novoTelefone = key.nextLine();
                                travaNovoTelefone = cadastro.verificacaoNumeros(novoTelefone);
                                // Tratamento de números na entrada de dados
                                paciente[infoCpf].setTelefone(novoTelefone);
                                if (travaNovoTelefone == 1) { // Verificação no tamanho do novo Cpf
                                    System.out.println("Entrada inválida, tente novamente ");
                                } else if (novoTelefone.length() != 9) { // Verificação no tamanho do novo Telefone
                                    System.out.println("Entrada inválida, tente novamente");
                                }
                            } while (travaNovoTelefone == 1 || novoTelefone.length() != 9);
                            System.out.println("----------------------------------------------------------- ");
                            System.out.println("Telefone do paciente atualizado com sucesso ");
                            System.out.println("----------------------------------------------------------- ");
                            System.out.println(" ");
                            break;
                        case 4:
                            do { // Menu para atualização do diagnóstico do paciente
                                System.out.println("Atualize o diagnóstico do paciente: ");
                                System.out.println("1 - Covid ");
                                System.out.println("2 - Zica ");
                                System.out.println("3 - Chikungunya ");
                                System.out.println("4 - Dengue ");
                                novoDiag = key.next();
                                novoDiagCode = cadastro.tranforma(novoDiag);
                                // Tratamento de números na entrada de dados
                                paciente[infoCpf].setDiagnostico(novoDiagCode);
                            } while (novoDiagCode <= 0 || novoDiagCode > 4);
                            System.out.println("----------------------------------------------------------- ");
                            System.out.println("Diagnóstico do paciente atualizado com sucesso ");
                            System.out.println("----------------------------------------------------------- ");
                            System.out.println(" ");
                            break;
                        case 5:
                            do { // Menu para atualização do remédio receitado do paciente
                                System.out.println("Atualize o remédio receitado para o paciente: ");
                                System.out.println("Escolha o remédio que foi receitado para o paciente: ");
                                System.out.println(
                                        "1 - CovidUltra (" + medicamento[0].getQuantidadeRemedio() + " em estoque)");
                                System.out.println(
                                        "2 - Zicox (" + medicamento[1].getQuantidadeRemedio() + " em estoque)");
                                System.out.println(
                                        "3 - ChikTop (" + medicamento[2].getQuantidadeRemedio() + " em estoque)");
                                System.out.println(
                                        "4 - Denguenit (" + medicamento[3].getQuantidadeRemedio() + " em estoque)");
                                novoRemed = key.nextLine();
                                novoRemedCode = cadastro.tranforma(novoRemed);
                                // Tratamento de números na entrada de dados
                            } while (novoRemedCode < 0 || novoRemedCode > 4);

                            switch (novoRemedCode) {
                                case 1:
                                    paciente[infoCpf].setMedicamentoIndicado("CovidUltra");
                                    break;
                                case 2:
                                    paciente[infoCpf].setMedicamentoIndicado("Zicox");
                                    break;
                                case 3:
                                    paciente[infoCpf].setMedicamentoIndicado("ChikTop");
                                    break;
                                case 4:
                                    paciente[infoCpf].setMedicamentoIndicado("Denguenit");
                            }
                            System.out.println("----------------------------------------------------------- ");
                            System.out.println("Remédio do paciente atualizado com sucesso ");
                            System.out.println("----------------------------------------------------------- ");
                            System.out.println(" ");
                            break;

                        case 6:
                            do {
                                System.out.println("Digite a nova quantidade receitada: ");
                                novaQuant = key.nextLine();
                                travaNovaQuant = cadastro.verificacaoNumeros(novaQuant);
                                // Tratamento de números na entrada de dados
                                if (travaNovaQuant != 1) { // Verificação no tamanho do novo Telefone
                                    novaQuantCode = Integer.parseInt(novaQuant);
                                }

                                paciente[infoCpf].setQuantidadeCaixas(novaQuantCode);
                            } while (travaNovaQuant == 1
                                    || novaQuantCode > medicamento[novoRemedCode].getQuantidadeRemedio()
                                    || novaQuantCode < 0);
                            medicamento[novoRemedCode].setQuantidadeRemedio(
                                    medicamento[novoRemedCode].getQuantidadeRemedio() - novaQuantCode);

                            System.out.println("-----------------------------------------------------------");
                            System.out.println("Quantidade receitada atualizada com sucesso ");
                            System.out.println("-----------------------------------------------------------");
                            System.out.println(" ");
                            break;
                    }

                    break;
                case 6: // Opção para encerrar o programa
                    System.out.println("----------------------------------------------------------- ");
                    System.out.println("Obrigado por utilizar nosso programa");
                    System.out.println("----------------------------------------------------------- ");
                    saida = 6; // Atualiza a variável saida para 6, o que faz o loop de repetição se encerrar
            }
        } while (saida == 0); // Controle do loop de repetição do menu principal
        key.close();
    }
}