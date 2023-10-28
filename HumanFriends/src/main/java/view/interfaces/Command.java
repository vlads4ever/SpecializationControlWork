package view.interfaces;

import java.io.IOException;

public interface Command {
    String getDescription();
    void execute();
}
