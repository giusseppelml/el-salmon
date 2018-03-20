package owl.app.elsalmon.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import owl.app.elsalmon.fragments.MisionVisionFragment;
import owl.app.elsalmon.fragments.ProductosFragment;
import owl.app.elsalmon.fragments.QuienesSomosFragment;

/**
 * Created by giusseppe on 18/01/2018.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    private int numberOfTabs;

    public PagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                return new QuienesSomosFragment();
            case 1:
                return new MisionVisionFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }

}