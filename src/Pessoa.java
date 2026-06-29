public abstract class Pessoa {

    protected String nome;
    protected String cpf;
    protected String telefone;
    protected String dataNascimento;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    // sorbecarga
    public Pessoa(String nome, String cpf,
                  String telefone,
                  String dataNascimento) {

        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    // metodo abstrato
    public abstract String exibirResumo();

    // getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {

        if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Nome invalido");
        }

        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {

        if (cpf == null || cpf.equals("")) {
            throw new IllegalArgumentException("CPF invalido");
        }

        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}