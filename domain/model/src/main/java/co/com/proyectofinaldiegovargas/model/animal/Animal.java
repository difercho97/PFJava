package co.com.proyectofinaldiegovargas.model.animal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Animal {

  private String id;
  private String nombre;
  private int num_patas;
  private Character genero;
  private String especie;
  private String habitat;
  private Boolean esDomestico;
}
