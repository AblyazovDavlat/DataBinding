package com.example.dablyazov.binding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.dablyazov.binding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private FinalTime _Time = new FinalTime();

    private View.OnFocusChangeListener listener = new View.OnFocusChangeListener() {

        @Override

        public void onFocusChange(View v, boolean hasFocus) {

            int sh = Integer.parseInt(((EditText) findViewById(R.id.editTextStartHour)).getText().toString());
            int sm = Integer.parseInt(((EditText) findViewById(R.id.editTextStartMin)).getText().toString());
            int eh = Integer.parseInt(((EditText) findViewById(R.id.editTextEndHour)).getText().toString());
            int em = Integer.parseInt(((EditText) findViewById(R.id.editTextEndMin)).getText().toString());

            _Time.SetHours(sh,eh);
            _Time.SetMins(sm,em);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setTime(_Time);

        findViewById(R.id.editTextStartHour).setOnFocusChangeListener(listener);
        findViewById(R.id.editTextEndHour).setOnFocusChangeListener(listener);
        findViewById(R.id.editTextStartMin).setOnFocusChangeListener(listener);
        findViewById(R.id.editTextEndMin).setOnFocusChangeListener(listener);

    }

}
