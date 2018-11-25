package com.mygdx.game;

import com.badlogic.gdx.graphics.Camera;
import com.mygdx.game.entitirs.Player;

public class CameraMove {

    public void CameraMove(Camera camera, Player player, int status) {
        if (status == 0) {
            if (camera.position.x >= 642 && camera.position.y <=6820) {
                if (player.getPosX() <= 20 &&camera.position.x>642)
                    camera.position.set(camera.position.x - 3, camera.position.y, 0);
                else if (player.getPosX() >= 1250 && camera.position.x < 1470)
                    camera.position.set(camera.position.x + 3, camera.position.y, 0);
                else if (player.getPosY() <= 20 && camera.position.y<6820)
                    camera.position.set(camera.position.x, camera.position.y + 3, 0);
                else if (player.getPosY() >= 704 && camera.position.y>6350)
                    camera.position.set(camera.position.x, camera.position.y - 3, 0);

            }

        } else if (status == 2) {
            if (player.getPosX() <= 20)
                camera.position.set(camera.position.x - 3, camera.position.y, 0);
            else if (player.getPosX() >= 1250)
                camera.position.set(camera.position.x + 3, camera.position.y, 0);
            else if (player.getPosY() <= 20)
                camera.position.set(camera.position.x, camera.position.y + 3, 0);
            else if (player.getPosY() >= 704)
                camera.position.set(camera.position.x, camera.position.y - 3, 0);
        }
        camera.update();
    }
}
