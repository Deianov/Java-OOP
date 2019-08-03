package I_Workshop.BoatRacingSimulator.io;

import I_Workshop.BoatRacingSimulator.io.interfaces.OutputWriter;

public class OutputManager implements OutputWriter {
    @Override
    public void writeLine(String output){
        System.out.println(output);
    }
}
