package com.example.smartfarmer20;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

class SectionPgerAdapter extends FragmentPagerAdapter {
    public SectionPgerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                SeedsFragment seedsFragment=new SeedsFragment();
                return seedsFragment;
            case 1:
                PlantsFragment plantsFragment=new PlantsFragment();
                return plantsFragment;
            case 2:
                ToolsFragment toolsFragment=new ToolsFragment();
                return toolsFragment;

            case 3:
                InsectisidesFragment insectisidesFragment=new InsectisidesFragment();
                return insectisidesFragment;
            case 4:
                FertilizerFragment fertilizerFragment=new FertilizerFragment();
               return fertilizerFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "SEEDS";
            case 1:
                return "PLANTS";
            case 2:
                return "Tools";
            case 3:
                return "INSECTICIDES";
         case 4:
                return "Fertilizer";
            default:
                return null;
        }
    }
}
