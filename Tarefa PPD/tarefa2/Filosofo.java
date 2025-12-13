package tarefa2;

import java.util.Random;

public class Filosofo extends Thread {

    private final int id;
    private final Garfo garfoEsquerdo;
    private final Garfo garfoDireito;
    private final Random random = new Random();
    private int refeicoes = 0;

    public Filosofo(int id, Garfo esquerdo, Garfo direito) {
        this.id = id;
        this.garfoEsquerdo = esquerdo;
        this.garfoDireito = direito;
    }

    private void pensar() throws InterruptedException {
        log("está pensando");
        Thread.sleep((random.nextInt(3) + 1) * 1000);
    }

    private void comer() throws InterruptedException {
        // Filósofo 4 pega os garfos em ordem invertida
        if (id == 4) {
            synchronized (garfoDireito) {
                log("pegou o garfo direito (" + garfoDireito.getId() + ")");
                synchronized (garfoEsquerdo) {
                    iniciarRefeicao();
                }
            }
        } else {
            synchronized (garfoEsquerdo) {
                log("pegou o garfo esquerdo (" + garfoEsquerdo.getId() + ")");
                synchronized (garfoDireito) {
                    iniciarRefeicao();
                }
            }
        }
    }

    private void iniciarRefeicao() throws InterruptedException {
        log("pegou os dois garfos e está comendo");
        refeicoes++;
        Thread.sleep((random.nextInt(3) + 1) * 1000);
        log("terminou de comer e soltou os garfos");
    }

    private void log(String mensagem) {
        System.out.println("Filósofo " + id + ": " + mensagem);
    }

    public int getRefeicoes() {
        return refeicoes;
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                comer();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
