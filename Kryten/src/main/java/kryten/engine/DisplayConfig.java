package kryten.engine;

import static org.lwjgl.opengl.GL11.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

/**
 * Take care of all operation with display.
 * 
 * @author Jakub Chatrný
 *
 */
public class DisplayConfig {
	public static DisplayMode displaymode;
	private static final boolean RESIZABLE_WINDOW = true;
	public static int WINDOW_WIDTH = 800; 
	public static int WINDOW_HEIGHT = 600; 

	/**
	 * Initialize new display
	 * 
	 * @param width
	 * @param vSync
	 */
	public static void initDisplay(final int width, final int height, final boolean vSync) {
		WINDOW_WIDTH = width;
		WINDOW_HEIGHT = height;
		displaymode = new DisplayMode(width, height);
		initDisplay(displaymode, vSync);
	}
	
	/**
	 * Initialize new display
	 * 
	 * @param displaymode
	 * @param vSync
	 */
	protected static void initDisplay(final DisplayMode displaymode, final boolean vSync) {
		try {
			WINDOW_WIDTH = displaymode.getWidth();
			WINDOW_HEIGHT = displaymode.getHeight();
			Display.setDisplayMode(displaymode);
			Display.create();
			Display.setVSyncEnabled(vSync);
			Display.setResizable(RESIZABLE_WINDOW);
			// input
			Keyboard.create();
			Mouse.create();

		} catch (LWJGLException ex) {
			Logger.getLogger(Engine.class.getName())
					.log(Level.SEVERE, null, ex);
		}
	}
	
	/**
	 * Initialize new display with largest possible display mode 
	 * 
	 * @param displaymode
	 * @param vSync
	 */
	public static void initDisplay(final boolean vSync) {
		try {
			final DisplayMode[] dms = Display.getAvailableDisplayModes();
			for(int i = 0; i < dms.length; i++){
				if(dms[i].isFullscreenCapable()){
					initDisplay(dms[i],vSync);
					//System.out.println(dms[i].getWidth()+" "+dms[i].getHeight());
					break;
				}
			}
			
		} catch (LWJGLException ex) {
			Logger.getLogger(Engine.class.getName())
			.log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Initialize openGL stuff.
	 * 
	 * @param width
	 * @param height
	 */
	public static void initGL(final int width, final int height) {
		glEnable(GL_TEXTURE_2D);
		glShadeModel(GL_SMOOTH);
		glDisable(GL_DEPTH_TEST);
		glDisable(GL_LIGHTING);

		glClearColor(0.2f, 0.2f, 0.2f, 0.0f);
		glClearDepth(1);

		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);

		glViewport(0, 0, width, height);
		glMatrixMode(GL_MODELVIEW);

		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, width, height, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
	}
	
	/**
	 * Initialize openGL stuff.
	 * 
	 */
	public static void initGL() {
		glEnable(GL_TEXTURE_2D);
		glShadeModel(GL_SMOOTH);
		glDisable(GL_DEPTH_TEST);
		glDisable(GL_LIGHTING);

		glClearColor(0.2f, 0.2f, 0.2f, 0.0f);
		glClearDepth(1);

		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);

		glViewport(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		glMatrixMode(GL_MODELVIEW);

		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, WINDOW_WIDTH, WINDOW_HEIGHT, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
	}

	/**
	 * Set the display mode to be used
	 *
	 * @param width
	 *            The width of the display required
	 * @param height
	 *            The height of the display required
	 * @param fullscreen
	 *            True if we want fullscreen mode
	 */
	public static void setDisplayMode(int width, int height, boolean fullscreen) {

		// return if requested DisplayMode is already set
		if ((Display.getDisplayMode().getWidth() == width)
				&& (Display.getDisplayMode().getHeight() == height)
				&& (Display.isFullscreen() == fullscreen)) {
			return;
		}

		try {
			DisplayMode targetDisplayMode = null;

			if (fullscreen) {
				DisplayMode[] modes = Display.getAvailableDisplayModes();
				int freq = 0;

				for (int i = 0; i < modes.length; i++) {
					DisplayMode current = modes[i];

					if ((current.getWidth() == width)
							&& (current.getHeight() == height)) {
						if ((targetDisplayMode == null)
								|| (current.getFrequency() >= freq)) {
							if ((targetDisplayMode == null)
									|| (current.getBitsPerPixel() > targetDisplayMode
											.getBitsPerPixel())) {
								targetDisplayMode = current;
								freq = targetDisplayMode.getFrequency();
							}
						}

						// if we've found a match for bpp and frequence against
						// the
						// original display mode then it's probably best to go
						// for this one
						// since it's most likely compatible with the monitor
						if ((current.getBitsPerPixel() == Display
								.getDesktopDisplayMode().getBitsPerPixel())
								&& (current.getFrequency() == Display
										.getDesktopDisplayMode().getFrequency())) {
							targetDisplayMode = current;
							break;
						}
					}
				}
			} else {
				targetDisplayMode = new DisplayMode(width, height);
			}

			if (targetDisplayMode == null) {
				System.out.println("Failed to find value mode: " + width + "x"
						+ height + " fs=" + fullscreen);
				return;
			}

			Display.setDisplayMode(targetDisplayMode);
			Display.setFullscreen(fullscreen);
			initGL(width, height);

		} catch (LWJGLException e) {
			System.out.println("Unable to setup mode " + width + "x" + height
					+ " fullscreen=" + fullscreen + e);
		}
	}

	/**
	 * Clean up all lwjgl stuff.
	 */
	public static void cleanUp() {
		Display.destroy();
		Keyboard.destroy();
		Mouse.destroy();
	}

}