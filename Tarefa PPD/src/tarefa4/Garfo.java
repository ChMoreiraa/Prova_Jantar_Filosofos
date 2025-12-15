package tarefa4;

public class Garfo {

    private final int id;
    private boolean ocupado = false;

    public Garfo(int id) {
        this.id = id;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void ocupar() {
        ocupado = true;
    }

    public void liberar() {
        ocupado = false;
    }

    public int getId() {
        return id;
    }
}
