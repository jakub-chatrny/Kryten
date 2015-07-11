package kryten.engine;

import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;

public class FPSCounter {
	private static long lastFrame;
	/** frames per second */
	private static int fps;
	/** last FPS time */
	private static long lastFPS;
	public static void initFPSCounter(){
		getDelta(); // call once before loop to initialise lastFrame
		lastFPS = getTime(); // call before loop to initialise fps timer
	}
	
	/**
	 * Calculate how many milliseconds have passed since last frame.
	 *
	 * @return milliseconds passed since last frame
	 */
	private static int getDelta() {
		long time = getTime();
		int delta = (int) (time - lastFrame);
		lastFrame = time;

		return delta;
	}

	/**
	 * Get the accurate system time
	 *
	 * @return The system time in milliseconds
	 */
	private static long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}

	/**
	 * Calculate the FPS and set it in the title bar
	 */
	public static void updateFPS() {
		if (getTime() - lastFPS > 1000) {
			Display.setTitle("FPS: " + fps);
			fps = 0;
			lastFPS += 1000;
		}
		fps++;
	}

	/**
	 * 
	 * @return Actual FPS
	 */
	public static int getFPS() {
		return fps;
	}
}