package com.example.moneyshare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.appcompat.widget.AppCompatButton;

public class CustomListViewAdapter extends BaseAdapter {
    List<String> itens;
    private Context mContext;
    private static LayoutInflater inflater = null;

    public CustomListViewAdapter(Context context, List<String> itens){
        this.itens = itens;
        mContext = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return itens.size();
    }

    public String getItem(int position) {
        return itens.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (convertView == null)
            vi = inflater.inflate(R.layout.lend_order_interested_list_view, parent, false);

        String msg = itens.get(position);

        TextView tx1 = vi.findViewById(R.id.lendOrderInterestedUserName);
        TextView tx2 = vi.findViewById(R.id.lendOrderInterestedProposedROI);
        TextView tx3 = vi.findViewById(R.id.lendOrderInterestedUserCreditScore);

        tx1.setText(msg);
        tx2.setText("12 %");
        tx3.setText("3/3");

        AppCompatButton lendOrderInterestedApprove = vi.findViewById(R.id.lendOrderInterestedApprove);
        lendOrderInterestedApprove.setTag(position);
        lendOrderInterestedApprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                int itemPosition = (Integer)view.getTag();
                String msg = itens.get(itemPosition);
                Toast.makeText(view.getContext(), "clicked position " + msg + itemPosition, Toast.LENGTH_LONG ).show();
            }
        });

        return vi;
    }

    public void addItem(String item){
        itens.add(item);
    }

    public void addItens(List<String> itens){
        this.itens.addAll(itens);
    }
}