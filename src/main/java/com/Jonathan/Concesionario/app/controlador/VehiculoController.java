package com.Jonathan.Concesionario.app.controlador;

import com.Jonathan.Concesionario.app.dto.VehiculoDto;
import com.Jonathan.Concesionario.app.negocio.VehiculoNegocio;
import com.Jonathan.Concesionario.app.servicio.VehiculoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/Vehiculo")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.HEAD})

public class VehiculoController {

    @Autowired
    private VehiculoNegocio vehiculoNegocio;

    @Autowired
    private VehiculoServicio vehiculoServicio;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> all(){

        List<VehiculoDto> listaVehiculo=this.vehiculoNegocio.encontrarTodos();
        Map<String,Object> res=new HashMap<>();
        res.put("status","ok");
        res.put("data",listaVehiculo);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> crearVehiculo(@RequestBody Map<String,Object> request){
        Map<String,Object> res=new HashMap<>();
        try {
            VehiculoDto vehiculoDto = new VehiculoDto();

            vehiculoDto.setId(0);
            vehiculoDto.setTipoVehiculo(request.get("tipoVehiculo").toString());
            vehiculoDto.setModelo(Integer.parseInt(request.get("modelo").toString()));
            vehiculoDto.setCentCubicos(Integer.parseInt(request.get("centCubicos").toString()));
            vehiculoDto.setPlaca(request.get("placa").toString());
            vehiculoDto.setPrecio(Integer.parseInt(request.get("precio").toString()));
            vehiculoDto.setMarca(request.get("marca").toString());
            vehiculoDto.setColor(request.get("color").toString());

            String resp = this.vehiculoNegocio.guardarVehiculo(vehiculoDto);
            res.put("status","ok");
            res.put("code","200");
            res.put("data",resp);

        }catch(Exception e){
            res.put("status",HttpStatus.INTERNAL_SERVER_ERROR);
            res.put("code","500");
            res.put("data",e.getMessage());
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/Actualizar")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> actualizarVehiculo(@RequestBody Map<String,Object> request){
        Map<String,Object> res=new HashMap<>();
        VehiculoDto vehiculoDto = new VehiculoDto();

        vehiculoDto.setId(Integer.parseInt(request.get("id").toString()));
        vehiculoDto.setTipoVehiculo(request.get("tipoVehiculo").toString());
        vehiculoDto.setModelo(Integer.parseInt(request.get("modelo").toString()));
        vehiculoDto.setCentCubicos(Integer.parseInt(request.get("centCubicos").toString()));
        vehiculoDto.setPlaca(request.get("placa").toString());
        vehiculoDto.setPrecio(Integer.parseInt(request.get("precio").toString()));
        vehiculoDto.setMarca(request.get("marca").toString());
        vehiculoDto.setColor(request.get("color").toString());

        String resp = this.vehiculoNegocio.guardarVehiculo(vehiculoDto);
        res.put("status","ok");
        res.put("data",resp);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/eliminar/{id}")
    public  ResponseEntity<Map<String,Object>> eliminarVehiculo(@PathVariable int id){
        Map<String,Object> res=new HashMap<>();
        try {
            String resp=this.vehiculoNegocio.eliminarVehiculo(id);
            res.put("status","ok");
            res.put("code","200");
            res.put("data",resp);

        }catch(Exception e){
            res.put("status",HttpStatus.INTERNAL_SERVER_ERROR);
            res.put("code","500");
            res.put("data",e.getMessage());
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
