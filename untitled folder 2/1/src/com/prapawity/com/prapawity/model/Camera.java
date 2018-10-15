package com.prapawity.com.prapawity.model;

public class Camera {
    private float cameraX;
    private float cameraY;
    public void update(float newCamX, float newCamY){
        this.cameraX = newCamX;
        this.cameraY = newCamY;
    }

    public float getCameraX() {
        return cameraX;
    }

    public void setCameraX(float cameraX) {
        this.cameraX = cameraX;
    }

    public float getCameraY() {
        return cameraY;
    }

    public void setCameraY(float cameraY) {
        this.cameraY = cameraY;
    }
}
