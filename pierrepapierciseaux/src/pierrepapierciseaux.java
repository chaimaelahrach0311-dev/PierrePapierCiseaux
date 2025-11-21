import java.util.Random;
import java.util.Scanner;

public class pierrepapierciseaux {

    public static void main (String[] args ){
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String[] choix = {"Pierre", "Papier", "Ciseaux"};
        boolean rejouer= true;
        while (rejouer){
            System.out.println("entrer votre choix : (pierre = 0)/(papier = 1)/(ciseaux = 2)");
            int choixplayer =sc.nextInt();
            if (choixplayer<0 || choixplayer > 2) {
                System.out.println("Choix invalide, réessayez !");
                continue;
            }
            int choixordi = random.nextInt(3);

            System.out.println("Tu as choisi : " + choix[choixplayer]);
            System.out.println("L'ordinateur a choisi : " + choix[choixordi]);


            if(choixordi == choixplayer ){
                System.out.println("Égalité !");
            }
            else if((choixplayer==0 && choixordi==2 )||
                    (choixplayer==1 && choixordi==0 )||
                    (choixplayer==2 && choixordi==1 )){
                System.out.println("tu as gagné !");
            }
            else{
                System.out.println("l'ordinateur gagné !");
            }

            System.out.println("voulez vous rejouer ? (oui = 1) /(non = 0)");

            int rep = sc.nextInt();
            if (rep == 0){
                rejouer = false ;
                System.out.println("Fin du jeu ! ");
            }

        }
        sc.close();
    }

}
