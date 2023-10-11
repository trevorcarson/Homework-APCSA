/*
Simulate a government vaccination campaign where people from different
groups (each with different priorities) sign up for vaccines every day.
Due to limited supplies, we always want to serve the highest prioirity
people in the queue first.
*/

public class VaccineCampaign{

   public static void main(String[] args){
      //store signups in a priority queue
      MaxPQ pq = new MaxPQ();
      
      int day = 0; //keep track of what day it is
      while(StdIn.isEmpty() != true){
         //read in the command token, either ADD or REM
         String command = StdIn.readString();
         
         if(command.equals("ADD")){
            //read in this person's data
            int priority = StdIn.readInt();
            String first = StdIn.readString();
            String last = StdIn.readString();
            String name = first + last;
            
            //add the data to the queue
            pq.add(priority, name);
         }
         
         else if(command.equals("REM")){
            day++; //we only do one remove per day
            
            //how many people should we remove
            int nRem = StdIn.readInt();
            
            //print out each person we remove
            StdOut.println("DAY "+day);
            if(nRem == 0){
               StdOut.println("\tNone");
            }
            for(int i = 0; i < nRem; i++){
               StdOut.println("\t" + pq.remove().toString());
            }
         }
      }
   }
}
   
      
      