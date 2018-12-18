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
            case 0:openSound = Gdx.audio.newMusic(Gdx.files.internal("GenerateMap/Sparkle.mp3"));break;
            case 1:openSound = Gdx.audio.newMusic(Gdx.files.internal("GenerateMap/BaseMusic.mp3"));break;
            case 2:openSound = Gdx.audio.newMusic(Gdx.files.internal("GenerateMap/PelicianTown.mp3"));break;
            case 3:openSound = Gdx.audio.newMusic(Gdx.files.internal("GenerateMap/FunFest.mp3"));break;
            case 4:openSound = Gdx.audio.newMusic(Gdx.files.internal("GenerateMap/SoundEffect/nightsound.mp3"));break;

        }
    }
}
