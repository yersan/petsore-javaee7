/**
 * Created by yeraysb on 9/5/16.
 */
var home = home || {};

$(function () {

    home.Category = function () {
        this.id = ko.observable();
        this.name = ko.observable();
        this.description = ko.observable();
    }
    
    home.Person = function(){
        this.id  = ko.observable();
    }

    home.viewmodel = (function () {
        //private
        var category = new home.Category()
            .id(1)
            .name("Justin")
            .description("Rassier");
        
        var person = new home.Person().id(20);
        
        //public
        return {
            category: category,
            person: person
        }
        
    })();
    //hookup knockout to our viewmodel
    ko.applyBindings(home.viewmodel);
});
