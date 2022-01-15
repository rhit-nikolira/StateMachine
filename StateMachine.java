import java.util.List;

/**
 * Added this interface so we are programming to the interface and not the implementation.
 */
public interface StateMachine {
	boolean accept(List<Character> streamOfChars);

}
