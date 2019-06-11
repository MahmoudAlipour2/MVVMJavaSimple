package ir.mirannoor.mvvmretrofitjava.ViewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import ir.mirannoor.mvvmretrofitjava.Model.Model;

//Extend View model from ViewModel
public class ViewModel extends androidx.lifecycle.ViewModel {


    //Define LiveData in ViewModel
    public MutableLiveData<String> observable = new MutableLiveData<>();


    //Model Instance in ViewModel
    Model repository = new Model();


    public void setUser() {

        //get data from model by RXJava
        repository.getData().subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d("onSubscribe","Subscribe is started!");
            }

            @Override
            public void onNext(String s) {
                observable.setValue(s);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("onError",e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d("onComplete","Process Completed");
            }
        });

        //Send data to View by LiveData
        //  observable.setValue("Mahmoud");

    }


}
