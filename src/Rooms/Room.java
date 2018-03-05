package Rooms;

import Entities.Enemy;
import Entities.Item;
import Tools.GameFileReader;
import javax.print.DocFlavor;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import Entities.Enemy;
import Entities.Enemies.Angry_Fly;

/**
 * Room class basis for all rooms.
 */
public abstract class Room {
    protected int dimensionX, dimensionY;
    public static int pieceSize=156;
    protected boolean doorTop,doorRight,doorBot,doorLeft;
    protected static int wallWidth=90;
    static int[] topDoorPos= new int[2];
    static int[] botDoorPos= new int[2];
    static int[] leftDoorPos= new int[2];
    static int[] rightDoorPos= new int[2];
    protected ArrayList<Enemy> enemyList;
    protected ArrayList<Item> itemList;
    protected Boolean roomClear;

    /**
     * Room Constructor
     * @param x Horizontal size of the room
     * @param y Vertical size of the room
     */
    public Room(int x, int y,boolean top,boolean right,boolean bot,boolean left){
        this.dimensionX=x;
        this.dimensionY=y;
        this.doorTop=top;this.doorRight=right;this.doorBot=bot;this.doorLeft=left;
        this.enemyList = new ArrayList<Enemy>();
        this.itemList = new ArrayList<Item>();
        this.roomClear=false;
    }

    /**
     * Room Constructor
     * @param x
     * @param y
     */
    public Room(int x, int y){
        this.dimensionX=x;
        this.dimensionY=y;
        this.enemyList = new ArrayList<Enemy>();
        this.itemList = new ArrayList<Item>();
        this.roomClear = false;
    }

    /**
     * Called in the GameEngine start method loads in all variables that are common through all rooms
     */
    public static void init(){
        topDoorPos[0]= BasementRoom.getRoomImages()[0].getWidth()-BasementRoom.getDoorImgTop().getWidth()/2;
        topDoorPos[1]=25;
        rightDoorPos[0]= BasementRoom.getRoomImages()[0].getWidth()*2-154;
        rightDoorPos[1]=BasementRoom.getRoomImages()[0].getHeight()-64;
        botDoorPos[0]= BasementRoom.getRoomImages()[0].getWidth()-BasementRoom.getDoorImgTop().getWidth()/2;
        botDoorPos[1]=BasementRoom.getRoomImages()[0].getHeight()*2-135;
        leftDoorPos[0]= 10;
        leftDoorPos[1]= BasementRoom.getRoomImages()[0].getHeight()-58;
    }

    /**
     * @return x
     */
    public int getDimensionX() {
        return this.dimensionX;
    }

    /**
     * @return y
     */
    public int getDimensionY() {
        return this.dimensionY;
    }


    public static int[] getBotDoorPos() {
        return botDoorPos;
    }

    public static int[] getLeftDoorPos() {
        return leftDoorPos;
    }

    public static int[] getRightDoorPos() {
        return rightDoorPos;
    }

    public static int[] getTopDoorPos() {
        return topDoorPos;
    }

    public boolean[] getDoors(){
        return new boolean[] {doorTop,doorRight,doorBot,doorLeft};
    }

    public static int getWallWidth() {
        return wallWidth;
    }
    public ArrayList<Enemy> getEnemyList() {
    	return this.enemyList;
    }
    public void checkRoomClear(){
        if (enemyList.size()==0){
            this.roomClear=true;
        }else {
            this.roomClear=false;
        }
    }
    public boolean isRoomClear(){
        return roomClear;
    }
    public ArrayList<Item> getItemList() {
        return this.itemList;
    }
}
