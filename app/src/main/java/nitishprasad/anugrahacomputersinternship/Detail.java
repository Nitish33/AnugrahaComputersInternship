package nitishprasad.anugrahacomputersinternship;

import android.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class Detail extends AppCompatActivity {

    FrameLayout frameLayout;
    android.support.v4.app.FragmentManager manager;
    FragmentTransaction transaction;

    CardFragment fragment;

    PagerModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        model = (PagerModel) getIntent().getSerializableExtra("data");


        init();
    }

    private void init() {

        frameLayout = findViewById(R.id.container);
        fragment = new CardFragment();
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

        Bundle bundle = new Bundle();
        bundle.putSerializable("pagermodel",model);
        fragment.setArguments(bundle);

        transaction.replace(R.id.container,fragment);
        transaction.commit();

    }

}
