import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

class ArchivoTraducido {
    
    public Object[][] datos;    
    public String encabezado_x;
    public String encabezado_y;
    public ChartPanel grafica;
    public String titulo;

       
    
    public ArchivoTraducido(File archivo, String titulo){
        StringBuilder sb = new StringBuilder();
        if (archivo.exists() && archivo.canRead()) {
            BufferedReader bReader = null;
            try {
                bReader = Files.newBufferedReader(archivo.toPath(), StandardCharsets.UTF_8);
                String line;
                while ((line = bReader.readLine()) != null) {
                    sb.append(line+"\n");

                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                if (bReader != null) {
                    try {
                        bReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        String textoDelArchivo = sb.toString();        
        String lineas[] = textoDelArchivo.split("\n");
        datos = new Object[lineas.length-1][2];
        String titulos[] = lineas[0].split(",");
        encabezado_x = titulos[0];
        encabezado_y = titulos[1];
        for (int i = 1; i < lineas.length; i++) {
            String columnas[] = lineas[i].split(",");
            datos[i-1][0] = columnas[0];
            datos[i-1][1] = Double.parseDouble(columnas[1]);
        }
           
        
        DefaultCategoryDataset cd = new DefaultCategoryDataset();
        for (int i = 0; i < datos.length; i++) {
            cd.addValue((Double)datos[i][1], (String)datos[i][0],encabezado_x);
        }
        this.titulo = titulo;
        JFreeChart grafico = ChartFactory.createBarChart(titulo, encabezado_x, encabezado_y, cd);
        ChartPanel graficoPanel = new ChartPanel(grafico);
        graficoPanel.setPreferredSize(new java.awt.Dimension(500,400));
        grafica = graficoPanel;      
        
       
    }
      
    
}
