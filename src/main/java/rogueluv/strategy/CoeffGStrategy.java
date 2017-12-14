package rogueluv.strategy;

import java.util.ArrayList;

import rogueluv.framework.Random;
import rogueluv.framework.Size;
import rogueluv.framework.Vector2;

import rogueluv.model.*;

public abstract class CoeffGStrategy implements IGStrategy {
    protected float coeffGMonster = 5;
    protected float coeffGPotion = 4;
    protected float coeffGStairs = 3;
    protected float coeffGTreasure = 4;
    protected float coeffGVoid = 20;

    protected int maxFloor = 10;
    protected int maxStairs = 3;
    protected int minWidth = 10;
    protected int maxWidth = 15;
    protected int minHeight = 5;
    protected int maxHeight = 10;
    protected int floorWidth = 10;
    protected int floorHeight = 10;

    protected int minPlayerStrength = 80;
    protected int maxPlayerStrength = 120;

    protected int minMonsterGold = 10;
    protected int maxMonsterGold = 15;
    protected int minMonsterStrength = 5;
    protected int maxMonsterStrength = 15;
    protected int minPotionStats = -5;
    protected int maxPotionStats = +10;
    protected int minTreasureGold = 10;
    protected int maxTreasureGold = 15;

    public CoeffGStrategy() {

    }

    public abstract Floor generateFloors();

    public abstract int generatePlayerStrength();

    public float getCoeffGsNormal() {
        return coeffGMonster + coeffGPotion + coeffGTreasure + coeffGVoid;
    }


    public void setCoeffGMonster(float coeffGMonster) {
        this.coeffGMonster = coeffGMonster;
    }

    public float getCoeffGMonster() {
        return coeffGMonster;
    }

    public void setCoeffGPotion(float coeffGPotion) {
        this.coeffGPotion = coeffGPotion;
    }

    public float getCoeffGPotion() {
        return coeffGPotion;
    }

    public void setCoeffGStairs(float coeffGStairs) {
        this.coeffGStairs = coeffGStairs;
    }

    public float getCoeffGStairs() {
        return coeffGStairs;
    }

    public void setCoeffGTreasure(float coeffGTreasure) {
        this.coeffGTreasure = coeffGTreasure;
    }

    public float getCoeffGTreasure() {
        return coeffGTreasure;
    }

    public void setCoeffGVoid(float coeffGVoid) {
        this.coeffGVoid = coeffGVoid;
    }

    public float getCoeffGVoid() {
        return coeffGVoid;
    }

    public void setMaxFloor(int maxFloor) {
        this.maxFloor = maxFloor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public void setMaxStairs(int maxStairs) {
        this.maxStairs = maxStairs;
    }

    public int getMaxStairs() {
        return maxStairs;
    }

    public void setMinWidth(int minWidth) {
        this.minWidth = minWidth;
    }

    public int getMinWidth() {
        return minWidth;
    }

    public void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setFloorWidth(int floorWidth) {
        this.floorWidth = floorWidth;
    }

    public int getFloorWidth() {
        return floorWidth;
    }

    public void setFloorHeight(int floorHeight) {
        this.floorHeight = floorHeight;
    }

    public int getFloorHeight() {
        return floorHeight;
    }

    public void setMinPlayerStrength(int minPlayerStrength) {
        this.minPlayerStrength = minPlayerStrength;
    }

    public int getMinPlayerStrength() {
        return minPlayerStrength;
    }

    public void setMaxPlayerStrength(int maxPlayerStrength) {
        this.maxPlayerStrength = maxPlayerStrength;
    }

    public int getMaxPlayerStrength() {
        return maxPlayerStrength;
    }

    public void setMinMonsterGold(int minMonsterGold) {
        this.minMonsterGold = minMonsterGold;
    }

    public int getMinMonsterGold() {
        return minMonsterGold;
    }

    public void setMaxMonsterGold(int maxMonsterGold) {
        this.maxMonsterGold = maxMonsterGold;
    }

    public int getMaxMonsterGold() {
        return maxMonsterGold;
    }

    public void setMinMonsterStrength(int minMonsterStrength) {
        this.minMonsterStrength = minMonsterStrength;
    }

    public int getMinMonsterStrength() {
        return minMonsterStrength;
    }

    public void setMaxMonsterStrength(int maxMonsterStrength) {
        this.maxMonsterStrength = maxMonsterStrength;
    }

    public int getMaxMonsterStrength() {
        return maxMonsterStrength;
    }

    public void setMinPotionStats(int minPotionStats) {
        this.minPotionStats = minPotionStats;
    }

    public int getMinPotionStats() {
        return minPotionStats;
    }

    public void setMaxPotionStats(int maxPotionStats) {
        this.maxPotionStats = maxPotionStats;
    }

    public int getMaxPotionStats() {
        return maxPotionStats;
    }

    public void setMinTreasureGold(int minTreasureGold) {
        this.minTreasureGold = minTreasureGold;
    }

    public int getMinTreasureGold() {
        return minTreasureGold;
    }

    public void setMaxTreasureGold(int maxTreasureGold) {
        this.maxTreasureGold = maxTreasureGold;
    }

    public int getMaxTreasureGold() {
        return maxTreasureGold;
    }
}
