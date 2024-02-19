package com.example.demo.Service.impl;

import com.example.demo.entity.Sincronizacion;
import com.example.demo.repository.SincronizacionRepository;
import com.example.demo.Service.SincronizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SincrzServiceImpl implements SincronizacionService {

    @Autowired
    private SincronizacionRepository sincronizacionRepository;
    @Override
    public List<Sincronizacion> listAllSincroniz() {
        return sincronizacionRepository.findAll();
    }

    @Override
    public Sincronizacion getSincroniz(Integer id) {
        return sincronizacionRepository.findById(id).orElse(null);
    }

    @Override
    public Sincronizacion createSincroniz(Sincronizacion sincronizacion) {
        sincronizacion.setEstado("ACTUALIZADO");
        return null;
    }

    @Override
    public Sincronizacion updateSincroniz(Sincronizacion sincronizacion) {
        Sincronizacion sincronizDB = getSincroniz(sincronizacion.getId());

        if (null == sincronizDB){
            return null;
        }
        sincronizDB.setEstado(sincronizacion.getEstado());
        sincronizDB.setFecha(sincronizacion.getFecha());
        sincronizDB.setProducto(sincronizacion.getProducto());
        return sincronizacionRepository.save(sincronizDB);
    }

    @Override
    public Sincronizacion deleteSincroniz(Integer id) {
        Sincronizacion sincronizDB = getSincroniz(id);
        if (null == sincronizDB){
            return null;
        }
        sincronizDB.setEstado("DELETED");
            return sincronizacionRepository.save(sincronizDB);
    }
    @Override
    public Sincronizacion buscarPorEstado(String estado) {
        return sincronizacionRepository.findByEstado(estado);
    }
}
