/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secure_qr_code_generator;

import java.awt.Toolkit;

/**
 *
 * @author abans
 */
public class Secure_QR_code_Generator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        QRInputFrame inputPanel = new QRInputFrame();
        inputPanel.setTitle("SVSM Project");
        inputPanel.setIconImage(Toolkit.getDefaultToolkit().createImage("icon.png"));
        inputPanel.setResizable(false);
        inputPanel.setLocationRelativeTo(null);
        inputPanel.setVisible(true);
    }
}
