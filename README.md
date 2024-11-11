# PI_POO_Ciclo2

Este código implementa um sistema de geração de relatórios usando conceitos de Programação Orientada a Objetos (POO) e padrões de design. Ele inclui uma estrutura modular que separa as responsabilidades e utiliza encapsulamento, herança, polimorfismo, e abstração, além dos padrões Singleton, Factory Method, Abstract Factory, e Facade.

Principais Componentes
1. Classe Relatorio (Abstração Base): Define uma classe base abstrata para relatórios, com atributos comuns (categoria e valorTotal) e um método abstrato gerarRelatorio().

2. Classes Concretas (RelatorioGastos e RelatorioLucro): Cada classe estende Relatorio para representar tipos específicos de relatórios:
RelatorioGastos: Representa um relatório de gastos.
RelatorioLucro: Representa um relatório de lucro, incluindo o número de vendas.

3. Singleton (GeradorDeRelatorioSingleton): Garante uma instância única para gerenciar a geração dos relatórios, centralizando a lógica para exibir o conteúdo dos relatórios.

4. Abstract Factory e Factory Method: Utiliza o padrão Abstract Factory com a interface RelatorioFactory e suas implementações (RelatorioGastosFactory e RelatorioLucroFactory) para criar instâncias de relatórios de forma flexível e desacoplada.

5. Facade (RelatorioFacade): Simplifica o uso do sistema de geração de relatórios ao encapsular a criação e configuração de relatórios, facilitando o processo no código principal.

Classe Main
No Main, o RelatorioFacade é usado para gerar relatórios de maneira simplificada, sem expor as complexidades de criação, com exemplos de geração de relatórios de gastos e lucros.

Essas estruturas tornam o código organizado e fácil de expandir para novos tipos de relatórios.
