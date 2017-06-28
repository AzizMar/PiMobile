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
@Table(name = "thread")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Thread.findAll", query = "SELECT t FROM Thread t")
    , @NamedQuery(name = "Thread.findById", query = "SELECT t FROM Thread t WHERE t.id = :id")
    , @NamedQuery(name = "Thread.findBySubject", query = "SELECT t FROM Thread t WHERE t.subject = :subject")
    , @NamedQuery(name = "Thread.findByCreatedAt", query = "SELECT t FROM Thread t WHERE t.createdAt = :createdAt")
    , @NamedQuery(name = "Thread.findByIsSpam", query = "SELECT t FROM Thread t WHERE t.isSpam = :isSpam")})
public class Thread implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "subject")
    private String subject;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @Column(name = "is_spam")
    private boolean isSpam;
    @JoinColumn(name = "created_by_id", referencedColumnName = "id")
    @ManyToOne
    private Utilisateur createdById;
    @OneToMany(mappedBy = "threadId")
    private Collection<ThreadMetadata> threadMetadataCollection;
    @OneToMany(mappedBy = "threadId")
    private Collection<Message> messageCollection;

    public Thread() {
    }

    public Thread(Integer id) {
        this.id = id;
    }

    public Thread(Integer id, String subject, Date createdAt, boolean isSpam) {
        this.id = id;
        this.subject = subject;
        this.createdAt = createdAt;
        this.isSpam = isSpam;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean getIsSpam() {
        return isSpam;
    }

    public void setIsSpam(boolean isSpam) {
        this.isSpam = isSpam;
    }

    public Utilisateur getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Utilisateur createdById) {
        this.createdById = createdById;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thread)) {
            return false;
        }
        Thread other = (Thread) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBEntities.Thread[ id=" + id + " ]";
    }
    
}
