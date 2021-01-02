package com.example.calculatorapplication;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface Historydao {


    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(History history);

    @Query("DELETE FROM History_Table")
    void deleteAll();

    @Query("SELECT * FROM History_Table ORDER BY history ASC")
    LiveData<List<History>> getAlphabetizedWords();
}

