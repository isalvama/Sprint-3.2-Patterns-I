package first_level.command;

import java.util.Objects;

public class Command {
    private static int index = 1;
    private int commandNumber;
    private String commandBody;

    public static void setIndex(int index) {
        Command.index = index;
    }

    public int getCommandNumber() {
        return commandNumber;
    }

    public String getCommandBody() {
        return commandBody;
    }

    public Command (String commandBody) {
        this.commandNumber = index++;
        this.commandBody = Objects.requireNonNull(commandBody, "Body of the command can not be null");
    }
}
