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
        int playerLife = player.getLife();
        Point playerPos = player.getPosition();

        Monster[] monsters = new Monster[100];
        for (int i = 0; i < 4; i++) {
            monsters[i] = new Monster(playerPos);
        }

        boolean gameOver = false;
        int moveCounter = 0;

        Graphics.createGameMap(terminal);
        Graphics.updateGameMap(player,monsters,terminal);
        Graphics.printText(5,32,"Game Start",terminal);
        Graphics.printText(80,32,"Player life: " + playerLife,terminal);

        while (!gameOver) {
            System.out.println(player.getPosition());
            Key key;
            do {
                Thread.sleep(5);
                key = terminal.readInput();
            }
            while (key == null);
            // Count key strokes
            moveCounter++;

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
            // Next empty monster slot
            int emptyMonster = 0;

            // Move monster array
            for (int i = 0; i < monsters.length; i++) {
                if (monsters[i] == null) {
                    emptyMonster = i;
                    break;
                }
                monsters[i].moveMonster(playerPos);
                if (monsters[i].collision(playerPos)) {
                    if (playerLife > 0) {
                        player.setLife(playerLife-1);
                    } else if (playerLife == 0) {
                        gameOver = true;
                    }
                    break;
                }
            }

            if(moveCounter%5 == 0){
                if(emptyMonster < monsters.length) {
                    monsters[emptyMonster] = new Monster(playerPos);
                }
            }
            // Render and update board
            terminal.clearScreen();
            Graphics.createGameMap(terminal);
            Graphics.updateGameMap(player,monsters,terminal);
            Graphics.printText(80,32,"Player life: " + playerLife,terminal);
        }

        if(gameOver){
            Graphics.printText(45,15,"GAME OVER",terminal);
        }

    }
}
