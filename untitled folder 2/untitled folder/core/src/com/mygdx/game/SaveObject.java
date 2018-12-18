package com.mygdx.game;

import java.io.Serializable;
import java.util.ArrayList;

public class SaveObject implements Serializable {
    int day,money;
    FloorStatus[] floormap,floormap2,floormap3,floormap4;
    ArrayList<SlotBag> slotBags;
    static int days,moneys;
    static FloorStatus[] floormaps,floormaps2,floormaps3,floormaps4;
    static ArrayList<SlotBag> slotBagsz;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public FloorStatus[] getFloormap() {
        return floormap;
    }

    public void setFloormap(FloorStatus[] floormap) {
        this.floormap = floormap;
    }

    public FloorStatus[] getFloormap2() {
        return floormap2;
    }

    public void setFloormap2(FloorStatus[] floormap2) {
        this.floormap2 = floormap2;
    }

    public FloorStatus[] getFloormap3() {
        return floormap3;
    }

    public void setFloormap3(FloorStatus[] floormap3) {
        this.floormap3 = floormap3;
    }

    public FloorStatus[] getFloormap4() {
        return floormap4;
    }

    public void setFloormap4(FloorStatus[] floormap4) {
        this.floormap4 = floormap4;
    }

    public ArrayList<SlotBag> getSlotBags() {
        return slotBags;
    }

    public void setSlotBags(ArrayList<SlotBag> slotBags) {
        this.slotBags = slotBags;
    }

    public static int getDays() {
        return days;
    }

    public static void setDays(int days) {
        SaveObject.days = days;
    }

    public static int getMoneys() {
        return moneys;
    }

    public static void setMoneys(int moneys) {
        SaveObject.moneys = moneys;
    }

    public static FloorStatus[] getFloormaps() {
        return floormaps;
    }

    public static void setFloormaps(FloorStatus[] floormaps) {
        SaveObject.floormaps = floormaps;
    }

    public static FloorStatus[] getFloormaps2() {
        return floormaps2;
    }

    public static void setFloormaps2(FloorStatus[] floormaps2) {
        SaveObject.floormaps2 = floormaps2;
    }

    public static FloorStatus[] getFloormaps3() {
        return floormaps3;
    }

    public static void setFloormaps3(FloorStatus[] floormaps3) {
        SaveObject.floormaps3 = floormaps3;
    }

    public static FloorStatus[] getFloormaps4() {
        return floormaps4;
    }

    public static void setFloormaps4(FloorStatus[] floormaps4) {
        SaveObject.floormaps4 = floormaps4;
    }

    public static ArrayList<SlotBag> getSlotBagsz() {
        return slotBagsz;
    }

    public static void setSlotBagsz(ArrayList<SlotBag> slotBagsz) {
        SaveObject.slotBagsz = slotBagsz;
    }

    public SaveObject() {
    }


    public SaveObject(int day, int money, FloorStatus[] floormap, FloorStatus[] floormap2, FloorStatus[] floormap3, FloorStatus[] floormap4, ArrayList<SlotBag> slotBags) {
        this.day = day;
        this.money = money;
        this.floormap = floormap;
        this.floormap2 = floormap2;
        this.floormap3 = floormap3;
        this.floormap4 = floormap4;
        this.slotBags = slotBags;

        days = day;
        moneys = money;
        floormaps = floormap;
        floormaps2 = floormap2;
        floormaps3 = floormap3;
        floormaps4 = floormap4;
        slotBagsz = slotBags;
    }
}
