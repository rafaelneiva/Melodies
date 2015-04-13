package br.com.newagemobile.controller.adapters;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;

import br.com.newagemobile.controller.fragments.SampleFragment;

/**
 * Created by rafaelneiva on 22/01/15.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 3;
    private String titles[];
    private Drawable myDrawables[];

    public ViewPagerAdapter(FragmentManager fm, String[] titles2, Drawable drawable[]) {
        super(fm);
        titles = titles2;
        myDrawables = drawable;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return SampleFragment.newInstance();
            case 1:
                return SampleFragment.newInstance();
            case 2:
                return SampleFragment.newInstance();

        }
        return null;
    }

    public CharSequence getPageTitle(int position) {
//        return titles[position];

        SpannableStringBuilder sb = new SpannableStringBuilder(" "); // space added before text for convenience

        myDrawables[position].setBounds(10, 10, myDrawables[position].getIntrinsicWidth(), myDrawables[position].getIntrinsicHeight());
        ImageSpan span = new ImageSpan(myDrawables[position], ImageSpan.ALIGN_BASELINE);
        sb.setSpan(span, 0, 1, Spanned.SPAN_PRIORITY);

        return sb;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

}
