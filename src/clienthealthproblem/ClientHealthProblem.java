/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienthealthproblem;

import java.sql.*;
import java.util.*;

/**
 *
 * @author jzech
 */
public class ClientHealthProblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter Client ID: ");
        int clientId = userInput.nextInt();
        int tempId = clientId;
        int medId = clientId;
        System.out.println("Enter FirstName: ");
        String firstName = userInput.next();
        System.out.println("Enter LastName: ");
        String lastName = userInput.next();
        System.out.println("Enter Age: ");
        int age = userInput.nextInt();
        System.out.println("Enter temperature: ");
        double temp = userInput.nextDouble();
        System.out.println("Enter where temperature was taken: ");
        String tempPlace = userInput.next();
        System.out.println("Enter number of doses per day: ");
        int doses = userInput.nextInt();
        System.out.println("Enter number of hours between each dose: ");
        int frequency = userInput.nextInt();
        System.out.println("Number of days needed for medication: ");
        int duration = userInput.nextInt();

        Client client0 = createClient(clientId, firstName, lastName, age);
        Temperature temp0 = newTemp(tempId, temp, tempPlace);
        Medicine med0 = newMed(medId, doses, frequency, duration);
       
        
        String clientQuery = "insert into clients(clientId, firstName, lastName, age)" + "values (?,?,?,?)";
        
        String tempQuery = "insert into temperature(tempId, temp, tempTaken)" + "values (?,?,?)";
        
        String medQuery = "insert into medicine(medId, doses, frequency, dura)" + "values (?,?,?,?)";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orclpdb", "hr", "jordan");
            //Statement stmt = con.createStatement();
            
            PreparedStatement ps1 = con.prepareStatement(clientQuery);
            ps1.setInt(1, client0.clientId);
            ps1.setString(2, client0.firstName);
            ps1.setString(3, lastName);
            ps1.setInt(4, age);
            
            PreparedStatement ps2 = con.prepareStatement(tempQuery);
            ps2.setInt(1, client0.clientId);
            ps2.setDouble(2, temp);
            ps2.setString(3, tempPlace);
            
            PreparedStatement ps3 = con.prepareStatement(medQuery);
            ps3.setInt(1, client0.clientId);
            ps3.setInt(2, doses);
            ps3.setInt(3, frequency);
            ps3.setInt(4, duration);

            
            
           
            ps1.executeUpdate();
            ps2.executeUpdate();
            ps3.executeUpdate();
            
            con.close();
        } catch (Exception e) {
            System.out.println(e);

            //System.out.println(Client.numObjects);
            /*ArrayList<Temperature> tempArray = new ArrayList<>();
        tempArray.add(temp1);
        tempArray.add(temp2);
        tempArray.add(temp3);
        for (Temperature temp : tempArray) {
            System.out.println(temp.temp);
        }*/
        }

    }

    public static Client createClient(int id, String fName, String lName, int age) {
        Client newClient = new Client(id, fName, lName, age);
        return newClient;
    }

    public static Temperature newTemp(int id, Double temp, String tempTaken) {
        Temperature newTemp = new Temperature(id, temp, tempTaken);
        return newTemp;
    }

    public static Medicine newMed(int id, int dose, int freq, int dura) {
        Medicine newMedicine = new Medicine(id, dose, freq, dura);
        return newMedicine;
    }

}
