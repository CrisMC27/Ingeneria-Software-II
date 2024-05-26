package co.edu.ucentral.tarjetac.servicios;

import co.edu.ucentral.tarjetac.dto.SolicitudesDto;
import co.edu.ucentral.tarjetac.dto.TarjetasDto;
import co.edu.ucentral.tarjetac.entidades.Solicitud;
import co.edu.ucentral.tarjetac.entidades.Tarjeta;
import co.edu.ucentral.tarjetac.repositorios.RepositorioSolicitudes;
import co.edu.ucentral.tarjetac.repositorios.RepositorioTarjetas;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Service

public class ServicioSolicitudes implements Serializable {

    private ModelMapper modelMapper;
    private final RepositorioSolicitudes repoSoli;
    private final ServicioTarjetas servicioTarjetas;

    public List<SolicitudesDto> obtenerSolicitudes() {
        TypeToken<List<SolicitudesDto>> typeToken = new TypeToken<>(){};
        return modelMapper.map(repoSoli.findSolicitudesBy(), typeToken.getType());
    }
    public SolicitudesDto obtenerSolicitudByNum(long numS) {
        List<Solicitud> listaS = repoSoli.findSolicitudesByNumS(numS);
        if(!listaS.isEmpty())
            return modelMapper.map(listaS.get(0), SolicitudesDto.class);
        return null;
    }
    public SolicitudesDto actualizarSolicitud(SolicitudesDto solicitudesDto) {
        Solicitud solicitud = modelMapper.map(solicitudesDto, Solicitud.class);
        TarjetasDto tarjeta = new TarjetasDto();
        tarjeta = servicioTarjetas.registrar(tarjeta);
        if (solicitud != null){
            tarjeta.setNumerotarjeta(generarNumeroTarjeta());
            tarjeta.setCupo((long)(solicitud.getSalario()* 0.10));
            tarjeta.setDocumento(solicitud.getCedula());
            tarjeta.setFecha_cor(convertToDate(LocalDate.of(2024,7,20)));
            tarjeta.setFecha_lim(convertToDate(LocalDate.of(2024, 8, 7)));
            tarjeta.setFecha_vec(convertToDate(LocalDate.of(2026,5,26)));
            tarjeta.setSaldo(tarjeta.getCupo()-200000);
        }
        repoSoli.save(solicitud);
        return modelMapper.map(solicitud, SolicitudesDto.class);
    }
    public SolicitudesDto registrar(SolicitudesDto solicitudesDto) {
        Solicitud laSolicitud = repoSoli.save(modelMapper.map(solicitudesDto, Solicitud.class));
        return modelMapper.map(laSolicitud, SolicitudesDto.class);
    }
    private Date convertToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
    private long generarNumeroTarjeta() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            sb.append(random.nextInt(10));
        }
        return Long.parseLong(sb.toString());
    }
}
