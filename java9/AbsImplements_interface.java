package java9;

interface Animalia {
    public void organismList();
}

abstract class AnimalKingdom implements Animalia {
    public void organismList() {
        System.out.println("\nChrodate\tEchinodermata\tArthropoda\tAnnelida\tetc.");
    }

    abstract void examples();
}

class Displayanimals extends AnimalKingdom {

    @Override
    void examples() {
        System.out.println("\nWhales (Mammals),Balangonosus " +
                "(Multicelluler Echnodermata),Sparrow (Aves) etc.");

    }

    public static void main(String[] args) {
        Displayanimals D = new Displayanimals();
        System.out.printf("\nOrganismList ");
        D.organismList();
        System.out.printf("\nSome Examples");
        D.examples();

    }

}