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
import net.game.states.GameState;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Ali Murtaza Sharif
 */
public class Block extends Entity {
    
    private Entity ball;
    public static int BLOCK_SIZE = 32;

    public Block(int x, int y) {
        this.x = x;
        this.y = y;
        init();
    }
    
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        if(checkCollision(ball)) GameState.entities.remove(this);
    }

    @Override
    public void init() {
        width = BLOCK_SIZE;
        height = BLOCK_SIZE;
        name = "block";
        image = Assets.getImageFromSpriteSheet("blocks", 3, 0);
        
        for(Entity e : GameState.entities) {
            if(e.name.equals("ball")) ball = e;
        }
    }
    
}
