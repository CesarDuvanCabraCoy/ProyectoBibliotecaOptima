/**
 * 
 */
package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * @author andresnino
 *
 */
public class JBoardStadisticas extends JFrame {

    private JPanel contentPane;
    private JTextField tf4;
    private JTextField tf3;
    private JTextField tf1;
    private JTextField tf2;
    private boolean bandera=false;
    private static final int posX = 50;
    private static final int posXBar = 260;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	JBoardStadisticas frame = new JBoardStadisticas();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void paintStadistics(int student, int pc,int cola, int broken) {
    	EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	JBoardStadisticas frame = new JBoardStadisticas();
                	frame.setTitle("Resultados de simulacion.");
                	frame.tf1.setText(String.valueOf(student));
                	frame.tf2.setText(String.valueOf(pc));
                	frame.tf3.setText(String.valueOf(cola));
                	frame.tf4.setText(String.valueOf(broken));
                    frame.setVisible(true);
                    frame.bandera=true;
                    frame.repaint();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
	}

    /**
     * Create the frame.
     */
    public JBoardStadisticas() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        
        tf1 = new JTextField();
        tf1.setBounds(posX+117, 36, 86, 20);
        //contentPane.add(tf1);
        tf1.setColumns(10);
        
        tf2 = new JTextField();
        tf2.setBounds(117, 66, 86, 20);
        //contentPane.add(tf2);
        tf2.setColumns(10);
        
        tf3 = new JTextField();
        tf3.setBounds(117, 97, 86, 20);
        //contentPane.add(tf3);
        tf3.setColumns(10);
        
        tf4 = new JTextField();
        tf4.setBounds(117, 127, 86, 20);
        //contentPane.add(tf4);
        tf4.setColumns(10);
        
        JButton btnGraficar = new JButton("Graficar");
        /*btnGraficar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                bandera=true;
                repaint();
            }
        });*/
        btnGraficar.setBounds(9, 1, 2, 2);
        btnGraficar.setSelected(false);
        contentPane.add(btnGraficar);
    }
    
    
    public void paint(Graphics g)
    {
        super.paint(g);
        if (bandera==true)
        {
            String s1=tf1.getText();
            String s2=tf2.getText();
            String s3=tf3.getText();
            String s4=tf4.getText();
            int v1=Integer.parseInt(s1);
            int v2=Integer.parseInt(s2);
            int v3=Integer.parseInt(s3);
            int v4=Integer.parseInt(s4);
            int mayor=retornarMayor(v1,v2,v3,v4);
            
            int largo1=v1*400/mayor;
            int largo2=v2*400/mayor;
            int largo3=v3*400/mayor;
            int largo4=v4*400/mayor;

            g.setColor(new Color(255,0,0));
            g.fillRect(posXBar,250,largo1,40);
            g.drawString("Promedio de personas por dia:", 10, 270);            
            g.drawString(s1, this.getWidth()-60, 270);            

            g.setColor(new Color(0,128,0));
            g.fillRect(posXBar,300,largo2,40);
            g.drawString("Tiempo promedio de uso por dia/PC", 10, 320);            
            g.drawString(s2, this.getWidth()-60, 320);            

            g.setColor(new Color(0,0,255));
            g.fillRect(posXBar,350,largo3,40);
            g.drawString("Promedio de estudiantes en cola", 10, 370);            
            g.drawString(s3, this.getWidth()-60, 370); 
            
            g.setColor(Color.decode("#CC54FF"));
            g.fillRect(posXBar,400,largo4,40);
            g.drawString("Promedio PC's dañados por dia", 10, 420);            
            g.drawString(s4, this.getWidth()-60, 420);            
            
        }
    }
    
    private int retornarMayor(int v1,int v2,int v3,int v4)
    {
        if (v1>v2 && v1>v3)
            return v1;
        else
            if (v2>v3)
                return v2;
            else
                return v3;
    }
       
}
