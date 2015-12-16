package com.diplom.project.atmsickleave;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;


public class ATMSickLeaveActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	String[] colors = { "Красный", "Оранжевый", "Желтый", "Зелёный", "Голубой", "Синий", "Фиолетовый",
    			"Красны", "Оранжевый", "Желтый", "Зелёный", "Голубой", "Синий", "Фиолетовый"};
    	
    	ArrayList<Task> tasks = new ArrayList<Task>();

    	for (int i = 0; i < 20; i++)
    	{
    		Task task = new Task();
    		task.status = i % 3;
    		tasks.add(task);
    	}
    	
    	super.onCreate(savedInstanceState);
    	
    	LinearLayout layout = new LinearLayout(getApplicationContext());
   
    	layout.setOrientation(LinearLayout.VERTICAL);
    	
        setContentView(layout);
        
        new HeaderListView(this, layout);
        new FilterView(this, layout);
       
 
        // Связываемся с ListView
        ListView list = new ListView(getApplicationContext());
  
        // устанавливаем адаптер списку
        list.setAdapter(new TaskListAdapter(getApplicationContext(), tasks));
        
        layout.addView(list);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.atmsick_leave, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
