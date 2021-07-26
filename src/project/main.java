/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import view.login;
import javax.swing.JFrame;

/**
 *
 * @author Faa
 */
public class main {

    /**
     * @param args the command line arguments
     */
   
        // TODO code application logic here
        public main(){
        System.out.println("project.main.<init>()");
        login log = new login();
        log.setVisible(true);
        

    }
    public static void main(String[] args) {
        new main();
    }
    }

