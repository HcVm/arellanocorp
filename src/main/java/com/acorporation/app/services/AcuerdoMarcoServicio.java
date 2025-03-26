package com.acorporation.app.services;

import com.acorporation.app.dto.AcuerdoMarcoDTO;
import com.acorporation.app.models.AcuerdoMarco;
import com.acorporation.app.repositories.AcuerdoMarcoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AcuerdoMarcoServicio {

    @Autowired
    private AcuerdoMarcoRepositorio acuerdoMarcoRepositorio;

    public List<AcuerdoMarcoDTO> obtenerTodosLosAcuerdosMarco() {
        return acuerdoMarcoRepositorio.findAll().stream()
                .map(this::convertirAcuerdoMarcoADTO)
                .collect(Collectors.toList());
    }

    public AcuerdoMarcoDTO obtenerAcuerdoMarcoPorId(Integer id) {
        return acuerdoMarcoRepositorio.findById(id)
                .map(this::convertirAcuerdoMarcoADTO)
                .orElseThrow(() -> new RuntimeException("Acuerdo Marco no encontrado con ID: " + id));
    }

    public AcuerdoMarcoDTO crearAcuerdoMarco(AcuerdoMarcoDTO acuerdoMarcoDTO) {
        AcuerdoMarco acuerdoMarco = mapearDTOAEntidad(acuerdoMarcoDTO, new AcuerdoMarco());
        return convertirAcuerdoMarcoADTO(acuerdoMarcoRepositorio.save(acuerdoMarco));
    }

    public AcuerdoMarcoDTO actualizarAcuerdoMarco(Integer id, AcuerdoMarcoDTO acuerdoMarcoDTO) {
        AcuerdoMarco acuerdoMarco = acuerdoMarcoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Acuerdo Marco no encontrado con ID: " + id));

        acuerdoMarco = mapearDTOAEntidad(acuerdoMarcoDTO, acuerdoMarco);
        return convertirAcuerdoMarcoADTO(acuerdoMarcoRepositorio.save(acuerdoMarco));
    }

    public void eliminarAcuerdoMarco(Integer id) {
        if (!acuerdoMarcoRepositorio.existsById(id)) {
            throw new RuntimeException("No se puede eliminar, Acuerdo Marco no encontrado con ID: " + id);
        }
        acuerdoMarcoRepositorio.deleteById(id);
    }

    private AcuerdoMarcoDTO convertirAcuerdoMarcoADTO(AcuerdoMarco acuerdoMarco) {
        return new AcuerdoMarcoDTO(
                acuerdoMarco.getIdAcuerdo(),
                acuerdoMarco.getCodigoAcuerdo(),
                acuerdoMarco.getNombreAcuerdo(),
                acuerdoMarco.getFechaInicio(),
                acuerdoMarco.getFechaFin()
        );
    }

    private AcuerdoMarco mapearDTOAEntidad(AcuerdoMarcoDTO dto, AcuerdoMarco entidad) {
        entidad.setCodigoAcuerdo(dto.getCodigoAcuerdo());
        entidad.setNombreAcuerdo(dto.getNombreAcuerdo());
        entidad.setFechaInicio(dto.getFechaInicio());
        entidad.setFechaFin(dto.getFechaFin());
        return entidad;
    }
}
