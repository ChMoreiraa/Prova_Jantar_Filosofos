
package tarefa4;

public class Mesa {

    private final Garfo[] garfos;

    public Mesa(Garfo[] garfos) {
        this.garfos = garfos;
    }

    public synchronized void pegarGarfos(int id) throws InterruptedException {
        Garfo esquerdo = garfos[id];
        Garfo direito = garfos[(id + 1) % garfos.length];

        while (esquerdo.isOcupado() || direito.isOcupado()) {
            wait();
        }

        esquerdo.ocupar();
        direito.ocupar();
    }

    public synchronized void soltarGarfos(int id) {
        Garfo esquerdo = garfos[id];
        Garfo direito = garfos[(id + 1) % garfos.length];

        esquerdo.liberar();
        direito.liberar();
        notifyAll();
    }
}
