package com.duguletian.uibestpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by duguletian on 2016/9/6.
 */
public class MsgAdapter extends ArrayAdapter<Msg> {
    private int resourceId;
    public MsgAdapter(Context context, int textViewResourceId, List<Msg> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View converyView, ViewGroup parent){
        Msg msg = getItem(position);
        View view;
        ViewHolder viewHolder;

        if(converyView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder = new ViewHolder();
            viewHolder.leftLayout = (LinearLayout)view.findViewById(R.id.left_layout);
            viewHolder.rightLayout = (LinearLayout)view.findViewById(R.id.right_layout);
            viewHolder.leftMsg = (TextView)view.findViewById(R.id.left_msg);
            viewHolder.rightMsg = (TextView)view.findViewById(R.id.right_msg);
            view.setTag(viewHolder);
        }
        else {
            view = converyView;
            viewHolder = (ViewHolder)view.getTag();
        }

        if (msg.getType() == Msg.TYPE_RECIEVED){
            //如果是收到消息，则显示左边的消息布局，将右边的消息布局隐藏
            viewHolder.leftLayout.setVisibility(View.VISIBLE);
            viewHolder.rightLayout.setVisibility(View.GONE);
            viewHolder.leftMsg.setText(msg.getContent());
        }
        else if (msg.getType() == Msg.TYPE_SENT){
            viewHolder.rightLayout.setVisibility(view.VISIBLE);
            viewHolder.leftLayout.setVisibility(view.GONE);
            viewHolder.rightMsg.setText(msg.getContent());
        }
        return view;
    }

    class ViewHolder{
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsg;
        TextView rightMsg;
    }

}
