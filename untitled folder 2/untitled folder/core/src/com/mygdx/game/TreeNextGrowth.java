package com.mygdx.game;

public class TreeNextGrowth {
    public void growth(FloorStatus[] floorMap,FloorStatus[] floorMap2,FloorStatus[] floorMap3,FloorStatus[] floorMap4,int day){
        for (int i = 0 ; i<30;i++){
            setEiei(floorMap[i]);
            setEiei(floorMap2[i]);
            setEiei(floorMap3[i]);
            setEiei(floorMap4[i]);
        }
    }
    public void setEiei(FloorStatus floorMaps){
        floorMaps.getTree().addDay(1);
            if (floorMaps.getTree().getNameTree().equals("GenerateMap/tree/10/1.png") || floorMaps.getTree().getNameTree().equals("GenerateMap/tree/10/4.png") ||
                    floorMaps.getTree().getNameTree().equals("GenerateMap/tree/10/5.png")||floorMaps.getTree().getNameTree().equals("GenerateMap/tree/10/6.png") ||
                    floorMaps.getTree().getNameTree().equals("GenerateMap/tree/10/7.png")||floorMaps.getTree().getNameTree().equals("GenerateMap/tree/10/8.png")){
                switch (floorMaps.getTree().getDay()) {
                    case 1:{
                        if (floorMaps.getTree().getGrowthStatus() == 0 || floorMaps.getTree().getGrowthStatus()>10) {
                            floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                            floorMaps.getTree().setGrowthStatus(0);
                        } else if (floorMaps.getTree().getGrowthStatus()>=5){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/10/4.png");
                            floorMaps.getTree().setGrowthStatus(5);
                        }
                        break;
                    }
                    case 2:{

                        if (floorMaps.getTree().getGrowthStatus() <= 0 || floorMaps.getTree().getGrowthStatus()>15) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() <10 && floorMaps.getTree().getGrowthStatus()>=5){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/10/4.png");
                            floorMaps.getTree().setGrowthStatus(5);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 10) {
                            floorMaps.getTree().setNameTree("GenerateMap/tree/10/5.png");
                            floorMaps.getTree().setGrowthStatus(10);
                        }
                        break;
                    }
                    case 3:{
                        if (floorMaps.getTree().getGrowthStatus() < 5 || floorMaps.getTree().getGrowthStatus()>20) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() <10 && floorMaps.getTree().getGrowthStatus()>=5){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/10/4.png");
                            floorMaps.getTree().setGrowthStatus(5);

                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 10 && floorMaps.getTree().getGrowthStatus()<15){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/10/5.png");
                            floorMaps.getTree().setGrowthStatus(10);

                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 15){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/10/6.png");
                            floorMaps.getTree().setGrowthStatus(15);

                        }
                        break;
                    }
                    case 4:{
                        if (floorMaps.getTree().getGrowthStatus() < 10 || floorMaps.getTree().getGrowthStatus()>30) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() == 10) floorMaps.getTree().setNameTree("GenerateMap/tree/10/5.png");
                        else if (floorMaps.getTree().getGrowthStatus() == 15) floorMaps.getTree().setNameTree("GenerateMap/tree/10/6.png");
                        else if (floorMaps.getTree().getGrowthStatus() >= 20) floorMaps.getTree().setNameTree("GenerateMap/tree/10/7.png");
                        break;
                    }
                    case 6:{
                        floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        floorMaps.getTree().setGrowthStatus(0);
                        break;
                    }
                }
            }
            else if (floorMaps.getTree().getNameTree().equals("GenerateMap/tree/2/1.png")|| floorMaps.getTree().getNameTree().equals("GenerateMap/tree/2/3.png") || floorMaps.getTree().getNameTree().equals("GenerateMap/tree/2/4.png") ||
                    floorMaps.getTree().getNameTree().equals("GenerateMap/tree/2/5.png")||floorMaps.getTree().getNameTree().equals("GenerateMap/tree/2/6.png") ||
                    floorMaps.getTree().getNameTree().equals("GenerateMap/tree/2/7.png")||floorMaps.getTree().getNameTree().equals("GenerateMap/tree/2/8.png")){
                switch (floorMaps.getTree().getDay()) {
                    case 1:{
                        if (floorMaps.getTree().getGrowthStatus() == 0 || floorMaps.getTree().getGrowthStatus()>10) {
                            floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                            floorMaps.getTree().setGrowthStatus(0);
                        } else if (floorMaps.getTree().getGrowthStatus()>=5){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/2/3.png");
                            floorMaps.getTree().setGrowthStatus(5);
                        }
                        break;
                    }
                    case 2:{
                        if (floorMaps.getTree().getGrowthStatus() == 0 || floorMaps.getTree().getGrowthStatus()>20) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() <10 && floorMaps.getTree().getGrowthStatus()>=5){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/2/3.png");
                            floorMaps.getTree().setGrowthStatus(5);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 10) {
                            floorMaps.getTree().setNameTree("GenerateMap/tree/2/4.png");
                            floorMaps.getTree().setGrowthStatus(10);
                        }
                        break;
                    }
                    case 3:{
                        if (floorMaps.getTree().getGrowthStatus() < 5 || floorMaps.getTree().getGrowthStatus()>25) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() <10 && floorMaps.getTree().getGrowthStatus()>=5){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/2/3.png");
                            floorMaps.getTree().setGrowthStatus(5);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 10 && floorMaps.getTree().getGrowthStatus()<15){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/2/4.png");
                            floorMaps.getTree().setGrowthStatus(10);

                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 15){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/2/5.png");
                            floorMaps.getTree().setGrowthStatus(15);
                        }
                        break;
                    }
                    case 4:{
                        if (floorMaps.getTree().getGrowthStatus() < 10 || floorMaps.getTree().getGrowthStatus()>30) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() >=10 && floorMaps.getTree().getGrowthStatus()<15){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/2/4.png");
                            floorMaps.getTree().setGrowthStatus(10);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() < 20 && floorMaps.getTree().getGrowthStatus()>=15){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/2/5.png");
                            floorMaps.getTree().setGrowthStatus(15);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 20){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/2/6.png");
                            floorMaps.getTree().setGrowthStatus(20);
                        }
                        break;
                    }
                    case 5:{
                        if (floorMaps.getTree().getGrowthStatus() < 15 || floorMaps.getTree().getGrowthStatus()>35) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() <20 && floorMaps.getTree().getGrowthStatus()>=15){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/2/5.png");
                            floorMaps.getTree().setGrowthStatus(5);

                        }
                        else if (floorMaps.getTree().getGrowthStatus() < 25 && floorMaps.getTree().getGrowthStatus()>=20){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/2/6.png");
                            floorMaps.getTree().setGrowthStatus(10);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 25){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/2/7.png");
                            floorMaps.getTree().setGrowthStatus(25);
                        }
                        break;
                    }
                    case 6:{
                        if (floorMaps.getTree().getGrowthStatus() < 20 || floorMaps.getTree().getGrowthStatus()>40) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() <25 && floorMaps.getTree().getGrowthStatus()>=20){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/2/6.png");
                            floorMaps.getTree().setGrowthStatus(5);

                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 25 && floorMaps.getTree().getGrowthStatus()<30){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/2/7.png");
                            floorMaps.getTree().setGrowthStatus(10);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 30){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/2/8.png");
                            floorMaps.getTree().setGrowthStatus(30);
                        }
                        break;
                    }
                    case 8:{
                        floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        floorMaps.getTree().setGrowthStatus(0);
                        break;
                    }
                }
            }
            else if (floorMaps.getTree().getNameTree().equals("GenerateMap/tree/11/1.png")|| floorMaps.getTree().getNameTree().equals("GenerateMap/tree/11/2.png")||
                    floorMaps.getTree().getNameTree().equals("GenerateMap/tree/11/3.png") || floorMaps.getTree().getNameTree().equals("GenerateMap/tree/11/4.png") ||
                    floorMaps.getTree().getNameTree().equals("GenerateMap/tree/11/5.png")||floorMaps.getTree().getNameTree().equals("GenerateMap/tree/11/6.png") ||
                    floorMaps.getTree().getNameTree().equals("GenerateMap/tree/11/7.png")||floorMaps.getTree().getNameTree().equals("GenerateMap/tree/11/8.png")){
                switch (floorMaps.getTree().getDay()) {
                    case 1:{
                        if (floorMaps.getTree().getGrowthStatus() == 0 || floorMaps.getTree().getGrowthStatus()>10) {
                            floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                            floorMaps.getTree().setGrowthStatus(0);
                        } else if (floorMaps.getTree().getGrowthStatus()>=5){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/11/1.png");
                            floorMaps.getTree().setGrowthStatus(5);
                        }
                        break;
                    }
                    case 2:{
                        if (floorMaps.getTree().getGrowthStatus() <= 0 || floorMaps.getTree().getGrowthStatus()>15) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() <10 && floorMaps.getTree().getGrowthStatus()>=5){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/11/1.png");
                            floorMaps.getTree().setGrowthStatus(5);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 10) {
                            floorMaps.getTree().setNameTree("GenerateMap/tree/11/2.png");
                            floorMaps.getTree().setGrowthStatus(10);
                        }
                        break;
                    }
                    case 3:{
                        if (floorMaps.getTree().getGrowthStatus() < 5 || floorMaps.getTree().getGrowthStatus()>20) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() <10 && floorMaps.getTree().getGrowthStatus()>=5){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/11/1.png");
                            floorMaps.getTree().setGrowthStatus(5);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 10 && floorMaps.getTree().getGrowthStatus()<15){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/11/2.png");
                            floorMaps.getTree().setGrowthStatus(10);

                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 15){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/11/3.png");
                            floorMaps.getTree().setGrowthStatus(15);
                        }
                        break;
                    }
                    case 4:{
                        if (floorMaps.getTree().getGrowthStatus() < 10 || floorMaps.getTree().getGrowthStatus()>30) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() >=10 && floorMaps.getTree().getGrowthStatus()<15){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/11/2.png");
                            floorMaps.getTree().setGrowthStatus(10);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() < 20 && floorMaps.getTree().getGrowthStatus()>=15){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/11/3.png");
                            floorMaps.getTree().setGrowthStatus(15);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 20){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/11/4.png");
                            floorMaps.getTree().setGrowthStatus(20);
                        }
                        break;
                    }
                    case 5:{
                        if (floorMaps.getTree().getGrowthStatus() < 15 || floorMaps.getTree().getGrowthStatus()>35) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() <20 && floorMaps.getTree().getGrowthStatus()>=15){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/11/4.png");
                            floorMaps.getTree().setGrowthStatus(15);

                        }
                        else if (floorMaps.getTree().getGrowthStatus() < 25 && floorMaps.getTree().getGrowthStatus()>=20){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/11/4.png");
                            floorMaps.getTree().setGrowthStatus(20);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 25){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/11/5.png");
                            floorMaps.getTree().setGrowthStatus(25);
                        }
                        break;
                    }
                    case 6:{
                        if (floorMaps.getTree().getGrowthStatus() < 20 || floorMaps.getTree().getGrowthStatus()>40) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() <25 && floorMaps.getTree().getGrowthStatus()>=20){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/11/4.png");
                            floorMaps.getTree().setGrowthStatus(20);

                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 25 && floorMaps.getTree().getGrowthStatus()<30){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/11/5.png");
                            floorMaps.getTree().setGrowthStatus(25);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 30){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/11/6.png");
                            floorMaps.getTree().setGrowthStatus(30);
                        }
                        break;
                    }
                    case 7:{
                        if (floorMaps.getTree().getGrowthStatus() < 20 || floorMaps.getTree().getGrowthStatus()>45) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() <30 && floorMaps.getTree().getGrowthStatus()>=25){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/11/5.png");
                            floorMaps.getTree().setGrowthStatus(20);

                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 30 && floorMaps.getTree().getGrowthStatus()<35){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/11/6.png");
                            floorMaps.getTree().setGrowthStatus(30);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 35){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/11/7.png");
                            floorMaps.getTree().setGrowthStatus(35);
                        }
                        break;
                    }
                    case 8:{
                        if (floorMaps.getTree().getGrowthStatus() < 20 || floorMaps.getTree().getGrowthStatus()>50) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() <35 && floorMaps.getTree().getGrowthStatus()>=30){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/11/6.png");
                            floorMaps.getTree().setGrowthStatus(30);

                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 35 && floorMaps.getTree().getGrowthStatus()<45){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/11/7.png");
                            floorMaps.getTree().setGrowthStatus(40);
                        }
                        break;
                    }
                    case 9:{
                        if (floorMaps.getTree().getGrowthStatus() < 20 || floorMaps.getTree().getGrowthStatus()>55) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() <35 && floorMaps.getTree().getGrowthStatus()>=30){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/11/6.png");
                            floorMaps.getTree().setGrowthStatus(5);

                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 35 && floorMaps.getTree().getGrowthStatus()<45){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/11/7.png");
                            floorMaps.getTree().setGrowthStatus(40);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 45){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/11/8.png");
                            floorMaps.getTree().setGrowthStatus(45);
                        }
                        break;
                    }
                    case 11:{
                        floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        floorMaps.getTree().setGrowthStatus(0);
                        break;
                    }
                }
            }
            else if (floorMaps.getTree().getNameTree().equals("GenerateMap/tree/12/1.png")|| floorMaps.getTree().getNameTree().equals("GenerateMap/tree/12/2.png")||
                    floorMaps.getTree().getNameTree().equals("GenerateMap/tree/12/3.png") || floorMaps.getTree().getNameTree().equals("GenerateMap/tree/12/4.png") ||
                    floorMaps.getTree().getNameTree().equals("GenerateMap/tree/12/5.png")||floorMaps.getTree().getNameTree().equals("GenerateMap/tree/12/6.png") ||
                    floorMaps.getTree().getNameTree().equals("GenerateMap/tree/12/7.png") || floorMaps.getTree().getNameTree().equals("GenerateMap/tree/12/8.png")||
                    floorMaps.getTree().getNameTree().equals("GenerateMap/tree/12/9.png")) {
                switch (floorMaps.getTree().getDay()) {
                    case 1:{
                        if (floorMaps.getTree().getGrowthStatus() == 0 || floorMaps.getTree().getGrowthStatus()>10) {
                            floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                            floorMaps.getTree().setGrowthStatus(0);
                        } else if (floorMaps.getTree().getGrowthStatus()>=5){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/12/3.png");
                            floorMaps.getTree().setGrowthStatus(5);
                        }
                        break;
                    }
                    case 2:{
                        if (floorMaps.getTree().getGrowthStatus() < 5 || floorMaps.getTree().getGrowthStatus()>15) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() <10 && floorMaps.getTree().getGrowthStatus()>=5){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/12/3.png");
                            floorMaps.getTree().setGrowthStatus(5);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 10 && floorMaps.getTree().getGrowthStatus()<15){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/12/4.png");
                            floorMaps.getTree().setGrowthStatus(10);
                        }
                        break;
                    }
                    case 3:{
                        if (floorMaps.getTree().getGrowthStatus() < 5 || floorMaps.getTree().getGrowthStatus()>20) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() >=5 && floorMaps.getTree().getGrowthStatus()<10){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/12/3.png");
                            floorMaps.getTree().setGrowthStatus(5);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() < 15 && floorMaps.getTree().getGrowthStatus()>=10){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/12/4.png");
                            floorMaps.getTree().setGrowthStatus(10);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 15 && floorMaps.getTree().getGrowthStatus()<20){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/12/5.png");
                            floorMaps.getTree().setGrowthStatus(15);
                        }
                        break;
                    }
                    case 4:{
                        if (floorMaps.getTree().getGrowthStatus() < 10 || floorMaps.getTree().getGrowthStatus()>25) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() >=10 && floorMaps.getTree().getGrowthStatus()<15){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/12/4.png");
                            floorMaps.getTree().setGrowthStatus(10);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() < 20 && floorMaps.getTree().getGrowthStatus()>=15){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/12/5.png");
                            floorMaps.getTree().setGrowthStatus(15);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 20 && floorMaps.getTree().getGrowthStatus()<25){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/12/6.png");
                            floorMaps.getTree().setGrowthStatus(20);
                        }
                        break;
                    }
                    case 5:{
                        if (floorMaps.getTree().getGrowthStatus() < 15 || floorMaps.getTree().getGrowthStatus()>30) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() >=15 && floorMaps.getTree().getGrowthStatus()<20){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/12/5.png");
                            floorMaps.getTree().setGrowthStatus(15);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() < 25 && floorMaps.getTree().getGrowthStatus()>=20){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/12/6.png");
                            floorMaps.getTree().setGrowthStatus(20);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 25 && floorMaps.getTree().getGrowthStatus()<30){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/12/7.png");
                            floorMaps.getTree().setGrowthStatus(25);
                        }
                        break;
                    }
                    case 6:{
                        if (floorMaps.getTree().getGrowthStatus() < 20 || floorMaps.getTree().getGrowthStatus()>35) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() >=20 && floorMaps.getTree().getGrowthStatus()<25){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/12/6.png");
                            floorMaps.getTree().setGrowthStatus(20);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() < 30 && floorMaps.getTree().getGrowthStatus()>=25){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/12/7.png");
                            floorMaps.getTree().setGrowthStatus(25);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 30 && floorMaps.getTree().getGrowthStatus()<35){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/12/8.png");
                            floorMaps.getTree().setGrowthStatus(30);
                        }
                        break;
                    }
                    case 7:{
                        if (floorMaps.getTree().getGrowthStatus() < 25 || floorMaps.getTree().getGrowthStatus()>40) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() >=25 && floorMaps.getTree().getGrowthStatus()<30){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/12/7.png");
                            floorMaps.getTree().setGrowthStatus(35);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() < 35 && floorMaps.getTree().getGrowthStatus()>=30){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/12/8.png");
                            floorMaps.getTree().setGrowthStatus(30);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 35 && floorMaps.getTree().getGrowthStatus()<40){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/12/9.png");
                            floorMaps.getTree().setGrowthStatus(35);
                        }
                        break;
                    }
                    case 9:{
                        floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        floorMaps.getTree().setGrowthStatus(0);
                        break;
                    }
                }
            }
            else if (floorMaps.getTree().getNameTree().equals("GenerateMap/tree/13/1.png")|| floorMaps.getTree().getNameTree().equals("GenerateMap/tree/13/2.png")||
                    floorMaps.getTree().getNameTree().equals("GenerateMap/tree/13/3.png") || floorMaps.getTree().getNameTree().equals("GenerateMap/tree/13/4.png") ||
                    floorMaps.getTree().getNameTree().equals("GenerateMap/tree/13/5.png")||floorMaps.getTree().getNameTree().equals("GenerateMap/tree/13/6.png") ||
                    floorMaps.getTree().getNameTree().equals("GenerateMap/tree/13/7.png")||floorMaps.getTree().getNameTree().equals("GenerateMap/tree/13/8.png")
                    ||floorMaps.getTree().getNameTree().equals("GenerateMap/tree/13/9.png")) {
                System.out.println(floorMaps.getTree().getGrowthStatus());
                switch (floorMaps.getTree().getDay()) {
                    case 1:{
                        if (floorMaps.getTree().getGrowthStatus() == 0 || floorMaps.getTree().getGrowthStatus()>10) {
                            floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                            floorMaps.getTree().setGrowthStatus(0);
                        } else if (floorMaps.getTree().getGrowthStatus()>=5){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/1.png");
                            floorMaps.getTree().setGrowthStatus(5);
                        }
                        break;
                    }
                    case 2:{
                        if (floorMaps.getTree().getGrowthStatus() < 5 || floorMaps.getTree().getGrowthStatus()>15) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() <10 && floorMaps.getTree().getGrowthStatus()>=5){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/1.png");
                            floorMaps.getTree().setGrowthStatus(5);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 10 && floorMaps.getTree().getGrowthStatus()<15){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/1.png");
                            floorMaps.getTree().setGrowthStatus(10);
                        }
                        break;
                    }
                    case 3:{
                        if (floorMaps.getTree().getGrowthStatus() < 5 || floorMaps.getTree().getGrowthStatus()>20) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() >=5 && floorMaps.getTree().getGrowthStatus()<10){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/1.png");
                            floorMaps.getTree().setGrowthStatus(5);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() < 15 && floorMaps.getTree().getGrowthStatus()>=10){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/1.png");
                            floorMaps.getTree().setGrowthStatus(10);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 15 && floorMaps.getTree().getGrowthStatus()<20){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/2.png");
                            floorMaps.getTree().setGrowthStatus(15);
                        }
                        break;
                    }
                    case 4:{
                        if (floorMaps.getTree().getGrowthStatus() < 10 || floorMaps.getTree().getGrowthStatus()>25) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() >=10 && floorMaps.getTree().getGrowthStatus()<15){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/1.png");
                            floorMaps.getTree().setGrowthStatus(10);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() < 20 && floorMaps.getTree().getGrowthStatus()>=15){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/2.png");
                            floorMaps.getTree().setGrowthStatus(15);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 20 && floorMaps.getTree().getGrowthStatus()<25){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/2.png");
                            floorMaps.getTree().setGrowthStatus(20);
                        }
                        break;
                    }
                    case 5:{
                        if (floorMaps.getTree().getGrowthStatus() < 15 || floorMaps.getTree().getGrowthStatus()>30) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() >=15 && floorMaps.getTree().getGrowthStatus()<20){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/2.png");
                            floorMaps.getTree().setGrowthStatus(10);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() < 25 && floorMaps.getTree().getGrowthStatus()>=20){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/2.png");
                            floorMaps.getTree().setGrowthStatus(15);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 25 && floorMaps.getTree().getGrowthStatus()<30){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/3.png");
                            floorMaps.getTree().setGrowthStatus(25);
                        }
                        break;
                    }
                    case 6:{
                        if (floorMaps.getTree().getGrowthStatus() < 20 || floorMaps.getTree().getGrowthStatus()>35) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() >=20 && floorMaps.getTree().getGrowthStatus()<25){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/2.png");
                            floorMaps.getTree().setGrowthStatus(20);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() < 30 && floorMaps.getTree().getGrowthStatus()>=25){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/3.png");
                            floorMaps.getTree().setGrowthStatus(25);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 30 && floorMaps.getTree().getGrowthStatus()<35){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/3.png");
                            floorMaps.getTree().setGrowthStatus(30);
                        }
                        break;
                    }
                    case 7:{
                        if (floorMaps.getTree().getGrowthStatus() < 25 || floorMaps.getTree().getGrowthStatus()>40) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() >=25 && floorMaps.getTree().getGrowthStatus()<30){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/3.png");
                            floorMaps.getTree().setGrowthStatus(25);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() < 35 && floorMaps.getTree().getGrowthStatus()>=30){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/3.png");
                            floorMaps.getTree().setGrowthStatus(30);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 35 && floorMaps.getTree().getGrowthStatus()<40){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/4.png");
                            floorMaps.getTree().setGrowthStatus(35);
                        }
                        break;
                    }
                    case 8:{
                        if (floorMaps.getTree().getGrowthStatus() < 30 || floorMaps.getTree().getGrowthStatus()>45) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() >=30 && floorMaps.getTree().getGrowthStatus()<35){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/3.png");
                            floorMaps.getTree().setGrowthStatus(30);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() < 40 && floorMaps.getTree().getGrowthStatus()>=35){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/4.png");
                            floorMaps.getTree().setGrowthStatus(35);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 40 && floorMaps.getTree().getGrowthStatus()<45){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/4.png");
                            floorMaps.getTree().setGrowthStatus(40);
                        }
                        break;
                    }
                    case 9:{
                        if (floorMaps.getTree().getGrowthStatus() < 35 || floorMaps.getTree().getGrowthStatus()>50) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() >=35 && floorMaps.getTree().getGrowthStatus()<40){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/4.png");
                            floorMaps.getTree().setGrowthStatus(35);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() < 45 && floorMaps.getTree().getGrowthStatus()>=40){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/4.png");
                            floorMaps.getTree().setGrowthStatus(40);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 45 && floorMaps.getTree().getGrowthStatus()<50){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/5.png");
                            floorMaps.getTree().setGrowthStatus(45);
                        }
                        break;
                    }
                    case 10:{
                        if (floorMaps.getTree().getGrowthStatus() < 40 || floorMaps.getTree().getGrowthStatus()>50) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() >=40 && floorMaps.getTree().getGrowthStatus()<45){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/4.png");
                            floorMaps.getTree().setGrowthStatus(40);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() < 50 && floorMaps.getTree().getGrowthStatus()>=45){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/5.png");
                            floorMaps.getTree().setGrowthStatus(45);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 50 && floorMaps.getTree().getGrowthStatus()<55){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/5.png");
                            floorMaps.getTree().setGrowthStatus(50);
                        }
                        break;
                    }
                    case 11:{
                        if (floorMaps.getTree().getGrowthStatus() < 45 || floorMaps.getTree().getGrowthStatus()>55) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() >=45 && floorMaps.getTree().getGrowthStatus()<50){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/4.png");
                            floorMaps.getTree().setGrowthStatus(45);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() < 55 && floorMaps.getTree().getGrowthStatus()>=50){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/5.png");
                            floorMaps.getTree().setGrowthStatus(50);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 55 && floorMaps.getTree().getGrowthStatus()<60){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/5.png");
                            floorMaps.getTree().setGrowthStatus(55);
                        }
                        break;
                    }
                    case 12:{
                        if (floorMaps.getTree().getGrowthStatus() < 45 || floorMaps.getTree().getGrowthStatus()>55) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() >=50 && floorMaps.getTree().getGrowthStatus()<55){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/4.png");
                            floorMaps.getTree().setGrowthStatus(50);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() < 60 && floorMaps.getTree().getGrowthStatus()>=55){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/5.png");
                            floorMaps.getTree().setGrowthStatus(55);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 60 && floorMaps.getTree().getGrowthStatus()<65){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/5.png");
                            floorMaps.getTree().setGrowthStatus(60);
                        }
                        break;
                    }
                    case 13:{
                        if (floorMaps.getTree().getGrowthStatus() < 45 || floorMaps.getTree().getGrowthStatus()>55) floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() >=55 && floorMaps.getTree().getGrowthStatus()<60){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/4.png");
                            floorMaps.getTree().setGrowthStatus(55);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() < 65 && floorMaps.getTree().getGrowthStatus()>=60){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/5.png");
                            floorMaps.getTree().setGrowthStatus(60);
                        }
                        else if (floorMaps.getTree().getGrowthStatus() >= 65 && floorMaps.getTree().getGrowthStatus()<70){
                            floorMaps.getTree().setNameTree("GenerateMap/tree/13/5.png");
                            floorMaps.getTree().setGrowthStatus(65);
                        }
                        break;
                    }
                    case 15:{
                        floorMaps.getTree().setNameTree("GenerateMap/deadtree.png");
                        floorMaps.getTree().setGrowthStatus(0);
                        break;
                    }
                }
            }

        }

}
