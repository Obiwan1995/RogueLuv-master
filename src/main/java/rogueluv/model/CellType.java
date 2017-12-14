package rogueluv.model;

/**
 * Classe modèle d'un type de cellule pour RogueLuv
 * @author gocario
 * @version 1.0
 */
public abstract class CellType {

    /**
     * Action de la cellule à effectuer
     * @return true Si la case est reset
     */
    public abstract boolean action();
    
    
    /**
     * Calcule la somme des monstres des paliers
     * @return int Somme des monstres (base: 0)
     */
    public int countGold() {
        return 0;
    }

    /**
     * Calcule la somme des monstres des paliers
     * @return int Somme des monstres (base: 0)
     */
    public int countMonster() {
        return 0;
    }

    public abstract char getSymbol();
}
