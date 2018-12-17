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
            if (floorMaps.getTree().getNameTree().equals("tree/10/1.png") || floorMaps.getTree().getNameTree().equals("tree/10/4.png") ||
                    floorMaps.getTree().getNameTree().equals("tree/10/5.png")||floorMaps.getTree().getNameTree().equals("tree/10/6.png") ||
                    floorMaps.getTree().getNameTree().equals("tree/10/7.png")||floorMaps.getTree().getNameTree().equals("tree/10/8.png")){
                switch (floorMaps.getTree().getDay()) {
                    case 1:{
                        if (floorMaps.getTree().getGrowthStatus() == 0) {
                            floorMaps.getTree().setNameTree("deadtree.png");
                            floorMaps.getTree().setGrowthStatus(0);
                        } else {
                            floorMaps.getTree().setNameTree("tree/10/4.png");
                        }
                        break;
                    }
                    case 2:{
                        if (floorMaps.getTree().getGrowthStatus() < 5) floorMaps.getTree().setNameTree("deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() >= 5) floorMaps.getTree().setNameTree("tree/10/5.png");
                        break;
                    }
                    case 3:{
                        if (floorMaps.getTree().getGrowthStatus() < 7) floorMaps.getTree().setNameTree("deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() >= 10) floorMaps.getTree().setNameTree("tree/10/6.png");
                        break;
                    }
                    case 4:{
                        if (floorMaps.getTree().getGrowthStatus() < 12) floorMaps.getTree().setNameTree("deadtree.png");
                        else if (floorMaps.getTree().getGrowthStatus() >= 15) floorMaps.getTree().setNameTree("tree/10/7.png");
                        break;
                    }
                    case 6:{
                        floorMaps.getTree().setNameTree("deadtree.png");
                        floorMaps.getTree().setGrowthStatus(0);
                        break;
                    }
                }
                System.out.println(floorMaps.getTree().getGrowthStatus()+"  "+floorMaps.getTree().getDay());
            }

        }

}
