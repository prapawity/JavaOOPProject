package com.mygdx.game;

public class FloorStatus {
    private String name;
    private int status;
    private Tree tree;

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }

    public FloorStatus(String name, int status, Tree tree) {
        this.name = name;
        this.status = status;
        this.tree = tree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
