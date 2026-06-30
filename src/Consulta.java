public class Consulta {
    private String cpfPaciente;
    private String nomeProfissional;
    private String data;
    private String horario;
    private String tipo;
    private String status;

    // sem tipo - assume inicial
    public Consulta(String cpfPaciente, String nomeProfissional, String data, String horario) {
        this.cpfPaciente = cpfPaciente;
        this.nomeProfissional = nomeProfissional;
        this.data = data;
        this.horario = horario;
        this.tipo = "inicial";
        this.status = "agendada";
    }

    public Consulta(String cpfPaciente, String nomeProfissional, String data, String horario, String tipo) {
        this.cpfPaciente = cpfPaciente;
        this.nomeProfissional = nomeProfissional;
        this.data = data;
        this.horario = horario;
        this.tipo = tipo;
        this.status = "agendada";
    }

    // esse aqui a gente usa na remarcacao pra poder setar o status direto
    public Consulta(String cpfPaciente, String nomeProfissional, String data,
                    String horario, String tipo, String status) {
        this.cpfPaciente = cpfPaciente;
        this.nomeProfissional = nomeProfissional;
        this.data = data;
        this.horario = horario;
        this.tipo = tipo;
        this.status = status;
    }
    //Getters e Setters
    
    public String getCpfPaciente() {
        return cpfPaciente;
    }
    // Validação: cpf deve ter 11 digitos (sem pontuação)
    public boolean setCpfPaciente(String cpfPaciente) {
        if (cpfPaciente == null || cpfPaciente.length() != 11) {
            System.out.println("Erro: CPF invalido. Deve conter 11 digitos.");
            return false;
        }
        this.cpfPaciente = cpfPaciente;
        return true;
    }
    public String getNomeProfissional() {
        return nomeProfissional;
    }
    public boolean setNomeProfissional(String nomeProfissional) {
        if (nomeProfissional == null || nomeProfissional.trim().isEmpty()) {
            System.out.println("Erro: Nome do profissional não pode ser vazio.");
            return false;
        }
        this.nomeProfissional = nomeProfissional;
        return true;
    }

    public String getData() {
        return data;
    }
    public String getHorario() {
        return horario;
    }

    public boolean setHorario(String horario) {
        if (horario == null || horario.trim().isEmpty()) {
            System.out.println("Erro: Horário não pode ser vazio.");
            return false;
        }
        this.horario = horario;
        return true;
    }
    public String getStatus() {
        return status;
    }

    // Metódos de negócio

    public void cancelar() {
        this.status = "cancelada";
    }

    // cancelar com motivo - retorna a msg formatada
    public String cancelar(String motivo) {
        this.status = "cancelada";
        return "Consulta cancelada. Motivo: " + motivo;
    }

    public void remarcar() {
        this.status = "remarcada";
    }

    public void realizar() {
        this.status = "realizada";
    }

    public String exibirResumo() {
        return "Paciente(CPF): " + cpfPaciente + " | Prof: " + nomeProfissional
                + " | Data: " + data + " | Hora: " + horario
                + " | Tipo: " + tipo + " | Status: " + status;
    }
}
