package rencontre;

public abstract class Rencontre {
    public abstract String rencontrer();
}

public class Monstre extends Rencontre {
    private String type;

    public Monstre(String type) {
        this.type = type;
    }

    @Override
    public String rencontrer() {
        return "Un " + type + " affreux!";
    }
}

public class Gobelin extends Monstre {
    public Gobelin() {
        super("Gobelin");
    }
}

public class Orque extends Monstre {
    public Orque() {
        super("Orque");
    }
}

public class Gargouille extends Monstre {
    public Gargouille() {
        super("Gargouille");
    }
}

public class Boss extends Gargouille {
    @Override
    public String rencontrer() {
        return "La bataille finale!";
    }
}

public class Tresor extends Rencontre {
    private String type;

    public Tresor(String type) {
        this.type = type;
    }

    @Override
    public String rencontrer() {
        return type + "! Quelle chance!";
    }
}

public class SacDeButin extends Tresor {
    public SacDeButin() {
        super("Sac de butin");
    }
}

public class Potion extends Tresor {
    public Potion() {
        super("Potion");
    }
}

public class ArtefactMagique extends Tresor {
    public ArtefactMagique() {
        super("Artefact magique");
    }
}

public class Rien extends Rencontre {
    @Override
    public String rencontrer() {
        return "Un moment pacifique.";
    }
}

