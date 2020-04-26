package com.dbapresents.datingplatform.profile;

import com.dbapresents.datingplatform.breed.BreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final BreedRepository breedRepository;

    @Autowired
    private ProfileService(ProfileRepository profileRepository, BreedRepository breedRepository) {
        this.profileRepository = profileRepository;
        this.breedRepository = breedRepository;
    }

    public void addProfile(NewProfileRequest newProfileRequest) {
        Profile profile = new Profile();
        profile.setName(newProfileRequest.getName());
        profile.setHeight(newProfileRequest.getHeight());
        profile.setWeight(newProfileRequest.getWeight());
        profile.setDescription(newProfileRequest.getDescription());
        profile.setImageUrl("/img/sample.jpg");
        if (newProfileRequest.getBreedId() != null) {
            profile.setBreed(breedRepository.findById(newProfileRequest.getBreedId())
                    .orElse(null));
        }
        profile.setGender(newProfileRequest.getGender());
        profileRepository.save(profile);
    }

}
