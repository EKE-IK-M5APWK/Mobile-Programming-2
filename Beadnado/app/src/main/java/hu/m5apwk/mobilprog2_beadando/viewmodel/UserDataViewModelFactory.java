package hu.m5apwk.mobilprog2_beadando.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import org.jetbrains.annotations.NotNull;

public class UserDataViewModelFactory implements ViewModelProvider.Factory {

    private String data;

    public UserDataViewModelFactory(String s) {
        this.data = s;
    }
    @NonNull
    @NotNull
    @Override
    public <T extends ViewModel> T create(@NonNull @NotNull Class<T> modelClass) {
        return (T) new UserDataViewModel();
    }
}
