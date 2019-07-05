package E_Polymorphism.Exercises.Word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandImpl implements CommandInterface {

    class ToUpperTransform implements TextTransform {
        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex){
            if (startIndex < 0 || endIndex <= startIndex) {
                return;
            }
            for (int i = startIndex; i < endIndex && i < text.length() ; i++) {
                text.setCharAt(i, Character.toUpperCase(text.charAt(i)));
            }
        }
    }

    class commandCut implements TextTransform {
        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
            if (startIndex < 0 || endIndex <= startIndex) {
                clipboard = "";
                return;
            }
            String newClipboard = text.substring(startIndex, Math.min(endIndex, text.length()));
            text.delete(startIndex, endIndex);
            clipboard = newClipboard;
        }
    }

    class commandPaste implements TextTransform {
        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
            if (endIndex > startIndex) {
                text.delete(startIndex, endIndex);
            }
            text.insert(startIndex, clipboard);
        }
    }

    private Map<String, TextTransform> commandTransforms;
    private StringBuilder text;
    protected String clipboard;

    public CommandImpl(StringBuilder text) {
        this.commandTransforms = new HashMap<>();
        this.text = text;
    }

    @Override
    public void init() {
        this.commandTransforms.clear();
        for (Command p : this.initCommands()) {
            this.commandTransforms.putIfAbsent(p.getText(), p.getTextTransform());
        }
        this.clipboard = "";
    }

    @Override
    public void handleInput(String input) {
        String[] tokens = input.split("\\s+");

        String commandName = tokens[0];
        int startInd = Integer.parseInt(tokens[1]);
        int endInd = Integer.parseInt(tokens[2]);

        this.commandTransforms.get(commandName).invokeOn(this.text, startInd, endInd);
    }

    protected List<Command> initCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new Command("uppercase", new ToUpperTransform()));
        commands.add(new Command("cut", new commandCut()));
        commands.add(new Command("paste", new commandPaste()));

        return commands;
    }
}
