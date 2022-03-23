import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class Algoritmo extends Thread {
    public Object datos[][];
    public int pasos;
    private volatile javax.swing.JPanel panelGraficas;
    private volatile javax.swing.JRadioButton sort2;
    private volatile javax.swing.JRadioButton sort3;
    private volatile javax.swing.JRadioButton bubblesort;
    private volatile javax.swing.JRadioButton ascendente;
    private volatile javax.swing.JRadioButton descendente;
    private volatile javax.swing.JLabel fieldPasos;
    private String tituloGrafica, encabezado_x, encabezado_y;
    private int algoritmo, orden;





    public Algoritmo (int algoritmo, int orden, Object[][] datos, String encabezado_x, String encabezado_y, String tituloGrafica, javax.swing.JRadioButton ascendente, javax.swing.JRadioButton descendente, javax.swing.JRadioButton bubblesort, javax.swing.JRadioButton sort2, javax.swing.JRadioButton sort3, javax.swing.JPanel panelGraficas, javax.swing.JLabel fieldPasos){
        this.datos = datos;
        this.panelGraficas = panelGraficas;
        this.sort2 = sort2;
        this.sort3 = sort3;
        this.bubblesort = bubblesort;
        this.ascendente = ascendente;
        this.descendente = descendente;
        this.fieldPasos = fieldPasos;
        this.tituloGrafica = tituloGrafica;
        this.encabezado_x = encabezado_x;
        this.encabezado_y = encabezado_y;
        this.algoritmo = algoritmo;
        this.orden = orden;

    }


    @Override
    public void run() {
        Cronometro.running.set(true);
        try {
            pasos = 0;
            fieldPasos.setText(Integer.toString(pasos));
            if (algoritmo == 1) { // bubble sort
                if (orden == 1) { // Ascendente
                    for (int i = 0; i < datos.length; i++) {
                        for (int j = 1; j < (datos.length - i); j++) {
                            if ((Double) datos[j - 1][1] > (Double) datos[j][1]) {
                                //Cambiar datos entre ellos
                                Object[] temp = datos[j - 1];
                                datos[j - 1] = datos[j];
                                datos[j] = temp;
                                pasos++;
                                Thread.sleep(2000);
                                graficar();
                                fieldPasos.setText(Integer.toString(pasos));
                            }
                        }
                    }


                } else { // Descendiente
                    for (int i = 0; i < datos.length; i++) {
                        for (int j = 0; j < (datos.length - i - 1); j++) {
                            if ((Double) datos[j + 1][1] > (Double) datos[j][1]) {
                                //Cambiar datos entre ellos
                                Object[] temp = datos[j];
                                datos[j] = datos[j + 1];
                                datos[j + 1] = temp;
                                pasos++;
                                Thread.sleep(2000);
                                graficar();
                                fieldPasos.setText(Integer.toString(pasos));

                            }
                        }
                    }


                }
            } else if (algoritmo == 2) { // Insertion Sort
                if (orden == 1){ // Ascendente
                    for (int j = 1; j < datos.length; j++) {
                        Double key = (Double) datos[j][1];
                        int i = j-1;
                        while ( (i > -1) && ((Double) datos[i][1] > key ) ) {
                            datos[i+1][1] = datos[i][1];
                            i--;
                        }
                        datos[i+1][1] = key;
                        pasos++;
                        Thread.sleep(2000);
                        graficar();
                        fieldPasos.setText(Integer.toString(pasos));

                    }
                } else{
                    for (int j = 1; j < datos.length; j++) {
                        Double key = (Double) datos[j][1];
                        int i = j-1;
                        while ( (i >= 0) && ((Double) datos[i][1] < key ) ) {
                            datos[i+1][1] = datos[i][1];
                            i--;
                        }
                        datos[i+1][1] = key;
                        pasos++;
                        Thread.sleep(2000);
                        graficar();
                        fieldPasos.setText(Integer.toString(pasos));

                    }
                }
            } else if (algoritmo == 3) { // Shell sort
                if (orden == 1){ // Ascendente
                    int n = datos.length;
                    for (int dist = n/2; dist > 0; dist /= 2)
                    {
                        for (int i = dist; i < n; i ++)
                        {

                            Object[] temp = datos[i];

                            int j;
                            for (j = i; j >= dist && (Double) datos[j - dist][1] > (Double) temp[1]; j -= dist)
                                datos[j] = datos[j - dist];

                            datos[j] = temp;
                            pasos++;
                            Thread.sleep(2000);
                            graficar();
                            fieldPasos.setText(Integer.toString(pasos));
                        }
                    }

                } else{
                    int n = datos.length;
                    for (int dist = n/2; dist > 0; dist /= 2)
                    {
                        for (int i = dist; i < n; i ++)
                        {

                            Object[] temp = datos[i];

                            int j;
                            for (j = i; j >= dist && (Double) datos[j - dist][1] < (Double) temp[1]; j -= dist)
                                datos[j] = datos[j - dist];

                            datos[j] = temp;
                            pasos++;
                            Thread.sleep(2000);
                            graficar();
                            fieldPasos.setText(Integer.toString(pasos));
                        }
                    }
                }
            }

            //Al terminar de ordenar
            Cronometro.running.set(false);




        } catch (Exception e){

        }


    }

    private void graficar(){
        panelGraficas.removeAll();
        panelGraficas.repaint();
        panelGraficas.validate();
        DefaultCategoryDataset cd = new DefaultCategoryDataset();
        for (int i = 0; i < datos.length; i++) {
            cd.addValue((Double) datos[i][1], (String) datos[i][0], encabezado_x);
        }

        JFreeChart grafico = ChartFactory.createBarChart(tituloGrafica, encabezado_x, encabezado_y, cd);
        ChartPanel graficoPanel = new ChartPanel(grafico);
        graficoPanel.setPreferredSize(new java.awt.Dimension(500, 400));
        panelGraficas.add(graficoPanel, BorderLayout.CENTER);
        panelGraficas.validate();
    }



}
