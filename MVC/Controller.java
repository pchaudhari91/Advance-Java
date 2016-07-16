/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Prerana
 */
public class Controller {
    
    private Model calmodel;
    private View calview;
    
    public Controller(Model calmodel, View calview)
    {
        this.calmodel= calmodel;
        this.calview= calview;
        
        this.calview.calculationlistener(new calculatelistener());
    }
    
    
    class calculatelistener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            
            int numberOne, numberTwo=0;
            
            try
            {
                numberOne = calview.getnumberOne();
                numberOne = calview.getnumberTwo();
                
                calmodel.calculation(numberOne, numberTwo);
                
               calview.setresult(calview.getcalculatesolution());
               
               
                
                
                
            }
            
            catch(NumberFormatException e)
            {
                calview.errormessage("You need to enter 2 integers");
            }
            
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
    }
    
    
}
