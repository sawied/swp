define(["bootstrap",
        "mustache",
        "core/model/users",
        "core/Tip",
        "text!core/template/layout.html",
    "text!core/template/Shapes.html",
        "switcher/switcher",
        "core/Person",
        "core/Alert",
        "domReady!",
    ],
    function ($, mustache, userService, tip,template,shapesTemplate, switcher, Person,alt) {



            var $root = $("#doc-root");

            userService.load({"enable": true}).done(function (data) {
                    var dom = mustache.render(template, data);
                    $root.html(dom);
//			$("#user-dialog").modal({"show":true});

                $("[data-event='modelTest']").on("click",function () {
                    alt({title:"Hello world!",content:"model.test"}).done(function (expected) {
                        console.log("user's select ",expected);
                    });
                });

                    $root.find("#shapes").html(shapesTemplate);
                
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