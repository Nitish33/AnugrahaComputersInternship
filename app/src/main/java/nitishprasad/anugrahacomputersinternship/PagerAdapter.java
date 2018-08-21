package nitishprasad.anugrahacomputersinternship;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class PagerAdapter extends FragmentPagerAdapter {

    ArrayList<CardFragment> fragmentsList;

    public PagerAdapter(FragmentManager fm,ArrayList<CardFragment> allFragment) {
        super(fm);

        this.fragmentsList = allFragment;
    }


    @Override
    public Fragment getItem(int position) {
        return fragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsList.size();
    }



}