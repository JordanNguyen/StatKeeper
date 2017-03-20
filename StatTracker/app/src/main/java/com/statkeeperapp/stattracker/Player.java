package com.statkeeperapp.stattracker;

import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by brand_000 on 3/19/2017.
 */
public class Player implements Serializable{

    String name, image_url;
    int fg_made, fg_miss, three_made, three_miss, ft_made, ft_miss, assists, rebounds, turnovers, fouls, steals, blocks, points;

    public Player(String n, String image) {
        name = n;
        image_url = image;
        fg_made = 0;
        fg_miss = 0;
        three_made = 0;
        three_miss = 0;
        ft_made = 0;
        ft_miss = 0;
        assists = 0;
        rebounds = 0;
        turnovers = 0;
        fouls = 0;
        steals = 0;
        blocks = 0;
        points = 0;
    }

    public int getAssists() {
        return assists;
    }

    public int getBlocks() {
        return blocks;
    }

    public int getFg_made() {
        return fg_made;
    }

    public int getFg_miss() {
        return fg_miss;
    }

    public int getFouls() {
        return fouls;
    }

    public int getFt_made() {
        return ft_made;
    }

    public int getFt_miss() {
        return ft_miss;
    }

    public int getPoints() {
        return points;
    }

    public int getRebounds() {
        return rebounds;
    }

    public int getSteals() {
        return steals;
    }

    public int getThree_made() {
        return three_made;
    }

    public int getThree_miss() {
        return three_miss;
    }

    public int getTurnovers() {
        return turnovers;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getName() {
        return name;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }

    public void setFg_made(int fg_made) {
        this.fg_made = fg_made;
    }

    public void setFg_miss(int fg_miss) {
        this.fg_miss = fg_miss;
    }

    public void setFouls(int fouls) {
        this.fouls = fouls;
    }

    public void setFt_made(int ft_make) {
        this.ft_made = ft_make;
    }

    public void setFt_miss(int ft_miss) {
        this.ft_miss = ft_miss;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setRebounds(int rebounds) {
        this.rebounds = rebounds;
    }

    public void setSteals(int steals) {
        this.steals = steals;
    }

    public void setThree_made(int three_make) {
        this.three_made = three_make;
    }

    public void setThree_miss(int three_miss) {
        this.three_miss = three_miss;
    }

    public void setTurnovers(int turnovers) {
        this.turnovers = turnovers;
    }
}
