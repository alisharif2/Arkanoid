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
package net.game.entities;

import net.game.util.Hitbox;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Ali Murtaza Sharif
 */
public abstract class Entity extends Hitbox {
    
    public Image image;
    public String name;
    
    public Entity() {
        init();
    }
    
    public void render(GameContainer container, Graphics g) {
        if(image != null) image.draw(x, y, width, height);
    }
    public abstract void update(GameContainer container, StateBasedGame game, int delta);
    public abstract void init();
}
