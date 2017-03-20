package com.statkeeperapp.stattracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.teams_array, android.R.layout.simple_spinner_item);

        Spinner spinner = (Spinner) findViewById(R.id.team1_spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Spinner spinner2 = (Spinner) findViewById(R.id.team2_spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);

        TextView start = (TextView) findViewById(R.id.start_button);
        start.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        TextView new_team = (TextView) findViewById(R.id.new_team);
        new_team.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), CreateTeamActivity.class);
                startActivity(intent);
            }
        });
    }
}
