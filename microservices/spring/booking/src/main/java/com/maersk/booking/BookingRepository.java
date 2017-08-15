package com.maersk.booking;

import org.springframework.data.repository.CrudRepository;

import com.maersk.booking.Booking;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface BookingRepository extends CrudRepository<Booking, Long> {

}
