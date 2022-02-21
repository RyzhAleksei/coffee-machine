import domain.CoffeeMachine;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        CoffeeMachine coffeeMachine;
        try {
            int paramFirst = Integer.parseInt(args[0]);
            int paramSecond = Integer.parseInt(args[1]);
            int paramThird = Integer.parseInt(args[2]);
            if (paramFirst < 0 || paramSecond < 0 || paramThird < 0) {
                throw new Exception();
            }
            coffeeMachine = new CoffeeMachine(paramFirst, paramSecond, paramThird);
        } catch (Exception e) {
            System.out.println("You need write params: coffee, water, milk\n" +
                    "where all params >= 0.\n" +
                    "You can try again =)");
            return;
        }
        System.out.println("Hello, hot drink lover !");
        System.out.println("Coffee-Machine is turn on!");
        var scanner = new Scanner(System.in);
        while (coffeeMachine.isPower()){
            try {
                System.out.println("What do you want?");
                var enteredLine = scanner.nextLine().toLowerCase();
                String[] commandValues = enteredLine.split(" ", 2);
                switch (commandValues[0]){
                    case "water": {
                            coffeeMachine.addWater(commandValues[1]);
                        }
                        break;
                    case "milk": {
                            coffeeMachine.addMilk(commandValues[1]);
                        }
                        break;
                    case "coffee":{
                            coffeeMachine.addCoffee(commandValues[1]);
                        }
                        break;
                    case "latte": {
                            coffeeMachine.makeLatte(commandValues[1]);
                        }
                        break;
                    case "ristretto": {
                            coffeeMachine.makeRistretto(commandValues[1]);
                        }
                        break;
                    case "cappuccino":{
                            coffeeMachine.makeCappuccino(commandValues[1]);
                        }
                        break;
                    case "lungo": {
                            coffeeMachine.makeLungo(commandValues[1]);
                        }
                        break;
                    case "espresso": {
                            coffeeMachine.makeEspresso(commandValues[1]);
                        }
                        break;
                    case "turn": {
                        coffeeMachine.turnOff(commandValues[1]);
                        }
                        break;
                    default:
                        coffeeMachine.showErrorMassage();
                }

            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e){
                coffeeMachine.showErrorMassage();
            }
        }

    }
}
