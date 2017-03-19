package com.statkeeperapp.stattracker;

import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        findViewById(R.id.two_point_make_text).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.two_point_miss_text).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.three_point_make_text).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.three_point_miss_text).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.ft_make_text).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.ft_miss_text).setOnTouchListener(new MyTouchListener());

        findViewById(R.id.rebound_text).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.assist_text).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.steal_text).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.block_text).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.foul_text).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.turnover_text).setOnTouchListener(new MyTouchListener());


        findViewById(R.id.left_card_player_top_left_layout).setOnDragListener(new MyDragListener());
        findViewById(R.id.left_card_player_top_center_layout).setOnDragListener(new MyDragListener());
        findViewById(R.id.left_card_player_top_right_layout).setOnDragListener(new MyDragListener());
        findViewById(R.id.left_card_player_bot_left_layout).setOnDragListener(new MyDragListener());
        findViewById(R.id.left_card_player_bot_right_layout).setOnDragListener(new MyDragListener());

        findViewById(R.id.right_card_player_top_left_layout).setOnDragListener(new MyDragListener());
        findViewById(R.id.right_card_player_top_center_layout).setOnDragListener(new MyDragListener());
        findViewById(R.id.right_card_player_top_right_layout).setOnDragListener(new MyDragListener());
        findViewById(R.id.right_card_player_bot_right_layout).setOnDragListener(new MyDragListener());
        findViewById(R.id.right_card_player_bot_left_layout).setOnDragListener(new MyDragListener());


        ImageView left_player1 = (ImageView) findViewById(R.id.left_image_player_top_left);
        Picasso.with(getApplicationContext()).load("http://forums.nba-live.com/dl_mod/thumbs/7467_4Pacific.png").transform(new CircleTransform()).into(left_player1);
        ImageView left_player2 = (ImageView) findViewById(R.id.left_image_player_top_center);
        Picasso.with(getApplicationContext()).load("http://forums.nba-live.com/dl_mod/thumbs/3638_MIA_James_LeBron.png").transform(new CircleTransform()).into(left_player2);
        ImageView left_player3 = (ImageView) findViewById(R.id.left_image_player_top_right);
        Picasso.with(getApplicationContext()).load("http://www.spotrac.com/blog/wp-content/uploads/2013/05/gs-curry.png").transform(new CircleTransform()).into(left_player3);
        ImageView left_player4 = (ImageView) findViewById(R.id.left_image_player_bot_left);
        Picasso.with(getApplicationContext()).load("http://a3.espncdn.com/combiner/i?img=%2Fi%2Fheadshots%2Fnba%2Fplayers%2Ffull%2F2384.png").transform(new CircleTransform()).into(left_player4);
        ImageView left_player5 = (ImageView) findViewById(R.id.left_image_player_bot_right);
        Picasso.with(getApplicationContext()).load("http://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/1722.png&w=350&h=254").transform(new CircleTransform()).into(left_player5);

        ImageView right_player1 = (ImageView) findViewById(R.id.right_image_player_top_left);
        Picasso.with(getApplicationContext()).load("http://www.ieeevr.org/2017/img/tobias-hollerer.jpg").transform(new CircleTransform()).into(right_player1);
        ImageView right_player2 = (ImageView) findViewById(R.id.right_image_player_top_center);
        Picasso.with(getApplicationContext()).load("https://www.cs.ucsb.edu/sites/cs.ucsb.edu/files/styles/portrait-full/public/images/graduate/dong_samuel.jpg?itok=cYWtYbj1&c=ed53ae072f9ae2aa1d80a0c1cab57b49").transform(new CircleTransform()).into(right_player2);
        ImageView right_player3 = (ImageView) findViewById(R.id.right_image_player_top_right);
        Picasso.with(getApplicationContext()).load("https://media.licdn.com/mpr/mpr/shrinknp_400_400/p/5/005/0a5/25f/14fcd8f.jpg").transform(new CircleTransform()).into(right_player3);
        ImageView right_player4 = (ImageView) findViewById(R.id.right_image_player_bot_left);
        Picasso.with(getApplicationContext()).load("https://www.cs.ucsb.edu/sites/cs.ucsb.edu/files/styles/portrait-full/public/faculty/images/matthew-turk_0.jpg?itok=Qu98srhX&c=d1bcd0f47e9a68775b3c5d6ad01ffaf8").transform(new CircleTransform()).into(right_player4);
        ImageView right_player5 = (ImageView) findViewById(R.id.right_image_player_bot_right);
        Picasso.with(getApplicationContext()).load("https://pbs.twimg.com/profile_images/73630820/HeadShot.jpg").transform(new CircleTransform()).into(right_player5);


    }



    private final class MyTouchListener implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(data, shadowBuilder, v, 0);
                v.setVisibility(View.VISIBLE);
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

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action  = event.getAction();
            
            switch (event.getAction()) {

                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing
                    Log.d("DRAG", "Drag started!");
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
                   // view.setVisibility(View.INVISIBLE);
                    v.setBackgroundDrawable(normalShape);
                    Log.d("DRAG", "Drag dropped!");
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
