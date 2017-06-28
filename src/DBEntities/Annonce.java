/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBEntities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author azizx
 */
@Entity
@Table(name = "annonce")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Annonce.findAll", query = "SELECT a FROM Annonce a")
    , @NamedQuery(name = "Annonce.findById", query = "SELECT a FROM Annonce a WHERE a.id = :id")
    , @NamedQuery(name = "Annonce.findByDepart", query = "SELECT a FROM Annonce a WHERE a.depart = :depart")
    , @NamedQuery(name = "Annonce.findByArrivee", query = "SELECT a FROM Annonce a WHERE a.arrivee = :arrivee")
    , @NamedQuery(name = "Annonce.findByHeuredepart", query = "SELECT a FROM Annonce a WHERE a.heuredepart = :heuredepart")
    , @NamedQuery(name = "Annonce.findByDate", query = "SELECT a FROM Annonce a WHERE a.date = :date")
    , @NamedQuery(name = "Annonce.findByNbplace", query = "SELECT a FROM Annonce a WHERE a.nbplace = :nbplace")
    , @NamedQuery(name = "Annonce.findByPrix", query = "SELECT a FROM Annonce a WHERE a.prix = :prix")
    , @NamedQuery(name = "Annonce.findByDisponible", query = "SELECT a FROM Annonce a WHERE a.disponible = :disponible")
    , @NamedQuery(name = "Annonce.findByBagages", query = "SELECT a FROM Annonce a WHERE a.bagages = :bagages")
    , @NamedQuery(name = "Annonce.findByAnimal", query = "SELECT a FROM Annonce a WHERE a.animal = :animal")
    , @NamedQuery(name = "Annonce.findByFumer", query = "SELECT a FROM Annonce a WHERE a.fumer = :fumer")
    , @NamedQuery(name = "Annonce.findByDescription", query = "SELECT a FROM Annonce a WHERE a.description = :description")})
public class Annonce implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "depart")
    private String depart;
    @Basic(optional = false)
    @Column(name = "arrivee")
    private String arrivee;
    @Column(name = "heuredepart")
    private String heuredepart;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "nbplace")
    private Integer nbplace;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prix")
    private Double prix;
    @Column(name = "disponible")
    private Boolean disponible;
    @Column(name = "bagages")
    private Boolean bagages;
    @Column(name = "animal")
    private Boolean animal;
    @Column(name = "fumer")
    private Boolean fumer;
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "voitureid", referencedColumnName = "id")
    @ManyToOne
    private Voiture voitureid;
    @JoinColumn(name = "userid", referencedColumnName = "id")
    @ManyToOne
    private Utilisateur userid;
    @OneToMany(mappedBy = "annonceid")
    private Collection<Reservation> reservationCollection;

    public Annonce() {
    }

    public Annonce(Integer id) {
        this.id = id;
    }

    public Annonce(Integer id, String depart, String arrivee) {
        this.id = id;
        this.depart = depart;
        this.arrivee = arrivee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getArrivee() {
        return arrivee;
    }

    public void setArrivee(String arrivee) {
        this.arrivee = arrivee;
    }

    public String getHeuredepart() {
        return heuredepart;
    }

    public void setHeuredepart(String heuredepart) {
        this.heuredepart = heuredepart;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getNbplace() {
        return nbplace;
    }

    public void setNbplace(Integer nbplace) {
        this.nbplace = nbplace;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Boolean getBagages() {
        return bagages;
    }

    public void setBagages(Boolean bagages) {
        this.bagages = bagages;
    }

    public Boolean getAnimal() {
        return animal;
    }

    public void setAnimal(Boolean animal) {
        this.animal = animal;
    }

    public Boolean getFumer() {
        return fumer;
    }

    public void setFumer(Boolean fumer) {
        this.fumer = fumer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Voiture getVoitureid() {
        return voitureid;
    }

    public void setVoitureid(Voiture voitureid) {
        this.voitureid = voitureid;
    }

    public Utilisateur getUserid() {
        return userid;
    }

    public void setUserid(Utilisateur userid) {
        this.userid = userid;
    }

    @XmlTransient
    public Collection<Reservation> getReservationCollection() {
        return reservationCollection;
    }

    public void setReservationCollection(Collection<Reservation> reservationCollection) {
        this.reservationCollection = reservationCollection;
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
        if (!(object instanceof Annonce)) {
            return false;
        }
        Annonce other = (Annonce) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBEntities.Annonce[ id=" + id + " ]";
    }
    
}
