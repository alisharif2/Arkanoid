/*
 * Copyright (C) 2015 Ali Murtaza Sharif
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.game.core;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SpriteSheet;

/**
 *
 * @author Ali Murtaza Sharif
 */
public class Assets {
    
    private static Map<String, Image> images;
    private static Map<String, SpriteSheet> sprites;
    private static Map<String, Sound> sounds;
    
    public Assets() {
        images = new HashMap<>();
        sprites = new HashMap<>();
        sounds = new HashMap<>();
        
        try {
            images.put("player", loadImage("assets/breakoutBoard.png"));
            images.put("ball", loadImage("assets/ball.png"));
            sprites.put("blocks", loadSpriteSheet("assets/blocks.png", 32, 32));
        } catch (SlickException ex) {
            Logger.getLogger(Assets.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Image loadImage(String path) throws SlickException {
        return new Image(path, false, Image.FILTER_NEAREST);
    }
    
    private Sound loadSound(String path) throws SlickException {
        return new Sound(path);
    }
    
    private SpriteSheet loadSpriteSheet(String path, int width, int height) throws SlickException {
        return new SpriteSheet(loadImage(path), width, height);
    }
    
    public static Image getImage(String name) {
        return images.get(name);
    }
    
    public static SpriteSheet getSpriteSheet(String name) {
        return sprites.get(name);
    }
    
    public static Sound getSound(String name) {
        return sounds.get(name);
    }
    
    public static Image getImageFromSpriteSheet(String name, int x, int y) {
        return sprites.get(name).getSubImage(x, y);
    }
}
