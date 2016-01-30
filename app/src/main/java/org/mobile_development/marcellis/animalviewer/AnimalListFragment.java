package org.mobile_development.marcellis.animalviewer;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnimalListFragment extends Fragment {

    private static final String IMAGES = "images";
    private static final String NAMES = "names";

    private int[] imageIds;
    private String[] animalNames;

    private ArrayAdapter adapter;
    private ListView listView;


    public AnimalListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        List<ListModel> listModels = new ArrayList<>() ;

        for (int i = 0; i < imageIds.length; i++) {
            listModels.add(new ListModel(imageIds[i], animalNames[i]));
        }


        View view= inflater.inflate(R.layout.fragment_animal_list, container, false);
        listView = (ListView) view.findViewById(R.id.listview);
        adapter = new ListAdapter(getActivity(), R.layout.animal_list_item, listModels);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View listItem, int position, long id) {
                ((FragmentActivity) getActivity()).showDetail(position);
            }
        });


        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            imageIds = getArguments().getIntArray(IMAGES);
            animalNames = getArguments().getStringArray(NAMES);
        }
    }

    public static AnimalListFragment newInstance(int[] imageIds, String[] nameStrings) {
        Bundle args = new Bundle();
        args.putIntArray(IMAGES, imageIds);
        args.putStringArray(NAMES, nameStrings);
        AnimalListFragment fragment = new AnimalListFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
