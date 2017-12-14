package rogueluv.model;

import rogueluv.controller.RogueLuv;

/**
 * Classe modèle d'un escalier abstrait pour RogueLuv
 * @author gocario
 * @version 1.0
 */
public abstract class Stairs extends CellType {
    protected Floor floor = null;


    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public Floor getFloor() {
        return floor;
    }

    /**
     * Constructeur de la classe
     * @param floor Palier abstrait
     */
    public Stairs(Floor floor) {
        this.floor = floor;
    }
    
    @Override
    public boolean action() {
        
        //RogueLuv.getInstance().moveToFloor(floor);
        RogueLuv.getInstance().writeConsole("Il y a "+floor.countGold()+"$ et "+floor.countMonster()+" monstres.");
        RogueLuv.getInstance().writeConsole("Voulez vous emprunter les escaliers ? [y]/[zqsd]");
        
        return false;
    }
    
    @Override
    public abstract char getSymbol();
}
