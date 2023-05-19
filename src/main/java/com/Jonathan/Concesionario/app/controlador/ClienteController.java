package com.Jonathan.Concesionario.app.controlador;

import com.Jonathan.Concesionario.app.dto.ClienteDto;
import com.Jonathan.Concesionario.app.negocio.ClienteNegocio;
import com.Jonathan.Concesionario.app.servicio.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/Cliente")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.HEAD})

public class ClienteController {

    @Autowired
    private ClienteNegocio clienteNegocio;

    @Autowired
    private ClienteServicio clienteServicio;

   @GetMapping("/all")
   @ResponseBody
    public ResponseEntity<Map<String,Object>> all(){

        List<ClienteDto> listaClientes=this.clienteNegocio.encontrarTodos();
        Map<String,Object> res=new HashMap<>();
        res.put("status","ok");
        res.put("data",listaClientes);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/crear")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> crearCliente(@RequestBody Map<String,Object> request){
        Map<String,Object> res=new HashMap<>();
        try {
            ClienteDto clienteDto = new ClienteDto();

            clienteDto.setId(0);
            clienteDto.setNombres(request.get("nombres").toString());
            clienteDto.setApellidos(request.get("apellidos").toString());
            clienteDto.setTelefono(Integer.parseInt(request.get("telefono").toString()));
            clienteDto.setCorreo(request.get("correo").toString());

            String resp = this.clienteNegocio.guardarCliente(clienteDto);
            res.put("status","ok");
            res.put("code","200");
            res.put("data",resp);

        }catch(Exception e){
            res.put("status","ok");
            res.put("code","500");
            res.put("data",e.getMessage());
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/Actualizar")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> actualizarCliente(@RequestBody Map<String,Object> request){
        Map<String,Object> res=new HashMap<>();
        ClienteDto clienteDto = new ClienteDto();

        clienteDto.setId(Integer.parseInt(request.get("id").toString()));
        clienteDto.setNombres(request.get("nombres").toString());
        clienteDto.setApellidos(request.get("apellidos").toString());
        clienteDto.setTelefono(Integer.parseInt(request.get("telefono").toString()));
        clienteDto.setCorreo(request.get("correo").toString());
        String resp = this.clienteNegocio.guardarCliente(clienteDto);
        res.put("status","ok");
        res.put("data",resp);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/eliminar/{id}")
    public  ResponseEntity<Map<String,Object>> eliminarCliente(@PathVariable int id){
        Map<String,Object> res=new HashMap<>();
        try {
            String resp=this.clienteNegocio.eliminarCliente(id);
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
