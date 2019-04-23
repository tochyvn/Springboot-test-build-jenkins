package com.capgemini.overview.exception;

public class VehiculeNotFoundException extends RuntimeException {
    public VehiculeNotFoundException() {
        super("Vehicule not found.");
    }
}
