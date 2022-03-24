import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.UUID;


public class Algoritmo extends Thread {
    private Object[][] datosIniciales;
    private Object[][] datos;
    private int pasos;
    private volatile javax.swing.JPanel panelGraficas;
    private volatile javax.swing.JRadioButton sort2;
    private volatile javax.swing.JRadioButton sort3;
    private volatile javax.swing.JRadioButton bubblesort;
    private volatile javax.swing.JRadioButton ascendente;
    private volatile javax.swing.JRadioButton descendente;
    private volatile javax.swing.JLabel fieldPasos;
    private String tituloGrafica, encabezado_x, encabezado_y;
    private int algoritmo, orden;
    private String tiempo, ordenString, algoritmoString;
    private String nombrePrimeraFoto, nombreSegundaFoto;




    public Algoritmo (int algoritmo, int orden, Object[][] datos, String encabezado_x, String encabezado_y, String tituloGrafica, JRadioButton ascendente, JRadioButton descendente, JRadioButton bubblesort, JRadioButton sort2, JRadioButton sort3, JPanel panelGraficas, JLabel fieldPasos){

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

        datosIniciales = new Object[datos.length][2];
        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < 2; j++) {
                datosIniciales[i][j]= datos[i][j];
            }
        }

        // Crear imagen de gráfica desordenada
        DefaultCategoryDataset cd = new DefaultCategoryDataset();
        for (int i = 0; i < datosIniciales.length; i++) {
            cd.addValue((Double) datosIniciales[i][1], (String) datosIniciales[i][0], encabezado_x);
        }
        JFreeChart grafico = ChartFactory.createBarChart(tituloGrafica, encabezado_x, encabezado_y, cd);
        nombrePrimeraFoto = String.valueOf(UUID.randomUUID());
        File bar = new File("src/main/java/img/" + nombrePrimeraFoto + ".png");
        try {
            ChartUtils.saveChartAsPNG(bar, grafico, 1000, 700);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    @Override
    public void run() {
        Cronometro.running.set(true);
        try {
            pasos = 0;
            fieldPasos.setText(Integer.toString(pasos));
            if (algoritmo == 1) { // bubble sort
                algoritmoString = "Bubble sort";
                if (orden == 1) { // Ascendente
                    ordenString = " Ascendente";
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


                } else { // Descendente
                    ordenString = " Descendente";
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
                algoritmoString = "Insertion Sort";
                if (orden == 1){ // Ascendente
                    ordenString = " Ascendente";
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
                    ordenString = " Descendente";
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
                algoritmoString = "Shell Sort";
                if (orden == 1){ // Ascendente
                    ordenString = " Ascendente";
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
                    ordenString = " Descendente";
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
            tiempo = Cronometro.tiempo;

            // Crear imagen de gráfica ordenada
            DefaultCategoryDataset cd = new DefaultCategoryDataset();
            for (int i = 0; i < datos.length; i++) {
                cd.addValue((Double) datos[i][1], (String) datos[i][0], encabezado_x);
            }
            JFreeChart grafico = ChartFactory.createBarChart(tituloGrafica, encabezado_x, encabezado_y, cd);
            nombreSegundaFoto = String.valueOf(UUID.randomUUID());
            File bar = new File("src/main/java/img/" + nombreSegundaFoto + ".png");
            try {
                ChartUtils.saveChartAsPNG(bar, grafico, 1000, 700);
            } catch (IOException e) {
                e.printStackTrace();
            }

            generarHTML();
            JOptionPane.showMessageDialog(null, "Gráfica ordenada exitosamente, ya se ha generado el reporte.", "Gráfica ordenada", JOptionPane.INFORMATION_MESSAGE);




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

    private void generarHTML() {
        //Nombre del archivo
        LocalTime hora = LocalTime.now();
        String nombreArchivo = tituloGrafica + "_" + hora.getHour() + "_" + hora.getMinute() + "_" + hora.getSecond();

        try {
            //Crear archivo
            File archivo = new File(nombreArchivo + ".html");
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("Ya existe un archivo con ese nombre.");
            }

            // Escribimos en el archivo
            FileWriter writer = new FileWriter(nombreArchivo + ".html");
            writer.write("<html>");
            writer.write("<head>");
            writer.write("<title>" +  tituloGrafica + "</title>");
            writer.write("</head>");
            writer.write("<body>");
            writer.write("<p style=\"text-align: center;\"><strong>Sergio Andr&eacute; Lima Corado</strong><strong></strong></p>\n" +
                    "<p style=\"text-align: center;\"><strong>202100154</strong></p>\n" +
                    "<hr />\n" +
                    "<p style=\"text-align: center;\"><strong>Algoritmo Emplado:</strong></p>\n" +
                    "<p style=\"text-align: center;\">" + algoritmoString + ordenString + "</p>\n" +
                    "<p style=\"text-align: center;\"></p>\n" +
                    "<p style=\"text-align: center;\"><strong>Tiempo Transcurrido:</strong></p>\n" +
                    "<p style=\"text-align: center;\">" + tiempo + "</p>\n" +
                    "<p style=\"text-align: center;\"></p>\n" +
                    "<p style=\"text-align: center;\"><strong>Cantidad de Pasos:</strong></p>\n" +
                    "<p style=\"text-align: center;\">"+ pasos +"</p>\n" +
                    "<hr />\n" +
                    "<p style=\"text-align: center;\"><strong>Datos sin Ordenar</strong></p>\n" +
                    "<table border=\"1\" style=\"height: 20px; width: 90%; border-collapse: collapse; margin-left: auto; margin-right: auto;\">\n" +
                    "<tbody>\n");

            int porcentaje = 100 / (datosIniciales.length + 1);
            for (int j = 0; j < 2; j++) {
                writer.write("<tr style=\"height: 10px;\">\n");
                if (j == 0) {
                    writer.write("<td style=\"width: "+ porcentaje + "%; height: 10px; text-align: center;\">" + encabezado_x + "</td>\n");
                } else {
                    writer.write("<td style=\"width: "+ porcentaje + "%; height: 10px; text-align: center;\">" + encabezado_y + "</td>\n");
                }
                for (int i = 0; i < datosIniciales.length; i++) {
                    String celda;
                    if(j == 0){
                        celda = (String)datosIniciales[i][j];
                    } else
                        celda = Double.toString((Double)datosIniciales[i][j]);
                    writer.write( "<td style=\"width: "+ porcentaje + "%; height: 10px; text-align: center;\">"+ celda +"</td>\n");
                }
                writer.write("</tr>\n");
            }

            writer.write("</tbody>\n" + "</table>\n" + "<p><img src=\"src/main/java/img/" + nombrePrimeraFoto + ".png\" alt=\"sdadsa\" width=\"1000\" height=\"700\" style=\"display: block; margin-left: auto; margin-right: auto;\" /></p>\n" +
                    "<hr />\n" + "<p style=\"text-align: center;\"><strong>Datos Ordenados</strong></p>\n" +
                    "<table border=\"1\" style=\"height: 20px; width: 90%; border-collapse: collapse; margin-left: auto; margin-right: auto;\">\n" +
                    "<tbody>\n");

            for (int j = 0; j < 2; j++) {
                writer.write("<tr style=\"height: 10px;\">\n");
                if (j == 0) {
                    writer.write("<td style=\"width: "+ porcentaje + "%; height: 10px; text-align: center;\">" + encabezado_x + "</td>\n");
                } else {
                    writer.write("<td style=\"width: "+ porcentaje + "%; height: 10px; text-align: center;\">" + encabezado_y + "</td>\n");
                }
                for (int i = 0; i < datos.length; i++) {
                    String celda;
                    if(j == 0){
                        celda = (String)datos[i][j];
                    } else
                        celda = Double.toString((Double)datos[i][j]);
                    writer.write( "<td style=\"width: "+ porcentaje + "%; height: 10px; text-align: center;\">"+ celda +"</td>\n");
                }
                writer.write("</tr>\n");
            }

            writer.write("</tbody>\n" + "</table>\n" + "<p><img src=\"src/main/java/img/" + nombreSegundaFoto + ".png\" alt=\"sdadsa\" width=\"1000\" height=\"700\" style=\"display: block; margin-left: auto; margin-right: auto;\" /></p>");

            writer.write("</body>");
            writer.write("</html>");
            writer.close();
            System.out.println("Archivo sobrescrito con éxito.");





        } catch (IOException e) {
            System.out.println("Error.");
            e.printStackTrace();
        }

       //




    }



}
