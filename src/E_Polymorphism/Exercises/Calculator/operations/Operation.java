package E_Polymorphism.Exercises.Calculator.operations;

public interface Operation {
    void addOperand(int operand);
    int getResult();
    boolean isCompleted();
}
