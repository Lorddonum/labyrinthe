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