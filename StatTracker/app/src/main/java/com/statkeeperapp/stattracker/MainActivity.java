package com.statkeeperapp.stattracker;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SubDialog.onAcceptButtonClickListener {

    TextView player1pts, player1reb, player1ast, player2pts, player2reb, player2ast, player3pts, player3reb, player3ast,
            player4pts, player4reb, player4ast, player5pts, player5reb, player5ast, player6pts, player6reb, player6ast,
    player7pts, player7reb, player7ast, player8pts, player8reb, player8ast, player9pts, player9reb, player9ast, player0pts, player0reb, player0ast;

    TextView left_player_name1, left_player_name2, left_player_name3, left_player_name4, left_player_name5,  right_player_name1, right_player_name2,
            right_player_name3, right_player_name4, right_player_name5;

    TextView score;

    Player home_player1, home_player2, home_player3, home_player4, home_player5, home_player6, home_player7, home_player8, home_player9, home_player10,
            away_player1,  away_player2,  away_player3,  away_player4,  away_player5, away_player6, away_player7, away_player8, away_player9, away_player10;

    ArrayList<Player> home_player_list, away_player_list;

    ImageView left_player1, left_player2, left_player3, left_player4, left_player5, right_player1, right_player2, right_player3, right_player4, right_player5;

    TextView two_point_make, three_point_make;


    ImageView left_player_plus_red1, left_player_plus_red2, left_player_plus_red3, left_player_plus_red4, left_player_plus_red5;
    ImageView left_player_plus_green1, left_player_plus_green2, left_player_plus_green3, left_player_plus_green4, left_player_plus_green5;
    ImageView left_player_plus_blue1, left_player_plus_blue2, left_player_plus_blue3, left_player_plus_blue4, left_player_plus_blue5;

    ImageView right_player_plus_red1, right_player_plus_red2, right_player_plus_red3, right_player_plus_red4, right_player_plus_red5;
    ImageView right_player_plus_green1, right_player_plus_green2, right_player_plus_green3, right_player_plus_green4, right_player_plus_green5;
    ImageView right_player_plus_blue1, right_player_plus_blue2, right_player_plus_blue3, right_player_plus_blue4, right_player_plus_blue5;

    int current_stat_index;


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
        home_player6 = new Player("K. Irving", "http://forums.nba-live.com/dl_mod/thumbs/5645_CLE_Irving_Kyrie.png");
        home_player7 = new Player("D. Rose", "http://www.nba-live.com/wp-content/uploads/2014/11/derrick_rose_headshot.png");
        home_player8 = new Player("T. Duncan", "http://www.nba-live.com/wp-content/uploads/2012/10/3684_SAS_Duncan_Tim.png");
        home_player9 = new Player("D. Cousins", "http://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/4258.png&w=350&h=254");
        home_player10 = new Player("Birdman", "http://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/1135.png&amp;w=200&amp;h=145");


        away_player1 = new Player("T. Hollerer", "http://www.ieeevr.org/2017/img/tobias-hollerer.jpg");
        away_player2 = new Player("S. Dong", "https://www.cs.ucsb.edu/sites/cs.ucsb.edu/files/styles/portrait-full/public/images/graduate/dong_samuel.jpg?itok=cYWtYbj1&c=ed53ae072f9ae2aa1d80a0c1cab57b49");
        away_player3 = new Player("H. Kung", "https://media.licdn.com/mpr/mpr/shrinknp_400_400/p/5/005/0a5/25f/14fcd8f.jpg");
        away_player4 = new Player("M. Turk", "https://www.cs.ucsb.edu/sites/cs.ucsb.edu/files/styles/portrait-full/public/faculty/images/matthew-turk_0.jpg?itok=Qu98srhX&c=d1bcd0f47e9a68775b3c5d6ad01ffaf8");
        away_player5 = new Player("P. Conrad", "https://pbs.twimg.com/profile_images/73630820/HeadShot.jpg");
        away_player6 = new Player("P. Conrad", "https://pbs.twimg.com/profile_images/73630820/HeadShot.jpg");
        away_player7 = new Player("P. Conrad", "https://pbs.twimg.com/profile_images/73630820/HeadShot.jpg");
        away_player8 = new Player("P. Conrad", "https://pbs.twimg.com/profile_images/73630820/HeadShot.jpg");
        away_player9 = new Player("P. Conrad", "https://pbs.twimg.com/profile_images/73630820/HeadShot.jpg");
        away_player10 = new Player("P. Conrad", "https://pbs.twimg.com/profile_images/73630820/HeadShot.jpg");

        home_player_list = new ArrayList<>();
        home_player_list.add(home_player1);
        home_player_list.add(home_player2);
        home_player_list.add(home_player3);
        home_player_list.add(home_player4);
        home_player_list.add(home_player5);
        home_player_list.add(home_player6);
        home_player_list.add(home_player7);
        home_player_list.add(home_player8);
        home_player_list.add(home_player9);
        home_player_list.add(home_player10);

        away_player_list = new ArrayList<>();
        away_player_list.add(away_player1);
        away_player_list.add(away_player2);
        away_player_list.add(away_player3);
        away_player_list.add(away_player4);
        away_player_list.add(away_player5);
        away_player_list.add(away_player6);
        away_player_list.add(away_player7);
        away_player_list.add(away_player8);
        away_player_list.add(away_player9);
        away_player_list.add(away_player10);

        left_player_name1 = (TextView)findViewById(R.id.left_text_name1);
        left_player_name2 = (TextView)findViewById(R.id.left_text_name2);
        left_player_name3 = (TextView)findViewById(R.id.left_text_name3);
        left_player_name4 = (TextView)findViewById(R.id.left_text_name4);
        left_player_name5 = (TextView)findViewById(R.id.left_text_name5);
        left_player_name1.setText(home_player_list.get(0).getName());
        left_player_name2.setText(home_player_list.get(1).getName());
        left_player_name3.setText(home_player_list.get(2).getName());
        left_player_name4.setText(home_player_list.get(3).getName());
        left_player_name5.setText(home_player_list.get(4).getName());


        right_player_name1 = (TextView)findViewById(R.id.right_text_name1);
        right_player_name2 = (TextView)findViewById(R.id.right_text_name2);
        right_player_name3 = (TextView)findViewById(R.id.right_text_name3);
        right_player_name4 = (TextView)findViewById(R.id.right_text_name4);
        right_player_name5 = (TextView)findViewById(R.id.right_text_name5);
        right_player_name1.setText(away_player_list.get(0).getName());
        right_player_name2.setText(away_player_list.get(1).getName());
        right_player_name3.setText(away_player_list.get(2).getName());
        right_player_name4.setText(away_player_list.get(3).getName());
        right_player_name5.setText(away_player_list.get(4).getName());


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
                showDialog(home_player_list.get(0));
            }
        });

        RelativeLayout left_layout2 = (RelativeLayout)findViewById(R.id.left_card_player_top_center_layout);
        left_layout2.setOnDragListener(new MyDragListener(1));
        left_layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(home_player_list.get(1));
            }
        });
        RelativeLayout left_layout3 = (RelativeLayout)findViewById(R.id.left_card_player_top_right_layout);
        left_layout3.setOnDragListener(new MyDragListener(2));
        left_layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(home_player_list.get(2));
            }
        });
        RelativeLayout left_layout4 = (RelativeLayout)findViewById(R.id.left_card_player_bot_left_layout);
        left_layout4.setOnDragListener(new MyDragListener(3));
        left_layout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(home_player_list.get(3));
            }
        });
        RelativeLayout left_layout5 = (RelativeLayout)findViewById(R.id.left_card_player_bot_right_layout);
        left_layout5.setOnDragListener(new MyDragListener(4));
        left_layout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(home_player_list.get(4));
            }
        });

        RelativeLayout right_layout1 = (RelativeLayout)findViewById(R.id.right_card_player_top_left_layout);
        right_layout1.setOnDragListener(new MyDragListener(5));
        right_layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(away_player_list.get(0));
            }
        });
        RelativeLayout right_layout2 = (RelativeLayout)findViewById(R.id.right_card_player_top_center_layout);
        right_layout2.setOnDragListener(new MyDragListener(6));
        right_layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(away_player_list.get(1));
            }
        });
        RelativeLayout right_layout3 = (RelativeLayout)findViewById(R.id.right_card_player_top_right_layout);
        right_layout3.setOnDragListener(new MyDragListener(7));
        right_layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(away_player_list.get(2));
            }
        });
        RelativeLayout right_layout4 = (RelativeLayout)findViewById(R.id.right_card_player_bot_left_layout);
        right_layout4.setOnDragListener(new MyDragListener(8));
        right_layout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(away_player_list.get(3));
            }
        });
        RelativeLayout right_layout5 = (RelativeLayout)findViewById(R.id.right_card_player_bot_right_layout);
        right_layout5.setOnDragListener(new MyDragListener(9));
        right_layout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(away_player_list.get(4));
            }
        });

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



        left_player1 = (ImageView) findViewById(R.id.left_image_player_top_left);
        Picasso.with(getApplicationContext()).load(home_player1.getImage_url()).transform(new CircleTransform()).into(left_player1);
        left_player2 = (ImageView) findViewById(R.id.left_image_player_top_center);
        Picasso.with(getApplicationContext()).load(home_player2.getImage_url()).transform(new CircleTransform()).into(left_player2);
        left_player3 = (ImageView) findViewById(R.id.left_image_player_top_right);
        Picasso.with(getApplicationContext()).load(home_player3.getImage_url()).transform(new CircleTransform()).into(left_player3);
        left_player4 = (ImageView) findViewById(R.id.left_image_player_bot_left);
        Picasso.with(getApplicationContext()).load(home_player4.getImage_url()).transform(new CircleTransform()).into(left_player4);
        left_player5 = (ImageView) findViewById(R.id.left_image_player_bot_right);
        Picasso.with(getApplicationContext()).load(home_player5.getImage_url()).transform(new CircleTransform()).into(left_player5);

        right_player1 = (ImageView) findViewById(R.id.right_image_player_top_left);
        Picasso.with(getApplicationContext()).load(away_player1.getImage_url()).transform(new CircleTransform()).into(right_player1);
        right_player2 = (ImageView) findViewById(R.id.right_image_player_top_center);
        Picasso.with(getApplicationContext()).load(away_player2.getImage_url()).transform(new CircleTransform()).into(right_player2);
        right_player3 = (ImageView) findViewById(R.id.right_image_player_top_right);
        Picasso.with(getApplicationContext()).load(away_player3.getImage_url()).transform(new CircleTransform()).into(right_player3);
        right_player4 = (ImageView) findViewById(R.id.right_image_player_bot_left);
        Picasso.with(getApplicationContext()).load(away_player4.getImage_url()).transform(new CircleTransform()).into(right_player4);
        right_player5 = (ImageView) findViewById(R.id.right_image_player_bot_right);
        Picasso.with(getApplicationContext()).load(away_player5.getImage_url()).transform(new CircleTransform()).into(right_player5);

        ImageView left_sub = (ImageView) findViewById(R.id.left_substitute);
        left_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSubDialog(home_player_list, "home");
            }
        });

        ImageView right_sub = (ImageView) findViewById(R.id.right_substitute);
        right_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSubDialog(away_player_list, "away");
            }
        });


        // initialize 3 possible images for each player when stat is dropped
        left_player_plus_red1 = (ImageView) findViewById(R.id.plus_one_red1);
        left_player_plus_red2 = (ImageView) findViewById(R.id.plus_one_red2);
        left_player_plus_red3 = (ImageView) findViewById(R.id.plus_one_red3);
        left_player_plus_red4 = (ImageView) findViewById(R.id.plus_one_red4);
        left_player_plus_red5 = (ImageView) findViewById(R.id.plus_one_red5);

        left_player_plus_green1 = (ImageView) findViewById(R.id.plus_one_green1);
        left_player_plus_green2 = (ImageView) findViewById(R.id.plus_one_green2);
        left_player_plus_green3 = (ImageView) findViewById(R.id.plus_one_green3);
        left_player_plus_green4 = (ImageView) findViewById(R.id.plus_one_green4);
        left_player_plus_green5 = (ImageView) findViewById(R.id.plus_one_green5);

        left_player_plus_blue1 = (ImageView) findViewById(R.id.plus_one_blue1);
        left_player_plus_blue2 = (ImageView) findViewById(R.id.plus_one_blue2);
        left_player_plus_blue3 = (ImageView) findViewById(R.id.plus_one_blue3);
        left_player_plus_blue4 = (ImageView) findViewById(R.id.plus_one_blue4);
        left_player_plus_blue5 = (ImageView) findViewById(R.id.plus_one_blue5);

        right_player_plus_red1 = (ImageView) findViewById(R.id.plus_one_red6);
        right_player_plus_red2 = (ImageView) findViewById(R.id.plus_one_red7);
        right_player_plus_red3 = (ImageView) findViewById(R.id.plus_one_red8);
        right_player_plus_red4 = (ImageView) findViewById(R.id.plus_one_red9);
        right_player_plus_red5 = (ImageView) findViewById(R.id.plus_one_red10);

        right_player_plus_blue1 = (ImageView) findViewById(R.id.plus_one_blue6);
        right_player_plus_blue2 = (ImageView) findViewById(R.id.plus_one_blue7);
        right_player_plus_blue3 = (ImageView) findViewById(R.id.plus_one_blue8);
        right_player_plus_blue4 = (ImageView) findViewById(R.id.plus_one_blue9);
        right_player_plus_blue5 = (ImageView) findViewById(R.id.plus_one_blue10);

        right_player_plus_green1 = (ImageView) findViewById(R.id.plus_one_green6);
        right_player_plus_green2 = (ImageView) findViewById(R.id.plus_one_green7);
        right_player_plus_green3 = (ImageView) findViewById(R.id.plus_one_green8);
        right_player_plus_green4 = (ImageView) findViewById(R.id.plus_one_green9);
        right_player_plus_green5 = (ImageView) findViewById(R.id.plus_one_green10);

        TextView button_endgame = (TextView) findViewById(R.id.button_quit_game);
        button_endgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("End Game");
                alertDialog.setMessage("Are you sure you want to end the game?");
                alertDialog.setIcon(R.mipmap.ic_warning_black_24dp);
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alertDialog.dismiss();
                    }
                });
                alertDialog.show();
            }
        });

        TextView button_undo = (TextView) findViewById(R.id.button_undo);
        button_undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do undo stuff here
            }
        });

    }

    public void onAcceptButtonClick() {
        Log.d("ACCEPT", "on Accept button click called!");

        // update names
        left_player_name1.setText(home_player_list.get(0).getName());
        left_player_name2.setText(home_player_list.get(1).getName());
        left_player_name3.setText(home_player_list.get(2).getName());
        left_player_name4.setText(home_player_list.get(3).getName());
        left_player_name5.setText(home_player_list.get(4).getName());

        right_player_name1.setText(away_player_list.get(0).getName());
        right_player_name2.setText(away_player_list.get(1).getName());
        right_player_name3.setText(away_player_list.get(2).getName());
        right_player_name4.setText(away_player_list.get(3).getName());
        right_player_name5.setText(away_player_list.get(4).getName());

        // update images
        Picasso.with(getApplicationContext()).load(home_player_list.get(0).getImage_url()).transform(new CircleTransform()).into(left_player1);
        Picasso.with(getApplicationContext()).load(home_player_list.get(1).getImage_url()).transform(new CircleTransform()).into(left_player2);
        Picasso.with(getApplicationContext()).load(home_player_list.get(2).getImage_url()).transform(new CircleTransform()).into(left_player3);
        Picasso.with(getApplicationContext()).load(home_player_list.get(3).getImage_url()).transform(new CircleTransform()).into(left_player4);
        Picasso.with(getApplicationContext()).load(home_player_list.get(4).getImage_url()).transform(new CircleTransform()).into(left_player5);

        Picasso.with(getApplicationContext()).load(away_player_list.get(0).getImage_url()).transform(new CircleTransform()).into(right_player1);
        Picasso.with(getApplicationContext()).load(away_player_list.get(1).getImage_url()).transform(new CircleTransform()).into(right_player2);
        Picasso.with(getApplicationContext()).load(away_player_list.get(2).getImage_url()).transform(new CircleTransform()).into(right_player3);
        Picasso.with(getApplicationContext()).load(away_player_list.get(3).getImage_url()).transform(new CircleTransform()).into(right_player4);
        Picasso.with(getApplicationContext()).load(away_player_list.get(4).getImage_url()).transform(new CircleTransform()).into(right_player5);

        // update points
        player0pts.setText("" + home_player_list.get(0).getPoints());
        player1pts.setText("" + home_player_list.get(1).getPoints());
        player2pts.setText("" + home_player_list.get(2).getPoints());
        player3pts.setText("" + home_player_list.get(3).getPoints());
        player4pts.setText("" + home_player_list.get(4).getPoints());

        player5pts.setText("" + away_player_list.get(0).getPoints());
        player6pts.setText("" + away_player_list.get(1).getPoints());
        player7pts.setText("" + away_player_list.get(2).getPoints());
        player8pts.setText("" + away_player_list.get(3).getPoints());
        player9pts.setText("" + away_player_list.get(4).getPoints());

        // update rebounds
        player0reb.setText("" + home_player_list.get(0).getRebounds());
        player1reb.setText("" + home_player_list.get(1).getRebounds());
        player2reb.setText("" + home_player_list.get(2).getRebounds());
        player3reb.setText("" + home_player_list.get(3).getRebounds());
        player4reb.setText("" + home_player_list.get(4).getRebounds());

        player5reb.setText("" + away_player_list.get(0).getRebounds());
        player6reb.setText("" + away_player_list.get(1).getRebounds());
        player7reb.setText("" + away_player_list.get(2).getRebounds());
        player8reb.setText("" + away_player_list.get(3).getRebounds());
        player9reb.setText("" + away_player_list.get(4).getRebounds());

        // update assists
        player0ast.setText("" + home_player_list.get(0).getAssists());
        player1ast.setText("" + home_player_list.get(1).getAssists());
        player2ast.setText("" + home_player_list.get(2).getAssists());
        player3ast.setText("" + home_player_list.get(3).getAssists());
        player4ast.setText("" + home_player_list.get(4).getAssists());

        player5ast.setText("" + away_player_list.get(0).getAssists());
        player6ast.setText("" + away_player_list.get(1).getAssists());
        player7ast.setText("" + away_player_list.get(2).getAssists());
        player8ast.setText("" + away_player_list.get(3).getAssists());
        player9ast.setText("" + away_player_list.get(4).getAssists());

    }

    private void showSubDialog(ArrayList<Player> p, String team) {
        android.app.DialogFragment dialogFragment = SubDialog.newInstance(p, team);
        //dialogFragment.setTargetFragment(dialogFragment, 1);
        dialogFragment.show(getFragmentManager(), "sub_dialog");
    }


    private void showDialog(Player p) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        DialogFragment dialogFragment = DetailDialog.newInstance(p);
        //dialogFragment.setTargetFragment(dialogFragment, 1);
        dialogFragment.show(ft, "dialog");
    }

    private final class MyTouchListener implements View.OnTouchListener {

        int index;

        MyTouchListener(int i) {
            index = i;
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("stat", "" + index);
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(data, shadowBuilder, v, 0);
                v.setVisibility(View.VISIBLE);
                Log.d("ON TOUCH", "stat index: " + index);
                current_stat_index = index;
                return true;
            }
            else {
                return false;
            }

        }
    }

    class MyDragListener implements View.OnDragListener {
        Drawable enterShape = getResources().getDrawable(R.drawable.shape_hover);
        Drawable enterShapeGreen = getResources().getDrawable(R.drawable.green_highlight_grey_back);
        Drawable enterShapeRed = getResources().getDrawable(R.drawable.red_highlight_grey_back);
        Drawable enterShapeBlue = getResources().getDrawable(R.drawable.blue_highlight_grey_back);
        Drawable normalShape = getResources().getDrawable(R.drawable.shape_normal);
        Drawable green_highlgight_Shape = getResources().getDrawable(R.drawable.substitute_highlight);


        int index;

        MyDragListener(int id) {
            index = id;
        }

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action  = event.getAction();


            final View final_view = v;

            switch (event.getAction()) {

                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing
                    Log.d("DRAG", "Drag started! for index");
                    break;

                // called when item is dragged into target layout
                case DragEvent.ACTION_DRAG_ENTERED:

                    Log.d("ENTER", "Entered the player card! at current stat: " + current_stat_index);


                    // set the highlight color when hovering over player card
                    if (current_stat_index == 0 || current_stat_index == 1 || current_stat_index == 2) {
                        v.setBackgroundDrawable(enterShapeGreen);
                    }
                    else if (current_stat_index == 3 || current_stat_index == 4 || current_stat_index == 5) {
                        v.setBackgroundDrawable(enterShapeRed);
                    }
                    else {
                        v.setBackgroundDrawable(enterShapeBlue);
                    }
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

                        /* home player 0
                        /*
                        */
                        case 0:

                            // update home player 0's fg made and points
                            if (stat_index == 0) {

                                // update player card points stat
                                String temp = player0pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 2;
                                player0pts.setText("" + new_pts);
                                home_score += 2;

                                // update game score
                                score.setText("" + home_score + " - " + away_score);

                                home_player_list.get(0).setFg_made(home_player_list.get(0).getFg_made() + 1);
                                home_player_list.get(0).setPoints(home_player_list.get(0).getPoints() + 2);

                                // handle animation
                                left_player1.setVisibility(View.INVISIBLE);
                                left_player_plus_green1.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_green1.setAnimation(zoom_in);
                                left_player_plus_green1.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_green1.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_green1.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_green1.setVisibility(View.INVISIBLE);
                                                left_player1.setVisibility(View.VISIBLE);
                                               // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);

                            }

                            // update home player 0's three point made and points
                            else if (stat_index == 1) {
                                String temp = player0pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 3;
                                player0pts.setText("" + new_pts);

                                // update game score
                                home_score += 3;
                                score.setText("" + home_score + " - " + away_score);

                                home_player_list.get(0).setThree_made(home_player_list.get(0).getThree_made() + 1);
                                home_player_list.get(0).setFg_made(home_player_list.get(0).getFg_made() + 1);
                                home_player_list.get(0).setPoints(home_player_list.get(0).getPoints() + 3);

                                // handle animation
                                left_player1.setVisibility(View.INVISIBLE);
                                left_player_plus_green1.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_green1.setAnimation(zoom_in);
                                left_player_plus_green1.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_green1.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_green1.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_green1.setVisibility(View.INVISIBLE);
                                                left_player1.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);

                            }

                            // update home player 0's ft made and points
                            else if (stat_index == 2) {
                                String temp = player0pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 1;
                                player0pts.setText("" + new_pts);

                                // update game score
                                home_score += 1;
                                score.setText("" + home_score + " - " + away_score);

                                home_player_list.get(0).setFt_made(home_player_list.get(0).getFt_made() + 1);
                                home_player_list.get(0).setPoints(home_player_list.get(0).getPoints() + 1);

                                // handle animation
                                left_player1.setVisibility(View.INVISIBLE);
                                left_player_plus_green1.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_green1.setAnimation(zoom_in);
                                left_player_plus_green1.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_green1.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_green1.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_green1.setVisibility(View.INVISIBLE);
                                                left_player1.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 0's fg misses
                            else if(stat_index == 3) {
                                home_player_list.get(0).setFg_miss(home_player_list.get(0).getFg_miss() + 1);
                                // handle animation
                                left_player1.setVisibility(View.INVISIBLE);
                                left_player_plus_red1.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_red1.setAnimation(zoom_in);
                                left_player_plus_red1.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_red1.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_red1.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_red1.setVisibility(View.INVISIBLE);
                                                left_player1.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 0's three point misses
                            else if (stat_index == 4) {
                                home_player_list.get(0).setThree_miss(home_player_list.get(0).getThree_miss() + 1);
                                home_player_list.get(0).setFg_miss(home_player_list.get(0).getFg_miss() + 1);
                                // handle animation
                                left_player1.setVisibility(View.INVISIBLE);
                                left_player_plus_red1.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_red1.setAnimation(zoom_in);
                                left_player_plus_red1.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_red1.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_red1.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_red1.setVisibility(View.INVISIBLE);
                                                left_player1.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 0's missed fts
                            else if (stat_index == 5) {
                                home_player_list.get(0).setFt_miss(home_player_list.get(0).getFt_miss() + 1);
                                // handle animation
                                left_player1.setVisibility(View.INVISIBLE);
                                left_player_plus_red1.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_red1.setAnimation(zoom_in);
                                left_player_plus_red1.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_red1.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_red1.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_red1.setVisibility(View.INVISIBLE);
                                                left_player1.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 0's rebounds
                            else if (stat_index == 6) {
                                String temp = player0reb.getText().toString();
                                int reb = Integer.parseInt(temp);
                                int new_reb = reb + 1;
                                player0reb.setText("" + new_reb);

                                home_player_list.get(0).setRebounds(home_player_list.get(0).getRebounds() + 1);

                                // handle animation
                                left_player1.setVisibility(View.INVISIBLE);
                                left_player_plus_blue1.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_blue1.setAnimation(zoom_in);
                                left_player_plus_blue1.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_blue1.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_blue1.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_blue1.setVisibility(View.INVISIBLE);
                                                left_player1.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 0's assists
                            else if (stat_index == 7) {
                                String temp = player0ast.getText().toString();
                                int ast = Integer.parseInt(temp);
                                int new_ast = ast + 1;
                                player0ast.setText("" + new_ast);

                                home_player_list.get(0).setAssists(home_player_list.get(0).getAssists() + 1);
                                // handle animation
                                left_player1.setVisibility(View.INVISIBLE);
                                left_player_plus_blue1.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_blue1.setAnimation(zoom_in);
                                left_player_plus_blue1.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_blue1.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_blue1.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_blue1.setVisibility(View.INVISIBLE);
                                                left_player1.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 0's steals
                            else if (stat_index == 8) {
                                home_player_list.get(0).setSteals(home_player_list.get(0).getSteals() + 1);
                                // handle animation
                                left_player1.setVisibility(View.INVISIBLE);
                                left_player_plus_blue1.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_blue1.setAnimation(zoom_in);
                                left_player_plus_blue1.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_blue1.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_blue1.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_blue1.setVisibility(View.INVISIBLE);
                                                left_player1.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 0's blocks
                            else if (stat_index == 9) {
                                home_player_list.get(0).setBlocks(home_player_list.get(0).getBlocks() + 1);
                                // handle animation
                                left_player1.setVisibility(View.INVISIBLE);
                                left_player_plus_blue1.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_blue1.setAnimation(zoom_in);
                                left_player_plus_blue1.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_blue1.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_blue1.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_blue1.setVisibility(View.INVISIBLE);
                                                left_player1.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }
                            // update home player 0's fouls
                            else if (stat_index == 10) {
                                home_player_list.get(0).setFouls(home_player_list.get(0).getFouls() + 1);
                                // handle animation
                                left_player1.setVisibility(View.INVISIBLE);
                                left_player_plus_blue1.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_blue1.setAnimation(zoom_in);
                                left_player_plus_blue1.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_blue1.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_blue1.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_blue1.setVisibility(View.INVISIBLE);
                                                left_player1.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 0's turnovers
                            else if (stat_index == 11) {
                                home_player_list.get(0).setTurnovers(home_player_list.get(0).getTurnovers() + 1);
                                // handle animation
                                left_player1.setVisibility(View.INVISIBLE);
                                left_player_plus_blue1.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_blue1.setAnimation(zoom_in);
                                left_player_plus_blue1.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_blue1.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_blue1.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_blue1.setVisibility(View.INVISIBLE);
                                                left_player1.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            break;

                         /* home player 1
                         /*
                         */
                        case 1:
                            // update home player 1's fg made and points
                            if (stat_index == 0) {
                                String temp = player1pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 2;
                                player1pts.setText("" + new_pts);
                                home_score += 2;

                                // update game score
                                score.setText("" + home_score + " - " + away_score);

                                home_player_list.get(1).setFg_made(home_player_list.get(1).getFg_made() + 1);
                                home_player_list.get(1).setPoints(home_player_list.get(1).getPoints() + 2);

                                // handle animation
                                left_player2.setVisibility(View.INVISIBLE);
                                left_player_plus_green2.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_green2.setAnimation(zoom_in);
                                left_player_plus_green2.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_green2.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_green2.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_green2.setVisibility(View.INVISIBLE);
                                                left_player2.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);

                            }

                            // update home player 1's three point made and points
                            else if (stat_index == 1) {
                                String temp = player1pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 3;
                                player1pts.setText("" + new_pts);

                                // update game score
                                home_score += 3;
                                score.setText("" + home_score + " - " + away_score);

                                home_player_list.get(1).setFg_made(home_player_list.get(1).getFg_made() + 1);
                                home_player_list.get(1).setThree_made(home_player_list.get(1).getThree_made() + 1);
                                home_player_list.get(1).setPoints(home_player_list.get(1).getPoints() + 3);

                                // handle animation
                                left_player2.setVisibility(View.INVISIBLE);
                                left_player_plus_green2.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_green2.setAnimation(zoom_in);
                                left_player_plus_green2.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_green2.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_green2.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_green2.setVisibility(View.INVISIBLE);
                                                left_player2.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 1's ft made and points
                            else if (stat_index == 2) {
                                String temp = player1pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 1;
                                player1pts.setText("" + new_pts);

                                // update game score
                                home_score += 1;
                                score.setText("" + home_score + " - " + away_score);

                                home_player_list.get(1).setFt_made(home_player_list.get(1).getFt_made() + 1);
                                home_player_list.get(1).setPoints(home_player_list.get(1).getPoints() + 1);

                                // handle animation
                                left_player2.setVisibility(View.INVISIBLE);
                                left_player_plus_green2.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_green2.setAnimation(zoom_in);
                                left_player_plus_green2.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_green2.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_green2.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_green2.setVisibility(View.INVISIBLE);
                                                left_player2.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 1's fg misses
                            else if(stat_index == 3) {
                                home_player_list.get(1).setFg_miss(home_player_list.get(1).getFg_miss() + 1);
                                // handle animation
                                left_player2.setVisibility(View.INVISIBLE);
                                left_player_plus_red2.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_red2.setAnimation(zoom_in);
                                left_player_plus_red2.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_red2.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_red2.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_red2.setVisibility(View.INVISIBLE);
                                                left_player2.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 1's three point misses
                            else if (stat_index == 4) {
                                home_player_list.get(1).setFg_miss(home_player_list.get(1).getFg_miss() + 1);
                                home_player_list.get(1).setThree_miss(home_player_list.get(1).getThree_miss() + 1);
                                // handle animation
                                left_player2.setVisibility(View.INVISIBLE);
                                left_player_plus_red2.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_red2.setAnimation(zoom_in);
                                left_player_plus_red2.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_red2.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_red2.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_red2.setVisibility(View.INVISIBLE);
                                                left_player2.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 1's missed fts
                            else if (stat_index == 5) {
                                home_player_list.get(1).setFt_miss(home_player_list.get(1).getFt_miss() + 1);
                                // handle animation
                                left_player2.setVisibility(View.INVISIBLE);
                                left_player_plus_red2.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_red2.setAnimation(zoom_in);
                                left_player_plus_red2.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_red2.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_red2.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_red2.setVisibility(View.INVISIBLE);
                                                left_player2.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 1's rebounds
                            else if (stat_index == 6) {
                                String temp = player1reb.getText().toString();
                                int reb = Integer.parseInt(temp);
                                int new_reb = reb + 1;
                                player1reb.setText("" + new_reb);

                                home_player_list.get(1).setRebounds(home_player_list.get(1).getRebounds() + 1);

                                // handle animation
                                left_player2.setVisibility(View.INVISIBLE);
                                left_player_plus_blue2.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_blue2.setAnimation(zoom_in);
                                left_player_plus_blue2.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_blue2.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_blue2.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_blue2.setVisibility(View.INVISIBLE);
                                                left_player2.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 1's assists
                            else if (stat_index == 7) {
                                String temp = player1ast.getText().toString();
                                int ast = Integer.parseInt(temp);
                                int new_ast = ast + 1;
                                player1ast.setText("" + new_ast);

                                home_player_list.get(1).setAssists(home_player_list.get(1).getAssists() + 1);
                                // handle animation
                                left_player2.setVisibility(View.INVISIBLE);
                                left_player_plus_blue2.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_blue2.setAnimation(zoom_in);
                                left_player_plus_blue2.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_blue2.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_blue2.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_blue2.setVisibility(View.INVISIBLE);
                                                left_player2.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 1's steals
                            else if (stat_index == 8) {
                                home_player_list.get(1).setSteals(home_player_list.get(1).getSteals() + 1);
                                // handle animation
                                left_player2.setVisibility(View.INVISIBLE);
                                left_player_plus_blue2.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_blue2.setAnimation(zoom_in);
                                left_player_plus_blue2.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_blue2.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_blue2.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_blue2.setVisibility(View.INVISIBLE);
                                                left_player2.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 1's blocks
                            else if (stat_index == 9) {
                                home_player_list.get(1).setBlocks(home_player_list.get(1).getBlocks() + 1);
                                // handle animation
                                left_player2.setVisibility(View.INVISIBLE);
                                left_player_plus_blue2.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_blue2.setAnimation(zoom_in);
                                left_player_plus_blue2.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_blue2.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_blue2.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_blue2.setVisibility(View.INVISIBLE);
                                                left_player2.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }
                            // update home player 1's fouls
                            else if (stat_index == 10) {
                                home_player_list.get(1).setFouls(home_player_list.get(1).getFouls() + 1);
                                // handle animation
                                left_player2.setVisibility(View.INVISIBLE);
                                left_player_plus_blue2.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_blue2.setAnimation(zoom_in);
                                left_player_plus_blue2.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_blue2.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_blue2.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_blue2.setVisibility(View.INVISIBLE);
                                                left_player2.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 1's turnovers
                            else if (stat_index == 11) {
                                home_player_list.get(1).setTurnovers(home_player_list.get(1).getTurnovers() + 1);
                                // handle animation
                                left_player2.setVisibility(View.INVISIBLE);
                                left_player_plus_blue2.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_blue2.setAnimation(zoom_in);
                                left_player_plus_blue2.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_blue2.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_blue2.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_blue2.setVisibility(View.INVISIBLE);
                                                left_player2.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            break;

                        // home player 2
                        case 2:
                            // update home player 2's fg made and points
                            if (stat_index == 0) {
                                String temp = player2pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 2;
                                player2pts.setText("" + new_pts);
                                home_score += 2;

                                // update game score
                                score.setText("" + home_score + " - " + away_score);

                                home_player_list.get(2).setFg_made(home_player_list.get(2).getFg_made() + 1);
                                home_player_list.get(2).setPoints(home_player_list.get(2).getPoints() + 2);

                                // handle animation
                                left_player3.setVisibility(View.INVISIBLE);
                                left_player_plus_green3.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_green3.setAnimation(zoom_in);
                                left_player_plus_green3.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_green3.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_green3.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_green3.setVisibility(View.INVISIBLE);
                                                left_player3.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);

                            }

                            // update home player 2's three point made and points
                            else if (stat_index == 1) {
                                String temp = player2pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 3;
                                player2pts.setText("" + new_pts);

                                // update game score
                                home_score += 3;
                                score.setText("" + home_score + " - " + away_score);

                                home_player_list.get(2).setThree_made(home_player_list.get(2).getThree_made() + 1);
                                home_player_list.get(2).setPoints(home_player_list.get(2).getPoints() + 3);
                                home_player_list.get(2).setFg_made(home_player_list.get(2).getFg_made() + 1);
                                // handle animation
                                left_player3.setVisibility(View.INVISIBLE);
                                left_player_plus_green3.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_green3.setAnimation(zoom_in);
                                left_player_plus_green3.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_green3.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_green3.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_green3.setVisibility(View.INVISIBLE);
                                                left_player3.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 2's ft made and points
                            else if (stat_index == 2) {
                                String temp = player2pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 1;
                                player2pts.setText("" + new_pts);

                                // update game score
                                home_score += 1;
                                score.setText("" + home_score + " - " + away_score);

                                home_player_list.get(2).setFt_made(home_player_list.get(2).getFt_made() + 1);
                                home_player_list.get(2).setPoints(home_player_list.get(2).getPoints() + 1);
                                // handle animation
                                left_player3.setVisibility(View.INVISIBLE);
                                left_player_plus_green3.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_green3.setAnimation(zoom_in);
                                left_player_plus_green3.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_green3.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_green3.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_green3.setVisibility(View.INVISIBLE);
                                                left_player3.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 2's fg misses
                            else if(stat_index == 3) {
                                home_player_list.get(2).setFg_miss(home_player_list.get(2).getFg_miss() + 1);
                                // handle animation
                                left_player3.setVisibility(View.INVISIBLE);
                                left_player_plus_red3.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_red3.setAnimation(zoom_in);
                                left_player_plus_red3.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_red3.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_red3.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_red3.setVisibility(View.INVISIBLE);
                                                left_player3.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 2's three point misses
                            else if (stat_index == 4) {
                                home_player_list.get(2).setFg_miss(home_player_list.get(2).getFg_miss() + 1);
                                home_player_list.get(2).setThree_miss(home_player_list.get(2).getThree_miss() + 1);
                                // handle animation
                                left_player3.setVisibility(View.INVISIBLE);
                                left_player_plus_red3.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_red3.setAnimation(zoom_in);
                                left_player_plus_red3.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_red3.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_red3.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_red3.setVisibility(View.INVISIBLE);
                                                left_player3.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 2's missed fts
                            else if (stat_index == 5) {
                                home_player_list.get(2).setFt_miss(home_player_list.get(2).getFt_miss() + 1);
                                // handle animation
                                left_player3.setVisibility(View.INVISIBLE);
                                left_player_plus_red3.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_red3.setAnimation(zoom_in);
                                left_player_plus_red3.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_red3.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_red3.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_red3.setVisibility(View.INVISIBLE);
                                                left_player3.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 2's rebounds
                            else if (stat_index == 6) {
                                String temp = player2reb.getText().toString();
                                int reb = Integer.parseInt(temp);
                                int new_reb = reb + 1;
                                player2reb.setText("" + new_reb);

                                home_player_list.get(2).setRebounds(home_player_list.get(2).getRebounds() + 1);

                                // handle animation
                                left_player3.setVisibility(View.INVISIBLE);
                                left_player_plus_blue3.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_blue3.setAnimation(zoom_in);
                                left_player_plus_blue3.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_blue3.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_blue3.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_blue3.setVisibility(View.INVISIBLE);
                                                left_player3.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 2's assists
                            else if (stat_index == 7) {
                                String temp = player2ast.getText().toString();
                                int ast = Integer.parseInt(temp);
                                int new_ast = ast + 1;
                                player2ast.setText("" + new_ast);

                                home_player_list.get(2).setAssists(home_player_list.get(2).getAssists() + 1);

                                // handle animation
                                left_player3.setVisibility(View.INVISIBLE);
                                left_player_plus_blue3.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_blue3.setAnimation(zoom_in);
                                left_player_plus_blue3.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_blue3.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_blue3.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_blue3.setVisibility(View.INVISIBLE);
                                                left_player3.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 2's steals
                            else if (stat_index == 8) {
                                home_player_list.get(2).setSteals(home_player_list.get(2).getSteals() + 1);

                                // handle animation
                                left_player3.setVisibility(View.INVISIBLE);
                                left_player_plus_blue3.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_blue3.setAnimation(zoom_in);
                                left_player_plus_blue3.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_blue3.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_blue3.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_blue3.setVisibility(View.INVISIBLE);
                                                left_player3.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 2's blocks
                            else if (stat_index == 9) {
                                home_player_list.get(2).setBlocks(home_player_list.get(2).getBlocks() + 1);

                                // handle animation
                                left_player3.setVisibility(View.INVISIBLE);
                                left_player_plus_blue3.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_blue3.setAnimation(zoom_in);
                                left_player_plus_blue3.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_blue3.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_blue3.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_blue3.setVisibility(View.INVISIBLE);
                                                left_player3.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }
                            // update home player 2's fouls
                            else if (stat_index == 10) {
                                home_player_list.get(2).setFouls(home_player_list.get(2).getFouls() + 1);

                                // handle animation
                                left_player3.setVisibility(View.INVISIBLE);
                                left_player_plus_blue3.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_blue3.setAnimation(zoom_in);
                                left_player_plus_blue3.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_blue3.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_blue3.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_blue3.setVisibility(View.INVISIBLE);
                                                left_player3.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 2's turnovers
                            else if (stat_index == 11) {
                                home_player_list.get(2).setTurnovers(home_player_list.get(2).getTurnovers() + 1);

                                // handle animation
                                left_player3.setVisibility(View.INVISIBLE);
                                left_player_plus_blue3.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_blue3.setAnimation(zoom_in);
                                left_player_plus_blue3.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_blue3.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_blue3.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_blue3.setVisibility(View.INVISIBLE);
                                                left_player3.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            break;

                        // home player 3

                        case 3:
                            // update home player 3's fg made and points
                            if (stat_index == 0) {
                                String temp = player3pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 2;
                                player3pts.setText("" + new_pts);
                                home_score += 2;

                                // update game score
                                score.setText("" + home_score + " - " + away_score);

                                home_player_list.get(3).setFg_made(home_player_list.get(3).getFg_made() + 1);
                                home_player_list.get(3).setPoints(home_player_list.get(3).getPoints() + 2);

                                // handle animation
                                left_player4.setVisibility(View.INVISIBLE);
                                left_player_plus_green4.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_green4.setAnimation(zoom_in);
                                left_player_plus_green4.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_green4.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_green4.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_green4.setVisibility(View.INVISIBLE);
                                                left_player4.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);

                            }

                            // update home player 3's three point made and points
                            else if (stat_index == 1) {
                                String temp = player3pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 3;
                                player3pts.setText("" + new_pts);

                                // update game score
                                home_score += 3;
                                score.setText("" + home_score + " - " + away_score);

                                home_player_list.get(3).setThree_made(home_player_list.get(3).getThree_made() + 1);
                                home_player_list.get(3).setPoints(home_player_list.get(3).getPoints() + 3);
                                home_player_list.get(3).setFg_made(home_player_list.get(3).getFg_made() + 1);
                                // handle animation
                                left_player4.setVisibility(View.INVISIBLE);
                                left_player_plus_green4.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_green4.setAnimation(zoom_in);
                                left_player_plus_green4.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_green4.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_green4.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_green4.setVisibility(View.INVISIBLE);
                                                left_player4.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 3's ft made and points
                            else if (stat_index == 2) {
                                String temp = player3pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 1;
                                player3pts.setText("" + new_pts);

                                // update game score
                                home_score += 1;
                                score.setText("" + home_score + " - " + away_score);

                                home_player_list.get(3).setFt_made(home_player_list.get(3).getFt_made() + 1);
                                home_player_list.get(3).setPoints(home_player_list.get(3).getPoints() + 1);
                                // handle animation
                                left_player4.setVisibility(View.INVISIBLE);
                                left_player_plus_green4.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_green4.setAnimation(zoom_in);
                                left_player_plus_green4.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_green4.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_green4.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_green4.setVisibility(View.INVISIBLE);
                                                left_player4.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 3's fg misses
                            else if(stat_index == 3) {
                                home_player_list.get(3).setFg_miss(home_player_list.get(3).getFg_miss() + 1);
                                // handle animation
                                left_player4.setVisibility(View.INVISIBLE);
                                left_player_plus_red4.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_red4.setAnimation(zoom_in);
                                left_player_plus_red4.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_red4.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_red4.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_red4.setVisibility(View.INVISIBLE);
                                                left_player4.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 3's three point misses
                            else if (stat_index == 4) {
                                home_player_list.get(3).setFg_miss(home_player_list.get(3).getFg_miss() + 1);
                                home_player_list.get(3).setThree_miss(home_player_list.get(3).getThree_miss() + 1);
                                // handle animation
                                left_player4.setVisibility(View.INVISIBLE);
                                left_player_plus_red4.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_red4.setAnimation(zoom_in);
                                left_player_plus_red4.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_red4.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_red4.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_red4.setVisibility(View.INVISIBLE);
                                                left_player4.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 3's missed fts
                            else if (stat_index == 5) {
                                home_player_list.get(3).setFt_miss(home_player_list.get(3).getFt_miss() + 1);
                                // handle animation
                                left_player4.setVisibility(View.INVISIBLE);
                                left_player_plus_red4.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_red4.setAnimation(zoom_in);
                                left_player_plus_red4.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_red4.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_red4.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_red4.setVisibility(View.INVISIBLE);
                                                left_player4.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 3's rebounds
                            else if (stat_index == 6) {
                                String temp = player3reb.getText().toString();
                                int reb = Integer.parseInt(temp);
                                int new_reb = reb + 1;
                                player3reb.setText("" + new_reb);

                                home_player_list.get(3).setRebounds(home_player_list.get(3).getRebounds() + 1);

                                // handle animation
                                left_player4.setVisibility(View.INVISIBLE);
                                left_player_plus_blue4.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_blue4.setAnimation(zoom_in);
                                left_player_plus_blue4.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_blue4.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_blue4.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_blue4.setVisibility(View.INVISIBLE);
                                                left_player4.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 3's assists
                            else if (stat_index == 7) {
                                String temp = player3ast.getText().toString();
                                int ast = Integer.parseInt(temp);
                                int new_ast = ast + 1;
                                player3ast.setText("" + new_ast);

                                home_player_list.get(3).setAssists(home_player_list.get(3).getAssists() + 1);

                                // handle animation
                                left_player4.setVisibility(View.INVISIBLE);
                                left_player_plus_blue4.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_blue4.setAnimation(zoom_in);
                                left_player_plus_blue4.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_blue4.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_blue4.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_blue4.setVisibility(View.INVISIBLE);
                                                left_player4.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 3's steals
                            else if (stat_index == 8) {
                                home_player_list.get(3).setSteals(home_player_list.get(3).getSteals() + 1);

                                // handle animation
                                left_player4.setVisibility(View.INVISIBLE);
                                left_player_plus_blue4.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_blue4.setAnimation(zoom_in);
                                left_player_plus_blue4.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_blue4.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_blue4.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_blue4.setVisibility(View.INVISIBLE);
                                                left_player4.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 3's blocks
                            else if (stat_index == 9) {
                                home_player_list.get(3).setBlocks(home_player_list.get(3).getBlocks() + 1);

                                // handle animation
                                left_player4.setVisibility(View.INVISIBLE);
                                left_player_plus_blue4.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_blue4.setAnimation(zoom_in);
                                left_player_plus_blue4.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_blue4.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_blue4.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_blue4.setVisibility(View.INVISIBLE);
                                                left_player4.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }
                            // update home player 3's fouls
                            else if (stat_index == 10) {
                                home_player_list.get(3).setFouls(home_player_list.get(3).getFouls() + 1);

                                // handle animation
                                left_player4.setVisibility(View.INVISIBLE);
                                left_player_plus_blue4.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_blue4.setAnimation(zoom_in);
                                left_player_plus_blue4.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_blue4.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_blue4.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_blue4.setVisibility(View.INVISIBLE);
                                                left_player4.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 3's turnovers
                            else if (stat_index == 11) {
                                home_player_list.get(3).setTurnovers(home_player_list.get(3).getTurnovers() + 1);

                                // handle animation
                                left_player4.setVisibility(View.INVISIBLE);
                                left_player_plus_blue4.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_blue4.setAnimation(zoom_in);
                                left_player_plus_blue4.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_blue4.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_blue4.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_blue4.setVisibility(View.INVISIBLE);
                                                left_player4.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            break;


                        // home player 4
                        case 4:
                            // update home player 4's fg made and points
                            if (stat_index == 0) {
                                String temp = player4pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 2;
                                player4pts.setText("" + new_pts);
                                home_score += 2;

                                // update game score
                                score.setText("" + home_score + " - " + away_score);

                                home_player_list.get(4).setFg_made(home_player_list.get(4).getFg_made() + 1);
                                home_player_list.get(4).setPoints(home_player_list.get(4).getPoints() + 2);

                                // handle animation
                                left_player5.setVisibility(View.INVISIBLE);
                                left_player_plus_green5.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_green5.setAnimation(zoom_in);
                                left_player_plus_green5.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_green5.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_green5.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_green5.setVisibility(View.INVISIBLE);
                                                left_player5.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);

                            }

                            // update home player 4's three point made and points
                            else if (stat_index == 1) {
                                String temp = player4pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 3;
                                player4pts.setText("" + new_pts);

                                // update game score
                                home_score += 3;
                                score.setText("" + home_score + " - " + away_score);

                                home_player_list.get(4).setThree_made(home_player_list.get(4).getThree_made() + 1);
                                home_player_list.get(4).setPoints(home_player_list.get(4).getPoints() + 3);
                                home_player_list.get(4).setFg_made(home_player_list.get(4).getFg_made() + 1);

                                // handle animation
                                left_player5.setVisibility(View.INVISIBLE);
                                left_player_plus_green5.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_green5.setAnimation(zoom_in);
                                left_player_plus_green5.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_green5.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_green5.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_green5.setVisibility(View.INVISIBLE);
                                                left_player5.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 4's ft made and points
                            else if (stat_index == 2) {
                                String temp = player4pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 1;
                                player4pts.setText("" + new_pts);

                                // update game score
                                home_score += 1;
                                score.setText("" + home_score + " - " + away_score);

                                home_player_list.get(4).setFt_made(home_player_list.get(4).getFt_made() + 1);
                                home_player_list.get(4).setPoints(home_player_list.get(4).getPoints() + 1);

                                // handle animation
                                left_player5.setVisibility(View.INVISIBLE);
                                left_player_plus_green5.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_green5.setAnimation(zoom_in);
                                left_player_plus_green5.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_green5.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_green5.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_green5.setVisibility(View.INVISIBLE);
                                                left_player5.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 4's fg misses
                            else if(stat_index == 3) {
                                home_player_list.get(4).setFg_miss(home_player_list.get(4).getFg_miss() + 1);
                                // handle animation
                                left_player5.setVisibility(View.INVISIBLE);
                                left_player_plus_red5.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_red5.setAnimation(zoom_in);
                                left_player_plus_red5.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_red5.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_red5.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_red5.setVisibility(View.INVISIBLE);
                                                left_player5.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 4's three point misses
                            else if (stat_index == 4) {
                                home_player_list.get(4).setFg_miss(home_player_list.get(4).getFg_miss() + 1);
                                home_player_list.get(4).setThree_miss(home_player_list.get(4).getThree_miss() + 1);
                                // handle animation
                                left_player5.setVisibility(View.INVISIBLE);
                                left_player_plus_red5.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_red5.setAnimation(zoom_in);
                                left_player_plus_red5.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_red5.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_red5.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_red5.setVisibility(View.INVISIBLE);
                                                left_player5.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 4's missed fts
                            else if (stat_index == 5) {
                                home_player_list.get(4).setFt_miss(home_player_list.get(4).getFt_miss() + 1);
                                // handle animation
                                left_player5.setVisibility(View.INVISIBLE);
                                left_player_plus_red5.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_red5.setAnimation(zoom_in);
                                left_player_plus_red5.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_red5.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_red5.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_red5.setVisibility(View.INVISIBLE);
                                                left_player5.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 4's rebounds
                            else if (stat_index == 6) {
                                String temp = player4reb.getText().toString();
                                int reb = Integer.parseInt(temp);
                                int new_reb = reb + 1;
                                player4reb.setText("" + new_reb);

                                home_player_list.get(4).setRebounds(home_player_list.get(4).getRebounds() + 1);

                                // handle animation
                                left_player5.setVisibility(View.INVISIBLE);
                                left_player_plus_blue5.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_blue5.setAnimation(zoom_in);
                                left_player_plus_blue5.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_blue5.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_blue5.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_blue5.setVisibility(View.INVISIBLE);
                                                left_player5.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 4's assists
                            else if (stat_index == 7) {
                                String temp = player4ast.getText().toString();
                                int ast = Integer.parseInt(temp);
                                int new_ast = ast + 1;
                                player4ast.setText("" + new_ast);

                                home_player_list.get(4).setAssists(home_player_list.get(4).getAssists() + 1);

                                // handle animation
                                left_player5.setVisibility(View.INVISIBLE);
                                left_player_plus_blue5.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_blue5.setAnimation(zoom_in);
                                left_player_plus_blue5.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_blue5.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_blue5.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_blue5.setVisibility(View.INVISIBLE);
                                                left_player5.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 4's steals
                            else if (stat_index == 8) {
                                home_player_list.get(4).setSteals(home_player_list.get(4).getSteals() + 1);

                                // handle animation
                                left_player5.setVisibility(View.INVISIBLE);
                                left_player_plus_blue5.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_blue5.setAnimation(zoom_in);
                                left_player_plus_blue5.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_blue5.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_blue5.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_blue5.setVisibility(View.INVISIBLE);
                                                left_player5.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 4's blocks
                            else if (stat_index == 9) {
                                home_player_list.get(4).setBlocks(home_player_list.get(4).getBlocks() + 1);

                                // handle animation
                                left_player5.setVisibility(View.INVISIBLE);
                                left_player_plus_blue5.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_blue5.setAnimation(zoom_in);
                                left_player_plus_blue5.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_blue5.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_blue5.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_blue5.setVisibility(View.INVISIBLE);
                                                left_player5.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }
                            // update home player 4's fouls
                            else if (stat_index == 10) {
                                home_player_list.get(4).setFouls(home_player_list.get(4).getFouls() + 1);

                                // handle animation
                                left_player5.setVisibility(View.INVISIBLE);
                                left_player_plus_blue5.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_blue5.setAnimation(zoom_in);
                                left_player_plus_blue5.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_blue5.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_blue5.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_blue5.setVisibility(View.INVISIBLE);
                                                left_player5.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 4's turnovers
                            else if (stat_index == 11) {
                                home_player_list.get(4).setTurnovers(home_player_list.get(4).getTurnovers() + 1);

                                // handle animation
                                left_player5.setVisibility(View.INVISIBLE);
                                left_player_plus_blue5.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                left_player_plus_blue5.setAnimation(zoom_in);
                                left_player_plus_blue5.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                left_player_plus_blue5.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        left_player_plus_blue5.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                left_player_plus_blue5.setVisibility(View.INVISIBLE);
                                                left_player5.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            break;

                        // right side / away team players


                        // player 5 (away player 1)
                        case 5:
                            // update home player 4's fg made and points
                            if (stat_index == 0) {
                                String temp = player5pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 2;
                                player5pts.setText("" + new_pts);
                                away_score += 2;

                                // update game score
                                score.setText("" + home_score + " - " + away_score);

                                away_player_list.get(0).setFg_made(away_player_list.get(0).getFg_made() + 1);
                                away_player_list.get(0).setPoints(away_player_list.get(0).getPoints() + 2);

                                // handle animation
                                right_player1.setVisibility(View.INVISIBLE);
                                right_player_plus_green1.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_green1.setAnimation(zoom_in);
                                right_player_plus_green1.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_green1.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_green1.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_green1.setVisibility(View.INVISIBLE);
                                                right_player1.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);

                            }

                            // update home player 5's three point made and points
                            else if (stat_index == 1) {
                                String temp = player5pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 3;
                                player5pts.setText("" + new_pts);

                                // update game score
                                away_score += 3;
                                score.setText("" + home_score + " - " + away_score);

                                away_player_list.get(0).setFg_made(away_player_list.get(0).getFg_made() + 1);
                                away_player_list.get(0).setThree_made(away_player_list.get(0).getThree_made() + 1);
                                away_player_list.get(0).setPoints(away_player_list.get(0).getPoints() + 3);

                                // handle animation
                                right_player1.setVisibility(View.INVISIBLE);
                                right_player_plus_green1.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_green1.setAnimation(zoom_in);
                                right_player_plus_green1.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_green1.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_green1.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_green1.setVisibility(View.INVISIBLE);
                                                right_player1.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 5's ft made and points
                            else if (stat_index == 2) {
                                String temp = player5pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 1;
                                player5pts.setText("" + new_pts);

                                // update game score
                                away_score += 1;
                                score.setText("" + home_score + " - " + away_score);

                                away_player_list.get(0).setFt_made(away_player_list.get(0).getFt_made() + 1);
                                away_player_list.get(0).setPoints(away_player_list.get(0).getPoints() + 1);

                                // handle animation
                                right_player1.setVisibility(View.INVISIBLE);
                                right_player_plus_green1.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_green1.setAnimation(zoom_in);
                                right_player_plus_green1.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_green1.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_green1.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_green1.setVisibility(View.INVISIBLE);
                                                right_player1.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 5's fg misses
                            else if(stat_index == 3) {
                                away_player_list.get(0).setFg_miss(away_player_list.get(0).getFg_miss() + 1);
                                // handle animation
                                right_player1.setVisibility(View.INVISIBLE);
                                right_player_plus_red1.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_red1.setAnimation(zoom_in);
                                right_player_plus_red1.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_red1.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_red1.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_red1.setVisibility(View.INVISIBLE);
                                                right_player1.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 5's three point misses
                            else if (stat_index == 4) {
                                away_player_list.get(0).setFg_miss(away_player_list.get(0).getFg_miss() + 1);
                                away_player_list.get(0).setThree_miss(away_player_list.get(0).getThree_miss() + 1);
                                // handle animation
                                right_player1.setVisibility(View.INVISIBLE);
                                right_player_plus_red1.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_red1.setAnimation(zoom_in);
                                right_player_plus_red1.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_red1.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_red1.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_red1.setVisibility(View.INVISIBLE);
                                                right_player1.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 5's missed fts
                            else if (stat_index == 5) {
                                away_player_list.get(0).setFt_miss(away_player_list.get(0).getFt_miss() + 1);
                                // handle animation
                                right_player1.setVisibility(View.INVISIBLE);
                                right_player_plus_red1.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_red1.setAnimation(zoom_in);
                                right_player_plus_red1.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_red1.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_red1.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_red1.setVisibility(View.INVISIBLE);
                                                right_player1.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 5's rebounds
                            else if (stat_index == 6) {
                                String temp = player5reb.getText().toString();
                                int reb = Integer.parseInt(temp);
                                int new_reb = reb + 1;
                                player5reb.setText("" + new_reb);

                                away_player_list.get(0).setRebounds(away_player_list.get(0).getRebounds() + 1);

                                // handle animation
                                right_player1.setVisibility(View.INVISIBLE);
                                right_player_plus_blue1.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_blue1.setAnimation(zoom_in);
                                right_player_plus_blue1.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_blue1.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_blue1.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_blue1.setVisibility(View.INVISIBLE);
                                                right_player1.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 5's assists
                            else if (stat_index == 7) {
                                String temp = player5ast.getText().toString();
                                int ast = Integer.parseInt(temp);
                                int new_ast = ast + 1;
                                player5ast.setText("" + new_ast);

                                away_player_list.get(0).setAssists(away_player_list.get(0).getAssists() + 1);

                                // handle animation
                                right_player1.setVisibility(View.INVISIBLE);
                                right_player_plus_blue1.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_blue1.setAnimation(zoom_in);
                                right_player_plus_blue1.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_blue1.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_blue1.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_blue1.setVisibility(View.INVISIBLE);
                                                right_player1.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 5's steals
                            else if (stat_index == 8) {
                                away_player_list.get(0).setSteals(away_player_list.get(0).getSteals() + 1);

                                // handle animation
                                right_player1.setVisibility(View.INVISIBLE);
                                right_player_plus_blue1.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_blue1.setAnimation(zoom_in);
                                right_player_plus_blue1.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_blue1.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_blue1.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_blue1.setVisibility(View.INVISIBLE);
                                                right_player1.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 5's blocks
                            else if (stat_index == 9) {
                                away_player_list.get(0).setBlocks(away_player_list.get(0).getBlocks() + 1);

                                // handle animation
                                right_player1.setVisibility(View.INVISIBLE);
                                right_player_plus_blue1.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_blue1.setAnimation(zoom_in);
                                right_player_plus_blue1.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_blue1.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_blue1.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_blue1.setVisibility(View.INVISIBLE);
                                                right_player1.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }
                            // update home player 5's fouls
                            else if (stat_index == 10) {
                                away_player_list.get(0).setFouls(away_player_list.get(0).getFouls() + 1);

                                // handle animation
                                right_player1.setVisibility(View.INVISIBLE);
                                right_player_plus_blue1.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_blue1.setAnimation(zoom_in);
                                right_player_plus_blue1.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_blue1.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_blue1.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_blue1.setVisibility(View.INVISIBLE);
                                                right_player1.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 5's turnovers
                            else if (stat_index == 11) {
                                away_player_list.get(0).setTurnovers(away_player_list.get(0).getTurnovers() + 1);

                                // handle animation
                                right_player1.setVisibility(View.INVISIBLE);
                                right_player_plus_blue1.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_blue1.setAnimation(zoom_in);
                                right_player_plus_blue1.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_blue1.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_blue1.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_blue1.setVisibility(View.INVISIBLE);
                                                right_player1.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            break;


                        // player 6 (away player 2)
                        case 6:
                            // update home player 6's fg made and points
                            if (stat_index == 0) {
                                String temp = player6pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 2;
                                player6pts.setText("" + new_pts);
                                away_score += 2;

                                // update game score
                                score.setText("" + home_score + " - " + away_score);

                                away_player_list.get(1).setFg_made(away_player_list.get(1).getFg_made() + 1);
                                away_player_list.get(1).setPoints(away_player_list.get(1).getPoints() + 2);

                                // handle animation
                                right_player2.setVisibility(View.INVISIBLE);
                                right_player_plus_green2.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_green2.setAnimation(zoom_in);
                                right_player_plus_green2.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_green2.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_green2.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_green2.setVisibility(View.INVISIBLE);
                                                right_player2.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);

                            }

                            // update home player 6's three point made and points
                            else if (stat_index == 1) {
                                String temp = player6pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 3;
                                player6pts.setText("" + new_pts);

                                // update game score
                                away_score += 3;
                                score.setText("" + home_score + " - " + away_score);

                                away_player_list.get(1).setFg_made(away_player_list.get(1).getFg_made() + 1);
                                away_player_list.get(1).setThree_made(away_player_list.get(1).getThree_made() + 1);
                                away_player_list.get(1).setPoints(away_player_list.get(1).getPoints() + 3);

                                // handle animation
                                right_player2.setVisibility(View.INVISIBLE);
                                right_player_plus_green2.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_green2.setAnimation(zoom_in);
                                right_player_plus_green2.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_green2.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_green2.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_green2.setVisibility(View.INVISIBLE);
                                                right_player2.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 6's ft made and points
                            else if (stat_index == 2) {
                                String temp = player6pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 1;
                                player6pts.setText("" + new_pts);

                                // update game score
                                away_score += 1;
                                score.setText("" + home_score + " - " + away_score);

                                away_player_list.get(1).setFt_made(away_player_list.get(1).getFt_made() + 1);
                                away_player_list.get(1).setPoints(away_player_list.get(1).getPoints() + 1);

                                // handle animation
                                right_player2.setVisibility(View.INVISIBLE);
                                right_player_plus_green2.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_green2.setAnimation(zoom_in);
                                right_player_plus_green2.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_green2.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_green2.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_green2.setVisibility(View.INVISIBLE);
                                                right_player2.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 6's fg misses
                            else if(stat_index == 3) {
                                away_player_list.get(1).setFg_miss(away_player_list.get(1).getFg_miss() + 1);
                                // handle animation
                                right_player2.setVisibility(View.INVISIBLE);
                                right_player_plus_red2.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_red2.setAnimation(zoom_in);
                                right_player_plus_red2.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_red2.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_red2.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_red2.setVisibility(View.INVISIBLE);
                                                right_player2.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 6's three point misses
                            else if (stat_index == 4) {
                                away_player_list.get(1).setFg_miss(away_player_list.get(1).getFg_miss() + 1);
                                away_player_list.get(1).setThree_miss(away_player_list.get(1).getThree_miss() + 1);
                                // handle animation
                                right_player2.setVisibility(View.INVISIBLE);
                                right_player_plus_red2.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_red2.setAnimation(zoom_in);
                                right_player_plus_red2.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_red2.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_red2.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_red2.setVisibility(View.INVISIBLE);
                                                right_player2.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 6's missed fts
                            else if (stat_index == 5) {
                                away_player_list.get(1).setFt_miss(away_player_list.get(1).getFt_miss() + 1);
                                // handle animation
                                right_player2.setVisibility(View.INVISIBLE);
                                right_player_plus_red2.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_red2.setAnimation(zoom_in);
                                right_player_plus_red2.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_red2.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_red2.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_red2.setVisibility(View.INVISIBLE);
                                                right_player2.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 6's rebounds
                            else if (stat_index == 6) {
                                String temp = player6reb.getText().toString();
                                int reb = Integer.parseInt(temp);
                                int new_reb = reb + 1;
                                player6reb.setText("" + new_reb);

                                away_player_list.get(1).setRebounds(away_player_list.get(1).getRebounds() + 1);

                                // handle animation
                                right_player2.setVisibility(View.INVISIBLE);
                                right_player_plus_blue2.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_blue2.setAnimation(zoom_in);
                                right_player_plus_blue2.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_blue2.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_blue2.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_blue2.setVisibility(View.INVISIBLE);
                                                right_player2.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 6's assists
                            else if (stat_index == 7) {
                                String temp = player6ast.getText().toString();
                                int ast = Integer.parseInt(temp);
                                int new_ast = ast + 1;
                                player6ast.setText("" + new_ast);

                                away_player_list.get(1).setAssists(away_player_list.get(1).getAssists() + 1);

                                // handle animation
                                right_player2.setVisibility(View.INVISIBLE);
                                right_player_plus_blue2.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_blue2.setAnimation(zoom_in);
                                right_player_plus_blue2.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_blue2.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_blue2.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_blue2.setVisibility(View.INVISIBLE);
                                                right_player2.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 6's steals
                            else if (stat_index == 8) {
                                away_player_list.get(1).setSteals(away_player_list.get(1).getSteals() + 1);

                                // handle animation
                                right_player2.setVisibility(View.INVISIBLE);
                                right_player_plus_blue2.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_blue2.setAnimation(zoom_in);
                                right_player_plus_blue2.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_blue2.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_blue2.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_blue2.setVisibility(View.INVISIBLE);
                                                right_player2.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 6's blocks
                            else if (stat_index == 9) {
                                away_player_list.get(1).setBlocks(away_player_list.get(1).getBlocks() + 1);

                                // handle animation
                                right_player2.setVisibility(View.INVISIBLE);
                                right_player_plus_blue2.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_blue2.setAnimation(zoom_in);
                                right_player_plus_blue2.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_blue2.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_blue2.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_blue2.setVisibility(View.INVISIBLE);
                                                right_player2.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }
                            // update home player 6's fouls
                            else if (stat_index == 10) {
                                away_player_list.get(1).setFouls(away_player_list.get(1).getFouls() + 1);

                                // handle animation
                                right_player2.setVisibility(View.INVISIBLE);
                                right_player_plus_blue2.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_blue2.setAnimation(zoom_in);
                                right_player_plus_blue2.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_blue2.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_blue2.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_blue2.setVisibility(View.INVISIBLE);
                                                right_player2.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 6's turnovers
                            else if (stat_index == 11) {
                                away_player_list.get(1).setTurnovers(away_player_list.get(1).getTurnovers() + 1);

                                // handle animation
                                right_player2.setVisibility(View.INVISIBLE);
                                right_player_plus_blue2.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_blue2.setAnimation(zoom_in);
                                right_player_plus_blue2.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_blue2.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_blue2.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_blue2.setVisibility(View.INVISIBLE);
                                                right_player2.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            break;


                        // player 7 (away player 3)
                        case 7:
                            // update home player 7's fg made and points
                            if (stat_index == 0) {
                                String temp = player7pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 2;
                                player7pts.setText("" + new_pts);
                                away_score += 2;

                                // update game score
                                score.setText("" + home_score + " - " + away_score);

                                away_player_list.get(2).setFg_made(away_player_list.get(2).getFg_made() + 1);
                                away_player_list.get(2).setPoints(away_player_list.get(2).getPoints() + 2);

                                // handle animation
                                right_player3.setVisibility(View.INVISIBLE);
                                right_player_plus_green3.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_green3.setAnimation(zoom_in);
                                right_player_plus_green3.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_green3.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_green3.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_green3.setVisibility(View.INVISIBLE);
                                                right_player3.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);

                            }

                            // update home player 7's three point made and points
                            else if (stat_index == 1) {
                                String temp = player7pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 3;
                                player7pts.setText("" + new_pts);

                                // update game score
                                away_score += 3;
                                score.setText("" + home_score + " - " + away_score);

                                away_player_list.get(2).setFg_made(away_player_list.get(2).getFg_made() + 1);
                                away_player_list.get(2).setThree_made(away_player_list.get(2).getThree_made() + 1);
                                away_player_list.get(2).setPoints(away_player_list.get(2).getPoints() + 3);

                                // handle animation
                                right_player3.setVisibility(View.INVISIBLE);
                                right_player_plus_green3.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_green3.setAnimation(zoom_in);
                                right_player_plus_green3.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_green3.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_green3.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_green3.setVisibility(View.INVISIBLE);
                                                right_player3.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 7's ft made and points
                            else if (stat_index == 2) {
                                String temp = player7pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 1;
                                player7pts.setText("" + new_pts);

                                // update game score
                                away_score += 1;
                                score.setText("" + home_score + " - " + away_score);

                                away_player_list.get(2).setFt_made(away_player_list.get(2).getFt_made() + 1);
                                away_player_list.get(2).setPoints(away_player_list.get(2).getPoints() + 1);

                                // handle animation
                                right_player3.setVisibility(View.INVISIBLE);
                                right_player_plus_green3.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_green3.setAnimation(zoom_in);
                                right_player_plus_green3.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_green3.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_green3.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_green3.setVisibility(View.INVISIBLE);
                                                right_player3.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 7's fg misses
                            else if(stat_index == 3) {
                                away_player_list.get(2).setFg_miss(away_player_list.get(2).getFg_miss() + 1);
                                // handle animation
                                right_player3.setVisibility(View.INVISIBLE);
                                right_player_plus_red3.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_red3.setAnimation(zoom_in);
                                right_player_plus_red3.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_red3.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_red3.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_red3.setVisibility(View.INVISIBLE);
                                                right_player3.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 7's three point misses
                            else if (stat_index == 4) {
                                away_player_list.get(2).setThree_miss(away_player_list.get(2).getThree_miss() + 1);
                                away_player_list.get(2).setFg_miss(away_player_list.get(2).getFg_miss() + 1);
                                // handle animation
                                right_player3.setVisibility(View.INVISIBLE);
                                right_player_plus_red3.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_red3.setAnimation(zoom_in);
                                right_player_plus_red3.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_red3.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_red3.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_red3.setVisibility(View.INVISIBLE);
                                                right_player3.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 7's missed fts
                            else if (stat_index == 5) {
                                away_player_list.get(2).setFt_miss(away_player_list.get(2).getFt_miss() + 1);
                                // handle animation
                                right_player3.setVisibility(View.INVISIBLE);
                                right_player_plus_red3.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_red3.setAnimation(zoom_in);
                                right_player_plus_red3.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_red3.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_red3.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_red3.setVisibility(View.INVISIBLE);
                                                right_player3.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 7's rebounds
                            else if (stat_index == 6) {
                                String temp = player7reb.getText().toString();
                                int reb = Integer.parseInt(temp);
                                int new_reb = reb + 1;
                                player7reb.setText("" + new_reb);

                                away_player_list.get(2).setRebounds(away_player_list.get(2).getRebounds() + 1);

                                // handle animation
                                right_player3.setVisibility(View.INVISIBLE);
                                right_player_plus_blue3.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_blue3.setAnimation(zoom_in);
                                right_player_plus_blue3.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_blue3.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_blue3.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_blue3.setVisibility(View.INVISIBLE);
                                                right_player3.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);

                            }

                            // update home player 7's assists
                            else if (stat_index == 7) {
                                String temp = player7ast.getText().toString();
                                int ast = Integer.parseInt(temp);
                                int new_ast = ast + 1;
                                player7ast.setText("" + new_ast);

                                away_player_list.get(2).setAssists(away_player_list.get(2).getAssists() + 1);

                                // handle animation
                                right_player3.setVisibility(View.INVISIBLE);
                                right_player_plus_blue3.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_blue3.setAnimation(zoom_in);
                                right_player_plus_blue3.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_blue3.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_blue3.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_blue3.setVisibility(View.INVISIBLE);
                                                right_player3.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 7's steals
                            else if (stat_index == 8) {
                                away_player_list.get(2).setSteals(away_player_list.get(2).getSteals() + 1);

                                // handle animation
                                right_player3.setVisibility(View.INVISIBLE);
                                right_player_plus_blue3.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_blue3.setAnimation(zoom_in);
                                right_player_plus_blue3.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_blue3.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_blue3.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_blue3.setVisibility(View.INVISIBLE);
                                                right_player3.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 7's blocks
                            else if (stat_index == 9) {
                                away_player_list.get(2).setBlocks(away_player_list.get(2).getBlocks() + 1);

                                // handle animation
                                right_player3.setVisibility(View.INVISIBLE);
                                right_player_plus_blue3.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_blue3.setAnimation(zoom_in);
                                right_player_plus_blue3.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_blue3.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_blue3.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_blue3.setVisibility(View.INVISIBLE);
                                                right_player3.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }
                            // update home player 7's fouls
                            else if (stat_index == 10) {
                                away_player_list.get(2).setFouls(away_player_list.get(2).getFouls() + 1);

                                // handle animation
                                right_player3.setVisibility(View.INVISIBLE);
                                right_player_plus_blue3.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_blue3.setAnimation(zoom_in);
                                right_player_plus_blue3.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_blue3.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_blue3.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_blue3.setVisibility(View.INVISIBLE);
                                                right_player3.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 7's turnovers
                            else if (stat_index == 11) {
                                away_player_list.get(2).setTurnovers(away_player_list.get(2).getTurnovers() + 1);

                                // handle animation
                                right_player3.setVisibility(View.INVISIBLE);
                                right_player_plus_blue3.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_blue3.setAnimation(zoom_in);
                                right_player_plus_blue3.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_blue3.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_blue3.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_blue3.setVisibility(View.INVISIBLE);
                                                right_player3.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            break;


                        // player 8 (away player 4)
                        case 8:
                            // update home player 8's fg made and points
                            if (stat_index == 0) {
                                String temp = player8pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 2;
                                player8pts.setText("" + new_pts);
                                away_score += 2;

                                // update game score
                                score.setText("" + home_score + " - " + away_score);

                                away_player_list.get(3).setFg_made(away_player_list.get(3).getFg_made() + 1);
                                away_player_list.get(3).setPoints(away_player_list.get(3).getPoints() + 2);

                                // handle animation
                                right_player4.setVisibility(View.INVISIBLE);
                                right_player_plus_green4.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_green4.setAnimation(zoom_in);
                                right_player_plus_green4.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_green4.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_green4.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_green4.setVisibility(View.INVISIBLE);
                                                right_player4.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);

                            }

                            // update home player 7's three point made and points
                            else if (stat_index == 1) {
                                String temp = player8pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 3;
                                player8pts.setText("" + new_pts);

                                // update game score
                                away_score += 3;
                                score.setText("" + home_score + " - " + away_score);

                                away_player_list.get(3).setThree_made(away_player_list.get(3).getThree_made() + 1);
                                away_player_list.get(3).setPoints(away_player_list.get(3).getPoints() + 3);
                                away_player_list.get(3).setFg_made(away_player_list.get(3).getFg_made() + 1);

                                // handle animation
                                right_player4.setVisibility(View.INVISIBLE);
                                right_player_plus_green4.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_green4.setAnimation(zoom_in);
                                right_player_plus_green4.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_green4.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_green4.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_green4.setVisibility(View.INVISIBLE);
                                                right_player4.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 8's ft made and points
                            else if (stat_index == 2) {
                                String temp = player8pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 1;
                                player8pts.setText("" + new_pts);

                                // update game score
                                away_score += 1;
                                score.setText("" + home_score + " - " + away_score);

                                away_player_list.get(3).setFt_made(away_player_list.get(3).getFt_made() + 1);
                                away_player_list.get(3).setPoints(away_player_list.get(3).getPoints() + 1);

                                // handle animation
                                right_player4.setVisibility(View.INVISIBLE);
                                right_player_plus_green4.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_green4.setAnimation(zoom_in);
                                right_player_plus_green4.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_green4.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_green4.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_green4.setVisibility(View.INVISIBLE);
                                                right_player4.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 8's fg misses
                            else if(stat_index == 3) {
                                away_player_list.get(3).setFg_miss(away_player_list.get(3).getFg_miss() + 1);
                                // handle animation
                                right_player4.setVisibility(View.INVISIBLE);
                                right_player_plus_red4.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_red4.setAnimation(zoom_in);
                                right_player_plus_red4.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_red4.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_red4.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_red4.setVisibility(View.INVISIBLE);
                                                right_player4.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 8's three point misses
                            else if (stat_index == 4) {
                                away_player_list.get(3).setFg_miss(away_player_list.get(3).getFg_miss() + 1);
                                away_player_list.get(3).setThree_miss(away_player_list.get(3).getThree_miss() + 1);
                                // handle animation
                                right_player4.setVisibility(View.INVISIBLE);
                                right_player_plus_red4.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_red4.setAnimation(zoom_in);
                                right_player_plus_red4.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_red4.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_red4.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_red4.setVisibility(View.INVISIBLE);
                                                right_player4.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 8's missed fts
                            else if (stat_index == 5) {
                                away_player_list.get(3).setFt_miss(away_player_list.get(3).getFt_miss() + 1);
                                // handle animation
                                right_player4.setVisibility(View.INVISIBLE);
                                right_player_plus_red4.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_red4.setAnimation(zoom_in);
                                right_player_plus_red4.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_red4.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_red4.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_red4.setVisibility(View.INVISIBLE);
                                                right_player4.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 8's rebounds
                            else if (stat_index == 6) {
                                String temp = player8reb.getText().toString();
                                int reb = Integer.parseInt(temp);
                                int new_reb = reb + 1;
                                player8reb.setText("" + new_reb);

                                away_player_list.get(3).setRebounds(away_player_list.get(3).getRebounds() + 1);

                                // handle animation
                                right_player4.setVisibility(View.INVISIBLE);
                                right_player_plus_blue4.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_blue4.setAnimation(zoom_in);
                                right_player_plus_blue4.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_blue4.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_blue4.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_blue4.setVisibility(View.INVISIBLE);
                                                right_player4.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 8's assists
                            else if (stat_index == 7) {
                                String temp = player8ast.getText().toString();
                                int ast = Integer.parseInt(temp);
                                int new_ast = ast + 1;
                                player8ast.setText("" + new_ast);

                                away_player_list.get(3).setAssists(away_player_list.get(3).getAssists() + 1);

                                // handle animation
                                right_player4.setVisibility(View.INVISIBLE);
                                right_player_plus_blue4.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_blue4.setAnimation(zoom_in);
                                right_player_plus_blue4.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_blue4.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_blue4.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_blue4.setVisibility(View.INVISIBLE);
                                                right_player4.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 8's steals
                            else if (stat_index == 8) {
                                away_player_list.get(3).setSteals(away_player_list.get(3).getSteals() + 1);

                                // handle animation
                                right_player4.setVisibility(View.INVISIBLE);
                                right_player_plus_blue4.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_blue4.setAnimation(zoom_in);
                                right_player_plus_blue4.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_blue4.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_blue4.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_blue4.setVisibility(View.INVISIBLE);
                                                right_player4.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 8's blocks
                            else if (stat_index == 9) {
                                away_player_list.get(3).setBlocks(away_player_list.get(3).getBlocks() + 1);

                                // handle animation
                                right_player4.setVisibility(View.INVISIBLE);
                                right_player_plus_blue4.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_blue4.setAnimation(zoom_in);
                                right_player_plus_blue4.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_blue4.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_blue4.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_blue4.setVisibility(View.INVISIBLE);
                                                right_player4.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }
                            // update home player 8's fouls
                            else if (stat_index == 10) {
                                away_player_list.get(3).setFouls(away_player_list.get(3).getFouls() + 1);

                                // handle animation
                                right_player4.setVisibility(View.INVISIBLE);
                                right_player_plus_blue4.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_blue4.setAnimation(zoom_in);
                                right_player_plus_blue4.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_blue4.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_blue4.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_blue4.setVisibility(View.INVISIBLE);
                                                right_player4.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 8's turnovers
                            else if (stat_index == 11) {
                                away_player_list.get(3).setTurnovers(away_player_list.get(3).getTurnovers() + 1);

                                // handle animation
                                right_player4.setVisibility(View.INVISIBLE);
                                right_player_plus_blue4.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_blue4.setAnimation(zoom_in);
                                right_player_plus_blue4.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_blue4.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_blue4.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_blue4.setVisibility(View.INVISIBLE);
                                                right_player4.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            break;


                        // player 9 (away player 5)

                        case 9:
                            // update home player 9's fg made and points
                            if (stat_index == 0) {
                                String temp = player9pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 2;
                                player9pts.setText("" + new_pts);
                                away_score += 2;

                                // update game score
                                score.setText("" + home_score + " - " + away_score);

                                away_player_list.get(4).setFg_made(away_player_list.get(4).getFg_made() + 1);
                                away_player_list.get(4).setPoints(away_player_list.get(4).getPoints() + 2);

                                // handle animation
                                right_player5.setVisibility(View.INVISIBLE);
                                right_player_plus_green5.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_green5.setAnimation(zoom_in);
                                right_player_plus_green5.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_green5.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_green5.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_green5.setVisibility(View.INVISIBLE);
                                                right_player5.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);

                            }

                            // update home player 7's three point made and points
                            else if (stat_index == 1) {
                                String temp = player9pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 3;
                                player9pts.setText("" + new_pts);

                                // update game score
                                away_score += 3;
                                score.setText("" + home_score + " - " + away_score);

                                away_player_list.get(4).setThree_made(away_player_list.get(4).getThree_made() + 1);
                                away_player_list.get(4).setPoints(away_player_list.get(4).getPoints() + 3);
                                away_player_list.get(4).setFg_made(away_player_list.get(4).getFg_made() + 1);

                                // update game score
                                score.setText("" + home_score + " - " + away_score);

                                away_player_list.get(4).setFg_made(away_player_list.get(4).getFg_made() + 1);
                                away_player_list.get(4).setPoints(away_player_list.get(4).getPoints() + 2);

                                // handle animation
                                right_player5.setVisibility(View.INVISIBLE);
                                right_player_plus_green5.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_green5.setAnimation(zoom_in);
                                right_player_plus_green5.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_green5.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_green5.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_green5.setVisibility(View.INVISIBLE);
                                                right_player5.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 9's ft made and points
                            else if (stat_index == 2) {
                                String temp = player9pts.getText().toString();
                                int pts = Integer.parseInt(temp);
                                int new_pts = pts + 1;
                                player9pts.setText("" + new_pts);

                                // update game score
                                away_score += 1;
                                score.setText("" + home_score + " - " + away_score);

                                away_player_list.get(4).setFt_made(away_player_list.get(4).getFt_made() + 1);
                                away_player_list.get(4).setPoints(away_player_list.get(4).getPoints() + 1);

                                // update game score
                                score.setText("" + home_score + " - " + away_score);

                                away_player_list.get(4).setFg_made(away_player_list.get(4).getFg_made() + 1);
                                away_player_list.get(4).setPoints(away_player_list.get(4).getPoints() + 2);

                                // handle animation
                                right_player5.setVisibility(View.INVISIBLE);
                                right_player_plus_green5.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_green5.setAnimation(zoom_in);
                                right_player_plus_green5.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_green5.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_green5.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_green5.setVisibility(View.INVISIBLE);
                                                right_player5.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 9's fg misses
                            else if(stat_index == 3) {
                                away_player_list.get(4).setFg_miss(away_player_list.get(4).getFg_miss() + 1);
                                // handle animation
                                right_player5.setVisibility(View.INVISIBLE);
                                right_player_plus_red5.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_red5.setAnimation(zoom_in);
                                right_player_plus_red5.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_red5.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_red5.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_red5.setVisibility(View.INVISIBLE);
                                                right_player5.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 9's three point misses
                            else if (stat_index == 4) {
                                away_player_list.get(4).setFg_miss(away_player_list.get(4).getFg_miss() + 1);
                                away_player_list.get(4).setThree_miss(away_player_list.get(4).getThree_miss() + 1);
                                // handle animation
                                right_player5.setVisibility(View.INVISIBLE);
                                right_player_plus_red5.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_red5.setAnimation(zoom_in);
                                right_player_plus_red5.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_red5.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_red5.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_red5.setVisibility(View.INVISIBLE);
                                                right_player5.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 9's missed fts
                            else if (stat_index == 5) {
                                away_player_list.get(4).setFt_miss(away_player_list.get(4).getFt_miss() + 1);
                                // handle animation
                                right_player5.setVisibility(View.INVISIBLE);
                                right_player_plus_red5.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_red5.setAnimation(zoom_in);
                                right_player_plus_red5.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_red5.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_red5.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_red5.setVisibility(View.INVISIBLE);
                                                right_player5.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);


                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 9's rebounds
                            else if (stat_index == 6) {
                                String temp = player9reb.getText().toString();
                                int reb = Integer.parseInt(temp);
                                int new_reb = reb + 1;
                                player9reb.setText("" + new_reb);

                                away_player_list.get(4).setRebounds(away_player_list.get(4).getRebounds() + 1);

                                // handle animation
                                right_player5.setVisibility(View.INVISIBLE);
                                right_player_plus_blue5.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_blue5.setAnimation(zoom_in);
                                right_player_plus_blue5.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_blue5.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_blue5.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_blue5.setVisibility(View.INVISIBLE);
                                                right_player5.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);

                            }

                            // update home player 9's assists
                            else if (stat_index == 7) {
                                String temp = player9ast.getText().toString();
                                int ast = Integer.parseInt(temp);
                                int new_ast = ast + 1;
                                player9ast.setText("" + new_ast);

                                away_player_list.get(4).setAssists(away_player_list.get(4).getAssists() + 1);

                                // handle animation
                                right_player5.setVisibility(View.INVISIBLE);
                                right_player_plus_blue5.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_blue5.setAnimation(zoom_in);
                                right_player_plus_blue5.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_blue5.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_blue5.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_blue5.setVisibility(View.INVISIBLE);
                                                right_player5.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 9's steals
                            else if (stat_index == 8) {
                                away_player_list.get(4).setSteals(away_player_list.get(4).getSteals() + 1);

                                // handle animation
                                right_player5.setVisibility(View.INVISIBLE);
                                right_player_plus_blue5.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_blue5.setAnimation(zoom_in);
                                right_player_plus_blue5.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_blue5.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_blue5.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_blue5.setVisibility(View.INVISIBLE);
                                                right_player5.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 9's blocks
                            else if (stat_index == 9) {
                                away_player_list.get(4).setBlocks(away_player_list.get(4).getBlocks() + 1);

                                // handle animation
                                right_player5.setVisibility(View.INVISIBLE);
                                right_player_plus_blue5.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_blue5.setAnimation(zoom_in);
                                right_player_plus_blue5.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_blue5.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_blue5.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_blue5.setVisibility(View.INVISIBLE);
                                                right_player5.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }
                            // update home player 9's fouls
                            else if (stat_index == 10) {
                                away_player_list.get(4).setFouls(away_player_list.get(4).getFouls() + 1);

                                // handle animation
                                right_player5.setVisibility(View.INVISIBLE);
                                right_player_plus_blue5.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_blue5.setAnimation(zoom_in);
                                right_player_plus_blue5.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_blue5.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_blue5.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_blue5.setVisibility(View.INVISIBLE);
                                                right_player5.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
                            }

                            // update home player 9's turnovers
                            else if (stat_index == 11) {
                                away_player_list.get(4).setTurnovers(away_player_list.get(4).getTurnovers() + 1);

                                // handle animation
                                right_player5.setVisibility(View.INVISIBLE);
                                right_player_plus_blue5.setVisibility(View.VISIBLE);

                                Animation zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                                final Animation zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.stat_zoom_out);
                                right_player_plus_blue5.setAnimation(zoom_in);
                                right_player_plus_blue5.setAnimation(zoom_out);
                                final int secondsDelayed = 1;
                                final int waitForAnimation = 1;
                                right_player_plus_blue5.startAnimation(zoom_in);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        right_player_plus_blue5.startAnimation(zoom_out);
                                        new Handler().postDelayed(new Runnable() {

                                            @Override
                                            public void run() {
                                                Log.d("ANIMATION", "Animation done!");
                                                right_player_plus_blue5.setVisibility(View.INVISIBLE);
                                                right_player5.setVisibility(View.VISIBLE);
                                                // final_view.setBackgroundDrawable(normalShape);
                                            }
                                        }, waitForAnimation * 220);

                                    }
                                }, secondsDelayed * 300);
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


    public ArrayList<Player> getHome_player_list() {
        return home_player_list;
    }

    public ArrayList<Player> getAway_player_list() {
        return away_player_list;
    }
    public void setHomePlayer_list(ArrayList<Player> p) {
        home_player_list = p;
    }

    public void setAwayPlayer_list(ArrayList<Player> p) {
        away_player_list = p;
    }

}
