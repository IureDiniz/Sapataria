package aplication;

import static factory.ConnectionFactory.connect;
import TerminalTest.TerminalTest;

public class Aplication {

    
    public static void main(String[] args) {
        connect();
        TerminalTest.menu();
    }
    
}
