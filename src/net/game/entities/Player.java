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

import net.game.core.Assets;
import net.game.core.WindowProperty;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Ali Murtaza Sharif
 */
public class Player extends Entity {

    private final float speed = 0.8f;
    
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        if(container.getInput().isKeyDown(Input.KEY_LEFT)) x -= speed * delta;
        if(container.getInput().isKeyDown(Input.KEY_RIGHT)) x += speed * delta;
        
        if(x < 0) x += speed * delta;
        if(endX() > WindowProperty.WIDTH) x -= speed * delta;
    }

    @Override
    public void init() {
        width = 128;
        height = 24;
        x = (WindowProperty.WIDTH / 2) - halfWidth();
        y = WindowProperty.HEIGHT - height;
        image = Assets.getImage("player");
        name = "player";
    }
    
}
