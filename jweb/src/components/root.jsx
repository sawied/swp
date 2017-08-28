import {Provider} from 'react-redux';
import App from 'AppCore';
import Home from 'Home';
import FileManager from 'FileManager';
import Todos from 'todos';
import TodosReducers from './../reducers';
import {Router,Route,browserHistory,IndexRoute} from 'react-router';
import createDefaultStore from './../stores/defaultStore';

let store = createDefaultStore(TodosReducers);
export default class extends Component{
  render(){
    return (<Provider store={store}>
    <Router history={browserHistory}>
      <Route path='/' component={App}>
        <IndexRoute component={Home}/>
        <Route path="/todos" component={Todos}/>
        <Route path='/fileManager' component={FileManager}/>
      </Route>
    </Router>
    </Provider>);
  }
}
