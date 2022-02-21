package domain;

public class CoffeeMachine {

    private double volumeForCoffee;
    private double volumeForWater;
    private double volumeForMilk;
    private boolean power;

    public CoffeeMachine(int quantityCoffee, int quantityWater, int quantityMilk) {
        this.volumeForCoffee = quantityCoffee;
        this.volumeForWater = quantityWater;
        this.volumeForMilk = quantityMilk;
        this.power = true;
    }

    public void addWater(String quantity) throws NumberFormatException {
        int temp = Integer.parseInt(quantity);
        if (temp > 0) {
            this.volumeForWater = this.volumeForWater + temp;
            this.showResources();
        } else{
            this.showErrorMassage();
        }
    }

    public void addCoffee(String quantity) throws NumberFormatException {
        int temp = Integer.parseInt(quantity);
        if (temp > 0) {
            this.volumeForCoffee = this.volumeForCoffee + temp;
            this.showResources();;
        } else {
            this.showErrorMassage();
        }
    }

    public void addMilk(String quantity) throws NumberFormatException {
        int temp = Integer.parseInt(quantity);
        if (temp > 0) {
            this.volumeForMilk = this.volumeForMilk + temp;
            this.showResources();
        } else {
            this.showErrorMassage();
        }
    }

    public void makeLatte(String volume) throws NumberFormatException {
        int temp = Integer.parseInt(volume);
        if (this.checkCoffee(temp * 0.1)) {
            return;
        }
        if (this.checkWater(temp * 0.3)) {
            return;
        }
        if (this.checkMilk(temp * 0.6)) {
            return;
        }
        if (Utils.checkValue(temp)) {
            this.volumeForCoffee = this.volumeForCoffee - temp * 0.1;
            this.volumeForWater = this.volumeForWater - temp * 0.3;
            this.volumeForMilk = this.volumeForMilk - temp * 0.6;
            this.showResources();
        } else {
            this.showErrorMassage();
        }
    }

    public void makeRistretto(String volume) throws NumberFormatException {
        int temp = Integer.parseInt(volume);
        if (this.checkCoffee(temp * 0.5)) {
            return;
        }
        if (this.checkWater(temp * 0.5)) {
            return;
        }
        if (Utils.checkValue(temp)) {
            this.volumeForCoffee = this.volumeForCoffee - temp * 0.5;
            this.volumeForWater = this.volumeForWater - temp * 0.5;
            this.showResources();
        } else {
            this.showErrorMassage();
        }
    }

    public void makeCappuccino(String volume) throws NumberFormatException {
        int temp = Integer.parseInt(volume);
        if (this.checkCoffee(temp * 0.15)) {
            return;
        }
        if (this.checkWater(temp * 0.4)) {
            return;
        }
        if (this.checkMilk(temp * 0.45)) {
            return;
        }
        if (Utils.checkValue(temp)) {
            this.volumeForCoffee = this.volumeForCoffee - temp * 0.15;
            this.volumeForWater = this.volumeForWater - temp * 0.4;
            this.volumeForMilk = this.volumeForMilk - temp * 0.45;
            this.showResources();
        } else {
            this.showErrorMassage();
        }
    }

    public void makeLungo(String volume) throws NumberFormatException {
        int temp = Integer.parseInt(volume);
        if (this.checkCoffee(temp * 0.15)) {
            return;
        }
        if (this.checkWater(temp * 0.85)) {
            return;
        }
        if (Utils.checkValue(temp)) {
            this.volumeForCoffee = this.volumeForCoffee - temp * 0.15;
            this.volumeForWater = this.volumeForWater - temp * 0.85;
            this.showResources();
        } else {
            this.showErrorMassage();
        }

    }

    public void makeEspresso(String volume) throws NumberFormatException{
        int temp = Integer.parseInt(volume);
        if (this.checkCoffee(temp * 0.3)) {
            return;
        }
        if (this.checkWater(temp * 0.7)) {
            return;
        }
        if (Utils.checkValue(temp)) {
            this.volumeForCoffee = this.volumeForCoffee - temp * 0.3;
            this.volumeForWater = this.volumeForWater - temp * 0.7;
            this.showResources();
        } else {
            this.showErrorMassage();
        }

    }

    public void turnOff(String s){
        if (s.equals("off")){
            System.out.println("Goodbye !");
            this.power = false;
        }
    }

    private boolean checkCoffee(double value){
        if (value > this.volumeForCoffee){
            System.out.println("Not enough coffee");
            this.showResources();
            return true;
        }
        return false;
    }

    private boolean checkWater(double value){
        if (value > this.volumeForWater){
            System.out.println("Not enough water");
            this.showResources();
            return true;
        }
        return false;
    }

    private boolean checkMilk(double value){
        if (value > this.volumeForMilk){
            System.out.println("Not enough milk");
            this.showResources();
            return true;
        }
        return false;
    }

    public void showErrorMassage(){
        System.out.println("--------------------------");
        System.out.println("You command is not correct");
        this.showCommands();
    }

    public boolean isPower() {
        return power;
    }

    private void showResources(){
        System.out.printf("%.2f ", volumeForCoffee);
        System.out.printf("%.2f ", volumeForWater);
        System.out.printf("%.2f ", volumeForMilk);
        System.out.println("\n--------------------------");
    }

    private void showCommands(){
        System.out.println("You can use:\n" +
                "water N\n" +
                "milk N\n" +
                "coffee N\n" +
                "where N > 0\n\n" +
                "latte N\n" +
                "ristretto N\n" +
                "cappuccino N\n" +
                "lungo N\n" +
                "espresso N\n" +
                "where N >= 10\n\n" +
                "turn off");
        System.out.println("--------------------------");
    }


}
