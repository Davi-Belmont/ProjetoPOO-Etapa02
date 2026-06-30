public class ClinicoGeral extends Profissional {

    public ClinicoGeral(String nome) {
        super(nome, "clinica geral");
    }

    public ClinicoGeral(String nome,
                        String registro,
                        double valor) {

        super(nome, "clinica geral", registro, valor);
    }

    @Override
    public void registrarEspecifico() {
        System.out.println("Registro de clinico geral realizado.");
    }
}
