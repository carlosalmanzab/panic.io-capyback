package com.capy.back.inicializador.componentes;

import com.capy.back.compartidos.enums.EstadoParametrizacionReporteEnum;
import com.capy.back.localizacion.model.entity.Barrio;
import com.capy.back.localizacion.model.entity.Comuna;
import com.capy.back.localizacion.repository.IBarrioRepository;
import com.capy.back.localizacion.repository.IComunaRepository;
import com.capy.back.reportesciudadanos.parametrizacion.model.entity.Parametrizacion;
import com.capy.back.reportesciudadanos.parametrizacion.repository.IParametrizacionRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class DataInicial implements ApplicationRunner {

    private final IComunaRepository comunaRepository;
    private final IBarrioRepository barrioRepository;
    private final IParametrizacionRepository parametrizacionRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public DataInicial(IComunaRepository comunaRepository, IBarrioRepository barrioRepository, IParametrizacionRepository parametrizacionRepository) {
        this.comunaRepository = comunaRepository;
        this.barrioRepository = barrioRepository;
        this.parametrizacionRepository = parametrizacionRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        llenarDatos();
    }

    private Boolean verificarDatos()    {
        return comunaRepository.findAll().isEmpty() && barrioRepository.findAll().isEmpty() && parametrizacionRepository.findAll().isEmpty();
    }

    private void llenarDatos() {
        if (verificarDatos()) {
            llenarComunas();
            llenarBarriosComuna1();
            llenarBarriosComuna2();
            llenarBarriosComuna3();
            llenarBarriosComuna4();
            llenarBarriosComuna5();
            llenarBarriosComuna6();
            llenarBarriosComuna7();
            llenarBarriosComuna8();
            llenarBarriosComuna9();

            llenarParametrizacion();
        }
    }
    private void eliminarTablas(List<String> cpBarrio) {
        cpBarrio.forEach(tabla -> entityManager.createNativeQuery("DROP TABLE IF EXISTS " + tabla).executeUpdate());
    }

    private void llenarParametrizacion() {
        List<Parametrizacion> parametrizacion = List.of(
                Parametrizacion.builder()
                        .nombre("Homicidio")
                        .descripcion("Reporte de un asesinato o homicidio en la vía pública.")
                        .usuarioCreacion("admin")
                        .fechaCreacion(LocalDateTime.now())
                        .estado(EstadoParametrizacionReporteEnum.ACTIVO)
                        .build(),
                Parametrizacion.builder()
                        .nombre("Accidente de tránsito")
                        .descripcion("Reporte de un accidente de tráfico que involucra vehículos.")
                        .usuarioCreacion("admin")
                        .fechaCreacion(LocalDateTime.now())
                        .estado(EstadoParametrizacionReporteEnum.ACTIVO)
                        .build(),
                Parametrizacion.builder()
                        .nombre("Accidente en moto")
                        .descripcion("Reporte de un accidente de tránsito que involucra una moto.")
                        .usuarioCreacion("admin")
                        .fechaCreacion(LocalDateTime.now())
                        .estado(EstadoParametrizacionReporteEnum.ACTIVO)
                        .build(),
                Parametrizacion.builder()
                        .nombre("Robo a mano armada")
                        .descripcion("Reporte de un robo en el que el perpetrador utiliza un arma.")
                        .usuarioCreacion("admin")
                        .fechaCreacion(LocalDateTime.now())
                        .estado(EstadoParametrizacionReporteEnum.ACTIVO)
                        .build(),
                Parametrizacion.builder()
                        .nombre("Acoso callejero")
                        .descripcion("Reporte de acoso, intimidación o comportamiento inapropiado en la calle.")
                        .usuarioCreacion("admin")
                        .fechaCreacion(LocalDateTime.now())
                        .estado(EstadoParametrizacionReporteEnum.ACTIVO)
                        .build(),
                Parametrizacion.builder()
                        .nombre("Venta de drogas")
                        .descripcion("Reporte de actividad ilegal relacionada con la venta de drogas.")
                        .usuarioCreacion("admin")
                        .fechaCreacion(LocalDateTime.now())
                        .estado(EstadoParametrizacionReporteEnum.ACTIVO)
                        .build(),
                Parametrizacion.builder()
                        .nombre("Vandalismo")
                        .descripcion("Reporte de daños intencionales a la propiedad pública o privada.")
                        .usuarioCreacion("admin")
                        .fechaCreacion(LocalDateTime.now())
                        .estado(EstadoParametrizacionReporteEnum.ACTIVO)
                        .build(),
                Parametrizacion.builder()
                        .nombre("Robo de vehículo")
                        .descripcion("Reporte de robo de un vehículo en la calle.")
                        .usuarioCreacion("admin")
                        .fechaCreacion(LocalDateTime.now())
                        .estado(EstadoParametrizacionReporteEnum.ACTIVO)
                        .build(),
                Parametrizacion.builder()
                        .nombre("Aparcamiento ilegal")
                        .descripcion("Reporte de vehículos estacionados en lugares no permitidos.")
                        .usuarioCreacion("admin")
                        .fechaCreacion(LocalDateTime.now())
                        .estado(EstadoParametrizacionReporteEnum.ACTIVO)
                        .build(),
                Parametrizacion.builder()
                        .nombre("Incendio en la calle")
                        .descripcion("Reporte de un incendio en la vía pública.")
                        .usuarioCreacion("admin")
                        .fechaCreacion(LocalDateTime.now())
                        .estado(EstadoParametrizacionReporteEnum.ACTIVO)
                        .build(),
                Parametrizacion.builder()
                        .nombre("Agresión física")
                        .descripcion("Reporte de una agresión física en la vía pública.")
                        .usuarioCreacion("admin")
                        .fechaCreacion(LocalDateTime.now())
                        .estado(EstadoParametrizacionReporteEnum.ACTIVO)
                        .build(),
                Parametrizacion.builder()
                        .nombre("Vehículo abandonado")
                        .descripcion("Reporte de un vehículo abandonado en la calle.")
                        .usuarioCreacion("admin")
                        .fechaCreacion(LocalDateTime.now())
                        .estado(EstadoParametrizacionReporteEnum.ACTIVO)
                        .build(),
                Parametrizacion.builder()
                        .nombre("Basura acumulada")
                        .descripcion("Reporte de acumulación de basura en la vía pública.")
                        .usuarioCreacion("admin")
                        .fechaCreacion(LocalDateTime.now())
                        .estado(EstadoParametrizacionReporteEnum.ACTIVO)
                        .build(),
                Parametrizacion.builder()
                        .nombre("Perro suelto")
                        .descripcion("Reporte de un perro suelto y sin correa en la calle.")
                        .usuarioCreacion("admin")
                        .fechaCreacion(LocalDateTime.now())
                        .estado(EstadoParametrizacionReporteEnum.ACTIVO)
                        .build(),
                Parametrizacion.builder()
                        .nombre("Contaminación ambiental")
                        .descripcion("Reporte de actividades que causan contaminación ambiental.")
                        .usuarioCreacion("admin")
                        .fechaCreacion(LocalDateTime.now())
                        .estado(EstadoParametrizacionReporteEnum.ACTIVO)
                        .build()

        );

        parametrizacionRepository.saveAll(parametrizacion);
    }

    private void llenarComunas() {
        Comuna comuna1 = Comuna.builder()
                .nombre("Comuna 1")
                .build();
        Comuna comuna2 = Comuna.builder()
                .nombre("Comuna 2")
                .build();
        Comuna comuna3 = Comuna.builder()
                .nombre("Comuna 3")
                .build();
        Comuna comuna4 = Comuna.builder()
                .nombre("Comuna 4")
                .build();
        Comuna comuna5 = Comuna.builder()
                .nombre("Comuna 5")
                .build();
        Comuna comuna6 = Comuna.builder()
                .nombre("Comuna 6")
                .build();
        Comuna comuna7 = Comuna.builder()
                .nombre("Comuna 7")
                .build();
        Comuna comuna8 = Comuna.builder()
                .nombre("Comuna 8")
                .build();
        Comuna comuna9 = Comuna.builder()
                .nombre("Comuna 9")
                .build();
        comunaRepository.saveAll(List.of(comuna1, comuna2, comuna3, comuna4, comuna5, comuna6, comuna7, comuna8, comuna9));
    }

    private void llenarBarriosComuna1() {
        Long comuna1 = comunaRepository.findByNombre("Comuna 1").getId();

        List<Barrio> barriosComuna1 = List.of(
                Barrio.builder().nombre("Urbanización La Navarra").idComuna(comuna1).build(),
                Barrio.builder().nombre("Urbanización El Portal I").idComuna(comuna1).build(),
                Barrio.builder().nombre("La Palma").idComuna(comuna1).build(),
                Barrio.builder().nombre("Rancho Grande").idComuna(comuna1).build(),
                Barrio.builder().nombre("Mi Ranchito").idComuna(comuna1).build(),
                Barrio.builder().nombre("Nuevo Horizonte").idComuna(comuna1).build(),
                Barrio.builder().nombre("El Campano").idComuna(comuna1).build(),
                Barrio.builder().nombre("Casa Finca").idComuna(comuna1).build(),
                Barrio.builder().nombre("Urbanización Caracolí").idComuna(comuna1).build(),
                Barrio.builder().nombre("Urbanización Betanci").idComuna(comuna1).build(),
                Barrio.builder().nombre("Nueva Holanda").idComuna(comuna1).build(),
                Barrio.builder().nombre("Urbanización El Puente I").idComuna(comuna1).build(),
                Barrio.builder().nombre("La Ribera").idComuna(comuna1).build(),
                Barrio.builder().nombre("República de Panamá").idComuna(comuna1).build(),
                Barrio.builder().nombre("El Dorado").idComuna(comuna1).build(),
                Barrio.builder().nombre("El Poblado").idComuna(comuna1).build(),
                Barrio.builder().nombre("Urbanización El Níspero").idComuna(comuna1).build(),
                Barrio.builder().nombre("Urbanización Los Colores").idComuna(comuna1).build(),
                Barrio.builder().nombre("El Ébano").idComuna(comuna1).build(),
                Barrio.builder().nombre("Villa Nazaret").idComuna(comuna1).build(),
                Barrio.builder().nombre("Urbanización El Portal II").idComuna(comuna1).build(),
                Barrio.builder().nombre("Jesuralem").idComuna(comuna1).build(),
                Barrio.builder().nombre("Nueva Esperanza").idComuna(comuna1).build(),
                Barrio.builder().nombre("Urbanización Vallejo").idComuna(comuna1).build(),
                Barrio.builder().nombre("Barrio Levi").idComuna(comuna1).build()
        );

        barrioRepository.saveAll(barriosComuna1);

    }

    private void llenarBarriosComuna2() {
        Long comuna2 = comunaRepository.findByNombre("Comuna 2").getId();

        List<Barrio> barriosComuna2 = List.of(
                Barrio.builder().nombre("Campo Alegre").idComuna(comuna2).build(),
                Barrio.builder().nombre("Casita Nueva").idComuna(comuna2).build(),
                Barrio.builder().nombre("El Amparo").idComuna(comuna2).build(),
                Barrio.builder().nombre("El Bongo").idComuna(comuna2).build(),
                Barrio.builder().nombre("El Rosario").idComuna(comuna2).build(),
                Barrio.builder().nombre("El Tambo").idComuna(comuna2).build(),
                Barrio.builder().nombre("Juan XXIII").idComuna(comuna2).build(),
                Barrio.builder().nombre("La Alborada").idComuna(comuna2).build(),
                Barrio.builder().nombre("La Esmeralda").idComuna(comuna2).build(),
                Barrio.builder().nombre("La Esperanza II").idComuna(comuna2).build(),
                Barrio.builder().nombre("Las Viñas").idComuna(comuna2).build(),
                Barrio.builder().nombre("Magdalena").idComuna(comuna2).build(),
                Barrio.builder().nombre("El Minuto de Dios").idComuna(comuna2).build(),
                Barrio.builder().nombre("Río de Janeiro").idComuna(comuna2).build(),
                Barrio.builder().nombre("Urbanización El Puente II").idComuna(comuna2).build(),
                Barrio.builder().nombre("Urbanización Manuel Antonio Buelvas").idComuna(comuna2).build(),
                Barrio.builder().nombre("Urbanización Villa Real").idComuna(comuna2).build(),
                Barrio.builder().nombre("Villa Luz").idComuna(comuna2).build(),
                Barrio.builder().nombre("Villa Nueva").idComuna(comuna2).build(),
                Barrio.builder().nombre("Manuel Jiménez").idComuna(comuna2).build()
        );

        barrioRepository.saveAll(barriosComuna2);
    }

    private void llenarBarriosComuna3() {
        Long comuna3 = comunaRepository.findByNombre("Comuna 3").getId();

        List<Barrio> barriosComuna3 = List.of(
                Barrio.builder().nombre("Brisas del Sinú").idComuna(comuna3).build(),
                Barrio.builder().nombre("Buenavista").idComuna(comuna3).build(),
                Barrio.builder().nombre("El Tendal").idComuna(comuna3).build(),
                Barrio.builder().nombre("La Coquera").idComuna(comuna3).build(),
                Barrio.builder().nombre("La Granja").idComuna(comuna3).build(),
                Barrio.builder().nombre("Nuevo Milenio").idComuna(comuna3).build(),
                Barrio.builder().nombre("Pastrana Borrero").idComuna(comuna3).build(),
                Barrio.builder().nombre("Policarpa").idComuna(comuna3).build(),
                Barrio.builder().nombre("San Martín").idComuna(comuna3).build(),
                Barrio.builder().nombre("Santa Fe").idComuna(comuna3).build(),
                Barrio.builder().nombre("Santa Lucía").idComuna(comuna3).build(),
                Barrio.builder().nombre("Santander").idComuna(comuna3).build(),
                Barrio.builder().nombre("Simón Bolívar").idComuna(comuna3).build(),
                Barrio.builder().nombre("Los Araújos").idComuna(comuna3).build()
        );

        barrioRepository.saveAll(barriosComuna3);
    }

    private void llenarBarriosComuna4() {
        Long comuna4 = comunaRepository.findByNombre("Comuna 4").getId();

        List<Barrio> barriosComuna4 = List.of(
                Barrio.builder().nombre("Boston").idComuna(comuna4).build(),
                Barrio.builder().nombre("Colina Real").idComuna(comuna4).build(),
                Barrio.builder().nombre("Damasco").idComuna(comuna4).build(),
                Barrio.builder().nombre("Dos de Septiembre").idComuna(comuna4).build(),
                Barrio.builder().nombre("Edmundo López II").idComuna(comuna4).build(),
                Barrio.builder().nombre("El Enjambre").idComuna(comuna4).build(),
                Barrio.builder().nombre("El Paraíso").idComuna(comuna4).build(),
                Barrio.builder().nombre("El Prado").idComuna(comuna4).build(),
                Barrio.builder().nombre("Furatena (OPV)").idComuna(comuna4).build(),
                Barrio.builder().nombre("Galilea").idComuna(comuna4).build(),
                Barrio.builder().nombre("Granada").idComuna(comuna4).build(),
                Barrio.builder().nombre("La Campiña").idComuna(comuna4).build(),
                Barrio.builder().nombre("La Candelaria").idComuna(comuna4).build(),
                Barrio.builder().nombre("Las Américas").idComuna(comuna4).build(),
                Barrio.builder().nombre("Las Colinas").idComuna(comuna4).build(),
                Barrio.builder().nombre("Los Araujos").idComuna(comuna4).build(),
                Barrio.builder().nombre("Mira Flores").idComuna(comuna4).build(),
                Barrio.builder().nombre("Mogambito").idComuna(comuna4).build(),
                Barrio.builder().nombre("Mogambo").idComuna(comuna4).build(),
                Barrio.builder().nombre("Primero de Mayo").idComuna(comuna4).build(),
                Barrio.builder().nombre("Nueva Esperanza (OPV)").idComuna(comuna4).build(),
                Barrio.builder().nombre("Nuevo Horizonte II").idComuna(comuna4).build(),
                Barrio.builder().nombre("P-5").idComuna(comuna4).build(),
                Barrio.builder().nombre("Pablo VI").idComuna(comuna4).build(),
                Barrio.builder().nombre("Panzenú").idComuna(comuna4).build(),
                Barrio.builder().nombre("Paz del Río").idComuna(comuna4).build(),
                Barrio.builder().nombre("Ranchitos").idComuna(comuna4).build(),
                Barrio.builder().nombre("Robinson Pitalúa").idComuna(comuna4).build(),
                Barrio.builder().nombre("Santa Rosa").idComuna(comuna4).build(),
                Barrio.builder().nombre("Urbanización Guadalajara").idComuna(comuna4).build(),
                Barrio.builder().nombre("Urbanización Jiménez").idComuna(comuna4).build(),
                Barrio.builder().nombre("Urbanización Los Alpes").idComuna(comuna4).build(),
                Barrio.builder().nombre("Urbanización Los Ángeles").idComuna(comuna4).build(),
                Barrio.builder().nombre("Urbanización Los Robles").idComuna(comuna4).build(),
                Barrio.builder().nombre("Urbanización Samaria").idComuna(comuna4).build(),
                Barrio.builder().nombre("Urbanización Santa Isabel").idComuna(comuna4).build(),
                Barrio.builder().nombre("Vereda Tropical").idComuna(comuna4).build(),
                Barrio.builder().nombre("Villa Margarita").idComuna(comuna4).build(),
                Barrio.builder().nombre("Villa Paz (OPV)").idComuna(comuna4).build(),
                Barrio.builder().nombre("Urbanización Los Araujos").idComuna(comuna4).build()
        );

        barrioRepository.saveAll(barriosComuna4);
    }

    private void llenarBarriosComuna5() {
        Long comuna5 = comunaRepository.findByNombre("Comuna 5").getId();

        List<Barrio> barriosComuna5 = List.of(
                Barrio.builder().nombre("Balboa").idComuna(comuna5).build(),
                Barrio.builder().nombre("Catorce de Julio").idComuna(comuna5).build(),
                Barrio.builder().nombre("Chambacú").idComuna(comuna5).build(),
                Barrio.builder().nombre("Chuchurubí").idComuna(comuna5).build(),
                Barrio.builder().nombre("El Coliseo").idComuna(comuna5).build(),
                Barrio.builder().nombre("Colón").idComuna(comuna5).build(),
                Barrio.builder().nombre("Costa de Oro").idComuna(comuna5).build(),
                Barrio.builder().nombre("El Centro").idComuna(comuna5).build(),
                Barrio.builder().nombre("El Edén").idComuna(comuna5).build(),
                Barrio.builder().nombre("La Ceiba").idComuna(comuna5).build(),
                Barrio.builder().nombre("La Julia").idComuna(comuna5).build(),
                Barrio.builder().nombre("La Victoria").idComuna(comuna5).build(),
                Barrio.builder().nombre("Los Álamos").idComuna(comuna5).build(),
                Barrio.builder().nombre("Montería Moderno").idComuna(comuna5).build(),
                Barrio.builder().nombre("Nariño").idComuna(comuna5).build(),
                Barrio.builder().nombre("Obrero").idComuna(comuna5).build(),
                Barrio.builder().nombre("Ospina Pérez").idComuna(comuna5).build(),
                Barrio.builder().nombre("Pasatiempo").idComuna(comuna5).build(),
                Barrio.builder().nombre("Pueblo Nuevo").idComuna(comuna5).build(),
                Barrio.builder().nombre("Risaralda").idComuna(comuna5).build(),
                Barrio.builder().nombre("Santa Clara").idComuna(comuna5).build(),
                Barrio.builder().nombre("Tacasuan").idComuna(comuna5).build(),
                Barrio.builder().nombre("Urbanización Lacharme").idComuna(comuna5).build(),
                Barrio.builder().nombre("Urbina").idComuna(comuna5).build()
        );

        barrioRepository.saveAll(barriosComuna5);
    }

    private void llenarBarriosComuna6() {
        Long comuna6 = comunaRepository.findByNombre("Comuna 6").getId();

        List<Barrio> barriosComuna6 = List.of(
                Barrio.builder().nombre("Acción Nuevo Milenio").idComuna(comuna6).build(),
                Barrio.builder().nombre("Cantaclaro").idComuna(comuna6).build(),
                Barrio.builder().nombre("Caribe").idComuna(comuna6).build(),
                Barrio.builder().nombre("Casasuan").idComuna(comuna6).build(),
                Barrio.builder().nombre("Edmundo López").idComuna(comuna6).build(),
                Barrio.builder().nombre("El Alivio").idComuna(comuna6).build(),
                Barrio.builder().nombre("El Diamante").idComuna(comuna6).build(),
                Barrio.builder().nombre("La Pradera").idComuna(comuna6).build(),
                Barrio.builder().nombre("La Unión").idComuna(comuna6).build(),
                Barrio.builder().nombre("San Cristóbal").idComuna(comuna6).build(),
                Barrio.builder().nombre("Seis de Marzo").idComuna(comuna6).build(),
                Barrio.builder().nombre("Urbanización Cundama").idComuna(comuna6).build(),
                Barrio.builder().nombre("Urbanización El Laguito").idComuna(comuna6).build(),
                Barrio.builder().nombre("Urbanización Tacasuan").idComuna(comuna6).build(),
                Barrio.builder().nombre("Villa Ana").idComuna(comuna6).build(),
                Barrio.builder().nombre("Villa Arleth").idComuna(comuna6).build(),
                Barrio.builder().nombre("Villa Rocío").idComuna(comuna6).build(),
                Barrio.builder().nombre("Villa Rosario").idComuna(comuna6).build(),
                Barrio.builder().nombre("El Canal").idComuna(comuna6).build()
        );

        barrioRepository.saveAll(barriosComuna6);
    }

    private void llenarBarriosComuna7() {
        Long comuna7 = comunaRepository.findByNombre("Comuna 7").getId();

        List<Barrio> barriosComuna7 = List.of(
                Barrio.builder().nombre("Alamedas del Sinú").idComuna(comuna7).build(),
                Barrio.builder().nombre("Altos del Country").idComuna(comuna7).build(),
                Barrio.builder().nombre("El Carmen").idComuna(comuna7).build(),
                Barrio.builder().nombre("Invasión").idComuna(comuna7).build(),
                Barrio.builder().nombre("Los Laureles").idComuna(comuna7).build(),
                Barrio.builder().nombre("Luis Carlos Galán").idComuna(comuna7).build(),
                Barrio.builder().nombre("Prado Norte").idComuna(comuna7).build(),
                Barrio.builder().nombre("Sector Industrial").idComuna(comuna7).build(),
                Barrio.builder().nombre("Sucre").idComuna(comuna7).build(),
                Barrio.builder().nombre("Playa Brígida").idComuna(comuna7).build(),
                Barrio.builder().nombre("Villa del Río").idComuna(comuna7).build(),
                Barrio.builder().nombre("Los Laureles II").idComuna(comuna7).build()
        );

        barrioRepository.saveAll(barriosComuna7);
    }

    private void llenarBarriosComuna8() {
        Long comuna8 = comunaRepository.findByNombre("Comuna 8").getId();

        List<Barrio> barriosComuna8 = List.of(
                Barrio.builder().nombre("Castilla La Nueva").idComuna(comuna8).build(),
                Barrio.builder().nombre("El Edén").idComuna(comuna8).build(),
                Barrio.builder().nombre("El Mora").idComuna(comuna8).build(),
                Barrio.builder().nombre("El Recreo").idComuna(comuna8).build(),
                Barrio.builder().nombre("La Castellana").idComuna(comuna8).build(),
                Barrio.builder().nombre("La Española").idComuna(comuna8).build(),
                Barrio.builder().nombre("La Floresta").idComuna(comuna8).build(),
                Barrio.builder().nombre("Las Flores").idComuna(comuna8).build(),
                Barrio.builder().nombre("Los Alcázares").idComuna(comuna8).build(),
                Barrio.builder().nombre("Los Robles del Norte").idComuna(comuna8).build(),
                Barrio.builder().nombre("Villa Cielo (OPV)").idComuna(comuna8).build(),
                Barrio.builder().nombre("Ranchos del Inat").idComuna(comuna8).build(),
                Barrio.builder().nombre("San Francisco").idComuna(comuna8).build(),
                Barrio.builder().nombre("San José").idComuna(comuna8).build(),
                Barrio.builder().nombre("Urbanización Bonanza").idComuna(comuna8).build(),
                Barrio.builder().nombre("Urbanización Brizalia").idComuna(comuna8).build(),
                Barrio.builder().nombre("Urbanización El Limonar").idComuna(comuna8).build(),
                Barrio.builder().nombre("Urbanización Los Ángeles Norte").idComuna(comuna8).build(),
                Barrio.builder().nombre("Urbanización Los Bongos").idComuna(comuna8).build(),
                Barrio.builder().nombre("Urbanización Oriente").idComuna(comuna8).build(),
                Barrio.builder().nombre("Urbanización Santa Teresa").idComuna(comuna8).build(),
                Barrio.builder().nombre("Urbanización Sevilla").idComuna(comuna8).build(),
                Barrio.builder().nombre("Urbanización Versalles").idComuna(comuna8).build(),
                Barrio.builder().nombre("Urbanización Villa Fátima").idComuna(comuna8).build(),
                Barrio.builder().nombre("Urbanización Villa Sorento").idComuna(comuna8).build(),
                Barrio.builder().nombre("Veinticinco de Agosto").idComuna(comuna8).build(),
                Barrio.builder().nombre("El Limonar").idComuna(comuna8).build()
        );

        barrioRepository.saveAll(barriosComuna8);
    }

    private void llenarBarriosComuna9() {
        Long comuna9 = comunaRepository.findByNombre("Comuna 9").getId();

        List<Barrio> barriosComuna9 = List.of(
                Barrio.builder().nombre("Camilo Torres").idComuna(comuna9).build(),
                Barrio.builder().nombre("El Bosque").idComuna(comuna9).build(),
                Barrio.builder().nombre("El Ceibal").idComuna(comuna9).build(),
                Barrio.builder().nombre("El Triunfo").idComuna(comuna9).build(),
                Barrio.builder().nombre("Flor del Sinú").idComuna(comuna9).build(),
                Barrio.builder().nombre("La Esmeralda").idComuna(comuna9).build(),
                Barrio.builder().nombre("Las Parcelas").idComuna(comuna9).build(),
                Barrio.builder().nombre("Los Cedros").idComuna(comuna9).build(),
                Barrio.builder().nombre("Mocarí").idComuna(comuna9).build(),
                Barrio.builder().nombre("Paz del Norte (OPV)").idComuna(comuna9).build(),
                Barrio.builder().nombre("Villa Fátima (OPV)").idComuna(comuna9).build(),
                Barrio.builder().nombre("Siete de Mayo").idComuna(comuna9).build(),
                Barrio.builder().nombre("Urbanización Comfacor").idComuna(comuna9).build(),
                Barrio.builder().nombre("Veinte de Julio").idComuna(comuna9).build(),
                Barrio.builder().nombre("Villa Sinú").idComuna(comuna9).build()
        );

        barrioRepository.saveAll(barriosComuna9);
    }


}
