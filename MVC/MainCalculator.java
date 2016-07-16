/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Prerana
 */
public class MainCalculator {
    
    
     public static void main(String[] args) {
    View calview = new View();
   
    
    Model calmodel = new Model();
    Controller calcontroller = new Controller(calmodel, calview);
    
   
    
    calview.setVisible(true);
    
            
     }
}
