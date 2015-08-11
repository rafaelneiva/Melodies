package br.com.newagemobile.controller.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.newagemobile.R;

/**
 * Created by rafaelneiva on 22/01/15.
 */
public class SampleFragment extends Fragment {

    public static SampleFragment newInstance() {
        SampleFragment f = new SampleFragment();
        Bundle b = new Bundle();
        f.setArguments(b);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sample, container, false);

        if (1 == 1) {

        }

        return rootView;
    }
}
