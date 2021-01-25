package com.example.calculatorapplication;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "History_Table")
public class History {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "History")
    public String histories;

    public History() {

    }

    public History(@NonNull String history) {
        this.histories = history;
    }

    public String getHistores() {
        return this.histories;
    }
}
