 Bootstrap is a popular, open source framework. Complete with pre-built components it allows web designers of all skill levels to quickly build a site.

first of all, you need to install compass dependencies of ruby runtime.
**1.install ruby runtime**
>*I am test installation in ubuntu 16 LTS,if you are in china,you are better to use mirrors of [aliyun](http://mirrors.aliyun.com/).*
```
$ sudo apt-get update
$ apt-cache search ruby
$ sudo apt-get install ruby-dev
```
**2.verify installation of ruby runtime**
```
$ ruby -v
ruby 2.3.1p112 (2016-04-26) [x86_64-linux-gnu]
$ gem -v
2.5.1
```
OK ,by now all is ready to install **sass**,**compass** and **bootstrap**  
**3.change the gem sources**
```
$ gem sources --add https://gems.ruby-china.org/ --remove https://rubygems.org/
https://gems.ruby-china.org/ added to sources
https://rubygems.org/ removed from sources
$ gem sources -l
*** CURRENT SOURCES ***

https://gems.ruby-china.org/

```
***4.install compass and bootstrap***
```
$ sudo gem install compass
$ sudo gem install bootstrap-sass
$ gem list --local
sass (3.4.25)
compass (1.0.3)
compass-core (1.0.3)
compass-import-once (1.0.5)
autoprefixer-rails (7.2.5)
bootstrap-sass (3.3.7)
```
***5.create a project using compass***
```
$ compass create sweb -r bootstrap-sass --using bootstrap
```
Usage: compass help [command]

Primary Commands:
  * clean       - Remove generated files and the sass cache
  * compile     - Compile Sass stylesheets to CSS
  * create      - Create a new compass project
  * init        - Add compass to an existing project
  * watch       - Compile Sass stylesheets to CSS when they change

***6.custom bootstrap imports***
As usual ,we need to custom bootstrap components for using. you can create a file of bootstrap-custom.scss . then import you liked.for example:
```
@import "bootstrap/code";
@import "bootstrap/grid";
@import "bootstrap/tables";
@import "bootstrap/forms";
@import "bootstrap/buttons";
```
> some time ,you will encounter install error of node-sass, while downloading or installing. can try run following comands to fix the issue:

1.Error: ENOENT: no such file or directory, scandir '**/node_modules/node-sass/vendor'

solution: run 'npm rebuild node-sass ' or download binary file form [github node-sass](https://github.com/sass/node-sass/releases)
