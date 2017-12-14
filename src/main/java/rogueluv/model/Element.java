package rogueluv.model;

import rogueluv.framework.Vector2;

/**
 * Classe modèle d'un élément abstrait pour RogueLuv
 * @author gocario
 * @version 1.0
 */
public abstract class Element {

    public Vector2 getPosition() {
        return Vector2.Minus;
    }
    
    
    public abstract int countGold();
    public abstract int countMonster();
    
    
    public char getSymbol() {
        return ' ';
    }
}
