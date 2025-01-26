package entity;

import java.time.LocalDate;

public abstract class Identifiable {

    private long id;

    private LocalDate recordDate;

    public Identifiable(long id) {
        this.id = id;
        this.recordDate = LocalDate.now();
    }

    public long getId() {
        return id;
    }

    public LocalDate getRecordDate() {
        return recordDate;
    }


}
