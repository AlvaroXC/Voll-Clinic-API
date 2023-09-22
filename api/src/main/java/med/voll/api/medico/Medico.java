package med.voll.api.medico;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.direccion.Direccion;

@Table(name = "medicos")
@Entity (name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id") //usar el id para comparar a los medicos

public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private Direccion direccion;
    private boolean activo;

    public Medico(DatosRegistroMedico datosRegistroMedico) {
        this.activo=true;
        this.nombre=datosRegistroMedico.nombre();
        this.email=datosRegistroMedico.email();
        this.telefono= datosRegistroMedico.telefono();
        this.documento= datosRegistroMedico.documento();
        this.especialidad= datosRegistroMedico.especialidad();
        this.direccion=new Direccion(datosRegistroMedico.direccion());
    }


    public void actualizarDatos(DatosActuaizarMedico datosActuaizarMedico) {

        if(datosActuaizarMedico.nombre()!= null){
            this.nombre=datosActuaizarMedico.nombre();

        }
        if (datosActuaizarMedico.documento()!=null)
            this.documento= datosActuaizarMedico.documento();

        if(datosActuaizarMedico.direccion()!=null){
            this.direccion= direccion.actualizarDatos(datosActuaizarMedico.direccion());
        }

    }

    public void desactivarMedico() {
        this.activo=false;
    }
}
