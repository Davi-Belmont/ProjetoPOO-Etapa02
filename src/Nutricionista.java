public class Nutricionista extends Profissional {

    public Nutricionista(String nome) {
        super(nome, "nutricao");
    }

    public Nutricionista(String nome,
                         String registro,
                         double valor) {

        super(nome, "nutricao", registro, valor);
    }

    @Override
    public void registrarEspecifico() {
        System.out.println("Registro de nutricionista realizado.");
    }
}
