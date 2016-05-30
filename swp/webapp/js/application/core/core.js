define(["bootstrap",
        "domReady",
        "mustache",
        "core/model/users",
        "core/Tip",
        "text!core/template/layout.html",
        "switcher/switcher",
        "core/Person"
    ],
    function ($, domReady, mustache, userService, tip,template, switcher, Person) {

        domReady(function () {

            var $root = $("#doc-root");

            userService.load({"enable": true}).done(function (data) {
                    var dom = mustache.render(template, data);
                    $root.html(dom);
//			$("#user-dialog").modal({"show":true});
                }
            );


            console.log(Person.create("danan", 30));

            var $sidePanel = $("#sidePanel");

            var swt = null;

            $root.on("click", "[data-event='userDetail']", function () {

                tip("user list opened.");
                return;

                if (swt) {
                    swt.close();
                }
                swt = switcher.create($sidePanel, "detail", {});
            });


        });
    });