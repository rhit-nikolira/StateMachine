import java.util.LinkedList;
import java.util.List;

public class FindAbcAndPrintThings implements StateMachine {
	int state = 'A';
	static final int FINAL_STATE = 'f';
	private SideEffect ABCeffect;

	private List<Transition> transitions;

	public FindAbcAndPrintThings() { 
		this.ABCeffect = new WriteToFile();
		transitions = new LinkedList<Transition>();
		transitions.add(new Transition('A', 'A', 'b'));
		transitions.add(new Transition('A', '*', 'A'));
		transitions.add(new Transition('b', 'b', 'c'));
		transitions.add(new Transition('b', 'A', 'b'));
		transitions.add(new Transition('b', '*', 'A'));
		transitions.add(new Transition('c', 'c', FINAL_STATE));
		transitions.add(new Transition('c', 'A', 'b'));
		transitions.add(new Transition('c', '*', 'A'));
		transitions.add(new Transition(FINAL_STATE, '*', FINAL_STATE));
	}
	
	@Override
	public synchronized boolean accept(List<Character> streamOfChars) {
		state = 'A';
		return findAbcAndPrintThings(streamOfChars);
	}
	
	public boolean findAbcAndPrintThings(List<Character> streamOfChars) {
		// Should be in the final state by the end of the stream.
		if (streamOfChars.isEmpty()) {
			return state == FINAL_STATE;
		}

		char next = streamOfChars.remove(0);

		// State transitions
		for(Transition transition: transitions) {
			if(transition.state == state && (transition.nextChar == next || transition.nextChar == '*')) {
				this.ABCeffect.doSideEffect(next, state, FINAL_STATE);
				//runAppropriateSideEffect(next);				
				state = transition.nextState;
				return findAbcAndPrintThings(streamOfChars);
			}
		}
		return false;
	}
}
