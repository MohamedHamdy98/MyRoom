package Ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import Pojo.Model;
import Pojo.Repository;

public class RoomViewModel extends AndroidViewModel {

    Repository repository;
    LiveData<List<Model>> modelList;

    public RoomViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        modelList = repository.getAllUsers();
    }

    public LiveData<List<Model>> getAllUsers(){
        return repository.getAllUsers();
    }

    public void insert(Model model){
        repository.insert(model);
    }
    public void delete(Model model){
        repository.delete(model);
    }

}
