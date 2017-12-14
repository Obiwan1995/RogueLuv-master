package rogueluv.strategy;

import rogueluv.model.Floor;

public class CoeffGHardcore extends BasicGStrategy {
    
    public CoeffGHardcore() {
        coeffGMonster = 8;
        coeffGPotion = 5;
        
        maxStairs = 4;
        
        minPlayerStrength = 25;
        maxPlayerStrength = 40;
        minMonsterStrength = 15;
        maxMonsterStrength = 30;
        minPotionStats = -20;
        maxPotionStats = +23;
        
        maxFloor = 12;
        maxStairs = 5;
        floorWidth = 18;
        floorHeight = 18;
        
        minMonsterGold = 24;
        maxMonsterGold = 34;
        minTreasureGold = 23;
        maxTreasureGold = 39;
    }
}
