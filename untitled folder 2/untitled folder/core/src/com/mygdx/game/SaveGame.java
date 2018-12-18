package com.mygdx.game;

import com.badlogic.gdx.Gdx;

import java.io.*;

public class SaveGame {
    static SaveObject saveObject;
    public static void write(SaveObject saveObject){
        try {
            FileOutputStream fos = new FileOutputStream(Gdx.files.internal("GenerateMap/save/file.bat").toString());
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(saveObject);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SaveObject getSaveObject() {
        return saveObject;
    }

    public static void read() throws Exception{
        FileInputStream fin;
        ObjectInputStream oin;
        fin = new FileInputStream(Gdx.files.internal("GenerateMap/save/file.bat").toString());
        oin = new ObjectInputStream(fin);
        saveObject = (SaveObject) oin.readObject();
        oin.close();
        fin.close();
    }
}
