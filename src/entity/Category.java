package entity;

public enum Category {

    ELECTRONICS("Elektronik"),
    FASHION("Moda"),
    FOOD("Gıda"),
    BOOKS("Kitaplar"),
    HOME_GOODS("Ev Eşyası"),
    SPORTS("Spor"),
    HEALTH("Sağlık"),
    AUTOMOTIVE("Otomotiv"),
    BEAUTY("Güzellik"),
    ENTERTAINMENT("Eğlence");

    private final String description;

    Category(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
