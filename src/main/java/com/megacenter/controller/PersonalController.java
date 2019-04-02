package com.megacenter.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.megacenter.exception.ModeloNotFoundException;
import com.megacenter.model.Persona;
import com.megacenter.model.Personal;
import com.megacenter.representation.PersonalRepresentation;
import com.megacenter.service.IPersonaService;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.megacenter.service.IPersonalService;
import java.io.IOException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@RestController
@RequestMapping(value = "/api/personales")
public class PersonalController {

    @Autowired 
    private ServletContext context ;
	
    @Autowired
    private IPersonalService service ;

    @Autowired
    private IPersonaService personaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Personal>> listar() {
        List<Personal> colaborador = new ArrayList<>();
        
        
        String filePath = context.getRealPath("/images/");
        File file = new File(filePath);
        List<Personal> temp= new ArrayList<>();
        
       colaborador = temp ;
        try {
            colaborador = service.listar();
            for (Personal dato : colaborador) {
            dato.setFoto(filePath+dato.getFoto());
            
        }
        } catch (Exception e) {
            return new ResponseEntity<List<Personal>>(colaborador , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Personal>>(colaborador , HttpStatus.OK);
    }

    @GetMapping(value="/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<Personal> listarId(@PathVariable Integer id){
    	
        Personal colaborador = new Personal();
        colaborador = service.listarId(id);
        
        String filePath = context.getRealPath("/images/");
        colaborador.setEstado(filePath+colaborador.getFoto());
        if (colaborador == null) {
            throw new ModeloNotFoundException("ID: " + id);
        }
        Resource<Personal> resource = new Resource<Personal>(colaborador);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listar());
        resource.add(linkTo.withRel("all_Personal"));

        return resource;
    }

    @PostMapping(value="/registrar" , consumes = MediaType.ALL_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registrar(@RequestParam("file") MultipartFile file ,@RequestParam("rep") String rep) throws IOException , JsonParseException , JsonMappingException  {
        
         ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES); 
 
        PersonalRepresentation personalRep = mapper.reader().forType(PersonalRepresentation.class).readValue(rep);//esto comvierte el text en un array
        if(file != null) {
    		boolean isExist = new File(context.getRealPath("/images/")).exists();
        	if (!isExist) {
    			new File(context.getRealPath("/images/")).mkdir();
    		}
        	
        	String filename = file.getOriginalFilename();
        	String modifiFieldName = FilenameUtils.getBaseName(filename)+"_" + System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);
        	File servefile = new File(context.getRealPath("/images/"+File.separator+modifiFieldName));
        	personalRep.getPersonal().setFoto(servefile.getName());
                try {
    			FileUtils.writeByteArrayToFile(servefile, file.getBytes());
    		} catch (Exception e) {
    			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
    		}
        	
    	}
        
    	Persona persona = personaService.registrar(personalRep.getPersona());
    	personalRep.getPersonal().setPersona(persona);
        
        
    	Personal personal = service.registrar(personalRep.getPersonal());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(personal.getIdPersonal()).toUri();
       
        return ResponseEntity.created(location).build();
        
    }

    @PutMapping(value="/actualizar" , consumes = MediaType.ALL_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@RequestParam("file") MultipartFile file ,@RequestParam("rep") String rep) throws IOException, JsonParseException , JsonMappingException {
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        
        PersonalRepresentation personalRep = mapper.reader().forType(PersonalRepresentation.class).readValue(rep);
        
        String filePath = context.getRealPath("/images/");
        File fileDelete = FileUtils.getFile( filePath ,service.listarId(personalRep.getPersonal().getIdPersonal()).getFoto());
        fileDelete.delete();
        
        if(file != null) {
    		boolean isExist = new File(context.getRealPath("/images/")).exists();
        	if (!isExist) {
    			new File(context.getRealPath("/images/")).mkdir();
    		}
        	
        	String filename = file.getOriginalFilename();
        	String modifiFieldName = FilenameUtils.getBaseName(filename)+"_" + System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);
        	File servefile = new File(context.getRealPath("/images/"+File.separator+modifiFieldName));
        	personalRep.getPersonal().setFoto(servefile.getName());
                try {
    			FileUtils.writeByteArrayToFile(servefile, file.getBytes());
    		} catch (Exception e) {
    			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
    		}
        	
    	}
        Persona persona = personaService.modificar(personalRep.getPersona());
        personalRep.getPersonal().setPersona(persona);
        Personal personal = service.modificar(personalRep.getPersonal());
        return new ResponseEntity<Object>(HttpStatus.OK);

    }

    @DeleteMapping(value = "/eliminar/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable Integer id){
        Personal colaborador = service.listarId(id);
        if (colaborador == null) {
            throw new ModeloNotFoundException("ID: " + id);
        } else {
            String filePath = context.getRealPath("/images/");
            File file = FileUtils.getFile( filePath ,colaborador.getFoto());
            file.delete();
            service.eliminar(id);
        }
    }
}
