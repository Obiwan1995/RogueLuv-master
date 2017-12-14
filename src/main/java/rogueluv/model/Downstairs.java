package rogueluv.model;

import rogueluv.controller.RogueLuv;

/**
 * Classe modèle d'un escalier descendant pour RogueLuv
 * @author gocario
 * @version 1.0
 */
public class Downstairs extends Stairs {
    
    /**
     * Constructeur de la classe
     * @param floor Palier descendant
     */
    public Downstairs(Floor floor) {
        super(floor);
    }


    /**
     * Action de la cellule: Descendre les escalier
     * @return true Si la case est reset
     */
    @Override
    public boolean action() {
        System.out.println(floor);
        System.out.println("Downstairs.action()");
        
        return super.action();
    }
    
    
    private static char symbol = '<';
    public char getSymbol() {
        return symbol;
    }
}
