import java.util.ArrayList;

/* Inherit Building.java */
public class House extends Building{

  /* Setting up attributes needed */
  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;

  public House(String name, String address, int nFloors,boolean hasDiningRoom,boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String> ();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;

  }

  /* setting up accessors */
  /* check if the house has dining room */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /* overload hasDiningRoom() */
  public void hasDiningRoom(String type){
    System.out.println("please do not pass in String");
}

  /* get the number of residents */
  public int nResidents(){
    return this.residents.size();
  }

  /* overload nResidents() */
  public void nResidents(String message){
    System.out.println("You dont need to pass in anything, try this method again");
  }


  /* methods for move in and move out */
  public void moveIn(String name){
    this.residents.add(name);
  }

  public String moveOut(String name){
    if(this.residents.contains(name)){
      this.residents.remove(name);
      return name;
    } else{
      throw new RuntimeException("Unsuccessful attempt to remove resident");
    }
  }

  /* check does the house contain a certain resident */
  public boolean isResident(String person){
    return this.residents.contains(person);
  }

  public void showOptions() {
    System.out.println("Available options at " + this.name + 
    ":\n + isResident() \n + moveIn() \n + moveOut() + \n hasDiningRoom() + \n  nResidents() + \n goToFloor()");
  }

  public void goToFloor(int floorNum){
    if(hasElevator){
      System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    }else{
      int difference = Math.abs(floorNum - activeFloor);
      if(difference==1){
        System.out.println("Walking to #floor" + floorNum );
      }else{
        System.out.println(this.name + "does not have an elevator");
      }
    }

  }

  public static void main(String[] args) {
    new House();
  }

}