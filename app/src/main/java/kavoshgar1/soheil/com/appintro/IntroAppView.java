package kavoshgar1.soheil.com.appintro;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import Adapters.ViewPagerAppIntroAdpater;

/**
 * Created by soheilmohammadi on 10/10/17.
 */

public class IntroAppView extends LinearLayout {


    private static final String TAG = "IntroAppView";

    private ViewPagerAppIntroAdpater viewPagerAppIntroAdpater ;


    private  ArrayList<Circle> circles = new ArrayList<>();

    private FragmentManager fragmentManager ;
    private ArrayList<Integer> res_data ;

    private LinearLayout container_circles_app_intro ;
    private ViewPager viewPager ;

    private  float radiusCircle;
    private  int colorCircle;

    public IntroAppView(Context context) {
        super(context);
        init(context);
    }

    public IntroAppView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public IntroAppView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public IntroAppView setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager ;
        return this ;
    }
    public IntroAppView setResLayouts(ArrayList<Integer> res_data) {
        this.res_data = res_data ;
        return this ;
    }

    public void build(float radiusCircle , int colorCircle) {
        this.radiusCircle = radiusCircle ;
        this.colorCircle = colorCircle ;

        viewPagerAppIntroAdpater = new ViewPagerAppIntroAdpater(fragmentManager  , res_data);
        viewPager.setAdapter(viewPagerAppIntroAdpater);
        for (int i = 0; i <this.res_data.size() ; i++) {
            Circle circle =  new Circle(getContext());
            LayoutParams params = new LayoutParams(20 , ViewGroup.LayoutParams.MATCH_PARENT  );
            params.setMargins(5 , 5 , 5 , 5);
            circle.setLayoutParams(params);
            circle.build(this.radiusCircle , !Boolean.parseBoolean(String.valueOf(i)) , this.colorCircle);
            circles.add(circle);
            this.container_circles_app_intro.addView(circle);
        }
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                handleCircles(position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    private void init(Context context) {
        View view = inflate(context , R.layout.app_intro_module , this);
        this.viewPager = view.findViewById(R.id.view_pager_app_intro_module);
        this.container_circles_app_intro = view.findViewById(R.id.container_circles_app_intro);

    }

    public void notify_data() {
        viewPagerAppIntroAdpater.notifyDataSetChanged();
    }


    private  void handleCircles(int position){
        for (int i = 0; i <circles.size() ; i++) {
            if(i == position) {
                circles.get(i).build(this.radiusCircle ,  true, this.colorCircle);
            }else  {
                circles.get(i).build(this.radiusCircle ,  false , this.colorCircle);

            }
        }
    }
}
