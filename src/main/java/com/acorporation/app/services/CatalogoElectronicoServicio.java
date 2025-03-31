package com.acorporation.app.services;

import com.acorporation.app.dto.AcuerdoMarcoDTO;
import com.acorporation.app.dto.CatalogoElectronicoDTO;
import com.acorporation.app.models.AcuerdoMarco;
import com.acorporation.app.models.CatalogoElectronico;
import com.acorporation.app.repositories.AcuerdoMarcoRepositorio;
import com.acorporation.app.repositories.CatalogoElectronicoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CatalogoElectronicoServicio {

    @Autowired
    private CatalogoElectronicoRepositorio catalogoElectronicoRepositorio;

    @Autowired
    private AcuerdoMarcoRepositorio acuerdoMarcoRepositorio;

    public List<CatalogoElectronicoDTO> obtenerTodosLosCatalogosElectronicos() {
        List<CatalogoElectronico> catalogos = catalogoElectronicoRepositorio.findAll();
        return catalogos.stream()
                .map(this::convertirACatalogoElectronicoDTO)
                .collect(Collectors.toList());
    }

    public CatalogoElectronicoDTO obtenerCatalogoElectronicoPorId(Integer id) {
        Optional<CatalogoElectronico> catalogo = catalogoElectronicoRepositorio.findById(id);
        return catalogo.map(this::convertirACatalogoElectronicoDTO).orElse(null);
    }

    public CatalogoElectronicoDTO crearCatalogoElectronico(CatalogoElectronicoDTO catalogoDTO) {
        CatalogoElectronico catalogo = convertirADocumento(catalogoDTO);
        
        catalogo = catalogoElectronicoRepositorio.save(catalogo);
        
        return convertirACatalogoElectronicoDTO(catalogo);
    }
    
    public List<CatalogoElectronicoDTO> obtenerCatalogosPorAcuerdo(Integer idAcuerdo) {
        List<CatalogoElectronico> catalogos = catalogoElectronicoRepositorio.findByAcuerdoMarco_IdAcuerdo(idAcuerdo);
        return catalogos.stream()
                .map(this::convertirACatalogoElectronicoDTO)
                .collect(Collectors.toList());
    }

    public CatalogoElectronicoDTO actualizarCatalogoElectronico(Integer id, CatalogoElectronicoDTO catalogoDTO) {
        Optional<CatalogoElectronico> catalogoOptional = catalogoElectronicoRepositorio.findById(id);
        if (catalogoOptional.isPresent()) {
            CatalogoElectronico catalogo = convertirADocumento(catalogoDTO);
            catalogo.setIdCatalogo(id);
            
            catalogo = catalogoElectronicoRepositorio.save(catalogo);
            return convertirACatalogoElectronicoDTO(catalogo);
        }
        return null;
    }

    public void eliminarCatalogoElectronico(Integer id) {
        catalogoElectronicoRepositorio.deleteById(id);
    }

    // MÉTODOS PARA CONVERTIR ENTRE ENTIDAD Y DTO
    private CatalogoElectronicoDTO convertirACatalogoElectronicoDTO(CatalogoElectronico catalogo) {
        CatalogoElectronicoDTO catalogoDTO = new CatalogoElectronicoDTO();
        catalogoDTO.setIdCatalogo(catalogo.getIdCatalogo());
        catalogoDTO.setCodigoCatalogo(catalogo.getCodigoCatalogo());
        catalogoDTO.setDescripcionCatalogo(catalogo.getDescripcionCatalogo());
        catalogoDTO.setFechaCreacion(catalogo.getFechaCreacion());

        if (catalogo.getAcuerdoMarco() != null) {
            AcuerdoMarcoDTO acuerdoDTO = new AcuerdoMarcoDTO();
            acuerdoDTO.setIdAcuerdo(catalogo.getAcuerdoMarco().getIdAcuerdo());
            acuerdoDTO.setCodigoAcuerdo(catalogo.getAcuerdoMarco().getCodigoAcuerdo());
            acuerdoDTO.setNombreAcuerdo(catalogo.getAcuerdoMarco().getNombreAcuerdo());
            acuerdoDTO.setFechaInicio(catalogo.getAcuerdoMarco().getFechaInicio());
            acuerdoDTO.setFechaFin(catalogo.getAcuerdoMarco().getFechaFin());
            catalogoDTO.setAcuerdoMarco(acuerdoDTO);
        }
        return catalogoDTO;
    }

    private CatalogoElectronico convertirADocumento(CatalogoElectronicoDTO catalogoDTO) {
        CatalogoElectronico catalogo = new CatalogoElectronico();
        catalogo.setIdCatalogo(catalogoDTO.getIdCatalogo());
        catalogo.setCodigoCatalogo(catalogoDTO.getCodigoCatalogo());
        catalogo.setDescripcionCatalogo(catalogoDTO.getDescripcionCatalogo());
        catalogo.setFechaCreacion(catalogoDTO.getFechaCreacion());

        if (catalogoDTO.getAcuerdoMarco() != null) {
            Optional<AcuerdoMarco> acuerdoOptional = acuerdoMarcoRepositorio.findById(catalogoDTO.getAcuerdoMarco().getIdAcuerdo());
            acuerdoOptional.ifPresent(catalogo::setAcuerdoMarco);
        }
        return catalogo;
    }
}
