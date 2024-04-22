package pl.javastart.zadanie21;

public enum Category {

    ART_SPOZYWCZE("Art.spożywcze"),
    ART_GOSP_DOMOWEGO("Art.gosp.domowego"),
    INNE("Inne");

    private String polishTranslation;

    Category(String polishTranslation) {
        this.polishTranslation = polishTranslation;
    }

    public String getPolishTranslation() {
        return polishTranslation;
    }
}
