package fr.codecake.airbnb_clone_back.booking.repository;

import fr.codecake.airbnb_clone_back.booking.domain.Booking;
import fr.codecake.airbnb_clone_back.listing.domain.Listing;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("select case when count(booking) > 0 then true  else false end " +
            "from Booking booking where not (booking.endDate <= :startDate or booking.startDate >= :endDate) " +
            "and booking.fkListing = :fkListing")
    boolean bookingExistsAtInterval(OffsetDateTime startDate, OffsetDateTime endDate, UUID fkListing);

    List<Booking> findAllByFkListing(UUID fkListing);

    List<Booking> findAllByFkTenant(UUID fkTenant);

    int deleteBookingByFkTenantAndPublicId(UUID tenantPublicId, UUID bookingPublicId);

    int deleteBookingByPublicIdAndFkListing(UUID bookingPublicId, UUID listingPublicId);

    List<Booking> findAllByFkListingIn(List<UUID> allPropertyPublicIds);

    @Query("select booking from Booking booking where not" +
            "(booking.endDate <= :startDate or booking.startDate >= :endDate)" +
            " and booking.fkListing in :fkListings")
    List<Booking> findAllMatchWithDate(List<UUID> fkListings, OffsetDateTime startDate, OffsetDateTime endDate);
}
