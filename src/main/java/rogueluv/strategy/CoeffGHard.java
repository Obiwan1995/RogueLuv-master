package rogueluv.strategy;

import rogueluv.framework.Vector2;

import rogueluv.model.Cell;
import rogueluv.model.Floor;

public class CoeffGHard extends BasicGStrategy {
    
    public CoeffGHard() {
        coeffGMonster = 6;
        coeffGPotion = 5;
        
        minPlayerStrength = 70;
        maxPlayerStrength = 90;
        minMonsterStrength = 10;
        maxMonsterStrength = 15;
        minPotionStats = -13;
        maxPotionStats = +16;
        
        maxFloor = 11;
        maxStairs = 4;
        floorWidth = 15;
        floorHeight = 15;
        
        minMonsterGold = 14;
        maxMonsterGold = 19;
        minTreasureGold = 16;
        maxTreasureGold = 23;
    }
}
