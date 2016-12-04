package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.hxzy.login.FreiendsAdapter;
import com.hxzy.login.R;

/**
 * Created by Administrator on 2016/9/22.
 */
public class MyFriendsFragment extends Fragment{
    private View layoutView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layoutView =  inflater.inflate(R.layout.fragment_my_friends,null);

        return layoutView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (layoutView == null) return;
        ListView lv = (ListView) layoutView.findViewById(R.id.lv);
        lv.setAdapter(new FreiendsAdapter());
    }
}
