package com.example.demo.Service;
import com.example.demo.entity.Sincronizacion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SincronizacionService {
    public List<Sincronizacion> listAllSincroniz();

    public Sincronizacion getSincroniz(Integer id);

    public Sincronizacion createSincroniz(Sincronizacion sincronizacion);

    public Sincronizacion updateSincroniz(Sincronizacion sincronizacion);

    public Sincronizacion deleteSincroniz(Integer id);

    Sincronizacion buscarPorEstado(String estado);

}
