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
package net.game.util;

/**
 *
 * @author Ali Murtaza Sharif
 */
public class Hitbox {
    public float x, y, width, height;
    
    public Hitbox() {    
    }
    
    public Hitbox(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public boolean checkCollision(Hitbox box) {
        return box.endX() >= x && box.endY() >= y && endX() >= box.x && endY() >= box.y;
    }
    
    public float endX() { return x + width; }
    public float endY() { return y + height; }
    public float halfWidth() { return width / 2; }
    public float halfHeight() { return height / 2; }
    public float getCenterX() { return x + halfWidth(); }
    public float getCenterY() { return y + halfHeight(); }
}
