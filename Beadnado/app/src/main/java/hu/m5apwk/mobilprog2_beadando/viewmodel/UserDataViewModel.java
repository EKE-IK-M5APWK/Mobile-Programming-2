package hu.m5apwk.mobilprog2_beadando.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.jetbrains.annotations.NotNull;

public class UserDataViewModel extends ViewModel {
    private MutableLiveData<String> name;
    private MutableLiveData<Integer> id;
    public void setName(MutableLiveData<String> name) {
        this.name = name;
    }

    public MutableLiveData<Integer> getId() {
        return id;
    }

    public void setId(MutableLiveData<Integer> id) {
        this.id = id;
    }

    public MutableLiveData<String> getName() {
        if(name == null){
            name = new MutableLiveData<>();
        }
       return name;
    }

    @NotNull
    @Override
    public String toString() {
        return "UserDataViewModel{" +
                "name=" + name +
                ", id=" + id +
                '}';
    }
}
