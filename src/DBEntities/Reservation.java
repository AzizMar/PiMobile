/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBEntities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author azizx
 */
@Entity
@Table(name = "reservation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r")
    , @NamedQuery(name = "Reservation.findById", query = "SELECT r FROM Reservation r WHERE r.id = :id")
    , @NamedQuery(name = "Reservation.findByNbplaces", query = "SELECT r FROM Reservation r WHERE r.nbplaces = :nbplaces")
    , @NamedQuery(name = "Reservation.findByPrix", query = "SELECT r FROM Reservation r WHERE r.prix = :prix")
    , @NamedQuery(name = "Reservation.findByConfirme", query = "SELECT r FROM Reservation r WHERE r.confirme = :confirme")
    , @NamedQuery(name = "Reservation.findByDecline", query = "SELECT r FROM Reservation r WHERE r.decline = :decline")
    , @NamedQuery(name = "Reservation.findByDescription", query = "SELECT r FROM Reservation r WHERE r.description = :description")
    , @NamedQuery(name = "Reservation.findByDatereservation", query = "SELECT r FROM Reservation r WHERE r.datereservation = :datereservation")})
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nbplaces")
    private int nbplaces;
    @Basic(optional = false)
    @Column(name = "prix")
    private double prix;
    @Basic(optional = false)
    @Column(name = "confirme")
    private boolean confirme;
    @Basic(optional = false)
    @Column(name = "decline")
    private boolean decline;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "datereservation")
    @Temporal(TemporalType.DATE)
    private Date datereservation;
    @JoinColumn(name = "userid", referencedColumnName = "id")
    @ManyToOne
    private Utilisateur userid;
    @JoinColumn(name = "annonceid", referencedColumnName = "id")
    @ManyToOne
    private Annonce annonceid;

    public Reservation() {
    }

    public Reservation(Integer id) {
        this.id = id;
    }

    public Reservation(Integer id, int nbplaces, double prix, boolean confirme, boolean decline, Date datereservation) {
        this.id = id;
        this.nbplaces = nbplaces;
        this.prix = prix;
        this.confirme = confirme;
        this.decline = decline;
        this.datereservation = datereservation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNbplaces() {
        return nbplaces;
    }

    public void setNbplaces(int nbplaces) {
        this.nbplaces = nbplaces;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public boolean getConfirme() {
        return confirme;
    }

    public void setConfirme(boolean confirme) {
        this.confirme = confirme;
    }

    public boolean getDecline() {
        return decline;
    }

    public void setDecline(boolean decline) {
        this.decline = decline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatereservation() {
        return datereservation;
    }

    public void setDatereservation(Date datereservation) {
        this.datereservation = datereservation;
    }

    public Utilisateur getUserid() {
        return userid;
    }

    public void setUserid(Utilisateur userid) {
        this.userid = userid;
    }

    public Annonce getAnnonceid() {
        return annonceid;
    }

    public void setAnnonceid(Annonce annonceid) {
        this.annonceid = annonceid;
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
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBEntities.Reservation[ id=" + id + " ]";
    }
    
}
