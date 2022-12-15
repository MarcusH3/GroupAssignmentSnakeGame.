package main.java.se.nackademin.Geometry;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Colors {
    //    RGB CODES-> LIGHT,MID,DARK TONES: {L-R,L-G,L-B, M-R,M-G,M-B, D-R,D-G,D-B}
    int[] wineredmix = {230, 176, 170, 192, 57, 43, 146, 43, 33};
    int[] brightredmix = {245, 183, 177, 231, 76, 60, 176, 58, 46};
    int[] violetmix = {210, 180, 222, 142, 68, 173, 108, 52, 131};
    int[] oceanbluemix = {169, 204, 227, 41, 128, 185, 31, 97, 141};
    int[] skybluemix = {174, 214, 241, 52, 152, 219, 40, 116, 166};
    int[] mintgreenmix = {163, 228, 215, 26, 188, 156, 20, 143, 119};
    int[] forrestgreenmix = {169, 223, 191, 39, 174, 96, 30, 132, 73};
    int[] yellowmix = {249, 231, 159, 241, 196, 15, 183, 149, 11};
    int[] orangemix = {250, 215, 160, 243, 156, 18, 185, 119, 14};


    List<int[]> colormixList = new ArrayList<>();

    public Colors(){
        colormixList.add(wineredmix);
        colormixList.add(brightredmix);
        colormixList.add(violetmix);
        colormixList.add(oceanbluemix);
        colormixList.add(skybluemix);
        colormixList.add(mintgreenmix);
        colormixList.add(forrestgreenmix);
        colormixList.add(yellowmix);
        colormixList.add(orangemix);
        Collections.shuffle(colormixList);
    }

    public Color getLightColor() {
        int[] rgb = colormixList.get(0);
        return new Color(rgb[0], rgb[1], rgb[2]);
    }
    public Color getMidColor() {
        int[] rgb = colormixList.get(0);
        return new Color(rgb[3], rgb[4], rgb[5]);
    }
    public Color getDarkColor() {
        int[] rgb = colormixList.get(0);
        return new Color(rgb[6], rgb[7], rgb[8]);
    }



}