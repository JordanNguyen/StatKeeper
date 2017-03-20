package com.statkeeperapp.stattracker;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by brand_000 on 3/19/2017.
 */
public class DetailDialog extends DialogFragment {


    static String name, image_url;
    static int fg_made, fg_miss, three_made, three_miss, ft_made, ft_miss, points, assists, rebounds, steals, blocks, turnovers, fouls;

    static DetailDialog newInstance(Player p) {
        DetailDialog d = new DetailDialog();
        image_url = p.getImage_url();
        name = p.getName();
        fg_made = p.getFg_made();
        fg_miss = p.getFg_miss();
        three_made = p.getThree_made();
        three_miss = p.getThree_miss();
        ft_made = p.getFt_made();
        ft_miss = p.getFt_miss();
        points = p.getPoints();
        assists = p.getAssists();
        rebounds = p.getRebounds();
        steals = p.getSteals();
        blocks = p.getBlocks();
        turnovers = p.getTurnovers();
        fouls = p.getFouls();
        Bundle args = new Bundle();
        args.putString("image", image_url);
        args.putString("name", name);
        args.putInt("fg_made", fg_made);
        args.putInt("fg_miss", fg_miss);
        args.putInt("three_made", three_made);
        args.putInt("three_miss", three_miss);
        args.putInt("ft_made", ft_made);
        args.putInt("ft_miss", ft_miss);
        args.putInt("points", points);
        args.putInt("assists", assists);
        args.putInt("rebounds", rebounds);
        args.putInt("steals", steals);
        args.putInt("blocks", blocks);
        args.putInt("fouls", fouls);
        args.putInt("turnovers", turnovers);
        d.setArguments(args);

        return d;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        name = getArguments().getString("name");
        image_url = getArguments().getString("image");
        fg_made = getArguments().getInt("fg_made", 0);
        fg_miss = getArguments().getInt("fg_miss", 0);
        three_made = getArguments().getInt("three_made", 0);
        three_miss = getArguments().getInt("three_miss", 0);
        ft_made = getArguments().getInt("ft_made", 0);
        ft_miss = getArguments().getInt("ft_miss", 0);
        rebounds = getArguments().getInt("rebounds", 0);
        assists = getArguments().getInt("assists", 0);
        steals = getArguments().getInt("steals", 0);
        points = getArguments().getInt("points", 0);
        blocks = getArguments().getInt("blocks", 0);
        turnovers = getArguments().getInt("turnovers", 0);
        fouls = getArguments().getInt("fouls", 0);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_detail, container, false);
        //int width = getResources().getDimensionPixelSize(R.dimen.popup_width);
        //int height = getResources().getDimensionPixelSize(R.dimen.popup_height);
        //getDialog().getWindow().setLayout(width, height);

        TextView player_name = (TextView)v.findViewById(R.id.detail_player_name);
        player_name.setText(name);

        TextView fgs = (TextView)v.findViewById(R.id.detail_fgs);
        TextView fg_percent = (TextView)v.findViewById(R.id.detail_fg_percent);
        TextView threes = (TextView)v.findViewById(R.id.detail_three);
        TextView three_percent = (TextView)v.findViewById(R.id.detail_three_percent);
        TextView fts = (TextView)v.findViewById(R.id.detail_fts);
        TextView ft_percent = (TextView)v.findViewById(R.id.detail_ft_percent);
        TextView pts = (TextView)v.findViewById(R.id.detail_points);
        TextView fls = (TextView)v.findViewById(R.id.detail_fouls);
        TextView rebs = (TextView)v.findViewById(R.id.detail_rebounds);
        TextView asts = (TextView)v.findViewById(R.id.detail_assists);
        TextView stls = (TextView)v.findViewById(R.id.detail_steals);
        TextView blks = (TextView)v.findViewById(R.id.detail_blocks);
        TextView tos = (TextView)v.findViewById(R.id.detail_turnovers);


        // two point stuff
        int fg_total = fg_made + fg_miss;
        fgs.setText("" + fg_made + " / " + fg_total);
        if (fg_made == 0 && fg_total == 0) {
            fg_percent.setText("0.0");
        }
        else {
            float fg_perc = (float) fg_made / fg_total * 100;
            fg_percent.setText("" + String.format("%.1f", fg_perc));
        }

        // three point stuff
        int three_total = three_made + three_miss;
        threes.setText("" + three_made + " / " + three_total);
        if (three_made == 0 && three_total == 0) {
            three_percent.setText("0.0");
        }
        else {
            float three_perc = (float) three_made / three_total * 100;
            three_percent.setText("" + String.format("%.1f", three_perc));
        }

        // ft stuff
        int ft_total = ft_made + ft_miss;
        fts.setText("" + ft_made + " / " + ft_total);
        if (ft_made == 0 && ft_total == 0) {
            ft_percent.setText("0.0");
        }
        else {
            float ft_perc = (float) ft_made / ft_total * 100;
            ft_percent.setText("" + String.format("%.1f", ft_perc));
        }

        pts.setText("" + points);
        fls.setText("" + fouls);
        rebs.setText("" + rebounds);
        asts.setText("" +assists);
        stls.setText("" + steals);
        blks.setText("" + blocks);
        tos.setText("" + turnovers);


        ImageView player_pic = (ImageView)v.findViewById(R.id.detail_player_image);
        Picasso.with(getActivity().getApplicationContext()).load(image_url).transform(new CircleTransform()).into(player_pic);

        ImageView close = (ImageView)v.findViewById(R.id.detail_close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });


        return v;
    }

}
