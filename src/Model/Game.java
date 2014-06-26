package Model;

import Controller.Controller;
import View.View;

import java.io.IOException;

public class Game {

    private static boolean status = false;

    public static boolean isEnd(){
        return status;
    }

    public static void setStatus(boolean status) {
        Game.status = status;
    }
}
