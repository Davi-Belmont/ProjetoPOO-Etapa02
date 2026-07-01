public class Consulta implements Agendavel, Exportavel{
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

    public boolean setStatus(String status) {
        if (status == null) {
            System.out.println("Erro: status nao pode ser nulo.");
            return false;
        }

        boolean valido = status.equals("agendada") || status.equals("cancelada")
                || status.equals("remarcada") || status.equals("realizada");

        if (!valido) {
            System.out.println("Erro: status invalido. Use: agendada, cancelada, remarcada ou realizada.");
            return false;
        }

        this.status = status;
        return true;
    }
    
    public String getTipo() {
        return tipo;
    }

    // Métodos da interface agendavel

    @Override
    public void agendar() {
        this.setStatus("agendada");
    }

    @Override
    public void cancelar() {
        this.setStatus("cancelada");
    }

    @Override
    public void remarcar() {
        this.setStatus("remarcada");
    }

    // cancelar com motivo - sobrecarga, nao faz parte do contrato da interface
    public String cancelar(String motivo) {
        this.setStatus("cancelada");
        return "Consulta cancelada. Motivo: " + motivo;
    }

    // Métodos da interface exportavel

    @Override
    public String exportarDados() {
        return cpfPaciente + ";" + nomeProfissional + ";" + data + ";"
                + horario + ";" + tipo + ";" + status;
    }

    // Metódos de negócio

    public void realizar() {
        this.status = "realizada";
    }

    public String exibirResumo() {
        return "Paciente(CPF): " + cpfPaciente + " | Prof: " + nomeProfissional
                + " | Data: " + data + " | Hora: " + horario
                + " | Tipo: " + tipo + " | Status: " + status;
    }
}
