package kryten.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

/**
 * Mediates sprites to game. If font doesn't exist, try load it from resources and save for further usage.
 * @author jchatrny
 *
 */
public class TextureFactory {
	public static Map<String, Texture> textures = new HashMap<String, Texture>();
	public static String RES_PATH = "res/";
	private static boolean DEBUG_RESOURCE = false;
	/**
	 * Initialize factory
	 */
	public TextureFactory() {
		textures = new HashMap<String, Texture>();
	}

	/**
	 * Returns sprite
	 * @param name
	 * @return
	 */
	public static Texture get(String name) {

		Texture sprite;

		sprite = textures.get(name);

		if (null == sprite) {
			sprite = loadTexture(name);
			textures.put(name, sprite);
			if(DEBUG_RESOURCE)
				System.out.println("New sprite named \""+name+"\" has been loaded.");
		}

		return sprite;
	}

	/**
	 * Loads PNG texture from resource path. 128x128
	 * 
	 * @param key
	 *            name of file
	 * @return
	 */
	private static Texture loadTexture(String key) {
		try {
			return TextureLoader.getTexture("png", new FileInputStream(
					new File(RES_PATH + key + ".png")));
		} catch (IOException e) {
			System.err.println("Loading sprite file:\""+RES_PATH + key + ".png"+"\" failed.");
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Changes resource directory
	 * @param path
	 */
	public static void changeResourceDir(String path){
		TextureFactory.RES_PATH = path;
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