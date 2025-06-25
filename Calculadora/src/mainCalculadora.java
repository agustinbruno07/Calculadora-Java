import GUI.calculadora;
import java.awt.EventQueue;
public class mainCalculadora {

	public static void main(String[] args) {
       verCalculadora();
       
	}
	 private static void verCalculadora() {
	        EventQueue.invokeLater(new Runnable() { 
	            public void run() {
	                try {
	                    calculadora ventana = new calculadora(); 
	                    ventana.setVisible(true); 
	                } catch (Exception e) {
	                    e.printStackTrace(); 
	                }
	            }
	        });
	    }
}
