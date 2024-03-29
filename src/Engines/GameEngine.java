package Engines;

import Entities.*;
import Entities.Enemies.Angry_Fly;
import Entities.Enemies.Onetooth;
import Entities.Items.*;
import Entities.Players.Player_Isaac;
import Entities.Tears.Basic_Tear;
import Entities.Tears.Penetrating_Tear;
import Entities.Tears.Scythe_Tear;
import Misc.UI;
import Rooms.*;

public class GameEngine {
    private static Floor[] floorList;
    private static int floorNum;
    private static int[] currentCoord;
    /**
     * Called at the beginning of the program calls all init methods to load images and set variables
     */
    public static void start(){
        BasementRoom.init();
        BossRoom.init();
        ItemRoom.init();
        Room.init();
        Player_Isaac.init();
        Basic_Tear.init();
        Angry_Fly.init();
        Onetooth.init();
        UI.init();
        Magic_Mushroom.init();
        Full_Heart_Pickup.init();
        Scythe_Tear.init();
        Death_Touch.init();
        Cupid_Arrow.init();
        Penetrating_Tear.init();
        Double_Shot.init();
        init();
        

    }

    /**
     * GameEngines init method sets essential variables and build the level
     */
    public static void init(){
        currentCoord = new int[2];
        currentCoord[0]=15;currentCoord[1]=15;
        floorNum = 0;
        floorList = new Floor[1];
        for(int i = 0;i<floorList.length;i++){
            floorList[i]=new Floor(Math.round(7*((i+1))));
        }
    }

    /**
     * changes the current room based on direction given
     * @param direction - Takes "L","R","U" or "D" (Left, Right, Up and Down)
     * @return
     */
    public static boolean moveRoom(String direction) {
        if (direction.equals("U")) {
            if (floorList[floorNum].floorLayout[currentCoord[0]][currentCoord[1] - 1] != null) {
                currentCoord[1]--;

                return true;
            }
        } else if (direction.equals("R")) {
            if (floorList[floorNum].floorLayout[currentCoord[0] + 1][currentCoord[1]] != null) {
                currentCoord[0]++;
                return true;
            }
        } else if (direction.equals("D")) {
            if (floorList[floorNum].floorLayout[currentCoord[0]][currentCoord[1] + 1] != null) {
                currentCoord[1]++;
                return true;
            }
        } else if (direction.equals("L")) {
            if (floorList[floorNum].floorLayout[currentCoord[0] - 1][currentCoord[1]] != null) {
                currentCoord[0]--;
                return true;
            }
        }

        return false;
    }

    /**
     *  Checks if there is a room in a given direction
     * @param direction - Direction to check
     * @return - True if there is a room in direction given
     */
    public static Room getRoom(String direction) {
        if (direction.equals("U")) {
            if (floorList[floorNum].floorLayout[currentCoord[0]][currentCoord[1] - 1] != null) {
                return floorList[floorNum].floorLayout[currentCoord[0]][currentCoord[1] - 1];
            }
        } else if (direction.equals("R")) {
            if (floorList[floorNum].floorLayout[currentCoord[0] + 1][currentCoord[1]] != null) {
                return floorList[floorNum].floorLayout[currentCoord[0] + 1][currentCoord[1]];
            }
        } else if (direction.equals("D")) {
            if (floorList[floorNum].floorLayout[currentCoord[0]][currentCoord[1] + 1] != null) {
                return floorList[floorNum].floorLayout[currentCoord[0]][currentCoord[1] + 1];
            }
        } else if (direction.equals("L")) {
            if (floorList[floorNum].floorLayout[currentCoord[0] - 1][currentCoord[1]] != null) {
                return floorList[floorNum].floorLayout[currentCoord[0] - 1][currentCoord[1]];
            }
        }

        return null;
    }

    public static Boolean checkRoom(String direction) {
        if (direction.equals("U")) {
            if (floorList[floorNum].floorLayout[currentCoord[0]][currentCoord[1] - 1] != null) {
                return true;
            }
        } else if (direction.equals("R")) {
            if (floorList[floorNum].floorLayout[currentCoord[0] + 1][currentCoord[1]] != null) {
                return true;
            }
        } else if (direction.equals("D")) {
            if (floorList[floorNum].floorLayout[currentCoord[0]][currentCoord[1] + 1] != null) {
                return true;
            }
        } else if (direction.equals("L")) {
            if (floorList[floorNum].floorLayout[currentCoord[0] - 1][currentCoord[1]] != null) {
                return true;
            }
        }

        return false;
    }

    /**
     * Print the map in console like a mini map "S" is current location (Not for final game but for debugging)
     */
    public static void printFloor(){
        for (int y=0;y<30;y++){
            System.out.println();
            for (int x = 0; x<30; x++){
                if (x==currentCoord[0]&&y==currentCoord[1]){
                    System.out.print("S");
                }
                else if (getCurrentFloor().floorLayout[x][y]==null) {
                    System.out.print("O");
                }else if(floorList[0].floorLayout[x][y] instanceof ItemRoom) {
                    System.out.print("I");
                }else if(floorList[0].floorLayout[x][y] instanceof BossRoom){
                    System.out.print("B");
                }else{
                    System.out.print("X");
                }
                System.out.print(" ");
            }
        }
    }

    /**
     *
     * @return Room - returns the current room
     */
    public static Room getCurrentRoom(){
        return floorList[floorNum].floorLayout[currentCoord[0]][currentCoord[1]];
    }

    /**
     *
     * @return Floor - returns the current floor
     */
    public static Floor getCurrentFloor(){
        return floorList[floorNum];
    }

    public static int getFloorNum() {
        return floorNum;
    }
}

