package com.Jonathan.Concesionario.app.controlador;

import com.Jonathan.Concesionario.app.dto.VentaDto;
import com.Jonathan.Concesionario.app.negocio.VentaNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/Venta")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.HEAD})

public class VentaController {
    @Autowired
    private VentaNegocio ventaNegocio;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> all(){

        List<VentaDto> listaVentas=this.ventaNegocio.encontrarTodos();
        Map<String,Object> res=new HashMap<>();
        res.put("status","ok");
        res.put("data",listaVentas);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> crearVenta(@RequestBody Map<String,Object> request){
        Map<String,Object> res=new HashMap<>();
        VentaDto ventaDto = new VentaDto();

        ventaDto.setId(0);
        ventaDto.setFecha(request.get("fecha").toString());
        ventaDto.setMetPago(request.get("metPago").toString());
        ventaDto.setTotalVenta(Integer.parseInt(request.get("totalVenta").toString()));
        ventaDto.setNomCliente(request.get("nomCliente").toString());
        ventaDto.setApellCliente(request.get("apellCliente").toString());
        ventaDto.setNomEmpleado(request.get("nomEmpleado").toString());
        ventaDto.setApellEmpleado(request.get("apellEmpleado").toString());
        ventaDto.setPrecio(Integer.parseInt(request.get("precio").toString()));
        ventaDto.setColor(request.get("color").toString());

        String resp = this.ventaNegocio.guardarVenta(ventaDto);
        res.put("status","ok");
        res.put("data",resp);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/Actualizar")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> actualizarVenta(@RequestBody Map<String,Object> request){
        Map<String,Object> res=new HashMap<>();
        VentaDto ventaDto = new VentaDto();

        ventaDto.setId(Integer.parseInt(request.get("id").toString()));
        ventaDto.setFecha(request.get("fecha").toString());
        ventaDto.setMetPago(request.get("metPago").toString());
        ventaDto.setTotalVenta(Integer.parseInt(request.get("totalVenta").toString()));
        ventaDto.setNomCliente(request.get("nomCliente").toString());
        ventaDto.setApellCliente(request.get("apellCliente").toString());
        ventaDto.setNomEmpleado(request.get("nomEmpleado").toString());
        ventaDto.setApellEmpleado(request.get("apellEmpleado").toString());
        ventaDto.setPrecio(Integer.parseInt(request.get("precio").toString()));
        ventaDto.setColor(request.get("color").toString());
        String resp = this.ventaNegocio.guardarVenta(ventaDto);
        res.put("status","ok");
        res.put("data",resp);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
