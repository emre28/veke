import javax.swing.JFrame;

public class Main {

    public static void main(String[] args){
    	JFrame veke= new JFrame("VEKE");
    	veke.add(new panel_ve_thread());
    	veke.setResizable(false);//otomatik boyut kapatma
    	veke.pack();
    	veke.setLocationRelativeTo(null);//ekrana ortalama
    	veke.setVisible(true);
    	veke.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}