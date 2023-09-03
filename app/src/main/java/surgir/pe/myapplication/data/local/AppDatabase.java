package surgir.pe.myapplication.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import surgir.pe.myapplication.data.local.dao.CharacterDao;
import surgir.pe.myapplication.data.local.entity.CharacterEntity;

@Database(entities = {CharacterEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CharacterDao characterDao();
}

