function isPromise(value) {
    if (value !== null && typeof value === 'object') {
      return value && typeof value.then === 'function';
    }
  
    return false;
  }


export default function globalErrorMiddleware() {
    return store => next => action => {
  
      // If not a promise, continue on
      if (!isPromise(action.payload)) {
        return next(action);
      }
  
      /**
       * Because it iterates on an array for every async action, this
       * oneOfType function could be expensive to call in production.
       * Another solution would would be to include a property in `meta`
       * and evaulate that property.
       *
       * if (action.meta.globalError === true) {
       *   // handle error
       * }
       *
       * The error middleware serves to dispatch the initial pending promise to
       * the promise middleware, but adds a `catch`.
       */
      //if (action.meta.globalError===true) {
  
        // Dispatch initial pending promise, but catch any errors
        return next(action).catch(error => {
          
            window.console.warn(`${action.type} caught at middleware with reason: ${JSON.stringify(error.message)}.`);
            store.dispatch({type:'GLOBAL_ERROR',error});
        });
     // }
  
     // return next(action);
    };
  }