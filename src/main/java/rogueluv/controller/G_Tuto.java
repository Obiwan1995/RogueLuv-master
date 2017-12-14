package rogueluv.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.Properties;

public class G_Tuto {
    public static void modifyTuto(Boolean activated)
    {
        Properties prop = new Properties();
        OutputStream output = null;
        try 
        {
            output = new FileOutputStream("tuto.properties");
            if(activated) 
            {
                prop.setProperty("tutorialEnabled", "true");
            }
            else 
            {
                prop.setProperty("tutorialEnabled", "false");
            }
            prop.store(output, null);
        } 
        catch (IOException io) 
        {
            io.printStackTrace();
        } 
        finally
        {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static boolean getTuto()
    {
        Properties prop = new Properties();
        InputStream input = null;
        Boolean res = true;
        try 
        {
            input = new FileInputStream("tuto.properties");
            // Chargement du fichier
            prop.load(input);
            res = (prop.getProperty("tutorialEnabled").equals("true"));
        }
        catch (IOException ex) 
        {
            System.out.println("Fichier non existant");
        } 
        finally 
        {
            if (input != null) {
                try {
                    //On ferme le fichier
                    input.close();
                } 
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return res;
    }
}
