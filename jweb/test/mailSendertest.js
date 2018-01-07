var nodemailer = require("nodemailer");
// create reusable transport method (opens pool of SMTP connections)
var smtpTransport = nodemailer.createTransport("SMTP",{
    host:"smtp.sawied.top",
    port:465,
    debug:true,
    auth: {
        user: "ghost@sawied.top",
        pass: "Dojo.2017"
    }
});

// setup e-mail data with unicode symbols
var mailOptions = {
    from: "ghost@sawied.top", // sender address
    to: "danan.2009@hotmail.com", // list of receivers
    subject: "Hello sawied", // Subject line
    text: "Hello sawied", // plaintext body
    html: "<b>Hello sawied</b>" // html body
}

// send mail with defined transport object
smtpTransport.sendMail(mailOptions, function(error, response){
    if(error){
        console.log(error);
    }else{
        console.log("Message sent: " + response.message);
    }

    // if you don't want to use this transport object anymore, uncomment following line
    //smtpTransport.close(); // shut down the connection pool, no more messages
});