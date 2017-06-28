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
import javax.persistence.Lob;
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
@Table(name = "Voiture")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Voiture.findAll", query = "SELECT v FROM Voiture v")
    , @NamedQuery(name = "Voiture.findById", query = "SELECT v FROM Voiture v WHERE v.id = :id")
    , @NamedQuery(name = "Voiture.findByMatricule", query = "SELECT v FROM Voiture v WHERE v.matricule = :matricule")
    , @NamedQuery(name = "Voiture.findByModele", query = "SELECT v FROM Voiture v WHERE v.modele = :modele")
    , @NamedQuery(name = "Voiture.findByMarque", query = "SELECT v FROM Voiture v WHERE v.marque = :marque")
    , @NamedQuery(name = "Voiture.findByNombreplaces", query = "SELECT v FROM Voiture v WHERE v.nombreplaces = :nombreplaces")
    , @NamedQuery(name = "Voiture.findByPuissance", query = "SELECT v FROM Voiture v WHERE v.puissance = :puissance")
    , @NamedQuery(name = "Voiture.findByImageName", query = "SELECT v FROM Voiture v WHERE v.imageName = :imageName")
    , @NamedQuery(name = "Voiture.findByUpdatedAt", query = "SELECT v FROM Voiture v WHERE v.updatedAt = :updatedAt")
    , @NamedQuery(name = "Voiture.findByImageSize", query = "SELECT v FROM Voiture v WHERE v.imageSize = :imageSize")})
public class Voiture implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "matricule")
    private String matricule;
    @Basic(optional = false)
    @Column(name = "modele")
    private String modele;
    @Basic(optional = false)
    @Column(name = "marque")
    private String marque;
    @Basic(optional = false)
    @Column(name = "nombreplaces")
    private int nombreplaces;
    @Basic(optional = false)
    @Column(name = "puissance")
    private String puissance;
    @Lob
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "image_name")
    private String imageName;
    @Basic(optional = false)
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Basic(optional = false)
    @Column(name = "image_size")
    private int imageSize;
    @OneToMany(mappedBy = "voitureid")
    private Collection<Annonce> annonceCollection;
    @JoinColumn(name = "proprietaire_id", referencedColumnName = "id")
    @ManyToOne
    private Utilisateur proprietaireId;

    public Voiture() {
    }

    public Voiture(Integer id) {
        this.id = id;
    }

    public Voiture(Integer id, String matricule, String modele, String marque, int nombreplaces, String puissance, String imageName, Date updatedAt, int imageSize) {
        this.id = id;
        this.matricule = matricule;
        this.modele = modele;
        this.marque = marque;
        this.nombreplaces = nombreplaces;
        this.puissance = puissance;
        this.imageName = imageName;
        this.updatedAt = updatedAt;
        this.imageSize = imageSize;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getNombreplaces() {
        return nombreplaces;
    }

    public void setNombreplaces(int nombreplaces) {
        this.nombreplaces = nombreplaces;
    }

    public String getPuissance() {
        return puissance;
    }

    public void setPuissance(String puissance) {
        this.puissance = puissance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getImageSize() {
        return imageSize;
    }

    public void setImageSize(int imageSize) {
        this.imageSize = imageSize;
    }

    @XmlTransient
    public Collection<Annonce> getAnnonceCollection() {
        return annonceCollection;
    }

    public void setAnnonceCollection(Collection<Annonce> annonceCollection) {
        this.annonceCollection = annonceCollection;
    }

    public Utilisateur getProprietaireId() {
        return proprietaireId;
    }

    public void setProprietaireId(Utilisateur proprietaireId) {
        this.proprietaireId = proprietaireId;
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
        if (!(object instanceof Voiture)) {
            return false;
        }
        Voiture other = (Voiture) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBEntities.Voiture[ id=" + id + " ]";
    }
    
}
