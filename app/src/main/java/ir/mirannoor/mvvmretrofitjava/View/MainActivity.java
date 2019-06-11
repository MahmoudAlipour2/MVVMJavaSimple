package ir.mirannoor.mvvmretrofitjava.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Observable;

import ir.mirannoor.mvvmretrofitjava.R;
import ir.mirannoor.mvvmretrofitjava.ViewModel.ViewModel;

public class MainActivity extends AppCompatActivity {

    ViewModel viewModel;
    TextView txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Instance of ViewModel
        viewModel = ViewModelProviders.of(this).get(ViewModel.class);

        //Send request from "View to ViewModel" by Instance.
        viewModel.setUser();


        //Get data from ViewModel
        viewModel.observable.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
              txt=findViewById(R.id.txt);
              txt.setText(s);
            }
        });


    }
}
