package first_level.undo;

import first_level.command.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public final class Undo {
    private static Undo undoInstance;
    private List<Command> commandHistory;

    private Undo () {
        this.commandHistory = new ArrayList<>();
    }

    public static Undo getUndo(){
        if (undoInstance == null) {
            undoInstance = new Undo();
        }
        return undoInstance;
    }

    public String showHistory() {
        List<Command> historyList = List.copyOf(this.commandHistory);
        return historyList.stream()
                .map(c -> c.getCommandNumber() + " " + c.getCommandBody())
                .collect(Collectors.joining("\n"));
    }

    public void addCommand(String commandBody){
        Command command = new Command(commandBody);
        this.commandHistory.add(command);
    }

    public void undoCommand (){
        if (this.commandHistory.isEmpty()) {
            throw new NoSuchElementException("The last element of the list can not be removed because the list is empty");
        }
        this.commandHistory.removeLast();
    }

    public void removeAllHistory() {
        this.commandHistory.clear();
        Command.setIndex(1);
    }
}
