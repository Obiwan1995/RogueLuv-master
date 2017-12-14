package rogueluv.model;

import rogueluv.controller.RogueLuv;

import rogueluv.framework.Direction;
import rogueluv.framework.Size;
import rogueluv.framework.Vector2;

/**
 * Classe modèle d'un joueur pour RogueLuv
 * @author gocario
 * @version 1.0
 */
public final class Player {

    private static Player instance = null;
    public static Player getInstance() {
        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }
    public static Player resetInstance(){
        if (instance != null) {
            instance = null;
        }
        return getInstance();
    }

    private Floor currentFloor = null;
    private Vector2 position = Vector2.Zero;
    private int strength = 0;
    private int gold = 0;


    public void setCurrentFloor(Floor currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Floor getCurrentFloor() {
        return currentFloor;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void addStrength(int strength) {
        this.strength += strength;
        //La force ne peut pas être négative
        if(this.strength <=0) {
            this.strength = 0;
        }
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public void addGold(int gold) {
        this.gold += gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getGold() {
        return gold;
    }

    /**
     * Constructeur de la classe
     */
    private Player() {
        //TODO: Initialiser les variables d'instances ?!
    }


    /**
     * Retourne la cellule sur lequel se tient le joueur
     * @return Cell Cellule du joueur
     */
    public Cell getActualCell() {
        return currentFloor.getCell(position);
    }

    /**
     * Déplace le joueur en fonction d'une direction spécifié
     * @param direction Direction
     * @return true Si le joueur a bougé
     */
    public boolean move(Direction direction) {

        boolean hasMove = false;
        switch (direction) {
        case Up:
        case North:
            if (position.getY() > 0) {
                position.addY(-1);
                hasMove = true;
            }
            break;
        case Down:
        case South:
            if (position.getY() < currentFloor.getSize().getHeight() - 1) {
                position.addY(+1);
                hasMove = true;
            }
            break;
        case Left:
        case West:
            if (position.getX() > 0) {
                position.addX(-1);
                hasMove = true;
            }

            break;
        case Right:
        case East:
            if (position.getX() < currentFloor.getSize().getWidth() - 1) {
                position.addX(+1);
                hasMove = true;
            }
            break;
        }
        
        return hasMove;
    }
    
    /**
     * Découvre 3x3 : les 8 cases autour du joueur
     * @return int Nombre de monstres alentours
     */
    public int discover() {
        int countMonster = 0;
        for (int i = 0; i < 9; i++) {
            Cell cell = currentFloor.getCell(position.getX() - 1 + i % 3, position.getY() - 1 + i / 3);
            
            if (cell != null) {
                
                if (cell.countMonster() == 1) {
                    countMonster++;
                }
                cell.setDiscovered(true);
            }
        }
        return countMonster;
    }

    private static char symbol = '@';
    public char getSymbol() {
        return symbol;
    }
}
