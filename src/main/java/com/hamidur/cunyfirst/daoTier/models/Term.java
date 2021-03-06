package com.hamidur.cunyfirst.daoTier.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity(name = "Term")
@Table(name = "Terms")
public class Term implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "termId", updatable = false, nullable = false)
    private Integer termId;
    
    @Column(name = "termName", nullable = false, length = 6)
    private String termName;
    
    @Column(name = "termYear", nullable = false)
    private Integer termYear;
    
    public Term() {}
    
    public Term(String termName, Integer termYear)
    {
        this.termName = termName;
        this.termYear = termYear;
    }
    
    public Integer getTermId()
    {
        return termId;
    }
    
    public void setTermId(Integer termId)
    {
        this.termId = termId;
    }
    
    public String getTermName()
    {
        return termName;
    }
    
    public void setTermName(String termName)
    {
        this.termName = termName;
    }
    
    public Integer getTermYear()
    {
        return termYear;
    }
    
    public void setTermYear(Integer termYear)
    {
        this.termYear = termYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Term)) return false;
        Term term = (Term) o;
        return Objects.equals(getTermName(), term.getTermName()) &&
                Objects.equals(getTermYear(), term.getTermYear());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getTermName(), getTermYear());
    }
    
    @Override
    public String toString()
    {
        return "Term{" + "termId=" + termId + ", termName='" + termName + '\'' + ", termYear=" + termYear + '}';
    }
}
