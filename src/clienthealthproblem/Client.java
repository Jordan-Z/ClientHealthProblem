/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienthealthproblem;

/**
 *
 * @author jzech
 */
public class Client {

    public static int numObjects = 0;
    int clientId;
    String firstName;
    String lastName;
    int age;

    public Client(int id, String fName, String lName, int age) {
        Client.numObjects++;
        this.clientId = id;
        this.firstName = fName;
        this.lastName = lName;
        this.age = age;
        
    }

    public int getId() {
        return clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String printClientInfo() {
        return ("Client ID: "+ this.getId() +"\nFirst Name: "+ this.getFirstName()+
                "\nLast Name: "+ getLastName()+ "\nAge: " + this.getAge());
    }

}
