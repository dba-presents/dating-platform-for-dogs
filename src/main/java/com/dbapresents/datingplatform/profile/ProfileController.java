package com.dbapresents.datingplatform.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/profile")
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    private ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity createProfile(NewProfileRequest newProfileRequest) {
        profileService.addProfile(newProfileRequest);
        return ResponseEntity.ok().build();
    }

}
