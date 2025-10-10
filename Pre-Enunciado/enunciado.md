# Backend de Aplicaciones - Pre-enunciado Turno 1

## 🎯 Objetivo

Preparar una aplicación Java (consola) que inicialice una base de datos H2 en memoria, configure el mapeo JPA/Hibernate, y valide mínimamente la estructura. El día del parcial solo se deberá agregar el parseo del CSV y los procesos solicitados.

---

## 🛠️ Requisitos Técnicos

- Java 17+
- Maven
- Librerías:
  - Lombok
  - JDBC
  - JPA/Hibernate
- Base de datos:
  - H2 en memoria (`jdbc:h2:mem:legos;DB_CLOSE_DELAY=-1`)
  - Script SQL: `sql/ddl_legos.sql` (estructura y datos iniciales)

---

## 📁 Estructura Sugerida del Proyecto

├── src/ 
│ └── main/ 
│ ├── java/utnfc/isi/back/ 
│ │ ├── infra/ 
│ │ │ ├── DataSourceProvider.java 
│ │ │ ├── LocalEntityManagerProvider.java 
│ │ │ └── DbInitializer.java 
│ │ ├── domain/ 
│ │ │ ├── Country.java 
│ │ │ ├── Theme.java 
│ │ │ ├── AgeGroup.java 
│ │ │ └── LegoSet.java 
│ │ └── repo/ (opcional) 
│ └── resources/ 
│ └── META-INF/ 
│ └── persistence.xml 
├── sql/ 
│ └── ddl_legos.sql 
├── App.java 
└── pom.xml

---

## 🧩 Tareas a Realizar

### 1. Inicialización de BD

- Implementar `DbInitializer`:
  - Conexión H2 en memoria
  - Ejecutar `ddl_legos.sql` desde classpath
  - Cerrar recursos con `try-with-resources`

### 2. Infraestructura

- `DataSourceProvider`: expone `javax.sql.DataSource` para JDBC y JPA
- `LocalEntityManagerProvider`: configura `EntityManagerFactory` con Hibernate

### 3. Entidades JPA

- Mapear tablas:
  - `COUNTRIES` → `Country`
  - `THEMES` → `Theme`
  - `AGE_GROUPS` → `AgeGroup`
  - `LEGO_SETS` → `LegoSet`
- Usar `@Column(name = "...")` para mapear nombres distintos
- Relaciones en `LegoSet`:
  - `@ManyToOne(optional = false)` a `Theme`, `AgeGroup`, `Country`

### 4. AgeGroup - Método sugerido

```java
public boolean matchesAge(int age) {
    if (maxAge == null) return age >= minAge;
    if (minAge.equals(maxAge)) return age == minAge;
    return age >= minAge && age <= maxAge;
}
