package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.mygdx.game.entitirs.Player;

public class FarmAcivities {
     Sound sound = Gdx.audio.newSound(Gdx.files.internal("SoundEffect/Dicking.mp3"));
     Sound sound2 = Gdx.audio.newSound(Gdx.files.internal("SoundEffect/watering.mp3"));

    public void FarmAcivities(FloorStatus[] floorMaps, Player player, int mouseNumber, MouseChange mouseChange){
        mouseChange.render(mouseNumber,mouseNumber);
            if (player.getmouseClicked() == true) {
                if (mouseNumber==3){
                    mouseChange.render(8,mouseNumber);
                    sound.play();
                }
                changeEffect(mouseNumber);
                if(332<=player.getPosX() && player.getPosX()<=415 && player.getPosY()>=72 && player.getPosY()<=160){
                    if (mouseNumber==3) {
                        if(floorMaps[0].getStatus()==0) {
                            floorMaps[0].setName("dicking.png");
                            floorMaps[0].setStatus(1);
                        }
                        else if(floorMaps[0].getStatus()==2){
                            floorMaps[0].setName("dickingwet.png");
                            floorMaps[0].setStatus(4);
                        }
                    }
                    else if(mouseNumber==6){
                        if(floorMaps[0].getStatus()==0){
                            floorMaps[0].setName("wetfloor.png");
                            floorMaps[0].setStatus(2);
                        }
                        else if(floorMaps[0].getStatus()==1){
                            floorMaps[0].setName("dickingwet.png");
                            floorMaps[0].setStatus(3);
                        }
                    }
                    else if(mouseNumber==7){
                        floorMaps[0].getTree().setNameTree("tree/1/1.png");
                        floorMaps[0].getTree().setGrowthStatus(0);

                    }
                }
                else if(437<=player.getPosX() && player.getPosX()<=518 && player.getPosY()>=72 && player.getPosY()<=160){
                    if (mouseNumber==3) {
                        if(floorMaps[1].getStatus()==0) {
                            floorMaps[1].setName("dicking.png");
                            floorMaps[1].setStatus(1);
                        }
                        else if(floorMaps[1].getStatus()==2){
                            floorMaps[1].setName("dickingwet.png");
                            floorMaps[1].setStatus(4);
                        }
                    }
                    else if(mouseNumber==6){
                        if(floorMaps[1].getStatus()==0){
                            floorMaps[1].setName("wetfloor.png");
                            floorMaps[1].setStatus(2);
                        }
                        else if(floorMaps[1].getStatus()==1){
                            floorMaps[1].setName("dickingwet.png");
                            floorMaps[1].setStatus(3);
                        }
                    }
                    else if(mouseNumber==7){
                        floorMaps[1].getTree().setNameTree("tree/1/3.png");
                        floorMaps[1].getTree().setGrowthStatus(0);

                    }
                }
                else if(546<=player.getPosX() && player.getPosX()<=622 && player.getPosY()>=72 && player.getPosY()<=160){
                    if (mouseNumber==3) {
                        if(floorMaps[2].getStatus()==0) {
                            floorMaps[2].setName("dicking.png");
                            floorMaps[2].setStatus(1);
                        }
                        else if(floorMaps[2].getStatus()==2){
                            floorMaps[2].setName("dickingwet.png");
                            floorMaps[2].setStatus(4);
                        }
                    }
                    else if(mouseNumber==6){
                        if(floorMaps[2].getStatus()==0){
                            floorMaps[2].setName("wetfloor.png");
                            floorMaps[2].setStatus(2);
                        }
                        else if(floorMaps[2].getStatus()==1){
                            floorMaps[2].setName("dickingwet.png");
                            floorMaps[2].setStatus(3);
                        }
                    }
                    else if(mouseNumber==7){
                        floorMaps[2].getTree().setNameTree("tree/1/4.png");
                        floorMaps[2].getTree().setGrowthStatus(0);

                    }
                }
                else if(647<=player.getPosX() && player.getPosX()<=728 && player.getPosY()>=72 && player.getPosY()<=160){
                    if (mouseNumber==3) {
                        if(floorMaps[3].getStatus()==0) {
                            floorMaps[3].setName("dicking.png");
                            floorMaps[3].setStatus(1);
                        }
                        else if(floorMaps[3].getStatus()==2){
                            floorMaps[3].setName("dickingwet.png");
                            floorMaps[3].setStatus(4);
                        }
                    }
                    else if(mouseNumber==6){
                        if(floorMaps[3].getStatus()==0){
                            floorMaps[3].setName("wetfloor.png");
                            floorMaps[3].setStatus(2);
                        }
                        else if(floorMaps[3].getStatus()==1){
                            floorMaps[3].setName("dickingwet.png");
                            floorMaps[3].setStatus(3);
                        }
                    }
                    else if(mouseNumber==7){
                        floorMaps[3].getTree().setNameTree("tree/1/5.png");
                        floorMaps[3].getTree().setGrowthStatus(0);

                    }

                }
                else if(751<=player.getPosX() && player.getPosX()<=834 && player.getPosY()>=72 && player.getPosY()<=160){
                    if (mouseNumber==3) {
                        if(floorMaps[4].getStatus()==0) {
                            floorMaps[4].setName("dicking.png");
                            floorMaps[4].setStatus(1);
                        }
                        else if(floorMaps[4].getStatus()==2){
                            floorMaps[4].setName("dickingwet.png");
                            floorMaps[4].setStatus(4);
                        }
                    }
                    else if(mouseNumber==6){
                        if(floorMaps[4].getStatus()==0){
                            floorMaps[4].setName("wetfloor.png");
                            floorMaps[4].setStatus(2);
                        }
                        else if(floorMaps[4].getStatus()==1){
                            floorMaps[4].setName("dickingwet.png");
                            floorMaps[4].setStatus(3);
                        }
                    }
                    else if(mouseNumber==7){
                        floorMaps[4].getTree().setNameTree("tree/1/6.png");
                        floorMaps[4].getTree().setGrowthStatus(0);

                    }
                }
                else if(857<=player.getPosX() && player.getPosX()<=938 && player.getPosY()>=72 && player.getPosY()<=160){
                    if (mouseNumber==3) {
                        if(floorMaps[5].getStatus()==0) {
                            floorMaps[5].setName("dicking.png");
                            floorMaps[5].setStatus(1);
                        }
                        else if(floorMaps[5].getStatus()==2){
                            floorMaps[5].setName("dickingwet.png");
                            floorMaps[5].setStatus(4);
                        }
                    }
                    else if(mouseNumber==6){
                        if(floorMaps[5].getStatus()==0){
                            floorMaps[5].setName("wetfloor.png");
                            floorMaps[5].setStatus(2);
                        }
                        else if(floorMaps[5].getStatus()==1){
                            floorMaps[5].setName("dickingwet.png");
                            floorMaps[5].setStatus(3);
                        }
                    }
                    else if(mouseNumber==7){
                        floorMaps[5].getTree().setNameTree("tree/1/7.png");
                        floorMaps[5].getTree().setGrowthStatus(0);

                    }
                }
                else if(332<=player.getPosX() && player.getPosX()<=414 && player.getPosY()>=173 && player.getPosY()<=258){
                    if (mouseNumber==3) {
                        if(floorMaps[6].getStatus()==0) {
                            floorMaps[6].setName("dicking.png");
                            floorMaps[6].setStatus(1);
                        }
                        else if(floorMaps[6].getStatus()==2){
                            floorMaps[6].setName("dickingwet.png");
                            floorMaps[6].setStatus(4);
                        }
                    }
                    else if(mouseNumber==6){
                        if(floorMaps[6].getStatus()==0){
                            floorMaps[6].setName("wetfloor.png");
                            floorMaps[6].setStatus(2);
                        }
                        else if(floorMaps[6].getStatus()==1){
                            floorMaps[6].setName("dickingwet.png");
                            floorMaps[6].setStatus(3);
                        }
                    }
                    else if(mouseNumber==7){
                        floorMaps[6].getTree().setNameTree("weed.png");
                        floorMaps[6].getTree().setGrowthStatus(0);

                    }
                }
                else if(437<=player.getPosX() && player.getPosX()<=518 && player.getPosY()>=173 && player.getPosY()<=258){
                    if (mouseNumber==3) {
                        if(floorMaps[7].getStatus()==0) {
                            floorMaps[7].setName("dicking.png");
                            floorMaps[7].setStatus(1);
                        }
                        else if(floorMaps[7].getStatus()==2){
                            floorMaps[7].setName("dickingwet.png");
                            floorMaps[7].setStatus(4);
                        }
                    }
                    else if(mouseNumber==6){
                        if(floorMaps[7].getStatus()==0){
                            floorMaps[7].setName("wetfloor.png");
                            floorMaps[7].setStatus(2);
                        }
                        else if(floorMaps[7].getStatus()==1){
                            floorMaps[7].setName("dickingwet.png");
                            floorMaps[7].setStatus(3);
                        }
                    }
                    else if(mouseNumber==7){
                        floorMaps[7].getTree().setNameTree("weed.png");
                        floorMaps[7].getTree().setGrowthStatus(0);

                    }
                }
                else if(546<=player.getPosX() && player.getPosX()<=622 && player.getPosY()>=173 && player.getPosY()<=258){
                    if (mouseNumber==3) {
                        if(floorMaps[8].getStatus()==0) {
                            floorMaps[8].setName("dicking.png");
                            floorMaps[8].setStatus(1);
                        }
                        else if(floorMaps[8].getStatus()==2){
                            floorMaps[8].setName("dickingwet.png");
                            floorMaps[8].setStatus(4);
                        }
                    }
                    else if(mouseNumber==6){
                        if(floorMaps[8].getStatus()==0){
                            floorMaps[8].setName("wetfloor.png");
                            floorMaps[8].setStatus(2);
                        }
                        else if(floorMaps[8].getStatus()==1){
                            floorMaps[8].setName("dickingwet.png");
                            floorMaps[8].setStatus(3);
                        }
                    }
                    else if(mouseNumber==7){
                        floorMaps[8].getTree().setNameTree("weed.png");
                        floorMaps[8].getTree().setGrowthStatus(0);

                    }
                }
                else if(647<=player.getPosX() && player.getPosX()<=728 && player.getPosY()>=173 && player.getPosY()<=258){
                    if (mouseNumber==3) {
                        if(floorMaps[9].getStatus()==0) {
                            floorMaps[9].setName("dicking.png");
                            floorMaps[9].setStatus(1);
                        }
                        else if(floorMaps[9].getStatus()==2){
                            floorMaps[9].setName("dickingwet.png");
                            floorMaps[9].setStatus(4);
                        }
                    }
                    else if(mouseNumber==6){
                        if(floorMaps[9].getStatus()==0){
                            floorMaps[9].setName("wetfloor.png");
                            floorMaps[9].setStatus(2);
                        }
                        else if(floorMaps[9].getStatus()==1){
                            floorMaps[9].setName("dickingwet.png");
                            floorMaps[9].setStatus(3);
                        }
                    }
                    else if(mouseNumber==7){
                        floorMaps[9].getTree().setNameTree("weed.png");
                        floorMaps[9].getTree().setGrowthStatus(0);

                    }
                }else if(751<=player.getPosX() && player.getPosX()<=834 && player.getPosY()>=173 && player.getPosY()<=258){
                    if (mouseNumber==3) {
                        if(floorMaps[10].getStatus()==0) {
                            floorMaps[10].setName("dicking.png");
                            floorMaps[10].setStatus(1);
                        }
                        else if(floorMaps[10].getStatus()==2){
                            floorMaps[10].setName("dickingwet.png");
                            floorMaps[10].setStatus(4);
                        }
                    }
                    else if(mouseNumber==6){
                        if(floorMaps[10].getStatus()==0){
                            floorMaps[10].setName("wetfloor.png");
                            floorMaps[10].setStatus(2);
                        }
                        else if(floorMaps[10].getStatus()==1){
                            floorMaps[10].setName("dickingwet.png");
                            floorMaps[10].setStatus(3);
                        }
                    }
                    else if(mouseNumber==7){
                        floorMaps[10].getTree().setNameTree("weed.png");
                        floorMaps[10].getTree().setGrowthStatus(0);

                    }
                }else if(857<=player.getPosX() && player.getPosX()<=938 && player.getPosY()>=173 && player.getPosY()<=258){
                    if (mouseNumber==3) {
                        if(floorMaps[11].getStatus()==0) {
                            floorMaps[11].setName("dicking.png");
                            floorMaps[11].setStatus(1);
                        }
                        else if(floorMaps[11].getStatus()==2){
                            floorMaps[11].setName("dickingwet.png");
                            floorMaps[11].setStatus(4);
                        }
                    }
                    else if(mouseNumber==6){
                        if(floorMaps[11].getStatus()==0){
                            floorMaps[11].setName("wetfloor.png");
                            floorMaps[11].setStatus(2);
                        }
                        else if(floorMaps[11].getStatus()==1){
                            floorMaps[11].setName("dickingwet.png");
                            floorMaps[11].setStatus(3);
                        }
                    }
                    else if(mouseNumber==7){
                        floorMaps[11].getTree().setNameTree("weed.png");
                        floorMaps[11].getTree().setGrowthStatus(0);

                    }
                }else if(332<=player.getPosX() && player.getPosX()<=414 && player.getPosY()>=273 && player.getPosY()<=358){
                    if (mouseNumber==3) {
                        if(floorMaps[12].getStatus()==0) {
                            floorMaps[12].setName("dicking.png");
                            floorMaps[12].setStatus(1);
                        }
                        else if(floorMaps[12].getStatus()==2){
                            floorMaps[12].setName("dickingwet.png");
                            floorMaps[12].setStatus(4);
                        }
                    }
                    else if(mouseNumber==6){
                        if(floorMaps[12].getStatus()==0){
                            floorMaps[12].setName("wetfloor.png");
                            floorMaps[12].setStatus(2);
                        }
                        else if(floorMaps[12].getStatus()==1){
                            floorMaps[12].setName("dickingwet.png");
                            floorMaps[12].setStatus(3);
                        }
                    }else if(mouseNumber==7){
                        floorMaps[12].getTree().setNameTree("weed.png");
                        floorMaps[12].getTree().setGrowthStatus(0);

                    }

                }else if(437<=player.getPosX() && player.getPosX()<=518 && player.getPosY()>=273 && player.getPosY()<=358){
                    if (mouseNumber==3) {
                        if(floorMaps[13].getStatus()==0) {
                            floorMaps[13].setName("dicking.png");
                            floorMaps[13].setStatus(1);
                        }
                        else if(floorMaps[13].getStatus()==2){
                            floorMaps[13].setName("dickingwet.png");
                            floorMaps[13].setStatus(4);
                        }
                    }
                    else if(mouseNumber==6){
                        if(floorMaps[13].getStatus()==0){
                            floorMaps[13].setName("wetfloor.png");
                            floorMaps[13].setStatus(2);
                        }
                        else if(floorMaps[13].getStatus()==1){
                            floorMaps[13].setName("dickingwet.png");
                            floorMaps[13].setStatus(3);
                        }
                    }else if(mouseNumber==7){
                        floorMaps[13].getTree().setNameTree("weed.png");
                        floorMaps[13].getTree().setGrowthStatus(0);

                    }
                }

                else if(546<=player.getPosX() && player.getPosX()<=622 && player.getPosY()>=273 && player.getPosY()<=358){
                    if (mouseNumber==3) {
                        if(floorMaps[14].getStatus()==0) {
                            floorMaps[14].setName("dicking.png");
                            floorMaps[14].setStatus(1);
                        }
                        else if(floorMaps[14].getStatus()==2){
                            floorMaps[14].setName("dickingwet.png");
                            floorMaps[14].setStatus(4);
                        }
                    }
                    else if(mouseNumber==6){
                        if(floorMaps[14].getStatus()==0){
                            floorMaps[14].setName("wetfloor.png");
                            floorMaps[14].setStatus(2);
                        }
                        else if(floorMaps[14].getStatus()==1){
                            floorMaps[14].setName("dickingwet.png");
                            floorMaps[14].setStatus(3);
                        }
                    }else if(mouseNumber==7){
                        floorMaps[14].getTree().setNameTree("weed.png");
                        floorMaps[14].getTree().setGrowthStatus(0);

                    }
                }

                else if(647<=player.getPosX() && player.getPosX()<=728 && player.getPosY()>=273 && player.getPosY()<=358){
                    if (mouseNumber==3) {
                        if(floorMaps[15].getStatus()==0) {
                            floorMaps[15].setName("dicking.png");
                            floorMaps[15].setStatus(1);
                        }
                        else if(floorMaps[15].getStatus()==2){
                            floorMaps[15].setName("dickingwet.png");
                            floorMaps[15].setStatus(4);
                        }
                    }
                    else if(mouseNumber==6){
                        if(floorMaps[15].getStatus()==0){
                            floorMaps[15].setName("wetfloor.png");
                            floorMaps[15].setStatus(2);
                        }
                        else if(floorMaps[15].getStatus()==1){
                            floorMaps[15].setName("dickingwet.png");
                            floorMaps[15].setStatus(3);
                        }
                    }else if(mouseNumber==7){
                        floorMaps[15].getTree().setNameTree("weed.png");
                        floorMaps[15].getTree().setGrowthStatus(0);

                    }
                }

                else if(751<=player.getPosX() && player.getPosX()<=834 && player.getPosY()>=273 && player.getPosY()<=358){
                    if (mouseNumber==3) {
                        if(floorMaps[16].getStatus()==0) {
                            floorMaps[16].setName("dicking.png");
                            floorMaps[16].setStatus(1);
                        }
                        else if(floorMaps[16].getStatus()==2){
                            floorMaps[16].setName("dickingwet.png");
                            floorMaps[16].setStatus(4);
                        }
                    }
                    else if(mouseNumber==6){
                        if(floorMaps[16].getStatus()==0){
                            floorMaps[16].setName("wetfloor.png");
                            floorMaps[16].setStatus(2);
                        }
                        else if(floorMaps[16].getStatus()==1){
                            floorMaps[16].setName("dickingwet.png");
                            floorMaps[16].setStatus(3);
                        }
                    }else if(mouseNumber==7){
                        floorMaps[16].getTree().setNameTree("weed.png");
                        floorMaps[16].getTree().setGrowthStatus(0);

                    }
                }

                else if(857<=player.getPosX() && player.getPosX()<=938 && player.getPosY()>=273 && player.getPosY()<=358){
                    if (mouseNumber==3) {
                        if(floorMaps[17].getStatus()==0) {
                            floorMaps[17].setName("dicking.png");
                            floorMaps[17].setStatus(1);
                        }
                        else if(floorMaps[17].getStatus()==2){
                            floorMaps[17].setName("dickingwet.png");
                            floorMaps[17].setStatus(4);
                        }
                    }
                    else if(mouseNumber==6){
                        if(floorMaps[17].getStatus()==0){
                            floorMaps[17].setName("wetfloor.png");
                            floorMaps[17].setStatus(2);
                        }
                        else if(floorMaps[17].getStatus()==1){
                            floorMaps[17].setName("dickingwet.png");
                            floorMaps[17].setStatus(3);
                        }
                    }else if(mouseNumber==7){
                        floorMaps[17].getTree().setNameTree("weed.png");
                        floorMaps[17].getTree().setGrowthStatus(0);

                    }
                }

                else if(332<=player.getPosX() && player.getPosX()<=414 && player.getPosY()>=373 && player.getPosY()<=458){
                    if (mouseNumber==3) {
                        if(floorMaps[18].getStatus()==0) {
                            floorMaps[18].setName("dicking.png");
                            floorMaps[18].setStatus(1);
                        }
                        else if(floorMaps[18].getStatus()==2){
                            floorMaps[18].setName("dickingwet.png");
                            floorMaps[18].setStatus(4);
                        }
                    }
                    else if(mouseNumber==6){
                        if(floorMaps[18].getStatus()==0){
                            floorMaps[18].setName("wetfloor.png");
                            floorMaps[18].setStatus(2);
                        }
                        else if(floorMaps[18].getStatus()==1){
                            floorMaps[18].setName("dickingwet.png");
                            floorMaps[18].setStatus(3);
                        }
                    }else if(mouseNumber==7){
                        floorMaps[18].getTree().setNameTree("weed.png");
                        floorMaps[18].getTree().setGrowthStatus(0);

                    }
                }

                else if(437<=player.getPosX() && player.getPosX()<=518 && player.getPosY()>=373 && player.getPosY()<=458){
                    if (mouseNumber==3) {
                        if(floorMaps[19].getStatus()==0) {
                            floorMaps[19].setName("dicking.png");
                            floorMaps[19].setStatus(1);
                        }
                        else if(floorMaps[19].getStatus()==2){
                            floorMaps[19].setName("dickingwet.png");
                            floorMaps[19].setStatus(4);
                        }
                    }
                    else if(mouseNumber==6){
                        if(floorMaps[19].getStatus()==0){
                            floorMaps[19].setName("wetfloor.png");
                            floorMaps[19].setStatus(2);
                        }
                        else if(floorMaps[19].getStatus()==1){
                            floorMaps[19].setName("dickingwet.png");
                            floorMaps[19].setStatus(3);
                        }
                    }else if(mouseNumber==7){
                        floorMaps[19].getTree().setNameTree("weed.png");
                        floorMaps[19].getTree().setGrowthStatus(0);

                    }
                }

                else if(546<=player.getPosX() && player.getPosX()<=622 && player.getPosY()>=373 && player.getPosY()<=458){
                    if (mouseNumber==3) {
                        if(floorMaps[20].getStatus()==0) {
                            floorMaps[20].setName("dicking.png");
                            floorMaps[20].setStatus(1);
                        }
                        else if(floorMaps[20].getStatus()==2){
                            floorMaps[20].setName("dickingwet.png");
                            floorMaps[20].setStatus(4);
                        }
                    }
                    else if(mouseNumber==6){
                        if(floorMaps[20].getStatus()==0){
                            floorMaps[20].setName("wetfloor.png");
                            floorMaps[20].setStatus(2);
                        }
                        else if(floorMaps[20].getStatus()==1){
                            floorMaps[20].setName("dickingwet.png");
                            floorMaps[20].setStatus(3);
                        }
                    }else if(mouseNumber==7){
                        floorMaps[20].getTree().setNameTree("weed.png");
                        floorMaps[20].getTree().setGrowthStatus(0);

                    }
                }

                else if(647<=player.getPosX() && player.getPosX()<=728 && player.getPosY()>=373 && player.getPosY()<=458){
                    if (mouseNumber==3) {
                        if(floorMaps[21].getStatus()==0) {
                            floorMaps[21].setName("dicking.png");
                            floorMaps[21].setStatus(1);
                        }
                        else if(floorMaps[21].getStatus()==2){
                            floorMaps[21].setName("dickingwet.png");
                            floorMaps[21].setStatus(4);
                        }
                    }
                    else if(mouseNumber==6){
                        if(floorMaps[21].getStatus()==0){
                            floorMaps[21].setName("wetfloor.png");
                            floorMaps[21].setStatus(2);
                        }
                        else if(floorMaps[21].getStatus()==1){
                            floorMaps[21].setName("dickingwet.png");
                            floorMaps[21].setStatus(3);
                        }
                    }else if(mouseNumber==7){
                        floorMaps[21].getTree().setNameTree("weed.png");
                        floorMaps[21].getTree().setGrowthStatus(0);

                    }
                }

                else if(751<=player.getPosX() && player.getPosX()<=834 && player.getPosY()>=373 && player.getPosY()<=458){
                    if (mouseNumber==3) {
                        if(floorMaps[22].getStatus()==0) {
                            floorMaps[22].setName("dicking.png");
                            floorMaps[22].setStatus(1);
                        }
                        else if(floorMaps[22].getStatus()==2){
                            floorMaps[22].setName("dickingwet.png");
                            floorMaps[22].setStatus(4);
                        }
                    }
                    else if(mouseNumber==6){
                        if(floorMaps[22].getStatus()==0){
                            floorMaps[22].setName("wetfloor.png");
                            floorMaps[22].setStatus(2);
                        }
                        else if(floorMaps[22].getStatus()==1){
                            floorMaps[22].setName("dickingwet.png");
                            floorMaps[22].setStatus(3);
                        }
                    }else if(mouseNumber==7){
                        floorMaps[22].getTree().setNameTree("weed.png");
                        floorMaps[22].getTree().setGrowthStatus(0);

                    }
                }

                else if(857<=player.getPosX() && player.getPosX()<=938 && player.getPosY()>=373 && player.getPosY()<=458){
                    if (mouseNumber==3) {
                        if(floorMaps[23].getStatus()==0) {
                            floorMaps[23].setName("dicking.png");
                            floorMaps[23].setStatus(1);
                        }
                        else if(floorMaps[23].getStatus()==2){
                            floorMaps[23].setName("dickingwet.png");
                            floorMaps[23].setStatus(4);
                        }
                    }
                    else if(mouseNumber==6){
                        if(floorMaps[23].getStatus()==0){
                            floorMaps[23].setName("wetfloor.png");
                            floorMaps[23].setStatus(2);
                        }
                        else if(floorMaps[23].getStatus()==1){
                            floorMaps[23].setName("dickingwet.png");
                            floorMaps[23].setStatus(3);
                        }
                    }else if(mouseNumber==7){
                        floorMaps[23].getTree().setNameTree("weed.png");
                        floorMaps[23].getTree().setGrowthStatus(0);
                    }


                }
                else if(332<=player.getPosX() && player.getPosX()<=414 && player.getPosY()>=473 && player.getPosY()<=558){
                    if (mouseNumber==3) {
                        if(floorMaps[24].getStatus()==0) {
                            floorMaps[24].setName("dicking.png");
                            floorMaps[24].setStatus(1);
                        }
                        else if(floorMaps[24].getStatus()==2){
                            floorMaps[24].setName("dickingwet.png");
                            floorMaps[24].setStatus(4);
                        }
                    }
                    else if(mouseNumber==6){
                        if(floorMaps[24].getStatus()==0){
                            floorMaps[24].setName("wetfloor.png");
                            floorMaps[24].setStatus(2);
                        }
                        else if(floorMaps[24].getStatus()==1){
                            floorMaps[24].setName("dickingwet.png");
                            floorMaps[24].setStatus(3);
                        }
                    }else if(mouseNumber==7){
                        floorMaps[24].getTree().setNameTree("weed.png");
                        floorMaps[24].getTree().setGrowthStatus(0);

                    }
                }

                else if(437<=player.getPosX() && player.getPosX()<=518 && player.getPosY()>=473 && player.getPosY()<=558){
                    if (mouseNumber==3) {
                        if(floorMaps[25].getStatus()==0) {
                            floorMaps[25].setName("dicking.png");
                            floorMaps[25].setStatus(1);
                        }
                        else if(floorMaps[25].getStatus()==2){
                            floorMaps[25].setName("dickingwet.png");
                            floorMaps[25].setStatus(4);
                        }
                    }
                    else if(mouseNumber==6){
                        if(floorMaps[25].getStatus()==0){
                            floorMaps[25].setName("wetfloor.png");
                            floorMaps[25].setStatus(2);
                        }
                        else if(floorMaps[25].getStatus()==1){
                            floorMaps[25].setName("dickingwet.png");
                            floorMaps[25].setStatus(3);
                        }
                    }else if(mouseNumber==7){
                        floorMaps[25].getTree().setNameTree("weed.png");
                        floorMaps[25].getTree().setGrowthStatus(0);

                    }
                }
                else if(546<=player.getPosX() && player.getPosX()<=622 && player.getPosY()>=473 && player.getPosY()<=558){
                    if (mouseNumber==3) {
                        if(floorMaps[26].getStatus()==0) {
                            floorMaps[26].setName("dicking.png");
                            floorMaps[26].setStatus(1);
                        }
                        else if(floorMaps[26].getStatus()==2){
                            floorMaps[26].setName("dickingwet.png");
                            floorMaps[26].setStatus(4);
                        }
                    }
                    else if(mouseNumber==6){
                        if(floorMaps[26].getStatus()==0){
                            floorMaps[26].setName("wetfloor.png");
                            floorMaps[26].setStatus(2);
                        }
                        else if(floorMaps[26].getStatus()==1){
                            floorMaps[26].setName("dickingwet.png");
                            floorMaps[26].setStatus(3);
                        }
                    }else if(mouseNumber==7){
                        floorMaps[26].getTree().setNameTree("weed.png");
                        floorMaps[26].getTree().setGrowthStatus(0);

                    }
                }
                else if(647<=player.getPosX() && player.getPosX()<=728 && player.getPosY()>=473 && player.getPosY()<=558){
                    if (mouseNumber==3) {
                        if(floorMaps[27].getStatus()==0) {
                            floorMaps[27].setName("dicking.png");
                            floorMaps[27].setStatus(1);
                        }
                        else if(floorMaps[27].getStatus()==2){
                            floorMaps[27].setName("dickingwet.png");
                            floorMaps[27].setStatus(4);
                        }
                    }
                    else if(mouseNumber==6){
                        if(floorMaps[27].getStatus()==0){
                            floorMaps[27].setName("wetfloor.png");
                            floorMaps[27].setStatus(2);
                        }
                        else if(floorMaps[27].getStatus()==1){
                            floorMaps[27].setName("dickingwet.png");
                            floorMaps[27].setStatus(3);
                        }
                    }else if(mouseNumber==7){
                        floorMaps[27].getTree().setNameTree("weed.png");
                        floorMaps[27].getTree().setGrowthStatus(0);

                    }
                }
                else if(751<=player.getPosX() && player.getPosX()<=834 && player.getPosY()>=473 && player.getPosY()<=558){
                    if (mouseNumber==3) {
                        if(floorMaps[28].getStatus()==0) {
                            floorMaps[28].setName("dicking.png");
                            floorMaps[28].setStatus(1);
                        }
                        else if(floorMaps[28].getStatus()==2){
                            floorMaps[28].setName("dickingwet.png");
                            floorMaps[28].setStatus(4);
                        }
                    }
                    else if(mouseNumber==6){
                        if(floorMaps[28].getStatus()==0){
                            floorMaps[28].setName("wetfloor.png");
                            floorMaps[28].setStatus(2);
                        }
                        else if(floorMaps[28].getStatus()==1){
                            floorMaps[28].setName("dickingwet.png");
                            floorMaps[28].setStatus(3);
                        }
                    }else if(mouseNumber==7){
                        floorMaps[28].getTree().setNameTree("weed.png");
                        floorMaps[28].getTree().setGrowthStatus(0);

                    }
                }
                else if(857<=player.getPosX() && player.getPosX()<=938 && player.getPosY()>=473 && player.getPosY()<=558){
                    if (mouseNumber==3) {
                        if(floorMaps[29].getStatus()==0) {
                            floorMaps[29].setName("dicking.png");
                            floorMaps[29].setStatus(1);
                        }
                        else if(floorMaps[29].getStatus()==2){
                            floorMaps[29].setName("dickingwet.png");
                            floorMaps[29].setStatus(4);
                        }
                    }
                    else if(mouseNumber==6){
                        if(floorMaps[29].getStatus()==0){
                            floorMaps[29].setName("wetfloor.png");
                            floorMaps[29].setStatus(2);
                        }
                        else if(floorMaps[29].getStatus()==1){
                            floorMaps[29].setName("dickingwet.png");
                            floorMaps[29].setStatus(3);
                        }
                    }else if(mouseNumber==7){
                        floorMaps[29].getTree().setNameTree("weed.png");
                        floorMaps[29].getTree().setGrowthStatus(0);

                    }
                }

                player.setMouseClicked(false);
            }


        }
        private void changeEffect(int mouse){
        switch (mouse){
            case 3:{
                sound2.stop();
                sound.play();
                break;
            }
            case 6:{
                sound2.play();
                sound.stop();
                break;
            }

        }

        }

    }
