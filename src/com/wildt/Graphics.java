package com.wildt;

import com.googlecode.lanterna.terminal.Terminal;

import java.awt.*;

public class Graphics {
    public static final int WIDTH = 100;
    public static final int HEIGHT = 30;

    public static void createGameMap (Terminal terminal){
        int[] borderV = new int[]{0,WIDTH};
        int[] borderH = new int[]{0,HEIGHT};
        terminal.applyBackgroundColor(150,150,150);
        for(int v:borderV){
            for (int i = 0; i < HEIGHT; i++) {
                terminal.moveCursor(v,i);
                terminal.putCharacter(' ');
            }
        }
        for(int h:borderH){
            for (int i = 0; i < WIDTH; i++) {
                terminal.moveCursor(i,h);
                terminal.putCharacter(' ');
            }
        }

    }
    public static void updateGameMap(Player player, Monster[] monsters, Terminal terminal){
        drawUnit(player.getPosition(),'P',terminal);
        for (int i = 0; i < monsters.length; i++) {
            if(monsters[i]==null){
                break;
            }
            drawUnit(monsters[i].getPosition(),'M',terminal);
        }
    }
    public static void drawUnit(Point point, char c, Terminal terminal){
        terminal.moveCursor(point.x,point.y);
        terminal.applyBackgroundColor(0,0,0);
        terminal.putCharacter(c);
    }
    public static void printText(int x, int y, String message, Terminal
            terminal) {
        for (int i=0;i<message.length();i++)
        {
            terminal.moveCursor(x, y);
            terminal.putCharacter(message.charAt(i));
            x=x+1;
        }
    }
}
