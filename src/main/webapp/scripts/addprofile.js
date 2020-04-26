'use strict';

import * as jQuery from '/scripts/jquery/dist/jquery.min.js';
import * as underscore from '/scripts/underscore/underscore-min.js';
import * as datingUrl from '/scripts/url.js';

const populateBreedSelect = function() {
    $.get(datingUrl.getBaseUrl() + 'api/breeds/').done(function (breeds) {
        const $breedId = $('#breedId');
        breeds.forEach(function (breed) {
            $breedId.append('<option value="' + breed.id + '">' + breed.name + '</option>');
        });
    });
};

$(document).ready(function() {
    populateBreedSelect();

    $('#addProfileBtn').click(function () {
        $.post(datingUrl.getBaseUrl() + 'api/profile/', {
            name: $('#name').val(),
            gender: $('#gender').val(),
            height: $('#height').val(),
            weight: $('#weight').val(),
            description: $('#description').val(),
            breedId: $('#breedId').val()
        })
            .done(function () {
                window.location.href = '/index.html';
            });
    });
});