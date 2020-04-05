'use strict';

import * as jQuery from '/scripts/jquery/dist/jquery.min.js';
import * as underscore from "/scripts/underscore/underscore-min.js";

const getBaseUrl = function() {
    const reg = new RegExp(/^.*\//);
    return reg.exec(window.location.href);
};

export {
    getBaseUrl
}