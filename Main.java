package optimize;

abstract class Relatorio {
    protected String categoria;
    protected double valorTotal;

    public Relatorio(String categoria, double valorTotal) {
        this.categoria = categoria;
        this.valorTotal = valorTotal;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public abstract void gerarRelatorio();
}

// Classe para Relatório de Gastos
class RelatorioGastos extends Relatorio {

    public RelatorioGastos(String categoria, double valorTotal) {
        super(categoria, valorTotal);
    }

    @Override
    public void gerarRelatorio() {
        System.out.println("Relatório de Gastos - Categoria: " + categoria + " - Valor: " + valorTotal);
    }
}

// Classe para Relatório de Lucro
class RelatorioLucro extends Relatorio {
    private int numeroVendas;

    public RelatorioLucro(String categoria, double valorTotal, int numeroVendas) {
        super(categoria, valorTotal);
        this.numeroVendas = numeroVendas;
    }

    public int getNumeroVendas() {
        return numeroVendas;
    }

    @Override
    public void gerarRelatorio() {
        System.out.println("Relatório de Lucro - Categoria: " + categoria + " - Lucro Total: " + valorTotal +
                " - Número de Vendas: " + numeroVendas);
    }
}

// Singleton para gerar relatórios
class GeradorDeRelatorioSingleton {
    private static GeradorDeRelatorioSingleton instancia;

    private GeradorDeRelatorioSingleton() {}

    public static GeradorDeRelatorioSingleton getInstancia() {
        if (instancia == null) {
            instancia = new GeradorDeRelatorioSingleton();
        }
        return instancia;
    }

    public void gerarRelatorio(Relatorio relatorio) {
        relatorio.gerarRelatorio();
    }
}

// Interface Abstract Factory para criação de relatórios
interface RelatorioFactory {
    Relatorio criarRelatorio(String categoria, double valorTotal);
}

// Factory para Relatório de Gastos
class RelatorioGastosFactory implements RelatorioFactory {
    @Override
    public Relatorio criarRelatorio(String categoria, double valorTotal) {
        return new RelatorioGastos(categoria, valorTotal);
    }
}

// Factory para Relatório de Lucro
class RelatorioLucroFactory implements RelatorioFactory {
    public Relatorio criarRelatorio(String categoria, double valorTotal, int numeroVendas) {
        return new RelatorioLucro(categoria, valorTotal, numeroVendas);
    }

    @Override
    public Relatorio criarRelatorio(String categoria, double valorTotal) {
        throw new UnsupportedOperationException("Número de vendas é necessário para o Relatório de Lucro.");
    }
}

// Facade para simplificar a geração dos relatórios
class RelatorioFacade {
    private GeradorDeRelatorioSingleton gerador;

    public RelatorioFacade() {
        this.gerador = GeradorDeRelatorioSingleton.getInstancia();
    }

    public void gerarRelatorioGastos(String categoria, double valorTotal) {
        Relatorio relatorio = new RelatorioGastosFactory().criarRelatorio(categoria, valorTotal);
        gerador.gerarRelatorio(relatorio);
    }

    public void gerarRelatorioLucro(String categoria, double valorTotal, int numeroVendas) {
        Relatorio relatorio = new RelatorioLucroFactory().criarRelatorio(categoria, valorTotal, numeroVendas);
        gerador.gerarRelatorio(relatorio);
    }
}

// Classe Main para testes
public class Main {
    public static void main(String[] args) {
        RelatorioFacade facade = new RelatorioFacade();

        facade.gerarRelatorioGastos("Desenvolvimento", 5000);
        facade.gerarRelatorioGastos("Testes", 2000);
        facade.gerarRelatorioLucro("Lucro", 15000, 300);

        System.out.println("Relatórios gerados com sucesso.");
    }
}
