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
import com.acorporation.app.models.Producto;
import com.acorporation.app.models.ValorCaracteristica;
import com.acorporation.app.repositories.CatalogoElectronicoRepositorio;
import com.acorporation.app.repositories.MarcaRepositorio;
import com.acorporation.app.repositories.ProductoRepositorio;
import com.acorporation.app.repositories.ValorCaracteristicaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoServicio {

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

        // Obtener el catálogo electrónico y la marca
        Optional<CatalogoElectronico> catalogoElectronico = catalogoElectronicoRepositorio.findById(productoDTO.getCatalogoElectronico().getIdCatalogo());
        Optional<Marca> marca = marcaRepositorio.findById(productoDTO.getMarca().getIdMarca());

        catalogoElectronico.ifPresent(producto::setCatalogoElectronico);
        marca.ifPresent(producto::setMarca);

        // Guardar el producto
        producto = productoRepositorio.save(producto);

        // Guardar las características del producto
        List<ValorCaracteristica> caracteristicas = productoDTO.getCaracteristicas().stream()
                .map(ValorCaracteristicaDTO::getIdValorCaracteristica) // Obtener el ID de ValorCaracteristicaDTO
                .map(valorCaracteristicaRepositorio::findById) // Buscar ValorCaracteristica por ID
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
        // Agregar las características al producto usando el método addCaracteristica (que debes crear en la entidad Producto)
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

            // Obtener el catálogo electrónico y la marca
            Optional<CatalogoElectronico> catalogoElectronico = catalogoElectronicoRepositorio.findById(productoDTO.getCatalogoElectronico().getIdCatalogo());
            Optional<Marca> marca = marcaRepositorio.findById(productoDTO.getMarca().getIdMarca());

            catalogoElectronico.ifPresent(producto::setCatalogoElectronico);
            marca.ifPresent(producto::setMarca);

            // Obtener las características enviadas en la actualización
            List<ValorCaracteristica> nuevasCaracteristicas = productoDTO.getCaracteristicas().stream()
                    .map(ValorCaracteristicaDTO::getIdValorCaracteristica)
                    .map(valorCaracteristicaRepositorio::findById)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());

            // Eliminar características que ya no están en la lista enviada
            List<ValorCaracteristica> caracteristicasAEliminar = new ArrayList<>();
            for (ValorCaracteristica existente : producto.getCaracteristicas()) {
                if (!nuevasCaracteristicas.contains(existente)) {
                    caracteristicasAEliminar.add(existente);
                }
            }
            caracteristicasAEliminar.forEach(producto::removeCaracteristica);

            // Agregar nuevas características si no están en la lista actual
            for (ValorCaracteristica nueva : nuevasCaracteristicas) {
                if (!producto.getCaracteristicas().contains(nueva)) {
                    producto.addCaracteristica(nueva);
                }
            }

            // Guardar el producto con las actualizaciones
            producto = productoRepositorio.save(producto);

            return convertirProductoADTO(producto);
        } else {
            return null; // O lanzar una excepción
        }
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
        // Mapear el catálogo electrónico al DTO
        productoDTO.setCatalogoElectronico(convertirCatalogoElectronicoADTO(producto.getCatalogoElectronico()));
        productoDTO.setStock(producto.getStock());
        productoDTO.setEstado(producto.getEstado());
        productoDTO.setPrecioPlataforma(producto.getPrecioPlataforma());
        // Mapear la marca al DTO
        productoDTO.setMarca(convertirMarcaADTO(producto.getMarca()));
        // Mapear las características al DTO
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
        valorCaracteristicaDTO.setNombreCaracteristica(valorCaracteristica.getCaracteristica().getNombreCaracteristica()); // Obtener el nombre de la característica
        valorCaracteristicaDTO.setValor(valorCaracteristica.getValor());
        return valorCaracteristicaDTO;
    }
}