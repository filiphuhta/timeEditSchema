/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.schemaprojekt_3.resources;

/**
 *
 * @author filiphuhta
 */
public class TimeEdit2{
    
     String id;
     String kurs;
     String typ;
     String datum;
     String starttid;
     String sluttid;
     String beskrivning;
    //List<TimeEdit2> timeedit;


    public String getKurs() {
        return kurs;
    }

    public void setKurs(String kurs) {
        this.kurs = kurs;
    }
    
    
    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getStarttid() {
        return starttid;
    }

    public void setStarttid(String starttid) {
        this.starttid = starttid;
    }

    public String getSluttid() {
        return sluttid;
    }

    public void setSluttid(String sluttid) {
        this.sluttid = sluttid;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getBeskrivning() {
        return beskrivning;
    }

    public void setBeskrivning(String beskrivning) {
        this.beskrivning = beskrivning;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
//    public void setTimeEdit(List<TimeEdit2> timeedit){
//        this.timeedit=timeedit;
//    
//    }
//    
//    public List getTimeEdit(){
//    return this.timeedit;
//    }
    

}