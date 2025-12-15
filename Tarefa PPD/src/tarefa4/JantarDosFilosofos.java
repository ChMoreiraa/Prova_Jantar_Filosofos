package tarefa4;

public class JantarDosFilosofos {

    public static void main(String[] args) throws InterruptedException {

        Garfo[] garfos = new Garfo[5];
        for (int i = 0; i < 5; i++) {
            garfos[i] = new Garfo(i);
        }

        Mesa mesa = new Mesa(garfos);

        Filosofo[] filosofos = new Filosofo[5];
        for (int i = 0; i < 5; i++) {
            filosofos[i] = new Filosofo(i, mesa);
            filosofos[i].start();
        }

        Thread.sleep(120000);

        System.out.println("\n--- Estatísticas de Execução ---");
        for (Filosofo f : filosofos) {
            System.out.println("Filósofo " + f.getName() +
                    " comeu " + f.getRefeicoes() + " vezes.");
        }

        System.exit(0);
    }
}
