package com.domain;

import javax.persistence.*;

@Entity
@Table(name="taxslnrate")
public class TaxRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer genaral1stSlab;
    private Integer femalgenaral1stSlab;
    private Integer disa1stSlab;
    private Integer ff1stSlab;
    private Integer firstSlab;
    private Integer sslab;
    private Integer tslab;
    private Integer fslab;
    private Integer restslab;
    private Float firstSlabRate;
    private Float secSLabRate;
    private Float thSlabRate;
    private Float fSlabRate;
    private Float reSlabRate;
    private String tax_year;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGenaral1stSlab() {
        return genaral1stSlab;
    }

    public void setGenaral1stSlab(Integer genaral1stSlab) {
        this.genaral1stSlab = genaral1stSlab;
    }

    public Integer getFemalgenaral1stSlab() {
        return femalgenaral1stSlab;
    }

    public void setFemalgenaral1stSlab(Integer femalgenaral1stSlab) {
        this.femalgenaral1stSlab = femalgenaral1stSlab;
    }

    public Integer getDisa1stSlab() {
        return disa1stSlab;
    }

    public void setDisa1stSlab(Integer disa1stSlab) {
        this.disa1stSlab = disa1stSlab;
    }

    public Integer getFf1stSlab() {
        return ff1stSlab;
    }

    public void setFf1stSlab(Integer ff1stSlab) {
        this.ff1stSlab = ff1stSlab;
    }

    public Integer getFirstSlab() {
        return firstSlab;
    }

    public void setFirstSlab(Integer firstSlab) {
        this.firstSlab = firstSlab;
    }

    public Integer getSslab() {
        return sslab;
    }

    public void setSslab(Integer sslab) {
        this.sslab = sslab;
    }

    public Integer getTslab() {
        return tslab;
    }

    public void setTslab(Integer tslab) {
        this.tslab = tslab;
    }

    public Integer getFslab() {
        return fslab;
    }

    public void setFslab(Integer fslab) {
        this.fslab = fslab;
    }

    public Integer getRestslab() {
        return restslab;
    }

    public void setRestslab(Integer restslab) {
        this.restslab = restslab;
    }

    public Float getFirstSlabRate() {
        return firstSlabRate;
    }

    public void setFirstSlabRate(Float firstSlabRate) {
        this.firstSlabRate = firstSlabRate;
    }

    public Float getSecSLabRate() {
        return secSLabRate;
    }

    public void setSecSLabRate(Float secSLabRate) {
        this.secSLabRate = secSLabRate;
    }

    public Float getThSlabRate() {
        return thSlabRate;
    }

    public void setThSlabRate(Float thSlabRate) {
        this.thSlabRate = thSlabRate;
    }

    public Float getfSlabRate() {
        return fSlabRate;
    }

    public void setfSlabRate(Float fSlabRate) {
        this.fSlabRate = fSlabRate;
    }

    public Float getReSlabRate() {
        return reSlabRate;
    }

    public void setReSlabRate(Float reSlabRate) {
        this.reSlabRate = reSlabRate;
    }

    public String getTax_year() {
        return tax_year;
    }

    public void setTax_year(String tax_year) {
        this.tax_year = tax_year;
    }


}
