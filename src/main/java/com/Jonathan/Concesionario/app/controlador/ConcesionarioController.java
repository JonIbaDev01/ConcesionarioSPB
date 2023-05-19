package com.Jonathan.Concesionario.app.controlador;


import com.Jonathan.Concesionario.app.dto.ConcesionarioDto;
import com.Jonathan.Concesionario.app.negocio.ConcesionarioNegocio;
import com.Jonathan.Concesionario.app.servicio.ConcesionarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/Concesionario")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})

public class ConcesionarioController {
    @Autowired
    private ConcesionarioNegocio concesionarioNegocio;

    @Autowired
    private ConcesionarioServicio concesionarioServicio;


    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> all(){
        List<ConcesionarioDto> listaConcesionario= this.concesionarioNegocio.encontrarTodos();

        Map<String,Object> res=new HashMap<>();
        res.put("status","ok");
        res.put("data",listaConcesionario);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> crearCliente(@RequestBody Map<String,Object> request){
        Map<String,Object> res=new HashMap<>();
        try{
            ConcesionarioDto concesionarioDto= new ConcesionarioDto();

            concesionarioDto.setId(0);
            concesionarioDto.setNombre(request.get("nombre").toString());
            concesionarioDto.setDireccion(request.get("direccion").toString());
            concesionarioDto.setTelefono(Integer.parseInt(request.get("telefono").toString()));
            String resp = this.concesionarioNegocio.guardarConcesionario(concesionarioDto);
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
        ConcesionarioDto concesionarioDto= new ConcesionarioDto();

        concesionarioDto.setId(Integer.parseInt(request.get("id").toString()));
        concesionarioDto.setNombre(request.get("nombre").toString());
        concesionarioDto.setDireccion(request.get("direccion").toString());
        concesionarioDto.setTelefono(Integer.parseInt(request.get("telefono").toString()));
        String resp = this.concesionarioNegocio.guardarConcesionario(concesionarioDto);
        res.put("status","ok");
        res.put("data",resp);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/eliminar/{id}")
    public  ResponseEntity<Map<String,Object>> eliminarConcesionario(@PathVariable int id){
        Map<String,Object> res=new HashMap<>();
        try {
            String resp=this.concesionarioNegocio.eliminarConcesionario(id);
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
