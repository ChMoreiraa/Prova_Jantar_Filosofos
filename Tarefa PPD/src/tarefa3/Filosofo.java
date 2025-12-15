package tarefa3;

import java.util.Random;

public class Filosofo extends Thread {

    private final int id;
    private final Garfo esquerdo;
    private final Garfo direito;
    private final Random random = new Random();
    private int refeicoes = 0;

    public Filosofo(int id, Garfo esquerdo, Garfo direito) {
        this.id = id;
        this.esquerdo = esquerdo;
        this.direito = direito;
    }

    private void pensar() throws InterruptedException {
        log("está pensando");
        Thread.sleep((random.nextInt(3) + 1) * 1000);
    }

    private void comer() throws InterruptedException {
        esquerdo.pegar();
        log("pegou o garfo esquerdo (" + esquerdo.getId() + ")");

        direito.pegar();
        log("pegou o garfo direito (" + direito.getId() + ")");

        log("está comendo");
        refeicoes++;
        Thread.sleep((random.nextInt(3) + 1) * 1000);

        esquerdo.soltar();
        direito.soltar();
        log("soltou os garfos");
    }

    private void log(String msg) {
        System.out.println("Filósofo " + id + ": " + msg);
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
