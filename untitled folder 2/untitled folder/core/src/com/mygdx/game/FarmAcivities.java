package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.mygdx.game.entitirs.Player;

import java.util.ArrayList;

public class FarmAcivities {
     Sound sound = Gdx.audio.newSound(Gdx.files.internal("SoundEffect/Dicking.mp3"));
     Sound sound2 = Gdx.audio.newSound(Gdx.files.internal("SoundEffect/watering.mp3"));
     Sound sound3 = Gdx.audio.newSound(Gdx.files.internal("SoundEffect/sand.mp3"));
     long id;
     int moneys;

    public int FarmAcivities(FloorStatus[] floorMaps, Player player, int mouseNumber, MouseChange mouseChange, int money, ArrayList<SlotBag> slotBag){
        moneys = money;
        mouseChange.render(mouseNumber,mouseNumber);
            if (player.getmouseClicked() == true) {
                if (mouseNumber==3){
                    mouseChange.render(8,mouseNumber);
                }else if(mouseNumber==7 || mouseNumber==10){
                    mouseChange.render(9,mouseNumber);
                }
                changeEffect(mouseNumber);
                if(332<=player.getPosX() && player.getPosX()<=415 && player.getPosY()>=72 && player.getPosY()<=160){
                    activity(0,mouseNumber,floorMaps,slotBag,mouseChange);
                }else if(437<=player.getPosX() && player.getPosX()<=518 && player.getPosY()>=72 && player.getPosY()<=160){
                    activity(1,mouseNumber,floorMaps,slotBag,mouseChange);
                }else if(546<=player.getPosX() && player.getPosX()<=622 && player.getPosY()>=72 && player.getPosY()<=160){
                    activity(2,mouseNumber,floorMaps,slotBag,mouseChange);
                }else if(647<=player.getPosX() && player.getPosX()<=728 && player.getPosY()>=72 && player.getPosY()<=160){
                    activity(3,mouseNumber,floorMaps,slotBag,mouseChange);
                }else if(751<=player.getPosX() && player.getPosX()<=834 && player.getPosY()>=72 && player.getPosY()<=160){
                    activity(4,mouseNumber,floorMaps,slotBag,mouseChange);
                }else if(857<=player.getPosX() && player.getPosX()<=938 && player.getPosY()>=72 && player.getPosY()<=160){
                    activity(5,mouseNumber,floorMaps,slotBag,mouseChange);
                }else if(332<=player.getPosX() && player.getPosX()<=414 && player.getPosY()>=173 && player.getPosY()<=258){
                    activity(6,mouseNumber,floorMaps,slotBag,mouseChange);
                }else if(437<=player.getPosX() && player.getPosX()<=518 && player.getPosY()>=173 && player.getPosY()<=258){
                    activity(7,mouseNumber,floorMaps,slotBag,mouseChange);
                }else if(546<=player.getPosX() && player.getPosX()<=622 && player.getPosY()>=173 && player.getPosY()<=258){
                    activity(8,mouseNumber,floorMaps,slotBag,mouseChange);
                }else if(647<=player.getPosX() && player.getPosX()<=728 && player.getPosY()>=173 && player.getPosY()<=258){
                    activity(9,mouseNumber,floorMaps,slotBag,mouseChange);
                }else if(751<=player.getPosX() && player.getPosX()<=834 && player.getPosY()>=173 && player.getPosY()<=258){
                    activity(10,mouseNumber,floorMaps,slotBag,mouseChange);
                }else if(857<=player.getPosX() && player.getPosX()<=938 && player.getPosY()>=173 && player.getPosY()<=258){
                    activity(11,mouseNumber,floorMaps,slotBag,mouseChange);
                }else if(332<=player.getPosX() && player.getPosX()<=414 && player.getPosY()>=273 && player.getPosY()<=358){
                    activity(12,mouseNumber,floorMaps,slotBag,mouseChange);
                }else if(437<=player.getPosX() && player.getPosX()<=518 && player.getPosY()>=273 && player.getPosY()<=358){
                    activity(13,mouseNumber,floorMaps,slotBag,mouseChange);
                }else if(546<=player.getPosX() && player.getPosX()<=622 && player.getPosY()>=273 && player.getPosY()<=358){
                    activity(14,mouseNumber,floorMaps,slotBag,mouseChange);
                }else if(647<=player.getPosX() && player.getPosX()<=728 && player.getPosY()>=273 && player.getPosY()<=358){
                    activity(15,mouseNumber,floorMaps,slotBag,mouseChange);
                }else if(751<=player.getPosX() && player.getPosX()<=834 && player.getPosY()>=273 && player.getPosY()<=358){
                    activity(16,mouseNumber,floorMaps,slotBag,mouseChange);
                }else if(857<=player.getPosX() && player.getPosX()<=938 && player.getPosY()>=273 && player.getPosY()<=358){
                    activity(17,mouseNumber,floorMaps,slotBag,mouseChange);
                }else if(332<=player.getPosX() && player.getPosX()<=414 && player.getPosY()>=373 && player.getPosY()<=458){
                    activity(18,mouseNumber,floorMaps,slotBag,mouseChange);
                } else if(437<=player.getPosX() && player.getPosX()<=518 && player.getPosY()>=373 && player.getPosY()<=458){
                    activity(19,mouseNumber,floorMaps,slotBag,mouseChange);
                }else if(546<=player.getPosX() && player.getPosX()<=622 && player.getPosY()>=373 && player.getPosY()<=458){
                    activity(20,mouseNumber,floorMaps,slotBag,mouseChange);
                }else if(647<=player.getPosX() && player.getPosX()<=728 && player.getPosY()>=373 && player.getPosY()<=458){
                    activity(21,mouseNumber,floorMaps,slotBag,mouseChange);
                }else if(751<=player.getPosX() && player.getPosX()<=834 && player.getPosY()>=373 && player.getPosY()<=458){
                    activity(22,mouseNumber,floorMaps,slotBag,mouseChange);
                }else if(857<=player.getPosX() && player.getPosX()<=938 && player.getPosY()>=373 && player.getPosY()<=458){
                    activity(23,mouseNumber,floorMaps,slotBag,mouseChange);
                }else if(332<=player.getPosX() && player.getPosX()<=414 && player.getPosY()>=473 && player.getPosY()<=558){
                    activity(24,mouseNumber,floorMaps,slotBag,mouseChange);
                }else if(437<=player.getPosX() && player.getPosX()<=518 && player.getPosY()>=473 && player.getPosY()<=558){
                    activity(25,mouseNumber,floorMaps,slotBag,mouseChange);
                }else if(546<=player.getPosX() && player.getPosX()<=622 && player.getPosY()>=473 && player.getPosY()<=558){
                    activity(26,mouseNumber,floorMaps,slotBag,mouseChange);
                }else if(647<=player.getPosX() && player.getPosX()<=728 && player.getPosY()>=473 && player.getPosY()<=558){
                    activity(27,mouseNumber,floorMaps,slotBag,mouseChange);
                }else if(751<=player.getPosX() && player.getPosX()<=834 && player.getPosY()>=473 && player.getPosY()<=558){
                    activity(28,mouseNumber,floorMaps,slotBag,mouseChange);
                }else if(857<=player.getPosX() && player.getPosX()<=938 && player.getPosY()>=473 && player.getPosY()<=558){
                    activity(29,mouseNumber,floorMaps,slotBag,mouseChange);
                }

                player.setMouseClicked(false);
            }
        return moneys;


        }
        private void changeEffect(int mouse){
        if (mouse==10) mouse=7;
        switch (mouse){
            case 3:{
                sound3.stop();
                sound2.stop();
                sound.play();
                break;
            }
            case 6:{
                sound3.stop();
                sound2.play();
                sound.stop();
                break;
            }
            case 7:{
                sound.stop();
                sound2.stop();
                sound3.setVolume(id,2f);
                sound3.play();
                break;
            }

        }

        }
        private void activity(int index,int mouseNumber,FloorStatus[] floorMaps,ArrayList<SlotBag> slotBags,MouseChange mouseChange){
            if (mouseNumber==3) {
                if(floorMaps[index].getStatus()==0) {
                    floorMaps[index].setName("dicking.png");
                    floorMaps[index].setStatus(1);
                    floorMaps[index].getTree().addGrowth(2);
                }
                else if(floorMaps[index].getStatus()==2){
                    floorMaps[index].setName("dickingwet.png");
                    floorMaps[index].setStatus(4);
                }
                if(!floorMaps[index].getTree().getNameTree().equals("null.png") & !floorMaps[index].getTree().getNameTree().equals("deadtree.png")){
                    floorMaps[index].getTree().setNameTree("deadtree.png");
                    floorMaps[index].getTree().setGrowthStatus(0);
                }
                else if(floorMaps[index].getTree().getNameTree().equals("deadtree.png")){
                    floorMaps[index].getTree().setNameTree("null.png");
                    floorMaps[index].getTree().setGrowthStatus(0);
                    floorMaps[index].getTree().setDay(0);
                }
            }
            else if(mouseNumber==6){
                if(floorMaps[index].getStatus()==0){
                    floorMaps[index].setName("wetfloor.png");
                    floorMaps[index].setStatus(2);
                }
                else if(floorMaps[index].getStatus()==1){
                    floorMaps[index].setName("dickingwet.png");
                    floorMaps[index].setStatus(4);
                }
                if(!floorMaps[index].getTree().getNameTree().equals("null.png"))floorMaps[index].getTree().addGrowth(5);
            }
            else if(mouseNumber==7 && floorMaps[index].getTree().getNameTree().equals("null.png")){
                if(slotBags.get(0).getName().equals("tree/10/bag.png")){
                    floorMaps[index].getTree().setNameTree("tree/10/1.png");
                }
                else if(slotBags.get(0).getName().equals("tree/2/bag.png")){
                    floorMaps[index].getTree().setNameTree("tree/2/1.png");
                }
                else if(slotBags.get(0).getName().equals("tree/11/bag.png")){
                    floorMaps[index].getTree().setNameTree("tree/11/1.png");
                }
                else if(slotBags.get(0).getName().equals("tree/12/bag.png")){
                    floorMaps[index].getTree().setNameTree("tree/12/1.png");
                }
                else if(slotBags.get(0).getName().equals("tree/13/bag.png")){
                    floorMaps[index].getTree().setNameTree("tree/13/1.png");
                }
                if(floorMaps[index].getStatus()>2)floorMaps[index].getTree().setGrowthStatus(5);
                slotBags.get(0).setCoun(-1);
                if(slotBags.get(0).getCoun()==0)mouseChange.render(1,mouseNumber);
            }
            else if(mouseNumber==10 && floorMaps[index].getTree().getNameTree().equals("null.png")){
                if(slotBags.get(1).getName().equals("tree/10/bag.png")){
                    floorMaps[index].getTree().setNameTree("tree/10/1.png");
                    floorMaps[index].getTree().setGrowthStatus(0);
                }
                else if(slotBags.get(1).getName().equals("tree/2/bag.png")){
                    floorMaps[index].getTree().setNameTree("tree/2/1.png");
                    floorMaps[index].getTree().setGrowthStatus(0);
                }
                else if(slotBags.get(1).getName().equals("tree/11/bag.png")){
                    floorMaps[index].getTree().setNameTree("tree/11/1.png");
                    floorMaps[index].getTree().setGrowthStatus(0);
                }
                else if(slotBags.get(1).getName().equals("tree/12/bag.png")){
                    floorMaps[index].getTree().setNameTree("tree/12/1.png");
                    floorMaps[index].getTree().setGrowthStatus(0);
                }
                else if(slotBags.get(1).getName().equals("tree/13/bag.png")){
                    floorMaps[index].getTree().setNameTree("tree/13/1.png");
                    floorMaps[index].getTree().setGrowthStatus(0);
                }
                if(floorMaps[index].getStatus()>2)floorMaps[index].getTree().setGrowthStatus(5);
                slotBags.get(1).setCoun(-1);
                if(slotBags.get(1).getCoun()==0)mouseChange.render(1,mouseNumber);
            }
            else if(mouseNumber==11 && floorMaps[index].getTree().getNameTree().equals("null.png")){
                if(slotBags.get(2).getName().equals("tree/10/bag.png")){
                    floorMaps[index].getTree().setNameTree("tree/10/1.png");
                    floorMaps[index].getTree().setGrowthStatus(0);
                }
                else if(slotBags.get(2).getName().equals("tree/2/bag.png")){
                    floorMaps[index].getTree().setNameTree("tree/2/1.png");
                    floorMaps[index].getTree().setGrowthStatus(0);
                }
                else if(slotBags.get(2).getName().equals("tree/11/bag.png")){
                    floorMaps[index].getTree().setNameTree("tree/11/1.png");
                    floorMaps[index].getTree().setGrowthStatus(0);
                }
                else if(slotBags.get(2).getName().equals("tree/12/bag.png")){
                    floorMaps[index].getTree().setNameTree("tree/12/1.png");
                    floorMaps[index].getTree().setGrowthStatus(0);
                }
                else if(slotBags.get(2).getName().equals("tree/13/bag.png")){
                    floorMaps[index].getTree().setNameTree("tree/13/1.png");
                    floorMaps[index].getTree().setGrowthStatus(0);
                }
                if(floorMaps[index].getStatus()>2)floorMaps[index].getTree().setGrowthStatus(5);
                slotBags.get(2).setCoun(-1);
                if(slotBags.get(2).getCoun()==0)mouseChange.render(1,mouseNumber);
            }
            else if(mouseNumber==12 && floorMaps[index].getTree().getNameTree().equals("null.png")){
                if(slotBags.get(3).getName().equals("tree/10/bag.png")){
                    floorMaps[index].getTree().setNameTree("tree/10/1.png");
                    floorMaps[index].getTree().setGrowthStatus(0);
                }
                else if(slotBags.get(3).getName().equals("tree/2/bag.png")){
                    floorMaps[index].getTree().setNameTree("tree/2/1.png");
                    floorMaps[index].getTree().setGrowthStatus(0);
                }
                else if(slotBags.get(3).getName().equals("tree/11/bag.png")){
                    floorMaps[index].getTree().setNameTree("tree/11/1.png");
                    floorMaps[index].getTree().setGrowthStatus(0);
                }
                else if(slotBags.get(3).getName().equals("tree/12/bag.png")){
                    floorMaps[index].getTree().setNameTree("tree/12/1.png");
                    floorMaps[index].getTree().setGrowthStatus(0);
                }
                else if(slotBags.get(3).getName().equals("tree/13/bag.png")){
                    floorMaps[index].getTree().setNameTree("tree/13/1.png");
                    floorMaps[index].getTree().setGrowthStatus(0);
                }
                if(floorMaps[index].getStatus()>2)floorMaps[index].getTree().setGrowthStatus(5);
                slotBags.get(3).setCoun(-1);
                if(slotBags.get(3).getCoun()==0)mouseChange.render(1,mouseNumber);
            }
            else if(floorMaps[index].getTree().getNameTree().equals("tree/10/7.png") || floorMaps[index].getTree().getNameTree().equals("tree/2/8.png")
                    || floorMaps[index].getTree().getNameTree().equals("tree/11/8.png")){
                if(mouseNumber==4||mouseNumber==5) {
                    moneys += 15;
                    floorMaps[index].getTree().setNameTree("deadtree.png");
                    floorMaps[index].getTree().setGrowthStatus(0);
                    floorMaps[index].getTree().setDay(0);
                }
            }

        }

    }
