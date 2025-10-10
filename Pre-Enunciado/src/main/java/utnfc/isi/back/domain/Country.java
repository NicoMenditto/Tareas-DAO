package utnfc.isi.back.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "COUNTRIES")
public class Country {
    @Id
    @Column(name = "ID_COUNTRY")
    private Integer id;

    @Column(name = "CODE", nullable = false, length = 3, unique = true)
    private String code;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
