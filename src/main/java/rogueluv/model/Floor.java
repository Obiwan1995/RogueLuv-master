package rogueluv.model;

import java.util.ArrayList;

import rogueluv.framework.Size;
import rogueluv.framework.Vector2;

/**
 * Classe modèle d'un palier pour RogueLuv
 * @author gocario
 * @version 1.0
 */
public class Floor extends Element {
    
    private ArrayList<Element> elements = new ArrayList<Element>();
    private int level = 1;
    private Size size;


    public void addElement(Element element) {
        this.elements.add(element);
    }
    public void delElement(Element element) {
        this.elements.remove(element);
    }
    public void setElements(ArrayList<Element> elements) {
        this.elements = elements;
    }
    public ArrayList<Element> getElements() {
        return elements;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public int getLevel() {
        return level;
    }
    
    public void setSize(Size size) {
        this.size = size;
    }
    public Size getSize() {
        return size;
    }
    

    /**
     * Récupère la cellule aux coordonnées demandées
     * @param x Colonne de la cellule
     * @param y Ligne de la cellule
     * @return Cell Cellule correspondante
     */
    public Cell getCell(int x, int y) {
        Cell cell = null;
        
        for (int i = 0; i < elements.size() && cell == null; i++) {
            Element element = elements.get(i);
            Vector2 v = element.getPosition();
            if (v.getX() == x && v.getY() == y) {
                cell = (Cell) element;
            }
        }
        return cell;
    }
    
    /**
     * Récupère la cellule aux coordonnées demandées
     * @param v Coordonnées de la cellule
     * @return Cell Cellule correspondante
     */
    public Cell getCell(Vector2 v) {
        return this.getCell(v.getX(), v.getY());
    }

    /**
     * Récupère la cellule contenant les escaliers descendant du niveau
     * @return Cell Cellule de l'escalier descendant
     */
    public Cell getDownstairs() {
        Cell cell = null;
        
        for (int i = 0; i < elements.size() && cell == null; i++) {
            Element element = elements.get(i);
            if (element.getPosition() != Vector2.Minus) {
                cell = (Cell) element;
                
                if (cell.getCellType() instanceof Downstairs) {
                
                } else {
                    cell = null;
                }
            }
        }
        return cell;
    }

    /**
     * Récupère la cellule contenant les escaliers ascendant du niveau floor
     * @param floor Niveau sur lequel pointe les escalier
     * @return Cell Cellule de l'escalier ascendant
     */
    public Cell getUpstairs(Floor floor) {
        Cell cell = null;
        
        for (int i = 0; i < elements.size() && cell == null; i++) {
            Element element = elements.get(i);
            if (element.getPosition() != Vector2.Minus) {
                cell = (Cell) element;
                
                if (cell.getCellType() instanceof Upstairs) {
                    if (((Upstairs) cell.getCellType()).getFloor() == floor) {

                    } else {
                        cell = null;
                    }
                } else {
                    cell = null;
                }
            }
        }
        return cell;
    }
    
    /**
     * Récupère toutes les cellules contenant des escaliers ascendants
     * @return ArrayList<Cell> Cellules des escaliers
     */
    public ArrayList<Cell> getUpstairs() {
        ArrayList<Cell> cells = new ArrayList<Cell>();
        Cell cell;
        
        for (int i = 0; i < elements.size(); i++) {
            Element element = elements.get(i);
            if (element.getPosition() != Vector2.Minus) {
                cell = (Cell) element;
                
                if (cell.getCellType() instanceof Upstairs) {
                    cells.add(cell);
                }
            }
        }
        return cells;
    }

    /**
     * Calcule la somme des trésors du palier
     * @return int Somme des trésors
     */
    @Override
    public int countGold() {
        int count = 0;

        for (Element element : elements) {
            count += element.countGold();
        }

        return count;
    }

    /**
     * Calcule la somme des monstres du palier
     * @return int Somme des monstres
     */
    @Override
    public int countMonster() {
        int count = 0;

        for (Element element : elements) {
            count += element.countMonster();
        }

        return count;
    }
}
