public class Atendimento implements Exportavel {
    private int indiceConsulta;
    private String observacoes;
    private String diagnostico;
    private String[] procedimentos;
    private int totalProcedimentos;

    // registro basico - so observacoes
    public Atendimento(int indiceConsulta, String observacoes) {
        this.indiceConsulta = indiceConsulta;
        this.observacoes = observacoes;
        this.diagnostico = "";
        this.procedimentos = new String[10];
        this.totalProcedimentos = 0;
    }

    public Atendimento(int indiceConsulta, String observacoes, String diagnostico) {
        this.indiceConsulta = indiceConsulta;
        this.observacoes = observacoes;
        this.diagnostico = diagnostico;
        this.procedimentos = new String[10];
        this.totalProcedimentos = 0;
    }

    // registro completo com procedimentos ja definidos
    public Atendimento(int indiceConsulta, String observacoes, String diagnostico,
                       String[] procedimentos, int totalProcedimentos) {
        this.indiceConsulta = indiceConsulta;
        this.observacoes = observacoes;
        this.diagnostico = diagnostico;
        this.procedimentos = new String[10];
        this.totalProcedimentos = totalProcedimentos;
        for (int i = 0; i < totalProcedimentos; i++) {
            this.procedimentos[i] = procedimentos[i];
        }
    }

    // Getters e Setters

    public int getIndiceConsulta() {
        return indiceConsulta;
    }
    // Validação: índice não pode ser negativo
    public boolean setIndiceConsulta(int indiceConsulta) {
        if(indiceConsulta <0) {
            System.out.println("Erro: Índice de consulta não pode ser negativo.");
            return false;
        }
        this.indiceConsulta = indiceConsulta;
        return true;
    }

    public String getObservacoes() {
        return observacoes;
    }
    // Validação: observações não podem ser nulas
    public boolean setObservaçoes(String observaçoes) {
        if (observacoes == null) {
            System.out.println("Erro: Observações não podem ser nulas.");
            return false;
        }
        this.observacoes = observaçoes;
        return true;
    }
    public String getDiagnostico() {
        return diagnostico;
    }
    public void setDiagnostico(String diagnostico) {
        if (diagnostico == null) {
            this.diagnostico = "";
        } else {
            this.diagnostico = diagnostico;
        }
    }
    public String[] getProcedimentos() {
        String[] copia = new String[totalProcedimentos];
        for (int i = 0; i < totalProcedimentos; i++) {
            copia[i] = procedimentos[i];
        }
        return copia;
    }

    // Métodos de negócio

    // adiciona um por vez
    public void adicionarProcedimento(String procedimento) {
        if (totalProcedimentos < 10) {
            procedimentos[totalProcedimentos] = procedimento;
            totalProcedimentos++;
        }
    }

    // adiciona varios de uma vez
    public void adicionarProcedimento(String[] procs, int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            if (totalProcedimentos < 10) {
                procedimentos[totalProcedimentos] = procs[i];
                totalProcedimentos++;
            }
        }
    }

    // Método da interface exportavel

    @Override
    public String exportarDados() {
        String procs = "";
        for (int i = 0; i < totalProcedimentos; i++) {
            procs = procs + procedimentos[i];
            if (i < totalProcedimentos - 1) {
                procs = procs + ",";
            }
        }
        return indiceConsulta + ";" + observacoes + ";" + diagnostico + ";" + procs;
    }

    public String exibirResumo() {
        String resumo = "Observacoes: " + observacoes;

        if (!diagnostico.equals("")) {
            resumo = resumo + "\nDiagnostico: " + diagnostico;
        }

        if (totalProcedimentos > 0) {
            resumo = resumo + "\nProcedimentos: ";
            for (int i = 0; i < totalProcedimentos; i++) {
                resumo = resumo + procedimentos[i];
                if (i < totalProcedimentos - 1) {
                    resumo = resumo + ", ";
                }
            }
        }
        return resumo;
    }
}
