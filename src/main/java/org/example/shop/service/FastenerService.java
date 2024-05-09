package org.example.shop.service;

import org.example.shop.model.Fastener;

public interface FastenerService {
    boolean save (Fastener fastener);

    Fastener findById(Long id);
}
