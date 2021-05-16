package hu.kormany.milan.nameapplication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private MutableLiveData<String> name;

    public MutableLiveData<String> getName() {

        if(name == null){
            name = new MutableLiveData<>();
        }

        return name;
    }
}
