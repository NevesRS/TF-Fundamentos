import java.util.*;

public class App {
    // teste
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        Medicamento[] medicamento = new Medicamento[4];
        medicamento[0] = new Medicamento("CovidUltra", 15);
        medicamento[1] = new Medicamento("Zicox", 20);
        medicamento[2] = new Medicamento("ChikTop", 15);
        medicamento[3] = new Medicamento("Denguenit", 15);

        Paciente[] paciente = new Paciente[10];

        paciente[0] = new Paciente("Bruno", "12345678900", null, 0, null, 0);
        paciente[1] = new Paciente("Aline", "1234", null, 0, null, 0);

        CadastroPaciente cadastro = new CadastroPaciente(10);
        cadastro.setPacientes(paciente);

        int saida = 0;
        String opcaoPrincipal;
        int opcaoPrincipalCode = 5;
        System.out.println("----------------------------------------------------------- ");
        System.out.println("Olá, pressione enter para entrar no programa");
        System.out.println("----------------------------------------------------------- ");
        do {
            key.nextLine();
            do {

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
            } while (opcaoPrincipalCode <= 0 || opcaoPrincipalCode > 6);

            switch (opcaoPrincipalCode) {
                case 1: // Adicionar paciente
                    int travaNome = 1;
                    String nome = " ";
                    do {
                        System.out.println("Digite o nome do paciente que você deseja adicionar: ");
                        nome = key.nextLine();
                        travaNome = cadastro.verificacaoLetras(nome);
                        if (travaNome == 1) {
                            System.out.println("Nome inválido, tente novamente");
                        }
                    } while (travaNome == 1);

                    int travaCpf = 1;
                    String cpf = " ";
                    do {
                        System.out.println("Digite o cpf do paciente");
                        cpf = key.nextLine();
                        travaCpf = cadastro.verificacaoNumeros(cpf);
                        if (travaCpf == 1) {
                            System.out.println("Cpf inválido, tente novamente");
                        } else if (cpf.length() != 11) {
                            System.out.println(
                                    "Cpf inválido, digite apenas os números do cpf do paciente, Ex: 11122233345");
                        }
                    } while (cpf.length() != 11 || travaCpf == 1);

                    int travaTelefone;
                    String tel = " ";
                    do {
                        System.out.println("Digite o celular do paciente");
                        tel = key.nextLine();
                        travaTelefone = cadastro.verificacaoNumeros(tel);
                        if (tel.length() != 9) {
                            System.out.println("Número de celular inválido, tente novamente");
                        } else if (travaTelefone == 1) {
                            System.out.println("Número de celular invá1lido utilize o formato 911223344 ");
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
                        diagnosticoCodigo = cadastro.tranforma(diagnostico);
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
                        remedioCodigo = cadastro.tranforma(remedio);
                    } while (remedioCodigo < 1 || remedioCodigo > 4);

                    String quant;
                    int quantTrava;
                    int quantCode = 0;
                    do {
                        System.out.println("Digite a quantidade de remédio receitada para o paciente: ");
                        quant = key.nextLine();
                        quantTrava = cadastro.verificacaoNumeros(quant);
                        if (quantTrava != 1) {
                            quantCode = quantTrava;
                        } else {
                            System.out.println("Entrada de dados inválida, tente novamente");
                        }
                        if (quantCode > medicamento[remedioCodigo - 1].getQuantidadeRemedio() || quantCode < 0) {
                            System.out.println("Quantidade indisponivel no estoque!");
                        }
                    } while (quantCode > medicamento[remedioCodigo - 1].getQuantidadeRemedio() || quantCode < 0
                            || quantTrava == 1);
                    cadastro.alterarRemedio(quantCode, medicamento, remedioCodigo, nome, cpf, tel, diagnosticoCodigo);
                    break;

                case 2: // removerPac paciente
                    String removerPac = " ";
                    do {
                        System.out.println("Digite o cpf do paciente que você deseja remover: ");
                        removerPac = key.nextLine();
                        if (removerPac.length() != 11) {
                            System.out.println(
                                    "Cpf inválido, digite apenas os números do cpf do paciente, Ex: 11122233345");
                        }
                    } while (removerPac.length() != 11);
                    cadastro.removerPaciente(paciente, removerPac);
                    cadastro.organizarVetor(paciente);
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
                        menuFichas = cadastro.tranforma(fichas);
                    } while (menuFichas >= 5 || menuFichas <= 0);
                    switch (menuFichas) {
                        case 1:
                            System.out.println("Aqui está a ficha com os pacientes internados:  ");
                            System.out.println(" ");
                            cadastro.imprimeOcupado();
                            System.out.println("----------------------------------------------------------- ");
                            System.out.println("Pressione enter para voltar ao menu");
                            System.out.println("----------------------------------------------------------- ");
                            break;
                        case 2:
                            System.out.println("Aqui está a ficha com os pacientes e os leitos ainda disponiveis: ");
                            System.out.println(" ");
                            cadastro.imprimeTodoVetor();
                            System.out.println("----------------------------------------------------------- ");
                            System.out.println("Pressione enter para voltar ao menu");
                            System.out.println("----------------------------------------------------------- ");
                            break;
                        case 3:
                            System.out.println("Aqui está o relatório da ocorrência das doenças no hospital: ");
                            System.out.println(" ");
                            cadastro.porcentDoenças();
                            System.out.println("----------------------------------------------------------- ");
                            System.out.println("Pressione enter para voltar ao menu");
                            System.out.println("----------------------------------------------------------- ");
                            break;
                        case 4:
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

                case 4: // Gerenciar remédios
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
                        menuRemedio = cadastro.tranforma(remedioCode);
                    } while (menuRemedio <= 0 || menuRemedio > 2);
                    switch (menuRemedio) {
                        case 1: // Mostrar todo o estoque
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
                        case 2:// Alterar estoque
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
                            } while (opcaoAlteraEstoque > 4 || opcaoAlteraEstoque <= 0);
                            switch (opcaoAlteraEstoque) {
                                case 1: // Alterar quantidade de coviultra
                                    String covidAltera;
                                    int travaCovidAltera;
                                    do {
                                        System.out.println("Digite a nova quantidade de CovidUltra do estoque");
                                        covidAltera = key.nextLine();
                                        travaCovidAltera = cadastro.verificacaoNumeros(covidAltera);
                                        medicamento[0].setQuantidadeRemedio(travaCovidAltera);
                                        if (travaCovidAltera == 1) {
                                            System.out.println("Entrada inválida, tente novamente");
                                        }
                                        if (medicamento[0].getQuantidadeRemedio() < 0) {
                                            System.out.println(
                                                    "Quantidades de caixas de CovidUltra inválida, tente novamente");
                                        }
                                    } while (medicamento[0].getQuantidadeRemedio() < 0 || travaCovidAltera == 1);
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
                                    do {
                                        System.out.println("Digite a nova quantidade de Zicox do estoque");
                                        zicAltera = key.nextLine();
                                        travaZicAltera = cadastro.verificacaoNumeros(zicAltera);
                                        medicamento[1].setQuantidadeRemedio(travaZicAltera);
                                        if (travaZicAltera == 1) {
                                            System.out.println("Entrada inválida, tente novamente ");
                                        }
                                        if (medicamento[1].getQuantidadeRemedio() < 0) {
                                            System.out.println(
                                                    "Quantidades de caixas de Zicox inválida, tente novamente");
                                        }
                                    } while (medicamento[1].getQuantidadeRemedio() < 0 || travaZicAltera == 1);
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
                                    do {
                                        System.out.println("Digite a nova quantidade de ChikTop do estoque");
                                        chikAltera = key.nextLine();
                                        travaChikAltera = cadastro.verificacaoLetras(chikAltera);
                                        medicamento[2].setQuantidadeRemedio(travaChikAltera);
                                        if (travaChikAltera == 1) {
                                            System.out.println("Entrada inválida, tente novamente ");
                                        }
                                        if (medicamento[2].getQuantidadeRemedio() < 0) {
                                            System.out.println(
                                                    "Quantidades de caixas de ChikTop inválida, tente novamente");
                                        }
                                    } while (medicamento[2].getQuantidadeRemedio() < 0 || travaChikAltera == 1);
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
                                    do {
                                        System.out.println("Digite a nova quantidade de Denguenit do estoque");
                                        dengAltera = key.nextLine();
                                        travaDengAltera = cadastro.verificacaoNumeros(dengAltera);
                                        medicamento[3].setQuantidadeRemedio(travaDengAltera);
                                        if (travaDengAltera == 1) {
                                            System.out.println("Entrada inválida, tente novamente ");
                                        }
                                        if (medicamento[3].getQuantidadeRemedio() < 0) {
                                            System.out.println(
                                                    "Quantidades de caixas de Denguenit inválida, tente novamente");
                                        }
                                    } while (medicamento[3].getQuantidadeRemedio() < 0 || travaDengAltera == 1);
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

                case 5:
                    String alterPaciente;
                    int alterPacienteCode = 0;
                    String cpfPaciente;
                    int cpfPacienteCode;
                    do {
                        System.out.println("Digite o CPF do paciente que você deseja alterar a ficha: ");
                        cpfPaciente = key.nextLine();
                        cpfPacienteCode = cadastro.verificacaoNumeros(cpfPaciente);
                        if (cpfPacienteCode == 1) {
                            System.out.println("Entrada inválida, tente novamente ");
                        }
                    } while (cpfPacienteCode == 1 || cpfPaciente.length() != 11);

                    int infoCpf = cadastro.localizarPaciente(cpfPaciente);
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
                                paciente[infoCpf].setNome(novoNome);
                                if (travaNovoNome == 1) {
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
                                paciente[infoCpf].setCpf(novoCpf);
                                if (travaNovoCpf == 1) {
                                    System.out.println("Entrada inválida, tente novamente ");
                                } else if (novoCpf.length() != 11) {
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
                                paciente[infoCpf].setTelefone(novoTelefone);
                                if (travaNovoTelefone == 1) {
                                    System.out.println("Entrada inválida, tente novamente ");
                                } else if (novoTelefone.length() != 9) {
                                    System.out.println("Entrada inválida, tente novamente");
                                }
                            } while (travaNovoTelefone == 1 || novoTelefone.length() != 9);
                            System.out.println("----------------------------------------------------------- ");
                            System.out.println("Telefone do paciente atualizado com sucesso ");
                            System.out.println("----------------------------------------------------------- ");
                            System.out.println(" ");
                            break;
                        case 4:

                            do {
                                System.out.println("Atualize o diagnóstico do paciente: ");
                                System.out.println("1 - Covid ");
                                System.out.println("2 - Zica ");
                                System.out.println("3 - Chikungunya ");
                                System.out.println("4 - Dengue ");
                                novoDiag = key.next();
                                novoDiagCode = cadastro.tranforma(novoDiag);
                                paciente[infoCpf].setDiagnostico(novoDiagCode);
                            } while (novoDiagCode <= 0 || novoDiagCode > 4);
                            System.out.println("----------------------------------------------------------- ");
                            System.out.println("Diagnóstico do paciente atualizado com sucesso ");
                            System.out.println("----------------------------------------------------------- ");
                            System.out.println(" ");
                            break;
                        case 5:

                            do {
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
                                if (travaNovaQuant != 1) {
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
                case 6:
                    System.out.println("----------------------------------------------------------- ");
                    System.out.println("Obrigado por utilizar nosso programa");
                    System.out.println("----------------------------------------------------------- ");
                    saida = 6;
            }
        } while (saida == 0);
        key.close();
    }
}