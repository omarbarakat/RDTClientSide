package com.rdt;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String configFileName = args[0];
        ClientConfig clientConfig = null;
        try {
            clientConfig = ClientConfig.parseConfigFile(configFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Client client = new Client(clientConfig);
        client.run();
    }
}
