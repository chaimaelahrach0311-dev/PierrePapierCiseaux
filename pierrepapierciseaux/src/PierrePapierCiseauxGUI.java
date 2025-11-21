import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


    public class PierrePapierCiseauxGUI {

        public static void main(String[] args) {
            JFrame frame = new JFrame("Pierre-Papier-Ciseaux");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 1));

            JLabel resultLabel = new JLabel("Choisissez Pierre, Papier ou Ciseaux", SwingConstants.CENTER);
            panel.add(resultLabel);

            JPanel buttonPanel = new JPanel();
            JButton pierreButton = new JButton("Pierre");
            JButton papierButton = new JButton("Papier");
            JButton ciseauxButton = new JButton("Ciseaux");
            buttonPanel.add(pierreButton);
            buttonPanel.add(papierButton);
            buttonPanel.add(ciseauxButton);
            panel.add(buttonPanel);

            JButton rejouerButton = new JButton("Rejouer");
            rejouerButton.setEnabled(false);
            panel.add(rejouerButton);

            Random random = new Random();
            String[] choix = {"Pierre", "Papier", "Ciseaux"};

            ActionListener playListener = e -> {
                int choixPlayer = 0;
                if (e.getSource() == pierreButton) choixPlayer = 0;
                if (e.getSource() == papierButton) choixPlayer = 1;
                if (e.getSource() == ciseauxButton) choixPlayer = 2;

                int choixOrdi = random.nextInt(3);

                String resultat = "Vous: " + choix[choixPlayer] + " | Ordinateur: " + choix[choixOrdi] + " -> ";

                if (choixPlayer == choixOrdi) {
                    resultat += "Égalité !";
                } else if ((choixPlayer == 0 && choixOrdi == 2) ||
                        (choixPlayer == 1 && choixOrdi == 0) ||
                        (choixPlayer == 2 && choixOrdi == 1)) {
                    resultat += "Vous avez gagné !";
                } else {
                    resultat += "L'ordinateur a gagné !";
                }

                resultLabel.setText(resultat);

                // Désactiver les boutons de choix et activer le bouton Rejouer
                pierreButton.setEnabled(false);
                papierButton.setEnabled(false);
                ciseauxButton.setEnabled(false);
                rejouerButton.setEnabled(true);
            };

            pierreButton.addActionListener(playListener);
            papierButton.addActionListener(playListener);
            ciseauxButton.addActionListener(playListener);

            rejouerButton.addActionListener(e -> {
                resultLabel.setText("Choisissez Pierre, Papier ou Ciseaux");
                pierreButton.setEnabled(true);
                papierButton.setEnabled(true);
                ciseauxButton.setEnabled(true);
                rejouerButton.setEnabled(false);
            });

            frame.add(panel);
            frame.setVisible(true);
        }
    }


