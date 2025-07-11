package fr.codecake.airbnb_clone_back.listing.repository;

import fr.codecake.airbnb_clone_back.listing.application.dto.DisplayCardListingDTO;
import fr.codecake.airbnb_clone_back.listing.domain.BookingCategory;
import fr.codecake.airbnb_clone_back.listing.domain.Listing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ListingRepository extends JpaRepository<Listing, Long> {
    @Query("select listing from Listing listing left join fetch listing.pictures picture " +
            "where listing.landlordPublicId = :landlordPublicId and picture.isCover = true")
    List<Listing> findAllByLandlordPublicIdFetchCoverPicture(UUID landlordPublicId);

    long deleteByPublicIdAndLandlordPublicId(UUID publicId, UUID landlordPublicId);

    @Query("select listing from Listing listing left join fetch  listing.pictures picture " +
            "where listing.bookingCategory = :bookingCategory and picture.isCover = true")
    Page<Listing> findAllByBookingCategoryWithCoverOnly(Pageable pageable, BookingCategory bookingCategory);

    @Query("select listing from Listing listing left join fetch  listing.pictures picture " +
            "where picture.isCover = true")
    Page<Listing> findAllWithCoverOnly(Pageable pageable);

    Optional<Listing> findByPublicId(UUID publicId);

    List<Listing> findByPublicIdIn(List<UUID> allListingPublicIds);

    Optional<Listing> findOneByPublicIdAndLandlordPublicId(UUID listingPublicId, UUID landlordPublicId);

    Page<Listing> findAllByLocationAndBathroomsAndBedroomsAndGuestsAndBeds(
            Pageable pageable, String location, int bathrooms, int bedrooms, int guests, int beds
    );
}
