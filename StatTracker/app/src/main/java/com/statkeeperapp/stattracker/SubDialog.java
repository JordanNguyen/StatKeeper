package com.statkeeperapp.stattracker;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by brand_000 on 3/19/2017.
 */
public class SubDialog extends android.app.DialogFragment {


    public interface onAcceptButtonClickListener {
        void onAcceptButtonClick();
    }

    private onAcceptButtonClickListener listener;


    boolean isHighlighted1, isHighlighted2, isHighlighted3, isHighlighted4, isHighlighted5;
    boolean is_bench_selected1, is_bench_selected2, is_bench_selected3, is_bench_selected4, is_bench_selected5;

    int subout_counter, subin_counter;

    ArrayList<Player> player_list;
    TextView title, text_player1, text_player2, text_player3, text_player4, text_player5;
    ImageView image_player1, image_player2, image_player3, image_player4, image_player5;

    TextView button_next, button_cancel;

    RelativeLayout player1_card, player2_card, player3_card, player4_card, player5_card;

    String team_afiil;

    static SubDialog newInstance(ArrayList<Player> p, String team) {
        SubDialog d = new SubDialog();
        Bundle args = new Bundle();
        args.putSerializable("list", p);
        args.putString("team", team);
        d.setArguments(args);
        return d;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (onAcceptButtonClickListener) context;
        }
        catch (ClassCastException e) {
            throw  new ClassCastException(context.toString() + "must implement onAccept lsitener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        player_list = (ArrayList<Player>)getArguments().getSerializable("list");
        team_afiil = getArguments().getString("team");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_sub, container, false);

        title = (TextView)v.findViewById(R.id.sub_title_text);

        image_player1 = (ImageView)v.findViewById(R.id.sub_current_image1);
        image_player2 = (ImageView)v.findViewById(R.id.sub_current_image2);
        image_player3 = (ImageView)v.findViewById(R.id.sub_current_image3);
        image_player4 = (ImageView)v.findViewById(R.id.sub_current_image4);
        image_player5 = (ImageView)v.findViewById(R.id.sub_current_image5);

        text_player1 = (TextView)v.findViewById(R.id.sub_current_name1);
        text_player2 = (TextView)v.findViewById(R.id.sub_current_name2);
        text_player3 = (TextView)v.findViewById(R.id.sub_current_name3);
        text_player4 = (TextView)v.findViewById(R.id.sub_current_name4);
        text_player5 = (TextView)v.findViewById(R.id.sub_current_name5);

        button_next = (TextView)v.findViewById(R.id.sub_button_confirm);
        button_cancel = (TextView)v.findViewById(R.id.sub_button_cancel);

        player1_card = (RelativeLayout) v.findViewById(R.id.sub_player1_layout);
        player2_card = (RelativeLayout) v.findViewById(R.id.sub_player2_layout);
        player3_card = (RelativeLayout) v.findViewById(R.id.sub_player3_layout);
        player4_card = (RelativeLayout) v.findViewById(R.id.sub_player4_layout);
        player5_card = (RelativeLayout) v.findViewById(R.id.sub_player5_layout);

        currentLineup();
        return v;
    }

    public void currentLineup() {
        final Drawable highlightShape = getResources().getDrawable(R.drawable.substitute_highlight);
        final Drawable normalShape = getResources().getDrawable(R.drawable.shape_normal);
        final Drawable grey_button = getResources().getDrawable(R.drawable.sub_cancel_button);
        final Drawable green_button = getResources().getDrawable(R.drawable.rounded_make_button);

        subout_counter = 0;
        subin_counter = 0;
        isHighlighted1 = false;
        isHighlighted2 = false;
        isHighlighted3 = false;
        isHighlighted4 = false;
        isHighlighted5 = false;
        player1_card.setBackgroundDrawable(normalShape);
        player2_card.setBackgroundDrawable(normalShape);
        player3_card.setBackgroundDrawable(normalShape);
        player4_card.setBackgroundDrawable(normalShape);
        player5_card.setBackgroundDrawable(normalShape);
        
        title.setText("Select player(s) to sub out");

        Picasso.with(getActivity().getApplicationContext()).load(player_list.get(0).getImage_url()).transform(new CircleTransform()).into(image_player1);
        Picasso.with(getActivity().getApplicationContext()).load(player_list.get(1).getImage_url()).transform(new CircleTransform()).into(image_player2);
        Picasso.with(getActivity().getApplicationContext()).load(player_list.get(2).getImage_url()).transform(new CircleTransform()).into(image_player3);
        Picasso.with(getActivity().getApplicationContext()).load(player_list.get(3).getImage_url()).transform(new CircleTransform()).into(image_player4);
        Picasso.with(getActivity().getApplicationContext()).load(player_list.get(4).getImage_url()).transform(new CircleTransform()).into(image_player5);
        text_player1.setText(player_list.get(0).getName());
        text_player2.setText(player_list.get(1).getName());
        text_player3.setText(player_list.get(2).getName());
        text_player4.setText(player_list.get(3).getName());
        text_player5.setText(player_list.get(4).getName());

        button_cancel.setText("CANCEL");
        button_cancel.setBackgroundDrawable(grey_button);
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        button_next.setText("NEXT");
        button_next.setBackgroundDrawable(grey_button);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("DIALOG", "sub out number: " + subout_counter);
                showBench();
            }
        });
        button_next.setClickable(false);

        player1_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isHighlighted1) {
                    player1_card.setBackgroundDrawable(normalShape);
                    subout_counter -= 1;
                    isHighlighted1 = false;
                    Log.d("DIALOG", "de-hightlighting2");

                }
                else {
                    player1_card.setBackground(highlightShape);
                    subout_counter += 1;
                    isHighlighted1 = true;
                }

                if (subout_counter == 0) {
                    button_next.setClickable(false);
                    button_next.setBackgroundDrawable(grey_button);
                }
                else {
                    button_next.setClickable(true);
                    button_next.setBackgroundDrawable(green_button);
                }
            }
        });

        player2_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isHighlighted2) {
                    player2_card.setBackgroundDrawable(normalShape);
                    subout_counter -= 1;
                    isHighlighted2 = false;
                    Log.d("DIALOG", "de-hightlighting2");

                } else {
                    player2_card.setBackground(highlightShape);
                    subout_counter += 1;
                    isHighlighted2 = true;
                }
                if (subout_counter == 0) {
                    button_next.setClickable(false);
                    button_next.setBackgroundDrawable(grey_button);
                } else {
                    button_next.setClickable(true);
                    button_next.setBackgroundDrawable(green_button);
                }
            }
        });

        player3_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isHighlighted3) {
                    player3_card.setBackgroundDrawable(normalShape);
                    subout_counter -= 1;
                    isHighlighted3 = false;
                    Log.d("DIALOG", "de-hightlighting2");

                } else {
                    player3_card.setBackground(highlightShape);
                    subout_counter += 1;
                    isHighlighted3 = true;
                }
                if (subout_counter == 0) {
                    button_next.setClickable(false);
                    button_next.setBackgroundDrawable(grey_button);
                } else {
                    button_next.setClickable(true);
                    button_next.setBackgroundDrawable(green_button);
                }
            }
        });

        player4_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isHighlighted4) {
                    player4_card.setBackgroundDrawable(normalShape);
                    subout_counter -= 1;
                    isHighlighted4 = false;
                    Log.d("DIALOG", "de-hightlighting2");

                }
                else {
                    player4_card.setBackground(highlightShape);
                    subout_counter += 1;
                    isHighlighted4 = true;
                }
                if (subout_counter == 0) {
                    button_next.setClickable(false);
                    button_next.setBackgroundDrawable(grey_button);
                }
                else {
                    button_next.setClickable(true);
                    button_next.setBackgroundDrawable(green_button);
                }
            }
        });

        player5_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isHighlighted5) {
                    player5_card.setBackgroundDrawable(normalShape);
                    subout_counter -= 1;
                    isHighlighted5 = false;
                    Log.d("DIALOG", "de-");

                } else {
                    player5_card.setBackground(highlightShape);
                    subout_counter += 1;
                    isHighlighted5 = true;
                }
                if (subout_counter == 0) {
                    button_next.setClickable(false);
                    button_next.setBackgroundDrawable(grey_button);
                } else {
                    button_next.setClickable(true);
                    button_next.setBackgroundDrawable(green_button);
                }
            }
        });



    }


    public void showBench() {

        final Drawable highlightShape = getResources().getDrawable(R.drawable.substitute_highlight);
        final Drawable normalShape = getResources().getDrawable(R.drawable.shape_normal);
        final Drawable back_button = getResources().getDrawable(R.drawable.sub_back_button);
        final Drawable grey_button = getResources().getDrawable(R.drawable.sub_cancel_button);
        final Drawable green_button = getResources().getDrawable(R.drawable.rounded_make_button);

        title.setText("Select player(s) to sub in");
        player1_card.setBackgroundDrawable(normalShape);
        player2_card.setBackgroundDrawable(normalShape);
        player3_card.setBackgroundDrawable(normalShape);
        player4_card.setBackgroundDrawable(normalShape);
        player5_card.setBackgroundDrawable(normalShape);


       /* if (isHighlighted1) {
            subout_counter++;
        }
        if (isHighlighted2) {
            subout_counter++;
        }
        if (isHighlighted3) {
            subout_counter++;
        }
        if (isHighlighted4) {
            subout_counter++;
        }
        if (isHighlighted5) {
            subout_counter++;
        }*/

        Picasso.with(getActivity().getApplicationContext()).load(player_list.get(5).getImage_url()).transform(new CircleTransform()).into(image_player1);
        Picasso.with(getActivity().getApplicationContext()).load(player_list.get(6).getImage_url()).transform(new CircleTransform()).into(image_player2);
        Picasso.with(getActivity().getApplicationContext()).load(player_list.get(7).getImage_url()).transform(new CircleTransform()).into(image_player3);
        Picasso.with(getActivity().getApplicationContext()).load(player_list.get(8).getImage_url()).transform(new CircleTransform()).into(image_player4);
        Picasso.with(getActivity().getApplicationContext()).load(player_list.get(9).getImage_url()).transform(new CircleTransform()).into(image_player5);


        text_player1.setText(player_list.get(5).getName());
        text_player2.setText(player_list.get(6).getName());
        text_player3.setText(player_list.get(7).getName());
        text_player4.setText(player_list.get(8).getName());
        text_player5.setText(player_list.get(9).getName());

        button_cancel.setText("BACK");
        button_cancel.setBackgroundDrawable(back_button);
        button_next.setText("ACCEPT");
        button_next.setBackgroundDrawable(grey_button);
        button_next.setClickable(false);

        // now the accept button
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<Integer> swap_out = new ArrayList<Integer>();
                ArrayList<Integer> swap_in = new ArrayList<Integer>();

                if (isHighlighted1) swap_out.add(0);
                if (isHighlighted2) swap_out.add(1);
                if (isHighlighted3) swap_out.add(2);
                if (isHighlighted4) swap_out.add(3);
                if (isHighlighted5) swap_out.add(4);

                if (is_bench_selected1) swap_in.add(5);
                if (is_bench_selected2) swap_in.add(6);
                if (is_bench_selected3) swap_in.add(7);
                if (is_bench_selected4) swap_in.add(8);
                if (is_bench_selected5) swap_in.add(9);

                for (int i = 0; i < swap_out.size(); i++) {
                    Log.d("DIALOG", "swap out players: " + swap_out.get(i));
                }

                for (int i = 0; i < swap_in.size(); i++) {
                    Log.d("DIALOG", "swap in players: " + swap_in.get(i));
                }

                if (swap_in.size() != swap_out.size()) {
                    Log.d("ERROR", "ERROR! this should never happen");
                }

                ArrayList<Player> new_player_list = player_list;
                for (int j = 0; j < swap_in.size(); j++) {
                    Player swap_out_player = player_list.get(swap_out.get(j));
                    Log.d("SWAP", "swapped out player " + swap_out.get(j));
                    Log.d("SWAP", "swapped in player " + swap_in.get(j));
                    Player swap_in_player = player_list.get(swap_in.get(j));
                    new_player_list.set(swap_in.get(j), swap_out_player);
                    new_player_list.set(swap_out.get(j), swap_in_player);
                }

                if (team_afiil.equals("home")) {
                    ((MainActivity) getActivity()).setHomePlayer_list(new_player_list);
                } else {
                    ((MainActivity) getActivity()).setAwayPlayer_list(new_player_list);
                }
                listener.onAcceptButtonClick();
                dismiss();
            }
        });


        // now the back button
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentLineup();
            }
        });

        player1_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (subin_counter == subout_counter && is_bench_selected1) {
                    Log.d("DIALOG", "counters are equal and player is highlighted");
                    player1_card.setBackgroundDrawable(normalShape);
                    is_bench_selected1 = false;
                    subin_counter -= 1;
                    Log.d("DIALOG", "changing to grey!");
                    button_next.setBackgroundDrawable(grey_button);
                    button_next.setClickable(false);
                    return;
                } else if (subin_counter == subout_counter && !is_bench_selected1) {
                    return;
                }

                if (is_bench_selected1) {
                    player1_card.setBackgroundDrawable(normalShape);
                    is_bench_selected1 = false;
                    subin_counter -= 1;

                } else {
                    player1_card.setBackgroundDrawable(highlightShape);
                    is_bench_selected1 = true;
                    subin_counter += 1;
                }

                if (subin_counter == subout_counter) {
                    Log.d("DIALOG", "changing to green!");
                    button_next.setBackgroundDrawable(green_button);
                    button_next.setClickable(true);
                }

            }
        });
        player2_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (subin_counter == subout_counter && is_bench_selected2) {
                    Log.d("DIALOG", "counters are equal and player is highlighted");

                    player2_card.setBackgroundDrawable(normalShape);
                    is_bench_selected2 = false;
                    subin_counter -= 1;
                    Log.d("DIALOG", "changing to grey!");
                    button_next.setBackgroundDrawable(grey_button);
                    button_next.setClickable(false);
                    return;
                } else if (subin_counter == subout_counter && !is_bench_selected2) {
                    return;
                }

                if (is_bench_selected2) {
                    player2_card.setBackgroundDrawable(normalShape);
                    is_bench_selected2 = false;
                    subin_counter -= 1;

                } else {
                    player2_card.setBackgroundDrawable(highlightShape);
                    is_bench_selected2 = true;
                    subin_counter += 1;
                }

                if (subin_counter == subout_counter) {
                    Log.d("DIALOG", "changing to green!");
                    button_next.setBackgroundDrawable(green_button);
                    button_next.setClickable(true);
                }
            }
        });
        player3_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (subin_counter == subout_counter && is_bench_selected3) {
                    Log.d("DIALOG", "counters are equal and player is highlighted");

                    player3_card.setBackgroundDrawable(normalShape);
                    is_bench_selected3 = false;
                    subin_counter -= 1;
                    Log.d("DIALOG", "changing to grey!");
                    button_next.setBackgroundDrawable(grey_button);
                    button_next.setClickable(false);
                    return;
                } else if (subin_counter == subout_counter && !is_bench_selected3) {
                    return;
                }

                if (is_bench_selected3) {
                    player3_card.setBackgroundDrawable(normalShape);
                    is_bench_selected3 = false;
                    subin_counter -= 1;

                } else {
                    player3_card.setBackgroundDrawable(highlightShape);
                    is_bench_selected3 = true;
                    subin_counter += 1;
                }

                if (subin_counter == subout_counter) {
                    Log.d("DIALOG", "changing to green!");
                    button_next.setBackgroundDrawable(green_button);
                    button_next.setClickable(true);
                }

            }
        });
        player4_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (subin_counter == subout_counter && is_bench_selected4) {
                    Log.d("DIALOG", "counters are equal and player is highlighted");

                    player4_card.setBackgroundDrawable(normalShape);
                    is_bench_selected4 = false;
                    subin_counter -= 1;
                    Log.d("DIALOG", "changing to grey!");
                    button_next.setBackgroundDrawable(grey_button);
                    button_next.setClickable(false);
                    return;
                } else if (subin_counter == subout_counter && !is_bench_selected4) {
                    return;
                }

                if (is_bench_selected4) {
                    player4_card.setBackgroundDrawable(normalShape);
                    is_bench_selected4 = false;
                    subin_counter -= 1;

                } else {
                    player4_card.setBackgroundDrawable(highlightShape);
                    is_bench_selected4 = true;
                    subin_counter += 1;
                }

                if (subin_counter == subout_counter) {
                    Log.d("DIALOG", "changing to green!");
                    button_next.setBackgroundDrawable(green_button);
                    button_next.setClickable(true);
                }
            }
        });
        player5_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (subin_counter == subout_counter && is_bench_selected5) {
                    Log.d("DIALOG", "counters are equal and player is highlighted");
                    player5_card.setBackgroundDrawable(normalShape);
                    is_bench_selected5 = false;
                    subin_counter -= 1;
                    Log.d("DIALOG", "changing to grey!");
                    button_next.setBackgroundDrawable(grey_button);
                    button_next.setClickable(false);
                    return;
                } else if (subin_counter == subout_counter && !is_bench_selected5) {
                    return;
                }

                if (is_bench_selected5) {
                    player5_card.setBackgroundDrawable(normalShape);
                    is_bench_selected5 = false;
                    subin_counter -= 1;
                }
                else {
                    player5_card.setBackgroundDrawable(highlightShape);
                    is_bench_selected5 = true;
                    subin_counter += 1;
                }

                if (subin_counter == subout_counter) {
                    Log.d("DIALOG", "changing to green!");
                    button_next.setBackgroundDrawable(green_button);
                    button_next.setClickable(true);
                }
            }
        });




    }

}
