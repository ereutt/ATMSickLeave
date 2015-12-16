package com.diplom.project.atmsickleave;

import java.util.ArrayList;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class TaskListAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<Task> tasks;
	
	public TaskListAdapter(Context context, ArrayList<Task> tasks)
	{
		this.context = context;
		this.tasks = tasks;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return tasks.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return tasks.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = (View) inflater.inflate(
                    R.layout.task_layout, null);
        }

        TextView id = (TextView)convertView.findViewById(R.id.task_id);
        id.setTextColor(0xFF000000);
        id.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, 25, (float) 0.8));
        id.setGravity(Gravity.START);
        id.setText(tasks.get(position).id);
        
        ImageView status=(ImageView)convertView.findViewById(R.id.task_status);
        status.setLayoutParams(new LinearLayout.LayoutParams(25, 25, (float) 0.2));
         
        switch (tasks.get(position).status)
        {
        case 0:
        	status.setImageResource(R.drawable.waiting);
        	break;
        case 1:
        	status.setImageResource(R.drawable.in_progress);
        	break;
        	
    	default:
    		status.setImageResource(R.drawable.done);
        }

        return convertView;
	}

}
