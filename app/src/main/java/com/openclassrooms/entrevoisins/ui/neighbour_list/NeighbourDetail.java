package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.openclassrooms.entrevoisins.ui.neighbour_list.MyNeighbourRecyclerViewAdapter.CLICKED_NEIGHBOUR;

public class NeighbourDetail extends AppCompatActivity {

    @BindView(R.id.nPicture)
    ImageView nPicture;
    @BindView(R.id.nName)
    TextView nName;
    @BindView(R.id.nName2)
    TextView nName2;
    @BindView(R.id.nAdress)
    TextView nAdress;
    @BindView(R.id.nPhoneNumber)
    TextView nPhoneNumber;
    @BindView(R.id.nSocialNetworks)
    TextView nSocialNetworks;
    @BindView(R.id.activity_favorite_greeting1_txt)
    TextView activity_favorite_greeting1_txt;
    @BindView(R.id.activity_favorite_greeting2_txt)
    TextView activity_favorite_greeting2_txt;
    @BindView(R.id.fav_btn)
    FloatingActionButton fav_btn;

    private NeighbourApiService mApiService;
    private Neighbour cloneNeighbour;
    private boolean favorite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbour_detail);
        ButterKnife.bind(this);


        mApiService = DI.getNeighbourApiService();

        cloneNeighbour = (Neighbour) getIntent().getSerializableExtra(CLICKED_NEIGHBOUR);
        favorite = cloneNeighbour.isFavorite();


        if (favorite) {
            fav_btn.setImageResource(R.drawable.ic_star_white_24dp);
        }
        else {
            fav_btn.setImageResource(R.drawable.ic_star_border_white_24dp);
        }

        nName.setText(cloneNeighbour.getName());
        nName2.setText(cloneNeighbour.getName());
        nAdress.setText(cloneNeighbour.getAddress());
        nPhoneNumber.setText(cloneNeighbour.getPhoneNumber());
        nSocialNetworks.setText("www.facebook.fr /" + cloneNeighbour.getName().toLowerCase());
        activity_favorite_greeting2_txt.setText(cloneNeighbour.getAboutMe());
        Glide.with(this).load(cloneNeighbour.getAvatarUrl()).into(nPicture);



        fav_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (favorite) {
                    favorite = false;
                    fav_btn.setImageResource(R.drawable.ic_star_border_white_24dp);
                    mApiService.deleteNeighbour(cloneNeighbour);
                } else {
                    favorite = true;
                    fav_btn.setImageResource(R.drawable.ic_star_white_24dp);
                    mApiService.addFavorite(cloneNeighbour);
                }
            }
        });



    }


}
