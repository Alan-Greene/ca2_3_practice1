package ca_practice;

public class Flight {
    Integer capacity;
    Double duration;
    Passenger[] passengers;
    int i = 0;

    public Flight(Integer capacity, Double duration){
        this.capacity = capacity;
        this.duration = duration;
        this.passengers = new Passenger[4];
    }

    public void fillList(Passenger passenger){
        passengers[i] = passenger;
        i++;
    }

    public void print(){
        System.out.printf("%-25s %-25s %-25s%n", "Name", "Age", "Baggage charge");
        for (Passenger passenger: passengers){
            System.out.printf("%-25s %-25d %-25.2f%n", passenger.getName(), passenger.getAge(), passenger.calcBaggageCharge());
        }
    }

    public int checkAvailability(){
        return capacity - passengers.length;
    }

    public String calcOldestPassenger(){
        int oldest = passengers[0].getAge();
        String oldest_name = passengers[0].getName();

        for (Passenger passenger: passengers){
            if (passenger.getAge() > oldest){
                oldest = passenger.getAge();
                oldest_name = passenger.getName();
            }
        }

        String oldest_age = Integer.toString(oldest);

        return oldest_name + " " + oldest_age;
    }

    public class Passenger{
        private String name;
        private Integer age;
        private Double[] weight_of_bags;
        private char[] size_of_bags;

        public Passenger(String name, Integer age, Double[] weight_of_bags, char[] size_of_bags){
            this.name = name;
            this.age = age;
            this.weight_of_bags = weight_of_bags;
            this.size_of_bags = size_of_bags;
        }

        public double calcBaggageCharge(){
            double baggage_charge = 0;

            for (Double weight : this.weight_of_bags) {
                if (weight <= 15) {
                    baggage_charge += 30;
                } else if (weight <= 20) {
                    baggage_charge += 40;
                } else {
                    double extra_charge = (weight - 20) * 10;
                    baggage_charge += 40 + extra_charge;
                }
            }

            return baggage_charge;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Double[] getWeight_of_bags() {
            return weight_of_bags;
        }

        public char[] getSize_of_bags() {
            return size_of_bags;
        }
    }
}
