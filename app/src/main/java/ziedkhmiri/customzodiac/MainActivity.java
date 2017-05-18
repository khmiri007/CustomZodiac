package ziedkhmiri.customzodiac;


import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements Adapter.OnClickListener{
    private RecyclerView recyclerView;
    private int viewPosition ;
    ImageView imageView;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        imageView = (ImageView)findViewById(R.id.imageView);
        title = (TextView)findViewById(R.id.title);
       setupAdapter();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position", viewPosition);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onItemClick(View sharedView, String transitionName, int position) {
        viewPosition = position;
        Intent intent = new Intent(this, TransitionActivity.class);
        intent.putExtra("transition",transitionName);
        intent.putExtra("position",viewPosition);
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, sharedView, transitionName);
        ActivityCompat.startActivity(this, intent, options.toBundle());
    }
    private void setupAdapter(){
     Adapter snapAdapter = new Adapter(this);
        snapAdapter.addImage(new img("Leo", R.drawable.leo, "July 23 - August 22"));
        snapAdapter.addImage(new img("Aquarius", R.drawable.aquarius, "January 20 - February 18"));
       snapAdapter.addImage(new img("Cancer", R.drawable.cancer, "June 21 - July 22"));
        snapAdapter.addImage(new img("Capricorn", R.drawable.capricorn, "December 22 - January 19"));
        snapAdapter.addImage(new img("Gemini", R.drawable.gemini, "May 21 - June 20"));
        snapAdapter.addImage(new img("Libra", R.drawable.libra, "September 23 - October 22"));
        snapAdapter.addImage(new img("Pisces", R.drawable.pisces, "February 19 - March 20"));
       snapAdapter.addImage(new img("Aries", R.drawable.aries, "March 21 - April 19"));
        snapAdapter.addImage(new img("Sagittarius", R.drawable.sagittarius, "November 22 - December 21"));
        snapAdapter.addImage(new img("Taurus", R.drawable.taurus, "April 20 - May 20"));
        snapAdapter.addImage(new img("Virgo", R.drawable.virgo, "August 23 - September 22"));
       snapAdapter.addImage(new img("Scorpio", R.drawable.scorpio, "October 23 - November 21"));
        recyclerView.setAdapter(snapAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }



}
