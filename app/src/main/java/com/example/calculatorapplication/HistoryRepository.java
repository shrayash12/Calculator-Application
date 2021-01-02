package com.example.calculatorapplication;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class HistoryRepository {
    private Historydao historydao;

    HistoryRepository(Application application) {
        HistoryRoomDataBase db = HistoryRoomDataBase.getDatabase(application);
        historydao = db.historiesdao();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<History>> getAllHistories() {
        return historydao.getAlphabetizedWords();
    }

    void insert(History history) {
        HistoryRoomDataBase.databaseWriteExecutor.execute(() -> {
            historydao.insert(history);
        });
    }

    public void delete() {
        HistoryRoomDataBase.databaseWriteExecutor.execute(() -> historydao.deleteAll());
    }
}
