/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author azizx
 */
public abstract class Utility {
    
    public static int loggedUserId;
    
    public static String getIdString (){
   return  ""+loggedUserId ;
    }

    @Override
    public String toString() {
        return  ""+loggedUserId ;
    }
    
   
}
