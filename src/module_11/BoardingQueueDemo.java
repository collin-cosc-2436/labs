package module_11;

public class BoardingQueueDemo {

    public static void main(String[] args) {
        BoardingQueue boardingQueue = new BoardingQueue(10);
        boardingQueue.addPassenger(new Passenger("Joe", BoardingClass.ECONOMY_CLASS));
        boardingQueue.addPassenger(new Passenger("Do", BoardingClass.ECONOMY_CLASS));
        boardingQueue.addPassenger(new Passenger("Joe1", BoardingClass.ECONOMY_CLASS));
        boardingQueue.addPassenger(new Passenger("Joe2", BoardingClass.ECONOMY_CLASS));
        boardingQueue.addPassenger(new Passenger("Joe3", BoardingClass.ECONOMY_CLASS));
        boardingQueue.addPassenger(new Passenger("Joe4", BoardingClass.ECONOMY_CLASS));
        boardingQueue.addPassenger(new Passenger("Bob", BoardingClass.BUSINESS_CLASS));
        boardingQueue.addPassenger(new Passenger("Jane", BoardingClass.FIRST_CLASS));

        System.out.println("Passengers in Boarding queue:");
        while (!boardingQueue.isEmpty()) {
            System.out.println("Now boarding... " + boardingQueue.nextBoardingPassenger());
        }


    }
}
