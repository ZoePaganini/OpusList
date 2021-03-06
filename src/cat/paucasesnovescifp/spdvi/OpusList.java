/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.paucasesnovescifp.spdvi;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

/**
 *
 * @author Alumne
 */
public class OpusList extends javax.swing.JFrame {
    private static final java.lang.reflect.Type LIST_OF_OBRA_TYPE = new TypeToken<List<Obra>>() {}.getType();
    static final String pathJson = "\\AppData\\Local\\OpusList\\data\\obres.json";
    static final String pathImage = "\\AppData\\Local\\OpusList\\images\\";
    public static ArrayList<Obra> obras = new ArrayList<Obra>();
    Gson gson = new Gson();
    //UpdateDialog updateDialog = new UpdateDialog(this, true);
    //UpdateDialog2 updateData = new UpdateDialog2(this, true);
    /**
     * Creates new form OpusList
     */
    public OpusList() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstObras = new javax.swing.JList<>();
        lblObra = new javax.swing.JLabel();
        mnuBarra = new javax.swing.JMenuBar();
        mnuMenu = new javax.swing.JMenu();
        mniInsert = new javax.swing.JMenuItem();
        mniUpdate = new javax.swing.JMenuItem();
        mniDelete = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Opus List");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lstObras.setToolTipText("");
        lstObras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstObrasMouseClicked(evt);
            }
        });
        lstObras.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstObrasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstObras);

        mnuMenu.setText("Menu");
        mnuMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMenuActionPerformed(evt);
            }
        });

        mniInsert.setText("Insert new Opus");
        mniInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniInsertActionPerformed(evt);
            }
        });
        mnuMenu.add(mniInsert);

        mniUpdate.setText("Update Opus");
        mniUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniUpdateActionPerformed(evt);
            }
        });
        mnuMenu.add(mniUpdate);

        mniDelete.setText("Delete Opus");
        mniDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDeleteActionPerformed(evt);
            }
        });
        mnuMenu.add(mniDelete);

        mnuBarra.add(mnuMenu);

        setJMenuBar(mnuBarra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(lblObra, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblObra, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstObrasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstObrasValueChanged
        String selectedObra = lstObras.getSelectedValue();
         if (selectedObra != null) {
            int lastIndex = selectedObra.indexOf(":");
            String selectedObraReg = selectedObra.substring(0, lastIndex);
            for(Obra o : obras)
            {
                if(o.getRegistre().equals(selectedObraReg))
                {
                    BufferedImage bufferedImage = null;
                    try {
                        bufferedImage = ImageIO.read(new File(System.getProperty("user.home") + pathImage + o.getImatge()));
                        ImageIcon icon = resizeImageIcon(bufferedImage, lblObra.getWidth(), lblObra.getHeight());
                        lblObra.setIcon(icon);
            
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                }
            }
         }
    }//GEN-LAST:event_lstObrasValueChanged

    private void mnuMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMenuActionPerformed

    }//GEN-LAST:event_mnuMenuActionPerformed

    private void mniInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniInsertActionPerformed
        InsertDialog insertDialog = new InsertDialog(this, true);
        insertDialog.setVisible(true);
        try {
        if (insertDialog.fileChooser.getSelectedFile() == null)
        {
            EncuestaDialog aviso = new EncuestaDialog(this, true);
            aviso.getLblMessage().setText("No tiene foto de perfil. Pulse OK para elegir una.");
            aviso.setVisible(true);
            if(aviso.imagen == true)
                
                insertDialog.fileChooser.showOpenDialog(this);
        }
        BufferedImage bufferedimage = ImageIO.read(new File(insertDialog.fileChooser.getSelectedFile().getAbsolutePath()));
        String outputImageAbsolutePath = System.getProperty("user.home")+  pathImage + insertDialog.fileChooser.getSelectedFile().getName();
        File outputImage = new File(outputImageAbsolutePath);   
        ImageIO.write(bufferedimage, "jpg", outputImage);
        
        if (insertDialog.confirm == true)
        {
            Obra obra = new Obra(insertDialog.registre, insertDialog.titol, insertDialog.any, insertDialog.format, insertDialog.autor, insertDialog.imatge);
            obras.add(obra);
            guardarJSON();
            UpdateListView();
        }
       
        } catch (IOException ex) {
           EncuestaDialog encuesta = new EncuestaDialog(this, true);
           encuesta.getLblMessage().setText(ex.getMessage());
           encuesta.setVisible(true);
        }      
    }//GEN-LAST:event_mniInsertActionPerformed

    public void writeObrasJSON(JsonWriter writer, Obra obra) throws IOException {
     writer.beginObject();
     writer.name("registre").value(obra.getRegistre());
     writer.name("titol").value(obra.getTitol());
     writer.name("any").value(obra.getAny());
     writer.name("format").value(obra.getFormat());
     writer.name("autor").value(obra.getAutor());
     writer.name("imatge").value(obra.getImatge());
     writer.endObject();
   }
    
    public void guardarJSON() throws IOException
    {
        JsonWriter writer = new JsonWriter(new FileWriter(System.getProperty("user.home") + pathJson));
        writer.beginArray();
        for (Obra o: obras)
        {   
            writeObrasJSON(writer, o);
        }
        writer.endArray();
        writer.close();
    }
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            JsonReader reader = new JsonReader(new FileReader(System.getProperty("user.home") + pathJson));
            obras = gson.fromJson(reader, LIST_OF_OBRA_TYPE);
            DefaultListModel obrasListModel = new DefaultListModel();
            for (Obra o: obras) {
                obrasListModel.addElement(o.toString());
            }
            lstObras.setModel(obrasListModel);
        }
        catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }//GEN-LAST:event_formWindowOpened

    private void mniUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniUpdateActionPerformed
        UpdateDialog updateDialog = new UpdateDialog(this, true);
        try {
        updateDialog.setVisible(true);
        EncuestaDialog aviso = new EncuestaDialog(this, true);
        UpdateDialog2 updateData = new UpdateDialog2(this, true);
        for (Obra o: obras) {
            if(o.getRegistre().equals(updateDialog.registre)) {
                updateDialog.isValid = true;
            }
        }
        if(updateDialog.isValid == false) 
        {
            aviso.getLblMessage().setText("No existe una obra con ese registro.") ;
            aviso.setVisible(true);
        } else {
            for (Obra o: obras)
            {
                if(o.getRegistre().equals(updateDialog.registre))
                {
                    try {
                        updateData.getTxtAutor().setText(o.getAutor());
                        updateData.getTxtTitol().setText(o.getTitol());
                        updateData.getTxtFormat().setText(o.getFormat());
                        updateData.getTxtAny().setText(o.getAny());
                        BufferedImage bufferedImage = ImageIO.read(new File(System.getProperty("user.home") + pathImage + o.getImatge()));
                        ImageIcon icon = resizeImageIcon(bufferedImage, updateData.getLblImatge().getWidth(), updateData.getLblImatge().getHeight());
                        updateData.getLblImatge().setIcon(icon);
            
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                    updateData.setVisible(true);
                    o.setAutor(updateData.autor);
                    o.setTitol(updateData.titol);
                    o.setFormat(updateData.format);
                    o.setImatge(updateData.imatge);
                    o.setAny(updateData.any);
                }
            }
        }
               
        if(updateData.confirma == true){
            guardarJSON();
            UpdateListView();
        }
        
        } catch(IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_mniUpdateActionPerformed

    private void lstObrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstObrasMouseClicked
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
        evt.consume();
        
        UpdateDialog updateDialog = new UpdateDialog(this, true);
        UpdateDialog2 updateData = new UpdateDialog2(this, true);
        
        String selectedObra = lstObras.getSelectedValue();
        int lastIndex = selectedObra.indexOf(":");
        String selectedObraReg = selectedObra.substring(0, lastIndex);
        
        try {
        updateDialog.getTxtRegistro().setText(selectedObraReg);
        updateDialog.setVisible(true); 
        
        for (Obra o: obras)
            {
                if(o.getRegistre().equals(updateDialog.registre))
                {
                    try {
                        updateData.getTxtAutor().setText(o.getAutor());
                        updateData.getTxtTitol().setText(o.getTitol());
                        updateData.getTxtFormat().setText(o.getFormat());
                        updateData.getTxtAny().setText(o.getAny());
                        BufferedImage bufferedImage = null;
                        bufferedImage = ImageIO.read(new File(System.getProperty("user.home") + pathImage + o.getImatge()));
                        ImageIcon icon = resizeImageIcon(bufferedImage, updateData.getLblImatge().getWidth(), updateData.getLblImatge().getHeight());
                        updateData.getLblImatge().setIcon(icon);
            
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                    updateData.setVisible(true);
                    o.setAutor(updateData.autor);
                    o.setTitol(updateData.titol);
                    o.setFormat(updateData.format);
                    o.setImatge(updateData.imatge);
                    o.setAny(updateData.any);
                }
            }
                
        if(updateData.confirma == true){
            guardarJSON();
            UpdateListView();
        }
    } catch(IOException e) {
            e.printStackTrace();
        }
        }
    }//GEN-LAST:event_lstObrasMouseClicked

    private void mniDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDeleteActionPerformed
        DeleteDialog deleteDialog = new DeleteDialog(this, true);
        
        try {
        deleteDialog.setVisible(true);
        String selectedObra = deleteDialog.tituloEliminado;
            
        for(Obra o: obras) {
            if(o.getTitol().equals(selectedObra)) {
                obras.remove(o);
                break;
            }
        }
        DefaultListModel obraListModel = new DefaultListModel();
        for(Obra o: obras) {
            obraListModel.addElement(o.toString());
        }
        lstObras.setModel(obraListModel);
        
        
        guardarJSON();
        UpdateListView();
        } catch (IOException e) {
            e.getStackTrace();
        }
        
    }//GEN-LAST:event_mniDeleteActionPerformed

    private ImageIcon resizeImageIcon (BufferedImage originalImage, int desiredWidth, int desiredHeight) {
        int newHeight = 0;    
        int newWidth = 0;
        float aspectRatio = (float)originalImage.getWidth() / originalImage.getHeight();
        if (originalImage.getWidth() > originalImage.getHeight()) {
            newWidth = desiredWidth;
            newHeight = Math.round( desiredWidth / aspectRatio);                
        }
        else {
            newHeight = desiredHeight;
            newWidth = Math.round(desiredHeight * aspectRatio);
        }
        Image resultingImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        BufferedImage outputImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
        ImageIcon imageIcon = new ImageIcon(outputImage);
        return imageIcon;
    }
    
    private void UpdateListView() {
        DefaultListModel obrasListModel = new DefaultListModel();
        for(Obra u: obras) {
            obrasListModel.addElement(u.toString());
        }
        lstObras.setModel(obrasListModel);
    }
    
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
            java.util.logging.Logger.getLogger(OpusList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OpusList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OpusList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OpusList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OpusList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblObra;
    private javax.swing.JList<String> lstObras;
    private javax.swing.JMenuItem mniDelete;
    private javax.swing.JMenuItem mniInsert;
    private javax.swing.JMenuItem mniUpdate;
    private javax.swing.JMenuBar mnuBarra;
    private javax.swing.JMenu mnuMenu;
    // End of variables declaration//GEN-END:variables
}
