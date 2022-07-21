package com.example.moneyshare.ui.gallery;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;

import com.example.moneyshare.BorrowOrderExecutedModel;
import com.example.moneyshare.BorrowOrderPlacedAdapter;
import com.example.moneyshare.BorrowOrderPlacedModel;
import com.example.moneyshare.JsonData;
import com.example.moneyshare.LendCompletedAdapter;
import com.example.moneyshare.LendCompletedModel;
import com.example.moneyshare.R;
import com.example.moneyshare.databinding.FragmentGalleryBinding;
import com.example.moneyshare.ui.home.HomeFragment;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Call<JsonData.lentDetailsList> call;
    String user_id;

    private FirebaseAuth mAuth;

    private List<LendCompletedModel> lendCompletedModelList = new ArrayList<>();
    private LendCompletedAdapter mLendCompletedAdapter;


    View mGalleryFragmentView=null;
    private GalleryFragment.OnFragmentInteractionListener mListener;

    public GalleryFragment() {
        // Required empty public constructor
    }

    public static GalleryFragment newInstance(String param1, String param2) {
        GalleryFragment fragment = new GalleryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Gallery : ","onCreate");
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerLendOrderCompleted);
        mLendCompletedAdapter = new LendCompletedAdapter(lendCompletedModelList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mLendCompletedAdapter);

        prepareBorrowOrderPlacedData();

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof GalleryFragment.OnFragmentInteractionListener) {
            mListener = (GalleryFragment.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("OnViewCreated","Called");

        if(mListener!=null){
            mListener.onFragmentInteraction("Gallery");
        }

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String st);
    }

    private void prepareBorrowOrderPlacedData() {
        lendCompletedModelList.add(new LendCompletedModel(2L,3.0, "xyz"));
        mLendCompletedAdapter.notifyDataSetChanged();
    }


}