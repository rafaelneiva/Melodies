package br.com.newagemobile.controller.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

import br.com.newagemobile.R;
import br.com.newagemobile.controller.adapters.ViewPagerAdapter;

/**
 * Created by rafaelneiva on 23/01/15.
 */
public class ViewPagerFragment extends Fragment {

    ViewPager mPager;
    private String tabtitles[] = new String[]{"Sample Tab 1", "Sample Tab 2", "Sample Tab 3"};
    Drawable mDrawable[];

    public PagerSlidingTabStrip mPagerTab;

    public static ViewPagerFragment newInstance() {
        ViewPagerFragment f = new ViewPagerFragment();
        Bundle args = new Bundle();
        f.setArguments(args);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_viewpager, container, false);

        mDrawable = new Drawable[]{
                getActivity().getResources().getDrawable(R.drawable.tab1),
                getActivity().getResources().getDrawable(R.drawable.tab2),
                getActivity().getResources().getDrawable(R.drawable.tab3)
        };

        mPager = (ViewPager) v.findViewById(R.id.viewpager);
        mPagerTab = (PagerSlidingTabStrip) v.findViewById(R.id.sliding_tabs);
        mPager.setAdapter(new ViewPagerAdapter(getActivity().getSupportFragmentManager(), tabtitles, mDrawable));

        mPagerTab.setViewPager(mPager);

        return v;
    }
}
