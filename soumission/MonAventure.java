package soumission;

import code_squelette.*;

public class MonAventure extends Aventure {

    public MonAventure(Labyrinthe carte) {
        super(carte);
    }

    @Override
    public boolean estPacifique() {
        for (Piece piece : carte.getPieces()) {
            if (piece.getRencontreType() == RencontreType.MONSTRE || piece.getRencontreType() == RencontreType.BOSS) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean contientDuTresor() {
        for (Piece piece : carte.getPieces()) {
            if (piece.getRencontreType() == RencontreType.TRESOR) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getTresorTotal() {
        int total = 0;
        for (Piece piece : carte.getPieces()) {
            if (piece.getRencontreType() == RencontreType.TRESOR) {
                total++;
            }
        }
        return total;
    }

    @Override
    public boolean contientBoss() {
        for (Piece piece : carte.getPieces()) {
            if (piece.getRencontreType() == RencontreType.BOSS) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Piece[] cheminJusquAuBoss() {
        List<Piece> chemin = new ArrayList<>();
        Piece[] pieces = carte.getPieces();
        Arrays.sort(pieces, Comparator.comparingInt(Piece::getID));

        for (Piece piece : pieces) {
            if (piece.getRencontreType() == RencontreType.BOSS) {
                chemin.add(piece);
                return chemin.toArray(new Piece[0]);
            } else if (piece.getID() == chemin.size()) {
                chemin.add(piece);
            } else {
                return new Piece[0];
            }
        }

        return new Piece[0];
    }
}
