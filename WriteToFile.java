import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class WriteToFile implements SideEffect{

    @Override
    public <T> void doSideEffect(T currItem, T state, T finalState) {
        try(PrintStream out = new PrintStream(new FileOutputStream("log.txt", true))){
            if (state.equals('A')) {
                if (currItem.equals('A')) {
                    out.println("Found the " + currItem);
                } else {
                    // This else branch handles the * edge in the diagram.                        out.println("Did not find the A. Still looking for A...");
                }
            } else if (state.equals('b')) {
                if (currItem.equals('b')) {
                    out.println("Found the " + currItem);
                } else if (currItem.equals('A')) {
                    out.println("Saw another A, going to b");
                } else {
                    out.println("Did not find the b. Restarting the search...");
                }
            } else if (state.equals('c')) {
                if (currItem.equals('c')) {
                    out.println("Found the " + currItem);
                } else if (currItem.equals('A')) {
                    out.println("Saw another A, going to b");
                } else {
                out.println("Did not find the c. Restarting the search...");
                }
            } else if (state.equals(finalState)) {
                out.println("In the final state, saw a meaningless " + currItem);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
