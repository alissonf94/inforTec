import Login from '../src/pages/Login'
import Resgiter from "../src/pages/Register"
import "./App.css"
import { RouterProvider, createBrowserRouter } from 'react-router-dom';

function App() {
  const defaultRouter = createBrowserRouter([
    {
      path: "/",
      element: <Login/>
    },
    {
      path: "/register",
      element: <Resgiter/>
    }
  ])

  return (
    <div className="App">
      <RouterProvider router = {defaultRouter}/>
    </div>
  );
}

export default App;
