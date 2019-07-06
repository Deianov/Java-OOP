package E_Polymorphism.Exercises.Calculator;

import E_Polymorphism.Exercises.Calculator.operations.DivisionOperation;
import E_Polymorphism.Exercises.Calculator.operations.MultiplicationOperation;
import E_Polymorphism.Exercises.Calculator.operations.Operation;

public class InputInterpreter {
    private CalculationEngine engine;

    public InputInterpreter(CalculationEngine engine){
        this.engine = engine;
    }

    public boolean interpret(String input) {
        try {
            engine.pushNumber(Integer.parseInt(input));
        }catch (Exception ex){
            engine.pushOperation(this.getOperation(input));
        }
        return true;
    }

    public Operation getOperation(String operation) {
        if (operation.equals("*")) {
            return new MultiplicationOperation();
        }
        if (operation.equals("/")) {
            return new DivisionOperation();
        }
        if (operation.equals("ms")) {
            engine.memorySave();
        }
        if (operation.equals("mr")) {
            Integer currentSave = engine.memoryRecall();

            if (currentSave != null) {
                engine.pushNumber(currentSave);
            }
        }

        return null;
    }
}
