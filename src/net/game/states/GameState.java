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
package net.game.states;

import java.util.ArrayList;
import net.game.core.WindowProperty;
import net.game.entities.Ball;
import net.game.entities.Block;
import static net.game.entities.Block.BLOCK_SIZE;
import net.game.entities.Entity;
import net.game.entities.Player;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Ali Murtaza Sharif
 */
public class GameState extends BasicGameState {

    public static ArrayList<Entity> entities;
    public int numberOfBlocks = 100;
    public static int score = 0;
    
    @Override
    public int getID() {
        return State.GAME;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        entities = new ArrayList<>();
        score = 0;
        
        entities.add(new Player());
        entities.add(new Ball());
        
        for(int i = 0;i < numberOfBlocks;i++) {
            entities.add(new Block((i * BLOCK_SIZE) % WindowProperty.WIDTH, (BLOCK_SIZE * 2) + BLOCK_SIZE * (int)((i * BLOCK_SIZE) / WindowProperty.WIDTH)));
        }
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        for(int i = 0;i < entities.size();i++) {
            entities.get(i).render(container, g);
        }
        g.drawString("Score: " + score, 0, 0);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        if(container.getInput().isKeyPressed(Input.KEY_ESCAPE)) game.enterState(State.MENU);
        
        for(int i = 0;i < entities.size();i++) {
            entities.get(i).update(container, game, delta);
        }
    }
}
