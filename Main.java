

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// Programming to the interface, not the implementation!
		StateMachine[] stateMachines = new StateMachine[] { new SumOfDigitsEquals3(), new FindAbcAndPrintThings() };
		
		Main main = new Main();
		main.runStateMachines(stateMachines);
	}
	
	public void runStateMachines(StateMachine[] stateMachines) {
		for (StateMachine stateMachine : stateMachines) {
			List<Character> digitsTestCase = new LinkedList<Character>();
			digitsTestCase.addAll(Arrays.asList(new Character[] { '0', '1', '2', '0' }));

			List<Character> lettersTestCase = new LinkedList<Character>();
			lettersTestCase.addAll(Arrays.asList(new Character[] { 'A', 'b', 'd', 'A', 'b', 'c', 'd' }));

			testMachine(stateMachine, lettersTestCase);
			System.out.println();
			testMachine(stateMachine, digitsTestCase);
			
			System.out.println();
		}
	}
	
	private static void testMachine(StateMachine stateMachine, List<Character> testCase) {
		boolean result;
		System.out.println("Running " + stateMachine.getClass().getSimpleName()+" on " + testCase);


		result = stateMachine.accept(testCase);
		System.out.println("Result: " + result);
	}
}
