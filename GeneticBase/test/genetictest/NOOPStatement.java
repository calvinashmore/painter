package genetictest;

import genetic.Context;
import genetic.GeneticComponent;
import genetic.component.statement.function.StatementFunction;
import java.util.List;

public class NOOPStatement extends StatementFunction {

    @Override
    public void execute(Context context, List<GeneticComponent> inputs) {
        System.out.println("NOOP Statement");
    }
}
