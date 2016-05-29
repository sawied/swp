/**
 * This example make use of requireJS to provide a clean and simple way to split JavaScript class definitions
 * into separate files and avoid global namespace pollution.  http://requirejs.org/
 *
 * We start by defining the definition within the require block inside a function; this means that any
 * new variables / methods will not be added to the global namespace; requireJS simply requires us to return
 * a single value (function / Object) which represents this definition.  In our case, we will be returning
 * the Class' function.
 */
define(function () {
    // Forces the JavaScript engine into strict mode: http://tinyurl.com/2dondlh
    "use strict";

    /**
     * This is our classes constructor; unlike AS3 this is where we define our member properties (fields).
     * To differentiate constructor functions from regular functions, by convention we start the function
     * name with a capital letter.  This informs users that they must invoke the Person function using
     * the `new` keyword and treat it as a constructor (ie: it returns a new instance of the Class).
     */
    function Person(name) {
        // This first guard ensures that the callee has invoked our Class' constructor function
        // with the `new` keyword - failure to do this will result in the `this` keyword referring 
        // to the callee's scope (typically the window global) which will result in the following fields
        // (name and _age) leaking into the global namespace and not being set on this object.
        if (!(this instanceof Person)) {
            throw new TypeError("Person constructor cannot be called as a function.");
        }

        // Here we create a member property (field) for the Person's name; setting its value
        // what the one supplied to the Constructor.  Although we don't have to define
        // properties ahead of time (they can easily be added at runtime as all Object / functions 
        // in JavaScript are dynamic) I believe it makes your code easier to follow if you list your
        // classes intentions up front (eg: in the Constructor function).
        this.name = name;

        // Here we are defining a private member. As there is no `private` keyword in JavaScript
        // there is no way for us to hide this data (without resorting to inelegant hacks); instead
        // we choose to use a naming convention where a leading underscore indicates a property
        // is private and should not be relied upon as part of the Classes public API.
        this._age = -1;
    }

    /**
     * Adding static properties is as simple as adding them directly to the constructor
     * function directly.
     */
    Person.RETIREMENT_AGE = 60;

    /**
     * Public Static methods are defined in the same way; here's a static constructor for our Person class
     * which also sets the person's age.
     */
    Person.create = function (name, age) {
        var result = new Person(name);
        result.setAge(age);

        return result;
    };

    /**
     * Any functions not added to the Person reference won't be visible, or accessible outside of
     * this file (closure); however, these methods and functions don't belong to the Person class either
     * and are static as a result.
     */
    function formatNameAndAge(person) {
        // Note that `this` does not refer to the Person object from inside this method.
        if (person._age === -1) {
            return "We don't know how old " + person.name + " is!";
        }

        return (person.name + ", is " + person._age + " years old and "
        + ((person.canRetire()) ? "can" : "can't") + " retire");
    };

    /**
     * The prototype is a special type of Object which is used as a the blueprint for all instances
     * of a given Class; by defining functions and properties on the prototype we reduce memory
     * overhead.  We can also achieve inheritance by pointing one classes' prototype at another, for
     * example, if we introduced a BankManager class which extended our Person class, we could write:
     *
     *	`BankManager.prototype = Person.prototype`
     *	`BankManager.prototype.constructor = BankManager`
     *
     * However, due to the dynamic nature of JavaScript I am of the opinion that favouring composition
     * over inheritance will make your code easier to read and re-use.
     */
    Person.prototype = {

        /**
         * Whenever you replace an Object's Prototype, you need to repoint
         * the base Constructor back at the original constructor Function,
         * otherwise `instanceof` calls will fail.
         */
        constructor: Person,

        /**
         * All methods added to a Class' prototype are public (visible); they are able to
         * access the properties and methods of the Person class via the `this` keyword.  Note that
         * unlike ActionScript, usage of the `this` keyword is required, failure to use it will
         * result in the JavaScript engine trying to resolve the definition on the global object.
         */
        greet: function () {
            // Note we have to use the `this` keyword.
            return "Hello, " + this.name;
        },

        /**
         * Even tho the `_age` property is accessible; it still makes a lot of sense to provide
         * mutator methods (getters / setters) which make up the public API of a Class - here we
         * validate the supplied value; something you can't do when a field is modified directly
         */
        setAge: function (value) {
            // Ensure the supplied value is numeric.
            if (typeof (value) !== 'number') {
                throw new TypeError(typeof (value) + " is not a number.");
            }

            // Ensure the supplied value is valid.
            if (isNaN(value) || value < 0) {
                throw new RangeError("Supplied value is out of range.");
            }

            this._age = value;
        },

        /**
         * This method access both a member property and a static property.
         */
        canRetire: function() {
            return this._age >= Person.RETIREMENT_AGE;
        },

        /**
         * Finally we can also access 'static' functions and properties.
         */
        toString: function() {
            // Note that as `formatNameAndAge` is static we must supply a reference
            // to `this` so it can operate on this instance.
            return formatNameAndAge(this);
        }
    };

    // As mentioned up top, requireJS needs us to return a value - in this files case, we will return
    // a reference to the constructor function.
    return Person;
});
