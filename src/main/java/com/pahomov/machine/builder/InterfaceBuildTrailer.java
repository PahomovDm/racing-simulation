package com.pahomov.machine.builder;

import com.pahomov.machine.Trailer;

public interface InterfaceBuildTrailer {
    InterfaceBuildTrailer name();

    InterfaceBuildTrailer massa();

    InterfaceBuildTrailer maxSpeed();

    Trailer build();
}

