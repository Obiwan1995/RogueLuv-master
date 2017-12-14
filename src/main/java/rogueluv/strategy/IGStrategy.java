package rogueluv.strategy;

import rogueluv.model.Floor;

public interface IGStrategy {
    
   Floor generateFloors();
   int generatePlayerStrength();
    
    /*
    public abstract Floor generateFloor(Floor parent);
    public abstract Cell generateCell(Vector2 position, Floor me, Floor parent);
    */
}
