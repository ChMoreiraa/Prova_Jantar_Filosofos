package tarefa3;

import java.util.concurrent.Semaphore;

public class Garfo {
    private final int id;
    private final Semaphore semaforo = new Semaphore(1);

    public Garfo(int id) {
        this.id = id;
    }

    public void pegar() throws InterruptedException {
        semaforo.acquire();
    }

    public void soltar() {
        semaforo.release();
    }

    public int getId() {
        return id;
    }
}
