package rogueluv.view;

import java.awt.Font;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import rogueluv.controller.RogueLuv;

import rogueluv.model.Element;
import rogueluv.model.Player;
import rogueluv.model.Floor;

/**
 * Classe vue, affiche le palier pour RogueLuv
 * @author gocario
 * @version 1.0
 */
public class ViewFloor extends JPanel {

    private JTextArea floorArea;
    
    
    /**
     * Constructeur de la classe
     */
    public ViewFloor(KeyListener listener) {
        initialize(listener);
    }

    /**
     * Initialise le JPanel `this`
     * @return void
     */
    private void initialize(KeyListener listener) {
        //TODO: Set up the size of the JTextArea`floor`
        
        floorArea = new JTextArea();        
        floorArea.setFont(new Font("Monospaced", 0, 20));
        floorArea.setEditable(false);
        floorArea.setLineWrap(true);
        floorArea.addKeyListener(listener);
        
        this.add(floorArea);
    }
    
    /**
     * Met à jour l'affichage du palier
     * @return void
     */
    public void updateFloor() {
        //TODO: Display the whole floor depending on the actual one in the JTextArea`floor`
        
        Player player = Player.getInstance();
        Floor floor = player.getCurrentFloor();
        
        StringBuilder str = new StringBuilder();
        
        for (int row = 0; row < floor.getSize().getHeight(); row++) {
            for (int col = 0; col < floor.getSize().getWidth(); col++) {
                str.append(' ');
            }
            str.append('\r').append('\n');
        }
        
        for (Element element : floor.getElements()) {
            int index = element.getPosition().getX() + element.getPosition().getY() * (floor.getSize().getWidth() + 2);
            str.setCharAt(index, element.getSymbol());
        }

        int index = player.getPosition().getX() + player.getPosition().getY() * (floor.getSize().getWidth() + 2);
        str.setCharAt(index, player.getSymbol());
        
        floorArea.setText(str.toString());
		floorArea.setColumns(floor.getSize().getWidth());
		floorArea.setRows(floor.getSize().getHeight());
    }
}
