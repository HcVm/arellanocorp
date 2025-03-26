package com.acorporation.app.services;

import com.acorporation.app.dto.ClienteDTO;
import com.acorporation.app.dto.CotizacionDTO;
import com.acorporation.app.dto.CotizacionProductoDTO;
import com.acorporation.app.dto.MarcaDTO;
import com.acorporation.app.dto.ProductoDTO;
import com.acorporation.app.dto.UsuarioDTO;
import com.acorporation.app.dto.ValorCaracteristicaDTO;
import com.acorporation.app.models.*;
import com.acorporation.app.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CotizacionServicio {

    @Autowired
    private CotizacionRepositorio cotizacionRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private CotizacionProductoRepositorio cotizacionProductoRepositorio;

    @Autowired
    private ProductoRepositorio productoRepositorio;

    public List<CotizacionDTO> obtenerTodasLasCotizaciones() {
        List<Cotizacion> cotizaciones = cotizacionRepositorio.findAll();
        return cotizaciones.stream()
                .map(this::convertirCotizacionADTO)
                .collect(Collectors.toList());
    }

    public CotizacionDTO obtenerCotizacionPorId(Integer id) {
        Optional<Cotizacion> cotizacion = cotizacionRepositorio.findById(id);
        return cotizacion.map(this::convertirCotizacionADTO).orElse(null);
    }

    public CotizacionDTO crearCotizacion(CotizacionDTO cotizacionDTO) {
        Cotizacion cotizacion = new Cotizacion();
        cotizacion.setFecha(new Date());
        cotizacion.setEstado(cotizacionDTO.getEstado());
        cotizacion.setObservaciones(cotizacionDTO.getObservaciones());

        Optional<Usuario> usuario = usuarioRepositorio.findById(cotizacionDTO.getUsuario().getIdUsuario());
        usuario.ifPresent(cotizacion::setUsuarioVenta);

        Optional<Cliente> cliente = clienteRepositorio.findById(cotizacionDTO.getCliente().getIdCliente());
        cliente.ifPresent(cotizacion::setCliente);

        cotizacion = cotizacionRepositorio.save(cotizacion);

        // Guardar los productos de la cotización
        for (CotizacionProductoDTO cotizacionProductoDTO : cotizacionDTO.getProductos()) {
            CotizacionProducto cotizacionProducto = new CotizacionProducto();
            cotizacionProducto.setCotizacion(cotizacion);
            cotizacionProducto.setCantidad(cotizacionProductoDTO.getCantidad());
            cotizacionProducto.setDescripcion(cotizacionProductoDTO.getDescripcion());
            cotizacionProducto.setUnidad(cotizacionProductoDTO.getUnidad());

            Optional<Producto> producto = productoRepositorio.findById(cotizacionProductoDTO.getProducto().getIdProducto());
            producto.ifPresent(cotizacionProducto::setProducto);

            cotizacionProducto.setImporteUnitario(cotizacionProductoDTO.getImporteUnitario());
            cotizacionProducto.setImporteTotal(cotizacionProductoDTO.getImporteTotal());

            cotizacionProductoRepositorio.save(cotizacionProducto);
        }

        return convertirCotizacionADTO(cotizacion);
    }

    public CotizacionDTO actualizarCotizacion(Integer id, CotizacionDTO cotizacionDTO) {
        Optional<Cotizacion> cotizacionOptional = cotizacionRepositorio.findById(id);
        if (cotizacionOptional.isPresent()) {
            Cotizacion cotizacion = cotizacionOptional.get();
            cotizacion.setEstado(cotizacionDTO.getEstado());
            cotizacion.setObservaciones(cotizacionDTO.getObservaciones());

            Optional<Usuario> usuario = usuarioRepositorio.findById(cotizacionDTO.getUsuario().getIdUsuario());
            usuario.ifPresent(cotizacion::setUsuarioVenta);

            Optional<Cliente> cliente = clienteRepositorio.findById(cotizacionDTO.getCliente().getIdCliente());
            cliente.ifPresent(cotizacion::setCliente);

            cotizacion = cotizacionRepositorio.save(cotizacion);
            return convertirCotizacionADTO(cotizacion);
        } else {
            return null; // O lanzar una excepción
        }
    }

    public void eliminarCotizacion(Integer id) {
        cotizacionRepositorio.deleteById(id);
    }

    private CotizacionDTO convertirCotizacionADTO(Cotizacion cotizacion) {
        CotizacionDTO cotizacionDTO = new CotizacionDTO();
        cotizacionDTO.setIdCotizacion(cotizacion.getIdCotizacion());
        cotizacionDTO.setFecha(cotizacion.getFecha());
        cotizacionDTO.setEstado(cotizacion.getEstado());
        cotizacionDTO.setObservaciones(cotizacion.getObservaciones());

        // Mapear el usuario al DTO
        if (cotizacion.getUsuarioVenta() != null) {
            cotizacionDTO.setUsuario(convertirUsuarioADTO(cotizacion.getUsuarioVenta()));
        }

        // Mapear el cliente al DTO
        if (cotizacion.getCliente() != null) {
            cotizacionDTO.setCliente(convertirClienteADTO(cotizacion.getCliente()));
        }

        // Mapear los productos de la cotización al DTO
        if (cotizacion.getProductos() != null) {
            cotizacionDTO.setProductos(cotizacion.getProductos().stream()
                    .map(this::convertirCotizacionProductoADTO)
                    .collect(Collectors.toList()));
        }

        return cotizacionDTO;
    }

    private UsuarioDTO convertirUsuarioADTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setIdUsuario(usuario.getIdUsuario());
        usuarioDTO.setIdUsuario(usuario.getIdUsuario());
        usuarioDTO.setNombreUsuario(usuario.getNombreUsuario());
        usuarioDTO.setNombreCompleto(usuario.getNombreCompleto());
        usuarioDTO.setEmail(usuario.getEmail());
        return usuarioDTO;
    }

    private ClienteDTO convertirClienteADTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setIdCliente(cliente.getIdCliente());
        clienteDTO.setIdCliente(cliente.getIdCliente());
        clienteDTO.setRazonSocial(cliente.getRazonSocial());
        clienteDTO.setRuc(cliente.getRuc());
        clienteDTO.setDireccion(cliente.getDireccion());
        return clienteDTO;
    }

    private CotizacionProductoDTO convertirCotizacionProductoADTO(CotizacionProducto cotizacionProducto) {
        CotizacionProductoDTO cotizacionProductoDTO = new CotizacionProductoDTO();
        cotizacionProductoDTO.setIdCotizacionProducto(cotizacionProducto.getIdCotizacionProducto());
        cotizacionProductoDTO.setCantidad(cotizacionProducto.getCantidad());
        cotizacionProductoDTO.setDescripcion(cotizacionProducto.getDescripcion());
        cotizacionProductoDTO.setUnidad(cotizacionProducto.getUnidad());

        // Mapear el producto al DTO
        if (cotizacionProducto.getProducto() != null) {
            cotizacionProductoDTO.setProducto(convertirProductoADTO(cotizacionProducto.getProducto()));
        }

        cotizacionProductoDTO.setImporteUnitario(cotizacionProducto.getImporteUnitario());
        cotizacionProductoDTO.setImporteTotal(cotizacionProducto.getImporteTotal());

        return cotizacionProductoDTO;
    }

    private ProductoDTO convertirProductoADTO(Producto producto) {
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setIdProducto(producto.getIdProducto());
        productoDTO.setNombreProducto(producto.getNombreProducto());
        productoDTO.setDescripcionProducto(producto.getDescripcionProducto());
        productoDTO.setCodigoProducto(producto.getCodigoProducto());
        productoDTO.setPrecioPlataforma(producto.getPrecioPlataforma());

        // Mapear la marca si existe
        if (producto.getMarca() != null) {
            productoDTO.setMarca(convertirMarcaADTO(producto.getMarca()));
        }

        // ✅ Mapear las características del producto
        if (producto.getCaracteristicas() != null) {
            List<ValorCaracteristicaDTO> caracteristicasDTO = producto.getCaracteristicas().stream()
                .map(this::convertirValorCaracteristicaADTO)
                .collect(Collectors.toList());
            productoDTO.setCaracteristicas(caracteristicasDTO);
        }

        return productoDTO;
    }
    
    private ValorCaracteristicaDTO convertirValorCaracteristicaADTO(ValorCaracteristica valorCaracteristica) {
        ValorCaracteristicaDTO dto = new ValorCaracteristicaDTO();
        dto.setIdValorCaracteristica(valorCaracteristica.getIdValorCaracteristica());
        dto.setValor(valorCaracteristica.getValor());

        if (valorCaracteristica.getCaracteristica() != null) {
            dto.setIdCaracteristica(valorCaracteristica.getCaracteristica().getIdCaracteristica());
            dto.setNombreCaracteristica(valorCaracteristica.getCaracteristica().getNombreCaracteristica());
        }

        return dto;
    }
    
    private MarcaDTO convertirMarcaADTO(Marca marca) {
        MarcaDTO marcaDTO = new MarcaDTO();
        marcaDTO.setIdMarca(marca.getIdMarca());
        marcaDTO.setNombreMarca(marca.getNombreMarca());
        return marcaDTO;
    }
}