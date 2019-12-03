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
public class Temperature{

    int clientId;
    Double temp;
    String tempTaken;

    public Temperature(int id, Double temp, String tempTaken) {
       
        this.clientId = id;
        this.temp = temp;
        this.tempTaken = tempTaken;
    }

    

    public int getId() {
        return clientId;
    }

    public Double getTemp() {
        return temp;
    }

    public String getTempTaken() {
        return tempTaken;
    }

    
    

}
