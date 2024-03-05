import Login from '../src/pages/Login'
import Resgiter from "../src/pages/Register"
import Home from "../src/pages/Home"
import Computers from './pages/Computers'
import Accessories from './pages/Accessories'
import Monitors from './pages/Monitors'
import "./App.css"
import { RouterProvider, createBrowserRouter } from 'react-router-dom';
import Keyboard from './pages/Keyboard'
import ShoppingCart from "./pages/ShoppingCart"
function App() {
  const defaultRouter = createBrowserRouter([
    {
      path: "/",
      element: <Login/>
    },
    {
      path: "/register",
      element: <Resgiter/>
    },
    {
      path:"/home",
      element:<Home/>
    },
    {
      path:'/computers',
      element: <Computers/>
    },
    {
      path:'/accessories',
      element: <Accessories/>
    },
    {
      path: '/keyboards',
      element: <Keyboard/>
    },
    {
      path: "/monitors",
      element: <Monitors/>
    },
    {
      path: "/shoppingCart",
      element: <ShoppingCart/>
    }
  ])

  return (
    <div className="App">
      <RouterProvider router = {defaultRouter}/>
    </div>
  );
}

export default App;
