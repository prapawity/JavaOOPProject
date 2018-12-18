package com.mygdx.game;

import java.io.*;

public class SaveGame {
    static SaveObject saveObject;
    public static void write(SaveObject saveObject){
        try {
            FileOutputStream fos = new FileOutputStream("save/file.bat");
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
        fin = new FileInputStream("save/file.bat");
        oin = new ObjectInputStream(fin);
        saveObject = (SaveObject) oin.readObject();
        oin.close();
        fin.close();
    }
}
