package com.example.meating.ui.about;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AboutViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AboutViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Group 5 meating app\nC110134148 梁詩敏\nC110118260 李俊賢\nB111118301 司徒嘉略");
    }

    public LiveData<String> getText() {
        return mText;
    }
}