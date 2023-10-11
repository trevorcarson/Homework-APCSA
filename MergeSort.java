public class MergeSort{
     public static IntList merge(IntList sorted1, IntList sorted2){
      /*Merge two sorted lists into one new sorted list
      Input:
         IntList sorted1: an Intlist sorted in ascending order
         IntList sorted2: another sorted IntList
      Output:
         return: a new IntList containing all the entries in
                 sorted1 and sorted2, sorted in ascending order
      Side Effects: None, sorted1 and sorted2 are unchanged
      Ex.
      IntList list1 = new IntList();
      list1.add(1);
      list1.add(3);
      list1.add(5);
      IntList list2 = new IntList();
      list2.add(2);
      list2.add(4);
      list1.toString() -> [1, 3, 5]
      list2.toString() -> [2, 4]
      merge(list1, list2) -> [1, 2, 3, 4, 5]
      */
      IntList sorted = new IntList();
      int counter1 = 0;
      int counter2 = 0;
      while((counter1 < sorted1.size()) && (counter2 < sorted2.size())){
         if(sorted1.get(counter1) <= sorted2.get(counter2)){
            sorted.add(sorted1.get(counter1));
            counter1++; 
         }
         if(sorted1.get(counter1) >= sorted2.get(counter2)){
            sorted.add(sorted2.get(counter2));
            counter2++;
         }
      }
      for(int i = counter1; i < sorted1.size(); i++){
         sorted.add(sorted1.get(i));
      }
      for(int i = counter2; i < sorted2.size(); i++){
         sorted.add(sorted2.get(i));
      }
      return sorted;
   }
   public static IntList sort(IntList unsorted){
      /*Sort an unsorted list in ascending order
      Input:
         IntList unsorted: an unsorted IntList
      Output:
         return: a new IntList containing the same
                 values as unsorted, but sorted
      Side Effects: None, unsorted is unaffected
      Ex.
      IntList l = new IntList();
      l.add(5);
      l.add(1);
      l.add(4);
      l.add(2);
      l.add(3);
      l.toString() -> [5, 1, 4, 2, 3]
      sort(l) -> [1, 2, 3, 4, 5]
      */
      IntList left = new IntList();
      IntList right = new IntList();
      if(unsorted.size() >= 2){
         for(int i = 0; i < unsorted.size(); i++){
            if(i < unsorted.size()/2) left.add(unsorted.get(i));
            if(i >= unsorted.size()/2) right.add(unsorted.get(i));
            }
         IntList sortedLeft = sort(left);
         IntList sortedRight = sort(right);
         return merge(sortedLeft, sortedRight);
         }
      else{
         return unsorted;
      }
   }
}