package fr.codecake.airbnb_clone_back.listing.application.dto;

import fr.codecake.airbnb_clone_back.listing.application.dto.vo.PriceVO;

import java.util.UUID;

public record ListingCreateBookingDTO(
        UUID listingPublicId, PriceVO price
) {
}
