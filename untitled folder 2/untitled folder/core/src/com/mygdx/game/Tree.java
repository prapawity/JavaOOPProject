package com.mygdx.game;

public class Tree {
    private String nameTree;
    private boolean ststusWatering;
    private int growthStatus;

    public Tree(String nameTree, boolean ststusWatering, int growthStatus) {
        this.nameTree = nameTree;
        this.ststusWatering = ststusWatering;
        this.growthStatus = growthStatus;
    }
    public Tree(){

    }

    public String getNameTree() {
        return nameTree;
    }

    public void setNameTree(String nameTree) {
        this.nameTree = nameTree;
    }

    public boolean isStstusWatering() {
        return ststusWatering;
    }

    public void setStstusWatering(boolean ststusWatering) {
        this.ststusWatering = ststusWatering;
    }

    public int getGrowthStatus() {
        return growthStatus;
    }

    public void setGrowthStatus(int growthStatus) {
        this.growthStatus = growthStatus;
    }
}
