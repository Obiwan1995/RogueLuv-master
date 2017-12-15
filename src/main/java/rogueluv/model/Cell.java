package rogueluv.model;

import rogueluv.framework.Vector2;

/**
 * Classe modèle d'une cellule pour RogueLuv
 * @author gocario
 * @version 1.0
 */
public class Cell extends Element {
    
    private CellType cellType = null;
    private Vector2 position;
    private boolean discovered = false; //////////////// DEBUG: TRUE


    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }

    public CellType getCellType() {
        return cellType;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setDiscovered(boolean discovered) {
        this.discovered = discovered;
    }

    public boolean isDiscovered() {
        return discovered;
    }

    /**
     * Constructeur de la classe
     */
    public Cell() {
    }
    
    
    /**
     * Gère l'action du type de cellule
     */
    public void action() {
        if (cellType != null) {
            if (cellType.action()) {
                cellType = null;
            }
        }
    }


    /**
     * Renvoie le nombre d'or de la cellule
     * @return int Nombre d'or
     */
    @Override
    public int countGold() {
        return (cellType == null ? 0 : cellType.countGold());
    }

    /**
     * Renvoie le nombre de monstre de la cellule
     * @return int Nombre de monstre
     */
    @Override
    public int countMonster() {
        return (cellType == null ? 0 : cellType.countMonster());
    }


    public char getSymbol() {
        if (!discovered)
            return 'X';
        if (cellType == null)
            return '.';
        return cellType.getSymbol();
    }
}
