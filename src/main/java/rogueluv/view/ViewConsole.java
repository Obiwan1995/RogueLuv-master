package rogueluv.view;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Classe vue, affiche la console pour RogueLuv
 * @author germain
 * @version 1.0
 */
public class ViewConsole extends JPanel {

    private JTextArea console;
    
    private final int maxLine = 3;
    private int nLine;
    

    /**
     * Constructeur de la classe
     */
    public ViewConsole(KeyListener listener) {
        initialize(listener);
    }
    
    /**
     * Initialise le JPanel `this`
     * @return void
     */
    private void initialize(KeyListener listener) {
        //TODO: Set up the size of the JTextArea`console`
        
        nLine = 0;
        
        
        console = new JTextArea();
        console.addKeyListener(listener);
        
        
        this.add(console);
    }
    
    /**
     * Efface tout le contenu de la console
     * @return void
     */
    public void clear() {
        nLine = 0;
        console.setText("");
    }


    /**
     * Ajoute une ligne dans la console
     * @param row Ligne ? ajouter
     * @return void
     */
    public void writeLine(String row) {
        //TODO: Write a line in the JTextArea`console`
        if (nLine >= maxLine) {
            String[] lines = console.getText().split("\n");
            console.setText(
                new StringBuilder()
                .append(lines[1])
                .append("\n")
                .append(lines[2])
                .append("\n")
                .toString()
            );
        } else {        
            nLine++;
        }
        
        console.append(row.concat("\n"));
        
    }

    /**
     * Modifie la couleur du texte de la console
     * @param color Couleur de modification
     * @return void
     */
    public void setForegroundColor(Color color) {
        console.setForeground(color);
    }

    /**
     * Modifie la couleur du fond de la console
     * @param color Couleur de modification
     * @return void
     */
    public void setBackgroundColor(Color color) {
        console.setBackground(color);
    }
}
