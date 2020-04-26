'use strict';

import * as jQuery from '/scripts/jquery/dist/jquery.min.js';
import * as underscore from '/scripts/underscore/underscore-min.js';
import * as datingUrl from '/scripts/url.js';

const loadProfiles = function() {
    const profileTempl = _.template('<div class="main__profile">' +
        '            <div class="main__profile-img-container">' +
        '                <img src="<%= imageUrl %>" class="main__profile-item-img" alt="profile image" />' +
        '                <div class="main__profile-item-characteristic-container">' +
        '                    <h2 class="main__profile-item-header"><%= name %></h2>' +
        '                    <div class="main__profile-characteristic-item">Gender: <%= gender %></div>' +
        '                    <div class="main__profile-characteristic-item">Height: <%= height %> cm</div>' +
        '                    <div class="main__profile-characteristic-item">Weight: <%= weight %> kg</div>' +
        '                    <div class="main__profile-characteristic-item">Breed: <%= breed %></div>' +
        '                </div>' +
        '            </div>' +
        '            <div class="main__profile-item-description"><%= description %></div>' +
        '        </div>');

    $.get(datingUrl.getBaseUrl() + 'api/profiles/').done(function (profiles) {
        const $profileListDiv = $('#profileListDiv');
        profiles.forEach(function (profile) {
            const $profile = $(profileTempl({
                name: profile.name,
                gender: profile.gender,
                height: profile.height,
                weight: profile.weight,
                imageUrl: profile.image,
                breed: profile.breed,
                description: profile.description
            }));
            $profileListDiv.append($profile);
        });
    });
};

$(document).ready(function() {
    loadProfiles();
});