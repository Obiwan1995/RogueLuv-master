package rogueluv.view;

import java.awt.CheckboxMenuItem;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import rogueluv.controller.RogueLuv;

import rogueluv.framework.Difficulty;

import rogueluv.strategy.BasicGStrategy;
import rogueluv.strategy.CoeffGHard;
import rogueluv.strategy.CoeffGHardcore;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.Properties;

import javax.swing.JCheckBoxMenuItem;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import rogueluv.controller.G_Score;

import rogueluv.controller.G_Tuto;

import rogueluv.model.Starway;

/**
 * Classe vue, affiche le menu
 * @author germain
 * @version 1.0
 */

public class ViewMenu extends JMenuBar {
    
    /**
     * Constructeur de la classe
     */
    public ViewMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu, submenu;
        JMenuItem menuItem;
        
        menu = new JMenu("Partie");
        menuBar.add(menu);

        //Menu nouvelle partie
        menuItem = new JMenuItem("Nouvelle partie");
        menuItem.addActionListener(new java.awt.event.ActionListener(){
        public void actionPerformed(ActionEvent e) 
        {
            System.out.println("Création d'une nouvelle partie");
            RogueLuv.getInstance().createGame();
        }
        });
        menu.add(menuItem);

        //Menu difficulté
        menu.addSeparator();
        
        submenu = new JMenu("Difficulté");
        menuItem = new JMenuItem("Normal");
        menuItem.addActionListener(new java.awt.event.ActionListener(){
        public void actionPerformed(ActionEvent e) 
        {
            System.out.println("Difficulté => Normal");
            RogueLuv.getInstance().setDifficulty(Difficulty.Normal);
            RogueLuv.getInstance().writeConsole("Difficulté => " + RogueLuv.getInstance().getDifficulty());
        }
        });
        submenu.add(menuItem);
        
        menuItem = new JMenuItem("Difficile");
        menuItem.addActionListener(new java.awt.event.ActionListener(){
        public void actionPerformed(ActionEvent e) 
        {
            System.out.println("Difficulté => Difficile");
            RogueLuv.getInstance().setDifficulty(Difficulty.Hard);
            RogueLuv.getInstance().writeConsole("Difficulté => " + RogueLuv.getInstance().getDifficulty());
        }
        });
        submenu.add(menuItem);
        menuItem = new JMenuItem("H4RDC0R3");
        menuItem.addActionListener(new java.awt.event.ActionListener(){
        public void actionPerformed(ActionEvent e) 
        {
            System.out.println("Difficulté => Hardcore");
            RogueLuv.getInstance().setDifficulty(Difficulty.Hardcore);
            RogueLuv.getInstance().writeConsole("Difficulté => " + RogueLuv.getInstance().getDifficulty());
        }
        });
        
        submenu.add(menuItem);
        menu.add(submenu);
        
        //Menu meilleurs scores  
        menu.addSeparator();
        menuItem = new JMenuItem("Meilleurs scores");
        menuItem.addActionListener(new java.awt.event.ActionListener(){
        public void actionPerformed(ActionEvent e) 
        {
            System.out.println("Affichage des meilleurs scores");
            showBestScores();
        }
        });
        menu.add(menuItem);
        
        //Menu tuto
        menu.addSeparator();
        menuItem = new JMenuItem("Afficher le tuto");
        menuItem.addActionListener(new java.awt.event.ActionListener(){
        public void actionPerformed(ActionEvent e) 
        {
            tuto();
        }
        });
        menu.add(menuItem);
        
        //CheckBox Tutorial
        menu.addSeparator();
        final JCheckBoxMenuItem checkItem = new JCheckBoxMenuItem("Tutorial au démarrage");
        if(G_Tuto.getTuto()) 
        {
            checkItem.setState(true);
        }
        checkItem.addActionListener(new java.awt.event.ActionListener(){
        public void actionPerformed(ActionEvent e) 
        {
            if(checkItem.getState()){
                G_Tuto.modifyTuto(true);
                System.out.println("Tutorial activé");
            }
            else
            {
                G_Tuto.modifyTuto(false);
                System.out.println("Tutorial desactivé");
            }
        }
        });
        menu.add(checkItem);

        this.add(menuBar);
    }
    
    /**
     * Affiche les meilleurs scores
     * @return void
     */
    public void showBestScores(){
        String[] scores = G_Score.getBestScores();
        String meilleursScores = "";
        if(scores != null)
        {
            for(int i=0;i<scores.length;i++) {
                if(scores[i] != null) {
                    meilleursScores += "\n" + scores[i];                
                }
            }
        }
        else 
        {
            meilleursScores = "\nAucun score enregistré pour le moment";
        }
        //TODO: Recuperer les scores
       JOptionPane.showConfirmDialog(null, "Meilleurs scores : \n" + meilleursScores.toString(), 
        "Information", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void showTutorial() {
        if(G_Tuto.getTuto())
        {
            tuto();
        }
    }
    
    public void tuto(){
        JOptionPane.showConfirmDialog(null, 
            "Déplacement : ZQSD ou les flèches directionnelles.\n" +
            "Appuyez sur [Y] pour emprunter un escalier\n" +
            "Difficulté modifiable dans le menu correspondant\n" +
            "Raccourci pour lancer la partie : [N]\n\n" +
            "Bon jeu !"
        , "Tutorial \n", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }
    
}


