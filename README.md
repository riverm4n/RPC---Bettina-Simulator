Trabalho Prático I de Sistemas Distribuídos

Implementação em Java do RPC (Remote Procedure Call)

1. Escreva um procedimento remoto que descubra o Segredo do Sucesso de Robertina. Robertina têm um
patrimônio de 1 milhão e 42 mil reais acumulado Q_f. Em seus investimentos, ela foi capaz de transformar o valor
inicial Q_0 de R$ 1.500,00 nesse montante. Levando em consideração uma aplicação financeira com valor inicial
Q_0 durante um período de t anos, a taxa de juros necessária i para que o investimento inicial alcance o valor
final Qf, é dada pela seguinte fórmula:

<img src="https://i.ibb.co/GdytTbD/Captura-de-tela-de-2019-04-08-22-15-35.png">

Escreva um procedimento remoto que tenha como entrada o valor

Escreva um procedimento remoto que tenha como entrada o valor do investimento Q0, patrimônio desejado Qf e
o tempo de investimento t (em meses) e calcule a taxa de juros mensal i.

ENTRADA DE EXEMPLO:
1500,00
1042000,00
36

SAÍDA DE EXEMPLO:
0.19933

Regras Importantes:
- Os exercícios devem ser desenvolvidos nas linguagens Java, C ou C++ e deverão rodar sobre os protocolos TCP
ou UDP
- O processo servidor deve obrigatoriamente rodar em um computador diferente dos processos clientes
- Cada equipe deverá ser composta por no máximo 3 integrantes
- Cada equipe tem no máximo 5 minutos para apresentar sua solução:
o +- 03 minutos para apresentar as aplicações. Incluindo descrição do código
o +- 02 minutos para mostrar funcionando
- Data de entrega: 09/04/2019 (no laboratório 1 do ICOMP)
- Critérios de avaliação:
o Entrega da documentação necessária: apresentação e código funcionando
o Sinergia do grupo no conhecimento da solução proposta
o Funcionalidades fornecidas pelas aplicações (interface e facilidade de manipulação)
- Dicas:
o Teste exaustivamente suas aplicações no laboratório em que ela será apresentada horas antes da
apresentação
o Cheque o tempo de sua apresentação. Lembre-se que o limite máximo de tempo é de 5 minutos
o Qualquer alteração as regras estipuladas deverá ser discutida com o professor da disciplina
