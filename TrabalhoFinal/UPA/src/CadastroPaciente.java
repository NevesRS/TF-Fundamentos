public class CadastroPaciente {
    private Paciente[] pacientes;
    private int tamanho;
    int index = 0;

    public CadastroPaciente(int tamanho){
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

    public int localizarPaciente(String nome){
        int selecionado = -1;
        for(int i = 0; i<tamanho; i++){
            if(pacientes[i] != null && pacientes[i].getNome() == nome){
                selecionado = i;
            }
        }
        return selecionado;
    }

    public void removerPaciente(Paciente[] p, int posicao){ 
        if(p[posicao] != null){
            p[posicao] = null;
            System.out.println("O paciente da: "+ posicao+" foi apagado.");
        }else{
            System.out.println("O paciente não foi encontrado na posição: "+ posicao);
        }
    }

    public void organizarVetor(Paciente[] p){
        Paciente[] p2 = new Paciente[p.length];

        int cont = 0;
            for(int i = 0; i <p.length; i++){
                if(p[i]!=null){
                p2[cont] = p[i];
                cont++;
                }else{
                    index = cont+1; 
                }
            }
            for(int f=0;f<p.length;f++){
                p[f]=p2[f];
            }
    }
}
