package chatgrupal;
import java.awt.event.KeyEvent;
import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Salvador RL
 * 
 */
public class Servidor extends javax.swing.JFrame {
    
    static ServerSocket ss;
     static Socket s;
     static DataInputStream din;
     static DataOutputStream dout;
     static String usuario;
    
    public Servidor() {
        initComponents();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtmensajes = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        txtmensaje = new javax.swing.JTextField();
        btnenviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat - Servidor");
        setIconImage(getIconImage());
        setIconImages(getIconImages());

        txtmensajes.setColumns(20);
        txtmensajes.setRows(5);
        txtmensajes.setFocusable(false);
        jScrollPane1.setViewportView(txtmensajes);

        jLabel1.setText("Mensaje");

        txtmensaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtmensajeKeyPressed(evt);
            }
        });

        btnenviar.setText("Envíar Mensaje");
        btnenviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnenviarActionPerformed(evt);
            }
        });
        btnenviar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnenviarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                    .addComponent(txtmensaje)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnenviar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtmensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(btnenviar, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnenviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnenviarActionPerformed
        // TODO add your handling code here:
        try {
            String msgout = "";
            msgout = txtmensaje.getText().trim();
            dout.writeUTF(usuario + " dice: " +msgout); //enviando el mensaje del servidor al cliente
            txtmensajes.setText(txtmensajes.getText().trim()+"\n"+ usuario + " dice: " +msgout);
            txtmensaje.setText("");
            //msg_text.setFocusable(true);
            txtmensaje.requestFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnenviarActionPerformed

    private void btnenviarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnenviarKeyPressed
                   
    }//GEN-LAST:event_btnenviarKeyPressed

    private void txtmensajeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmensajeKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
       try {
            //Inicializamos la variable que contendrá el mensaje en vacio
            String msgout = "";
            //Llenamos con lo que existe en la caja de texto
            msgout = txtmensaje.getText().trim();
            //damos salida al mensaje que enviamos
            dout.writeUTF(usuario + " dice: " +msgout);
            //Imprimimos lo que enviamos para llevar un historial
            txtmensajes.setText(txtmensajes.getText().trim()+"\n"+ usuario + " dice: " +msgout);
            //Vaciamos la caja de texto de donde salió el mensaje
            txtmensaje.setText("");
            //Hacemos enfoque para no volver a posicionar el mouse sobre la caja de texto
            txtmensaje.setFocusable(true);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }                     
    }//GEN-LAST:event_txtmensajeKeyPressed

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
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                try {
                //Creamos una variable que se comparará con la llamada usuario. Esta variable inicia vacia también
                String user;
                //User será llenada con el nombre de usuario que ingresemos aquí
                user = JOptionPane.showInputDialog(null, "Elija su nombre de usuario", "Programa Servidor", JOptionPane.INFORMATION_MESSAGE);
                //Ciclo while que no dejará que el programa avance mientras el usuario este vacio
                while (user == null || user.equals("")){
                    JOptionPane.showMessageDialog(null, "Debe ingresar un usuario");
                    user = JOptionPane.showInputDialog(null, "Elija su nombre de usuario", "Programa Servidor", JOptionPane.INFORMATION_MESSAGE);
                }
                //Cuando el usuario se llena entonces el programa continúa
                usuario = user;
                new Servidor().setVisible(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,e);
                }
            }
        });
        //Variable que va a contener el mensaje que recibimos del cliente
        String msgin = "";
        
        try {
            
            ss = new ServerSocket(7896); // El servidor inicia en el puerto 1201
            s = ss.accept(); //ahora el server va a aceptar las conexiones
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            while(!msgin.equals("exit")) {
                msgin = din.readUTF();
                txtmensajes.setText(txtmensajes.getText().trim()+"\n"+msgin);//muestra el mensaje desde el cliente
                //JOptionPane.showMessageDialog(null, msgin);
                //jmensajes.setText(auxiliar+ usuario + " Dice: " + message + "\r\n");
                //msg_area.setText("Cliente dice: " + msgin + "\r\n");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnenviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtmensaje;
    private static javax.swing.JTextArea txtmensajes;
    // End of variables declaration//GEN-END:variables
}
