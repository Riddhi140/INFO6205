package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class UFClient {
     private static Random random = new Random();
     private static int connections = 0;
     /*
      Returns the # of connections made for input
      @param input is the integer representing number of objects
      */
     private static int count(int input){
         connections = 0;
         UF_HWQUPC uf_hwqupc = new UF_HWQUPC(input);
         while(uf_hwqupc.components()!=1){
             int p = random.nextInt(input);
             int q = random.nextInt(input);
             if(!uf_hwqupc.isConnected(p,q)){
                 uf_hwqupc.union(p,q);
                 connections++;
             }
         }
         return connections;
     }
    public static void main(String[] args) {
       for(int i=0; i<10; i++){
           int input = random.nextInt(100000);
           System.out.println("# of Objects: "+input+" ,# of Connections: "+ count(input));
       }
    }
}