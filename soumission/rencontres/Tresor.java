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