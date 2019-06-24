package D_InterfacesAndAbstraction.Lab.SayHello;

public interface Person {
    String getName();

    default String sayHello() { return "Hello"; }
}
