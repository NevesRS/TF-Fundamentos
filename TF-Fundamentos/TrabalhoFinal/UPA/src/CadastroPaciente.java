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

    public int localizarPaciente(String nome) {
        int selecionado = -1;
        for (int i = 0; i < tamanho; i++) {
            if (pacientes[i] != null && pacientes[i].getNome() == nome) {
                selecionado = i;
            }
        }
        return selecionado;
    }

    public void teste() {
        System.out.println(pacientes.length);
    }

    public boolean AddPaciente(Paciente c) { // Adiciona pacientes ao Vetor
        if (index >= pacientes.length) {
            return false;
        } else {
            pacientes[index] = c;
            index++;
            return true;
        }
    }

    public void removerPaciente(Paciente[] p, int posicao) {
        if (p[posicao] != null) {
            p[posicao] = null;
            System.out.println("O paciente da: " + posicao + " foi apagado.");
        } else {
            System.out.println("O paciente não foi encontrado na posição: " + posicao);
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
                index = cont + 1;
            }
        }
        for (int f = 0; f < p.length; f++) {
            p[f] = p2[f];
        }
    }

    public void imprimeTodoVetor() {
        for (int i = 0; i < pacientes.length; i++) {
            if (pacientes[i] != null){
                System.out.println("\nPosição: "+i);
                System.out.println("Nome do Paciente:  " + pacientes[i].getNome());
                System.out.println("O Cpf do paciente é: " + pacientes[i].getCpf());
                System.out.println("O celulcar do paciente é" + pacientes[i].getTelefone());
                System.out.println("O diagnóstico do paciente é: " + pacientes[i].getDiagnostico());
                System.out
                        .println("O medicamento que o paciente deve tomar é: " + pacientes[i].getMedicamentoIndicado());
                System.out.println("A quantidade de caixas do medicamento que o usuário deve tomar é: "
                        + pacientes[i].getQuantidadeCaixas());
            }if(pacientes[i] == null){
                System.out.println("\nEssa posição não está cadastrada: "+i);
            }

        }

    }

    public void imprimeOcupado() {
        for (int i = 0; i < pacientes.length; i++) {
            if (pacientes[i] != null) {
                System.out.println("Nome do Paciente:  " + pacientes[i].getNome());
                System.out.println("O Cpf do paciente é: " + pacientes[i].getCpf());
                System.out.println("O celulcar do paciente é" + pacientes[i].getTelefone());
                System.out.println("O diagnóstico do paciente é: " + pacientes[i].getDiagnostico());
                System.out
                        .println("O medicamento que o paciente deve tomar é: " + pacientes[i].getMedicamentoIndicado());
                System.out.println("A quantidade de caixas do medicamento que o usuário deve tomar é: "
                        + pacientes[i].getQuantidadeCaixas());
            }
        }
    }
}
