/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBEntities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author azizx
 */
@Entity
@Table(name = "evaluation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluation.findAll", query = "SELECT e FROM Evaluation e")
    , @NamedQuery(name = "Evaluation.findById", query = "SELECT e FROM Evaluation e WHERE e.id = :id")
    , @NamedQuery(name = "Evaluation.findByNote", query = "SELECT e FROM Evaluation e WHERE e.note = :note")
    , @NamedQuery(name = "Evaluation.findByComment", query = "SELECT e FROM Evaluation e WHERE e.comment = :comment")
    , @NamedQuery(name = "Evaluation.findByPostedById", query = "SELECT e FROM Evaluation e WHERE e.postedById = :postedById")
    , @NamedQuery(name = "Evaluation.findByPostedToId", query = "SELECT e FROM Evaluation e WHERE e.postedToId = :postedToId")
    , @NamedQuery(name = "Evaluation.findByPostedAboutId", query = "SELECT e FROM Evaluation e WHERE e.postedAboutId = :postedAboutId")})
public class Evaluation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "note")
    private int note;
    @Basic(optional = false)
    @Column(name = "comment")
    private String comment;
    @Basic(optional = false)
    @Column(name = "posted_by_id")
    private int postedById;
    @Basic(optional = false)
    @Column(name = "posted_to_id")
    private int postedToId;
    @Basic(optional = false)
    @Column(name = "posted_about_id")
    private int postedAboutId;

    public Evaluation() {
    }

    public Evaluation(Integer id) {
        this.id = id;
    }

    public Evaluation(Integer id, int note, String comment, int postedById, int postedToId, int postedAboutId) {
        this.id = id;
        this.note = note;
        this.comment = comment;
        this.postedById = postedById;
        this.postedToId = postedToId;
        this.postedAboutId = postedAboutId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getPostedById() {
        return postedById;
    }

    public void setPostedById(int postedById) {
        this.postedById = postedById;
    }

    public int getPostedToId() {
        return postedToId;
    }

    public void setPostedToId(int postedToId) {
        this.postedToId = postedToId;
    }

    public int getPostedAboutId() {
        return postedAboutId;
    }

    public void setPostedAboutId(int postedAboutId) {
        this.postedAboutId = postedAboutId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluation)) {
            return false;
        }
        Evaluation other = (Evaluation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBEntities.Evaluation[ id=" + id + " ]";
    }
    
}
