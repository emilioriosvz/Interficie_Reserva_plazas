package vista;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class PanelVagon extends JPanel{
    
    private final int id_vagon;
   
    public PanelVagon (int id_vagon){
        this.id_vagon=id_vagon;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
       super.paintComponent(g); 
       Graphics2D g2 = (Graphics2D)g; 
       
       g2.drawString("Vagon nº " + id_vagon, 20, 20);
       
       g2.draw3DRect(40, 40, 650, 130, true);

        
    }
}