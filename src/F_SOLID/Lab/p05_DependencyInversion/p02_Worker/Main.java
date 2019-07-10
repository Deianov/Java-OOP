package F_SOLID.Lab.p05_DependencyInversion.p02_Worker;

public class Main {
    public static void main(String[] args) {

        Workable worker = new Worker();
        Workable worker6h = new Worker6h();
        Workable worker8h = new Worker8h();

        worker.work();
        worker6h.work();
        worker8h.work();
    }
}
