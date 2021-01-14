package com.xianyu.yixian_client.Model.Room.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

public class History {
    int kills = 0;
    boolean result = false;

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public History(int kills, boolean result) {
        this.kills = kills;
        this.result = result;
    }
}
