package fr.wcs.activityresult;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = new Intent(this, TabActivity.class);
        Button button = findViewById(R.id.pushMe);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(intent, 1);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK){
                String result = data.getStringExtra("result");
                TextView resultView = findViewById(R.id.result);
                resultView.setText(result);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
