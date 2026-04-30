package first_level.command;

public class Command {
    private static int index = 1;
    private int commandNumber;
    private String commandBody;

    public Command (String commandBody) {
        if (commandBody == null) throw new IllegalArgumentException("The body of the command can not be null");
        this.commandNumber = index++;
        this.commandBody = commandBody;
    }

    public static void setIndex(int index) {
        Command.index = index;
    }

    public static int getIndex() {
        return index;
    }

    public int getCommandNumber() {
        return commandNumber;
    }

    public String getCommandBody() {
        return commandBody;
    }
}
