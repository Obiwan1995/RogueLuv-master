package rogueluv.model;

import javax.swing.JOptionPane;

import rogueluv.controller.RogueLuv;
import rogueluv.controller.G_Score;

/**
 * Classe modèle d'un escalier finissant pour RogueLuv
 * @author gocario
 * @version 1.0
 */
public class Starway extends CellType {

    /**
     * Action de la cellule: Finir le jeu
     * @return true Si la case est reset
     */
    @Override
    public boolean action() {
        //TODO: Finir le jeu
        System.out.println("Starway.action()");
        RogueLuv.getInstance().winGame();
        return false;
    }
    

    
    private static char symbol = 'O';
    public char getSymbol() {
        return symbol;
    }
}
