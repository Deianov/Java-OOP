package F_SOLID.Lab.p05_DependencyInversion.p02_Worker;

public class Worker implements Workable {

    @Override
    public void work(){
        System.out.println("work");
    }
}
