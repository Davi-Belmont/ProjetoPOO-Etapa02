import java.util.ArrayList;
import java.util.List;

public abstract class Profissional extends Pessoa {
    
    private String especialidade;
    private String registroProfissional;
    private double valorConsulta;
    private List<String> diasDisponiveis;
    private List<HorarioDisponivel> horarios;

    // so nome e especialidade
    public Profissional(String nome, String especialidade) {
        super(nome);
        this.setEspecialidade (especialidade);
        this.registroProfissional = "";
        this.valorConsulta = 0;
        this.diasDisponiveis = new ArrayList<>();
        this.horarios = new ArrayList<>();
    }

    public Profissional(String nome, String especialidade, String registroProfissional, double valorConsulta) {
        super(nome);
        this.especialidade = especialidade;
        this.registroProfissional = registroProfissional;
        this.valorConsulta = valorConsulta;
        this.diasDisponiveis = new ArrayList<>();
        this.horarios = new ArrayList<>();
    }

    // construtor completo com dias
    public Profissional(String nome, String especialidade, String registroProfissional,
                        double valorConsulta, String[] dias, int totalDias) {
        super(nome);
        this.especialidade = especialidade;
        this.registroProfissional = registroProfissional;
        this.valorConsulta = valorConsulta;
        this.diasDisponiveis = new ArrayList<>();
        for (int i = 0; i < totalDias; i++) {
            this.diasDisponiveis.add(dias[i]);
        }
        this.horarios = new ArrayList<>();
    }

    public void atualizar(String registro, double valor) {
        this.setRegistroProfissional (registro);
        this.setValorConsulta (valor);
    }

    public void atualizar(String registro, double valor, String[] dias, int totalDias) {
        this.registroProfissional = registro;
        this.valorConsulta = valor;
        this.diasDisponiveis.clear();
        for (int i = 0; i < totalDias; i++) {
            this.diasDisponiveis.add(dias[i]);
        }
    }

    // verifica se o profissional atende naquele dia
   public boolean atendeNoDia(String dia) {

    for (String diaDisponivel : diasDisponiveis) {

        if (diaDisponivel.equalsIgnoreCase(dia)) {
            return true;
        }
    }

        return false;
    }

    // agregacao
    public void adicionarHorario(HorarioDisponivel horario) {
        horarios.add(horario);
    }

    public List<HorarioDisponivel> getHorarios() {
        return horarios;
    }



    // valida as especialidades aceitas pela clinica
    public static boolean especialidadeValida(String esp) {
        if (esp.equals("clinica geral")) return true;
        if (esp.equals("fisioterapia")) return true;
        if (esp.equals("psicologia")) return true;
        if (esp.equals("nutricao")) return true;
        return false;
    }

    // getters

    public String getEspecialidade() {
        return especialidade;
    }

    public String getRegistroProfissional() {
        return registroProfissional;
    }

    public double getValorConsulta() {
        return valorConsulta;
    }

    public List<String> getDiasDisponiveis() {
        return diasDisponiveis;
    }

    // setters

    public void setEspecialidade(String especialidade) {

        if (especialidade == null || especialidade.equals("")) {
            throw new IllegalArgumentException("Especialidade invalida");
        }

        this.especialidade = especialidade;
    }

    public void setRegistroProfissional(String registroProfissional) {

        if (registroProfissional == null || registroProfissional.equals("")) {
            throw new IllegalArgumentException("Registro invalido");
        }

        this.registroProfissional = registroProfissional;
    }

    public void setValorConsulta(double valorConsulta) {

        if (valorConsulta < 0) {
            throw new IllegalArgumentException("Valor invalido");
        }

        this.valorConsulta = valorConsulta;
    }

    public void setDiasDisponiveis(List<String> diasDisponiveis) {
        this.diasDisponiveis = diasDisponiveis;
    }

    public abstract void registrarEspecifico();

    // Sobreescrevendo o metodo abstrado de pessoa
    @Override
    public String exibirResumo() {
        String dias = "";
        for (int i = 0; i < diasDisponiveis.size(); i++) {
            if (i > 0) dias = dias + ", ";
            dias = dias + diasDisponiveis.get(i);
        }
        return "Nome: " + getNome() + " | Espec: " + getEspecialidade() + " | Reg: " + getRegistroProfissional()
                + " | Valor: R$" + getValorConsulta() + " | Dias: " + dias;
    }
}
