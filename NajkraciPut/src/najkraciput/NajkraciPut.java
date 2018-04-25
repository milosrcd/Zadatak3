package najkraciput;

import javax.swing.SwingUtilities;

public class NajkraciPut {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                View view = new View();
                view.setVisible(true);
            }
        });
    }

}
