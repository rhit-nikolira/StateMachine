public interface SideEffect {
	public <T> void doSideEffect(T currItem, T state, T finalState);
}
