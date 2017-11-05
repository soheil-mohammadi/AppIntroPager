package Fragments;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;

import Listeners.onInflateViewAppIntro;
import kavoshgar1.soheil.com.appintro.R;

/**
 * Created by soheilmohammadi on 10/10/17.
 */

public class AppIntroFragment extends Fragment {

    private static final String TAG = "AppIntroFragment";

    
    private static final String KEY_RES = "ARG_RES";
    private static final String KEY_PAGE = "ARG_PAGE";

    private  onInflateViewAppIntro listener ;
    private   ArrayList<Integer> res_layout ;
    private  int page ;

    public static AppIntroFragment newInstance(int position , ArrayList<Integer> res_layout ) {
        AppIntroFragment fragment = new AppIntroFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_PAGE ,  position);
        args.putIntegerArrayList(KEY_RES , res_layout);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.page = getArguments().getInt(KEY_PAGE);
        this.res_layout = getArguments().getIntegerArrayList(KEY_RES);
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (onInflateViewAppIntro) context ;
        }catch (ClassCastException e){
            Log.e(TAG, "onAttach: ERROR!!!");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = null;
        for (int i = 0; i < res_layout.size() ; i++) {
            if(page == i + 1){
                view = inflater.inflate(res_layout.get(i) , container , false);
                break;

            }
        }
        listener.do_someThings((ViewPager) getActivity().findViewById(R.id.view_pager_app_intro_module), view , page);
        return  view ;
    }
}
