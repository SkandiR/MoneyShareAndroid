package com.example.moneyshare.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moneyshare.AddMoneyActivity;
import com.example.moneyshare.BorrowRequestInputActivity;
import com.example.moneyshare.LendRequestActivity;
import com.example.moneyshare.LentActivity;
import com.example.moneyshare.R;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;


public class HomeFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    View mHomeFragmentView=null;

    private OnFragmentInteractionListener mListener;

    // lent and borrow buttons
    CardView lent_btn;
    CardView add_money;

    AppCompatButton lend_request;
    AppCompatButton borrow_request;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Home : ","onCreate");
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d("OnCreateView","Called");
        if(mHomeFragmentView==null)
            mHomeFragmentView = inflater.inflate(R.layout.fragment_home, container, false);
        // Inflate the layout for this fragment

        lent_btn = mHomeFragmentView.findViewById(R.id.lent_clickable);
        lent_btn.setOnClickListener((View.OnClickListener) this);

        add_money = mHomeFragmentView.findViewById(R.id.add_money);
        add_money.setOnClickListener((View.OnClickListener) this);

        lend_request = mHomeFragmentView.findViewById(R.id.lend_request_button);
        lend_request.setOnClickListener((View.OnClickListener) this);

        borrow_request = mHomeFragmentView.findViewById(R.id.borrow_request_button);
        borrow_request.setOnClickListener((View.OnClickListener) this);

        return mHomeFragmentView;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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
            mListener.onFragmentInteraction("Home");
        }

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String st);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lent_clickable:
                Intent lentIntent = new Intent(view.getContext(), LentActivity.class);
                startActivity(lentIntent);
                break;
            case R.id.borrowed_clickable:

                break;
            case R.id.lend_request_button:
                Intent lendRequestIntent = new Intent(view.getContext(), LendRequestActivity.class);
                startActivity(lendRequestIntent);
                break;
            case R.id.borrow_request_button:
                Intent borrowRequestIntent = new Intent(view.getContext(), BorrowRequestInputActivity.class);
                startActivity(borrowRequestIntent);
                break;
            case R.id.add_money:
                //show_add_money_popup();
                Intent addMoneyIntent = new Intent(view.getContext(), AddMoneyActivity.class);
                startActivity(addMoneyIntent);
                break;
        }
    }
}