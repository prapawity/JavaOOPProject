package com.mygdx.game;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveGame {
    static SaveObject saveObject;
    public static void write(SaveObject saveObject){
        try {
            FileOutputStream fos = new FileOutputStream("file.bat");
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
        fin = new FileInputStream("file.bat");
        oin = new ObjectInputStream(fin);
        saveObject = (SaveObject) oin.readObject();
        oin.close();
        fin.close();
    }
}
