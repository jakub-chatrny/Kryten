package kryten.engine;

import kryten.game.GameTemplate;

import org.lwjgl.opengl.Display;

import static org.lwjgl.opengl.GL11.*;

import java.awt.Dimension;
import java.awt.Toolkit;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

/**
 * Main class, initialize GL and game and is running game loop. In order to run
 * engine it's need to be initialized openGL init(width,height), then
 * initGame(game) and run() the engine
 * 
 * @author Jakub Chatrný
 */
public class Engine {
	private static final int vSyncFPS = 60;
	private static boolean vSyncFlag = true;

	/** Game reference */
	private static GameTemplate game;

	/**
	 * Initialize the display and openGL.
	 * 
	 * @param args
	 */
	public static void init(final int windowWidth,final int windowHeight) {
		DisplayConfig.initDisplay(windowWidth, windowHeight, vSyncFlag);
		DisplayConfig.initGL(windowWidth, windowHeight);
		FPSCounter.initFPSCounter();
		//printScreenSize();
	}
	/**
	 * Initialize the display and openGL.
	 * 
	 */
	public static void init() {
		DisplayConfig.initDisplay(vSyncFlag);
		DisplayConfig.initGL();
		FPSCounter.initFPSCounter();
		//printScreenSize();
	}

	/**
	 * Jump to game loop which periodically handle user input, update objects
	 * and render on screen. When game loop finish, clean up openGL "objects".
	 * 
	 * @param args
	 */
	public static void run() {
		if (Engine.game != null) {
			gameLoop();
			DisplayConfig.cleanUp();
		} else {
			System.err.println("Need intialize game first.");
			System.exit(1);
		}
	}

	/**
	 * Game loop which periodically handle user input, update objects and render
	 * on screen.
	 */
	private static void gameLoop() {
		while (!Display.isCloseRequested()) {

			// get user input
			getInput();
			// do update of objects
			update();
			// render on display
			render();
			// Update game actual FPS
			FPSCounter.updateFPS();

		}
	}

	/**
	 * Creates game object.
	 * 
	 * @return 0 on success, 1 on failure
	 */
	public static void initGame(GameTemplate game) {
		if (null != game) {
			Engine.game = game;
		} else {
			System.err.println("Game was not initialized.");
			System.exit(1);
		}
	}

	/**
	 * Call for handling user input
	 */
	public static void getInput() {
		game.getInput();
	}

	/**
	 * Call for updating objects
	 */
	public static void update() {
		game.update(FPSCounter.getFPS());
		//on window resize
		//do re init openGL with new display size
		if (Display.wasResized()) {
			DisplayConfig.initGL(Display.getWidth(),Display.getHeight());
		}
	}

	/**
	 * Call for rendering objects
	 */
	public static void render() {
		// clear the scenery
		glClear(GL_COLOR_BUFFER_BIT);
		// replaces the current matrix with the identity matrix
		glLoadIdentity();

		// write down to buffer matrixes
		game.render();

		// write down matrixes to display
		Display.update();
		// synchronize frame rate
		Display.sync(vSyncFPS);
	}
	
	public static void close(){
		Display.destroy();
		Keyboard.destroy();
		Mouse.destroy();
	}
	
	public static int getDisplayWidth(){
		return Display.getWidth();
	}
	
	public static int getDisplayHeight(){
		return Display.getHeight();
	}
	
	protected static void printScreenSize(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		System.out.println("width:"+width+"\n height:"+height);
	}

}