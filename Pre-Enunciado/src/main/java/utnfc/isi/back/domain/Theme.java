package utnfc.isi.back.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "THEMES")
public class Theme {
    @Id
    @Column(name = "ID_THEME")
    private Integer id;

    @Column(name = "NAME", nullable = false, length = 120, unique = true)
    private String name;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
