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
public class Thread {
    
    public int  id,created_by_id;
    private String subject;

    public Thread(int id, int created_by_id, String subject) {
        this.id = id;
        this.created_by_id = created_by_id;
        this.subject = subject;
    }

    public Thread() {
    }

    
   
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreatedById() {
        return created_by_id;
    }

    public void setCreatedById(int createdById) {
        this.created_by_id = createdById;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    
    
    
    
    
    
    
}
