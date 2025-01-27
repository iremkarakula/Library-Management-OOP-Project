package entity;

public enum LoanStatus {
    ON_LOAN("Ödünç alınmış"),
    RETURNED("İade edilmiş"),
    LOST("Kayıp");

    private String description;

    LoanStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
