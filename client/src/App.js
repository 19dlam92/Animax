import logo from './logo.svg';
import './App.css';
import { 
  BrowerRouter,
  Link,
  Switch,
  Route,
} from 'react-router-dom'
import AllAnime from './components/AllAnime';


function App() {
  return (
    <div className="App container">
      <BrowerRouter>
        <AllAnime></AllAnime>
        <Switch>
          <Route exact path="">
            
          </Route>
          <Route exact path="">

          </Route>
          <Route exact path="">

          </Route>
        </Switch>
      </BrowerRouter>
    </div>
  );
}

export default App;
