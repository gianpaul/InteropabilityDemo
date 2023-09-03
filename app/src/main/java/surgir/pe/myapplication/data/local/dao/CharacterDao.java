package surgir.pe.myapplication.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import surgir.pe.myapplication.data.local.entity.CharacterEntity;

@Dao
public interface CharacterDao {
    @Query("SELECT * FROM character")
    List<CharacterEntity> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<CharacterEntity> users);

    @Query("DELETE FROM character")
    void deleteAll();
}
