package entity;

public enum MemberStatus {
    STUDENT("Öğrenci"),
    EMPLOYEE("Çalışan yetişkin"),
    ADULT_NON_WORKING("Çalışmayan yetişkin"),
    SENIOR("Yaşlı");

    private String description;

    MemberStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
