package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.game.entitirs.ShowImage;

public class ShowingHudMoney {
    ShowImage pos1,pos2,pos3,pos4,pos5,pos6,pos7,pos8,hudMoney,day,numDay,numDay2;
    String moneyString;

    public void create(){
        pos1 = new ShowImage(new Sprite(new Texture(Gdx.files.internal("GenerateMap/number/num0.png"))));
        pos2 = new ShowImage(new Sprite(new Texture(Gdx.files.internal("GenerateMap/number/num0.png"))));
        pos3 = new ShowImage(new Sprite(new Texture(Gdx.files.internal("GenerateMap/number/num0.png"))));
        pos4 = new ShowImage(new Sprite(new Texture(Gdx.files.internal("GenerateMap/number/num0.png"))));
        pos5 = new ShowImage(new Sprite(new Texture(Gdx.files.internal("GenerateMap/number/num0.png"))));
        pos6 = new ShowImage(new Sprite(new Texture(Gdx.files.internal("GenerateMap/number/num0.png"))));
        pos7 = new ShowImage(new Sprite(new Texture(Gdx.files.internal("GenerateMap/number/num0.png"))));
        pos8 = new ShowImage(new Sprite(new Texture(Gdx.files.internal("GenerateMap/number/num0.png"))));
        day = new ShowImage(new Sprite(new Texture(Gdx.files.internal("GenerateMap/number/day.png"))));
        numDay = new ShowImage(new Sprite(new Texture(Gdx.files.internal("GenerateMap/number/num1.png"))));
        numDay2 = new ShowImage(new Sprite(new Texture(Gdx.files.internal("GenerateMap/number/num1.png"))));
        hudMoney = new ShowImage(new Sprite(new Texture(Gdx.files.internal("GenerateMap/number/hudMoneyShowing.png"))));

        pos1.scale(0.4f);
        pos2.scale(0.4f);
        pos3.scale(0.4f);
        pos4.scale(0.4f);
        pos5.scale(0.4f);
        pos6.scale(0.4f);
        pos7.scale(0.4f);
        pos8.scale(0.4f);
        day.scale(0.3f);
        numDay.scale(0.7f);
        hudMoney.scale(2);
        numDay2.scale(0.7f);

    }
    public void showHudMoney(OrthogonalTiledMapRenderer renderer, Camera camera,int money,int numday){
        moneyString = Integer.toString(money);
        switching(numday%10,numDay);
        for (int i =moneyString.length();i>0;i--)
            if(moneyString.length() == i) switching(Character.getNumericValue(moneyString.charAt(i-1)),pos8);
            else if(moneyString.length()-1 == i) switching(Character.getNumericValue(moneyString.charAt(i-1)),pos7);
            else if(moneyString.length()-2 == i) switching(Character.getNumericValue(moneyString.charAt(i-1)),pos6);
            else if(moneyString.length()-3 == i) switching(Character.getNumericValue(moneyString.charAt(i-1)),pos5);
            else if(moneyString.length()-4 == i) switching(Character.getNumericValue(moneyString.charAt(i-1)),pos4);
            else if(moneyString.length()-5 == i) switching(Character.getNumericValue(moneyString.charAt(i-1)),pos3);
            else if(moneyString.length()-6 == i) switching(Character.getNumericValue(moneyString.charAt(i-1)),pos2);
            else if(moneyString.length()-7 == i) switching(Character.getNumericValue(moneyString.charAt(i-1)),pos1);
        hudMoney.setPosition(camera.position.x-555,camera.position.y+265);
        pos1.setPosition(camera.position.x-600,camera.position.y+236);
        pos2.setPosition(camera.position.x-577,camera.position.y+236);
        pos3.setPosition(camera.position.x-555,camera.position.y+236);
        pos4.setPosition(camera.position.x-534,camera.position.y+236);
        pos5.setPosition(camera.position.x-512,camera.position.y+236);
        pos6.setPosition(camera.position.x-490,camera.position.y+236);
        pos7.setPosition(camera.position.x-465,camera.position.y+236);
        pos8.setPosition(camera.position.x-443,camera.position.y+236);
        numDay.setPosition(camera.position.x-443,camera.position.y+307);
        numDay2.setPosition(camera.position.x-465,camera.position.y+307);
        day.setPosition(camera.position.x-615,camera.position.y+295);
        hudMoney.draw(renderer.getBatch());
        if(money>=10000000) pos1.draw(renderer.getBatch());
        if(money>=1000000) pos2.draw(renderer.getBatch());
        if(money>=100000) pos3.draw(renderer.getBatch());
        if(money>=10000) pos4.draw(renderer.getBatch());
        if(money>=1000) pos5.draw(renderer.getBatch());
        if(money>=100) pos6.draw(renderer.getBatch());
        if(money>=10) pos7.draw(renderer.getBatch());
        pos8.draw(renderer.getBatch());
        day.draw(renderer.getBatch());
        if(numday>9){
            if(numday>19&& numday<30){
                numDay2.getTexture().dispose();
                numDay2.setTexture(new Texture(Gdx.files.internal("GenerateMap/number/num2.png")));
            }
            else if(numday>39&& numday<40){
                numDay2.getTexture().dispose();
                numDay2.setTexture(new Texture(Gdx.files.internal("GenerateMap/number/num3.png")));
            }
            numDay2.draw(renderer.getBatch());
        }
        numDay.draw(renderer.getBatch());
    }

    public void dispose(){
        pos1.getTexture().dispose();
        pos2.getTexture().dispose();
        pos3.getTexture().dispose();
        pos4.getTexture().dispose();
        pos5.getTexture().dispose();
        pos6.getTexture().dispose();
        pos7.getTexture().dispose();
        pos8.getTexture().dispose();
        hudMoney.getTexture().dispose();
        day.getTexture().dispose();
        numDay2.getTexture().dispose();
    }

    public void switching(int eiei,ShowImage posN){
        posN.getTexture().dispose();
        switch (eiei){
            case 0: posN.setTexture(new Texture(Gdx.files.internal("GenerateMap/number/num0.png"))); break;
            case 1: posN.setTexture(new Texture(Gdx.files.internal("GenerateMap/number/num1.png"))); break;
            case 2: posN.setTexture(new Texture(Gdx.files.internal("GenerateMap/number/num2.png"))); break;
            case 3: posN.setTexture(new Texture(Gdx.files.internal("GenerateMap/number/num3.png"))); break;
            case 4: posN.setTexture(new Texture(Gdx.files.internal("GenerateMap/number/num4.png"))); break;
            case 5: posN.setTexture(new Texture(Gdx.files.internal("GenerateMap/number/num5.png"))); break;
            case 6: posN.setTexture(new Texture(Gdx.files.internal("GenerateMap/number/num6.png"))); break;
            case 7: posN.setTexture(new Texture(Gdx.files.internal("GenerateMap/number/num7.png"))); break;
            case 8: posN.setTexture(new Texture(Gdx.files.internal("GenerateMap/number/num8.png"))); break;
            case 9: posN.setTexture(new Texture(Gdx.files.internal("GenerateMap/number/num9.png"))); break;

        }
    }
}
