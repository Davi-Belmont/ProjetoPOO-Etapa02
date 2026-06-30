public class Psicologo extends Profissional {

    public Psicologo(String nome) {
        super(nome, "psicologia");
    }

    public Psicologo(String nome,
                     String registro,
                     double valor) {

        super(nome, "psicologia", registro, valor);
    }

    @Override
    public void registrarEspecifico() {
        System.out.println("Registro de psicologo realizado.");
    }
}