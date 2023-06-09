public class App {
    public static void main(String[] args) throws Exception {

        Medicamento medicamentos[] = new Medicamento[4];

        medicamentos[0] = new Medicamento("CovixUltra", 15);
        medicamentos[1] = new Medicamento("Zikox", 15);
        medicamentos[2] = new Medicamento("Chiktop", 15);
        medicamentos[3] = new Medicamento("Denguenit", 15);

        Paciente[] paciente = new Paciente[10];

        paciente[0] = new Paciente("Bruno2", "601111", "9825252", 1, medicamentos[0].getNomeRemedio(),
                medicamentos[0].getQuantidadeRemedio());
        paciente[4] = new Paciente("Bruno3", "601111", "9825252", 1, medicamentos[0].getNomeRemedio(),
                medicamentos[0].getQuantidadeRemedio());
        paciente[5] = new Paciente("Bruno4", "601111", "9825252", 1, medicamentos[0].getNomeRemedio(),
                medicamentos[0].getQuantidadeRemedio());
        paciente[8] = new Paciente("Bruno5", "601111", "9825252", 1, medicamentos[0].getNomeRemedio(),
                medicamentos[0].getQuantidadeRemedio());

        CadastroPaciente p = new CadastroPaciente(10);
        p.setPacientes(paciente);

        int b = p.localizarPaciente("Bruno2");

        // Digite o que você fazer.
        // Remove
        // Digite nome da pessoa que você deseja remover
        // if(b != -1){
        // System.out.println("Paciente encontrado: \n"+paciente[b].toString());
        // }else{
        // System.out.println("Paciente não foi encontrado!");
        // }  

        p.organizarVetor(paciente);

        for (int i = 0; i < paciente.length; i++) {
            if (paciente[i] != null) {
                System.out.println("Posição: " + i + "\n" + paciente[i].toString() + "\n");
            }
        }

    }
}
