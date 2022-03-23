
import java.awt.BorderLayout;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;



public class ventana extends javax.swing.JFrame {

    private boolean graficaGenerada;
    private ArchivoTraducido archivoTraducido;
    private String tiempoCronometro;
    private Object[][] datos, datosIniciales;
    private String tituloGrafica, encabezado_x, encabezado_y;


    
    public ventana() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        orden = new javax.swing.ButtonGroup();
        algoritmo = new javax.swing.ButtonGroup();
        jFileChooser1 = new javax.swing.JFileChooser();
        panelGraficas = new javax.swing.JPanel();
        fieldRutaArchivo = new javax.swing.JTextField();
        fieldTituloGrafica = new javax.swing.JTextField();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        botonExaminar = new javax.swing.JButton();
        botonGenerarGrafica = new javax.swing.JButton();
        ascendente = new javax.swing.JRadioButton();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        descendente = new javax.swing.JRadioButton();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        sort2 = new javax.swing.JRadioButton();
        bubblesort = new javax.swing.JRadioButton();
        sort3 = new javax.swing.JRadioButton();
        botonOrdenar = new javax.swing.JButton();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        fieldPasos = new javax.swing.JLabel();
        fieldCronometro = new javax.swing.JLabel();

        jFileChooser1.setCurrentDirectory(new java.io.File("C:\\Program Files\\NetBeans-12.6\\*"));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(61, 64, 91));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        panelGraficas.setMinimumSize(new java.awt.Dimension(500, 200));
        panelGraficas.setPreferredSize(new java.awt.Dimension(500, 400));
        panelGraficas.setLayout(new java.awt.BorderLayout());

        fieldRutaArchivo.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        fieldRutaArchivo.setText("INGRESE RUTA DEL ARCHIVO");
        fieldRutaArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldRutaArchivoActionPerformed(evt);
            }
        });

        fieldTituloGrafica.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Cronómetro");
        jLabel1.setToolTipText("");
        jLabel1.setFocusable(false);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        jLabel2.setText("Ruta del Archivo");

        botonExaminar.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        botonExaminar.setText("Examinar");
        botonExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonExaminarActionPerformed(evt);
            }
        });

        botonGenerarGrafica.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        botonGenerarGrafica.setText("Generar Gráfica");
        botonGenerarGrafica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGenerarGraficaActionPerformed(evt);
            }
        });

        orden.add(ascendente);
        ascendente.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        ascendente.setText("Ascendente");
        ascendente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ascendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ascendenteActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        jLabel3.setText("Título de la Gráfica");

        orden.add(descendente);
        descendente.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        descendente.setText("Descendente");
        descendente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        descendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descendenteActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Algoritmo");
        jLabel4.setToolTipText("");
        jLabel4.setFocusable(false);
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        algoritmo.add(sort2);
        sort2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        sort2.setText("Merge Sort");
        sort2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sort2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sort2ActionPerformed(evt);
            }
        });

        algoritmo.add(bubblesort);
        bubblesort.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        bubblesort.setText("Bubble Sort");
        bubblesort.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bubblesort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bubblesortActionPerformed(evt);
            }
        });

        algoritmo.add(sort3);
        sort3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        sort3.setText("Sort sort Sort");
        sort3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sort3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sort3ActionPerformed(evt);
            }
        });

        botonOrdenar.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        botonOrdenar.setText("Ordenar");
        botonOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonOrdenarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 30)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Orden");
        jLabel5.setToolTipText("");
        jLabel5.setFocusable(false);
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Pasos");
        jLabel6.setToolTipText("");
        jLabel6.setFocusable(false);
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fieldPasos.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        fieldPasos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fieldPasos.setText("0");
        fieldPasos.setToolTipText("");
        fieldPasos.setFocusable(false);
        fieldPasos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fieldCronometro.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        fieldCronometro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fieldCronometro.setText("00:00:00");
        fieldCronometro.setToolTipText("");
        fieldCronometro.setFocusable(false);
        fieldCronometro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelGraficas, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(fieldRutaArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
                                .addComponent(fieldTituloGrafica)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonGenerarGrafica, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                            .addComponent(botonExaminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(sort3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                            .addComponent(sort2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bubblesort, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(descendente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ascendente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(botonOrdenar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fieldPasos, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldCronometro, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fieldRutaArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonExaminar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldTituloGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(botonGenerarGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(ascendente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(descendente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bubblesort)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sort2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sort3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonOrdenar)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldCronometro, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldPasos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelGraficas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldRutaArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldRutaArchivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldRutaArchivoActionPerformed

    private void botonExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExaminarActionPerformed
        // TODO add your handling code here:
        int result = this.jFileChooser1.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION){
            File archivo = this.jFileChooser1.getSelectedFile();
            fieldRutaArchivo.setText(archivo.getPath());
        }
    }//GEN-LAST:event_botonExaminarActionPerformed

    private void botonGenerarGraficaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGenerarGraficaActionPerformed
        // TODO add your handling code here:
        panelGraficas.removeAll();        
        panelGraficas.repaint();
        panelGraficas.validate();
        graficaGenerada = false;
        
        
        if(!fieldRutaArchivo.getText().trim().equals("") && !fieldTituloGrafica.getText().trim().equals("")){
                      
            
            try {
                File archivo = new File(fieldRutaArchivo.getText());
                archivoTraducido = new ArchivoTraducido(archivo, fieldTituloGrafica.getText());
                tituloGrafica = archivoTraducido.titulo;
                encabezado_x = archivoTraducido.encabezado_x;
                encabezado_y = archivoTraducido.encabezado_y;
                panelGraficas.add(archivoTraducido.grafica, BorderLayout.CENTER); 
                panelGraficas.validate();
                graficaGenerada = true;
                datos = archivoTraducido.datos;
                datosIniciales = archivoTraducido.datos;
                
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Documento o ruta no válida. ", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        }else {

            JOptionPane.showMessageDialog(null, "Debe de elegir un archivo y un título.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonGenerarGraficaActionPerformed

    private void ascendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ascendenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ascendenteActionPerformed

    private void descendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descendenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descendenteActionPerformed

    private void sort2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sort2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sort2ActionPerformed

    private void bubblesortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bubblesortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bubblesortActionPerformed

    private void sort3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sort3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sort3ActionPerformed

    private void botonOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonOrdenarActionPerformed
        // TODO add your handling code here:
        if (graficaGenerada) {

            // Desactivamos para evitar errores
            fieldTituloGrafica.setEnabled(false);
            botonOrdenar.setEnabled(false);
            botonGenerarGrafica.setEnabled(false);
            botonExaminar.setEnabled(false);

            //guardar foto de gráfica inicial

            if (esAlgoritmoValido()) {


                //Iniciamos cronómetro y algoritmo

                Algoritmo ordenamiento = new Algoritmo(algoritmo(),orden(),datos, encabezado_x, encabezado_y, tituloGrafica, ascendente, descendente, bubblesort, sort2, sort3, panelGraficas, fieldPasos);
                new Cronometro(fieldCronometro).start();
                ordenamiento.start();

                tiempoCronometro = fieldCronometro.getText();

            } else {
                fieldCronometro.setText("00:00.000");
                JOptionPane.showMessageDialog(null, "Debe de elegir el orden y el algoritmo para ordenar la gráfica", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

            //Volvemos a activar
            fieldTituloGrafica.setEnabled(true);
            botonOrdenar.setEnabled(true);
            botonGenerarGrafica.setEnabled(true);
            botonExaminar.setEnabled(true);
        } else  {
            JOptionPane.showMessageDialog(null, "Para ordenar debe de primero generar una gráfica.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_botonOrdenarActionPerformed

    private int orden() {
        if(ascendente.isSelected()){
            return 1;
        } else
            return 2;
    }

    private int algoritmo() {
        if(bubblesort.isSelected())
            return 1;
        else if(sort2.isSelected())
            return 2;
        else
            return 3;
    }

    private boolean esAlgoritmoValido() {
        return (ascendente.isSelected() || descendente.isSelected()) && (bubblesort.isSelected() || sort2.isSelected() || sort3.isSelected());
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
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup algoritmo;
    private volatile javax.swing.JRadioButton ascendente;
    private javax.swing.JButton botonExaminar;
    private javax.swing.JButton botonGenerarGrafica;
    private javax.swing.JButton botonOrdenar;
    private volatile javax.swing.JRadioButton bubblesort;
    private volatile javax.swing.JRadioButton descendente;
    private volatile javax.swing.JLabel fieldCronometro;
    private volatile javax.swing.JLabel fieldPasos;
    private javax.swing.JTextField fieldRutaArchivo;
    public javax.swing.JTextField fieldTituloGrafica;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.ButtonGroup orden;
    private volatile javax.swing.JPanel panelGraficas;
    private volatile javax.swing.JRadioButton sort2;
    private volatile javax.swing.JRadioButton sort3;

}
