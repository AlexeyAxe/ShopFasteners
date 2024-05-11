package org.axenov.shop.service;

import org.axenov.shop.model.Fastener;

public interface FastenerService {
    boolean save (Fastener fastener);

    Fastener findById(Long id);
}
