package rogueluv.model;

import rogueluv.controller.RogueLuv;

import rogueluv.framework.Random;

/**
 * Classe modèle d'un monstre pour RogueLuv
 * @author gocario
 * @version 1.0
 */
public class Monster extends CellType {
    
    private static String[] names = {"Wemmert", "Haristoy", "Schnell", "Divoux", "Karutone-chan", "Succube", "Chauve-souris", "Dragon", "Goblin", "Batman"};
    public static String[] getNames() {
        return names;
    }
    
    private String name = null;
    private int strength = 0;
    private int gold = 0;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStrength(int strength) {
        this.strength += strength;
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
    public Monster(String name, int strength, int gold) {
        this.name = name;
        this.strength = strength;
        this.gold = gold;
    }


    /**
     * Action de la cellule: Récupérer le trésor
     * @return true Si la case est reset
     */
    @Override
    public boolean action() {
        //TODO: Faire un lancer aléatoire pour dï¿½terminer l'issue du combat
        System.out.println("Monster.action()");
        
        Random rand = new Random();
        int fP = Player.getInstance().getStrength();
        int fM = strength;
            
        if (rand.rint(0, fP + fM) - fP <= 0) {
            Player.getInstance().addStrength(fM * rand.rint(0, 100) / 100);
            RogueLuv.getInstance().writeConsole("Vous avez battu "+name+" !");
        } else {
            RogueLuv.getInstance().loseGame(name);
        }
        
        return true;
    }


    /**
     * Renvoie le nombre de monstre
     * @return int Nombre de monstre
     */
    @Override
    public int countMonster() {
        return 1;
    }
    
    
    private static char symbol = '.';
    public char getSymbol() {
        return symbol;
    }
}
