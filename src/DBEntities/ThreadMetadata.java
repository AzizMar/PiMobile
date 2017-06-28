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
@Table(name = "thread_metadata")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThreadMetadata.findAll", query = "SELECT t FROM ThreadMetadata t")
    , @NamedQuery(name = "ThreadMetadata.findById", query = "SELECT t FROM ThreadMetadata t WHERE t.id = :id")
    , @NamedQuery(name = "ThreadMetadata.findByIsDeleted", query = "SELECT t FROM ThreadMetadata t WHERE t.isDeleted = :isDeleted")
    , @NamedQuery(name = "ThreadMetadata.findByLastParticipantMessageDate", query = "SELECT t FROM ThreadMetadata t WHERE t.lastParticipantMessageDate = :lastParticipantMessageDate")
    , @NamedQuery(name = "ThreadMetadata.findByLastMessageDate", query = "SELECT t FROM ThreadMetadata t WHERE t.lastMessageDate = :lastMessageDate")})
public class ThreadMetadata implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "is_deleted")
    private boolean isDeleted;
    @Column(name = "last_participant_message_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastParticipantMessageDate;
    @Column(name = "last_message_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastMessageDate;
    @JoinColumn(name = "participant_id", referencedColumnName = "id")
    @ManyToOne
    private Utilisateur participantId;
    @JoinColumn(name = "thread_id", referencedColumnName = "id")
    @ManyToOne
    private Thread threadId;

    public ThreadMetadata() {
    }

    public ThreadMetadata(Integer id) {
        this.id = id;
    }

    public ThreadMetadata(Integer id, boolean isDeleted) {
        this.id = id;
        this.isDeleted = isDeleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getLastParticipantMessageDate() {
        return lastParticipantMessageDate;
    }

    public void setLastParticipantMessageDate(Date lastParticipantMessageDate) {
        this.lastParticipantMessageDate = lastParticipantMessageDate;
    }

    public Date getLastMessageDate() {
        return lastMessageDate;
    }

    public void setLastMessageDate(Date lastMessageDate) {
        this.lastMessageDate = lastMessageDate;
    }

    public Utilisateur getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Utilisateur participantId) {
        this.participantId = participantId;
    }

    public Thread getThreadId() {
        return threadId;
    }

    public void setThreadId(Thread threadId) {
        this.threadId = threadId;
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
        if (!(object instanceof ThreadMetadata)) {
            return false;
        }
        ThreadMetadata other = (ThreadMetadata) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBEntities.ThreadMetadata[ id=" + id + " ]";
    }
    
}
