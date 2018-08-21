package nitishprasad.anugrahacomputersinternship;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity implements CardFragment.CardClick{

    CardFragment fragment1,fragment2,fragment3,fragment4,fragment5;
    CardFragment prFragemnt1,prFragment2;
    TextView pos;

    ImageView imageView;
    ProfileModel profileModel1,profileModel2;
    PagerModel pagerModel1,pagerModel2,pagerModel3,pagerModel4,pagerModel5;
    Bundle b1,b2,b3,b4,b5;

    ViewPager pager;
    PagerAdapter adapter;
    DepthTransformation depthTransformation;

    ArrayList<CardFragment> allFragment = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        imageView = findViewById(R.id.image);
        pos  =findViewById(R.id.position);

        profileModel1 = new ProfileModel();
        profileModel1.setUserName("Nitish Prasad");
        profileModel1.setDescription("Description of Nitish Prasad");
        profileModel1.setUserImage(R.drawable.nitish);


        profileModel2 = new ProfileModel();
        profileModel2.setUserName("Rahul Kumar");
        profileModel2.setDescription("Description of Rahul Kumar");
        profileModel2.setUserImage(R.drawable.nitish);

        pagerModel1 = new PagerModel();
        pagerModel1.setComment(10);
        pagerModel1.setLikes(100);
        pagerModel1.setTitle("Artistic");
        pagerModel1.setView(5000);
        pagerModel1.setProfileModel(profileModel1);
        pagerModel1.setImageResource(R.drawable.img_1);
        pagerModel1.setRating(1);


        pagerModel2 = new PagerModel();
        pagerModel2.setComment(50);
        pagerModel2.setLikes(130);
        pagerModel2.setTitle("Race Sport");
        pagerModel2.setView(50);
        pagerModel2.setProfileModel(profileModel2);
        pagerModel2.setImageResource(R.drawable.img_2);
        pagerModel2.setRating(2);


        pagerModel3 = new PagerModel();
        pagerModel3.setComment(510);
        pagerModel3.setLikes(104);
        pagerModel3.setTitle("Football");
        pagerModel3.setView(508);
        pagerModel3.setProfileModel(profileModel1);
        pagerModel3.setImageResource(R.drawable.img_3);
        pagerModel3.setRating(3);

        pagerModel4 = new PagerModel();
        pagerModel4.setComment(10);
        pagerModel4.setLikes(120);
        pagerModel4.setTitle("Nature");
        pagerModel4.setView(5050);
        pagerModel4.setProfileModel(profileModel2);
        pagerModel4.setImageResource(R.drawable.img_4);
        pagerModel4.setRating(4);

        pagerModel5 = new PagerModel();
        pagerModel5.setComment(10);
        pagerModel5.setLikes(100);
        pagerModel5.setTitle("Nature");
        pagerModel5.setView(5000);
        pagerModel5.setProfileModel(profileModel1);
        pagerModel5.setImageResource(R.drawable.img_5);
        pagerModel5.setRating(5);

        pager = findViewById(R.id.pager);
        depthTransformation = new DepthTransformation();

        fragment1 = new CardFragment();
        fragment2 = new CardFragment();
        fragment3 = new CardFragment();
        fragment4 = new CardFragment();
        fragment5 = new CardFragment();
        prFragemnt1 = new CardFragment();
        prFragment2 = new CardFragment();


        fragment1.bindClickListener(this);
        fragment2.bindClickListener(this);
        fragment3.bindClickListener(this);
        fragment4.bindClickListener(this);
        fragment5.bindClickListener(this);

        allFragment.add(prFragemnt1);
        allFragment.add(fragment1);
        allFragment.add(fragment2);
        allFragment.add(fragment3);
        allFragment.add(fragment4);
        allFragment.add(fragment5);
        allFragment.add(prFragment2);

        b1 = new Bundle();
        b2 = new Bundle();
        b3 = new Bundle();
        b4 = new Bundle();
        b5  = new Bundle();

        b1.putSerializable("pagermodel",pagerModel1);
        b2.putSerializable("pagermodel",pagerModel2);
        b3.putSerializable("pagermodel",pagerModel3);
        b4.putSerializable("pagermodel",pagerModel4);
        b5.putSerializable("pagermodel",pagerModel5);


        prFragemnt1.setArguments(b5);
        fragment1.setArguments(b1);
        fragment2.setArguments(b2);
        fragment3.setArguments(b3);
        fragment4.setArguments(b4);
        fragment5.setArguments(b5);
        prFragment2.setArguments(b1);

        adapter = new PagerAdapter(getSupportFragmentManager(),allFragment);

        pager.setAdapter(adapter);
//        pager.setPageTransformer(true,depthTransformation);
        pager.setPadding(80,0,80,0);
        pager.setPageMargin(40);
        pager.setClipToPadding(false);

        setUpPageListener();
        pager.setCurrentItem(1);
    }

    private void setUpPageListener(){

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(final int position) {

                CardFragment fragment = allFragment.get(position);

                imageView.setImageResource((
                        (PagerModel) fragment.getArguments().get("pagermodel"))
                .getImageResource());

                pos.setText(""+position);

                if(position == 0){

                    pos.setText("5");

                    Handler h = new Handler();
                    h.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            pager.setCurrentItem(5,false);
                        }
                    },200);
                }

                else if(position == 6){

                    pos.setText("1");
                    Handler h = new Handler();
                    h.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            pager.setCurrentItem(1,false);
                        }
                    },200);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onCardClick(PagerModel pagerModel) {

        Log.e("fragement data",pagerModel.getTitle()+"  "+pagerModel.getRating());

        Intent intent = new Intent(this,Detail.class);
        intent.putExtra("data",pagerModel);
        startActivity(intent);

    }
}
