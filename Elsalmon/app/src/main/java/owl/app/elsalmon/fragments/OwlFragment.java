package owl.app.elsalmon.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import owl.app.elsalmon.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OwlFragment extends Fragment {


    public OwlFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_owl, container, false);
    }

}
