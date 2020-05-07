package Pojo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Repository {
    private Database database;
    private DaoInterface daoInterface;
    private LiveData<List<Model>> modelList;

    public Repository(Application application) {
        database = Database.getDatabase(application);
        daoInterface = database.daoInterface();
        modelList = daoInterface.getAllUsers();
    }
    public LiveData<List<Model>> getAllUsers(){
        return daoInterface.getAllUsers();
    }
    public void insert(final Model model){
        new AsyncTask <Void,Void,Void> (){
            @Override
            protected Void doInBackground(Void... voids) {
                database.daoInterface().insert(model);
                return null;
            }
        }.execute();
    }
    public void delete(final Model model){
       new AsyncTask<Void,Void,Void>(){

           @Override
           protected Void doInBackground(Void... voids) {
               database.daoInterface().delete(model);
               return null;
           }
       }.execute();
    }
}
