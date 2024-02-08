package com.petLovers.errors.pet;

public class PetOwnershipException extends RuntimeException {
    public PetOwnershipException(String message) {
        super(message);
    }
}
