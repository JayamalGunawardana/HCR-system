
package net.flood.ocrnn;


import net.flood.ocrnn.ui.MainFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import net.flood.ocrnn.ui.login;
import net.flood.ocrnn.util.DBConnect;
import net.flood.ocrnn.util.LOGIN;

public class NumberIden {

    /**
     * @param args the command line arguments
     */
    
    public static NeuralNetwork network;
    public static MainFrame frame;
    public static ExecutorService queryExecutor;
    public static ExecutorService trainExecutor;
    public static ScheduledExecutorService testExecutor;
    public static login Login;
    
    public static void main(String[] args) throws InterruptedException, Exception {
        
        LOGIN oblog= new LOGIN();
        oblog.setVisible(true);
        
        queryExecutor = Executors.newSingleThreadExecutor();
        trainExecutor = Executors.newSingleThreadExecutor();
        testExecutor = Executors.newSingleThreadScheduledExecutor();

        //Initialize a new neaural network with 0.1 learning rate, 784 inputs, 200 hidden nodes and 10 outputs
        network = new NeuralNetwork(0.1, 784, 200, 24); //(0.1, 784, 200, 10)

    }

    public static CharacterQueryTask query(BufferedImage img) {
        CharacterQueryTask task = new CharacterQueryTask(img);
        queryExecutor.submit(task);
        return task;
    }
    
}
