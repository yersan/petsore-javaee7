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

        self.category = new Category();

        $.getJSON("rest/categories", function (allData) {
            var mappedTasks = $.map(allData, function (item) {
                return new Category()
                    .id(item.id)
                    .name(item.name)
                    .description(item.description)
            });
        });


        return {
            category: self.category,
        }
    })();

    ko.applyBindings(viewmodel);
});

