package in.co.praveendeshmane.blog.viewmodelexample;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final  MyViewModel model = ViewModelProviders.of(this).get(MyViewModel.class);
        model.getTasks().observe(MainActivity.this, new Observer<List<Task>>() {
            @Override
            public void onChanged(@Nullable List<Task> users) {
                // update UI
                TextView textView = findViewById(R.id.result);
                textView.setText(model.getTasks().getValue().get(0).toString());
            }
        });
    }
}