import Login from '../src/pages/Login'
import { RouterProvider, createBrowserRouter } from 'react-router-dom';

function App() {
  const defaultRouter = createBrowserRouter([
    {
      path: "/",
      element: <Login/>
    }
  ])

  return (
    <div className="App">
      <RouterProvider router = {defaultRouter}/>
    </div>
  );
}

export default App;
