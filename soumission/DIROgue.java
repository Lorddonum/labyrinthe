package soumission;

import code_squelette.*;
import rencontre.*;
import java.util.Random;

public class DIROgue {
     
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MonAventure aventure = new MonAventure();
        MonLabyrinthe labyrinthe = new MonLabyrinthe();

        while (true) {
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");

            if (tokens[0].equalsIgnoreCase("piece")) {
                int id = Integer.parseInt(tokens[1]);
                String rencontre = tokens[2];
                aventure.ajouterPiece(new Piece(id, RencontreType.valueOf(rencontre.toUpperCase())));
            } else if (tokens[0].equalsIgnoreCase("corridor")) {
                int id1 = Integer.parseInt(tokens[1]);
                int id2 = Integer.parseInt(tokens[2]);
                aventure.ajouterCorridor(id1, id2);
            } else if (tokens[0].equalsIgnoreCase("CORRIDORS")) {
                break;
            } else if (tokens[0].equalsIgnoreCase("FIN")) {
                break;
            }
        }

        String rapport = genererRapport(aventure);
        String scenario = genererScenario(aventure);

        System.out.println("Rapport:");
        System.out.println(rapport);

        System.out.println("Scenario:");
        System.out.println(scenario);
    }

    public static String genererRapport(Aventure a) {
        StringBuilder rapport = new StringBuilder();

        rapport.append("Donjon avec ").append(a.getNombrePieces()).append(" pieces :\n");

        for (Piece piece : a.getPieces()) {
            rapport.append(piece).append(" : ").append(piece.getVoisins()).append("\n");
        }

        rapport.append(a.estPacifique() ? "Pacifique.\n" : "Non pacifique.\n");
        rapport.append(a.contientBoss() ? "Contient un boss.\n" : "Ne contient pas de boss.\n");
        rapport.append("Contient ").append(a.getTresorTotal()).append(" tresor(s).\n");

        rapport.append("Chemin jusqu'au boss :\n");
        List<Piece> chemin = a.cheminJusquAuBoss();
        for (Piece piece : chemin) {
            rapport.append(piece).append("\n");
        }

        return rapport.toString();
    }

	public static String genererScenario(Aventure a) {
        StringBuilder scenario = new StringBuilder();

        for (Piece piece : a.cheminJusquAuBoss()) {
            RencontreType rencontreType = piece.getRencontreType();
            Rencontre rencontre = null;

            if (rencontreType == RencontreType.MONSTRE) {
                rencontre = genererMonstre();
            } else if (rencontreType == RencontreType.TRESOR) {
                rencontre = genererTresor();
            }

            if (rencontre != null) {
                scenario.append(rencontre.rencontrer()).append("\n");
            }
        }

        return scenario.toString();
    }

    private Rencontre genererMonstre() {
        Random random = new Random();
        int randomNumber = random.nextInt(3);

        switch (randomNumber) {
            case 0:
                return new Gobelin();
            case 1:
                return new Orque();
            case 2:
                return new Gargouille();
            default:
                return null;
        }
    }

    private Rencontre genererTresor() {
        Random random = new Random();
        int randomNumber = random.nextInt(3);

        switch (randomNumber) {
            case 0:
                return new SacDeButin();
            case 1:
                return new Potion();
            case 2:
                return new ArtefactMagique();
            default:
                return null;
        }
    }

}

