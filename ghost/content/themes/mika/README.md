# Develop your own custom ghost theme 
### The ghost system has out of box theme named Casper in default installation. it is a beautiful theme, and easily adapted  most purposes. Maybe you prefer characteristic theme for your professional publishing platform

, Don't hesitate, let's getting start your own now.

> Before beginning, I assume you are familiar to the technology of front side developing, such as HTML, CSS ,JS etc.

1. Setup developing environment 

   Because Ghost developed in NODE,so you must install node firstly , refer the official document  to check the supported node [versions](https://docs.ghost.org/docs/supported-node-versions) of Ghost.  

   check you node version like this:
   
   `
    node  -v 
   `
 
    make sure your installed version in official recommended versions.

    then you can install Ghost-CLI now.
    Ghost-CLI is a series tool, that can install, configure and make it easy to getting developing.

     `
     npm install -g ghost-cli
     `

    available commands of Ghost-CLI：

    - ghost config
    - ghost doctor
    - ghost help
    - ghost install
    - ghost log
    - ghost ls
    - ghost setup
    - ghost start
    - ghost stop
    - ghost restart
    - ghost run
    - ghost update
    - ghost uninstall

    To install ghost in local ,type the command below in an empty folder that will be your workspace for developing :

    > it is better to use an empty folder to install ghost, Ghost CLI will output lots of information about what it's doing

    `ghost install local`

    it will take a few minutes, after installation completed. you will see a few files in workspace created before. importantly, the folder of placing theme files is in /content/themes/.


2. create your own theme 

    create a folder named same with your theme name in /content/themes/. for example : my-theme

    then create some required files for a simplest theme:

    - index.hbs
    - post.hbs
    - package.json

you can create those files from default Casper as a base.

>Handlebars is the templating language used by Ghost. Handlebars provides the power necessary to let you build semantic templates effectively with no frustration.

As the meaning of file names, index page display articles as a list, and post page display a specific post. 

For Example ,you show the list of your articles in index page :

``` HTML
{{#foreach posts}}
<h2>{{title}}</h2>
<p>{{excerpt words="33"}}</p>
{{/foreach}}
```
Render a post in post page：

``` html
{{#post}}
 <h1 class="post-title">{{title}}</h1>
 <p>{{content}}</p>
{{/post}}  
```

So far, you have created a simplest Ghost template. let run it now,type below in workspace folder:

``` shell
ghost start --development
```

you can see the terminal output of ghost starting .
You can access your blog at http://localhost:2368/, you will notice you custom theme don't take effect. 

access ghost admin console at http://localhost:2368/ghost/, and switch theme in SETTINGS->Design->Themes, you will see your own theme list here , click ACTIVE anchor to active. then go to Home page, you will see you own theme be applied .

OK, refer to [the document](https://themes.ghost.org/docs/about) of blog to perfect it.










