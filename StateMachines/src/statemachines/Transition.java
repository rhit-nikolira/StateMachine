package statemachines;

public class Transition {
	public int state;
	public char nextChar;
	public int nextState;
	
	public Transition(int state, char nextChar, int nextState) {
		this.state = state;
		this.nextChar = nextChar;
		this.nextState = nextState;
	}	
}
