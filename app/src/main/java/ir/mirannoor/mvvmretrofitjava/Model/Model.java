package ir.mirannoor.mvvmretrofitjava.Model;

import io.reactivex.Observable;

public class Model {


    public Observable<String> getData(){
        return Observable.just("Mahmoud","Alipour");
    }
}
