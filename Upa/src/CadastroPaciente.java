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
    int selecionado = 0;
    for (int i = 0; i < tamanho; i++) {
      if (pacientes[i] != null && pacientes[i].getCpf() == cpf) {
        selecionado = i;
      }
    }
    return selecionado;
  }

  public boolean AddPaciente(Paciente c) { // Adiciona pacientes ao Vetor
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
      pacientes[index] = c;
      index++;
      return true;
    }
  }

  public void removerPaciente(Paciente[] p, int posicao) {
    if (p[posicao] != null) {
      p[posicao] = null;
      System.out.println("----------------------------------------------------------- ");
      System.out.println("O paciente da posição " + posicao + " foi apagado do sistema.");
      System.out.println("----------------------------------------------------------- ");
      System.out.println(" ");
    } else {
      System.out.println("----------------------------------------------------------- ");
      System.out.println("Não foi encontrado nenhum paciente na posição: " + posicao);
      System.out.println("----------------------------------------------------------- ");
      System.out.println(" ");
    }
  }

  public void organizarVetor(Paciente[] p) {
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

  public void porcentDoenças() {
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

  public void imprimeTodoVetor() {
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

  public void imprimeOcupado() {
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
