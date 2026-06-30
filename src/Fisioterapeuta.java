public class Fisioterapeuta extends Profissional {

    public Fisioterapeuta(String nome) {
        super(nome, "fisioterapia");
    }

    public Fisioterapeuta(String nome,
                          String registro,
                          double valor) {

        super(nome, "fisioterapia", registro, valor);
    }

    @Override
    public void registrarEspecifico() {
        System.out.println("Registro de fisioterapeuta realizado.");
    }
}