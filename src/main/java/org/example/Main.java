package org.example;
import javax.swing.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.awt.*;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Exemplo JCombobox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        JPanel panel = new JPanel();
        frame.add(panel);

        final JPanel contentPanel = (JPanel) frame.getContentPane();
        frame.setVisible(true);

        try {
            while (true) {
                String path = "https://testeinfnet.000webhostapp.com/arquivo.txt";
                Document doc = Jsoup.connect(path).get();
                System.out.println(doc);

                String corSelecionada = doc.toString();
                System.out.println(corSelecionada);

                if (corSelecionada.indexOf('2') != 1)
                    contentPanel.setBackground(Color.RED);
                else if (corSelecionada.indexOf('1') != 1)
                    contentPanel.setBackground(Color.YELLOW);
                else if (corSelecionada.indexOf('0') != 1)
                    contentPanel.setBackground(Color.GREEN);
                Thread.sleep(2000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
