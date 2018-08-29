package com.example.sujith.interrupt.Menu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.example.sujith.interrupt.R;
import com.goka.blurredgridmenu.BlurringView;
import com.goka.blurredgridmenu.GridMenu;
import com.goka.blurredgridmenu.GridMenuAdapter;

import java.util.ArrayList;
import java.util.List;

public class GridMenuFragment1 extends Fragment implements AdapterView.OnItemClickListener {

    private static final String KEY_BG_RESOURCE_ID = "key_bg_resource_id";

    public static GridMenuFragment1 newInstance(int backgroundResourceID) {
        GridMenuFragment1 gridMenuFragment1 = new GridMenuFragment1();
        Bundle args = new Bundle();
        args.putInt(KEY_BG_RESOURCE_ID, backgroundResourceID);
        gridMenuFragment1.setArguments(args);
        return gridMenuFragment1;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGridMenuAdapter = new GridMenuAdapter(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_grid_menu1, null);
        View backgroundView = view.findViewById(R.id.blurred_view1);

        int backgroundResourceID = getArguments().getInt(KEY_BG_RESOURCE_ID, 0);
        backgroundView.setBackgroundResource(backgroundResourceID);

        BlurringView blurringView = (BlurringView) view.findViewById(R.id.blurring_view1);
        blurringView.setBlurredView(backgroundView);

        GridView gridView = (GridView) view.findViewById(R.id.menu_grid_view1);
        mGridMenuAdapter.addAll(this.mMenus);
        gridView.setAdapter(mGridMenuAdapter);
        gridView.setOnItemClickListener(this);

        ImageButton close = view.findViewById(R.id.close);
        final RelativeLayout relativeLayout = view.findViewById(R.id.BlurRel);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setVisibility(View.GONE);
            }
        });
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (mOnClickMenuListener == null) {
            throw new IllegalArgumentException("Must implement setOnClickMenuListener");
        } else {
            mOnClickMenuListener.onClickMenu(mMenus.get(i), i);
        }
    }

    public void setupMenu(List<GridMenu> menus) {
        this.mMenus = menus;
    }

    private GridMenuAdapter mGridMenuAdapter;

    private List<GridMenu> mMenus = new ArrayList<>();

    private com.goka.blurredgridmenu.GridMenuFragment.OnClickMenuListener mOnClickMenuListener;

    public void setOnClickMenuListener(com.goka.blurredgridmenu.GridMenuFragment.OnClickMenuListener listener) {
        mOnClickMenuListener = listener;
    }

    public interface OnClickMenuListener {

        void onClickMenu(GridMenu gridMenu, int position);
    }

}
