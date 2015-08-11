package br.com.newagemobile.controller.activities;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import br.com.newagemobile.R;
import br.com.newagemobile.controller.fragments.ViewPagerFragment;

public class MainActivity extends ActionBarActivity {

    private Toolbar mToolbar;
    private ViewPagerFragment viewPagerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPagerFragment = ViewPagerFragment.newInstance();

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content, new SplashsFragment())
                    .commit();


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .setCustomAnimations(R.anim.slide_fade_from_bottom, R.anim.slide_fade_to_bottom)
                            .replace(R.id.content, viewPagerFragment)
                            .commit();
                }
            }, 1500);

        }

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            mToolbar.setNavigationIcon(R.drawable.ic_ab_drawer);
            getSupportActionBar().hide();
        }

        tintNotificationBar(R.color.color_primary_dark);
        tintTaskDescription(R.color.color_primary);

    }

    private void tintNotificationBar(int colorId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(colorId));
        }
    }

    private void tintTaskDescription(int colorId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityManager.TaskDescription tDesc =
                    new ActivityManager.TaskDescription(getResources().getString(R.string.app_name), null, getResources().getColor(colorId));
            this.setTaskDescription(tDesc);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return item.getItemId() == R.id.action_settings || super.onOptionsItemSelected(item);

    }

    /**
     * Splash Screen
     */
    public static class SplashsFragment extends Fragment {

        public SplashsFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_main, container, false);
        }
    }
}
