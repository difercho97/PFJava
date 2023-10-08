package co.com.proyectofinaldiegovargas.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "animal")
public class AnimalEntity {

  @Id
  private String id;
  @Column
  private String nombre;
  @Column
  private int num_patas;
  @Column
  private Character genero;
  @Column
  private String especie;
  @Column
  private String habitat;
  @Column
  private Boolean esDomestico;
}
