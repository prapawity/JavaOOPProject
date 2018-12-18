package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.Pixmap;

public class MouseChange {
    private Pixmap pm,pm1,pm2,pm3,pm4,pm5,pm6,pm7,pm32,pm72;
    private Cursor cursor,cursor1,cursor2,cursor3,cursor4,cursor5,cursor6,cursor7,cursor32,cursor72;
    public void create(){
        pm = new Pixmap(Gdx.files.internal("GenerateMap/mouse.png"));
        cursor = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("GenerateMap/mouse.png")),0,0);
        pm1 = new Pixmap(Gdx.files.internal("GenerateMap/mouse.png"));
        cursor1 = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("GenerateMap/mouse.png")),0,0);

        pm2 = new Pixmap(Gdx.files.internal("GenerateMap/hand.png"));
        cursor2 = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("GenerateMap/hand.png")), 0, 0);


        pm3 = new Pixmap(Gdx.files.internal("GenerateMap/shovel.png"));
        cursor3 = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("GenerateMap/shovel.png")), 0, 0);
        pm32 = new Pixmap(Gdx.files.internal("GenerateMap/shovelDown.png"));
        cursor32 = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("GenerateMap/shovelDown.png")), 0, 0);


        pm4 = new Pixmap(Gdx.files.internal("GenerateMap/picaxe.png"));
        cursor4 = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("GenerateMap/picaxe.png")), 0, 0);


        pm5 = new Pixmap(Gdx.files.internal("GenerateMap/axe.png"));
        cursor5 = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("GenerateMap/axe.png")), 0, 0);


        pm6 = new Pixmap(Gdx.files.internal("GenerateMap/watering.png"));
        cursor6 = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("GenerateMap/watering.png")), 0, 0);


        pm7 = new Pixmap(Gdx.files.internal("GenerateMap/mouseweedbag1.png"));
        cursor7 = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("GenerateMap/mouseweedbag1.png")), 0, 0);

        pm72 = new Pixmap(Gdx.files.internal("GenerateMap/mouseBagDown.png"));
        cursor72 = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("GenerateMap/mouseBagDown.png")), 0, 0);



        Gdx.graphics.setCursor(cursor);



    }

    public int render(int type,int mouseNumber){
        switch (type){
            case 1:{
                pm = pm1;
                cursor = cursor1;
                Gdx.graphics.setCursor(cursor);
            }break;
            case 2:{
                pm = pm2;
                cursor = cursor2;
                Gdx.graphics.setCursor(cursor);
            }break;
            case 3:{
                pm = pm3;
                cursor = cursor3;
                Gdx.graphics.setCursor(cursor);
            }break;
            case 4:{
                pm = pm4;
                cursor = cursor4;
                Gdx.graphics.setCursor(cursor);
            }break;
            case 5:{
                pm = pm5;
                cursor = cursor5;
                Gdx.graphics.setCursor(cursor);
            }break;
            case 6:{;
                pm = pm6;
                cursor = cursor6;
                Gdx.graphics.setCursor(cursor);
            }break;
            case 7:{
                pm = pm7;
                cursor = cursor7;
                Gdx.graphics.setCursor(cursor);
            }break;
            case 8: {
                pm = pm32;
                cursor = cursor32;
                Gdx.graphics.setCursor(cursor);
                break;
            }
            case 9:{
                pm = pm72;
                cursor = cursor72;
                Gdx.graphics.setCursor(cursor);
                break;
            }
            case 10:{
                pm = pm7;
                cursor = cursor7;
                Gdx.graphics.setCursor(cursor);
            }
            case 11:{
                pm = pm7;
                cursor = cursor7;
                Gdx.graphics.setCursor(cursor);
            }
            case 12:{
                pm = pm7;
                cursor = cursor7;
                Gdx.graphics.setCursor(cursor);
            }
        }
        mouseNumber = type;
        return mouseNumber;


    }
}
