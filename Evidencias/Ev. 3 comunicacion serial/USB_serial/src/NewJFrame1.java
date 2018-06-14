
import jssc.SerialPortList; //** Clase para enumerar los puertos seriales
import java.io.OutputStream;
import gnu.io.SerialPort;
import java.io.InputStream;
import java.util.Enumeration;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
//import gnu.io.RXTXCommDriver;
import java.io.IOException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TDB_PC
 */

public class NewJFrame1 extends javax.swing.JFrame 
{    
    String NoPort = new String();  // variable que almacena el nombre del puerto
    String Data = new String();
    /**
     * Creates new form NewJFrame1
     */
    private OutputStream Output = null;
    private InputStream  Input = null;
    SerialPort serialPort;
    private final String PORT_NAME = "NoPort";
    private static final int TIME_OUT = 2000;
    private static final int DATA_RATE = 9600;
    
   //SerialPortEventListener evento = new SerialPortEventListener();
    
    public void ArduinoConnection() {

CommPortIdentifier portId = null;
Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

while (portEnum.hasMoreElements()) {
CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();

if (PORT_NAME.equals(currPortId.getName())) {
portId = currPortId;
break;
}
}

if (portId == null) {

System.exit(ERROR);
return;
}

try {

serialPort = (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);

serialPort.setSerialPortParams(DATA_RATE,
SerialPort.DATABITS_8,
SerialPort.STOPBITS_1,
SerialPort.PARITY_NONE);

Output = serialPort.getOutputStream(); //Se prepara a Output //para enviar datos
Input = serialPort.getInputStream(); //Se prepara input para //recibir datos

serialPort.addEventListener((SerialPortEventListener) this); //Se agrega un Event //Listener
serialPort.notifyOnDataAvailable(true); //Se indica que se //notifique al usuario cuando sea que halla datos disponibles en //el puerto serie
} catch (Exception e) {

System.exit(ERROR);
}
  }

public synchronized void serialEvent(SerialPortEvent oEvent) {
if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
try {
int datos;
datos = RecibirDatos(); //Se invoca la función RecibirDatos()

//Esta función devolverá un valor entero en formato ASCII.
System.out.println((char)datos); //Se imprime en el mensaje

//haciendo la conversión de ASCII a nuestro alfabeto.
} catch (Exception e) {
System.err.println(e.toString());
}
}
}
    
private int RecibirDatos() throws IOException {
int Output = 0;
Output = Input.read();
return Output;
}

    public NewJFrame1() {
        //Data="COM3";
        //NoPort="COM4";
        initComponents();
        //System.out.println(Data);
        //System.out.println(NoPort);
        //ArduinoConnection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Comunicación Serial");

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Input");

        jLabel3.setText("Output");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(215, 215, 215)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(75, 75, 75)
                                .addComponent(jButton2)
                                .addGap(65, 65, 65))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(299, 299, 299)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(90, 90, 90))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/******* Método que obtiene el nombre del Puerto Serial del jComoboBox y envía como parámetro al NewjFrame
 *  además cierra el actual jFrame y abre otro jFrame ***/
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       if (jComboBox1.getItemCount()!=0) {
            //Data="COM3";
            //NoPort="COM4";
             NoPort = jComboBox1.getItemAt(0).toString();  //Obtiene el nombre del puerto             
             Data = jComboBox2.getItemAt(1).toString();
             System.out.println("Input " + NoPort);
             System.out.println("Output " + Data);
             NewJFrame jFrame = new NewJFrame(NoPort,Data); //crea el Jframe         
       jFrame.setVisible(true); //Muestra el jFrame        
       // this.dispose(); // Elimina el actual jFrame
        }     
       
    }//GEN-LAST:event_jButton1ActionPerformed
 /* Método que se ejecuta cuando se abre el jFrame, llena el jComboBox con los nombres de los puertos seriales disponibles */
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        String[] portNames = SerialPortList.getPortNames(); //Obtiene los nombres de los puertos seriales
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(portNames)); //Se envían al jComboBox
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(portNames));
    }//GEN-LAST:event_formWindowOpened
/** Método para salir del jFrame */ 
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:        
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
   
}
