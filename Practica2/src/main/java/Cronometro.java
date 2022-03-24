import javax.swing.*;
import java.util.Observable;
import java.util.concurrent.atomic.AtomicBoolean;

public class Cronometro extends Thread {

    private int minutos, segundos, milisegundos;
    private volatile javax.swing.JLabel lblCronometro;
    public static AtomicBoolean running = new AtomicBoolean(false);
    public static String tiempo;


    public Cronometro (javax.swing.JLabel lblCronometro) {
        this.minutos = 0;
        this.segundos = 0;
        this.milisegundos = 0;
        this.lblCronometro = lblCronometro;
    }

    @Override
    public void run() {
        String tiempo;

        try {

            while (running.get()) {
                tiempo = "";

                if (minutos < 10) {
                    tiempo += "0" + minutos;
                } else {
                    tiempo += minutos;
                }

                tiempo += ":";

                if (segundos < 10) {
                    tiempo += "0" + segundos;
                } else {
                    tiempo += segundos;
                }

                tiempo += ".";

                if (milisegundos < 10) {
                    tiempo += "00" + milisegundos;
                } else if (milisegundos < 100) {
                    tiempo += "0" + milisegundos;
                } else {
                    tiempo += milisegundos;
                }

                lblCronometro.setText(tiempo);
                this.tiempo = tiempo;
                Thread.sleep(1);

                milisegundos++;

                if (milisegundos == 1000) {
                    segundos++;
                    milisegundos = 0;
                    if (segundos == 60) {
                        minutos++;
                        segundos = 0;
                    }
                }

            }

        }
        catch (Exception e){

        }
    }
}
