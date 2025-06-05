package fr.codecake.airbnb_clone_back.listing.mapper;

import fr.codecake.airbnb_clone_back.listing.application.dto.sub.PictureDTO;
import fr.codecake.airbnb_clone_back.listing.domain.ListingPicture;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ListingPictureMapper {

    Set<ListingPicture> pictureDTOsToListingPictures(List<PictureDTO> pictureDTOs);

    List<PictureDTO> listingPictureToPictureDTO(List<ListingPicture> listingPictures);

    @Mapping(target = "file", source = "file")
    @Mapping(target = "fileContentType", source = "fileContentType")
    @Mapping(target = "isCover", source = "cover")
    PictureDTO convertToPictureDTO(ListingPicture listingPicture);

    @Named("extract-cover")
    default PictureDTO extractCover(Set<ListingPicture> pictures) {
        return pictures.stream().filter(ListingPicture::isCover).findFirst().map(this::convertToPictureDTO).orElseThrow();
    }
}
