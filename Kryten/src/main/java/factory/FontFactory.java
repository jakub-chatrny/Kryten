package factory;

import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.TrueTypeFont;

/**
 * Mediates fonts to game. If font doesn't exist, convert it from java.awt font
 * and save for further usage.
 * 
 * @author Jakub Chatrný
 *
 */
public class FontFactory {
	public static Map<String, TTFont> fonts = new HashMap<String, TTFont>();
	public static int capacity;
	public static boolean DEBUG_RESOURCE = false;

	/**
	 * Create empty factory
	 */
	public FontFactory() {
		fonts = new HashMap<String, TTFont>();
	}

	/**
	 * Get needed font, if font doesn't exist convert him and save.
	 * 
	 * @param name
	 * @param style
	 * @param size
	 * @return
	 */
	public static TrueTypeFont getFont(final String name, final int style, final int size) {

		TrueTypeFont ttf;
		TTFont font;

		font = fonts.get(name);
		if (null == font) { // font not found
			if(DEBUG_RESOURCE)
				System.out.println("New TrueTypeFont created " + (++capacity));
			ttf = convertFontFromAwt(name, Font.PLAIN, size);
			// save
			font = new TTFont();
			font.put(size, ttf);
			fonts.put(name, font);

			return ttf;
		} else {
			ttf = font.get(size);
			if (null == ttf) {
				if(DEBUG_RESOURCE)
					System.out.println("New TrueTypeFont created " + (++capacity));
				ttf = convertFontFromAwt(name, Font.PLAIN, size);
				font.put(size, ttf);
			}
			return ttf;
		}
	}

	/**
	 * Convert font from java.atw to TrueTypeFont
	 * 
	 * @param name
	 * @param style
	 * @param size
	 * @return
	 */
	private static TrueTypeFont convertFontFromAwt(final String name, final int style, final int size) {
		Font awtFont = new Font(name, style, size);
		return new TrueTypeFont(awtFont, true);
	}
	
	/**
	 * @return the dEBUG_RESOURCE
	 */
	public static boolean isDebug() {
		return DEBUG_RESOURCE;
	}

	/**
	 * @param DEBUG_RESOURCE the DEBUG_RESOURCE to set
	 */
	public static void setDebug(boolean flag) {
		DEBUG_RESOURCE = flag;
	}
	
	/**
	 * Changes state of debug
	 * @return
	 */
	public static boolean changeDebug(){
		return DEBUG_RESOURCE = !DEBUG_RESOURCE;
	}
}