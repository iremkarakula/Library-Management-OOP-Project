package entity;

import java.time.LocalDateTime;

public enum BookStatus {

    AVAILABLE("Mevcut"),
    CHECKED_OUT("Ödünç Alındı"),
    RESERVED("Rezerve Edildi"),
    LOST("Kayıp"),
    DAMAGED("Hasar Görmüş");

    private final String description;
    private LocalDateTime localDateTime;

    BookStatus(String description) {
        this.description = description;
        this.localDateTime = LocalDateTime.now();
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

}
