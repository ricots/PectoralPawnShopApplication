package com.vadym.pectoralepawnshop.fragments;


import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vadym.pectoralepawnshop.utils.CaptionedImagesAdapter;
import com.vadym.pectoralepawnshop.activities.DetailTopicsActivity;
import com.vadym.pectoralepawnshop.R;

public class ForClientFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView forClientsRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_recyclerview, container, false);
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter("FOR_CLIENTS", forClientsRecycler.getContext());
        forClientsRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        forClientsRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            public void onClick(int idTopic) {
                Intent intent = new Intent(getActivity(), DetailTopicsActivity.class);
                intent.putExtra(DetailTopicsActivity.ID_TOPIC, idTopic);
                getActivity().startActivity(intent);
            }
        });

        return forClientsRecycler;
    }

}
