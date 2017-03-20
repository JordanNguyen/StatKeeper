package com.statkeeperapp.stattracker;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class CreateTeamActivity  extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_team_activity);





        final ArrayList<String> players = new ArrayList<String>();

        final TextView roster = (TextView) findViewById(R.id.roster);
        final EditText player = (EditText) findViewById(R.id.player_name);
        final Button addPlayer = (Button) findViewById(R.id.add_button);
        final Button undo = (Button) findViewById(R.id.undo_button);
        final Button save = (Button) findViewById(R.id.save_button);


        player.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND) {

                    if (player.getText().toString().equals("")) {

                    }

                    else if (players.size() < 15) {
                        String names = "";
                        players.add(player.getText().toString());

                        for (int i = 0; i < players.size(); i++) {
                            names = names + (i + 1) + ". " + players.get(i) + "\n";
                        }

                        roster.setText(names);
                        player.setText("");
                        handled = true;
                    }

                    else {
                        Toast text = Toast.makeText(getApplicationContext(), "Your team is full!", Toast.LENGTH_LONG);
                        text.show();
                    }
                }
                return handled;
            }
        });


        addPlayer.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v)
            {
                if (player.getText().toString().equals("")) {

                }

                else if (players.size() < 15) {
                    String names = "";
                    players.add(player.getText().toString());

                    for (int i = 0; i < players.size(); i++) {
                        names = names + (i + 1) + ". " + players.get(i) + "\n";
                    }

                    roster.setText(names);
                    player.setText("");
                }
                else {
                    Toast text = Toast.makeText(getApplicationContext(), "Your team is full!", Toast.LENGTH_LONG);
                    text.show();
                }
            }
        });

        undo.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v)
            {
                if (players.size() != 0) {
                    String names = "";
                    players.remove(players.size() - 1);

                    for (int i = 0; i < players.size(); i++) {
                        names = names + (i+1) + ". " + players.get(i) + "\n";
                    }

                    roster.setText(names);
                    player.setText("");
                }
            }
        });

        save.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                startActivity(intent);
            }
        });

    }

}
