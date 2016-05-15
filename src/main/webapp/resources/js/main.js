/**
 * Created by yeraysb on 9/5/16.
 */

Category = function () {
    this.id = ko.observable();
    this.name = ko.observable();
    this.description = ko.observable();
}

$(function () {

    var viewmodel = (function () {
        var self = this;

        self.categories = ko.observableArray([]);

        $.getJSON("rest/categories", function (allData) {
            var mappedTasks = $.map(allData, function (item) {
                return new Category()
                    .id(item.id)
                    .name(item.name)
                    .description(item.description)
            });

            self.categories(mappedTasks);
        });


        return {
            categories: self.categories,
        }
    })();

    ko.applyBindings(viewmodel);
});

