/*
A class for representing a dictionary of key-value pairs.
Sort the KVPairs by key in the underlying storage for
faster look-up times through bisection search.
*/

public class SADict{
   private KVPair[] storage;  //an array to store key-value pairs
   private int size;          //the number of entries currently in the Dict
   
   private static int defaultCapacity = 10; 
   
   public SADict(){
      /*Constructor. Initialize a new empty Dictionary*/
      this.storage = new KVPair[defaultCapacity];
   }
   
   public int size(){
      /*Return the number of entries currently in this Dictionary*/
      return this.size;
   }
   
   private void resize(){
      /*Double the storage capacity of this dictionary.
      Copy over the existing contents.*/
      KVPair[] newStore = new KVPair[2*this.storage.length];
      for(int i = 0; i < this.size; i++){
         newStore[i] = this.storage[i];
      }
      this.storage = newStore;
   }
   
   public String toString(){
      /*Return a String representing the contents of this Dict*/
      String s = "{";
      for(int i = 0; i < this.size; i++){
         if(i != 0){
            s += ", ";
         }
         KVPair check = this.storage[i];
         s += check.toString();
      }
      return s += "}";
   }
   public double search(String key){
      /* Search through this dict for a matching key using binary search.
      If a match is found, return the index within the storage array of
      the match, but as a double (ex. if the index was 3, return 3.0). If
      no match is found, return the placement between indices where the
      new key should be inserted (ex. if it should go between 3 and 4,
      return 3.5). If the key is in the dict, the result will end in 0.0,
      otherwise it will end in 0.5
      Ex.
      SADict d = new SADict()
      d.search("a") -> -0.5 (since not in dict)
      
      d.put("a")
      d.search("a") -> 0.0  (since now in dict)
      
      d.search("c") -> 0.5  (above 0, but not in dict)
      d.put("c")
      d.search("c") -> 1.0  (now in dict)
      
      d.search("b") -> 0.5  (should go between 0 and 1)
      */
      int l = 0;
      int u = this.size();
      if(this.size() == 0) return -0.5;
      if(this.size() == 1){
         if(this.storage[l].getKey().equals(key)) return 0.0;
         if(this.storage[l].getKey().compareTo(key) > 0) return -.5;
         return 0.5;
      }
      if(this.storage[l].getKey().equals(key)) return l+.0;
      if(this.storage[u-1].getKey().equals(key)) return u-1.0;
      if(this.storage[l].getKey().compareTo(key) > 0) return -0.5;
      if(this.storage[u-1].getKey().compareTo(key) < 0) return u-.5;
      String middle = "";
      double m = 0;
      while(u > l + 1){
         m = (u+l)/2;
         middle = this.storage[(int)m].getKey();
         if(middle.equals(key)) break;
         if(middle.compareTo(key) > 0){
            u = (int)m;
         }
         if(middle.compareTo(key) < 0){
            l = (int)m;
         }
      }
      if(middle.equals(key)) return m;
      if(this.storage[l].getKey().compareTo(key) < 0){
         if(this.storage[u].getKey().compareTo(key) > 0){
            return l+.5;
         }
         return l-.5;
      }
      return u+.5;
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
      KVPair newKV = new KVPair(key, value);
      double a = this.search(key);
      if(a%1.0 == 0.0){
         this.storage[(int)a] = newKV;
      }
      else{
         if(this.size == this.storage.length){
            this.resize();
         }
         this.storage[this.size] = newKV;
         this.size++;
      }
   }
   public Object get(String key){
      double a = this.search(key);
      if(a % 1.0 == 0.0){
         return this.storage[(int)a].getValue();
      }
      else return null;
   }
   public void delete(String key){
      /* Delete the matching key-value pair from this dict. If the key
      is not in this dict, do nothing.
      Ex.
      SADict d = new SADict()
      d.put("a", 0)
      d.put("b", 1)
      d.put("c", 2)
      d.put("d", 3)
      d.toString() -> {"a":0, "b":1, "c":2, "d":3}
      
      d.delete("c")
      d.toString() -> {"a":0, "b":1, "d":3}
   
      d.delete("b")
      d.toString() -> {"a":0, "d":3}
      
      d.delete("b")
      d.toString() -> {"a":0, "d":3}
   
      d.delete("d")
      d.toString() -> {"a": 0}
   
      d.delete("a")
      d.toString() -> {}
   
      d.delete("a")
      d.toString() -> {}
      */
      double a = this.search(key);
      if(a % 1.0 == 0.0){
         for(int i = (int) a; i < this.size()-1; i++){
            this.storage[i] = this.storage[i+1];
         }
         this.size--;
      }
   }
}
         
      
            
            
      
      