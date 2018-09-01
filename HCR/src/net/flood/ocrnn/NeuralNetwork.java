
package net.flood.ocrnn;

public class NeuralNetwork {
    static {
        System.loadLibrary("HCR"); 
    }

    private long nativeHandle; //Hold pointer to c++ neural_net object

    public NeuralNetwork(double learningRate, int inputNodes, int hiddenNodes, int outputNodes) {
        init(learningRate, inputNodes, hiddenNodes, outputNodes);
    }

    public native void init(double learningRate, int inputNodes, int hiddenNodes, int outputNodes);

    public native void dispose();

    public native double[] query(double[] inputs);

    
    public native void train(double[] inputs, double[] targets);

    public native void setWih(double[][] wih);

    public native void setWho(double[][] who);

    /**
     * @return thes weights matrix between input and hidden layers.
     */
    public native double[][] getWih();

    /**
     * @return the weights matrix between hidden and output layers.
     */
    public native double[][] getWho();

    /**
     * @return the network learning rate.
     */
    public native double getLearningRate();

    /**
     * @return the amount of input layer nodes.
     */
    public native int getInputNodes();

    /**
     * @return the amount of hidden layer nodes.
     */
    public native int getHiddenNodes();

    /**
     * @return the amount of output layer nodes.
     */
    public native int getOutputNodes();
}
