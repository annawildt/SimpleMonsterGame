package com.wildt;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) {
        Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();

//        for (int i = 0; i < 5; i++) {
//            terminal.moveCursor(5, i);
//            terminal.putCharacter('O');
//            terminal.moveCursor(i, 5);
//            terminal.putCharacter('X');
//        terminal.applyBackgroundColor(Terminal.Color.GREEN);
//        terminal.applyForegroundColor(Terminal.Color.BLUE);
    }
}
