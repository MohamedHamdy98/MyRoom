package Pojo;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DaoInterface {
    @Insert
    public void insert(Model model);

    @Delete
    public void delete(Model model);

    @Update
    public void update(Model model);

    @Query("Select * From table_database")
    public LiveData<List<Model>> getAllUsers();
}
