package nitishprasad.anugrahacomputersinternship;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.flaviofaria.kenburnsview.KenBurnsView;

public class MainActivity extends AppCompatActivity {

    KenBurnsView images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        images = findViewById(R.id.image);

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                images.setImageResource(R.drawable.splash_background_2);
            }
        },1500);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(MainActivity.this,HomeScreen.class);
                startActivity(intent);
            }
        },3000);
    }
}
