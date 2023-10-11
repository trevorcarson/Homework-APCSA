public class Dog extends Pet{
   /*Dog inherits all attributes and methods of Pet*/
   boolean good;
   public Dog(String name, int age){
      super(name, age); //call superclass constructor
      this.good = true;
   }
   public String talk(){
      return "woof";
   }
   public void birthday(){
      this.age+=7;
   }
   public void praise(){
      this.good = true;
   }
   public void scold(){
      this.good = false;
   }
   
   /*Override methods you want to change*/
   
}