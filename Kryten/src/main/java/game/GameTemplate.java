package game;

/**
 * Contains methods which need to be implemented to run a game.
 * @author Jakub Chatrný
 *
 */
public abstract class GameTemplate {
	public abstract void getInput();
	public abstract void render();
	public abstract void update(int FPS);
}