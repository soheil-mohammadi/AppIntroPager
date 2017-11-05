package Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import Fragments.AppIntroFragment;

/**
 * Created by soheilmohammadi on 10/10/17.
 */

public class ViewPagerAppIntroAdpater extends FragmentPagerAdapter {


    private ArrayList<Integer> reslayout_list ;

    public ViewPagerAppIntroAdpater(FragmentManager fm , ArrayList<Integer> reslayout_list) {
        super(fm);
        this.reslayout_list = reslayout_list ;
    }



    @Override
    public Fragment getItem(int position) {
        return AppIntroFragment.newInstance( position + 1  , reslayout_list);
    }


    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE ;
    }

    @Override
    public int getCount() {
        return reslayout_list.size() ;
    }
}
