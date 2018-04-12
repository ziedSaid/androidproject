package learnmore.projet.learnmore;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khalil on 27/03/2018.
 */

public class CourseViewPagerAdapter extends FragmentPagerAdapter {

    private  final List<Fragment> fragmentsList =new ArrayList<>();
    private final List<String> fragmentsListTitle = new ArrayList<>();

    public CourseViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsListTitle.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentsListTitle.get(position);
    }

    public void addFragment(Fragment fragment, String title){
        fragmentsListTitle.add(title);
        fragmentsList.add(fragment);
    }
}
