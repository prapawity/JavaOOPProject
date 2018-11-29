package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class ChangeSound {
    Music openSound;
    public void create(){
        changeSound(0);
        openSound.setLooping(true);
    }

    public void changeSound(int type){
        switch (type){
            case 0:openSound = Gdx.audio.newMusic(Gdx.files.internal("Sparkle.mp3"));break;
            case 1:openSound = Gdx.audio.newMusic(Gdx.files.internal("BaseMusic.mp3"));break;
            case 2:openSound = Gdx.audio.newMusic(Gdx.files.internal("PelicianTown.mp3"));break;
            case 3:openSound = Gdx.audio.newMusic(Gdx.files.internal("FunFest.mp3"));break;
            case 4:openSound = Gdx.audio.newMusic(Gdx.files.internal("SoundEffect/nightsound.mp3"));break;

        }
    }
}
