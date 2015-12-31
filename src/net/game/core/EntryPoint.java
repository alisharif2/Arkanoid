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

import net.game.states.*;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Ali Murtaza Sharif
 */
public class EntryPoint extends StateBasedGame {

    public EntryPoint() {
        super("ARKANOID");
    }

    public static void main(String[] args) {
        try {
            AppGameContainer game = new AppGameContainer(new EntryPoint());
            game.setDisplayMode(WindowProperty.WIDTH, WindowProperty.HEIGHT, false);
            game.start();
        } catch (SlickException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        gc.setTargetFrameRate(60);
        gc.setAlwaysRender(false);
        //gc.setVSync(true);
        gc.setShowFPS(false);
        gc.setMaximumLogicUpdateInterval(60);
        
        new Assets();
        
        this.addState(new MenuState());
        this.addState(new GameState());
        this.addState(new LoseState());
        this.addState(new WinState());
    }
}