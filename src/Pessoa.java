public abstract class Pessoa {
    protected String nome;

    // Criando o construtor principal
    public Pessoa(String nome){
        this.nome = nome;
    }

    // metodo abstrato 
    public abstract void exibirResumo();

    // Getters e Setters
    public String getNome(){
        return nome;
    }
    // Protege o estado do objeto contra nomes vazios ou nulos
    public void setNome(String nome) {
        if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Nome inválido! O nome não pode ser vazio ou nulo.");
        }
        this.nome = nome;
    }
}