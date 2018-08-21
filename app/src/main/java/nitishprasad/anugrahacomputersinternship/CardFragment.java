package nitishprasad.anugrahacomputersinternship;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class CardFragment extends Fragment {


    PagerModel pagerModel;
    View view;
    TextView title,name,description,viewCount,commentCount,likesCount;
    ImageView profileImage,image;

    public  interface CardClick{

        void onCardClick(PagerModel pagerModel);
    }

    CardClick  cardClick;

    public CardFragment() {
        // Required empty public constructor
    }

    public void bindClickListener(CardClick cardClick){

        this.cardClick = cardClick;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_card, container, false);


        pagerModel = (PagerModel) getArguments().getSerializable("pagermodel");


        init();

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(cardClick!=null){
                    cardClick.onCardClick(pagerModel);
                }
            }
        });

        return view;
    }

    private void init() {

        title = view.findViewById(R.id.title);
        name = view.findViewById(R.id.name);
        description = view.findViewById(R.id.description);
        viewCount = view.findViewById(R.id.views);
        commentCount = view.findViewById(R.id.comment);
        likesCount  = view.findViewById(R.id.likes);
        profileImage = view.findViewById(R.id.profile_image);
        image = view.findViewById(R.id.image);

        title.setText(pagerModel.getTitle());
        name.setText(pagerModel.getProfileModel().getUserName());
        description.setText(pagerModel.getProfileModel().getDescription());
        viewCount.setText(""+pagerModel.getView());
        commentCount.setText(""+pagerModel.getComment());
        likesCount.setText(""+pagerModel.getLikes());

        Picasso.get()
                .load(pagerModel.getImageResource())
                .into(image);

        Picasso.get()
                .load(pagerModel.getProfileModel().getUserImage())
                .into(profileImage);
    }



}
