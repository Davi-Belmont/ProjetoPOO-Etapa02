public class Paciente extends Pessoa implements Exportavel {

    private int idade;
    private String telefone;
    private String convenioNome;
    private boolean ativo;

    // construtor 1: nome e cpf
    public Paciente(String nome, String cpf) {
        super(nome); // chamando o construtor da superclasse Pessoa 
        this.setCpf(cpf);
        this.idade = 0;
        this.telefone = "";
        this.convenioNome = "";
        this.ativo = true;
    }

    // construtor 2: idade e telefone
    public Paciente(String nome, String cpf, int idade, String telefone) {
        super(nome); // Passa o nome para a classe base
        this.setCpf(cpf);
        this.idade = idade;
        this.telefone = telefone;
        this.convenioNome = "";
        this.ativo = true;
    }

    // construtor com todos os dados
    public Paciente(String nome, String cpf, int idade, String telefone, String convenioNome) {
        super(nome); // Passa o nome para a classe base
        this.setCpf(cpf);
        this.idade = idade;
        this.telefone = telefone;
        this.convenioNome = convenioNome;
        this.ativo = true;
    }

    // Getters e Setters

    public int getIdade() {
        return idade;
    }

    // Validação: idade não pode ser negativa nem maior que um limite razoável
    public boolean setIdade(int idade) {
        if (idade < 0 || idade > 130) {
            System.out.println("Erro: idade invalida.");
            return false;
        }
        this.idade = idade;
        return true;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone == null) {
            this.telefone = "";
        } else {
            this.telefone = telefone;
        }
    }

    public String getConvenioNome() {
        return convenioNome;
    }

    public void setConvenioNome(String convenioNome) {
        if (convenioNome == null) {
            this.convenioNome = "";
        } else {
            this.convenioNome = convenioNome;
        }
    }

    public boolean isAtivo() {
        return ativo;
    }

    // atualiza so idade e telefone
    public void complementar(int idade, String telefone) {
        this.idade = idade;
        this.telefone = telefone;
    }

    // atualiza tudo incluindo convenio
    public void complementar(int idade, String telefone, String convenioNome) {
        this.idade = idade;
        this.telefone = telefone;
        this.convenioNome = convenioNome;
    }

    public void desativar() {
        this.ativo = false;
    }

    // Método da interface exportavel

    @Override
    public String exportarDados() {
        return getNome() + ";" + getCpf() + ";" + idade + ";" + telefone
                + ";" + convenioNome + ";" + ativo;
    }

    // Sobscreve o metodo abstrato de Pessoa
    @Override
    public String exibirResumo() {
        String status = "Sim";
        if (!ativo) {
            status = "Nao";
        }
        // usando getNome para pegar o nome da classe mae
        return "Nome: " + getNome() + " | CPF: " + getCpf() + " | Idade: " + idade
                + " | Tel: " + telefone + " | Convenio: " + convenioNome
                + " | Ativo: " + status;
    }
}
