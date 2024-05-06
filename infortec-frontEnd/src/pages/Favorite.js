import NavBar from "../components/NavBar";
import { useEffect, useState } from "react";
import { BsHeart } from "react-icons/bs";
import favoriteService from "../services/FavoriteService"
import ItemFavorites from "../components/ItemFavorite";
import "../styles/Favorite.css"
const Favorite = ()=>{
    const [favorites, setFavorites] = useState([])
    async function getFavorites ()
    {
        const idClient =  localStorage.getItem("userId")
        const response  = await favoriteService.findAll(idClient);
        const data = await response.json();
        setFavorites(data);
    }

   useEffect(()=>{
        getFavorites()
   },[favorites])
    
    return (
        <div className="container-favorites">
             <NavBar/>
             <div className="container2-favorites">
                
                <div className="itens-favorites">
                    {favorites.map((item) => {
                            return(
                                <ItemFavorites id = {item.idFavorite} urlImage = {item.product.imgUrl} nameProduct = {item.product.name}
                                price = {item.product.price}
                                productBrand = {item.product.brand}
                                />
                            )                
                    })}
               </div>
             </div>
        </div>
    )
}

export default Favorite