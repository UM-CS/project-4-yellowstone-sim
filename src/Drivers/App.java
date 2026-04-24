package Drivers;

import javax.swing.JFrame;

public class App {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Yellowstone Simulation");

        Sim sim = new Sim(5);

        frame.add(sim);
        frame.setSize(1500, 1500); // adjust as needed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // center screen
        frame.setVisible(true);

    }
}