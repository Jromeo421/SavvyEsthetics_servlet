
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JRome
 */
public class AppCalculator {
    
    public static void main(String[] args){
        
        try{
            Scanner userInput = new Scanner(System.in);
            Controller mathmatics = new Controller();
            Integer userInput1;
            Integer userInput2;
            Integer userInput3;
            
            String operator;
            
            System.out.println("Please Enter a number of your choice.");
            userInput1 = Integer.parseInt(userInput.nextLine());
            
            System.out.println("Please enter the type of mathmatics you want to do. (+,*,/,-)");
            operator = userInput.nextLine();
            
            System.out.println("Please Enter a number ");
            userInput2 = Integer.parseInt(userInput.nextLine());
            
            
        }
    
}
}
