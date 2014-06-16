package vista;

import modelo.Plaza;
import modelo.PlazaCollection;
import controlador.ReservaPlazaViewController;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ReservaPlazaView extends JFrame {

    public Plaza[] plazas;
    public JButton[] buttons_sits;
    
    public JButton button_conf;
    public JButton button_cancel;

    public ReservaPlazaView() {
        //Las plazas llaman al controlador para reyenarse
        this.plazas = PlazaCollection.getCollection();
        
        //Los botones[] de los asientos tienen la longitud de las plazas totales
        this.buttons_sits = new JButton[this.plazas.length];
        
        //Cuando le des a la X cierras la app
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Título de la app
        this.setTitle("Reserva Plaza");
        
        //panel q engloba todo
        addComponentsToPane(this.getContentPane());
        this.setSize(800, 400);
        this.setResizable(false);
        this.setVisible(true);

    }

    private void addComponentsToPane(Container panel) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        //panel superior--------------------------------------------------------
        JPanel panelSuperior = new JPanel();
        
        //panel vagon con su numero
        PanelVagon panelVagon = new PanelVagon(9);
        panelVagon.setSize(550, 550);
        panelVagon.setLayout(new GridLayout(4, 9));

        //botones de los asientos
        for (int i = 0; i < this.plazas.length; i++) {
            buttons_sits[i] = new JButton(plazas[i].getAsiento());
            buttons_sits[i].setSize(75, 75);
            panelVagon.add(buttons_sits[i]);
        }
        
        //borde superior del panel:
        panelVagon.setBorder(new EmptyBorder(50, 40, 50, 110));

        
        //panel inferior--------------------------------------------------------
        JPanel panelInferior = new JPanel();
        panelInferior.setSize(550, 150);
        
        button_conf = new JButton("Confirmacion");
        button_conf.setEnabled(false);
        

        button_cancel = new JButton("Cancelacion");
        button_cancel.setEnabled(false);
        
        //Añadimos al panel inferior los dos botones (inhabilitados)
        panelInferior.add(button_conf);
        panelInferior.add(button_cancel);
        
        //Añadimos al panel superior el panelVagon, que contiene ya todos los botones
        //inicializados con sus asientos.
        panelSuperior.add(panelVagon);        
        panel.add(panelSuperior);
        panel.add(panelInferior);
    }
    
//listener de los botones
    public void addListener(ReservaPlazaViewController controlador) {
     
        for (int i = 0; i < this.plazas.length; i++) {
              this.buttons_sits[i].addActionListener(controlador);
        }
              this.button_conf.addActionListener(controlador);
              this.button_cancel.addActionListener(controlador);
    }

}
