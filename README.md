# Prova_Jantar_Filosofos

Este repositório contém as 5 tarefas solicitadas na prova final de Programação Paralela e Distribuída

# Tarefa 1 – Jantar dos Filósofos (Deadlock)
## Descrição

Nesta tarefa foi implementada uma versão básica do problema do Jantar dos Filósofos utilizando Java e threads, com o objetivo de demonstrar a ocorrência de deadlock. O sistema é composto por cinco filósofos e cinco garfos, onde cada filósofo é uma thread que alterna entre os estados de pensar e comer.
Todos os filósofos seguem a mesma ordem de aquisição dos recursos, pegando primeiro o garfo esquerdo e depois o garfo direito. Essa abordagem foi escolhida propositalmente, pois cria um cenário propício à ocorrência de deadlock.

## Implementação

Os garfos são tratados como recursos compartilhados e protegidos por blocos synchronized, garantindo exclusão mútua. Cada filósofo simula tempos aleatórios de pensamento e alimentação entre um e três segundos. Para facilitar a observação do deadlock durante a execução, foi utilizada uma barreira de sincronização simples, garantindo que todos os filósofos obtenham o garfo esquerdo antes de tentar pegar o garfo direito, evidenciando a espera circular.
Um sistema de logging via console registra os principais eventos da execução, permitindo acompanhar o comportamento concorrente das threads.

## Ocorrência de Deadlock

Durante a execução do programa por pelo menos 30 segundos, foi possível observar o deadlock. Em determinado momento, todos os filósofos ficaram bloqueados ao tentar pegar o segundo garfo, fazendo com que a execução permanecesse travada e sem novos registros no log.
Essa implementação atende às condições clássicas de deadlock: exclusão mútua, posse e espera, ausência de preempção e espera circular.
Como Compilar e Executar

## Pré-requisitos

Java JDK instalado (versão 8 ou superior)

## Compilação

No diretório raiz do projeto, execute:


1° cd src


2° javac tarefa1\*.java


3° cd ..

## Execução

Ainda no diretório raiz, execute:
java -cp src tarefa1.JantarDosFilosofos

O programa será executado por pelo menos 30 segundos. O deadlock pode ser identificado quando os logs param de ser exibidos no terminal.

## Evidências
Print da execução foi capturado diretamente do terminal, demonstrando o momento em que todos os filósofos tentam obter o segundo garfo e ficam bloqueados, caracterizando o deadlock.

<img width="795" height="456" alt="image" src="https://github.com/user-attachments/assets/d344bc80-a8ec-4c9a-b52b-adb45681b50b" />


# Tarefa 2 – Solução com Prevenção de Deadlock

## Descrição

Nesta tarefa foi implementada uma modificação na solução do Jantar dos Filósofos com o objetivo de prevenir o deadlock. A estrutura geral do sistema foi mantida, utilizando cinco filósofos e cinco garfos, com cada filósofo representado por uma thread.
A principal diferença em relação à Tarefa 1 está na ordem de aquisição dos recursos.

## Prevenção de Deadlock

Enquanto quatro filósofos pegam primeiro o garfo esquerdo e depois o direito, o filósofo de ID 4 faz o contrário, pegando primeiro o garfo direito e depois o esquerdo. Essa alteração quebra a condição de espera circular, impedindo que todos os filósofos fiquem bloqueados simultaneamente.
Com isso, o sistema continua progredindo e nenhum deadlock foi observado durante a execução.

## Starvation

Apesar de o deadlock ser evitado, ainda existe a possibilidade de starvation, pois não há um mecanismo que garanta justiça na distribuição dos recursos. Um filósofo pode acabar comendo menos vezes dependendo do escalonamento das threads.

## Comparação com a Tarefa 1

Na Tarefa 1, todos os filósofos seguiam a mesma ordem de aquisição dos garfos, o que possibilitava a ocorrência de deadlock. Nesta tarefa, ter feito a inversão da ordem para um único filósofo foi suficiente para que eu conseguisse eliminar esse problema, mantendo a implementação simples e eficiente.

## Estatísticas de Execução

Durante a execução do programa por pelo menos dois minutos, foi contabilizado o número de vezes que cada filósofo conseguiu comer. Os resultados demonstram que o sistema permanece ativo durante todo o período, sem bloqueios totais.

## Como Compilar e Executar

Compilação


1° cd src


2° javac tarefa2\*.java


3° cd ..


Execução


java -cp src tarefa2.JantarDosFilosofos

Print da execução foi capturado diretamente do terminal


![tarefa2 img1](https://github.com/user-attachments/assets/ad053be6-1581-4508-b01f-657f0313714c)
![tarefa2 img2](https://github.com/user-attachments/assets/18d030a2-b9d9-4f1f-a2ba-72ad9e60a4bd)


