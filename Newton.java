public class Newton{
      public static double sqrt(double x, double left, double right, double err){
      /*Calculates the square root of x using Newton's Method (Bisection Search)
      Inputs:
         double x: the num. whose sqrt you want
         double left: initial left bracket, left * left < x
         double right: initial right bracket, right * right > x
         double err: the max. error on the answer
      Outputs:
         return: the approx. sqrt(x)
      Ex.
      sqrt(18, 4, 5, 0.1)   -> 4.21875
      sqrt(18, 4, 5, 0.01)  -> 4.24609375
      sqrt(18, 4, 5, 0.001) -> 4.24267578125
      */
      if(x < 0){
         throw new IllegalArgumentException("x must be > 0");
      }
      double middle = 0;
      while(Math.abs(right) - Math.abs(left) > err){
         middle = (right+left)/2;
         if((middle*middle)>Math.abs(x)){
            right = middle;
            sqrt(x,left,middle,err);
         }
         if((middle*middle)<x){
            left = middle;
            sqrt(x,middle,right,err);
         }
      }
      middle = (left + right) /2;
      return middle;
   }
   public static double sqrt(double x, double err){
      /*Calculates the square root of x
      using Newton's Method (Bisection Search)
      Inputs:
         double x: the num. whose sqrt you want
         double err: the max. error on the answer
      Outputs:
         return: the approx. sqrt(x)
      Ex.
      sqrt(6.0, 0.001) -> 2.44970703125
      sqrt(4.0, 0.001) -> 2.0
      sqrt(1.0, 0.001) -> 1.0
      */
      //check if x is valid for sqrt()
      if(x < 0){
         throw new IllegalArgumentException("x must be > 0");
      }
      int lower = 0;
      int upper = x;
      return sqrt(x,lower,upper,err);
   }
   
}


   public void put(String key, Object value){
      /* If the key already exists in this dict, update the value. If the
      key is not already in this dict, make a new entry.
      Ex.
      SADict d = new SADict()
      s.put("c", 1)
      s.toString() -> {"c":1}
      s.put("c", 2)
      s.toString() -> {"c":2}
      s.put("a", -1)
      s.toString() -> {"a":-1, "c":2}
      s.put("a", 0)
      s.toString() -> {"a":0, "c":2}
      s.put("b", 3)
      s.toString() -> {"a":0, "b":3, "c":2}
      s.put("b", 1)
      s.toString() -> {"a":0, "b":1, "c":2}
      */
      if(this.size == this.storage.length){
         this.resize();
      }
      KVPair newKV = new KVPair(key, value);
      double a = search(key);
      if((a/.5)%2 == 0){
         this.storage[(int)a] = newKV;
      }
      else{
         for(int i = (int) a; i < this.size(); i++){
            this.size++;
            this.storage[i] = this.storage[i+1];
            this.storage[(int)a] = newKV;
         }
      }
   }
      