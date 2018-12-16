package com.mygdx.game;

import com.badlogic.gdx.graphics.Camera;

public class CameraMove {

    public void CameraMove(Camera camera,int caset) {
            if (camera.position.x >= 642 && camera.position.y <=6820) {
                switch (caset){
                    case 1:camera.position.set(642, 6820, 0);break;
                    case 2:camera.position.set(1470, 6349, 0);break;
                    case 3:camera.position.set(1470, 6820, 0);break;
                    case 4:camera.position.set(642, 6349, 0);break;
                }

            }

        camera.update();
    }
}
