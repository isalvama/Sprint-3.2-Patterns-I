package first_level.command;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

class CommandTest implements WithAssertions {

    @Test
    void constructor_beforeCreatingInstance_indexIncrements() {
        assertThat(Command.getIndex()).isEqualTo(1);
    }

    @Test
    void constructor_whenCreatingTwoInstances_indexAndCommandNumberIncrements() {
        Command command1 = new Command("git checkout -b feat/command");
        assertThat(Command.getIndex()).isEqualTo(2);
        Command command2 = new Command("git add Command.java");
        assertThat(Command.getIndex()).isEqualTo(3);
        assertThat(command1.getCommandNumber()).isEqualTo(1);
        assertThat(command2.getCommandNumber()).isEqualTo(2);
    }
}