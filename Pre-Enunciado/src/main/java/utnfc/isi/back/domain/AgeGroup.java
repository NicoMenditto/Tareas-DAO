package utnfc.isi.back.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "AGE_GROUPS")
public class AgeGroup {
    @Id
    @Column(name = "ID_AGE_GROUP")
    private Integer id;

    @Column(name = "CODE", nullable = false, length = 16, unique = true)
    private String code;

    // We'll parse codes like "6-12" or "12" into min/max
    @Transient
    private Integer minAge;

    @Transient
    private Integer maxAge;

    @PostLoad
    @PostPersist
    @PostUpdate
    private void parseCode() {
        if (code == null) return;
        String c = code.trim();
        if (c.contains("-")) {
            String[] parts = c.split("-", 2);
            try { minAge = Integer.valueOf(parts[0]); } catch (Exception e) { minAge = null; }
            try { maxAge = Integer.valueOf(parts[1]); } catch (Exception e) { maxAge = null; }
        } else {
            try { minAge = Integer.valueOf(c); maxAge = minAge; } catch (Exception e) { minAge = null; maxAge = null; }
        }
    }

    public boolean matchesAge(int age) {
        if (minAge == null) return false;
        if (maxAge == null) return age >= minAge;
        if (minAge.equals(maxAge)) return age == minAge;
        return age >= minAge && age <= maxAge;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; parseCode(); }
}
