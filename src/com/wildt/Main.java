package com.wildt;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

import java.awt.*;
import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();

        Player player = new Player();
        Point playerPos = player.getPosition();

        Monster[] monsters = new Monster[100];
        for (int i = 0; i < 4; i++) {
            monsters[i] = new Monster(playerPos);
        }

        boolean gameOver = false;

        while (!gameOver) {
            Key key;
            do {
                Thread.sleep(5);
                key = terminal.readInput();
            }
            while (key == null);
            switch (key.getKind()) {
                case ArrowDown:
                    player.move(0, player.getSpeed());
                    break;
                case ArrowUp:
                    player.move(0, player.getSpeed() * -1);
                    break;
                case ArrowLeft:
                    player.move(player.getSpeed() * -1, 0);
                    break;
                case ArrowRight:
                    player.move(player.getSpeed(), 0);
                    break;
            }
            // Get new Player current position
            playerPos = player.getPosition();

            // Move monster array
            for (int i = 0; i < monsters.length; i++) {
                if (monsters[i] == null) {
                    break;
                }
                monsters[i].moveMonster(playerPos);


                if (monsters[i].collision(playerPos)) {
                    gameOver = true;
                    break;
                }
            }

            if (gameOver) {
                
            }
        }

    }
}
