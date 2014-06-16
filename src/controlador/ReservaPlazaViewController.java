package controlador;

import vista.ReservaPlazaView;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ReservaPlazaViewController implements ActionListener {

    private final ReservaPlazaView reservaView;

    public ReservaPlazaViewController(ReservaPlazaView reservaView) {
        //aquí inicializa la reservaView, con la view q hemos generado antes
        this.reservaView = reservaView;
        //y le decimos que el listener es esta clase.
        this.reservaView.addListener(this);
    }

    //Acciones del Listener.
    @Override
    public void actionPerformed(ActionEvent e) {
        //Recorre el array de botones poniendo el fondo blanco
        if (e.getSource() == this.reservaView.button_conf) {
            for (int i = 0; i < reservaView.buttons_sits.length; i++) {

                if (!reservaView.plazas[i].isLibre()) {

                    reservaView.buttons_sits[i].setEnabled(false);

                    reservaView.buttons_sits[i].setBackground(Color.white);

                }
            }
        
        } else if (e.getSource() == this.reservaView.button_cancel) {
            //recorre el array de botones volviendolos disponibles y poniendolos negros
            for (JButton buttons_sit : reservaView.buttons_sits) {
                if (buttons_sit.isEnabled()) {
                    buttons_sit.setForeground(Color.black);
                    //
                    for (int i =0; i< reservaView.buttons_sits.length; i++) {
                        if (reservaView.plazas[i].isLibre()) {
                            reservaView.buttons_sits[i].setEnabled(true);
                        }
                    
                    }
                }
            }

        } else {
            for (int i = 0; i < reservaView.buttons_sits.length; i++) {

                if (e.getSource() == reservaView.buttons_sits[i]) {

                    if (reservaView.plazas[i].isLibre()) {

                        reservaView.plazas[i].setLibre(false);

                        //reservaView.buttons_sits[i].setForeground(Color.white);
                        reservaView.buttons_sits[i].setBackground(Color.blue);

                        reservaView.button_cancel.setEnabled(true);
                        reservaView.button_conf.setEnabled(true);
                    }
                }
            }
        }
    }
}
