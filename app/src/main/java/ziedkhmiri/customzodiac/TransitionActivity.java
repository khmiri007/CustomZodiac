package ziedkhmiri.customzodiac;

/**
 * Created by zied216 on 18/04/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static ziedkhmiri.customzodiac.Util.getIcon;
import static ziedkhmiri.customzodiac.Util.getdetail;
import static ziedkhmiri.customzodiac.Util.gettitle;


public class TransitionActivity extends AppCompatActivity {
    ImageView circleView;
    TextView title,detail;
    FloatingActionButton fab;
    NestedScrollView nestedScrollView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);
        circleView = (ImageView) findViewById(R.id.imageView);
        title = (TextView)findViewById(R.id.title);
        detail= (TextView)findViewById(R.id.detail);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Intent intent = getIntent();
            int position =  getIntent().getIntExtra("position", 0);
           circleView.setTransitionName(intent.getStringExtra("transition"));
            title.setText(gettitle(position));
            detail.setText(getdetail(position));
            Glide.with(this).load(getIcon(position)).into(circleView);
            getWindow().setSharedElementEnterTransition(TransitionInflater.from(this).inflateTransition(R.transition.curve_transition));
            Transition transition = getWindow().getSharedElementEnterTransition();
            transition.addListener(new Transition.TransitionListener() {
                @Override
                public void onTransitionStart(Transition transition) {
                    fab.setScaleX(0);
                    fab.setScaleY(0);
                    fab.setVisibility(View.INVISIBLE);
                    nestedScrollView.setAlpha(0f);
                }

                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @Override
                public void onTransitionEnd(Transition transition) {
                    fab.show();
                    nestedScrollView.setTranslationY(
                            dpToPixels(TransitionActivity.this, 72));
                    nestedScrollView.animate().alpha(1f).translationY(0)
                            .setInterpolator(new DecelerateInterpolator());
                    transition.removeListener(this);
                }

                @Override
                public void onTransitionCancel(Transition transition) {

                }

                @Override
                public void onTransitionPause(Transition transition) {

                }

                @Override
                public void onTransitionResume(Transition transition) {

                }
            });
        } else {
            if (savedInstanceState == null) {
                fab.setScaleX(0);
                fab.setScaleY(0);
                fab.setVisibility(View.INVISIBLE);
                fab.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fab.show();
                    }
                }, 300);
            }
        }
    }

    @Override
    public void onActivityReenter(int resultCode, Intent data) {
        super.onActivityReenter(resultCode, data);
        supportPostponeEnterTransition();
    }

    @Override
    public void onBackPressed() {
        fab.setVisibility(View.INVISIBLE);
        nestedScrollView.animate().alpha(0)
                .setInterpolator(new AccelerateInterpolator())
                .translationY(dpToPixels(TransitionActivity.this, 72))
                .start();
        supportFinishAfterTransition();
    }
    public static int dpToPixels(Context context, int value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value,
                context.getResources().getDisplayMetrics());
    }

}
