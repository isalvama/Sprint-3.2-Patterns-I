package first.level.undo;

import first_level.undo.Undo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.WithAssertions;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


class UndoTest implements WithAssertions{
    Undo undo = Undo.getUndo();

    @BeforeEach
    void setup(){
        undo.removeAllHistory();
    }

    @Test
    void getUndo_afterNewlyCreatedInstance_commandHistoryShows2NewObjects() {
        assertThat(undo.showHistory()).isEqualTo("");
    }

    @Test
    void showHistory_2NewObjectsAfterNewlyCreatingInstance_commandHistoryShows2NewObjects() {
        undo.addCommand("mkdir carpeta");
        undo.addCommand("cd fitxers");
        assertThat(Undo.getUndo().showHistory()).isEqualTo("1 mkdir carpeta\n2 cd fitxers");
    }

    @Test
    void undoCommand_afterNewlyCreatedInstance_throwsNoSuchElementExceptionWithExpectedMessage() {
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {undo.undoCommand();});
        assertEquals("The last element of the list can not be removed because the list is empty", exception.getMessage());
    }

    @Test
    void undoCommand_afterAddingObjects_commandHistoryShowsAllObjectsExceptLast() {
        undo.addCommand("mkdir carpeta");
        undo.addCommand("cd fitxers");
        undo.addCommand("touch fitxer.html");
        undo.addCommand("cd ../");
        undo.addCommand("mkdir images");
        undo.undoCommand();
        assertThat(Undo.getUndo().showHistory()).isEqualTo("1 mkdir carpeta\n2 cd fitxers\n3 touch fitxer.html\n4 cd ../");
    }

}