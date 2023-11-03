package soumission;

import code_squelette.*;

import java.util.*;

public class MonLabyrinthe implements Labyrinthe {
    private Piece[] pieces;
    private int pieceCount;
    private Map<Piece, List<Piece>> adjacencyList;

    public MonLabyrinthe() {
        this.pieces = new Piece[50];
        this.pieceCount = 0;
        this.adjacencyList = new HashMap<>();
    }

    @Override
    public Piece[] getPieces() {
        return Arrays.copyOfRange(pieces, 0, pieceCount);
    }

    @Override
    public int nombreDePieces() {
        return pieceCount;
    }

    @Override
    public void ajouteEntree(Exterieur out, Piece e) {
        if (!adjacencyList.containsKey(out)) {
            adjacencyList.put(out, new ArrayList<>());
        }
        adjacencyList.get(out).add(e);
        ajoutePiece(e);
    }

    @Override
    public void ajouteCorridor(Piece e1, Piece e2) {
        if (!adjacencyList.containsKey(e1)) {
            adjacencyList.put(e1, new ArrayList<>());
        }
        adjacencyList.get(e1).add(e2);
        ajoutePiece(e1);
        ajoutePiece(e2);
    }

    @Override
    public boolean existeCorridorEntre(Piece e1, Piece e2) {
        return adjacencyList.containsKey(e1) && adjacencyList.get(e1).contains(e2);
    }

    @Override
    public Piece[] getPiecesConnectees(Piece e) {
        if (!adjacencyList.containsKey(e)) {
            return null;
        }
        List<Piece> connectedPieces = adjacencyList.get(e);
        return connectedPieces.toArray(new Piece[0]);
    }

    private void ajoutePiece(Piece e) {
        if (!Arrays.asList(pieces).contains(e)) {
            pieces[pieceCount] = e;
            pieceCount++;
        }
    }
}

