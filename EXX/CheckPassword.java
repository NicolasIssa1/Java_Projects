package EXX;

public class CheckPassword {
    public static boolean longEnough(String password) {
        if(password.length() >= 12)
        {
            return true;
        }
        else {
            return false;

        }
    }
  
    public static boolean atLeastTwoDigits(String password) {
        int digitCount = 0;
        for(int i = 0; i < password.length(); i++){
            if(Character.isDigit(password.charAt(i))){
                digitCount++;
                if(digitCount>=2){
                    System.out.println("Password is valid for digits");
                    return true;
                }
            }
        
        }
        return false;
        
    }
  
    public static void main(String[] args) {
        //Checking if at least one argument is provided. 
        if(args.length > 0){
            // args[0] is the first command line argument.
            String password = args[0];

            //we then pass the password to both mehtods in the class
            boolean isLongEnough = longEnough(password);
            boolean hasTwoDigits = atLeastTwoDigits(password);

            if(isLongEnough && hasTwoDigits){
                System.out.println("Final result : Password is valid");
            } 
            else
            {
                System.out.println("Final result : Password is invalid");
            }
        }
        else{
            System.out.println("No password provided ; please provide a password");
        }

    }
  }
