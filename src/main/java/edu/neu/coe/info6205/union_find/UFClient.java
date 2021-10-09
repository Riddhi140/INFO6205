package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class UFClient {
     private static Random random = new Random();
     /*
      Returns the # of pairs generated to connect all nodes of input
      @param input is the integer representing number of objects
      */
     private static int count(int input){
         int pairs = 0;
         UF_HWQUPC uf_hwqupc = new UF_HWQUPC(input);
         while(uf_hwqupc.components()!=1){
             int p = random.nextInt(input);
             int q = random.nextInt(input);
             pairs++;
             if(!uf_hwqupc.isConnected(p,q)){
                 uf_hwqupc.union(p,q);
             }
         }
         return pairs;
     }
    public static void main(String[] args) {
       for(int i=0; i<20; i++){
           int input = random.nextInt(100000);
           System.out.println("# of Objects: "+ input + " ,# of Pairs generated: "+ count(input));
           System.out.println("Relationship: 0.5 * n log n :"+ Math.round(0.5*input*(Math.log(input)))*100/100);
           System.out.println("<------------------------------------------------------------->");
       }
    }
}