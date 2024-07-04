package kh.edu.rupp.ite.visitme.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.chip.Chip;
import com.google.android.material.navigation.NavigationBarView;

import kh.edu.rupp.ite.visitme.R;
import kh.edu.rupp.ite.visitme.databinding.ActivityLandingBinding;
import kh.edu.rupp.ite.visitme.fragment.HomeFragment;
import kh.edu.rupp.ite.visitme.fragment.PlacesFragment;
import kh.edu.rupp.ite.visitme.fragment.ProfileFragment;

public class LandingActivity extends AppCompatActivity {

   private ActivityLandingBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLandingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Create home fragment
        HomeFragment homeFragment = new HomeFragment();
        showFragment(homeFragment);

        //handle bottom navigation
        binding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return handleOnNavigationItem(item);
            }
        });
    }

    private boolean handleOnNavigationItem(MenuItem item){
        if(item.getItemId() == R.id.menuHome){
            showFragment(new HomeFragment());
        }else if (item.getItemId() == R.id.menuPlaces){
            showFragment(new PlacesFragment());
        }else{
            showFragment(new ProfileFragment());
        }
        return true;
    }

    private void showFragment (Fragment fragment){
        //FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

        //fragment transaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //Replace fragment
        fragmentTransaction.replace(binding.home.getId(), fragment);

        //commit fragment
        fragmentTransaction.commit();
    }
}
