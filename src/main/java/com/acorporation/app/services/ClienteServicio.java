package com.acorporation.app.services;

import com.acorporation.app.dto.ClienteDTO;
import com.acorporation.app.models.Cliente;
import com.acorporation.app.repositories.ClienteRepositorio;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.acorporation.app.enums.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public List<ClienteDTO> obtenerTodosLosClientes() {
        return clienteRepositorio.findAll().stream()
                .map(this::convertirClienteADTO)
                .collect(Collectors.toList());
    }

    public ClienteDTO obtenerClientePorId(Integer id) {
        Cliente cliente = clienteRepositorio.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con ID: " + id));
        return convertirClienteADTO(cliente);
    }

    public ClienteDTO crearCliente(ClienteDTO clienteDTO) {
        Cliente cliente = convertirDTOACliente(clienteDTO);
        cliente = clienteRepositorio.save(cliente);
        return convertirClienteADTO(cliente);
    }

    public ClienteDTO actualizarCliente(Integer id, ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepositorio.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con ID: " + id));

        cliente.setRuc(Optional.ofNullable(clienteDTO.getRuc()).orElse(cliente.getRuc()));
        cliente.setRazonSocial(Optional.ofNullable(clienteDTO.getRazonSocial()).orElse(cliente.getRazonSocial()));
        cliente.setDireccion(Optional.ofNullable(clienteDTO.getDireccion()).orElse(cliente.getDireccion()));
        cliente.setCelular(Optional.ofNullable(clienteDTO.getCelular()).orElse(cliente.getCelular()));
        cliente.setCorreo(Optional.ofNullable(clienteDTO.getCorreo()).orElse(cliente.getCorreo()));
        cliente.setContacto(Optional.ofNullable(clienteDTO.getContacto()).orElse(cliente.getContacto()));
        cliente.setObservaciones(Optional.ofNullable(clienteDTO.getObservaciones()).orElse(cliente.getObservaciones()));
        cliente.setActivo(Optional.ofNullable(clienteDTO.getActivo()).orElse(cliente.getActivo()));
        cliente.setUnidadEjecutora(Optional.ofNullable(clienteDTO.getUnidadEjecutora()).orElse(cliente.getUnidadEjecutora()));
        cliente.setEncargadoAlmacenEntidad(Optional.ofNullable(clienteDTO.getEncargadoAlmacenEntidad()).orElse(cliente.getEncargadoAlmacenEntidad()));
        cliente.setContactoRecogidaPedido(Optional.ofNullable(clienteDTO.getContactoRecogidaPedido()).orElse(cliente.getContactoRecogidaPedido()));

        if (clienteDTO.getTipo() != null) {
            cliente.setTipo(TipoCliente.valueOf(clienteDTO.getTipo()));
        }

        cliente = clienteRepositorio.save(cliente);
        return convertirClienteADTO(cliente);
    }

    public void eliminarCliente(Integer id) {
        if (!clienteRepositorio.existsById(id)) {
            throw new EntityNotFoundException("Cliente no encontrado con ID: " + id);
        }
        clienteRepositorio.deleteById(id);
    }

    private ClienteDTO convertirClienteADTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setIdCliente(cliente.getIdCliente());
        clienteDTO.setRuc(cliente.getRuc());
        clienteDTO.setRazonSocial(cliente.getRazonSocial());
        clienteDTO.setDireccion(cliente.getDireccion());
        clienteDTO.setCelular(cliente.getCelular());
        clienteDTO.setCorreo(cliente.getCorreo());
        clienteDTO.setContacto(cliente.getContacto());
        clienteDTO.setObservaciones(cliente.getObservaciones());
        clienteDTO.setFechaCreacion(cliente.getFechaCreacion());
        clienteDTO.setActivo(cliente.getActivo());
        clienteDTO.setTipo(cliente.getTipo().name());
        clienteDTO.setUnidadEjecutora(cliente.getUnidadEjecutora());
        clienteDTO.setEncargadoAlmacenEntidad(cliente.getEncargadoAlmacenEntidad());
        clienteDTO.setContactoRecogidaPedido(cliente.getContactoRecogidaPedido());
        return clienteDTO;
    }

    private Cliente convertirDTOACliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setRuc(clienteDTO.getRuc());
        cliente.setRazonSocial(clienteDTO.getRazonSocial());
        cliente.setDireccion(clienteDTO.getDireccion());
        cliente.setCelular(clienteDTO.getCelular());
        cliente.setCorreo(clienteDTO.getCorreo());
        cliente.setContacto(clienteDTO.getContacto());
        cliente.setObservaciones(clienteDTO.getObservaciones());
        cliente.setFechaCreacion(new Date());
        cliente.setActivo(clienteDTO.getActivo());
        cliente.setTipo(TipoCliente.valueOf(clienteDTO.getTipo()));
        cliente.setUnidadEjecutora(clienteDTO.getUnidadEjecutora());
        cliente.setEncargadoAlmacenEntidad(clienteDTO.getEncargadoAlmacenEntidad());
        cliente.setContactoRecogidaPedido(clienteDTO.getContactoRecogidaPedido());
        return cliente;
    }
}