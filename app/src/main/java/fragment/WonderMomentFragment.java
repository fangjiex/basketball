package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.hxzy.login.R;
import com.hxzy.login.WonderAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/22.
 */
public class WonderMomentFragment extends Fragment{

    private View layoutView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layoutView = inflater.inflate(R.layout.fragment_wonder_monent,null);

        return layoutView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (layoutView == null) return;
        ListView lv = (ListView) layoutView.findViewById(R.id.lv);
        lv.setAdapter(new WonderAdapter());


    }
}
