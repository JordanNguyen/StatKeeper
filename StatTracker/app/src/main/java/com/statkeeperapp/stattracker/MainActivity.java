package com.statkeeperapp.stattracker;

import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView player1pts, player1reb, player1ast, player2pts, player2reb, player2ast, player3pts, player3reb, player3ast,
            player4pts, player4reb, player4ast, player5pts, player5reb, player5ast, player6pts, player6reb, player6ast,
    player7pts, player7reb, player7ast, player8pts, player8reb, player8ast, player9pts, player9reb, player9ast, player0pts, player0reb, player0ast;

    TextView score;

    Player home_player1, home_player2, home_player3, home_player4, home_player5, away_player1,  away_player2,  away_player3,  away_player4,  away_player5;

    ArrayList<Player> player_list;

    TextView two_point_make, three_point_make;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);


        // create player objects
        home_player1 = new Player("K. Bryant", "http://forums.nba-live.com/dl_mod/thumbs/7467_4Pacific.png");
        home_player2 = new Player("L. James", "http://forums.nba-live.com/dl_mod/thumbs/3638_MIA_James_LeBron.png");
        home_player3 = new Player("S. Curry", "http://www.spotrac.com/blog/wp-content/uploads/2013/05/gs-curry.png");
        home_player4 = new Player("D. Howard", "http://a3.espncdn.com/combiner/i?img=%2Fi%2Fheadshots%2Fnba%2Fplayers%2Ffull%2F2384.png");
        home_player5 = new Player("Y. Ming", "http://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/1722.png&w=350&h=254");

        away_player1 = new Player("T. Hollerer", "http://www.ieeevr.org/2017/img/tobias-hollerer.jpg");
        away_player2 = new Player("S. Dong", "https://www.cs.ucsb.edu/sites/cs.ucsb.edu/files/styles/portrait-full/public/images/graduate/dong_samuel.jpg?itok=cYWtYbj1&c=ed53ae072f9ae2aa1d80a0c1cab57b49");
        away_player3 = new Player("H. Kung", "https://media.licdn.com/mpr/mpr/shrinknp_400_400/p/5/005/0a5/25f/14fcd8f.jpg");
        away_player4 = new Player("M. Turk", "https://www.cs.ucsb.edu/sites/cs.ucsb.edu/files/styles/portrait-full/public/faculty/images/matthew-turk_0.jpg?itok=Qu98srhX&c=d1bcd0f47e9a68775b3c5d6ad01ffaf8");
        away_player5 = new Player("P. Conrad", "https://pbs.twimg.com/profile_images/73630820/HeadShot.jpg");

        player_list = new ArrayList<>();
        player_list.add(home_player1);
        player_list.add(home_player2);
        player_list.add(home_player3);
        player_list.add(home_player4);
        player_list.add(home_player5);
        player_list.add(away_player1);
        player_list.add(away_player2);
        player_list.add(away_player3);
        player_list.add(away_player4);
        player_list.add(away_player5);


        findViewById(R.id.two_point_make_text).setOnTouchListener(new MyTouchListener(0));
        findViewById(R.id.three_point_make_text).setOnTouchListener(new MyTouchListener(1));
        findViewById(R.id.ft_make_text).setOnTouchListener(new MyTouchListener(2));
        findViewById(R.id.two_point_miss_text).setOnTouchListener(new MyTouchListener(3));
        findViewById(R.id.three_point_miss_text).setOnTouchListener(new MyTouchListener(4));
        findViewById(R.id.ft_miss_text).setOnTouchListener(new MyTouchListener(5));

        findViewById(R.id.rebound_text).setOnTouchListener(new MyTouchListener(6));
        findViewById(R.id.assist_text).setOnTouchListener(new MyTouchListener(7));
        findViewById(R.id.steal_text).setOnTouchListener(new MyTouchListener(8));
        findViewById(R.id.block_text).setOnTouchListener(new MyTouchListener(9));
        findViewById(R.id.foul_text).setOnTouchListener(new MyTouchListener(10));
        findViewById(R.id.turnover_text).setOnTouchListener(new MyTouchListener(11));


        RelativeLayout left_layout1 = (RelativeLayout)findViewById(R.id.left_card_player_top_left_layout);
        left_layout1.setOnDragListener(new MyDragListener(0));
        left_layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(home_player1);
            }
        });

        RelativeLayout left_layout2 = (RelativeLayout)findViewById(R.id.left_card_player_top_center_layout);
        left_layout2.setOnDragListener(new MyDragListener(1));
        RelativeLayout left_layout3 = (RelativeLayout)findViewById(R.id.left_card_player_top_right_layout);
        left_layout3.setOnDragListener(new MyDragListener(2));
        RelativeLayout left_layout4 = (RelativeLayout)findViewById(R.id.left_card_player_bot_left_layout);
        left_layout4.setOnDragListener(new MyDragListener(3));
        RelativeLayout left_layout5 = (RelativeLayout)findViewById(R.id.left_card_player_bot_right_layout);
        left_layout5.setOnDragListener(new MyDragListener(4));

        RelativeLayout right_layout1 = (RelativeLayout)findViewById(R.id.right_card_player_top_left_layout);
        right_layout1.setOnDragListener(new MyDragListener(5));
        RelativeLayout right_layout2 = (RelativeLayout)findViewById(R.id.right_card_player_top_center_layout);
        right_layout2.setOnDragListener(new MyDragListener(6));
        RelativeLayout right_layout3 = (RelativeLayout)findViewById(R.id.right_card_player_top_right_layout);
        right_layout3.setOnDragListener(new MyDragListener(7));
        RelativeLayout right_layout4 = (RelativeLayout)findViewById(R.id.right_card_player_bot_left_layout);
        right_layout4.setOnDragListener(new MyDragListener(8));
        RelativeLayout right_layout5 = (RelativeLayout)findViewById(R.id.right_card_player_bot_right_layout);
        right_layout5.setOnDragListener(new MyDragListener(9));

        player0pts = (TextView)findViewById(R.id.left_player0_pts);
        player0reb = (TextView)findViewById(R.id.left_player0_reb);
        player0ast = (TextView)findViewById(R.id.left_player0_ast);
        player1pts = (TextView)findViewById(R.id.left_player1_pts);
        player1reb = (TextView)findViewById(R.id.left_player1_reb);
        player1ast = (TextView)findViewById(R.id.left_player1_ast);
        player2pts = (TextView)findViewById(R.id.left_player2_pts);
        player2reb = (TextView)findViewById(R.id.left_player2_reb);
        player2ast = (TextView)findViewById(R.id.left_player2_ast);
        player3pts = (TextView)findViewById(R.id.left_player3_pts);
        player3reb = (TextView)findViewById(R.id.left_player3_reb);
        player3ast = (TextView)findViewById(R.id.left_player3_ast);
        player4pts = (TextView)findViewById(R.id.left_player4_pts);
        player4reb = (TextView)findViewById(R.id.left_player4_reb);
        player4ast = (TextView)findViewById(R.id.left_player4_ast);
        player5pts = (TextView)findViewById(R.id.right_player0_pts);
        player5reb = (TextView)findViewById(R.id.right_player0_reb);
        player5ast = (TextView)findViewById(R.id.right_player0_ast);
        player6pts = (TextView)findViewById(R.id.right_player1_pts);
        player6reb = (TextView)findViewById(R.id.right_player1_reb);
        player6ast = (TextView)findViewById(R.id.right_player1_ast);
        player7pts = (TextView)findViewById(R.id.right_player2_pts);
        player7reb = (TextView)findViewById(R.id.right_player2_reb);
        player7ast = (TextView)findViewById(R.id.right_player2_ast);
        player8pts = (TextView)findViewById(R.id.right_player3_pts);
        player8reb = (TextView)findViewById(R.id.right_player3_reb);
        player8ast = (TextView)findViewById(R.id.right_player3_ast);
        player9pts = (TextView)findViewById(R.id.right_player4_pts);
        player9reb = (TextView)findViewById(R.id.right_player4_reb);
        player9ast = (TextView)findViewById(R.id.right_player4_ast);

        score = (TextView)findViewById(R.id.game_score);

        ImageView left_player1 = (ImageView) findViewById(R.id.left_image_player_top_left);
        Picasso.with(getApplicationContext()).load(home_player1.getImage_url()).transform(new CircleTransform()).into(left_player1);
        ImageView left_player2 = (ImageView) findViewById(R.id.left_image_player_top_center);
        Picasso.with(getApplicationContext()).load(home_player2.getImage_url()).transform(new CircleTransform()).into(left_player2);
        ImageView left_player3 = (ImageView) findViewById(R.id.left_image_player_top_right);
        Picasso.with(getApplicationContext()).load(home_player3.getImage_url()).transform(new CircleTransform()).into(left_player3);
        ImageView left_player4 = (ImageView) findViewById(R.id.left_image_player_bot_left);
        Picasso.with(getApplicationContext()).load(home_player4.getImage_url()).transform(new CircleTransform()).into(left_player4);
        ImageView left_player5 = (ImageView) findViewById(R.id.left_image_player_bot_right);
        Picasso.with(getApplicationContext()).load(home_player5.getImage_url()).transform(new CircleTransform()).into(left_player5);

        ImageView right_player1 = (ImageView) findViewById(R.id.right_image_player_top_left);
        Picasso.with(getApplicationContext()).load(away_player1.getImage_url()).transform(new CircleTransform()).into(right_player1);
        ImageView right_player2 = (ImageView) findViewById(R.id.right_image_player_top_center);
        Picasso.with(getApplicationContext()).load(away_player2.getImage_url()).transform(new CircleTransform()).into(right_player2);
        ImageView right_player3 = (ImageView) findViewById(R.id.right_image_player_top_right);
        Picasso.with(getApplicationContext()).load(away_player3.getImage_url()).transform(new CircleTransform()).into(right_player3);
        ImageView right_player4 = (ImageView) findViewById(R.id.right_image_player_bot_left);
        Picasso.with(getApplicationContext()).load(away_player4.getImage_url()).transform(new CircleTransform()).into(right_player4);
        ImageView right_player5 = (ImageView) findViewById(R.id.right_image_player_bot_right);
        Picasso.with(getApplicationContext()).load(away_player5.getImage_url()).transform(new CircleTransform()).into(right_player5);


    }


    private void showDialog(Player p) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        DialogFragment dialogFragment = DetailDialog.newInstance(p);
        dialogFragment.show(ft, "dialog");
    }



    private final class MyTouchListener implements View.OnTouchListener {

        int index;

        MyTouchListener(int i) {
            index = i;
            //stat_index = index;
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("stat", "" + index);
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(data, shadowBuilder, v, 0);
                v.setVisibility(View.VISIBLE);
                Log.d("ON TOUCH", "stat index: " + index);
                return true;
            }
            else {
                return false;
            }

        }
    }

    class MyDragListener implements View.OnDragListener {
        Drawable enterShape = getResources().getDrawable(R.drawable.shape_hover);
        Drawable normalShape = getResources().getDrawable(R.drawable.shape_normal);

        int index;

        MyDragListener(int id) {
            index = id;
        }

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action  = event.getAction();


            switch (event.getAction()) {

                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing
                    Log.d("DRAG", "Drag started! for index");
                    break;

                // called when item is dragged into target layout
                case DragEvent.ACTION_DRAG_ENTERED:
                    v.setBackgroundDrawable(enterShape);
                    Log.d("ENTER", "Entered the player card!");
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                   // v.setBackgroundDrawable(normalShape);
                    Log.d("DRAG", "Drag exited!");
                    v.setBackgroundDrawable(normalShape);
                    break;

                // called when you drop item on target
                case DragEvent.ACTION_DROP:
                    // v.setBackgroundDrawable(enterShape);
                   // View view = (View)event.getLocalState();
                   // ViewGroup owner = (ViewGroup)view.getParent();
                   // view.setVisibility(View.INVISIBLE);
                    ClipData data = event.getClipData();
                    ClipData.Item item = data.getItemAt(0);
                    CharSequence charSequence = item.getText();
                    String s = charSequence.toString();
                    Log.d("ON DRAG", "index: " + s);
                    int stat_index = Integer.parseInt(s);

                    v.setBackgroundDrawable(normalShape);
                    Log.d("DRAG", "Drag dropped! On card " + index + " stat index: " + stat_index);

                    String current_score = score.getText().toString();
                    String [] parts = current_score.split("\\-");
                    int home_score = Integer.parseInt(parts[0].trim());
                    int away_score = Integer.parseInt(parts[1].trim());
                    Log.d("SCORE", "home: " +  home_score + " away: " + away_score);
                    switch (index) {

                        /* home player 1
                        /*
                        */
                        case 0:

                            // update home player 1's fg made and points
                            if (stat_index == 0) {
                                String temp = player0pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 2;
                                player0pts.setText("" + new_pts);
                                home_score += 2;
                               // player_list.get(0).setPoints(new_pts);

                                // update game score
                                score.setText("" + home_score + " - " + away_score);

                                player_list.get(0).setFg_made(player_list.get(0).getFg_made() + 1);
                                player_list.get(0).setPoints(player_list.get(0).getPoints() + 2);
                                Log.d("On DROP", "player 1 points: " + player_list.get(0).getPoints());
                                Log.d("On DROP", "player 1 fg made: " + player_list.get(0).getFg_made());

                            }

                            // update home player 1's three point made and points
                            else if (stat_index == 1) {
                                String temp = player0pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 3;
                                player0pts.setText("" + new_pts);

                                // update game score
                                home_score += 3;
                                score.setText("" + home_score + " - " + away_score);

                                player_list.get(0).setThree_made(player_list.get(0).getThree_made() + 1);
                                player_list.get(0).setPoints(player_list.get(0).getPoints() + 3);
                            }

                            // update home player 1's ft made and points
                            else if (stat_index == 2) {
                                String temp = player0pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 1;
                                player0pts.setText("" + new_pts);

                                // update game score
                                home_score += 1;
                                score.setText("" + home_score + " - " + away_score);

                                player_list.get(0).setFt_made(player_list.get(0).getFt_made() + 1);
                                player_list.get(0).setPoints(player_list.get(0).getPoints() + 1);
                            }

                            // update home player 1's fg misses
                            else if(stat_index == 3) {
                                player_list.get(0).setFg_miss(player_list.get(0).getFg_miss() + 1);
                            }

                            // update home player 1's three point misses
                            else if (stat_index == 4) {
                                player_list.get(0).setThree_miss(player_list.get(0).getThree_miss() + 1);
                            }

                            // update home player 1's missed fts
                            else if (stat_index == 5) {
                                player_list.get(0).setFt_miss(player_list.get(0).getFt_miss() + 1);
                            }

                            // update home player 1's rebounds
                            else if (stat_index == 6) {
                                String temp = player0reb.getText().toString();
                                int reb = Integer.parseInt(temp);
                                int new_reb = reb + 1;
                                player0reb.setText("" + new_reb);

                                player_list.get(0).setRebounds(player_list.get(0).getRebounds() + 1);
                            }

                            // update home player 1's assists
                            else if (stat_index == 7) {
                                String temp = player0ast.getText().toString();
                                int ast = Integer.parseInt(temp);
                                int new_ast = ast + 1;
                                player0ast.setText("" + new_ast);

                                player_list.get(0).setAssists(player_list.get(0).getAssists() + 1);
                            }

                            // update home player 1's steals
                            else if (stat_index == 8) {
                                player_list.get(0).setSteals(player_list.get(0).getSteals() + 1);
                            }

                            // update home player 1's blocks
                            else if (stat_index == 9) {
                                player_list.get(0).setBlocks(player_list.get(0).getBlocks() + 1);
                            }
                            // update home player 1's fouls
                            else if (stat_index == 10) {
                                player_list.get(0).setFouls(player_list.get(0).getFouls() + 1);
                            }

                            // update home player 1's turnovers
                            else if (stat_index == 11) {
                                player_list.get(0).setTurnovers(player_list.get(0).getTurnovers() + 1);
                            }

                            break;

                         /* home player 2
                         /*
                         */
                        case 1:
                            if (stat_index == 0) {
                                String temp = player1pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 2;
                                player1pts.setText("" + new_pts);
                                home_score += 2;
                                score.setText("" + home_score + " - " + away_score);
                            }
                            else if (stat_index == 1) {
                                String temp = player1pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 3;
                                player1pts.setText("" + new_pts);
                                home_score += 3;
                                score.setText("" + home_score + " - " + away_score);
                            }
                            else if (stat_index == 2) {
                                String temp = player1pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 1;
                                player1pts.setText("" + new_pts);
                                home_score += 1;
                                score.setText("" + home_score + " - " + away_score);
                            }
                            else if (stat_index == 6) {
                                String temp = player1reb.getText().toString();
                                int reb = Integer.parseInt(temp);
                                int new_reb = reb + 1;
                                player1reb.setText("" + new_reb);
                            }
                            else if (stat_index == 7) {
                                String temp = player1ast.getText().toString();
                                int ast = Integer.parseInt(temp);
                                int new_ast = ast + 1;
                                player1ast.setText("" + new_ast);
                            }
                            break;
                        // home player 3
                        case 2:
                            if (stat_index == 0) {
                                String temp = player2pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 2;
                                player2pts.setText("" + new_pts);
                                home_score += 2;
                                score.setText("" + home_score + " - " + away_score);
                            }
                            else if (stat_index == 1) {
                                String temp = player2pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 3;
                                player2pts.setText("" + new_pts);
                                home_score += 3;
                                score.setText("" + home_score + " - " + away_score);
                            }
                            else if (stat_index == 2) {
                                String temp = player2pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 1;
                                player2pts.setText("" + new_pts);
                                home_score += 1;
                                score.setText("" + home_score + " - " + away_score);
                            }
                            else if (stat_index == 6) {
                                String temp = player2reb.getText().toString();
                                int reb = Integer.parseInt(temp);
                                int new_reb = reb + 1;
                                player2reb.setText("" + new_reb);
                            }
                            else if (stat_index == 7) {
                                String temp = player2ast.getText().toString();
                                int ast = Integer.parseInt(temp);
                                int new_ast = ast + 1;
                                player2ast.setText("" + new_ast);
                            }
                            break;
                        // home player 4
                        case 3:
                            if (stat_index == 0) {
                                String temp = player3pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 2;
                                player3pts.setText("" + new_pts);
                                home_score += 2;
                                score.setText("" + home_score + " - " + away_score);
                            }
                            else if (stat_index == 1) {
                                String temp = player3pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 3;
                                player3pts.setText("" + new_pts);
                                home_score += 3;
                                score.setText("" + home_score + " - " + away_score);
                            }
                            else if (stat_index == 2) {
                                String temp = player3pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 1;
                                player3pts.setText("" + new_pts);
                                home_score += 1;
                                score.setText("" + home_score + " - " + away_score);
                            }
                            else if (stat_index == 6) {
                                String temp = player3reb.getText().toString();
                                int reb = Integer.parseInt(temp);
                                int new_reb = reb + 1;
                                player3reb.setText("" + new_reb);
                            }
                            else if (stat_index == 7) {
                                String temp = player3ast.getText().toString();
                                int ast = Integer.parseInt(temp);
                                int new_ast = ast + 1;
                                player3ast.setText("" + new_ast);
                            }
                            break;
                        // home player 5
                        case 4:
                            if (stat_index == 0) {
                                String temp = player4pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 2;
                                player4pts.setText("" + new_pts);
                                home_score += 2;
                                score.setText("" + home_score + " - " + away_score);
                            }
                            else if (stat_index == 1) {
                                String temp = player4pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 3;
                                player4pts.setText("" + new_pts);
                                home_score += 3;
                                score.setText("" + home_score + " - " + away_score);
                            }
                            else if (stat_index == 2) {
                                String temp = player4pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 1;
                                player4pts.setText("" + new_pts);
                                home_score += 1;
                                score.setText("" + home_score + " - " + away_score);
                            }
                            else if (stat_index == 6) {
                                String temp = player4reb.getText().toString();
                                int reb = Integer.parseInt(temp);
                                int new_reb = reb + 1;
                                player4reb.setText("" + new_reb);
                            }
                            else if (stat_index == 7) {
                                String temp = player4ast.getText().toString();
                                int ast = Integer.parseInt(temp);
                                int new_ast = ast + 1;
                                player4ast.setText("" + new_ast);
                            }
                            break;

                        case 5:
                            if (stat_index == 0) {
                                String temp = player5pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 2;
                                player5pts.setText("" + new_pts);
                                away_score += 2;
                                score.setText("" + home_score + " - " + away_score);
                            }
                            else if (stat_index == 1) {
                                String temp = player5pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 3;
                                player5pts.setText("" + new_pts);
                                away_score += 3;
                                score.setText("" + home_score + " - " + away_score);
                            }
                            else if (stat_index == 2) {
                                String temp = player5pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 1;
                                player5pts.setText("" + new_pts);
                                away_score += 1;
                                score.setText("" + home_score + " - " + away_score);
                            }
                            else if (stat_index == 6) {
                                String temp = player5reb.getText().toString();
                                int reb = Integer.parseInt(temp);
                                int new_reb = reb + 1;
                                player5reb.setText("" + new_reb);
                            }
                            else if (stat_index == 7) {
                                String temp = player5ast.getText().toString();
                                int ast = Integer.parseInt(temp);
                                int new_ast = ast + 1;
                                player5ast.setText("" + new_ast);
                            }
                            break;

                        case 6:
                            if (stat_index == 0) {
                                String temp = player6pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 2;
                                player6pts.setText("" + new_pts);
                                away_score += 2;
                                score.setText("" + home_score + " - " + away_score);
                            }
                            else if (stat_index == 1) {
                                String temp = player6pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 3;
                                player6pts.setText("" + new_pts);
                                away_score += 3;
                                score.setText("" + home_score + " - " + away_score);
                            }
                            else if (stat_index == 2) {
                                String temp = player6pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 1;
                                player6pts.setText("" + new_pts);
                                away_score += 1;
                                score.setText("" + home_score + " - " + away_score);
                            }
                            else if (stat_index == 6) {
                                String temp = player6reb.getText().toString();
                                int reb = Integer.parseInt(temp);
                                int new_reb = reb + 1;
                                player6reb.setText("" + new_reb);
                            }
                            else if (stat_index == 7) {
                                String temp = player6ast.getText().toString();
                                int ast = Integer.parseInt(temp);
                                int new_ast = ast + 1;
                                player6ast.setText("" + new_ast);
                            }
                            break;

                        case 7:
                            if (stat_index == 0) {
                                String temp = player7pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 2;
                                player7pts.setText("" + new_pts);
                                away_score += 2;
                                score.setText("" + home_score + " - " + away_score);
                            }
                            else if (stat_index == 1) {
                                String temp = player7pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 3;
                                player7pts.setText("" + new_pts);
                                away_score += 3;
                                score.setText("" + home_score + " - " + away_score);
                            }
                            else if (stat_index == 2) {
                                String temp = player7pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 1;
                                player7pts.setText("" + new_pts);
                                away_score += 1;
                                score.setText("" + home_score + " - " + away_score);
                            }
                            else if (stat_index == 6) {
                                String temp = player7reb.getText().toString();
                                int reb = Integer.parseInt(temp);
                                int new_reb = reb + 1;
                                player7reb.setText("" + new_reb);
                            }
                            else if (stat_index == 7) {
                                String temp = player7ast.getText().toString();
                                int ast = Integer.parseInt(temp);
                                int new_ast = ast + 1;
                                player7ast.setText("" + new_ast);
                            }
                            break;

                        case 8:
                            if (stat_index == 0) {
                                String temp = player8pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 2;
                                player8pts.setText("" + new_pts);
                                away_score += 2;
                                score.setText("" + home_score + " - " + away_score);
                            }
                            else if (stat_index == 1) {
                                String temp = player8pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 3;
                                player8pts.setText("" + new_pts);
                                away_score += 3;
                                score.setText("" + home_score + " - " + away_score);
                            }
                            else if (stat_index == 2) {
                                String temp = player8pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 1;
                                player8pts.setText("" + new_pts);
                                away_score += 1;
                                score.setText("" + home_score + " - " + away_score);
                            }
                            else if (stat_index == 6) {
                                String temp = player8reb.getText().toString();
                                int reb = Integer.parseInt(temp);
                                int new_reb = reb + 1;
                                player8reb.setText("" + new_reb);
                            }
                            else if (stat_index == 7) {
                                String temp = player8ast.getText().toString();
                                int ast = Integer.parseInt(temp);
                                int new_ast = ast + 1;
                                player8ast.setText("" + new_ast);
                            }
                            break;

                        case 9:
                            if (stat_index == 0) {
                                String temp = player9pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 2;
                                player9pts.setText("" + new_pts);
                                away_score += 2;
                                score.setText("" + home_score + " - " + away_score);
                            }
                            else if (stat_index == 1) {
                                String temp = player9pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 3;
                                player9pts.setText("" + new_pts);
                                away_score += 3;
                                score.setText("" + home_score + " - " + away_score);
                            }
                            else if (stat_index == 2) {
                                String temp = player9pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 1;
                                player9pts.setText("" + new_pts);
                                away_score += 1;
                                score.setText("" + home_score + " - " + away_score);
                            }
                            else if (stat_index == 6) {
                                String temp = player9reb.getText().toString();
                                int reb = Integer.parseInt(temp);
                                int new_reb = reb + 1;
                                player9reb.setText("" + new_reb);
                            }
                            else if (stat_index == 7) {
                                String temp = player9ast.getText().toString();
                                int ast = Integer.parseInt(temp);
                                int new_ast = ast + 1;
                                player9ast.setText("" + new_ast);
                            }
                            break;
                    }
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                  //  v.setBackgroundDrawable(normalShape);

                    Log.d("DRAG", "Drag ended!");
                default:
                    break;
            }
            return true;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
