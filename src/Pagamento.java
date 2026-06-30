public class Pagamento {
    private int indiceConsulta;
    private double valorFinal;
    private String tipoPagamento;
    private int parcelas;

    public Pagamento(int indiceConsulta, double valorFinal, String tipoPagamento) {
        this.indiceConsulta = indiceConsulta;
        this.valorFinal = valorFinal;
        this.tipoPagamento = tipoPagamento;
        this.parcelas = 1;
    }

    // com parcelas (so pra cartao)
    public Pagamento(int indiceConsulta, double valorFinal, String tipoPagamento, int parcelas) {
        this.indiceConsulta = indiceConsulta;
        this.valorFinal = valorFinal;
        this.tipoPagamento = tipoPagamento;
        this.parcelas = parcelas;
    }

    // Getters e Setters

    public int getIndiceConsulta() {
        return indiceConsulta;
    }

    // Validaçao: índice naã pode ser negativo
    public boolean setIndiceConsulta(int indiceConsulta) {
        if (indiceConsulta < 0) {
            System.out.println("Erro: indice de consulta invalido.");
            return false;
        }
        this.indiceConsulta = indiceConsulta;
        return true;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    // Validação: valor não pode ser negativo
    public boolean setValorFinal(double valorFinal) {
        if (valorFinal < 0) {
            System.out.println("Erro: valor final nao pode ser negativo.");
            return false;
        }
        this.valorFinal = valorFinal;
        return true;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    // Validação: tipo precisa ser um valor válido
    public boolean setTipoPagamento(String tipoPagamento) {
        if (tipoPagamento == null) {
            System.out.println("Erro: tipo de pagamento invalido.");
            return false;
        }

        boolean valido = tipoPagamento.equals("dinheiro") || tipoPagamento.equals("cartao")
                || tipoPagamento.equals("pix") || tipoPagamento.equals("convenio");

        if (!valido) {
            System.out.println("Erro: tipo de pagamento invalido. Use: dinheiro, cartao, pix ou convenio.");
            return false;
        }

        this.tipoPagamento = tipoPagamento;
        return true;
    }

    public int getParcelas() {
        return parcelas;
    }

    // validação: parcelas deve ser no minimo 1
    public boolean setParcelas(int parcelas) {
        if (parcelas < 1) {
            System.out.println("Erro: numero de parcelas invalido.");
            return false;
        }
        this.parcelas = parcelas;
        return true;
    }

    // Métodos de negócio
    
    // sem desconto nenhum
    public static double calcularValor(double valorBase) {
        return valorBase;
    }

    // com desconto em percentual
    public static double calcularValor(double valorBase, double percentualDesconto) {
        double desconto = valorBase * percentualDesconto / 100;
        double valor = valorBase - desconto;
        if (valor < 0) {
            valor = 0;
        }
        return valor;
    }

    // com desconto e multa somada
    public static double calcularValor(double valorBase, double percentualDesconto, double multa) {
        double desconto = valorBase * percentualDesconto / 100;
        double valor = valorBase - desconto + multa;
        if (valor < 0) {
            valor = 0;
        }
        return valor;
    }

    public String exibirResumo() {
        // arredonda pra 2 casas
        double valorArredondado = Math.round(valorFinal * 100.0) / 100.0;
        String resumo = "Consulta #" + indiceConsulta + " | Valor: R$" + valorArredondado
                + " | Tipo: " + tipoPagamento + " | Parcelas: " + parcelas;
        if (parcelas > 1) {
            double valorParcela = Math.round((valorFinal / parcelas) * 100.0) / 100.0;
            resumo = resumo + " (R$" + valorParcela + " cada)";
        }
        return resumo;
    }
}
