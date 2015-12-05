package com.rdt;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Client {

    private DatagramSocket welcomingSocket;
    private int maxN;
    private long rngSeed;
    private float plp;
    private float pep = 0.05f;
    private String strategy;

    private static final int EXPECTED_REQ_SIZE = 2048;

    public Client(ClientConfig serverConfig){

    }

    public Client(int port, int maxN, long rngSeed, float plp, String strategy) throws SocketException {
        try {
            welcomingSocket = new DatagramSocket(port);
        } catch (SocketException e) {
            throw e;
        }

        this.maxN = maxN;
        this.rngSeed = rngSeed;
        this.plp = plp;
        this.strategy = strategy;
    }

    public void run() {

//            DatagramPacket pkt = new DatagramPacket(new byte[EXPECTED_REQ_SIZE], EXPECTED_REQ_SIZE);
//
//            try {
//                welcomingSocket.receive(pkt);
//            } catch (IOException e) {
//                continue;
//            }

            String fileName = "";
            Thread connectionHandler = new Thread(
                    new ConnectionHandler(strategy, fileName,
                    plp, pep,  rngSeed, maxN)
            );
            connectionHandler.start();
    }

}