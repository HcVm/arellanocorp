package com.acorporation.app.services;

import com.acorporation.app.dto.AcuerdoMarcoDTO;
import com.acorporation.app.dto.CatalogoElectronicoDTO;
import com.acorporation.app.dto.EmpresaDTO;
import com.acorporation.app.dto.MarcaDTO;
import com.acorporation.app.dto.ProductoDTO;
import com.acorporation.app.dto.ValorCaracteristicaDTO;
import com.acorporation.app.models.AcuerdoMarco;
import com.acorporation.app.models.CatalogoElectronico;
import com.acorporation.app.models.Empresa;
import com.acorporation.app.models.Marca;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.acorporation.app.models.Producto;
import com.acorporation.app.models.ValorCaracteristica;
import com.acorporation.app.repositories.CatalogoElectronicoRepositorio;
import com.acorporation.app.repositories.MarcaRepositorio;
import com.acorporation.app.repositories.ProductoRepositorio;
import com.acorporation.app.repositories.ValorCaracteristicaRepositorio;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoServicio {
	
	private static final Logger log = LoggerFactory.getLogger(ProductoServicio.class);

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Autowired
    private CatalogoElectronicoRepositorio catalogoElectronicoRepositorio;

    @Autowired
    private MarcaRepositorio marcaRepositorio;

    @Autowired
    private ValorCaracteristicaRepositorio valorCaracteristicaRepositorio;
    

    public List<ProductoDTO> obtenerTodosLosProductos() {
        List<Producto> productos = productoRepositorio.findAll();
        return productos.stream()
                .map(this::convertirProductoADTO)
                .collect(Collectors.toList());
    }

    public ProductoDTO obtenerProductoPorId(Integer id) {
        Optional<Producto> producto = productoRepositorio.findById(id);
        return producto.map(this::convertirProductoADTO).orElse(null);
    }

    public ProductoDTO crearProducto(ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setCodigoProducto(productoDTO.getCodigoProducto());
        producto.setNombreProducto(productoDTO.getNombreProducto());
        producto.setDescripcionProducto(productoDTO.getDescripcionProducto());
        producto.setStock(productoDTO.getStock());
        producto.setEstado(productoDTO.getEstado());
        producto.setPrecioPlataforma(productoDTO.getPrecioPlataforma());

        Optional<CatalogoElectronico> catalogoElectronico = catalogoElectronicoRepositorio.findById(productoDTO.getCatalogoElectronico().getIdCatalogo());
        Optional<Marca> marca = marcaRepositorio.findById(productoDTO.getMarca().getIdMarca());

        catalogoElectronico.ifPresent(producto::setCatalogoElectronico);
        marca.ifPresent(producto::setMarca);

        producto = productoRepositorio.save(producto);

        List<ValorCaracteristica> caracteristicas = productoDTO.getCaracteristicas().stream()
                .map(ValorCaracteristicaDTO::getIdValorCaracteristica)
                .map(valorCaracteristicaRepositorio::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
        caracteristicas.forEach(producto::addCaracteristica);
        productoRepositorio.save(producto);

        return convertirProductoADTO(producto);
    }

    public ProductoDTO actualizarProducto(Integer id, ProductoDTO productoDTO) {
        Optional<Producto> productoOptional = productoRepositorio.findById(id);
        if (productoOptional.isPresent()) {
            Producto producto = productoOptional.get();
            producto.setCodigoProducto(productoDTO.getCodigoProducto());
            producto.setNombreProducto(productoDTO.getNombreProducto());
            producto.setDescripcionProducto(productoDTO.getDescripcionProducto());
            producto.setStock(productoDTO.getStock());
            producto.setEstado(productoDTO.getEstado());
            producto.setPrecioPlataforma(productoDTO.getPrecioPlataforma());

            Optional<CatalogoElectronico> catalogoElectronico = catalogoElectronicoRepositorio.findById(productoDTO.getCatalogoElectronico().getIdCatalogo());
            Optional<Marca> marca = marcaRepositorio.findById(productoDTO.getMarca().getIdMarca());

            catalogoElectronico.ifPresent(producto::setCatalogoElectronico);
            marca.ifPresent(producto::setMarca);

            List<ValorCaracteristica> nuevasCaracteristicas = productoDTO.getCaracteristicas().stream()
                    .map(ValorCaracteristicaDTO::getIdValorCaracteristica)
                    .map(valorCaracteristicaRepositorio::findById)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());

            List<ValorCaracteristica> caracteristicasAEliminar = new ArrayList<>();
            for (ValorCaracteristica existente : producto.getCaracteristicas()) {
                if (!nuevasCaracteristicas.contains(existente)) {
                    caracteristicasAEliminar.add(existente);
                }
            }
            caracteristicasAEliminar.forEach(producto::removeCaracteristica);

            for (ValorCaracteristica nueva : nuevasCaracteristicas) {
                if (!producto.getCaracteristicas().contains(nueva)) {
                    producto.addCaracteristica(nueva);
                }
            }

            producto = productoRepositorio.save(producto);

            return convertirProductoADTO(producto);
        } else {
            return null;
        }
    }
    
    @Transactional
    public ProductoDTO agregarCaracteristicasAProducto(Integer idProducto, List<Integer> idsCaracteristicas) {
        log.info("➡️ Agregando características al producto ID: {}", idProducto);
        log.info("📌 Características recibidas: {}", idsCaracteristicas);

        if (idsCaracteristicas == null || idsCaracteristicas.isEmpty()) {
            throw new IllegalArgumentException("La lista de características no puede estar vacía.");
        }

        Producto producto = productoRepositorio.findById(idProducto)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        List<ValorCaracteristica> nuevasCaracteristicas = idsCaracteristicas.stream()
                .map(id -> valorCaracteristicaRepositorio.findById(id)
                        .orElseThrow(() -> new RuntimeException("Característica con ID " + id + " no encontrada"))
                )
                .collect(Collectors.toList());

        nuevasCaracteristicas.forEach(producto::addCaracteristica);

        productoRepositorio.saveAndFlush(producto);

        return convertirProductoADTO(producto);
    }
    
    @Transactional
    public ProductoDTO eliminarCaracteristicaDeProducto(Integer idProducto, Integer idCaracteristica) {
        Producto producto = productoRepositorio.findById(idProducto)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        ValorCaracteristica caracteristica = valorCaracteristicaRepositorio.findById(idCaracteristica)
                .orElseThrow(() -> new RuntimeException("Característica no encontrada"));

        producto.getCaracteristicas().remove(caracteristica);
        productoRepositorio.save(producto);

        return convertirProductoADTO(producto);
    }

    
    public List<ProductoDTO> obtenerProductosPorCatalogo(Integer idCatalogo) {
        List<Producto> productos = productoRepositorio.findByCatalogoElectronico_IdCatalogo(idCatalogo);
        return productos.stream()
                .map(this::convertirProductoADTO)
                .collect(Collectors.toList());
    }

    public List<ProductoDTO> obtenerProductosPorMarca(Integer idMarca) {
        List<Producto> productos = productoRepositorio.findByMarca_IdMarca(idMarca);
        return productos.stream()
                .map(this::convertirProductoADTO)
                .collect(Collectors.toList());
    }
    
    public List<ProductoDTO> obtenerProductosPorCatalogoYMarca(Integer idCatalogo, Integer idMarca) {
        List<Producto> productos;
        
        if (idMarca != null) {
            productos = productoRepositorio.findByCatalogoElectronico_IdCatalogoAndMarca_IdMarca(idCatalogo, idMarca);
        } else {
            productos = productoRepositorio.findByCatalogoElectronico_IdCatalogo(idCatalogo);
        }
        
        return productos.stream()
                .map(this::convertirProductoADTO) 
                .collect(Collectors.toList());
    }


    public void eliminarProducto(Integer id) {
        productoRepositorio.deleteById(id);
    }

    private ProductoDTO convertirProductoADTO(Producto producto) {
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setIdProducto(producto.getIdProducto());
        productoDTO.setCodigoProducto(producto.getCodigoProducto());
        productoDTO.setNombreProducto(producto.getNombreProducto());
        productoDTO.setDescripcionProducto(producto.getDescripcionProducto());

        productoDTO.setCatalogoElectronico(convertirCatalogoElectronicoADTO(producto.getCatalogoElectronico()));
        productoDTO.setStock(producto.getStock());
        productoDTO.setEstado(producto.getEstado());
        productoDTO.setPrecioPlataforma(producto.getPrecioPlataforma());

        productoDTO.setMarca(convertirMarcaADTO(producto.getMarca()));

        productoDTO.setCaracteristicas(producto.getCaracteristicas().stream()
                .map(this::convertirValorCaracteristicaADTO)
                .collect(Collectors.toList()));
        return productoDTO;
    }

    private CatalogoElectronicoDTO convertirCatalogoElectronicoADTO(CatalogoElectronico catalogoElectronico) {
        CatalogoElectronicoDTO catalogoElectronicoDTO = new CatalogoElectronicoDTO();
        catalogoElectronicoDTO.setIdCatalogo(catalogoElectronico.getIdCatalogo());
        catalogoElectronicoDTO.setCodigoCatalogo(catalogoElectronico.getCodigoCatalogo());
        catalogoElectronicoDTO.setDescripcionCatalogo(catalogoElectronico.getDescripcionCatalogo());
        catalogoElectronicoDTO.setFechaCreacion(catalogoElectronico.getFechaCreacion());
        catalogoElectronicoDTO.setAcuerdoMarco(convertirAcuerdoMarcoADTO(catalogoElectronico.getAcuerdoMarco())); 
        return catalogoElectronicoDTO;
    }
    
    private AcuerdoMarcoDTO convertirAcuerdoMarcoADTO(AcuerdoMarco acuerdoMarco) {
        AcuerdoMarcoDTO acuerdoMarcoDTO = new AcuerdoMarcoDTO();
        acuerdoMarcoDTO.setIdAcuerdo(acuerdoMarco.getIdAcuerdo());
        acuerdoMarcoDTO.setCodigoAcuerdo(acuerdoMarco.getCodigoAcuerdo());
        acuerdoMarcoDTO.setNombreAcuerdo(acuerdoMarco.getNombreAcuerdo());
        acuerdoMarcoDTO.setFechaInicio(acuerdoMarco.getFechaInicio());
        acuerdoMarcoDTO.setFechaFin(acuerdoMarco.getFechaFin());
        return acuerdoMarcoDTO;
    }

    private MarcaDTO convertirMarcaADTO(Marca marca) {
        MarcaDTO marcaDTO = new MarcaDTO();
        marcaDTO.setIdMarca(marca.getIdMarca());
        marcaDTO.setNombreMarca(marca.getNombreMarca());
        marcaDTO.setDescripcion(marca.getDescripcion());
        marcaDTO.setEmpresa(convertirEmpresaADTO(marca.getEmpresa()));
        return marcaDTO;
    }
    
    private EmpresaDTO convertirEmpresaADTO(Empresa empresa) {
        EmpresaDTO empresaDTO = new EmpresaDTO();
        empresaDTO.setIdEmpresa(empresa.getIdEmpresa());
        empresaDTO.setNombreEmpresa(empresa.getNombreEmpresa());
        empresaDTO.setRuc(empresa.getRuc());
        empresaDTO.setDireccion(empresa.getDireccion());
        empresaDTO.setTelefono(empresa.getTelefono());
        empresaDTO.setEmail(empresa.getEmail());
        empresaDTO.setFechaCreacion(empresa.getFechaCreacion());
        empresaDTO.setActivo(empresa.getActivo());
        return empresaDTO;
    }

    private ValorCaracteristicaDTO convertirValorCaracteristicaADTO(ValorCaracteristica valorCaracteristica) {
        ValorCaracteristicaDTO valorCaracteristicaDTO = new ValorCaracteristicaDTO();
        valorCaracteristicaDTO.setIdValorCaracteristica(valorCaracteristica.getIdValorCaracteristica());
        valorCaracteristicaDTO.setNombreCaracteristica(valorCaracteristica.getCaracteristica().getNombreCaracteristica());
        valorCaracteristicaDTO.setValor(valorCaracteristica.getValor());
        return valorCaracteristicaDTO;
    }
}