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
public class Medicine {
    int clientId;
    int dose; //number of doses per day
    int frequency; //number of hours between each dose
    int duration; //how many days needed

    public Medicine(int id, int dose, int frequency, int duration) {
        this.clientId = id;
        this.dose = dose;
        this.frequency = frequency;
        this.duration = duration;
    }

    public int getDose() {
        return dose;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getDuration() {
        return duration;
    }

    public int numberOfMedsNeeded() {
        
        return 0;
    }

}
