package com.Jonathan.Concesionario.app.controlador;

import com.Jonathan.Concesionario.app.dto.ClienteDto;
import com.Jonathan.Concesionario.app.dto.EmpleadoDto;
import com.Jonathan.Concesionario.app.entity.Empleado;
import com.Jonathan.Concesionario.app.implementacion.EmpleadoImpl;
import com.Jonathan.Concesionario.app.negocio.ClienteNegocio;
import com.Jonathan.Concesionario.app.negocio.EmpleadoNegocio;
import com.Jonathan.Concesionario.app.servicio.EmpleadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/Empleado")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
public class EmpleadoController {
    @Autowired
    private EmpleadoNegocio empleadoNegocio;

    @Autowired
    private EmpleadoServicio empleadoServicio;


    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> encontrarTodos(){
        List<EmpleadoDto> listaEmpleado= this.empleadoNegocio.encontrarTodos();
        System.out.println(listaEmpleado.toString());
        Map<String,Object> res=new HashMap<>();
        res.put("status","ok");
        res.put("data",listaEmpleado);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> crearEmpleado(@RequestBody Map<String,Object> request){
        Map<String,Object> res=new HashMap<>();
        try {
            EmpleadoDto empleadoDto = new EmpleadoDto();

            empleadoDto.setId(0);
            empleadoDto.setNombres(request.get("nombres").toString());
            empleadoDto.setApellidos(request.get("apellidos").toString());
            empleadoDto.setTelefono(Integer.parseInt(request.get("telefono").toString()));
            empleadoDto.setCorreo(request.get("correo").toString());

            String resp = this.empleadoNegocio.guardarEmpleado(empleadoDto);
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
    public ResponseEntity<Map<String,Object>> actualizarCliente(@RequestBody Map<String,Object> request){
        Map<String,Object> res=new HashMap<>();
        EmpleadoDto empleadoDto = new EmpleadoDto();

        empleadoDto.setId(Integer.parseInt(request.get("id").toString()));
        empleadoDto.setNombres(request.get("nombres").toString());
        empleadoDto.setApellidos(request.get("apellidos").toString());
        empleadoDto.setTelefono(Integer.parseInt(request.get("telefono").toString()));
        empleadoDto.setCorreo(request.get("correo").toString());
        String resp = this.empleadoNegocio.guardarEmpleado(empleadoDto);
        res.put("status","ok");
        res.put("data",resp);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/eliminar/{id}")
    public  ResponseEntity<Map<String,Object>> eliminarEmpleado(@PathVariable int id){
        Map<String,Object> res=new HashMap<>();
        try {
            String resp=this.empleadoNegocio.eliminarEmpleado(id);
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
