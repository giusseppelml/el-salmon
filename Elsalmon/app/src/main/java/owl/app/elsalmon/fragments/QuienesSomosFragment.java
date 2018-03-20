package owl.app.elsalmon.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import jp.wasabeef.blurry.Blurry;
import owl.app.elsalmon.R;

public class QuienesSomosFragment extends Fragment {


    public QuienesSomosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quienes_somos, container, false);

        view.post(new Runnable() {
            @Override
            public void run() {
                long startMs = System.currentTimeMillis();
                Blurry.with(getContext())
                        .radius(25)
                        .sampling(2)
                        .async()
                        .animate(500)
                        .capture(getView().findViewById(R.id.imageQuienes))
                        .into((ImageView)getView().findViewById(R.id.imageQuienes));
            }
        });

        return view;
    }

}
