public class CadastroPaciente {
  private Paciente[] pacientes;
  private int tamanho;
  int index = 0;

  public CadastroPaciente(int tamanho) {
    this.tamanho = tamanho;
    pacientes = new Paciente[tamanho];

  }

  public Paciente[] getPacientes() {
    return pacientes;
  }

  public int getTamanho() {
    return tamanho;
  }

  public void setPacientes(Paciente[] pacientes) {
    this.pacientes = pacientes;
  }

  public void setTamanho(int tamanho) {
    this.tamanho = tamanho;
  };

  public int localizarPaciente(String cpf) {
    int posicao = -1;
    for (int i = 0; i < pacientes.length; i++) {
      if (pacientes[i] != null) {
        if (pacientes[i].getCpf().equals(cpf)) {
          posicao = i;
        }
      }
    }
    return posicao;
  }

  public int verificacaoLetras(String nome) { // Percorre o parametro e verifica se ele tem algum número
    int aux = 1;
    for (int i = 0; i < nome.length(); i++) {
      char a = nome.charAt(i);
      if (a == '1' || a == '2' || a == '3' || a == '4' || a == '5' || a == '6' || a == '7' || a == '8' || a == '9'
          || a == '0') {
        aux = 1;
        i = nome.length();
      } else {
        aux = 2;
      }
    }
    return aux;
  }

  public int verificacaoNumeros(String cpf) { // Percorre o parametro e verifica se ele tem alguma letra
    for (int i = 0; i < cpf.length(); i++) {
      char a = cpf.charAt(i);
      if (a == '1' || a == '2' || a == '3' || a == '4' || a == '5' || a == '6' || a == '7' || a == '8' || a == '9'
          || a == '0') {
      } else {
        return 1;
      }
    }
    return 2;
  }

  public boolean cpfRepetido(Paciente[] p, String cpf) { // Método que verifica se tem Pacientes com Cpf repetido
    boolean retorno = false;
    for (int i = 0; i < pacientes.length; i++) {
      if (pacientes[i] != null) {
        if (pacientes[i].getCpf().equals(cpf)) {
          retorno = true;
        }
      }
    }
    return retorno;
  }

  public int tranforma(String valor) { // Transforma uma string em int para trabalhar de maneira mais simples no main
    int aux = 0;
    switch (valor) {
      case "1":
        aux = 1;
        break;
      case "2":
        aux = 2;
        break;
      case "3":
        aux = 3;
        break;
      case "4":
        aux = 4;
        break;
      case "5":
        aux = 5;
        break;
      case "6":
        aux = 6;
        break;
      default:
        System.out.println("Opção inválida, tente novamente");
        aux = 7;
        break;
    }
    return aux;
  }

  public boolean addPaciente(Paciente c) { // Adiciona pacientes ao Vetor
    if (index >= pacientes.length) {
      System.out.println("----------------------------------------------------------- ");
      System.out.println("A UPA está lotada, estamos sem espaços para novos pacientes ");
      System.out.println("----------------------------------------------------------- ");
      return false;
    } else {
      System.out.println("----------------------------------------------------------- ");
      System.out.println("Paciente cadatrado com sucesso ");
      System.out.println("----------------------------------------------------------- ");
      System.out.println(" ");
      System.out.println("----------------------------------------------------------- ");
      System.out.println("Pressione enter para voltar ao menu");
      System.out.println("----------------------------------------------------------- ");
      pacientes[index] = c;
      index++;
      return true;
    }
  }

  public void removerPaciente(Paciente[] p, String cpf) { // Localiza o paciente passando o cpf como parâmetro e remove
                                                          // o paciente de cpf x
    boolean existe = false;
    for (int i = 0; i < pacientes.length; i++) {
      if (pacientes[i] != null) {
        if (pacientes[i].getCpf().equals(cpf)) {
          existe = true;
          System.out.println("----------------------------------------------------------- ");
          System.out.println("O paciente " + pacientes[i].getNome() + " foi apagado do sistema.");
          System.out.println("----------------------------------------------------------- ");
          System.out.println(" ");
          pacientes[i] = null;
        }
      }
    }
    if (existe == false) {
      System.out.println("----------------------------------------------------------- ");
      System.out.println("Não existe nenhuma paciente com CPF: " + cpf);
      System.out.println("----------------------------------------------------------- ");
      System.out.println(" ");
    }
  }

  public void alterarRemedio(int quant, Medicamento[] medicamento, int remed, String nome, String cpf, String tel,
      int diag) { // Método para alterar o remédio receitado
    if (quant <= medicamento[remed - 1].getQuantidadeRemedio()) {
      medicamento[remed - 1]
          .setQuantidadeRemedio(medicamento[remed - 1].getQuantidadeRemedio() - quant);
      Paciente completarPaciente = new Paciente(nome, cpf, tel, diag,
          medicamento[remed - 1].getNomeRemedio(), quant);
      addPaciente(completarPaciente);
    }
  }

  public void organizarVetor(Paciente[] p) { // Método para organizar o vetor, para não permitir "furos" no vetor
    Paciente[] p2 = new Paciente[p.length];
    int cont = 0;
    for (int i = 0; i < p.length; i++) {
      if (p[i] != null) {
        p2[cont] = p[i];
        cont++;
      } else {
        index = cont;
      }
    }
    for (int f = 0; f < p.length; f++) {
      p[f] = p2[f];
    }
  }

  public void porcentDoenças() { // Cálcula a porcentagem de doenças recebendo a quantidade de cada ocorrência da
                                 // doença.
    int contCovid = 0;
    int contZika = 0;
    int contChikungunya = 0;
    int contDengue = 0;

    int total = 0;

    double percentCovid = 0;
    double percentZika = 0;
    double percentChikungunya = 0;
    double percentDengue = 0;

    for (int i = 0; i < pacientes.length; i++) {
      if (pacientes[i] != null) {
        if (pacientes[i].getDiagnostico().equals("Covid")) {
          contCovid++;
        }
        if (pacientes[i].getDiagnostico().equals("Zika")) {
          contZika++;
        }
        if (pacientes[i].getDiagnostico().equals("Chikungunya")) {
          contChikungunya++;
        }
        if (pacientes[i].getDiagnostico().equals("Dengue")) {
          contDengue++;
        }
        total = contChikungunya + contCovid + contDengue + contZika;
        percentCovid = ((double) contCovid / total) * 100;
        percentZika = ((double) contZika / total) * 100;
        percentChikungunya = ((double) contChikungunya / total) * 100;
        percentDengue = ((double) contDengue / total) * 100;
      }
    }
    System.out.println("Total de pacientes registrados: " + total + "\nCovid: " + percentCovid + "%\nZika: "
        + percentZika + "%\nChikungunya: " + percentChikungunya + "%\nDengue: " + percentDengue);
    System.out.println("----------------------------------------------------------- ");
    System.out.println("");
  }

  public void imprimeTodoVetor() { // Imprime todo o vetor paciente. (Com as lacunas)
    for (int i = 0; i < pacientes.length; i++) {
      if (pacientes[i] != null) {

        System.out.println("Posição: " + i);
        System.out.println("Nome do Paciente:  " + pacientes[i].getNome());
        System.out.println("Cpf do paciente: " + pacientes[i].getCpf());
        System.out.println("Celucar do paciente: " + pacientes[i].getTelefone());
        System.out.println("Diagnóstico do paciente: " + pacientes[i].getDiagnostico());
        System.out.println("Medicamento receitado: " + pacientes[i].getMedicamentoIndicado());
        System.out.println("Quantidade de caixas raceitadas: " + pacientes[i].getQuantidadeCaixas());
        System.out.println(" ");
      } else if (pacientes[i] == null) {
        System.out.println("Essa posição não está cadastrada: " + i);
        System.out.println(" ");
      }
    }
  }

  public void imprimeOcupado() { // Imprime todo o vetor paciente. (Sem as lacunas)
    for (int i = 0; i < pacientes.length; i++) {
      if (pacientes[i] != null) {
        System.out.println("Posição: " + i);
        System.out.println("Nome do Paciente:  " + pacientes[i].getNome());
        System.out.println("Cpf do paciente: " + pacientes[i].getCpf());
        System.out.println("Celulcar do paciente: " + pacientes[i].getTelefone());
        System.out.println("Diagnóstico do paciente: " + pacientes[i].getDiagnostico());
        System.out.println("Medicamento receitado: " + pacientes[i].getMedicamentoIndicado());
        System.out.println("Quantidade de caixas receitadas: " + pacientes[i].getQuantidadeCaixas());
        System.out.println(" ");
      }
    }
  }
}
