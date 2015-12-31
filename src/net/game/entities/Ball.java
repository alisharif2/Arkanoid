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

import java.util.Random;
import net.game.core.Assets;
import net.game.core.WindowProperty;
import net.game.states.GameState;
import net.game.states.State;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;


public class Ball extends Entity {
    
    private float speed = 0.4f;
    private final float SPEED_MAX = 2.0f;
    private int dirX = 1;
    private int dirY = -1;
    
    private Entity player;

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        x += speed * delta * dirX;
        y += speed * delta * dirY;
        
        if(x < 0) dirX = 1;
        if(y < 0) dirY = 1;
        if(endX() > WindowProperty.WIDTH) dirX = -1;
        if(endY() > WindowProperty.HEIGHT) game.enterState(State.LOSE);
        
        if(checkCollision(player)) dirY = -1;
        
        for(Entity e : GameState.entities) {
            if(checkCollision(e) && e.name.equals("block")) {
                dirY = 1;
                GameState.score++;
                if(speed < SPEED_MAX) speed += 0.01f;
            }
        }
    }

    @Override
    public void init() {
        width = 24;
        height = 24;
        x = (new Random()).nextInt(WindowProperty.WIDTH);
        y = WindowProperty.HEIGHT / 2 - halfWidth();
        image = Assets.getImage("ball");
        name = "ball";
        
        for(Entity e : GameState.entities) {
            if(e.name.equals("player")) player = e;
        }
    }
    
}
