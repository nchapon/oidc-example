require('bootstrap/dist/css/bootstrap.min.css');
require('./css/main.css');

import Vue from 'vue';
import axios from 'axios';

// Axios Config
const HTTP= axios.create({
    baseURL:"http://localhost:8000/oidc-secure"
})





new Vue({
    el: '#app',

    data: {
        message: "",
        error:false
    },
    methods: {
        callPublic: function(event){
            HTTP.get('public')
                .then(response => {
                    // JSON responses are automatically parsed.
                    this.message = response.data
                    this.error=false
                })
                .catch(e => {
                    this.message="Error"
                    this.error=true
                    console.log(e)
                })
        },
        callSecured: function(event){
            HTTP.get('secured')
                .then(response => {
                    // JSON responses are automatically parsed.
                    this.message = response.data
                    this.error=false
                })
                .catch(e => {
                    this.message="Error"
                    this.error=true
                    console.log(e)
                })
        },
        callAdmin: function(event){
            HTTP.get('admin')
                .then(response => {
                    // JSON responses are automatically parsed.
                    this.message = response.data
                    this.error=false
                })
                .catch(e => {
                    this.message="Error"
                    this.error=true
                    console.log(e)
                })
        }
    }

});
