package utnfc.isi.back.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "LEGO_SETS")
public class LegoSet {
    @Id
    @Column(name = "ID_SET")
    private Integer id;

    @Column(name = "PROD_ID", nullable = false)
    private Integer prodId;

    @Column(name = "SET_NAME", nullable = false, length = 200)
    private String setName;

    @Column(name = "PROD_DESC", length = 2048)
    private String prodDesc;

    @Column(name = "REVIEW_DIFFICULTY", length = 32)
    private String reviewDifficulty;

    @Column(name = "PIECE_COUNT")
    private Integer pieceCount;

    @Column(name = "STAR_RATING", precision = 3, scale = 1)
    private Double starRating;

    @Column(name = "LIST_PRICE", precision = 10, scale = 2)
    private Double listPrice;

    @ManyToOne(optional = false)
    @JoinColumn(name = "THEME_ID")
    private Theme theme;

    @ManyToOne(optional = false)
    @JoinColumn(name = "AGE_GROUP_ID")
    private AgeGroup ageGroup;

    @ManyToOne(optional = false)
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getProdId() { return prodId; }
    public void setProdId(Integer prodId) { this.prodId = prodId; }
    public String getSetName() { return setName; }
    public void setSetName(String setName) { this.setName = setName; }
    public String getProdDesc() { return prodDesc; }
    public void setProdDesc(String prodDesc) { this.prodDesc = prodDesc; }
    public String getReviewDifficulty() { return reviewDifficulty; }
    public void setReviewDifficulty(String reviewDifficulty) { this.reviewDifficulty = reviewDifficulty; }
    public Integer getPieceCount() { return pieceCount; }
    public void setPieceCount(Integer pieceCount) { this.pieceCount = pieceCount; }
    public Double getStarRating() { return starRating; }
    public void setStarRating(Double starRating) { this.starRating = starRating; }
    public Double getListPrice() { return listPrice; }
    public void setListPrice(Double listPrice) { this.listPrice = listPrice; }
    public Theme getTheme() { return theme; }
    public void setTheme(Theme theme) { this.theme = theme; }
    public AgeGroup getAgeGroup() { return ageGroup; }
    public void setAgeGroup(AgeGroup ageGroup) { this.ageGroup = ageGroup; }
    public Country getCountry() { return country; }
    public void setCountry(Country country) { this.country = country; }
}
