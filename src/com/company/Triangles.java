package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Triangles {
    public static String lastInput="";
    public static String lastResult="";
    public String task(String input) {
        lastInput=input;
        try{
        String[] lines=input.strip().split("\n");
        ArrayList<Integer> list=new ArrayList<>();
        ArrayList<String> ints=new ArrayList<>();
        for(int i=0;i< lines.length;i++){String[] x=lines[i].split(" ");for (String str:x){ints.add(str);}}
        for (int i=0;i<ints.size()-1;i++){
            ints.get(i).strip();
            if(!ints.get(i).equals("")){
                if(Integer.parseInt(ints.get(i))<1 || Integer.parseInt(ints.get(i))>1000000000){throw new NumberFormatException();}
                else{
            list.add(Integer.parseInt(ints.get(i)));}}
        }
        ints.get(ints.size() - 1).strip();
        list.add(Integer.parseInt(ints.get(ints.size() - 1)));
        if(list.get(list.size()-1)!=0){throw new NumberFormatException();}
        list.remove(ints.size()-1);
            Collections.sort(list);
        String output="";
            Boolean gotNumbers=false;
            for(int i=0;i<list.size()-2;i++){
                if(list.get(i)+list.get(i+1)>list.get(i+2)){gotNumbers=true;output=list.get(i).toString()+" "+list.get(i+1).toString()+" "+list.get(i+2).toString();lastResult=output; break;}
            }
            if(!gotNumbers){lastResult="NIE";output="NIE";}
            System.out.println("end of script");
            System.out.println(output);
        return output;

        }
        catch(Exception e){e.printStackTrace();
            lastResult="Error";
        return "Invalid input";
        }

    }
    public void info(){
        System.out.println("Project v1.0\nTask: Triangles (IO)\nTask Overview: For a list of numbers from 1 to 1000000000, check if there is a set of three numbers that could satisfy the traingle condition, else print NIE");
    }
    public Triangles(){
        System.out.println("Triangles");
    }
}
