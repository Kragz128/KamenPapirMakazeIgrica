package igrica;

import java.util.Random;
import java.util.Scanner;

public class Rengar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        String[] opcije = { "kamen", "papir", "makaze" };

        int playerHp = 100;
        int enemyHp = 100;

        while (playerHp > 0 && enemyHp > 0) {

            String playerRps = "";
            String enemyRps = "";

            while (true) {
                System.out.print("Unesi kamen/papir/makaze: ");
                playerRps = sc.nextLine().trim().toLowerCase();

                if (playerRps.equals("kamen") || playerRps.equals("papir") || playerRps.equals("makaze")) {
                    break;
                }

                System.out.println("Nevažeći unos. Probaj ponovo.");
            }

            enemyRps = opcije[rand.nextInt(opcije.length)];
            System.out.println("Protivnik je izabrao: " + enemyRps);

            boolean playerStarts = false;

            if (playerRps.equals(enemyRps)) {
                System.out.println("Nerešeno, ponovi RPS.");
                continue;
            } else if ((playerRps.equals("kamen") && enemyRps.equals("makaze")) ||
                       (playerRps.equals("papir") && enemyRps.equals("kamen")) ||
                       (playerRps.equals("makaze") && enemyRps.equals("papir"))) {
                playerStarts = true;
                System.out.println("Pobedio si RPS i biraš prvi potez.");
            } else {
                playerStarts = false;
                System.out.println("Protivnik je pobedio RPS i ide prvi.");
            }
            
            String playerAction = "";
            String enemyAction = "";

            if (playerStarts) {
                while (true) {
                    System.out.print("Izaberi napad ili odbrana: ");
                    playerAction = sc.nextLine().trim().toLowerCase();

                    if (playerAction.equals("napad") || playerAction.equals("odbrana")) {
                        break;
                    }

                    System.out.println("Nevažeći unos. Unesi napad ili odbrana.");
                }

                if (rand.nextBoolean()) {
                    enemyAction = "napad";
                } else {
                    enemyAction = "odbrana";
                }
                System.out.println("Protivnik bira: " + enemyAction);
            } else {
                if (rand.nextBoolean()) {
                    enemyAction = "napad";
                } else {
                    enemyAction = "odbrana";
                }
                System.out.println("Protivnik bira: " + enemyAction);

                while (true) {
                    System.out.print("Izaberi napad ili odbrana: ");
                    playerAction = sc.nextLine().trim().toLowerCase();

                    if (playerAction.equals("napad") || playerAction.equals("odbrana")) {
                        break;
                    }

                    System.out.println("Nevažeći unos. Unesi napad ili odbrana.");
                }
            }
            int playerDamage = 0;
            int enemyDamage = 0;

            if (playerAction.equals("napad") && enemyAction.equals("napad")) {
                playerDamage = 20;
                enemyDamage = 20;
            } else if (playerAction.equals("napad") && enemyAction.equals("odbrana")) {
                enemyDamage = 10;
            } else if (playerAction.equals("odbrana") && enemyAction.equals("napad")) {
                playerDamage = 10;
            }

            playerHp -= playerDamage;
            enemyHp -= enemyDamage;

            System.out.println("Igrač je primio " + playerDamage + " štete.");
            System.out.println("Protivnik je primio " + enemyDamage + " štete.");
            System.out.println("Igrač HP: " + Math.max(playerHp, 0) + " | Protivnik HP: " + Math.max(enemyHp, 0));

            if (playerHp <= 0 || enemyHp <= 0) {
                break;
            }
        }

        if (playerHp <= 0 && enemyHp <= 0) {
            System.out.println("Oba su izgubila!");
        } else if (playerHp <= 0) {
            System.out.println("Protivnik je pobedio!");
        } else {
            System.out.println("Pobedio si!");
        }

        sc.close();
    }
}