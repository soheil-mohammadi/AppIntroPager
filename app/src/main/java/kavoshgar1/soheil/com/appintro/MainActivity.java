package kavoshgar1.soheil.com.appintro;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

import Listeners.onInflateViewAppIntro;

public class MainActivity extends AppCompatActivity implements onInflateViewAppIntro {


    private  IntroAppView  intro_app_view ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intro_app_view = (IntroAppView) findViewById(R.id.intro_app_view);
        init_intro_appView();
    }


    private void init_intro_appView() {
        ArrayList<Integer> res_layouts = new ArrayList<>() ;
        res_layouts.add(R.layout.intro_app_view_one);
        res_layouts.add(R.layout.intro_app_view_two);
        intro_app_view.setFragmentManager(getSupportFragmentManager()).setResLayouts(res_layouts).build(8 , Color.GREEN);
    }





    @Override
    public void do_someThings(final ViewPager viewPager, View view, int current_page) {

        switch (current_page) {
            case  1 :
                Button btn_app_intro_one = view.findViewById(R.id.btn_app_intro_one);

                btn_app_intro_one.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        viewPager.setCurrentItem(1);
                    }
                });
                break;

            case 2 :

                Button btn_app_intro_end = view.findViewById(R.id.btn_app_intro_end);
                btn_app_intro_end.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this , SecondActivity.class));
                        finish();
                    }
                });

                break;
        }

    }


}
