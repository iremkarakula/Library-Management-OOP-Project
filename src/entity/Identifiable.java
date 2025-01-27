package entity;

import util.IDGenerator;

import java.time.LocalDate;

public abstract class Identifiable {

    private long id;
    private LocalDate recordDate;

    public Identifiable(long id) {
        this.id = IDGenerator.generateId();
        this.recordDate = LocalDate.now();
    }

    public Identifiable() {
    }

    public long getId() {
        return id;
    }


    public LocalDate getRecordDate() {
        return recordDate;
    }



}
