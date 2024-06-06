package com.codingbee.neural_network.neural_network;

import com.codingbee.neural_network.exceptions.IncorrectDataException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Network {
    private int networkNo;
    private List<List<Neuron>> hiddenLayers;
    private List<Neuron> outputLayer;
    private int[] hiddenLayersSizes;
    private int inputLayerSize, outputLayerSize;

    /**Creates new Network object based on the parameters it is given.
     *
     * @param inputLayerSize amount of parameters passed to the input layer of the network. Must be higher than 0.
     * @param outputLayerSize the number of outcomes in the output layer. Must be higher than 0.
     * @param hiddenLayersSizes array of numbers which determine how many neurons will each hidden layer have. If it is null no hidden layer will be crated.
     * @param networkNo number which the network will be assigned to in the file system. Needs to be unique from the rest to work properly.
     *
     * @throws IncorrectDataException if requirements of the parameters are not fulfilled.
     */
    public Network(int inputLayerSize, int outputLayerSize, int[] hiddenLayersSizes, int networkNo) throws IncorrectDataException {
        if (inputLayerSize<1) throw new IncorrectDataException("Network constructor - input layer size");
        if (outputLayerSize<1) throw new IncorrectDataException("Network constructor - output layer size");
        if (hiddenLayersSizes!=null) for (int hiddenLayerSize : hiddenLayersSizes) {
            if (hiddenLayerSize < 1) throw new IncorrectDataException("Network constructor - hidden layers sizes");
        }
        this.inputLayerSize = inputLayerSize;
        this.outputLayerSize = outputLayerSize;
        this.hiddenLayersSizes = hiddenLayersSizes;
        this.networkNo = networkNo;
        hiddenLayers = new ArrayList<>();
        outputLayer = new ArrayList<>();

    }

    public void createRandomNeuronValuesInDir(String path, boolean initAfterwards){
        //DATA RANDOM
        try {
            Files.createDirectories(Paths.get(path));
        } catch (IOException e) {
        }
        if(initAfterwards) initNeuronsFromDir(path);

    }
    public void initNeuronsFromDir(String folderPath){

    }
}