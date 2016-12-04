package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.hxzy.login.R;

/**
 * Created by Administrator on 2016/9/21.
 */
public class WonderFragment extends Fragment{
    private View layoutView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layoutView =  inflater.inflate(R.layout.fragment_wonder,null);
        return layoutView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showFragment(new WonderMomentFragment());
        RadioGroup wonderHeaderNav  = (RadioGroup) layoutView.findViewById(R.id.wonder_header_nav);
        wonderHeaderNav.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.wonder_monent){
                    showFragment(new WonderMomentFragment());
                }else if (checkedId == R.id.my_friends){
                    showFragment(new MyFriendsFragment());
                }
            }
        });
    }
    public void showFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.sub_content,fragment);
        fragmentTransaction.commit();
    }
}
