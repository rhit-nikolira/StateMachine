

public class Transition {
	public int state;
	public char nextChar;
	public int nextState;
	public SideEffect s;
    public Object nextInput;

	
	public Transition(int state, char nextChar, int nextState) {
		this.state = state;
		this.nextChar = nextChar;
		this.nextState = nextState;
	}
}
