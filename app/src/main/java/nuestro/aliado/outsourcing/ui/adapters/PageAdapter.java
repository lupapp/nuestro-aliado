package nuestro.aliado.outsourcing.ui.adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;

import java.util.List;

public class PageAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> list;

    private FragmentManager mFragmentManager;

    public PageAdapter(FragmentManager fm) {
        super(fm);
        this.mFragmentManager = fm;
    }

    public void setList(List<Fragment> list) {
        this.list = list;
    }

    public void clear() {

        if (this.list != null) {

            FragmentTransaction ft = mFragmentManager.beginTransaction();
            for (Fragment f : list) {
                //You can perform additional check to remove some (not all) fragments:
                ft.remove(f);
            }
            ft.commitAllowingStateLoss();

            this.list.clear();
            this.notifyDataSetChanged();
        }
    }

    public void removePage(int page){
        list.remove(page);
    }
    public void addNewPage(Fragment fr, int pos){
        list.add(pos,fr);
    }


    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {

        if (this.list != null) {
            return this.list.size();
        }
        return 0;
    }

    @Override
    public int getItemPosition(Object object) {
        return PageAdapter.POSITION_NONE;
    }
}
