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
import javax.persistence.Lob;
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
@Table(name = "utilisateur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u")
    , @NamedQuery(name = "Utilisateur.findById", query = "SELECT u FROM Utilisateur u WHERE u.id = :id")
    , @NamedQuery(name = "Utilisateur.findByUsername", query = "SELECT u FROM Utilisateur u WHERE u.username = :username")
    , @NamedQuery(name = "Utilisateur.findByUsernameCanonical", query = "SELECT u FROM Utilisateur u WHERE u.usernameCanonical = :usernameCanonical")
    , @NamedQuery(name = "Utilisateur.findByEmail", query = "SELECT u FROM Utilisateur u WHERE u.email = :email")
    , @NamedQuery(name = "Utilisateur.findByEmailCanonical", query = "SELECT u FROM Utilisateur u WHERE u.emailCanonical = :emailCanonical")
    , @NamedQuery(name = "Utilisateur.findByEnabled", query = "SELECT u FROM Utilisateur u WHERE u.enabled = :enabled")
    , @NamedQuery(name = "Utilisateur.findBySalt", query = "SELECT u FROM Utilisateur u WHERE u.salt = :salt")
    , @NamedQuery(name = "Utilisateur.findByPassword", query = "SELECT u FROM Utilisateur u WHERE u.password = :password")
    , @NamedQuery(name = "Utilisateur.findByLastLogin", query = "SELECT u FROM Utilisateur u WHERE u.lastLogin = :lastLogin")
    , @NamedQuery(name = "Utilisateur.findByConfirmationToken", query = "SELECT u FROM Utilisateur u WHERE u.confirmationToken = :confirmationToken")
    , @NamedQuery(name = "Utilisateur.findByPasswordRequestedAt", query = "SELECT u FROM Utilisateur u WHERE u.passwordRequestedAt = :passwordRequestedAt")
    , @NamedQuery(name = "Utilisateur.findByNom", query = "SELECT u FROM Utilisateur u WHERE u.nom = :nom")
    , @NamedQuery(name = "Utilisateur.findByPrenom", query = "SELECT u FROM Utilisateur u WHERE u.prenom = :prenom")
    , @NamedQuery(name = "Utilisateur.findBySolde", query = "SELECT u FROM Utilisateur u WHERE u.solde = :solde")
    , @NamedQuery(name = "Utilisateur.findByVille", query = "SELECT u FROM Utilisateur u WHERE u.ville = :ville")
    , @NamedQuery(name = "Utilisateur.findByImageProfil", query = "SELECT u FROM Utilisateur u WHERE u.imageProfil = :imageProfil")
    , @NamedQuery(name = "Utilisateur.findByTelephone", query = "SELECT u FROM Utilisateur u WHERE u.telephone = :telephone")})
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "username_canonical")
    private String usernameCanonical;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "email_canonical")
    private String emailCanonical;
    @Basic(optional = false)
    @Column(name = "enabled")
    private boolean enabled;
    @Column(name = "salt")
    private String salt;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Column(name = "last_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
    @Column(name = "confirmation_token")
    private String confirmationToken;
    @Column(name = "password_requested_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date passwordRequestedAt;
    @Basic(optional = false)
    @Lob
    @Column(name = "roles")
    private String roles;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @Column(name = "solde")
    private int solde;
    @Basic(optional = false)
    @Column(name = "ville")
    private String ville;
    @Basic(optional = false)
    @Column(name = "image_profil")
    private String imageProfil;
    @Basic(optional = false)
    @Column(name = "telephone")
    private int telephone;
    @OneToMany(mappedBy = "userid")
    private Collection<Annonce> annonceCollection;
    @OneToMany(mappedBy = "userid")
    private Collection<Reservation> reservationCollection;
    @OneToMany(mappedBy = "proprietaireId")
    private Collection<Voiture> voitureCollection;
    @OneToMany(mappedBy = "createdById")
    private Collection<Thread> threadCollection;
    @OneToMany(mappedBy = "participantId")
    private Collection<ThreadMetadata> threadMetadataCollection;
    @OneToMany(mappedBy = "senderId")
    private Collection<Message> messageCollection;
    @OneToMany(mappedBy = "participantId")
    private Collection<MessageMetadata> messageMetadataCollection;

    public Utilisateur() {
    }

    public Utilisateur(Integer id) {
        this.id = id;
    }

    public Utilisateur(Integer id, String username, String usernameCanonical, String email, String emailCanonical, boolean enabled, String password, String roles, String nom, String prenom, int solde, String ville, String imageProfil, int telephone) {
        this.id = id;
        this.username = username;
        this.usernameCanonical = usernameCanonical;
        this.email = email;
        this.emailCanonical = emailCanonical;
        this.enabled = enabled;
        this.password = password;
        this.roles = roles;
        this.nom = nom;
        this.prenom = prenom;
        this.solde = solde;
        this.ville = ville;
        this.imageProfil = imageProfil;
        this.telephone = telephone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsernameCanonical() {
        return usernameCanonical;
    }

    public void setUsernameCanonical(String usernameCanonical) {
        this.usernameCanonical = usernameCanonical;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailCanonical() {
        return emailCanonical;
    }

    public void setEmailCanonical(String emailCanonical) {
        this.emailCanonical = emailCanonical;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public Date getPasswordRequestedAt() {
        return passwordRequestedAt;
    }

    public void setPasswordRequestedAt(Date passwordRequestedAt) {
        this.passwordRequestedAt = passwordRequestedAt;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getImageProfil() {
        return imageProfil;
    }

    public void setImageProfil(String imageProfil) {
        this.imageProfil = imageProfil;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    @XmlTransient
    public Collection<Annonce> getAnnonceCollection() {
        return annonceCollection;
    }

    public void setAnnonceCollection(Collection<Annonce> annonceCollection) {
        this.annonceCollection = annonceCollection;
    }

    @XmlTransient
    public Collection<Reservation> getReservationCollection() {
        return reservationCollection;
    }

    public void setReservationCollection(Collection<Reservation> reservationCollection) {
        this.reservationCollection = reservationCollection;
    }

    @XmlTransient
    public Collection<Voiture> getVoitureCollection() {
        return voitureCollection;
    }

    public void setVoitureCollection(Collection<Voiture> voitureCollection) {
        this.voitureCollection = voitureCollection;
    }

    @XmlTransient
    public Collection<Thread> getThreadCollection() {
        return threadCollection;
    }

    public void setThreadCollection(Collection<Thread> threadCollection) {
        this.threadCollection = threadCollection;
    }

    @XmlTransient
    public Collection<ThreadMetadata> getThreadMetadataCollection() {
        return threadMetadataCollection;
    }

    public void setThreadMetadataCollection(Collection<ThreadMetadata> threadMetadataCollection) {
        this.threadMetadataCollection = threadMetadataCollection;
    }

    @XmlTransient
    public Collection<Message> getMessageCollection() {
        return messageCollection;
    }

    public void setMessageCollection(Collection<Message> messageCollection) {
        this.messageCollection = messageCollection;
    }

    @XmlTransient
    public Collection<MessageMetadata> getMessageMetadataCollection() {
        return messageMetadataCollection;
    }

    public void setMessageMetadataCollection(Collection<MessageMetadata> messageMetadataCollection) {
        this.messageMetadataCollection = messageMetadataCollection;
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
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBEntities.Utilisateur[ id=" + id + " ]";
    }
    
}
