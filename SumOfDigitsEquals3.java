import java.util.LinkedList;
import java.util.List;

/*
 *
 * Deterministic finite state machine to sum up a list of numbers and see if it
 * equals 3. Notice there is no + operator in this code - state machines do not
 * do arithmetic. Finite state machines have very simple instruction sets that
 * take in the next character and decide (based on the current state) the next
 * state to enter.
 *
 */
public class SumOfDigitsEquals3 implements StateMachine {
	int state = 0;
	static final int FINAL_STATE = 3;

	private SideEffect sum3Effect = new SideEffect() {
		@Override
		public <T> void doSideEffect(T currItem, T state, T finalState) {
			return;
		}
	};

	private List<Transition> transitions;
	public SumOfDigitsEquals3() {
		transitions = new LinkedList<Transition>();
		transitions.add(new Transition(0, '0', 0));
		transitions.add(new Transition(0, '1', 1));
		transitions.add(new Transition(0, '2', 2));
		transitions.add(new Transition(0, '3', 3));
		transitions.add(new Transition(1, '0', 1));
		transitions.add(new Transition(1, '1', 2));
		transitions.add(new Transition(1, '2', 3));
		transitions.add(new Transition(2, '0', 2));
		transitions.add(new Transition(2, '1', 3));
		transitions.add(new Transition(3, '0', 3));
	}

	@Override
	public boolean accept(List<Character> streamOfChars) {
		state = 0;
		return sumOfDigitsEquals3(streamOfChars);
		// return sumOfDigitsEquals3(0, streamOfChars);
	}

	public boolean sumOfDigitsEquals3(List<Character> streamOfChars) {
		// Should have a sum of 3 by the end of the stream.
		if (streamOfChars.isEmpty())
			return state == FINAL_STATE;

		char next = streamOfChars.remove(0);

		for(Transition transition: transitions) {
			if(transition.state == state && transition.nextChar == next) {
				this.sum3Effect.doSideEffect(next, state, FINAL_STATE);
				state = transition.nextState;
				return sumOfDigitsEquals3(streamOfChars);
			}
		}
		return false;
	}
	// public boolean sumOfDigitsEquals3(int sum, List<Character> streamOfChars) {
	// 	// Should have a sum of 3 by the end of the stream.
	// 	if (streamOfChars.isEmpty()) {
	// 		return sum == FINAL_STATE;
	// 	}

	// 	char next = streamOfChars.remove(0);

	// 	for(Transition transition: transitions) {
	// 		if(transition.state == sum && transition.nextChar == next) {
	// 			// FIXME: this code is subtly different from the other state machine.
	// 			// TODO: Unify the codebase. Use good design.
	// 			return sumOfDigitsEquals3(transition.nextState, streamOfChars);
	// 		}
	// 	}

	// 	return false;
	// }
}
