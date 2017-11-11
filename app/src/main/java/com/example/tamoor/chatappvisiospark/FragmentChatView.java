package com.example.tamoor.chatappvisiospark;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FragmentChatView extends Fragment {

    public static RecyclerView chatFeedRecycler;
    public static SwipeRefreshLayout refreshLayout;
//    public static BadgesFeedAdapter badapter;
//    public static RVPostAdapter adapter;
    public static TextView msgTextview;
    public static LinearLayout ct_avi;
    public static Context context;
    public static TextView tv;

//    public static List<Posts> list = new ArrayList<Posts>();
//    public static ArrayList<BadgeModel> badgeslist;
//    public static String json;

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_chat_view, container, false);

        context = getContext();

        initViews();

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

//                GetFeed();
            }
        });

        return view;
    }

    public void initViews(){
        refreshLayout = view.findViewById(R.id.swipe_refresh);
        chatFeedRecycler = view.findViewById(R.id.recycler_view);
    }
}
