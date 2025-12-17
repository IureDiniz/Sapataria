package aplication;

import static factory.ConnectionFactory.connect;
import gui.IndexFrame;

public class Aplication {

    
    public static void main(String[] args) {
        connect();
        
        // Configurar Nimbus Look and Feel
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IndexFrame().setVisible(true);
            }
        });
    }
    
}
