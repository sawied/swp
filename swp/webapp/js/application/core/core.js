define(["bootstrap",
        "domReady",
        "mustache",
        "core/model/users",
        "text!core/template/layout.html",
        "switcher/switcher",
        "core/Person"
    ],
    function ($, domReady, mustache, userService, template, switcher,Person) {

        domReady(function () {

            var $root = $("#doc-root");

            userService.load({"enable": true}).done(function (data) {
                    var dom = mustache.render(template, data);
                    $root.html(dom);
//			$("#user-dialog").modal({"show":true});
                }
            );



            console.log(Person.create("danan",30));

            var $sidePanel = $("#sidePanel");

            var swt = null;

            $root.on("click", "[data-event='userDetail']", function () {
                if (swt) {
                    swt.close();
                }
                swt = switcher.create($sidePanel,{});
            });


        });
    });