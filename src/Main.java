import java.util.Scanner;

public class Main {
    public static void main (String [] args){

        String input;
        if (args.length == 0){
            Scanner scan = new Scanner(System.in);
            input = scan.nextLine();

        }
        else {
            input = args[0];
        }

        if (isNumber(input)) {
            boolean isMagic = false;
            int n = 1;
            String multiplied = input;
            while (multiplied.length() == input.length()) {
                for (int i = 0; i < input.length(); i++) {
                    isMagic = false;
                    if (input.equals(multiplied)) {
                        isMagic = true;
                        break;
                    }
                    multiplied = shift(multiplied);
                }
                if (!isMagic && n <= 2) {
                    System.out.println("It's not magic :(");
                    break;
                }
                if (!isMagic && n > 2) {
                    System.out.println("It's magic!");
                    //System.out.println("successive multiples up to " + (n - 1));
                    break;
                }

                n += 1;
                multiplied = Integer.toString((Integer.parseInt(input)) * n);

            }
            if (isMagic && n>2){
                System.out.println("It's magic!");
                //System.out.println("successive multiples up to " + (n - 1));
            }
        } else {
            System.out.println("It's not magic :(");
        }
    }


    public static boolean isNumber (String in){
        try{
            Integer.parseInt(in);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }

    public static String shift (String in){
        char [] arr = new char [in.length()];
        arr[0] = in.charAt(in.length()-1);
        for (int i=0; i<in.length()-1; i++){
            arr[i+1] = in.charAt(i);
        }
        return String.valueOf(arr);
    }
}
