package com.example.mycards;

public class Constants {
    public static int SCREEN_WIDTH;
    public static int SCREEN_HEIGHT;

    public static int genericScale = 150;
    public static float cardWidth = genericScale*2.5f;
    public static float cardHeight = genericScale*3.5f;

    public static double[][] layoutX= new double[][]{{.5},{.5,.5},{.5,.5,.5},{.2,.8,.2,.8},{.2,.8,.2,.8,.5},
            {.2,.8,.2,.8,.2,.8},{.2,.8,.5,.2,.8,.2,.8},{.2,.8,.2,.8,.2,.8,.2,.8},{.2,.8,.5,.2,.8,.2,.8,.2,.8}
            ,{.2,.8,.5,.2,.8,.2,.8,.5,.2,.8}};
    public static double[][] layoutY= new double[][]{{.5},{.2,.8},{.2,.5,.8},{.2,.2,.8,.8},{.2,.2,.8,.8,.5},
            {.2,.2,.8,.8,.5,.5},{.2,.2,.4,.8,.8,.5,.5},{.2,.2,.4,.4,.6,.6,.8,.8},{.2,.2,.3,.4,.4,.6,.6,.8,.8}
            ,{.2,.2,.3,.4,.4,.6,.6,.7,.8,.8}};
}
