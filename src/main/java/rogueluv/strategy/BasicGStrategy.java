package rogueluv.strategy;

import java.util.ArrayList;

import rogueluv.framework.Random;
import rogueluv.framework.Size;
import rogueluv.framework.Vector2;

import rogueluv.model.Cell;
import rogueluv.model.Downstairs;
import rogueluv.model.Floor;
import rogueluv.model.Monster;
import rogueluv.model.Potion;
import rogueluv.model.Starway;
import rogueluv.model.Treasure;
import rogueluv.model.Upstairs;

public class BasicGStrategy extends CoeffGStrategy {
    
    public BasicGStrategy() {
        super();
    }
    
    public Floor generateFloors() {
        return generateFloor(null, true);
    }

    public int generatePlayerStrength() {
        return new Random().rint(minPlayerStrength, maxPlayerStrength);
    }
    
    
    private Floor generateFloor(Floor parent, boolean toTheEnd) {
        
        Random rand = new Random();
        Floor floor = new Floor();
        if (parent != null) {
            floor.setLevel(parent.getLevel() + 1);
        } else {
            floor.setLevel(1-maxFloor);
        }
        floor.setSize(new Size(floorWidth, floorHeight));
        
        if (parent != null)
            System.out.println("["+parent.getLevel()+"]"+parent+" -> ["+floor.getLevel()+"]"+floor);
        else
            System.out.println("[NULL]null -> ["+floor.getLevel()+"]"+floor);
        
        // Normals cells
        for (int row = 0; row < floor.getSize().getHeight(); row++) {
            for (int col = 0; col < floor.getSize().getWidth(); col++) {
                floor.addElement(generateCell(new Vector2(col, row), floor, parent));
            }
        }
        
        // Specials cells
        int lDown = 0; //limitDownstairs
        int lUp = 0; //limitUpstairs
        int lEnd = 0; //limitStarway
        
        
        if (toTheEnd) {
            if (floor.getLevel() != 0) {
                lUp = rand.rint(1, maxStairs);
            } else {
                lEnd = 1;
            }
            
            if (parent != null) {
                lDown = 1;
            }
        } else {
            if (floor.getLevel() != 0) {
                lUp = rand.rint(0, maxStairs);
            }
            lDown = 1;
        }
        
        
        ArrayList<Vector2> positions = new ArrayList<Vector2>() ;
        
        // Upstairs
        while(lUp-- > 0) {
            boolean isNew = false;
            Vector2 position = Vector2.Minus;
            while (!isNew) {
                position = new Vector2(rand.rint(0, floor.getSize().getWidth()), rand.rint(0, floor.getSize().getHeight()));
                isNew = true;
                for (int i = 0; i < positions.size() && isNew; i++) {
                    if (position.equals(positions.get(i))) {
                        isNew = false;
                    }
                }
            }
            
            positions.add(position);
            
            Cell cell = new Cell();
            cell.setPosition(position);
            cell.setCellType(new Upstairs(generateFloor(floor, toTheEnd)));
            
            floor.addElement(cell);
            floor.delElement(floor.getCell(position));
            
            toTheEnd = false;
        }
        
        // Downstairs
        while(lDown-- > 0) {
            boolean isNew = false;
            Vector2 position = Vector2.Minus;
            while (!isNew) {
                position = new Vector2(rand.rint(0, floor.getSize().getWidth()), rand.rint(0, floor.getSize().getHeight()));
                isNew = true;
                for (int i = 0; i < positions.size() && isNew; i++) {
                    if (position.equals(positions.get(i))) {
                        isNew = false;
                    }
                }
            } 
            
            positions.add(position);
            
            Cell cell = new Cell();
            cell.setPosition(position);
            cell.setCellType(new Downstairs(parent));
            
            floor.addElement(cell);
            floor.delElement(floor.getCell(position));
        }
        
        // Starway
        while(lEnd-- > 0) {
            boolean isNew = false;
            Vector2 position = Vector2.Minus;
            while (!isNew) {
                position = new Vector2(rand.rint(0, floor.getSize().getWidth()), rand.rint(0, floor.getSize().getHeight()));
                isNew = true;
                for (int i = 0; i < positions.size() && isNew; i++) {
                    if (position.equals(positions.get(i))) {
                        isNew = false;
                    }
                }
            }
            
            positions.add(position);
            
            Cell cell = new Cell();
            cell.setPosition(position);
            cell.setCellType(new Starway());
            
            floor.addElement(cell);
            floor.delElement(floor.getCell(position));
        }
        
        
        return floor;
    }
    
    private Cell generateCell(Vector2 position, Floor me, Floor parent) {
        
        Random rand = new Random();
        Cell cell = new Cell();
        
        float theRand = rand.rfloat(0, getCoeffGsNormal());
        
        if ((theRand -= coeffGMonster) <= 0){
            cell.setCellType(new Monster(Monster.getNames()[rand.rint(0, Monster.getNames().length)], rand.rint(minMonsterStrength, maxMonsterStrength), rand.rint(minMonsterGold, maxMonsterGold)));
        } else if ((theRand -= coeffGPotion) <= 0) {
            cell.setCellType(new Potion(rand.rint(minPotionStats, maxPotionStats)));
        } else if ((theRand -= coeffGTreasure) <= 0) {
            cell.setCellType(new Treasure(rand.rint(minTreasureGold, maxTreasureGold)));
        } else {
            cell.setCellType(null);
        }
        
        cell.setPosition(position);
        return cell;
    }
}
