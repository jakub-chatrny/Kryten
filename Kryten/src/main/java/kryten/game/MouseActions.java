package kryten.game;

public interface MouseActions {
	abstract void mouseLeftHoldAction(int x, int y);
	abstract void mouseLeftPressedAction(int x, int y);
	abstract void mouseLeftReleasedAction(int x, int y);
	
	abstract void mouseRightHoldAction(int x, int y);
	abstract void mouseRightPressedAction(int x, int y);
	abstract void mouseRightReleasedAction(int x, int y);
}
